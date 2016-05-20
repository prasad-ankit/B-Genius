package com.badlogic.gdx.maps.tiled.tiles;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTile.BlendMode;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.TimeUtils;

public class AnimatedTiledMapTile
  implements TiledMapTile
{
  private static final long initialTimeOffset;
  private static long lastTiledMapRenderTime = 0L;
  private int[] animationIntervals;
  private TiledMapTile.BlendMode blendMode = TiledMapTile.BlendMode.ALPHA;
  private int frameCount = 0;
  private StaticTiledMapTile[] frameTiles;
  private int id;
  private int loopDuration;
  private MapProperties properties;

  static
  {
    initialTimeOffset = TimeUtils.millis();
  }

  public AnimatedTiledMapTile(float paramFloat, Array paramArray)
  {
    this.frameTiles = new StaticTiledMapTile[paramArray.size];
    this.frameCount = paramArray.size;
    this.loopDuration = (paramArray.size * (int)(paramFloat * 1000.0F));
    this.animationIntervals = new int[paramArray.size];
    for (int i = 0; i < paramArray.size; i++)
    {
      this.frameTiles[i] = ((StaticTiledMapTile)paramArray.get(i));
      this.animationIntervals[i] = (int)(paramFloat * 1000.0F);
    }
  }

  public AnimatedTiledMapTile(IntArray paramIntArray, Array paramArray)
  {
    this.frameTiles = new StaticTiledMapTile[paramArray.size];
    this.frameCount = paramArray.size;
    this.animationIntervals = paramIntArray.toArray();
    this.loopDuration = 0;
    for (int i = 0; i < paramIntArray.size; i++)
    {
      this.frameTiles[i] = ((StaticTiledMapTile)paramArray.get(i));
      this.loopDuration += paramIntArray.get(i);
    }
  }

  public static void updateAnimationBaseTime()
  {
    lastTiledMapRenderTime = TimeUtils.millis() - initialTimeOffset;
  }

  public int[] getAnimationIntervals()
  {
    return this.animationIntervals;
  }

  public TiledMapTile.BlendMode getBlendMode()
  {
    return this.blendMode;
  }

  public TiledMapTile getCurrentFrame()
  {
    return this.frameTiles[getCurrentFrameIndex()];
  }

  public int getCurrentFrameIndex()
  {
    int i = (int)(lastTiledMapRenderTime % this.loopDuration);
    for (int j = 0; j < this.animationIntervals.length; j++)
    {
      int k = this.animationIntervals[j];
      if (i <= k)
        return j;
      i -= k;
    }
    throw new GdxRuntimeException("Could not determine current animation frame in AnimatedTiledMapTile.  This should never happen.");
  }

  public StaticTiledMapTile[] getFrameTiles()
  {
    return this.frameTiles;
  }

  public int getId()
  {
    return this.id;
  }

  public float getOffsetX()
  {
    return getCurrentFrame().getOffsetX();
  }

  public float getOffsetY()
  {
    return getCurrentFrame().getOffsetY();
  }

  public MapProperties getProperties()
  {
    if (this.properties == null)
      this.properties = new MapProperties();
    return this.properties;
  }

  public TextureRegion getTextureRegion()
  {
    return getCurrentFrame().getTextureRegion();
  }

  public void setAnimationIntervals(int[] paramArrayOfInt)
  {
    int i = 0;
    if (paramArrayOfInt.length == this.animationIntervals.length)
    {
      this.animationIntervals = paramArrayOfInt;
      this.loopDuration = 0;
      while (i < paramArrayOfInt.length)
      {
        this.loopDuration += paramArrayOfInt[i];
        i++;
      }
    }
    throw new GdxRuntimeException("Cannot set " + paramArrayOfInt.length + " frame intervals. The given int[] must have a size of " + this.animationIntervals.length + ".");
  }

  public void setBlendMode(TiledMapTile.BlendMode paramBlendMode)
  {
    this.blendMode = paramBlendMode;
  }

  public void setId(int paramInt)
  {
    this.id = paramInt;
  }

  public void setOffsetX(float paramFloat)
  {
    throw new GdxRuntimeException("Cannot set offset of AnimatedTiledMapTile.");
  }

  public void setOffsetY(float paramFloat)
  {
    throw new GdxRuntimeException("Cannot set offset of AnimatedTiledMapTile.");
  }

  public void setTextureRegion(TextureRegion paramTextureRegion)
  {
    throw new GdxRuntimeException("Cannot set the texture region of AnimatedTiledMapTile.");
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.tiled.tiles.AnimatedTiledMapTile
 * JD-Core Version:    0.6.0
 */