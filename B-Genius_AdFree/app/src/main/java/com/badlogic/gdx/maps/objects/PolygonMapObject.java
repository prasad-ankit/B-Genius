package com.badlogic.gdx.maps.objects;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.math.Polygon;

public class PolygonMapObject extends MapObject
{
  private Polygon polygon;

  public PolygonMapObject()
  {
    this(new float[0]);
  }

  public PolygonMapObject(Polygon paramPolygon)
  {
    this.polygon = paramPolygon;
  }

  public PolygonMapObject(float[] paramArrayOfFloat)
  {
    this.polygon = new Polygon(paramArrayOfFloat);
  }

  public Polygon getPolygon()
  {
    return this.polygon;
  }

  public void setPolygon(Polygon paramPolygon)
  {
    this.polygon = paramPolygon;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.objects.PolygonMapObject
 * JD-Core Version:    0.6.0
 */