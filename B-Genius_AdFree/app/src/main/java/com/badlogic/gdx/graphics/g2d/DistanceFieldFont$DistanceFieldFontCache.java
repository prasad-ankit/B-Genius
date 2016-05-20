package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.glutils.ShaderProgram;

class DistanceFieldFont$DistanceFieldFontCache extends BitmapFontCache
{
  public DistanceFieldFont$DistanceFieldFontCache(DistanceFieldFont paramDistanceFieldFont)
  {
    super(paramDistanceFieldFont, paramDistanceFieldFont.usesIntegerPositions());
  }

  public DistanceFieldFont$DistanceFieldFontCache(DistanceFieldFont paramDistanceFieldFont, boolean paramBoolean)
  {
    super(paramDistanceFieldFont, paramBoolean);
  }

  private float getSmoothingFactor()
  {
    DistanceFieldFont localDistanceFieldFont = (DistanceFieldFont)super.getFont();
    return localDistanceFieldFont.getDistanceFieldSmoothing() * localDistanceFieldFont.getScaleX();
  }

  private void setSmoothingUniform(Batch paramBatch, float paramFloat)
  {
    paramBatch.flush();
    paramBatch.getShader().setUniformf("u_smoothing", paramFloat);
  }

  public void draw(Batch paramBatch)
  {
    setSmoothingUniform(paramBatch, getSmoothingFactor());
    super.draw(paramBatch);
    setSmoothingUniform(paramBatch, 0.0F);
  }

  public void draw(Batch paramBatch, int paramInt1, int paramInt2)
  {
    setSmoothingUniform(paramBatch, getSmoothingFactor());
    super.draw(paramBatch, paramInt1, paramInt2);
    setSmoothingUniform(paramBatch, 0.0F);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g2d.DistanceFieldFont.DistanceFieldFontCache
 * JD-Core Version:    0.6.0
 */