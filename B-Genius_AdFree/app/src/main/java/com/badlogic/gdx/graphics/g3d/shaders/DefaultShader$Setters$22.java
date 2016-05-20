package com.badlogic.gdx.graphics.g3d.shaders;

import com.badlogic.gdx.graphics.g3d.Attributes;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.utils.RenderContext;
import com.badlogic.gdx.graphics.g3d.utils.TextureBinder;

final class DefaultShader$Setters$22 extends BaseShader.LocalSetter
{
  public final void set(BaseShader paramBaseShader, int paramInt, Renderable paramRenderable, Attributes paramAttributes)
  {
    paramBaseShader.set(paramInt, paramBaseShader.context.textureBinder.bind(((TextureAttribute)paramAttributes.get(TextureAttribute.Reflection)).textureDescription));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.22
 * JD-Core Version:    0.6.0
 */