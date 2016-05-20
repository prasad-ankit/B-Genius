package com.badlogic.gdx.physics.box2d.graphics;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.RayCastCallback;

class ParticleEmitterBox2D$1
  implements RayCastCallback
{
  public float reportRayFixture(Fixture paramFixture, Vector2 paramVector21, Vector2 paramVector22, float paramFloat)
  {
    this.this$0.particleCollided = true;
    this.this$0.normalAngle = (57.295776F * MathUtils.atan2(paramVector22.y, paramVector22.x));
    return paramFloat;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.physics.box2d.graphics.ParticleEmitterBox2D.1
 * JD-Core Version:    0.6.0
 */