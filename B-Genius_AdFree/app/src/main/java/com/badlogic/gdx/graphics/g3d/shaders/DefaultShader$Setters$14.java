package com.badlogic.gdx.graphics.g3d.shaders;

import com.badlogic.gdx.graphics.g3d.Attributes;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;

final class DefaultShader$Setters$14 extends BaseShader.LocalSetter
{
  public final void set(BaseShader paramBaseShader, int paramInt, Renderable paramRenderable, Attributes paramAttributes)
  {
    TextureAttribute localTextureAttribute = (TextureAttribute)paramAttributes.get(TextureAttribute.Diffuse);
    paramBaseShader.set(paramInt, localTextureAttribute.offsetU, localTextureAttribute.offsetV, localTextureAttribute.scaleU, localTextureAttribute.scaleV);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.14
 * JD-Core Version:    0.6.0
 */