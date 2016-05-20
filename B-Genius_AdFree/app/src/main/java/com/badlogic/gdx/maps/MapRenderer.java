package com.badlogic.gdx.maps;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Matrix4;

public abstract interface MapRenderer
{
  public abstract void render();

  public abstract void render(int[] paramArrayOfInt);

  public abstract void setView(OrthographicCamera paramOrthographicCamera);

  public abstract void setView(Matrix4 paramMatrix4, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.MapRenderer
 * JD-Core Version:    0.6.0
 */