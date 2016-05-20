package com.badlogic.gdx.utils.viewport;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.utils.Scaling;

public class FillViewport extends ScalingViewport
{
  public FillViewport(float paramFloat1, float paramFloat2)
  {
    super(Scaling.fill, paramFloat1, paramFloat2);
  }

  public FillViewport(float paramFloat1, float paramFloat2, Camera paramCamera)
  {
    super(Scaling.fill, paramFloat1, paramFloat2, paramCamera);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.viewport.FillViewport
 * JD-Core Version:    0.6.0
 */