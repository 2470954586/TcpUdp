package tcp;

import java.io.*;
import java.net.Socket;

public class Tclient {
    public static void main(String args[]) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //PrintWriter pw = new PrintWriter(socket.getOutputStream());
        while (true) {
            String line = br.readLine();
            //pw.print(line);
            bw.write(line);
            bw.newLine();
            bw.flush();
            if (line.equals("over")) {
                break;
            }
            //读取服务端
            System.out.println(reader.readLine());
            //pw.println(line);
        }
        reader.close();
        br.close();
        bw.close();
        socket.close();
    }
}
