package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.graphics.g3d.shaders.DepthShader;
import com.badlogic.gdx.graphics.g3d.shaders.DepthShader.Config;

public class DepthShaderProvider extends BaseShaderProvider
{
  public final DepthShader.Config config;

  public DepthShaderProvider()
  {
    this(null);
  }

  public DepthShaderProvider(FileHandle paramFileHandle1, FileHandle paramFileHandle2)
  {
    this(paramFileHandle1.readString(), paramFileHandle2.readString());
  }

  public DepthShaderProvider(DepthShader.Config paramConfig)
  {
    if (paramConfig == null)
      paramConfig = new DepthShader.Config();
    this.config = paramConfig;
  }

  public DepthShaderProvider(String paramString1, String paramString2)
  {
    this(new DepthShader.Config(paramString1, paramString2));
  }

  protected Shader createShader(Renderable paramRenderable)
  {
    return new DepthShader(paramRenderable, this.config);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.utils.DepthShaderProvider
 * JD-Core Version:    0.6.0
 */