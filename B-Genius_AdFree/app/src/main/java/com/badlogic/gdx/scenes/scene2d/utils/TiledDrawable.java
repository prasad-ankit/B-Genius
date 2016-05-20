package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TiledDrawable extends TextureRegionDrawable
{
  public TiledDrawable()
  {
  }

  public TiledDrawable(TextureRegion paramTextureRegion)
  {
    super(paramTextureRegion);
  }

  public TiledDrawable(TextureRegionDrawable paramTextureRegionDrawable)
  {
    super(paramTextureRegionDrawable);
  }

  public void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    TextureRegion localTextureRegion = getRegion();
    float f1 = localTextureRegion.getRegionWidth();
    float f2 = localTextureRegion.getRegionHeight();
    int i = (int)(paramFloat3 / f1);
    int j = (int)(paramFloat4 / f2);
    float f3 = paramFloat3 - f1 * i;
    float f4 = paramFloat4 - f2 * j;
    int k = 0;
    float f5 = paramFloat2;
    float f6 = paramFloat1;
    while (k < i)
    {
      int i1 = 0;
      float f15 = paramFloat2;
      while (i1 < j)
      {
        paramBatch.draw(localTextureRegion, f6, f15, f1, f2);
        f15 += f2;
        i1++;
      }
      f6 += f1;
      k++;
      f5 = f15;
    }
    Texture localTexture = localTextureRegion.getTexture();
    float f7 = localTextureRegion.getU();
    float f8 = localTextureRegion.getV2();
    if (f3 > 0.0F)
    {
      float f12 = f7 + f3 / localTexture.getWidth();
      float f13 = localTextureRegion.getV();
      int n = 0;
      f5 = paramFloat2;
      while (n < j)
      {
        paramBatch.draw(localTexture, f6, f5, f3, f2, f7, f8, f12, f13);
        f5 += f2;
        n++;
      }
      if (f4 > 0.0F)
      {
        float f14 = f8 - f4 / localTexture.getHeight();
        paramBatch.draw(localTexture, f6, f5, f3, f4, f7, f8, f12, f14);
      }
    }
    if (f4 > 0.0F)
    {
      float f9 = localTextureRegion.getU2();
      float f10 = f8 - f4 / localTexture.getHeight();
      int m = 0;
      float f11 = paramFloat1;
      while (m < i)
      {
        paramBatch.draw(localTexture, f11, f5, f1, f4, f7, f8, f9, f10);
        f11 += f1;
        m++;
      }
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable
 * JD-Core Version:    0.6.0
 */