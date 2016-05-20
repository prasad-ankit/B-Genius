package com.badlogic.gdx.scenes.scene2d.utils;

public abstract interface Layout
{
  public abstract float getMaxHeight();

  public abstract float getMaxWidth();

  public abstract float getMinHeight();

  public abstract float getMinWidth();

  public abstract float getPrefHeight();

  public abstract float getPrefWidth();

  public abstract void invalidate();

  public abstract void invalidateHierarchy();

  public abstract void layout();

  public abstract void pack();

  public abstract void setFillParent(boolean paramBoolean);

  public abstract void setLayoutEnabled(boolean paramBoolean);

  public abstract void validate();
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.utils.Layout
 * JD-Core Version:    0.6.0
 */