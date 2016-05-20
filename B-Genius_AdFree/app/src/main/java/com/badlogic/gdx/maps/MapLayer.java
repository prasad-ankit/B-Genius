package com.badlogic.gdx.maps;

public class MapLayer
{
  private String name = "";
  private MapObjects objects = new MapObjects();
  private float opacity = 1.0F;
  private MapProperties properties = new MapProperties();
  private boolean visible = true;

  public String getName()
  {
    return this.name;
  }

  public MapObjects getObjects()
  {
    return this.objects;
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
 * Qualified Name:     com.badlogic.gdx.maps.MapLayer
 * JD-Core Version:    0.6.0
 */