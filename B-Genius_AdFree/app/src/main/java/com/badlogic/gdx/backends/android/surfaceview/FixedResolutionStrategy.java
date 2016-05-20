package com.badlogic.gdx.backends.android.surfaceview;

public class FixedResolutionStrategy
  implements ResolutionStrategy
{
  private final int height;
  private final int width;

  public FixedResolutionStrategy(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }

  public ResolutionStrategy.MeasuredDimension calcMeasures(int paramInt1, int paramInt2)
  {
    return new ResolutionStrategy.MeasuredDimension(this.width, this.height);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.surfaceview.FixedResolutionStrategy
 * JD-Core Version:    0.6.0
 */