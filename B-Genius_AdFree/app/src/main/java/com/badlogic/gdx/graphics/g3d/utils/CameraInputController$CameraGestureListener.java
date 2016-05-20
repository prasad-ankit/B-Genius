package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.input.GestureDetector.GestureAdapter;
import com.badlogic.gdx.math.Vector2;

public class CameraInputController$CameraGestureListener extends GestureDetector.GestureAdapter
{
  public CameraInputController controller;
  private float previousZoom;

  public boolean fling(float paramFloat1, float paramFloat2, int paramInt)
  {
    return false;
  }

  public boolean longPress(float paramFloat1, float paramFloat2)
  {
    return false;
  }

  public boolean pan(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return false;
  }

  public boolean pinch(Vector2 paramVector21, Vector2 paramVector22, Vector2 paramVector23, Vector2 paramVector24)
  {
    return false;
  }

  public boolean tap(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    return false;
  }

  public boolean touchDown(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.previousZoom = 0.0F;
    return false;
  }

  public boolean zoom(float paramFloat1, float paramFloat2)
  {
    float f1 = paramFloat2 - paramFloat1;
    float f2 = f1 - this.previousZoom;
    this.previousZoom = f1;
    float f3 = Gdx.graphics.getWidth();
    float f4 = Gdx.graphics.getHeight();
    CameraInputController localCameraInputController = this.controller;
    if (f3 > f4);
    while (true)
    {
      return localCameraInputController.pinchZoom(f2 / f4);
      f4 = f3;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.utils.CameraInputController.CameraGestureListener
 * JD-Core Version:    0.6.0
 */