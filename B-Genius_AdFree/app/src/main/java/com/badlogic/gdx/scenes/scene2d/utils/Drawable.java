package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.graphics.g2d.Batch;

public abstract interface Drawable
{
  public abstract void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);

  public abstract float getBottomHeight();

  public abstract float getLeftWidth();

  public abstract float getMinHeight();

  public abstract float getMinWidth();

  public abstract float getRightWidth();

  public abstract float getTopHeight();

  public abstract void setBottomHeight(float paramFloat);

  public abstract void setLeftWidth(float paramFloat);

  public abstract void setMinHeight(float paramFloat);

  public abstract void setMinWidth(float paramFloat);

  public abstract void setRightWidth(float paramFloat);

  public abstract void setTopHeight(float paramFloat);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.utils.Drawable
 * JD-Core Version:    0.6.0
 */