package me.yes.connector.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/**
 * Created by yes on 31/12/15.
 */
public class HttpRequest {
    private String contentType;
    private int contentLength;
    private InetAddress inetAddress;
    private InputStream inputStream;
    private String method;
    private String protocol;
    private String queryString;
    private String requestURI;
    private String serverName;
    private int serverPort;
    private Socket socket;
    private boolean requestedSessionCookie;
    private String requestedSessionId;
    private boolean requestedSessionURL;

    /**
     * The request attributes for this request
     */
    protected HashMap attributes = new HashMap();
    /**
     * The authorization credentials sent with this Request
     */
    protected String authorization = null;
    /**
     * The context path for this request
     */
    protected String contextPath = "";
    /**
     * The set of cookies associated with this request
     */
    protected ArrayList cookies = new ArrayList();
    /**
     * An empty collection to use for returning empty Enumerations. Do no
     * add any elements to this collection!
     */
    protected static ArrayList empty = new ArrayList();
    /**
     * The set of SimpleDateFormat formats to use in getDateHeader()
     */
    protected SimpleDateFormat formats[] = {
            new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.CHINA),
            new SimpleDateFormat("EEEEEE, dd-MMM-yyyy HH:mm:ss zzz", Locale.CHINA),
            new SimpleDateFormat("EEE MMMM d HH:mm:ss yyyy", Locale.CHINA)
    };
    /**
     * The HTTP headers associated with this Request, keyed by name. The values are ArrayLists of the
     * corresponding header values.
     */
    protected HashMap headers = new HashMap();
    /**
     * The parsed parameters for this request. This is populated only if parameter
     * information is requested via one of the <code>getParameter</code> family of method calls.
     * The key is the parameter name, while the value is a String array of values for this parameter.
     * <p>
     * <strong>IMPLEMENTATION NOTE</strong>
     * -Once the parameters for a particular request are parsed and stored here, tehy are not modified.
     * Therefore, application level access to the parameters need not be synchronized.
     * </p>
     */
    protected HashMap<String, String[]> parameters = null;
    /**
     * Have the parameters for this request been parsed yet?
     */
    protected boolean parsed = false;
    protected String pathInfo = null;

    /**
     * The reader that has been returned by <code>getReader</code>, if any.
     */
    protected BufferedReader reader = null;

    /**
     * The ServletInputStream that has been returned by <code>getInputStream</code>, if any.
     */
    protected ServletInputStream stream = null;

    public HttpRequest(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void addHeader(String name, String value) {
        name = name.toLowerCase();
        synchronized (headers) {
            ArrayList values = (ArrayList) headers.get(name);
            if (values == null) {
                values = new ArrayList();
                headers.put(name, values);
            }
            values.add(value);
        }
    }


}
