package me.yes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * Created by yes on 29/12/15.
 */
public class HttpServer1 {
    private boolean shutdown = false;

    public static void main(String[] args) {
        HttpServer1 httpServer1 = new HttpServer1();
        httpServer1.await();
    }

    public void await() {
        ServerSocket serverSocket = null;
        int port = 8080;
        try {
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        while (!shutdown) {
            Socket socket = null;
            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                socket = serverSocket.accept();
                inputStream = socket.getInputStream();
                outputStream = socket.getOutputStream();
                //create Request object and parse
//                Request request = new Request(inputStream);
//                request.parse();
//
//                //create Response object
//                Response response = new Response(outputStream);
//                response.setRequest(request);
//                //check if this is a request for a servlet or a static resource
//                //a request for a servlet begins with "/servlet/"
//                if (request.getUri().startsWith("/servlet/")) {
//                    ServletProcessor1 processor1 = new ServletProcessor1();
//                    processor1.process(request, response);
//                } else {
//                    StaticResourceProcessor processor = new StaticResourceProcessor();
//                    processor.processor();
//                }
//                socket.close();
//                shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }
}
