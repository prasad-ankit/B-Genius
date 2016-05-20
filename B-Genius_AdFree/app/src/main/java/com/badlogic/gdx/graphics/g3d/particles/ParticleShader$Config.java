package com.badlogic.gdx.graphics.g3d.particles;

public class ParticleShader$Config
{
  public ParticleShader.AlignMode align = ParticleShader.AlignMode.Screen;
  public int defaultCullFace = -1;
  public int defaultDepthFunc = -1;
  public String fragmentShader = null;
  public boolean ignoreUnimplemented = true;
  public ParticleShader.ParticleType type = ParticleShader.ParticleType.Billboard;
  public String vertexShader = null;

  public ParticleShader$Config()
  {
  }

  public ParticleShader$Config(ParticleShader.AlignMode paramAlignMode)
  {
    this.align = paramAlignMode;
  }

  public ParticleShader$Config(ParticleShader.AlignMode paramAlignMode, ParticleShader.ParticleType paramParticleType)
  {
    this.align = paramAlignMode;
    this.type = paramParticleType;
  }

  public ParticleShader$Config(ParticleShader.ParticleType paramParticleType)
  {
    this.type = paramParticleType;
  }

  public ParticleShader$Config(String paramString1, String paramString2)
  {
    this.vertexShader = paramString1;
    this.fragmentShader = paramString2;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.ParticleShader.Config
 * JD-Core Version:    0.6.0
 */