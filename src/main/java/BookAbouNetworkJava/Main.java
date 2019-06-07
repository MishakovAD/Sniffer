package BookAbouNetworkJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class Main {
    public static void main(String[] args) throws IOException {
        TestInetAddress obj = new TestInetAddress();
        try {
            URLConnection urlConn = obj.getURLConnection("https://rutube.ru/video/03a384eb201b7d3a323a94ab49a55f5a/?pl_type=source&pl_id=18265");
            System.out.println(urlConn.getContentType());
            System.out.println("======InputStream=======");
            InputStream inStr = urlConn.getInputStream(); //просто чтение байтов - не эффективно, лучше в обертку
            BufferedReader reader = new BufferedReader(new InputStreamReader(inStr));
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
            inStr.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        /**
         * В данном случае нам нужна "подмена интересов", чтобы мы могли перехватывать запросы на другие сайты.
         * Без прокси-сервера это сделать невозможно. Клиенту нужно явно указать, чтобы он отправлял запросы через мой сервер.
         *
         *         InetAddress inetAddress = obj.getLocalAddress();
         *         ServerSocket serverSocket1 = new ServerSocket(443, 80, inetAddress);
         *   Эквивалентно (кроме максимального числа подключений)
         *         ServerSocket serverSocket = new ServerSocket(443);
         *
         * Прокси-сервер??
         * https://ru.stackoverflow.com/questions/990367/serversocket-java-%D0%A3%D1%81%D1%82%D0%B0%D0%BD%D0%BE%D0%B2%D0%BA%D0%B0-%D0%BB%D1%8E%D0%B1%D0%BE%D0%B3%D0%BE-%D0%B0%D0%B4%D1%80%D0%B5%D1%81%D0%B0
         *
         * Использовать свое приложение, которое будет передавать ссылку с видео серверу, а тот, в свое время, уже отправлять это по адресу и читать входящий поток данных.
         * Осталось расшифровать поток данных, который приходит. А лучше, для начала, проигрывать его онлайн в своем приложении, а затем уже и скачивать.
         */
        InetAddress inetAddress = obj.getLocalAddress();
        ServerSocket serverSocket = new ServerSocket(443, 80, inetAddress);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println(socket.getInetAddress());
        }

    }
}
