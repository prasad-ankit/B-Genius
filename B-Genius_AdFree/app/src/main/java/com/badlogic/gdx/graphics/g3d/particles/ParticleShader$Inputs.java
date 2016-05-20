package com.badlogic.gdx.graphics.g3d.particles;

import com.badlogic.gdx.graphics.g3d.shaders.BaseShader.Uniform;

public class ParticleShader$Inputs
{
  public static final BaseShader.Uniform cameraInvDirection;
  public static final BaseShader.Uniform cameraRight = new BaseShader.Uniform("u_cameraRight");
  public static final BaseShader.Uniform regionSize;
  public static final BaseShader.Uniform screenWidth;

  static
  {
    cameraInvDirection = new BaseShader.Uniform("u_cameraInvDirection");
    screenWidth = new BaseShader.Uniform("u_screenWidth");
    regionSize = new BaseShader.Uniform("u_regionSize");
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.ParticleShader.Inputs
 * JD-Core Version:    0.6.0
 */