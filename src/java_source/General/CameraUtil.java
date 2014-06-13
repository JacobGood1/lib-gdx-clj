package General;

import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Created by jacob on 6/2/2014.
 */
public class CameraUtil
{
    public static OrthographicCamera getBox2DCam(){
        return Zomboid.box2DCamera;
    }
    public static void setToOrtho(OrthographicCamera cam, boolean yDown, float viewportWidth, float viewportHeight){
        cam.setToOrtho(yDown, viewportWidth, viewportHeight);
    }
}
