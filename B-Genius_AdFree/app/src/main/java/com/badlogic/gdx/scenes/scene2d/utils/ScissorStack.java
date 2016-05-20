package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

public class ScissorStack
{
  private static Array scissors = new Array();
  static Vector3 tmp = new Vector3();
  static final Rectangle viewport = new Rectangle();

  public static void calculateScissors(Camera paramCamera, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Matrix4 paramMatrix4, Rectangle paramRectangle1, Rectangle paramRectangle2)
  {
    tmp.set(paramRectangle1.x, paramRectangle1.y, 0.0F);
    tmp.mul(paramMatrix4);
    paramCamera.project(tmp, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    paramRectangle2.x = tmp.x;
    paramRectangle2.y = tmp.y;
    tmp.set(paramRectangle1.x + paramRectangle1.width, paramRectangle1.y + paramRectangle1.height, 0.0F);
    tmp.mul(paramMatrix4);
    paramCamera.project(tmp, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    paramRectangle2.width = (tmp.x - paramRectangle2.x);
    paramRectangle2.height = (tmp.y - paramRectangle2.y);
  }

  public static void calculateScissors(Camera paramCamera, Matrix4 paramMatrix4, Rectangle paramRectangle1, Rectangle paramRectangle2)
  {
    calculateScissors(paramCamera, 0.0F, 0.0F, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), paramMatrix4, paramRectangle1, paramRectangle2);
  }

  private static void fix(Rectangle paramRectangle)
  {
    paramRectangle.x = Math.round(paramRectangle.x);
    paramRectangle.y = Math.round(paramRectangle.y);
    paramRectangle.width = Math.round(paramRectangle.width);
    paramRectangle.height = Math.round(paramRectangle.height);
    if (paramRectangle.width < 0.0F)
    {
      paramRectangle.width = (-paramRectangle.width);
      paramRectangle.x -= paramRectangle.width;
    }
    if (paramRectangle.height < 0.0F)
    {
      paramRectangle.height = (-paramRectangle.height);
      paramRectangle.y -= paramRectangle.height;
    }
  }

  public static Rectangle getViewport()
  {
    if (scissors.size == 0)
    {
      viewport.set(0.0F, 0.0F, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
      return viewport;
    }
    Rectangle localRectangle = (Rectangle)scissors.peek();
    viewport.set(localRectangle);
    return viewport;
  }

  public static Rectangle peekScissors()
  {
    return (Rectangle)scissors.peek();
  }

  public static Rectangle popScissors()
  {
    Rectangle localRectangle1 = (Rectangle)scissors.pop();
    if (scissors.size == 0)
    {
      Gdx.gl.glDisable(3089);
      return localRectangle1;
    }
    Rectangle localRectangle2 = (Rectangle)scissors.peek();
    Gdx.gl.glScissor((int)localRectangle2.x, (int)localRectangle2.y, (int)localRectangle2.width, (int)localRectangle2.height);
    return localRectangle1;
  }

  public static boolean pushScissors(Rectangle paramRectangle)
  {
    fix(paramRectangle);
    if (scissors.size == 0)
    {
      if ((paramRectangle.width < 1.0F) || (paramRectangle.height < 1.0F))
        return false;
      Gdx.gl.glEnable(3089);
    }
    while (true)
    {
      scissors.add(paramRectangle);
      Gdx.gl.glScissor((int)paramRectangle.x, (int)paramRectangle.y, (int)paramRectangle.width, (int)paramRectangle.height);
      return true;
      Rectangle localRectangle = (Rectangle)scissors.get(-1 + scissors.size);
      float f1 = Math.max(localRectangle.x, paramRectangle.x);
      float f2 = Math.min(localRectangle.x + localRectangle.width, paramRectangle.x + paramRectangle.width);
      if (f2 - f1 < 1.0F)
        return false;
      float f3 = Math.max(localRectangle.y, paramRectangle.y);
      float f4 = Math.min(localRectangle.y + localRectangle.height, paramRectangle.y + paramRectangle.height);
      if (f4 - f3 < 1.0F)
        return false;
      paramRectangle.x = f1;
      paramRectangle.y = f3;
      paramRectangle.width = (f2 - f1);
      paramRectangle.height = Math.max(1.0F, f4 - f3);
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.utils.ScissorStack
 * JD-Core Version:    0.6.0
 */