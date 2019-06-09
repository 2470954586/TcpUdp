package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;


public class MyClient {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        DatagramSocket client = new DatagramSocket(6666);
//        String msg = "123456";
//        byte[] data = msg.getBytes();
        String msg = "123456";
        byte[] data = msg.getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, new InetSocketAddress("localhost", 8888));
        client.send(packet);
        client.close();

    }

}
