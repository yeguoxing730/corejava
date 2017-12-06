package com.ftp.other;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 5/11/16
 * Time: 2:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class FTPDeleteFileDemo {
    public static void main(String[] args) {
        String server = "10.35.63.22";
        int port = 21;
        String user = "anonymous";
        String pass = "";

        FTPClient ftpClient = new FTPClient();
        try {

            ftpClient.connect(server, port);

            int replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.out.println("Connect failed");
                return;
            }

            boolean success = ftpClient.login(user, pass);

            if (!success) {
                System.out.println("Could not login to the server");
                return;
            }
            String fileToDelete = "/worldcheckuser/wcdata/daily/20160511/AM/world-check-day.csv.gz.md5";

            boolean deleted = ftpClient.deleteFile(fileToDelete);
            if (deleted) {
                System.out.println("The file was deleted successfully.");
            } else {
                System.out.println("Could not delete the  file, it may not exist.");
            }

        } catch (IOException ex) {
            System.out.println("Oh no, there was an error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            // logs out and disconnects from server
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
