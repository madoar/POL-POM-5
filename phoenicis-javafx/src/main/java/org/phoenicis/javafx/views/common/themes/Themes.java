package org.phoenicis.javafx.views.common.themes;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by marc on 23.05.17.
 */
public class Themes {
    public static final Theme DEFAULT = new ClasspathTheme("Default theme", "default",
            "/org/phoenicis/javafx/themes/default/");
    public static final Theme DARK = new ClasspathTheme("Dark theme", "dark", "/org/phoenicis/javafx/themes/dark/");
    public static final Theme BREEZE_DARK = new ClasspathTheme("Breeze Dark theme", "breezeDark",
            "/org/phoenicis/javafx/themes/breezeDark/");
    public static final Theme UNITY = new ClasspathTheme("Unity theme", "unity", "/org/phoenicis/javafx/themes/unity/");

    public static Theme[] all() {
        return new Theme[] { DEFAULT, DARK, BREEZE_DARK, UNITY };
    }

    public static Optional<Theme> fromShortName(String shortName) {
        return Arrays.stream(all()).filter(theme -> theme.getShortName().equals(shortName)).findAny();
    }
}