package com.badlogic.gdx.maps.objects;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.math.Rectangle;

public class RectangleMapObject extends MapObject
{
  private Rectangle rectangle;

  public RectangleMapObject()
  {
    this(0.0F, 0.0F, 1.0F, 1.0F);
  }

  public RectangleMapObject(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.rectangle = new Rectangle(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }

  public Rectangle getRectangle()
  {
    return this.rectangle;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.objects.RectangleMapObject
 * JD-Core Version:    0.6.0
 */