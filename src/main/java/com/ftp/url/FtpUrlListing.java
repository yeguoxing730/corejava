package com.ftp.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 5/11/16
 * Time: 2:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class FtpUrlListing {
    public static void main(String[] args) {
        String ftpUrl = "ftp://%s:%s@%s/%s;type=d";
        String host = "192.165.219.225";
        String user = "r436943";
        String pass = "Reuters10g";
        String dirPath = "/worldcheckuser/wcdata/";

        ftpUrl = String.format(ftpUrl, user, pass, host, dirPath);
        System.out.println("URL: " + ftpUrl);

        try {
            URL url = new URL(ftpUrl);
            URLConnection conn = url.openConnection();
            InputStream inputStream = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line = null;
            System.out.println("--- START ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("--- END ---");

            inputStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
