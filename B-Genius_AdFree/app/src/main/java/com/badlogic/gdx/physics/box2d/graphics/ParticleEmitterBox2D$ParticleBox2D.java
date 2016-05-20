package com.badlogic.gdx.physics.box2d.graphics;

import com.badlogic.gdx.graphics.g2d.ParticleEmitter.Particle;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

class ParticleEmitterBox2D$ParticleBox2D extends ParticleEmitter.Particle
{
  public ParticleEmitterBox2D$ParticleBox2D(ParticleEmitterBox2D paramParticleEmitterBox2D, Sprite paramSprite)
  {
    super(paramSprite);
  }

  public void translate(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 < 0.001F)
      return;
    float f1 = getX() + getWidth() / 2.0F;
    float f2 = getY() + getHeight() / 2.0F;
    this.this$0.particleCollided = false;
    this.this$0.startPoint.set(f1, f2);
    this.this$0.endPoint.set(f1 + paramFloat1, f2 + paramFloat2);
    if (this.this$0.world != null)
      this.this$0.world.rayCast(this.this$0.rayCallBack, this.this$0.startPoint, this.this$0.endPoint);
    if (this.this$0.particleCollided)
    {
      this.angle = (2.0F * this.this$0.normalAngle - this.angle - 180.0F);
      this.angleCos = MathUtils.cosDeg(this.angle);
      this.angleSin = MathUtils.sinDeg(this.angle);
      paramFloat1 *= this.angleCos;
      paramFloat2 *= this.angleSin;
    }
    super.translate(paramFloat1, paramFloat2);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.physics.box2d.graphics.ParticleEmitterBox2D.ParticleBox2D
 * JD-Core Version:    0.6.0
 */