package me.yes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by yes on 29/12/15.
 */
public class Response {
    private static final int BUFFER_SIZE = 1024;

    private OutputStream outputStream = null;

    private Request request = null;

    public Response(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void sendStaticResource() throws IOException {
        byte[] bytes = new byte[BUFFER_SIZE];
        FileInputStream fileInputStream = null;
        try {
            File file = new File(HttpServer.WEB_ROOT, request.getUri());
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                int ch = fileInputStream.read(bytes, 0, BUFFER_SIZE);
                while (ch != -1) {
                    outputStream.write(bytes, 0, ch);
                    ch = fileInputStream.read(bytes, 0, BUFFER_SIZE);
                }
            } else {
                String errorMessage = "HTTP/1.1 404 File Not Found\n" + "Content-Type:text/html\n";
                outputStream.write(errorMessage.getBytes());
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        } finally{
            if(fileInputStream!=null){
                fileInputStream.close();
            }
        }
    }
}
