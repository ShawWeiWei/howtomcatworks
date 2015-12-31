package me.yes;

import java.io.OutputStream;

/**
 * Created by yes on 29/12/15.
 */
public class Response {
    private OutputStream outputStream;
    private Request request;
    public Response(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
