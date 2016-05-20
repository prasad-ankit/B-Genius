package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.reflect.ClassReflection;

public class BaseDrawable
  implements Drawable
{
  private float bottomHeight;
  private float leftWidth;
  private float minHeight;
  private float minWidth;
  private String name;
  private float rightWidth;
  private float topHeight;

  public BaseDrawable()
  {
  }

  public BaseDrawable(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BaseDrawable))
      this.name = ((BaseDrawable)paramDrawable).getName();
    this.leftWidth = paramDrawable.getLeftWidth();
    this.rightWidth = paramDrawable.getRightWidth();
    this.topHeight = paramDrawable.getTopHeight();
    this.bottomHeight = paramDrawable.getBottomHeight();
    this.minWidth = paramDrawable.getMinWidth();
    this.minHeight = paramDrawable.getMinHeight();
  }

  public void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
  }

  public float getBottomHeight()
  {
    return this.bottomHeight;
  }

  public float getLeftWidth()
  {
    return this.leftWidth;
  }

  public float getMinHeight()
  {
    return this.minHeight;
  }

  public float getMinWidth()
  {
    return this.minWidth;
  }

  public String getName()
  {
    return this.name;
  }

  public float getRightWidth()
  {
    return this.rightWidth;
  }

  public float getTopHeight()
  {
    return this.topHeight;
  }

  public void setBottomHeight(float paramFloat)
  {
    this.bottomHeight = paramFloat;
  }

  public void setLeftWidth(float paramFloat)
  {
    this.leftWidth = paramFloat;
  }

  public void setMinHeight(float paramFloat)
  {
    this.minHeight = paramFloat;
  }

  public void setMinWidth(float paramFloat)
  {
    this.minWidth = paramFloat;
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }

  public void setRightWidth(float paramFloat)
  {
    this.rightWidth = paramFloat;
  }

  public void setTopHeight(float paramFloat)
  {
    this.topHeight = paramFloat;
  }

  public String toString()
  {
    if (this.name == null)
      return ClassReflection.getSimpleName(getClass());
    return this.name;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable
 * JD-Core Version:    0.6.0
 */