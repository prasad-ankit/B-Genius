package com.badlogic.gdx.utils.viewport;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.utils.Scaling;

public class StretchViewport extends ScalingViewport
{
  public StretchViewport(float paramFloat1, float paramFloat2)
  {
    super(Scaling.stretch, paramFloat1, paramFloat2);
  }

  public StretchViewport(float paramFloat1, float paramFloat2, Camera paramCamera)
  {
    super(Scaling.stretch, paramFloat1, paramFloat2, paramCamera);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.viewport.StretchViewport
 * JD-Core Version:    0.6.0
 */