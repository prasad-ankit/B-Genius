package com.badlogic.gdx.graphics;

import com.badlogic.gdx.utils.ObjectMap;

public final class Colors
{
  private static final ObjectMap map = new ObjectMap();

  static
  {
    reset();
  }

  public static Color get(String paramString)
  {
    return (Color)map.get(paramString);
  }

  public static ObjectMap getColors()
  {
    return map;
  }

  public static Color put(String paramString, Color paramColor)
  {
    return (Color)map.put(paramString, paramColor);
  }

  public static void reset()
  {
    map.clear();
    map.put("CLEAR", Color.CLEAR);
    map.put("BLACK", Color.BLACK);
    map.put("WHITE", Color.WHITE);
    map.put("LIGHT_GRAY", Color.LIGHT_GRAY);
    map.put("GRAY", Color.GRAY);
    map.put("DARK_GRAY", Color.DARK_GRAY);
    map.put("SLATE", Color.SLATE);
    map.put("BLUE", Color.BLUE);
    map.put("NAVY", Color.NAVY);
    map.put("ROYAL", Color.ROYAL);
    map.put("SKY", Color.SKY);
    map.put("CYAN", Color.CYAN);
    map.put("TEAL", Color.TEAL);
    map.put("GREEN", Color.GREEN);
    map.put("CHARTREUSE", Color.CHARTREUSE);
    map.put("LIME", Color.LIME);
    map.put("FOREST", Color.FOREST);
    map.put("OLIVE", Color.OLIVE);
    map.put("YELLOW", Color.YELLOW);
    map.put("GOLD", Color.GOLD);
    map.put("GOLDENROD", Color.GOLDENROD);
    map.put("BROWN", Color.BROWN);
    map.put("TAN", Color.TAN);
    map.put("FIREBRICK", Color.FIREBRICK);
    map.put("RED", Color.RED);
    map.put("CORAL", Color.CORAL);
    map.put("ORANGE", Color.ORANGE);
    map.put("SALMON", Color.SALMON);
    map.put("PINK", Color.PINK);
    map.put("MAGENTA", Color.MAGENTA);
    map.put("PURPLE", Color.PURPLE);
    map.put("VIOLET", Color.VIOLET);
    map.put("MAROON", Color.MAROON);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.Colors
 * JD-Core Version:    0.6.0
 */