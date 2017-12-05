package java.ftp.directory;

import org.apache.commons.net.ftp.FTPClient;

import java.ftp.util.FTPUtil;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 4/29/16
 * Time: 5:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class FTPMakeNestedDirectoryTest {
    public static void main(String[] args) {
        String server = "10.35.63.22";
        int port = 21;
        String user = "anonymous";
        String pass = "";
        FTPClient ftpClient = new FTPClient();

        try {
            // connect and login to the server
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);

            // use local passive mode to pass firewall
            ftpClient.enterLocalPassiveMode();

            System.out.println("Connected");

            String dirPath = "guoxing/java/ftp/demo/connect";

            FTPUtil.makeDirectories(ftpClient, dirPath);

            // log out and disconnect from the server
            ftpClient.logout();
            ftpClient.disconnect();

            System.out.println("Disconnected");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
