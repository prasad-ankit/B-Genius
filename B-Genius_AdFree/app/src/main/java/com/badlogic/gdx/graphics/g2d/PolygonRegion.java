package com.badlogic.gdx.graphics.g2d;

public class PolygonRegion
{
  final TextureRegion region;
  final float[] textureCoords;
  final short[] triangles;
  final float[] vertices;

  public PolygonRegion(TextureRegion paramTextureRegion, float[] paramArrayOfFloat, short[] paramArrayOfShort)
  {
    this.region = paramTextureRegion;
    this.vertices = paramArrayOfFloat;
    this.triangles = paramArrayOfShort;
    float[] arrayOfFloat = new float[paramArrayOfFloat.length];
    this.textureCoords = arrayOfFloat;
    float f1 = paramTextureRegion.u;
    float f2 = paramTextureRegion.v;
    float f3 = paramTextureRegion.u2 - f1;
    float f4 = paramTextureRegion.v2 - f2;
    int i = paramTextureRegion.regionWidth;
    int j = paramTextureRegion.regionHeight;
    int k = 0;
    int m = paramArrayOfFloat.length;
    while (k < m)
    {
      arrayOfFloat[k] = (f1 + f3 * (paramArrayOfFloat[k] / i));
      int n = k + 1;
      arrayOfFloat[n] = (f2 + f4 * (1.0F - paramArrayOfFloat[n] / j));
      k = n + 1;
    }
  }

  public TextureRegion getRegion()
  {
    return this.region;
  }

  public float[] getTextureCoords()
  {
    return this.textureCoords;
  }

  public short[] getTriangles()
  {
    return this.triangles;
  }

  public float[] getVertices()
  {
    return this.vertices;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g2d.PolygonRegion
 * JD-Core Version:    0.6.0
 */