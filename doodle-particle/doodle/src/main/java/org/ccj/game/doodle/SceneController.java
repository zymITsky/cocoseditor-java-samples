package org.ccj.game.doodle;

import org.ccj.Director;
import org.ccj.Event;
import org.ccj.Touch;
import org.ccj.base.Ref;
import org.ccj.d2.Label;
import org.ccj.d2.Sprite;
import org.ccj.d2.action.MoveTo;
import org.ccj.d2.action.ScaleTo;
import org.ccj.d2.action.Sequence;
import org.ccj.editor.cce.Action;
import org.ccj.editor.cce.Bind;
import org.ccj.editor.cce.NodeController;
import org.ccj.math.Vec2;
import org.ccj.particle.ParticleSystemQuad;

/**
 */
public class SceneController extends NodeController {

    @Bind()
    public Label scoreLabel;
    @Bind()
    public Sprite monsterSprite;

    public float totalScore = 0;

    public void createParticle(String name, Vec2 vec2) {
        ParticleSystemQuad particle = ParticleSystemQuad.create("particles/" + name + ".plist");
        particle.setPosition(vec2);
        particle.setTotalParticles(1000);
        owner.addChild(particle);
    }

    @Override
    public void onEnter() {
        super.onEnter();
        setTouchEnabled(true);
        setTouchMode(Touch.MODE_ONE_BY_ONE);

        this.createParticle("lv01", new Vec2(360, 400));
    }

    @Override
    public void onExit() {
        super.onExit();
    }

    @Override
    public void onUpdate(float delta) {
        super.onUpdate(delta);
        totalScore += delta;
        scoreLabel.setString((int) totalScore + "");
    }

}
