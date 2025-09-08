package com.iep.commons.app.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BaseUtils {

    public static URI getUri(String endpoint){
        return URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path(endpoint).toUriString());
    }

}
