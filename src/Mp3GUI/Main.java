
package Mp3GUI;
import java.io.File;
import java.io.IOException;
import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;

public class Main {
    static Player audioPlayer = null;
    public static void main(String[] args) {
        try {
            Manager.createRealizedPlayer(new File("G:\\songs\\Maroon 5 - Animals.mp3").toURL()).start();
        } catch (IOException | NoPlayerException | CannotRealizeException ex) {}
    }
}
