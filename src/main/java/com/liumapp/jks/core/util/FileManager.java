package com.liumapp.jks.core.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author liumapp
 * @file FileManager.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/17/18
 */
public class FileManager {

    public void copyFile(File fromFile, File toFile) throws IOException {
        FileInputStream ins = new FileInputStream(fromFile);
        FileOutputStream out = new FileOutputStream(toFile);
        byte[] b = new byte[1024];
        int n= 0;
        while ( (n = ins.read(b) ) != -1) {
            out.write(b, 0, n);
        }

        ins.close();
        out.close();
    }

}
