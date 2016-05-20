package com.badlogic.gdx.maps.tiled.renderers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Rectangle;

public class IsometricStaggeredTiledMapRenderer extends BatchTiledMapRenderer
{
  public IsometricStaggeredTiledMapRenderer(TiledMap paramTiledMap)
  {
    super(paramTiledMap);
  }

  public IsometricStaggeredTiledMapRenderer(TiledMap paramTiledMap, float paramFloat)
  {
    super(paramTiledMap, paramFloat);
  }

  public IsometricStaggeredTiledMapRenderer(TiledMap paramTiledMap, float paramFloat, Batch paramBatch)
  {
    super(paramTiledMap, paramFloat, paramBatch);
  }

  public IsometricStaggeredTiledMapRenderer(TiledMap paramTiledMap, Batch paramBatch)
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
    float f4 = 0.5F * f2;
    float f5 = 0.5F * f3;
    int k = Math.max(0, (int)((this.viewBounds.x - f4) / f2));
    int m = Math.min(i, (int)((f4 + (f2 + (this.viewBounds.x + this.viewBounds.width))) / f2));
    int n = Math.max(0, (int)((this.viewBounds.y - f3) / f3));
    for (int i1 = -1 + Math.min(j, (int)((f3 + (this.viewBounds.y + this.viewBounds.height)) / f5)); i1 >= n; i1--)
    {
      float f6;
      int i2;
      label211: TextureRegion localTextureRegion;
      if (i1 % 2 == 1)
      {
        f6 = f4;
        i2 = m - 1;
        if (i2 < k)
          continue;
        TiledMapTileLayer.Cell localCell = paramTiledMapTileLayer.getCell(i2, i1);
        if (localCell != null)
        {
          TiledMapTile localTiledMapTile = localCell.getTile();
          if (localTiledMapTile != null)
          {
            boolean bool1 = localCell.getFlipHorizontally();
            boolean bool2 = localCell.getFlipVertically();
            int i3 = localCell.getRotation();
            localTextureRegion = localTiledMapTile.getTextureRegion();
            float f7 = f2 * i2 - f6 + localTiledMapTile.getOffsetX() * this.unitScale;
            float f8 = f5 * i1 + localTiledMapTile.getOffsetY() * this.unitScale;
            float f9 = f7 + localTextureRegion.getRegionWidth() * this.unitScale;
            float f10 = f8 + localTextureRegion.getRegionHeight() * this.unitScale;
            float f11 = localTextureRegion.getU();
            float f12 = localTextureRegion.getV2();
            float f13 = localTextureRegion.getU2();
            float f14 = localTextureRegion.getV();
            this.vertices[0] = f7;
            this.vertices[1] = f8;
            this.vertices[2] = f1;
            this.vertices[3] = f11;
            this.vertices[4] = f12;
            this.vertices[5] = f7;
            this.vertices[6] = f10;
            this.vertices[7] = f1;
            this.vertices[8] = f11;
            this.vertices[9] = f14;
            this.vertices[10] = f9;
            this.vertices[11] = f10;
            this.vertices[12] = f1;
            this.vertices[13] = f13;
            this.vertices[14] = f14;
            this.vertices[15] = f9;
            this.vertices[16] = f8;
            this.vertices[17] = f1;
            this.vertices[18] = f13;
            this.vertices[19] = f12;
            if (bool1)
            {
              float f25 = this.vertices[3];
              this.vertices[3] = this.vertices[13];
              this.vertices[13] = f25;
              float f26 = this.vertices[8];
              this.vertices[8] = this.vertices[18];
              this.vertices[18] = f26;
            }
            if (bool2)
            {
              float f23 = this.vertices[4];
              this.vertices[4] = this.vertices[14];
              this.vertices[14] = f23;
              float f24 = this.vertices[9];
              this.vertices[9] = this.vertices[19];
              this.vertices[19] = f24;
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
      }
      while (true)
      {
        this.batch.draw(localTextureRegion.getTexture(), this.vertices, 0, 20);
        i2--;
        break label211;
        f6 = 0.0F;
        break;
        float f21 = this.vertices[4];
        this.vertices[4] = this.vertices[9];
        this.vertices[9] = this.vertices[14];
        this.vertices[14] = this.vertices[19];
        this.vertices[19] = f21;
        float f22 = this.vertices[3];
        this.vertices[3] = this.vertices[8];
        this.vertices[8] = this.vertices[13];
        this.vertices[13] = this.vertices[18];
        this.vertices[18] = f22;
        continue;
        float f17 = this.vertices[3];
        this.vertices[3] = this.vertices[13];
        this.vertices[13] = f17;
        float f18 = this.vertices[8];
        this.vertices[8] = this.vertices[18];
        this.vertices[18] = f18;
        float f19 = this.vertices[4];
        this.vertices[4] = this.vertices[14];
        this.vertices[14] = f19;
        float f20 = this.vertices[9];
        this.vertices[9] = this.vertices[19];
        this.vertices[19] = f20;
        continue;
        float f15 = this.vertices[4];
        this.vertices[4] = this.vertices[19];
        this.vertices[19] = this.vertices[14];
        this.vertices[14] = this.vertices[9];
        this.vertices[9] = f15;
        float f16 = this.vertices[3];
        this.vertices[3] = this.vertices[18];
        this.vertices[18] = this.vertices[13];
        this.vertices[13] = this.vertices[8];
        this.vertices[8] = f16;
      }
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.tiled.renderers.IsometricStaggeredTiledMapRenderer
 * JD-Core Version:    0.6.0
 */