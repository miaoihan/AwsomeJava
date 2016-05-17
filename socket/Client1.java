package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client1 {

    public static void main(String[] args) throws Exception {
        //得到服务器socket
        Socket server = new Socket(InetAddress.getLocalHost(), 5678);
        //从服务器接受的数据
        BufferedReader in = new BufferedReader(new InputStreamReader(
                server.getInputStream()));
        PrintWriter out = new PrintWriter(server.getOutputStream());
        //控制台的数据
        BufferedReader wt = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            //读取控制台数据
            String str = wt.readLine();
            //发送给服务器
            out.println(str);
            out.flush();
            if (str.equals("end")) {
                break;
            }
            //打印从服务器收到的消息
            System.out.println(in.readLine());
        }
        server.close();
    }
}