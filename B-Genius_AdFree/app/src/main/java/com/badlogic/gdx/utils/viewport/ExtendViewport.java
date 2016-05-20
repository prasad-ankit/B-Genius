package com.badlogic.gdx.utils.viewport;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Scaling;

public class ExtendViewport extends Viewport
{
  private float maxWorldHeight;
  private float maxWorldWidth;
  private float minWorldHeight;
  private float minWorldWidth;

  public ExtendViewport(float paramFloat1, float paramFloat2)
  {
    this(paramFloat1, paramFloat2, 0.0F, 0.0F, new OrthographicCamera());
  }

  public ExtendViewport(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this(paramFloat1, paramFloat2, paramFloat3, paramFloat4, new OrthographicCamera());
  }

  public ExtendViewport(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Camera paramCamera)
  {
    this.minWorldWidth = paramFloat1;
    this.minWorldHeight = paramFloat2;
    this.maxWorldWidth = paramFloat3;
    this.maxWorldHeight = paramFloat4;
    setCamera(paramCamera);
  }

  public ExtendViewport(float paramFloat1, float paramFloat2, Camera paramCamera)
  {
    this(paramFloat1, paramFloat2, 0.0F, 0.0F, paramCamera);
  }

  public float getMaxWorldHeight()
  {
    return this.maxWorldHeight;
  }

  public float getMaxWorldWidth()
  {
    return this.maxWorldWidth;
  }

  public float getMinWorldHeight()
  {
    return this.minWorldHeight;
  }

  public float getMinWorldWidth()
  {
    return this.minWorldWidth;
  }

  public void setMaxWorldHeight(float paramFloat)
  {
    this.maxWorldHeight = paramFloat;
  }

  public void setMaxWorldWidth(float paramFloat)
  {
    this.maxWorldWidth = paramFloat;
  }

  public void setMinWorldHeight(float paramFloat)
  {
    this.minWorldHeight = paramFloat;
  }

  public void setMinWorldWidth(float paramFloat)
  {
    this.minWorldWidth = paramFloat;
  }

  public void update(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    float f1 = this.minWorldWidth;
    float f2 = this.minWorldHeight;
    Vector2 localVector2 = Scaling.fit.apply(f1, f2, paramInt1, paramInt2);
    int i = Math.round(localVector2.x);
    int j = Math.round(localVector2.y);
    int k;
    int m;
    float f3;
    float f4;
    if (i < paramInt1)
    {
      float f8 = j / f2;
      float f9 = f2 / j * (paramInt1 - i);
      if (this.maxWorldWidth > 0.0F)
        f9 = Math.min(f9, this.maxWorldWidth - this.minWorldWidth);
      float f10 = f1 + f9;
      k = i + Math.round(f9 * f8);
      m = j;
      f3 = f2;
      f4 = f10;
    }
    while (true)
    {
      setWorldSize(f4, f3);
      setScreenBounds((paramInt1 - k) / 2, (paramInt2 - m) / 2, k, m);
      apply(paramBoolean);
      return;
      if (j < paramInt2)
      {
        float f5 = i / f1;
        float f6 = f1 / i * (paramInt2 - j);
        if (this.maxWorldHeight > 0.0F)
          f6 = Math.min(f6, this.maxWorldHeight - this.minWorldHeight);
        float f7 = f2 + f6;
        int n = j + Math.round(f6 * f5);
        f3 = f7;
        f4 = f1;
        m = n;
        k = i;
        continue;
      }
      k = i;
      m = j;
      f3 = f2;
      f4 = f1;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.viewport.ExtendViewport
 * JD-Core Version:    0.6.0
 */