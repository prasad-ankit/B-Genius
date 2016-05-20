package com.badlogic.gdx.graphics.g3d.particles;

import com.badlogic.gdx.graphics.g3d.shaders.BaseShader.Setter;

public class ParticleShader$Setters
{
  public static final BaseShader.Setter cameraInvDirection;
  public static final BaseShader.Setter cameraPosition;
  public static final BaseShader.Setter cameraRight = new ParticleShader.Setters.1();
  public static final BaseShader.Setter cameraUp = new ParticleShader.Setters.2();
  public static final BaseShader.Setter screenWidth;
  public static final BaseShader.Setter worldViewTrans;

  static
  {
    cameraInvDirection = new ParticleShader.Setters.3();
    cameraPosition = new ParticleShader.Setters.4();
    screenWidth = new ParticleShader.Setters.5();
    worldViewTrans = new ParticleShader.Setters.6();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.ParticleShader.Setters
 * JD-Core Version:    0.6.0
 */