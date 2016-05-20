package com.badlogic.gdx.graphics.g3d.shaders;

public class DefaultShader$Config
{
  public int defaultCullFace = -1;
  public int defaultDepthFunc = -1;
  public String fragmentShader = null;
  public boolean ignoreUnimplemented = true;
  public int numBones = 12;
  public int numDirectionalLights = 2;
  public int numPointLights = 5;
  public int numSpotLights = 0;
  public String vertexShader = null;

  public DefaultShader$Config()
  {
  }

  public DefaultShader$Config(String paramString1, String paramString2)
  {
    this.vertexShader = paramString1;
    this.fragmentShader = paramString2;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Config
 * JD-Core Version:    0.6.0
 */