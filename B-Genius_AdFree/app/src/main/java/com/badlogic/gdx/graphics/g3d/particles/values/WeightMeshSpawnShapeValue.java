package com.badlogic.gdx.graphics.g3d.particles.values;

import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.math.CumulativeDistribution;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

public final class WeightMeshSpawnShapeValue extends MeshSpawnShapeValue
{
  private CumulativeDistribution distribution = new CumulativeDistribution();

  public WeightMeshSpawnShapeValue()
  {
  }

  public WeightMeshSpawnShapeValue(WeightMeshSpawnShapeValue paramWeightMeshSpawnShapeValue)
  {
    super(paramWeightMeshSpawnShapeValue);
    load(paramWeightMeshSpawnShapeValue);
  }

  public final void calculateWeights()
  {
    this.distribution.clear();
    VertexAttributes localVertexAttributes = this.mesh.getVertexAttributes();
    int i = this.mesh.getNumIndices();
    int j = this.mesh.getNumVertices();
    int k = (short)(localVertexAttributes.vertexSize / 4);
    int m = (short)(localVertexAttributes.findByUsage(1).offset / 4);
    float[] arrayOfFloat = new float[j * k];
    this.mesh.getVertices(arrayOfFloat);
    if (i > 0)
    {
      short[] arrayOfShort = new short[i];
      this.mesh.getIndices(arrayOfShort);
      for (int i4 = 0; i4 < i; i4 += 3)
      {
        int i5 = m + k * arrayOfShort[i4];
        int i6 = m + k * arrayOfShort[(i4 + 1)];
        int i7 = m + k * arrayOfShort[(i4 + 2)];
        float f11 = arrayOfFloat[i5];
        float f12 = arrayOfFloat[(i5 + 1)];
        float f13 = arrayOfFloat[(i5 + 2)];
        float f14 = arrayOfFloat[i6];
        float f15 = arrayOfFloat[(i6 + 1)];
        float f16 = arrayOfFloat[(i6 + 2)];
        float f17 = arrayOfFloat[i7];
        float f18 = arrayOfFloat[(i7 + 1)];
        float f19 = arrayOfFloat[(i7 + 2)];
        float f20 = Math.abs((f11 * (f15 - f18) + f14 * (f18 - f12) + f17 * (f12 - f15)) / 2.0F);
        this.distribution.add(new MeshSpawnShapeValue.Triangle(f11, f12, f13, f14, f15, f16, f17, f18, f19), f20);
      }
    }
    int n = 0;
    while (n < j)
    {
      int i1 = n + m;
      int i2 = i1 + k;
      int i3 = i2 + k;
      float f1 = arrayOfFloat[i1];
      float f2 = arrayOfFloat[(i1 + 1)];
      float f3 = arrayOfFloat[(i1 + 2)];
      float f4 = arrayOfFloat[i2];
      float f5 = arrayOfFloat[(i2 + 1)];
      float f6 = arrayOfFloat[(i2 + 2)];
      float f7 = arrayOfFloat[i3];
      float f8 = arrayOfFloat[(i3 + 1)];
      float f9 = arrayOfFloat[(i3 + 2)];
      float f10 = Math.abs((f1 * (f5 - f8) + f4 * (f8 - f2) + f7 * (f2 - f5)) / 2.0F);
      this.distribution.add(new MeshSpawnShapeValue.Triangle(f1, f2, f3, f4, f5, f6, f7, f8, f9), f10);
      n += k;
    }
    this.distribution.generateNormalized();
  }

  public final SpawnShapeValue copy()
  {
    return new WeightMeshSpawnShapeValue(this);
  }

  public final void init()
  {
    calculateWeights();
  }

  public final void spawnAux(Vector3 paramVector3, float paramFloat)
  {
    MeshSpawnShapeValue.Triangle localTriangle = (MeshSpawnShapeValue.Triangle)this.distribution.value();
    float f1 = MathUtils.random();
    float f2 = MathUtils.random();
    paramVector3.set(localTriangle.x1 + f1 * (localTriangle.x2 - localTriangle.x1) + f2 * (localTriangle.x3 - localTriangle.x1), localTriangle.y1 + f1 * (localTriangle.y2 - localTriangle.y1) + f2 * (localTriangle.y3 - localTriangle.y1), localTriangle.z1 + f1 * (localTriangle.z2 - localTriangle.z1) + f2 * (localTriangle.z3 - localTriangle.z1));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.values.WeightMeshSpawnShapeValue
 * JD-Core Version:    0.6.0
 */