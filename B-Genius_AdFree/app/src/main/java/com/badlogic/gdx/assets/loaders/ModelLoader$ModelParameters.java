package com.badlogic.gdx.assets.loaders;

import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.Texture.TextureWrap;

public class ModelLoader$ModelParameters extends AssetLoaderParameters
{
  public TextureLoader.TextureParameter textureParameter = new TextureLoader.TextureParameter();

  public ModelLoader$ModelParameters()
  {
    TextureLoader.TextureParameter localTextureParameter1 = this.textureParameter;
    TextureLoader.TextureParameter localTextureParameter2 = this.textureParameter;
    Texture.TextureFilter localTextureFilter = Texture.TextureFilter.Linear;
    localTextureParameter2.magFilter = localTextureFilter;
    localTextureParameter1.minFilter = localTextureFilter;
    TextureLoader.TextureParameter localTextureParameter3 = this.textureParameter;
    TextureLoader.TextureParameter localTextureParameter4 = this.textureParameter;
    Texture.TextureWrap localTextureWrap = Texture.TextureWrap.Repeat;
    localTextureParameter4.wrapV = localTextureWrap;
    localTextureParameter3.wrapU = localTextureWrap;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.assets.loaders.ModelLoader.ModelParameters
 * JD-Core Version:    0.6.0
 */