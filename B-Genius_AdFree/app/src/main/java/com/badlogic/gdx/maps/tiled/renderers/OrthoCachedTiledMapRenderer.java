package com.badlogic.gdx.maps.tiled.renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteCache;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapImageLayer;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Disposable;
import java.util.Iterator;

public class OrthoCachedTiledMapRenderer
  implements TiledMapRenderer, Disposable
{
  protected static final int NUM_VERTICES = 20;
  private static final float tolerance = 1.0E-005F;
  protected boolean blending;
  protected final Rectangle cacheBounds = new Rectangle();
  protected boolean cached;
  protected boolean canCacheMoreE;
  protected boolean canCacheMoreN;
  protected boolean canCacheMoreS;
  protected boolean canCacheMoreW;
  protected int count;
  protected final TiledMap map;
  protected float maxTileHeight;
  protected float maxTileWidth;
  protected float overCache = 0.5F;
  protected final SpriteCache spriteCache;
  protected float unitScale;
  protected final float[] vertices = new float[20];
  protected final Rectangle viewBounds = new Rectangle();

  public OrthoCachedTiledMapRenderer(TiledMap paramTiledMap)
  {
    this(paramTiledMap, 1.0F, 2000);
  }

  public OrthoCachedTiledMapRenderer(TiledMap paramTiledMap, float paramFloat)
  {
    this(paramTiledMap, paramFloat, 2000);
  }

  public OrthoCachedTiledMapRenderer(TiledMap paramTiledMap, float paramFloat, int paramInt)
  {
    this.map = paramTiledMap;
    this.unitScale = paramFloat;
    this.spriteCache = new SpriteCache(paramInt, true);
  }

  public void dispose()
  {
    this.spriteCache.dispose();
  }

  public SpriteCache getSpriteCache()
  {
    return this.spriteCache;
  }

  public void invalidateCache()
  {
    this.cached = false;
  }

  public boolean isCached()
  {
    return this.cached;
  }

  public void render()
  {
    if (!this.cached)
    {
      this.cached = true;
      this.count = 0;
      this.spriteCache.clear();
      float f1 = this.viewBounds.width * this.overCache;
      float f2 = this.viewBounds.height * this.overCache;
      this.cacheBounds.x = (this.viewBounds.x - f1);
      this.cacheBounds.y = (this.viewBounds.y - f2);
      this.cacheBounds.width = (this.viewBounds.width + f1 * 2.0F);
      this.cacheBounds.height = (this.viewBounds.height + f2 * 2.0F);
      Iterator localIterator = this.map.getLayers().iterator();
      if (localIterator.hasNext())
      {
        MapLayer localMapLayer2 = (MapLayer)localIterator.next();
        this.spriteCache.beginCache();
        if ((localMapLayer2 instanceof TiledMapTileLayer))
          renderTileLayer((TiledMapTileLayer)localMapLayer2);
        while (true)
        {
          this.spriteCache.endCache();
          break;
          if (!(localMapLayer2 instanceof TiledMapImageLayer))
            continue;
          renderImageLayer((TiledMapImageLayer)localMapLayer2);
        }
      }
    }
    if (this.blending)
    {
      Gdx.gl.glEnable(3042);
      Gdx.gl.glBlendFunc(770, 771);
    }
    this.spriteCache.begin();
    MapLayers localMapLayers = this.map.getLayers();
    int i = localMapLayers.getCount();
    for (int j = 0; j < i; j++)
    {
      MapLayer localMapLayer1 = localMapLayers.get(j);
      if (!localMapLayer1.isVisible())
        continue;
      this.spriteCache.draw(j);
      renderObjects(localMapLayer1);
    }
    this.spriteCache.end();
    if (this.blending)
      Gdx.gl.glDisable(3042);
  }

  public void render(int[] paramArrayOfInt)
  {
    if (!this.cached)
    {
      this.cached = true;
      this.count = 0;
      this.spriteCache.clear();
      float f1 = this.viewBounds.width * this.overCache;
      float f2 = this.viewBounds.height * this.overCache;
      this.cacheBounds.x = (this.viewBounds.x - f1);
      this.cacheBounds.y = (this.viewBounds.y - f2);
      this.cacheBounds.width = (this.viewBounds.width + f1 * 2.0F);
      this.cacheBounds.height = (this.viewBounds.height + f2 * 2.0F);
      Iterator localIterator = this.map.getLayers().iterator();
      if (localIterator.hasNext())
      {
        MapLayer localMapLayer2 = (MapLayer)localIterator.next();
        this.spriteCache.beginCache();
        if ((localMapLayer2 instanceof TiledMapTileLayer))
          renderTileLayer((TiledMapTileLayer)localMapLayer2);
        while (true)
        {
          this.spriteCache.endCache();
          break;
          if (!(localMapLayer2 instanceof TiledMapImageLayer))
            continue;
          renderImageLayer((TiledMapImageLayer)localMapLayer2);
        }
      }
    }
    if (this.blending)
    {
      Gdx.gl.glEnable(3042);
      Gdx.gl.glBlendFunc(770, 771);
    }
    this.spriteCache.begin();
    MapLayers localMapLayers = this.map.getLayers();
    int i = paramArrayOfInt.length;
    for (int j = 0; j < i; j++)
    {
      int k = paramArrayOfInt[j];
      MapLayer localMapLayer1 = localMapLayers.get(k);
      if (!localMapLayer1.isVisible())
        continue;
      this.spriteCache.draw(k);
      renderObjects(localMapLayer1);
    }
    this.spriteCache.end();
    if (this.blending)
      Gdx.gl.glDisable(3042);
  }

  public void renderImageLayer(TiledMapImageLayer paramTiledMapImageLayer)
  {
    float f1 = Color.toFloatBits(1.0F, 1.0F, 1.0F, paramTiledMapImageLayer.getOpacity());
    float[] arrayOfFloat = this.vertices;
    TextureRegion localTextureRegion = paramTiledMapImageLayer.getTextureRegion();
    if (localTextureRegion == null)
      return;
    float f2 = paramTiledMapImageLayer.getX();
    float f3 = paramTiledMapImageLayer.getY();
    float f4 = f2 * this.unitScale;
    float f5 = f3 * this.unitScale;
    float f6 = f4 + localTextureRegion.getRegionWidth() * this.unitScale;
    float f7 = f5 + localTextureRegion.getRegionHeight() * this.unitScale;
    float f8 = localTextureRegion.getU();
    float f9 = localTextureRegion.getV2();
    float f10 = localTextureRegion.getU2();
    float f11 = localTextureRegion.getV();
    arrayOfFloat[0] = f4;
    arrayOfFloat[1] = f5;
    arrayOfFloat[2] = f1;
    arrayOfFloat[3] = f8;
    arrayOfFloat[4] = f9;
    arrayOfFloat[5] = f4;
    arrayOfFloat[6] = f7;
    arrayOfFloat[7] = f1;
    arrayOfFloat[8] = f8;
    arrayOfFloat[9] = f11;
    arrayOfFloat[10] = f6;
    arrayOfFloat[11] = f7;
    arrayOfFloat[12] = f1;
    arrayOfFloat[13] = f10;
    arrayOfFloat[14] = f11;
    arrayOfFloat[15] = f6;
    arrayOfFloat[16] = f5;
    arrayOfFloat[17] = f1;
    arrayOfFloat[18] = f10;
    arrayOfFloat[19] = f9;
    this.spriteCache.add(localTextureRegion.getTexture(), arrayOfFloat, 0, 20);
  }

  public void renderObject(MapObject paramMapObject)
  {
  }

  public void renderObjects(MapLayer paramMapLayer)
  {
    Iterator localIterator = paramMapLayer.getObjects().iterator();
    while (localIterator.hasNext())
      renderObject((MapObject)localIterator.next());
  }

  public void renderTileLayer(TiledMapTileLayer paramTiledMapTileLayer)
  {
    float f1 = Color.toFloatBits(1.0F, 1.0F, 1.0F, paramTiledMapTileLayer.getOpacity());
    int i = paramTiledMapTileLayer.getWidth();
    int j = paramTiledMapTileLayer.getHeight();
    float f2 = paramTiledMapTileLayer.getTileWidth() * this.unitScale;
    float f3 = paramTiledMapTileLayer.getTileHeight() * this.unitScale;
    int k = Math.max(0, (int)(this.cacheBounds.x / f2));
    int m = Math.min(i, (int)((f2 + (this.cacheBounds.x + this.cacheBounds.width)) / f2));
    int n = Math.max(0, (int)(this.cacheBounds.y / f3));
    int i1 = Math.min(j, (int)((f3 + (this.cacheBounds.y + this.cacheBounds.height)) / f3));
    boolean bool1;
    boolean bool2;
    label160: boolean bool3;
    label174: boolean bool4;
    label188: float[] arrayOfFloat;
    if (i1 < j)
    {
      bool1 = true;
      this.canCacheMoreN = bool1;
      if (m >= i)
        break label718;
      bool2 = true;
      this.canCacheMoreE = bool2;
      if (k <= 0)
        break label724;
      bool3 = true;
      this.canCacheMoreW = bool3;
      if (n <= 0)
        break label730;
      bool4 = true;
      this.canCacheMoreS = bool4;
      arrayOfFloat = this.vertices;
    }
    while (true)
    {
      if (i1 < n)
        return;
      int i2 = k;
      label211: if (i2 < m)
      {
        TiledMapTileLayer.Cell localCell = paramTiledMapTileLayer.getCell(i2, i1);
        Texture localTexture;
        if (localCell != null)
        {
          TiledMapTile localTiledMapTile = localCell.getTile();
          if (localTiledMapTile != null)
          {
            this.count = (1 + this.count);
            boolean bool5 = localCell.getFlipHorizontally();
            boolean bool6 = localCell.getFlipVertically();
            int i3 = localCell.getRotation();
            TextureRegion localTextureRegion = localTiledMapTile.getTextureRegion();
            localTexture = localTextureRegion.getTexture();
            float f4 = f2 * i2 + localTiledMapTile.getOffsetX() * this.unitScale;
            float f5 = f3 * i1 + localTiledMapTile.getOffsetY() * this.unitScale;
            float f6 = f4 + localTextureRegion.getRegionWidth() * this.unitScale;
            float f7 = f5 + localTextureRegion.getRegionHeight() * this.unitScale;
            float f8 = 0.5F / localTexture.getWidth();
            float f9 = 0.5F / localTexture.getHeight();
            float f10 = f8 + localTextureRegion.getU();
            float f11 = localTextureRegion.getV2() - f9;
            float f12 = localTextureRegion.getU2() - f8;
            float f13 = f9 + localTextureRegion.getV();
            arrayOfFloat[0] = f4;
            arrayOfFloat[1] = f5;
            arrayOfFloat[2] = f1;
            arrayOfFloat[3] = f10;
            arrayOfFloat[4] = f11;
            arrayOfFloat[5] = f4;
            arrayOfFloat[6] = f7;
            arrayOfFloat[7] = f1;
            arrayOfFloat[8] = f10;
            arrayOfFloat[9] = f13;
            arrayOfFloat[10] = f6;
            arrayOfFloat[11] = f7;
            arrayOfFloat[12] = f1;
            arrayOfFloat[13] = f12;
            arrayOfFloat[14] = f13;
            arrayOfFloat[15] = f6;
            arrayOfFloat[16] = f5;
            arrayOfFloat[17] = f1;
            arrayOfFloat[18] = f12;
            arrayOfFloat[19] = f11;
            if (bool5)
            {
              float f24 = arrayOfFloat[3];
              arrayOfFloat[3] = arrayOfFloat[13];
              arrayOfFloat[13] = f24;
              float f25 = arrayOfFloat[8];
              arrayOfFloat[8] = arrayOfFloat[18];
              arrayOfFloat[18] = f25;
            }
            if (bool6)
            {
              float f22 = arrayOfFloat[4];
              arrayOfFloat[4] = arrayOfFloat[14];
              arrayOfFloat[14] = f22;
              float f23 = arrayOfFloat[9];
              arrayOfFloat[9] = arrayOfFloat[19];
              arrayOfFloat[19] = f23;
            }
            if (i3 != 0)
              switch (i3)
              {
              default:
              case 1:
              case 2:
              case 3:
              }
          }
        }
        while (true)
        {
          this.spriteCache.add(localTexture, arrayOfFloat, 0, 20);
          i2++;
          break label211;
          bool1 = false;
          break;
          bool2 = false;
          break label160;
          label724: bool3 = false;
          break label174;
          label730: bool4 = false;
          break label188;
          float f20 = arrayOfFloat[4];
          arrayOfFloat[4] = arrayOfFloat[9];
          arrayOfFloat[9] = arrayOfFloat[14];
          arrayOfFloat[14] = arrayOfFloat[19];
          arrayOfFloat[19] = f20;
          float f21 = arrayOfFloat[3];
          arrayOfFloat[3] = arrayOfFloat[8];
          arrayOfFloat[8] = arrayOfFloat[13];
          arrayOfFloat[13] = arrayOfFloat[18];
          arrayOfFloat[18] = f21;
          continue;
          float f16 = arrayOfFloat[3];
          arrayOfFloat[3] = arrayOfFloat[13];
          arrayOfFloat[13] = f16;
          float f17 = arrayOfFloat[8];
          arrayOfFloat[8] = arrayOfFloat[18];
          arrayOfFloat[18] = f17;
          float f18 = arrayOfFloat[4];
          arrayOfFloat[4] = arrayOfFloat[14];
          arrayOfFloat[14] = f18;
          float f19 = arrayOfFloat[9];
          arrayOfFloat[9] = arrayOfFloat[19];
          arrayOfFloat[19] = f19;
          continue;
          float f14 = arrayOfFloat[4];
          arrayOfFloat[4] = arrayOfFloat[19];
          arrayOfFloat[19] = arrayOfFloat[14];
          arrayOfFloat[14] = arrayOfFloat[9];
          arrayOfFloat[9] = f14;
          float f15 = arrayOfFloat[3];
          arrayOfFloat[3] = arrayOfFloat[18];
          arrayOfFloat[18] = arrayOfFloat[13];
          arrayOfFloat[13] = arrayOfFloat[8];
          arrayOfFloat[8] = f15;
        }
      }
      label718: i1--;
    }
  }

  public void setBlending(boolean paramBoolean)
  {
    this.blending = paramBoolean;
  }

  public void setMaxTileSize(float paramFloat1, float paramFloat2)
  {
    this.maxTileWidth = paramFloat1;
    this.maxTileHeight = paramFloat2;
  }

  public void setOverCache(float paramFloat)
  {
    this.overCache = paramFloat;
  }

  public void setView(OrthographicCamera paramOrthographicCamera)
  {
    this.spriteCache.setProjectionMatrix(paramOrthographicCamera.combined);
    float f1 = paramOrthographicCamera.viewportWidth * paramOrthographicCamera.zoom + 2.0F * this.maxTileWidth * this.unitScale;
    float f2 = paramOrthographicCamera.viewportHeight * paramOrthographicCamera.zoom + 2.0F * this.maxTileHeight * this.unitScale;
    this.viewBounds.set(paramOrthographicCamera.position.x - f1 / 2.0F, paramOrthographicCamera.position.y - f2 / 2.0F, f1, f2);
    if (((this.canCacheMoreW) && (this.viewBounds.x < this.cacheBounds.x - 1.0E-005F)) || ((this.canCacheMoreS) && (this.viewBounds.y < this.cacheBounds.y - 1.0E-005F)) || ((this.canCacheMoreE) && (this.viewBounds.x + this.viewBounds.width > 1.0E-005F + (this.cacheBounds.x + this.cacheBounds.width))) || ((this.canCacheMoreN) && (this.viewBounds.y + this.viewBounds.height > 1.0E-005F + (this.cacheBounds.y + this.cacheBounds.height))))
      this.cached = false;
  }

  public void setView(Matrix4 paramMatrix4, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.spriteCache.setProjectionMatrix(paramMatrix4);
    float f1 = paramFloat1 - this.maxTileWidth * this.unitScale;
    float f2 = paramFloat2 - this.maxTileHeight * this.unitScale;
    float f3 = paramFloat3 + 2.0F * this.maxTileWidth * this.unitScale;
    float f4 = paramFloat4 + 2.0F * this.maxTileHeight * this.unitScale;
    this.viewBounds.set(f1, f2, f3, f4);
    if (((this.canCacheMoreW) && (this.viewBounds.x < this.cacheBounds.x - 1.0E-005F)) || ((this.canCacheMoreS) && (this.viewBounds.y < this.cacheBounds.y - 1.0E-005F)) || ((this.canCacheMoreE) && (this.viewBounds.x + this.viewBounds.width > 1.0E-005F + (this.cacheBounds.x + this.cacheBounds.width))) || ((this.canCacheMoreN) && (this.viewBounds.y + this.viewBounds.height > 1.0E-005F + (this.cacheBounds.y + this.cacheBounds.height))))
      this.cached = false;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer
 * JD-Core Version:    0.6.0
 */