package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.NinePatch;

public class NinePatchDrawable extends BaseDrawable
{
  private NinePatch patch;

  public NinePatchDrawable()
  {
  }

  public NinePatchDrawable(NinePatch paramNinePatch)
  {
    setPatch(paramNinePatch);
  }

  public NinePatchDrawable(NinePatchDrawable paramNinePatchDrawable)
  {
    super(paramNinePatchDrawable);
    setPatch(paramNinePatchDrawable.patch);
  }

  public void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.patch.draw(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }

  public NinePatch getPatch()
  {
    return this.patch;
  }

  public void setPatch(NinePatch paramNinePatch)
  {
    this.patch = paramNinePatch;
    setMinWidth(paramNinePatch.getTotalWidth());
    setMinHeight(paramNinePatch.getTotalHeight());
    setTopHeight(paramNinePatch.getPadTop());
    setRightWidth(paramNinePatch.getPadRight());
    setBottomHeight(paramNinePatch.getPadBottom());
    setLeftWidth(paramNinePatch.getPadLeft());
  }

  public NinePatchDrawable tint(Color paramColor)
  {
    NinePatchDrawable localNinePatchDrawable = new NinePatchDrawable(this);
    localNinePatchDrawable.setPatch(new NinePatch(localNinePatchDrawable.getPatch(), paramColor));
    return localNinePatchDrawable;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable
 * JD-Core Version:    0.6.0
 */