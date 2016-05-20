package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.graphics.g3d.shaders.DefaultShader;
import com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Config;

public class DefaultShaderProvider extends BaseShaderProvider
{
  public final DefaultShader.Config config;

  public DefaultShaderProvider()
  {
    this(null);
  }

  public DefaultShaderProvider(FileHandle paramFileHandle1, FileHandle paramFileHandle2)
  {
    this(paramFileHandle1.readString(), paramFileHandle2.readString());
  }

  public DefaultShaderProvider(DefaultShader.Config paramConfig)
  {
    if (paramConfig == null)
      paramConfig = new DefaultShader.Config();
    this.config = paramConfig;
  }

  public DefaultShaderProvider(String paramString1, String paramString2)
  {
    this(new DefaultShader.Config(paramString1, paramString2));
  }

  protected Shader createShader(Renderable paramRenderable)
  {
    return new DefaultShader(paramRenderable, this.config);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.utils.DefaultShaderProvider
 * JD-Core Version:    0.6.0
 */