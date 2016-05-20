package com.badlogic.gdx.maps.objects;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.math.Circle;

public class CircleMapObject extends MapObject
{
  private Circle circle;

  public CircleMapObject()
  {
    this(0.0F, 0.0F, 1.0F);
  }

  public CircleMapObject(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.circle = new Circle(paramFloat1, paramFloat2, paramFloat3);
  }

  public Circle getCircle()
  {
    return this.circle;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.objects.CircleMapObject
 * JD-Core Version:    0.6.0
 */