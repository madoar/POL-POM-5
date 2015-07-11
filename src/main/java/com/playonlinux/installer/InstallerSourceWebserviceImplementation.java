/*
 * Copyright (C) 2015 PÂRIS Quentin
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package com.playonlinux.installer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.playonlinux.dto.web.CategoryDTO;
import com.playonlinux.webservice.Webservice;
import java.net.URL;
import java.util.List;


/**
 * This class download scripts from a playonlinux web service and converts it into DTOs
 */
public class InstallerSourceWebserviceImplementation extends Webservice<CategoryDTO> implements InstallerSource {

    public InstallerSourceWebserviceImplementation(URL url) {
        super(url);
    }

    @Override
    protected TypeReference defineTypeReference() {
        return new TypeReference<List<CategoryDTO>>() {};
    }
}