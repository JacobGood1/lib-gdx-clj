package General;

import clojure.lang.AFunction;
import clojure.lang.Atom;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by jacob on 5/22/2014.
 */
public class Zomboid implements ApplicationListener {
    public static OrthographicCamera camera = new OrthographicCamera();
    public static OrthographicCamera hudCamera;
    public static SpriteBatch spriteBatch;
    final float STEP = 1 / 60f;
    float accumulator;
    private Texture texture;
    private Sprite sprite;
    static AFunction currentUpdate;
    static AFunction currentRender;
    //static World world;
    static Atom world = new Atom(new World(new Vector2(0, -9.81f), true));
    static Box2DDebugRenderer box2DDebugRenderer;
    static boolean isShowBox2dDebug = true;
    public static float WIDTH;
    public static float HEIGHT;
    public static float PPM = 100;
    public static OrthographicCamera box2DCamera;

    public Zomboid(AFunction currentUpdate, AFunction currentRender) {
        Zomboid.currentUpdate = currentUpdate;
        Zomboid.currentRender = currentRender;
    }

    public static void reload(AFunction currentUpdate, AFunction currentRender) {
        Zomboid.currentUpdate = currentUpdate;
        Zomboid.currentRender = currentRender;
    }
    @Override
    public void create() {
        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, WIDTH, HEIGHT);
        spriteBatch = new SpriteBatch();
        box2DDebugRenderer = new Box2DDebugRenderer();
        box2DCamera = new OrthographicCamera();
        box2DCamera.setToOrtho(false, WIDTH / PPM, HEIGHT / PPM);
        box2DCamera.update();
    }

    @Override
    public void resize(int i, int i2) {

    }

    @Override
    public void render() {
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        World tempWorld = (World)world.deref();
        if(isShowBox2dDebug) box2DDebugRenderer.render(tempWorld, box2DCamera.combined);
        accumulator = Gdx.graphics.getDeltaTime();
        while(accumulator >= STEP){
            accumulator -= STEP;
            tempWorld.step(STEP, 6,2);
            currentUpdate.invoke(STEP);
            currentRender.invoke();
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

    public static void setIsShowBox2dDebug(boolean b){
        isShowBox2dDebug = b;
    }
    public static World getWorld(){
        return (World) world.deref();
    }
    public AFunction getCurrentUpdate() {
        return currentUpdate;
    }

    public void setCurrentUpdate(AFunction currentUpdate) {
        this.currentUpdate = currentUpdate;
    }

    public AFunction getCurrentRender() {
        return currentRender;
    }

    public void setCurrentRender(AFunction currentRender) {
        this.currentRender = currentRender;
    }

    public static float getPPM() {
        return PPM;
    }

    public static void setPPM(float PPM) {
        Zomboid.PPM = PPM;
    }
}
