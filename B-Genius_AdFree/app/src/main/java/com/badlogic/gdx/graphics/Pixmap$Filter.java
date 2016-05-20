package com.badlogic.gdx.graphics;

public enum Pixmap$Filter
{
  static
  {
    BiLinear = new Filter("BiLinear", 1);
    Filter[] arrayOfFilter = new Filter[2];
    arrayOfFilter[0] = NearestNeighbour;
    arrayOfFilter[1] = BiLinear;
    $VALUES = arrayOfFilter;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.Pixmap.Filter
 * JD-Core Version:    0.6.0
 */