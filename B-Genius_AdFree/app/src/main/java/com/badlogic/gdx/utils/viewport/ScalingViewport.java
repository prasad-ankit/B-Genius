package com.badlogic.gdx.utils.viewport;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Scaling;

public class ScalingViewport extends Viewport
{
  private Scaling scaling;

  public ScalingViewport(Scaling paramScaling, float paramFloat1, float paramFloat2)
  {
    this(paramScaling, paramFloat1, paramFloat2, new OrthographicCamera());
  }

  public ScalingViewport(Scaling paramScaling, float paramFloat1, float paramFloat2, Camera paramCamera)
  {
    this.scaling = paramScaling;
    setWorldSize(paramFloat1, paramFloat2);
    setCamera(paramCamera);
  }

  public Scaling getScaling()
  {
    return this.scaling;
  }

  public void setScaling(Scaling paramScaling)
  {
    this.scaling = paramScaling;
  }

  public void update(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Vector2 localVector2 = this.scaling.apply(getWorldWidth(), getWorldHeight(), paramInt1, paramInt2);
    int i = Math.round(localVector2.x);
    int j = Math.round(localVector2.y);
    setScreenBounds((paramInt1 - i) / 2, (paramInt2 - j) / 2, i, j);
    apply(paramBoolean);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.viewport.ScalingViewport
 * JD-Core Version:    0.6.0
 */