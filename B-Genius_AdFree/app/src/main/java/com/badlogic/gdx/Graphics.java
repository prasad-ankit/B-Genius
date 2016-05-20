package com.badlogic.gdx;

import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Pixmap;

public abstract interface Graphics
{
  public abstract Graphics.BufferFormat getBufferFormat();

  public abstract float getDeltaTime();

  public abstract float getDensity();

  public abstract Graphics.DisplayMode getDesktopDisplayMode();

  public abstract Graphics.DisplayMode[] getDisplayModes();

  public abstract long getFrameId();

  public abstract int getFramesPerSecond();

  public abstract GL20 getGL20();

  public abstract GL30 getGL30();

  public abstract int getHeight();

  public abstract float getPpcX();

  public abstract float getPpcY();

  public abstract float getPpiX();

  public abstract float getPpiY();

  public abstract float getRawDeltaTime();

  public abstract Graphics.GraphicsType getType();

  public abstract int getWidth();

  public abstract boolean isContinuousRendering();

  public abstract boolean isFullscreen();

  public abstract boolean isGL30Available();

  public abstract Cursor newCursor(Pixmap paramPixmap, int paramInt1, int paramInt2);

  public abstract void requestRendering();

  public abstract void setContinuousRendering(boolean paramBoolean);

  public abstract void setCursor(Cursor paramCursor);

  public abstract boolean setDisplayMode(int paramInt1, int paramInt2, boolean paramBoolean);

  public abstract boolean setDisplayMode(Graphics.DisplayMode paramDisplayMode);

  public abstract void setTitle(String paramString);

  public abstract void setVSync(boolean paramBoolean);

  public abstract boolean supportsDisplayModeChange();

  public abstract boolean supportsExtension(String paramString);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.Graphics
 * JD-Core Version:    0.6.0
 */