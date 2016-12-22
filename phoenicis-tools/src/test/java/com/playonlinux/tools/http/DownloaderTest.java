package com.playonlinux.tools.http;

import org.apache.commons.io.IOUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.Header;

import java.io.File;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class DownloaderTest {
    private static URL mockServerURL;
    private static URL mockServerURLFile2;

    private static ClientAndServer mockServer;
    private static int MOCKSERVER_PORT = 3343;

    @BeforeClass
    public static void setUp() throws MalformedURLException {
        mockServer = new ClientAndServer(MOCKSERVER_PORT);
        mockServerURL = new URL("http://localhost:" + MOCKSERVER_PORT + "/test.txt");
        mockServerURLFile2 = new URL("http://localhost:" + MOCKSERVER_PORT + "/test2.txt");
    }

    @AfterClass
    public static void tearDown() {
        mockServer.stop();
    }

    @Test
    public void testGet_DownloadFile_FileIsDownloaded() throws Exception {
        mockServer.when(
                request()
                        .withMethod("GET")
                        .withPath("/test.txt")
        ).respond(
                response()
                        .withStatusCode(200)
                        .withHeaders(
                                new Header("Content-Type", "application/config")
                        )
                        .withBody("Content file to download")
        );

        File temporaryFile = File.createTempFile("test", "txt");
        temporaryFile.deleteOnExit();
        new Downloader().get(mockServerURL, temporaryFile, e -> {});

        String fileContent = IOUtils.toString(new FileReader(temporaryFile));

        assertEquals("Content file to download", fileContent);
    }

    @Test
    public void testGet_DownloadFileInAString_FileIsDownloaded() throws Exception {
        mockServer.when(
                request()
                        .withMethod("GET")
                        .withPath("/test2.txt")
        ).respond(
                response()
                        .withStatusCode(200)
                        .withHeaders(
                                new Header("Content-Type", "application/config")
                        )
                        .withBody("Content file to download 2")
        );

        String result = new Downloader().get(mockServerURLFile2, e -> {});

        assertEquals("Content file to download 2", result);
    }
}