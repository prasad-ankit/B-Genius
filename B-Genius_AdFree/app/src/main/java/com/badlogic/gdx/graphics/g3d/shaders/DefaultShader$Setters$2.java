package com.badlogic.gdx.graphics.g3d.shaders;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g3d.Attributes;
import com.badlogic.gdx.graphics.g3d.Renderable;

final class DefaultShader$Setters$2 extends BaseShader.GlobalSetter
{
  public final void set(BaseShader paramBaseShader, int paramInt, Renderable paramRenderable, Attributes paramAttributes)
  {
    paramBaseShader.set(paramInt, paramBaseShader.camera.view);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.2
 * JD-Core Version:    0.6.0
 */