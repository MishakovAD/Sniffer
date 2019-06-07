package BookAbouNetworkJava;

import BookAbouNetworkJava.Utils.FormaterUtils;
import Server.Server;

import java.io.IOException;
import java.net.*;

public class TestInetAddress {
    private InetAddress inetAddress;
    private InetAddress localAddress;
    private URL url;
    private ServerSocket serverSocket;

    public URL getURL (String hostName) throws MalformedURLException {
        url = new URL(hostName);
        return url;
    }

    public URLConnection getURLConnection (String hostName) throws IOException {
        if (hostName.contains("http")) {
            return getURL(hostName).openConnection();
        } else {
            StringBuilder str = new StringBuilder(hostName);
            StringBuilder http = new StringBuilder("https://");
            hostName = (http.append(str)).toString();
            return getURL(hostName).openConnection();
        }

    }

    public InetAddress getInetAddress (String hostName) throws UnknownHostException {
        if (FormaterUtils.isIP(hostName)) {
            inetAddress = InetAddress.getByName(hostName); //убрать и заменить на IP
            return inetAddress;
            //return inetAddress = InetAddress.getByAddress();
        } else {
            inetAddress = InetAddress.getByName(hostName);
            return inetAddress;
        }
    }

    public InetAddress getLocalAddress () throws UnknownHostException {
        localAddress = InetAddress.getLocalHost();
        return localAddress;
    }

    public ServerSocket getServerSocketWhithAddr (int port, int maxQueue, InetAddress addr) throws IOException {
        serverSocket = new ServerSocket(port, maxQueue, addr);
        return serverSocket;
    }

    public ServerSocket getServerSocket (int port) throws IOException {
        serverSocket = new ServerSocket(port);
        return serverSocket;
    }

}
