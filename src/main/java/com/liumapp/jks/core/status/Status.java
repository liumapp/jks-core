package com.liumapp.jks.core.status;

/**
 * @author liumapp
 * @file Status.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 2018/8/6
 */
public enum Status {

    SUCCESS("10001"), ERROR_CODE("10000");

    private String value;

    public String getValue () {
        return this.value;
    }

    private Status(String value) {
        this.value = value;
    }


}
