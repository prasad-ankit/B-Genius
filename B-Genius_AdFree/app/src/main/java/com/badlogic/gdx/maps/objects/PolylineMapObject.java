package com.badlogic.gdx.maps.objects;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.math.Polyline;

public class PolylineMapObject extends MapObject
{
  private Polyline polyline;

  public PolylineMapObject()
  {
    this(new float[0]);
  }

  public PolylineMapObject(Polyline paramPolyline)
  {
    this.polyline = paramPolyline;
  }

  public PolylineMapObject(float[] paramArrayOfFloat)
  {
    this.polyline = new Polyline(paramArrayOfFloat);
  }

  public Polyline getPolyline()
  {
    return this.polyline;
  }

  public void setPolyline(Polyline paramPolyline)
  {
    this.polyline = paramPolyline;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.objects.PolylineMapObject
 * JD-Core Version:    0.6.0
 */