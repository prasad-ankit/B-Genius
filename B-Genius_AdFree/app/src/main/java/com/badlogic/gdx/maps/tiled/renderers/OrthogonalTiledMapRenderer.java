package com.badlogic.gdx.maps.tiled.renderers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Rectangle;

public class OrthogonalTiledMapRenderer extends BatchTiledMapRenderer
{
  public OrthogonalTiledMapRenderer(TiledMap paramTiledMap)
  {
    super(paramTiledMap);
  }

  public OrthogonalTiledMapRenderer(TiledMap paramTiledMap, float paramFloat)
  {
    super(paramTiledMap, paramFloat);
  }

  public OrthogonalTiledMapRenderer(TiledMap paramTiledMap, float paramFloat, Batch paramBatch)
  {
    super(paramTiledMap, paramFloat, paramBatch);
  }

  public OrthogonalTiledMapRenderer(TiledMap paramTiledMap, Batch paramBatch)
  {
    super(paramTiledMap, paramBatch);
  }

  public void renderTileLayer(TiledMapTileLayer paramTiledMapTileLayer)
  {
    Color localColor = this.batch.getColor();
    float f1 = Color.toFloatBits(localColor.r, localColor.g, localColor.b, localColor.a * paramTiledMapTileLayer.getOpacity());
    int i = paramTiledMapTileLayer.getWidth();
    int j = paramTiledMapTileLayer.getHeight();
    float f2 = paramTiledMapTileLayer.getTileWidth() * this.unitScale;
    float f3 = paramTiledMapTileLayer.getTileHeight() * this.unitScale;
    int k = Math.max(0, (int)(this.viewBounds.x / f2));
    int m = Math.min(i, (int)((f2 + (this.viewBounds.x + this.viewBounds.width)) / f2));
    int n = Math.max(0, (int)(this.viewBounds.y / f3));
    int i1 = Math.min(j, (int)((f3 + (this.viewBounds.y + this.viewBounds.height)) / f3));
    float f4 = f3 * i1;
    float f5 = f2 * k;
    float[] arrayOfFloat = this.vertices;
    float f6 = f4;
    int i4;
    for (int i2 = i1; i2 >= n; i2 = i4)
    {
      int i3 = k;
      float f7 = f5;
      if (i3 < m)
      {
        TiledMapTileLayer.Cell localCell = paramTiledMapTileLayer.getCell(i3, i2);
        TextureRegion localTextureRegion;
        if (localCell != null)
        {
          TiledMapTile localTiledMapTile = localCell.getTile();
          if (localTiledMapTile != null)
          {
            boolean bool1 = localCell.getFlipHorizontally();
            boolean bool2 = localCell.getFlipVertically();
            int i5 = localCell.getRotation();
            localTextureRegion = localTiledMapTile.getTextureRegion();
            float f9 = f7 + localTiledMapTile.getOffsetX() * this.unitScale;
            float f10 = f6 + localTiledMapTile.getOffsetY() * this.unitScale;
            float f11 = f9 + localTextureRegion.getRegionWidth() * this.unitScale;
            float f12 = f10 + localTextureRegion.getRegionHeight() * this.unitScale;
            float f13 = localTextureRegion.getU();
            float f14 = localTextureRegion.getV2();
            float f15 = localTextureRegion.getU2();
            float f16 = localTextureRegion.getV();
            arrayOfFloat[0] = f9;
            arrayOfFloat[1] = f10;
            arrayOfFloat[2] = f1;
            arrayOfFloat[3] = f13;
            arrayOfFloat[4] = f14;
            arrayOfFloat[5] = f9;
            arrayOfFloat[6] = f12;
            arrayOfFloat[7] = f1;
            arrayOfFloat[8] = f13;
            arrayOfFloat[9] = f16;
            arrayOfFloat[10] = f11;
            arrayOfFloat[11] = f12;
            arrayOfFloat[12] = f1;
            arrayOfFloat[13] = f15;
            arrayOfFloat[14] = f16;
            arrayOfFloat[15] = f11;
            arrayOfFloat[16] = f10;
            arrayOfFloat[17] = f1;
            arrayOfFloat[18] = f15;
            arrayOfFloat[19] = f14;
            if (bool1)
            {
              float f27 = arrayOfFloat[3];
              arrayOfFloat[3] = arrayOfFloat[13];
              arrayOfFloat[13] = f27;
              float f28 = arrayOfFloat[8];
              arrayOfFloat[8] = arrayOfFloat[18];
              arrayOfFloat[18] = f28;
            }
            if (bool2)
            {
              float f25 = arrayOfFloat[4];
              arrayOfFloat[4] = arrayOfFloat[14];
              arrayOfFloat[14] = f25;
              float f26 = arrayOfFloat[9];
              arrayOfFloat[9] = arrayOfFloat[19];
              arrayOfFloat[19] = f26;
            }
            if (i5 != 0)
              switch (i5)
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
          this.batch.draw(localTextureRegion.getTexture(), arrayOfFloat, 0, 20);
          f7 += f2;
          i3++;
          break;
          float f23 = arrayOfFloat[4];
          arrayOfFloat[4] = arrayOfFloat[9];
          arrayOfFloat[9] = arrayOfFloat[14];
          arrayOfFloat[14] = arrayOfFloat[19];
          arrayOfFloat[19] = f23;
          float f24 = arrayOfFloat[3];
          arrayOfFloat[3] = arrayOfFloat[8];
          arrayOfFloat[8] = arrayOfFloat[13];
          arrayOfFloat[13] = arrayOfFloat[18];
          arrayOfFloat[18] = f24;
          continue;
          float f19 = arrayOfFloat[3];
          arrayOfFloat[3] = arrayOfFloat[13];
          arrayOfFloat[13] = f19;
          float f20 = arrayOfFloat[8];
          arrayOfFloat[8] = arrayOfFloat[18];
          arrayOfFloat[18] = f20;
          float f21 = arrayOfFloat[4];
          arrayOfFloat[4] = arrayOfFloat[14];
          arrayOfFloat[14] = f21;
          float f22 = arrayOfFloat[9];
          arrayOfFloat[9] = arrayOfFloat[19];
          arrayOfFloat[19] = f22;
          continue;
          float f17 = arrayOfFloat[4];
          arrayOfFloat[4] = arrayOfFloat[19];
          arrayOfFloat[19] = arrayOfFloat[14];
          arrayOfFloat[14] = arrayOfFloat[9];
          arrayOfFloat[9] = f17;
          float f18 = arrayOfFloat[3];
          arrayOfFloat[3] = arrayOfFloat[18];
          arrayOfFloat[18] = arrayOfFloat[13];
          arrayOfFloat[13] = arrayOfFloat[8];
          arrayOfFloat[8] = f18;
        }
      }
      float f8 = f6 - f3;
      i4 = i2 - 1;
      f6 = f8;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer
 * JD-Core Version:    0.6.0
 */