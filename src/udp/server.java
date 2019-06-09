package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/*
 * 服务段
 *idea需要开启另一个idea
 * */
public class server {
    public static void main(String args[]) throws Exception {
        //创建服务端
        DatagramSocket server = new DatagramSocket(8888);
        //接受容器
        byte[] contain = new byte[1024];
        //封装成包
        DatagramPacket packet = new DatagramPacket(contain, contain.length);
        server.receive(packet);
        //分析数据
        byte[] data = packet.getData();
        int len = packet.getLength();
        System.out.println(new String(data, 0, len));
        server.close();
    }
}
