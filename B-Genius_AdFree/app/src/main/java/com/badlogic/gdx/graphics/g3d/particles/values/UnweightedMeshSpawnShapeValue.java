package com.badlogic.gdx.graphics.g3d.particles.values;

import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

public final class UnweightedMeshSpawnShapeValue extends MeshSpawnShapeValue
{
  private short[] indices;
  private int positionOffset;
  private int triangleCount;
  private int vertexCount;
  private int vertexSize;
  private float[] vertices;

  public UnweightedMeshSpawnShapeValue()
  {
  }

  public UnweightedMeshSpawnShapeValue(UnweightedMeshSpawnShapeValue paramUnweightedMeshSpawnShapeValue)
  {
    super(paramUnweightedMeshSpawnShapeValue);
    load(paramUnweightedMeshSpawnShapeValue);
  }

  public final SpawnShapeValue copy()
  {
    return new UnweightedMeshSpawnShapeValue(this);
  }

  public final void setMesh(Mesh paramMesh, Model paramModel)
  {
    super.setMesh(paramMesh, paramModel);
    this.vertexSize = (paramMesh.getVertexSize() / 4);
    this.positionOffset = (paramMesh.getVertexAttribute(1).offset / 4);
    int i = paramMesh.getNumIndices();
    if (i > 0)
    {
      this.indices = new short[i];
      paramMesh.getIndices(this.indices);
      this.triangleCount = (this.indices.length / 3);
    }
    while (true)
    {
      this.vertexCount = paramMesh.getNumVertices();
      this.vertices = new float[this.vertexCount * this.vertexSize];
      paramMesh.getVertices(this.vertices);
      return;
      this.indices = null;
    }
  }

  public final void spawnAux(Vector3 paramVector3, float paramFloat)
  {
    if (this.indices == null)
    {
      int n = MathUtils.random(-3 + this.vertexCount) * this.vertexSize + this.positionOffset;
      int i1 = n + this.vertexSize;
      int i2 = i1 + this.vertexSize;
      MeshSpawnShapeValue.Triangle.pick(this.vertices[n], this.vertices[(n + 1)], this.vertices[(n + 2)], this.vertices[i1], this.vertices[(i1 + 1)], this.vertices[(i1 + 2)], this.vertices[i2], this.vertices[(i2 + 1)], this.vertices[(i2 + 2)], paramVector3);
      return;
    }
    int i = 3 * MathUtils.random(-1 + this.triangleCount);
    int j = this.indices[i] * this.vertexSize + this.positionOffset;
    int k = this.indices[(i + 1)] * this.vertexSize + this.positionOffset;
    int m = this.indices[(i + 2)] * this.vertexSize + this.positionOffset;
    MeshSpawnShapeValue.Triangle.pick(this.vertices[j], this.vertices[(j + 1)], this.vertices[(j + 2)], this.vertices[k], this.vertices[(k + 1)], this.vertices[(k + 2)], this.vertices[m], this.vertices[(m + 1)], this.vertices[(m + 2)], paramVector3);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.values.UnweightedMeshSpawnShapeValue
 * JD-Core Version:    0.6.0
 */