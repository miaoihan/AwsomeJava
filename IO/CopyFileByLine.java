package IO;

import java.io.*;

/**
 * 插入处理流，按行处理
 * Created by han on 16-4-19.
 */
public class CopyFileByLine {
    public static void main(String[] args) {
        try {
            FileReader input = new FileReader("/home/han/IdeaProjects/demo01/src/IO/FileCopyByChar.java");
            /**  将节点流插到处理流上   */
            BufferedReader br = new BufferedReader(input);
            FileWriter output = new FileWriter("tmp.txt");
            BufferedWriter bw = new BufferedWriter(output);

            String st = br.readLine();
            while (null != st){
                bw.write(st);
                bw.newLine();
                System.out.println(st);
                st = br.readLine();
            }
            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
