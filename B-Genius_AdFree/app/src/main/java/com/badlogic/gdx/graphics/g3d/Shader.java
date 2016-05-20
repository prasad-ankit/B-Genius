package com.badlogic.gdx.graphics.g3d;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g3d.utils.RenderContext;
import com.badlogic.gdx.utils.Disposable;

public abstract interface Shader extends Disposable
{
  public abstract void begin(Camera paramCamera, RenderContext paramRenderContext);

  public abstract boolean canRender(Renderable paramRenderable);

  public abstract int compareTo(Shader paramShader);

  public abstract void end();

  public abstract void init();

  public abstract void render(Renderable paramRenderable);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.Shader
 * JD-Core Version:    0.6.0
 */