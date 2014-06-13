package General;

import clojure.lang.AFunction;
import clojure.lang.Atom;
import clojure.lang.Keyword;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

/**
 * Created by jacob on 6/1/2014.
 */
public class Box2DUtil
{
    static Atom bdef = new Atom(new BodyDef());
    static AFunction createBody;
    static AFunction createBox;


    public Box2DUtil(AFunction createBody, AFunction createBox){
        Box2DUtil.createBody = createBody;
        Box2DUtil.createBox = createBox;

    }
    public static Body makeBody(float x, float y, BodyDef.BodyType bodyType){
        BodyDef tempBodyDef = (BodyDef)bdef.deref();
        tempBodyDef.position.set(x / Zomboid.PPM, y / Zomboid.PPM);
        tempBodyDef.type = bodyType;
        return Zomboid.getWorld().createBody(tempBodyDef);
    }
    public static void makeBox(Body body, int dimx, int dimy){
        FixtureDef fix = new FixtureDef();
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(dimx / Zomboid.PPM, dimy / Zomboid.PPM);
        fix.shape = shape;
        body.createFixture(fix);
    }

    public static void makeALotOfBoxes(int x, int y, Keyword type, int dimx, int dimy){
        int tons = 1000;
        for (int i = 0; i < tons; i++) {
            createBox.invoke(x + i, y + i, type, dimx, dimy);
        }
    }
}
