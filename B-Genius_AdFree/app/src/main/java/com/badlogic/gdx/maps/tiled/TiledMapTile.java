package com.badlogic.gdx.maps.tiled;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapProperties;

public abstract interface TiledMapTile
{
  public abstract TiledMapTile.BlendMode getBlendMode();

  public abstract int getId();

  public abstract float getOffsetX();

  public abstract float getOffsetY();

  public abstract MapProperties getProperties();

  public abstract TextureRegion getTextureRegion();

  public abstract void setBlendMode(TiledMapTile.BlendMode paramBlendMode);

  public abstract void setId(int paramInt);

  public abstract void setOffsetX(float paramFloat);

  public abstract void setOffsetY(float paramFloat);

  public abstract void setTextureRegion(TextureRegion paramTextureRegion);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.tiled.TiledMapTile
 * JD-Core Version:    0.6.0
 */