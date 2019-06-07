package BookAbouNetworkJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class Main {
    public static void main(String[] args) throws IOException {
        TestInetAddress obj = new TestInetAddress();
//        try {
//            URLConnection urlConn = obj.getURLConnection("https://www.youtube.com/watch?v=2_zxp5TkyuY");
//            System.out.println(urlConn.getContentType());
//            System.out.println("======InputStream=======");
//            InputStream inStr = urlConn.getInputStream(); //просто чтение байтов - не эффективно, лучше в обертку
//            BufferedReader reader = new BufferedReader(new InputStreamReader(inStr));
//            int c;
//            while ((c = reader.read()) != -1) {
//                System.out.print((char) c);
//            }
//            inStr.close();
//
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }

        /**
         * В данном случае нам нужна "подмена интересов", чтобы мы могли перехватывать запросы на другие сайты.
         */
        InetAddress inetAddress = obj.getLocalAddress();
        ServerSocket serverSocket = new ServerSocket(443, 80, inetAddress);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println(socket.getInetAddress());
        }

    }
}
