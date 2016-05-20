package com.badlogic.gdx.graphics.glutils;

public enum ShapeRenderer$ShapeType
{
  private final int glType;

  static
  {
    Line = new ShapeType("Line", 1, 1);
    Filled = new ShapeType("Filled", 2, 4);
    ShapeType[] arrayOfShapeType = new ShapeType[3];
    arrayOfShapeType[0] = Point;
    arrayOfShapeType[1] = Line;
    arrayOfShapeType[2] = Filled;
    $VALUES = arrayOfShapeType;
  }

  private ShapeRenderer$ShapeType(int arg3)
  {
    int j;
    this.glType = j;
  }

  public final int getGlType()
  {
    return this.glType;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType
 * JD-Core Version:    0.6.0
 */