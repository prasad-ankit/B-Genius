package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Matrix4;

public abstract interface ImmediateModeRenderer
{
  public abstract void begin(Matrix4 paramMatrix4, int paramInt);

  public abstract void color(float paramFloat);

  public abstract void color(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);

  public abstract void color(Color paramColor);

  public abstract void dispose();

  public abstract void end();

  public abstract void flush();

  public abstract int getMaxVertices();

  public abstract int getNumVertices();

  public abstract void normal(float paramFloat1, float paramFloat2, float paramFloat3);

  public abstract void texCoord(float paramFloat1, float paramFloat2);

  public abstract void vertex(float paramFloat1, float paramFloat2, float paramFloat3);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer
 * JD-Core Version:    0.6.0
 */