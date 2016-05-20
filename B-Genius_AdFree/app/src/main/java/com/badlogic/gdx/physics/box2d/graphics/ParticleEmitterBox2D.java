package com.badlogic.gdx.physics.box2d.graphics;

import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
import com.badlogic.gdx.graphics.g2d.ParticleEmitter.Particle;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.RayCastCallback;
import com.badlogic.gdx.physics.box2d.World;
import java.io.BufferedReader;

public class ParticleEmitterBox2D extends ParticleEmitter
{
  private static final float EPSILON = 0.001F;
  final Vector2 endPoint = new Vector2();
  float normalAngle;
  boolean particleCollided;
  final RayCastCallback rayCallBack = new ParticleEmitterBox2D.1(this);
  final Vector2 startPoint = new Vector2();
  final World world;

  public ParticleEmitterBox2D(World paramWorld)
  {
    this.world = paramWorld;
  }

  public ParticleEmitterBox2D(World paramWorld, ParticleEmitter paramParticleEmitter)
  {
    super(paramParticleEmitter);
    this.world = paramWorld;
  }

  public ParticleEmitterBox2D(World paramWorld, BufferedReader paramBufferedReader)
  {
    super(paramBufferedReader);
    this.world = paramWorld;
  }

  protected ParticleEmitter.Particle newParticle(Sprite paramSprite)
  {
    return new ParticleEmitterBox2D.ParticleBox2D(this, paramSprite);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.physics.box2d.graphics.ParticleEmitterBox2D
 * JD-Core Version:    0.6.0
 */