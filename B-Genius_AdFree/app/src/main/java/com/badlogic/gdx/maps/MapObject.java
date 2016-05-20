package com.badlogic.gdx.maps;

import com.badlogic.gdx.graphics.Color;

public class MapObject
{
  private Color color = Color.WHITE.cpy();
  private String name = "";
  private float opacity = 1.0F;
  private MapProperties properties = new MapProperties();
  private boolean visible = true;

  public Color getColor()
  {
    return this.color;
  }

  public String getName()
  {
    return this.name;
  }

  public float getOpacity()
  {
    return this.opacity;
  }

  public MapProperties getProperties()
  {
    return this.properties;
  }

  public boolean isVisible()
  {
    return this.visible;
  }

  public void setColor(Color paramColor)
  {
    this.color = paramColor;
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }

  public void setOpacity(float paramFloat)
  {
    this.opacity = paramFloat;
  }

  public void setVisible(boolean paramBoolean)
  {
    this.visible = paramBoolean;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.MapObject
 * JD-Core Version:    0.6.0
 */