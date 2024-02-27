package org.cloudapp.backend.utils;

public final class Utils {

    public static String getFileName(String originalFileName) {
        return originalFileName.split("\\.(?=[^\\.]+$)")[0];
    }

    public static String getFileExtension(String originalFileName) {
        return originalFileName.split("\\.(?=[^\\.]+$)")[1];
    }
}