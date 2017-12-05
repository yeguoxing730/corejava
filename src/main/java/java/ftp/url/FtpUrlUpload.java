package java.ftp.url;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 5/11/16
 * Time: 3:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class FtpUrlUpload {
    private static final int BUFFER_SIZE = 4096;

    public static void main(String[] args) {
        String ftpUrl = "ftp://%s:%s@%s/%s;type=i";
        String host = "192.165.219.225";
        String user = "r436943";
        String pass = "Reuters10g";
        String filePath = "C:\\IDEA\\ideaWorkspaces\\java\\ftp\\lib\\commons-net-3.1.jar";
        String uploadPath = "/worldcheckuser/wcdata/";


        ftpUrl = String.format(ftpUrl, user, pass, host, uploadPath);
        System.out.println("Upload URL: " + ftpUrl);

        try {
            URL url = new URL(ftpUrl);
            URLConnection conn = url.openConnection();
            OutputStream outputStream = conn.getOutputStream();
            FileInputStream inputStream = new FileInputStream(filePath);

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            inputStream.close();
            outputStream.close();

            System.out.println("File uploaded");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
