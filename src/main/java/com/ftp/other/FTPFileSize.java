package com.ftp.other;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 5/11/16
 * Time: 2:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class FTPFileSize {
    public static void main(String[] args) {
        String server = "10.35.63.22";
        int port = 21;
        String user = "anonymous";
        String pass = "";

        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);

            String filePath = "/worldcheckuser/wcdata/daily/20160511/AM/world-check-day.csv.gz";

            FTPFile file = ftpClient.mlistFile(filePath);
            long size = file.getSize();
            System.out.println("File size = " + size);

            ftpClient.sendCommand("SIZE", filePath);
            String reply = ftpClient.getReplyString();
            System.out.println("Reply for size command: " + reply);

            ftpClient.logout();
            ftpClient.disconnect();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.logout();
                    ftpClient.disconnect();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
