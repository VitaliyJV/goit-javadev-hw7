package HTTP;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class HttpStatusImageDownloader {

    public void downloadStatusImage(int code) {
        try {
        URL url = new URL(new HttpStatusChecker().getStatusImage(code));
        if (url.equals("")) {
        throw new RuntimeException("Link is incorrect!");}
        else {
        InputStream in = new BufferedInputStream(url.openStream());
        FileOutputStream out = new FileOutputStream("img" + code + ".jpg");
        byte[] buf = new byte[4096];
        int bytesRead;
        while ((bytesRead = in.read(buf)) != -1) {
            out.write(buf, 0, bytesRead);
        }
        out.close();
        in.close();
        }
    }
catch (IOException ex) {
        System.err.println("Image with status code " + code + " not found!");
        }
    }
}

