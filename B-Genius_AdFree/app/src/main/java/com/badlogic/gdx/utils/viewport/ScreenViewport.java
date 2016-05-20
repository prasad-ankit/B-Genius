package com.badlogic.gdx.utils.viewport;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class ScreenViewport extends Viewport
{
  private float unitsPerPixel = 1.0F;

  public ScreenViewport()
  {
    this(new OrthographicCamera());
  }

  public ScreenViewport(Camera paramCamera)
  {
    setCamera(paramCamera);
  }

  public float getUnitsPerPixel()
  {
    return this.unitsPerPixel;
  }

  public void setUnitsPerPixel(float paramFloat)
  {
    this.unitsPerPixel = paramFloat;
  }

  public void update(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    setScreenBounds(0, 0, paramInt1, paramInt2);
    setWorldSize(paramInt1 * this.unitsPerPixel, paramInt2 * this.unitsPerPixel);
    apply(paramBoolean);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.viewport.ScreenViewport
 * JD-Core Version:    0.6.0
 */