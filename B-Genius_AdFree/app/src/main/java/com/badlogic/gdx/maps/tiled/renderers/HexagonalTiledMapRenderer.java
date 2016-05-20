package com.badlogic.gdx.maps.tiled.renderers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.tiles.AnimatedTiledMapTile;
import com.badlogic.gdx.math.Rectangle;

public class HexagonalTiledMapRenderer extends BatchTiledMapRenderer
{
  public HexagonalTiledMapRenderer(TiledMap paramTiledMap)
  {
    super(paramTiledMap);
  }

  public HexagonalTiledMapRenderer(TiledMap paramTiledMap, float paramFloat)
  {
    super(paramTiledMap, paramFloat);
  }

  public HexagonalTiledMapRenderer(TiledMap paramTiledMap, float paramFloat, Batch paramBatch)
  {
    super(paramTiledMap, paramFloat, paramBatch);
  }

  public HexagonalTiledMapRenderer(TiledMap paramTiledMap, Batch paramBatch)
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
    float f4 = 0.25F * f2;
    float f5 = f2 * 0.75F;
    float f6 = 0.5F * f3;
    float f7 = 1.5F * f3;
    int k = Math.max(0, (int)((this.viewBounds.x - f4) / f5));
    int m = Math.min(i, (int)((f5 + (this.viewBounds.x + this.viewBounds.width)) / f5));
    int n = Math.max(0, (int)(this.viewBounds.y / f7));
    int i1 = Math.min(j, (int)((f7 + (this.viewBounds.y + this.viewBounds.height)) / f3));
    float[] arrayOfFloat = this.vertices;
    int i2 = n;
    if (i2 < i1)
      label771: for (int i3 = k; ; i3++)
      {
        float f8;
        float f9;
        if (i3 < m)
        {
          f8 = f5 * i3;
          if (i3 % 2 != 1)
            break label745;
          f9 = 0.0F;
        }
        TextureRegion localTextureRegion;
        while (true)
        {
          float f10 = f9 + f3 * i2;
          TiledMapTileLayer.Cell localCell = paramTiledMapTileLayer.getCell(i3, i2);
          if (localCell == null)
            break label771;
          TiledMapTile localTiledMapTile = localCell.getTile();
          if ((localTiledMapTile == null) || ((localTiledMapTile instanceof AnimatedTiledMapTile)))
            break label771;
          boolean bool1 = localCell.getFlipHorizontally();
          boolean bool2 = localCell.getFlipVertically();
          int i4 = localCell.getRotation();
          localTextureRegion = localTiledMapTile.getTextureRegion();
          float f11 = f8 + localTiledMapTile.getOffsetX() * this.unitScale;
          float f12 = f10 + localTiledMapTile.getOffsetY() * this.unitScale;
          float f13 = f11 + localTextureRegion.getRegionWidth() * this.unitScale;
          float f14 = f12 + localTextureRegion.getRegionHeight() * this.unitScale;
          float f15 = localTextureRegion.getU();
          float f16 = localTextureRegion.getV2();
          float f17 = localTextureRegion.getU2();
          float f18 = localTextureRegion.getV();
          arrayOfFloat[0] = f11;
          arrayOfFloat[1] = f12;
          arrayOfFloat[2] = f1;
          arrayOfFloat[3] = f15;
          arrayOfFloat[4] = f16;
          arrayOfFloat[5] = f11;
          arrayOfFloat[6] = f14;
          arrayOfFloat[7] = f1;
          arrayOfFloat[8] = f15;
          arrayOfFloat[9] = f18;
          arrayOfFloat[10] = f13;
          arrayOfFloat[11] = f14;
          arrayOfFloat[12] = f1;
          arrayOfFloat[13] = f17;
          arrayOfFloat[14] = f18;
          arrayOfFloat[15] = f13;
          arrayOfFloat[16] = f12;
          arrayOfFloat[17] = f1;
          arrayOfFloat[18] = f17;
          arrayOfFloat[19] = f16;
          if (bool1)
          {
            float f25 = arrayOfFloat[3];
            arrayOfFloat[3] = arrayOfFloat[13];
            arrayOfFloat[13] = f25;
            float f26 = arrayOfFloat[8];
            arrayOfFloat[8] = arrayOfFloat[18];
            arrayOfFloat[18] = f26;
          }
          if (bool2)
          {
            float f23 = arrayOfFloat[4];
            arrayOfFloat[4] = arrayOfFloat[14];
            arrayOfFloat[14] = f23;
            float f24 = arrayOfFloat[9];
            arrayOfFloat[9] = arrayOfFloat[19];
            arrayOfFloat[19] = f24;
          }
          if (i4 != 2)
            break label752;
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
          i2++;
          break;
          label745: f9 = f6;
        }
        label752: this.batch.draw(localTextureRegion.getTexture(), arrayOfFloat, 0, 20);
      }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.tiled.renderers.HexagonalTiledMapRenderer
 * JD-Core Version:    0.6.0
 */