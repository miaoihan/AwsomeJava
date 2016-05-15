package Media.music;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * time: 16-5-15.
 * author: han
 */
public class Music {
    static String fileName = "../music/bg.";

    public void playMusic(){
        InputStream in = null;
        AudioStream as = null;
        try {
            in = new FileInputStream(fileName);
            as = new AudioStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AudioPlayer.player.start(as);
    }
}
