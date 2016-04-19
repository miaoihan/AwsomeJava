package IO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 将每个字符读入，并写入另一个文件，打印出来
 * Created by han on 16-4-19.
 */
public class FileCopyByChar {
    public static void main(String[] args) {
        try {
            FileReader input = new FileReader("/home/han/IdeaProjects/demo01/src/IO/FileCopyByChar.java");
            FileWriter output = new FileWriter("/home/han/IdeaProjects/demo01/src/IO/tmp.txt");
            int c = input.read();
            while(c != -1){
                output.write(c);
                System.out.print((char)c);
                c = input.read();
            }
            input.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
