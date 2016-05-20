package com.badlogic.gdx.maps.objects;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.math.Ellipse;

public class EllipseMapObject extends MapObject
{
  private Ellipse ellipse;

  public EllipseMapObject()
  {
    this(0.0F, 0.0F, 1.0F, 1.0F);
  }

  public EllipseMapObject(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.ellipse = new Ellipse(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }

  public Ellipse getEllipse()
  {
    return this.ellipse;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.objects.EllipseMapObject
 * JD-Core Version:    0.6.0
 */