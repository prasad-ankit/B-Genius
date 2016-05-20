package com.badlogic.gdx.maps.tiled.renderers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class IsometricTiledMapRenderer extends BatchTiledMapRenderer
{
  private Vector2 bottomLeft = new Vector2();
  private Vector2 bottomRight = new Vector2();
  private Matrix4 invIsotransform;
  private Matrix4 isoTransform;
  private Vector3 screenPos = new Vector3();
  private Vector2 topLeft = new Vector2();
  private Vector2 topRight = new Vector2();

  public IsometricTiledMapRenderer(TiledMap paramTiledMap)
  {
    super(paramTiledMap);
    init();
  }

  public IsometricTiledMapRenderer(TiledMap paramTiledMap, float paramFloat)
  {
    super(paramTiledMap, paramFloat);
    init();
  }

  public IsometricTiledMapRenderer(TiledMap paramTiledMap, float paramFloat, Batch paramBatch)
  {
    super(paramTiledMap, paramFloat, paramBatch);
    init();
  }

  public IsometricTiledMapRenderer(TiledMap paramTiledMap, Batch paramBatch)
  {
    super(paramTiledMap, paramBatch);
    init();
  }

  private void init()
  {
    this.isoTransform = new Matrix4();
    this.isoTransform.idt();
    this.isoTransform.scale((float)(Math.sqrt(2.0D) / 2.0D), (float)(Math.sqrt(2.0D) / 4.0D), 1.0F);
    this.isoTransform.rotate(0.0F, 0.0F, 1.0F, -45.0F);
    this.invIsotransform = new Matrix4(this.isoTransform);
    this.invIsotransform.inv();
  }

  private Vector3 translateScreenToIso(Vector2 paramVector2)
  {
    this.screenPos.set(paramVector2.x, paramVector2.y, 0.0F);
    this.screenPos.mul(this.invIsotransform);
    return this.screenPos;
  }

  public void renderTileLayer(TiledMapTileLayer paramTiledMapTileLayer)
  {
    Color localColor = this.batch.getColor();
    float f1 = Color.toFloatBits(localColor.r, localColor.g, localColor.b, localColor.a * paramTiledMapTileLayer.getOpacity());
    float f2 = paramTiledMapTileLayer.getTileWidth() * this.unitScale;
    float f3 = paramTiledMapTileLayer.getTileHeight() * this.unitScale;
    float f4 = f2 * 0.5F;
    float f5 = f3 * 0.5F;
    this.topRight.set(this.viewBounds.x + this.viewBounds.width, this.viewBounds.y);
    this.bottomLeft.set(this.viewBounds.x, this.viewBounds.y + this.viewBounds.height);
    this.topLeft.set(this.viewBounds.x, this.viewBounds.y);
    this.bottomRight.set(this.viewBounds.x + this.viewBounds.width, this.viewBounds.y + this.viewBounds.height);
    int i = -2 + (int)(translateScreenToIso(this.topLeft).y / f2);
    int j = 2 + (int)(translateScreenToIso(this.bottomRight).y / f2);
    int k = -2 + (int)(translateScreenToIso(this.bottomLeft).x / f2);
    int m = 2 + (int)(translateScreenToIso(this.topRight).x / f2);
    for (int n = j; n >= i; n--)
    {
      int i1 = k;
      if (i1 > m)
        continue;
      float f6 = f4 * i1 + f4 * n;
      float f7 = f5 * n - f5 * i1;
      TiledMapTileLayer.Cell localCell = paramTiledMapTileLayer.getCell(i1, n);
      TextureRegion localTextureRegion;
      if (localCell != null)
      {
        TiledMapTile localTiledMapTile = localCell.getTile();
        if (localTiledMapTile != null)
        {
          boolean bool1 = localCell.getFlipHorizontally();
          boolean bool2 = localCell.getFlipVertically();
          int i2 = localCell.getRotation();
          localTextureRegion = localTiledMapTile.getTextureRegion();
          float f8 = f6 + localTiledMapTile.getOffsetX() * this.unitScale;
          float f9 = f7 + localTiledMapTile.getOffsetY() * this.unitScale;
          float f10 = f8 + localTextureRegion.getRegionWidth() * this.unitScale;
          float f11 = f9 + localTextureRegion.getRegionHeight() * this.unitScale;
          float f12 = localTextureRegion.getU();
          float f13 = localTextureRegion.getV2();
          float f14 = localTextureRegion.getU2();
          float f15 = localTextureRegion.getV();
          this.vertices[0] = f8;
          this.vertices[1] = f9;
          this.vertices[2] = f1;
          this.vertices[3] = f12;
          this.vertices[4] = f13;
          this.vertices[5] = f8;
          this.vertices[6] = f11;
          this.vertices[7] = f1;
          this.vertices[8] = f12;
          this.vertices[9] = f15;
          this.vertices[10] = f10;
          this.vertices[11] = f11;
          this.vertices[12] = f1;
          this.vertices[13] = f14;
          this.vertices[14] = f15;
          this.vertices[15] = f10;
          this.vertices[16] = f9;
          this.vertices[17] = f1;
          this.vertices[18] = f14;
          this.vertices[19] = f13;
          if (bool1)
          {
            float f26 = this.vertices[3];
            this.vertices[3] = this.vertices[13];
            this.vertices[13] = f26;
            float f27 = this.vertices[8];
            this.vertices[8] = this.vertices[18];
            this.vertices[18] = f27;
          }
          if (bool2)
          {
            float f24 = this.vertices[4];
            this.vertices[4] = this.vertices[14];
            this.vertices[14] = f24;
            float f25 = this.vertices[9];
            this.vertices[9] = this.vertices[19];
            this.vertices[19] = f25;
          }
          if (i2 != 0)
            switch (i2)
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
        this.batch.draw(localTextureRegion.getTexture(), this.vertices, 0, 20);
        i1++;
        break;
        float f22 = this.vertices[4];
        this.vertices[4] = this.vertices[9];
        this.vertices[9] = this.vertices[14];
        this.vertices[14] = this.vertices[19];
        this.vertices[19] = f22;
        float f23 = this.vertices[3];
        this.vertices[3] = this.vertices[8];
        this.vertices[8] = this.vertices[13];
        this.vertices[13] = this.vertices[18];
        this.vertices[18] = f23;
        continue;
        float f18 = this.vertices[3];
        this.vertices[3] = this.vertices[13];
        this.vertices[13] = f18;
        float f19 = this.vertices[8];
        this.vertices[8] = this.vertices[18];
        this.vertices[18] = f19;
        float f20 = this.vertices[4];
        this.vertices[4] = this.vertices[14];
        this.vertices[14] = f20;
        float f21 = this.vertices[9];
        this.vertices[9] = this.vertices[19];
        this.vertices[19] = f21;
        continue;
        float f16 = this.vertices[4];
        this.vertices[4] = this.vertices[19];
        this.vertices[19] = this.vertices[14];
        this.vertices[14] = this.vertices[9];
        this.vertices[9] = f16;
        float f17 = this.vertices[3];
        this.vertices[3] = this.vertices[18];
        this.vertices[18] = this.vertices[13];
        this.vertices[13] = this.vertices[8];
        this.vertices[8] = f17;
      }
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer
 * JD-Core Version:    0.6.0
 */