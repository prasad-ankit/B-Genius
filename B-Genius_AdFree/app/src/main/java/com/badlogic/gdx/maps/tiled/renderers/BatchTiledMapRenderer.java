package com.badlogic.gdx.maps.tiled.renderers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapImageLayer;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.tiles.AnimatedTiledMapTile;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Disposable;
import java.util.Iterator;

public abstract class BatchTiledMapRenderer
  implements TiledMapRenderer, Disposable
{
  protected static final int NUM_VERTICES = 20;
  protected Batch batch;
  protected Rectangle imageBounds = new Rectangle();
  protected TiledMap map;
  protected boolean ownsBatch;
  protected float unitScale;
  protected float[] vertices = new float[20];
  protected Rectangle viewBounds;

  public BatchTiledMapRenderer(TiledMap paramTiledMap)
  {
    this(paramTiledMap, 1.0F);
  }

  public BatchTiledMapRenderer(TiledMap paramTiledMap, float paramFloat)
  {
    this.map = paramTiledMap;
    this.unitScale = paramFloat;
    this.viewBounds = new Rectangle();
    this.batch = new SpriteBatch();
    this.ownsBatch = true;
  }

  public BatchTiledMapRenderer(TiledMap paramTiledMap, float paramFloat, Batch paramBatch)
  {
    this.map = paramTiledMap;
    this.unitScale = paramFloat;
    this.viewBounds = new Rectangle();
    this.batch = paramBatch;
    this.ownsBatch = false;
  }

  public BatchTiledMapRenderer(TiledMap paramTiledMap, Batch paramBatch)
  {
    this(paramTiledMap, 1.0F, paramBatch);
  }

  protected void beginRender()
  {
    AnimatedTiledMapTile.updateAnimationBaseTime();
    this.batch.begin();
  }

  public void dispose()
  {
    if (this.ownsBatch)
      this.batch.dispose();
  }

  protected void endRender()
  {
    this.batch.end();
  }

  public Batch getBatch()
  {
    return this.batch;
  }

  public TiledMap getMap()
  {
    return this.map;
  }

  public float getUnitScale()
  {
    return this.unitScale;
  }

  public Rectangle getViewBounds()
  {
    return this.viewBounds;
  }

  public void render()
  {
    beginRender();
    Iterator localIterator = this.map.getLayers().iterator();
    while (localIterator.hasNext())
    {
      MapLayer localMapLayer = (MapLayer)localIterator.next();
      if (!localMapLayer.isVisible())
        continue;
      if ((localMapLayer instanceof TiledMapTileLayer))
        renderTileLayer((TiledMapTileLayer)localMapLayer);
      if ((localMapLayer instanceof TiledMapImageLayer))
      {
        renderImageLayer((TiledMapImageLayer)localMapLayer);
        continue;
      }
      renderObjects(localMapLayer);
    }
    endRender();
  }

  public void render(int[] paramArrayOfInt)
  {
    beginRender();
    int i = paramArrayOfInt.length;
    int j = 0;
    if (j < i)
    {
      int k = paramArrayOfInt[j];
      MapLayer localMapLayer = this.map.getLayers().get(k);
      if (localMapLayer.isVisible())
      {
        if (!(localMapLayer instanceof TiledMapTileLayer))
          break label64;
        renderTileLayer((TiledMapTileLayer)localMapLayer);
      }
      while (true)
      {
        j++;
        break;
        label64: if ((localMapLayer instanceof TiledMapImageLayer))
        {
          renderImageLayer((TiledMapImageLayer)localMapLayer);
          continue;
        }
        renderObjects(localMapLayer);
      }
    }
    endRender();
  }

  public void renderImageLayer(TiledMapImageLayer paramTiledMapImageLayer)
  {
    Color localColor = this.batch.getColor();
    float f1 = Color.toFloatBits(localColor.r, localColor.g, localColor.b, localColor.a * paramTiledMapImageLayer.getOpacity());
    float[] arrayOfFloat = this.vertices;
    TextureRegion localTextureRegion = paramTiledMapImageLayer.getTextureRegion();
    if (localTextureRegion == null);
    float f4;
    float f5;
    float f6;
    float f7;
    do
    {
      return;
      float f2 = paramTiledMapImageLayer.getX();
      float f3 = paramTiledMapImageLayer.getY();
      f4 = f2 * this.unitScale;
      f5 = f3 * this.unitScale;
      f6 = f4 + localTextureRegion.getRegionWidth() * this.unitScale;
      f7 = f5 + localTextureRegion.getRegionHeight() * this.unitScale;
      this.imageBounds.set(f4, f5, f6 - f4, f7 - f5);
    }
    while ((!this.viewBounds.contains(this.imageBounds)) && (!this.viewBounds.overlaps(this.imageBounds)));
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
    this.batch.draw(localTextureRegion.getTexture(), arrayOfFloat, 0, 20);
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

  public void setMap(TiledMap paramTiledMap)
  {
    this.map = paramTiledMap;
  }

  public void setView(OrthographicCamera paramOrthographicCamera)
  {
    this.batch.setProjectionMatrix(paramOrthographicCamera.combined);
    float f1 = paramOrthographicCamera.viewportWidth * paramOrthographicCamera.zoom;
    float f2 = paramOrthographicCamera.viewportHeight * paramOrthographicCamera.zoom;
    this.viewBounds.set(paramOrthographicCamera.position.x - f1 / 2.0F, paramOrthographicCamera.position.y - f2 / 2.0F, f1, f2);
  }

  public void setView(Matrix4 paramMatrix4, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.batch.setProjectionMatrix(paramMatrix4);
    this.viewBounds.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.tiled.renderers.BatchTiledMapRenderer
 * JD-Core Version:    0.6.0
 */