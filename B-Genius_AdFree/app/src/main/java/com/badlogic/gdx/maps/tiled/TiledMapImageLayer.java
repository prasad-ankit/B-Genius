package com.badlogic.gdx.maps.tiled;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayer;

public class TiledMapImageLayer extends MapLayer
{
  private TextureRegion region;
  private float x;
  private float y;

  public TiledMapImageLayer(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2)
  {
    this.region = paramTextureRegion;
    this.x = paramFloat1;
    this.y = paramFloat2;
  }

  public TextureRegion getTextureRegion()
  {
    return this.region;
  }

  public float getX()
  {
    return this.x;
  }

  public float getY()
  {
    return this.y;
  }

  public void setTextureRegion(TextureRegion paramTextureRegion)
  {
    this.region = paramTextureRegion;
  }

  public void setX(float paramFloat)
  {
    this.x = paramFloat;
  }

  public void setY(float paramFloat)
  {
    this.y = paramFloat;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.tiled.TiledMapImageLayer
 * JD-Core Version:    0.6.0
 */