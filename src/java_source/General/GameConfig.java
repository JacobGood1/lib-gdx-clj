package General;

import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

/**
 * Created by jacob on 5/22/2014.
 */
public class GameConfig extends LwjglApplicationConfiguration {
    public GameConfig() {
        title = "Game";
        useGL30 = true;
        width = 480;
        height = 320;
    }
}
