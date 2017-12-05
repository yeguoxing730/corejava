package java.ftp.other;

import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 5/11/16
 * Time: 2:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class FTPRenamer {
    public static void main(String[] args) {
        String server = "10.35.63.22";
        int port = 21;
        String user = "anonymous";
        String pass = "";

        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);

            // renaming directory
            String oldDir = "/worldcheckuser/wcdata/daily/20160511/AM";
            String newDir = "/worldcheckuser/wcdata/daily/20160511/PM";

            boolean success = ftpClient.rename(oldDir, newDir);
            if (success) {
                System.out.println(oldDir + " was successfully renamed to: "
                        + newDir);
            } else {
                System.out.println("Failed to rename: " + oldDir);
            }

            // renaming file
            String oldFile = "/worldcheckuser/appicon_16.png";
            String newFile = "/worldcheckuser/rename.png";

            success = ftpClient.rename(oldFile, newFile);
            if (success) {
                System.out.println(oldFile + " was successfully renamed to: "
                        + newFile);
            } else {
                System.out.println("Failed to rename: " + oldFile);
            }

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
