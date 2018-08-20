package com.liumapp.jks.core.loader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * author liumapp
 * file Resource.java
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 6/28/18
 */
public class Resource {

    public static final String CLASSPATH_PREFIX = "classpath:";

    private String ref;

    private Resource(String ref) {
        this.ref = ref;
    }

    public static Resource from(String ref) {
        return new Resource(ref);
    }

    public InputStream getInputStream() throws FileNotFoundException {
        if (ref.startsWith(CLASSPATH_PREFIX)) {
            String classPathResource = ref.replace("classpath:", "");
            return this.getClass().getClassLoader().getResourceAsStream(classPathResource);
        } else {
            return new FileInputStream(ref);
        }
    }

}
