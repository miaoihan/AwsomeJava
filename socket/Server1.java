package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 单线程接受一个客户端
 */
public class Server1 {
    public static void main(String[] args) throws IOException {
        /** 得到连接服务器的socket */
        ServerSocket server = new ServerSocket(5678);
        /**  阻塞线程，直到接收到客户端   */
        Socket client = server.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream());
        BufferedReader wt = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = in.readLine();
            System.out.println("client:"+str);
            out.println("server:has received....");
            out.flush();
            String pack = wt.readLine();
//            out.println(pack);
//            out.flush();
            if (str.equals("end"))
                break;
        }
        client.close();
    }
}