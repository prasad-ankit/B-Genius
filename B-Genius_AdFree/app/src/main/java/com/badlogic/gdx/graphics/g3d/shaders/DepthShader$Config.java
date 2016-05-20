package com.badlogic.gdx.graphics.g3d.shaders;

public class DepthShader$Config extends DefaultShader.Config
{
  public float defaultAlphaTest = 0.5F;
  public boolean depthBufferOnly = false;

  public DepthShader$Config()
  {
    this.defaultCullFace = 1028;
  }

  public DepthShader$Config(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.shaders.DepthShader.Config
 * JD-Core Version:    0.6.0
 */