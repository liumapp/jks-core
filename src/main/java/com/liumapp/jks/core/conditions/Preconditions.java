package com.liumapp.jks.core.conditions;

/**
 * author liumapp
 * file Preconditions.java
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 6/28/18
 */
public class Preconditions {

    private Preconditions() {
        // prevent instance
    }

    public static void checkState(boolean expression, String message) {
        if (!expression) {
            throw new IllegalStateException(message);
        }
    }

    public static void checkArgument(boolean expression, String message) {
        if (!expression) {
            throw new IllegalArgumentException(message);
        }
    }

}
