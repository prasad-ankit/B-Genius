package com.badlogic.gdx.physics.box2d;

import com.badlogic.gdx.math.Vector2;

public class WorldManifold
{
  protected final Vector2 normal = new Vector2();
  protected int numContactPoints;
  protected final Vector2[] points;
  protected final float[] separations;

  protected WorldManifold()
  {
    Vector2[] arrayOfVector2 = new Vector2[2];
    arrayOfVector2[0] = new Vector2();
    arrayOfVector2[1] = new Vector2();
    this.points = arrayOfVector2;
    this.separations = new float[2];
  }

  public Vector2 getNormal()
  {
    return this.normal;
  }

  public int getNumberOfContactPoints()
  {
    return this.numContactPoints;
  }

  public Vector2[] getPoints()
  {
    return this.points;
  }

  public float[] getSeparations()
  {
    return this.separations;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.physics.box2d.WorldManifold
 * JD-Core Version:    0.6.0
 */