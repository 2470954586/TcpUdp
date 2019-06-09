package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Tserver {
    public static void main(String args[]) throws Exception {
        //创建服务器
        ServerSocket serverSocket = new ServerSocket(8888);
        //接受客户端请求
        Socket socket = serverSocket.accept();
        System.out.println(socket.getInetAddress().getHostAddress() + "连接了");
        //io获取输入输出流
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
       // PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        String line = null;
        //读取客户端
        while ((line = br.readLine()) != null) {
            if (line.equals("over")) {
                break;
            }
            System.out.println(line);
            bw.write(line.toUpperCase());
            bw.newLine();
            bw.flush();
           // pw.print(line);
        }
       // pw.close();
        bw.close();
        br.close();
        socket.close();
        System.out.println(socket.getInetAddress().getHostAddress() + "断开");
    }
}
