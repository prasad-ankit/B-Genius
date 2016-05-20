package com.badlogic.gdx.assets.loaders;

import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.graphics.Cubemap;
import com.badlogic.gdx.graphics.CubemapData;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.Texture.TextureWrap;

public class CubemapLoader$CubemapParameter extends AssetLoaderParameters
{
  public Cubemap cubemap = null;
  public CubemapData cubemapData = null;
  public Pixmap.Format format = null;
  public Texture.TextureFilter magFilter = Texture.TextureFilter.Nearest;
  public Texture.TextureFilter minFilter = Texture.TextureFilter.Nearest;
  public Texture.TextureWrap wrapU = Texture.TextureWrap.ClampToEdge;
  public Texture.TextureWrap wrapV = Texture.TextureWrap.ClampToEdge;
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.assets.loaders.CubemapLoader.CubemapParameter
 * JD-Core Version:    0.6.0
 */