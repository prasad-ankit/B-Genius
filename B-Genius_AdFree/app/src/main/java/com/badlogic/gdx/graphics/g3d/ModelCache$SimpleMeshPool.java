package com.badlogic.gdx.graphics.g3d;

import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.utils.Array;
import java.util.Iterator;

public class ModelCache$SimpleMeshPool
  implements ModelCache.MeshPool
{
  private Array freeMeshes = new Array();
  private Array usedMeshes = new Array();

  public void dispose()
  {
    Iterator localIterator1 = this.usedMeshes.iterator();
    while (localIterator1.hasNext())
      ((Mesh)localIterator1.next()).dispose();
    this.usedMeshes.clear();
    Iterator localIterator2 = this.freeMeshes.iterator();
    while (localIterator2.hasNext())
      ((Mesh)localIterator2.next()).dispose();
    this.freeMeshes.clear();
  }

  public void flush()
  {
    this.freeMeshes.addAll(this.usedMeshes);
    this.usedMeshes.clear();
  }

  public Mesh obtain(VertexAttributes paramVertexAttributes, int paramInt1, int paramInt2)
  {
    int i = this.freeMeshes.size;
    for (int j = 0; j < i; j++)
    {
      Mesh localMesh2 = (Mesh)this.freeMeshes.get(j);
      if ((!localMesh2.getVertexAttributes().equals(paramVertexAttributes)) || (localMesh2.getMaxVertices() < paramInt1) || (localMesh2.getMaxIndices() < paramInt2))
        continue;
      this.freeMeshes.removeIndex(j);
      this.usedMeshes.add(localMesh2);
      return localMesh2;
    }
    Mesh localMesh1 = new Mesh(false, 32768, Math.max(32768, 1 << 32 - Integer.numberOfLeadingZeros(paramInt2 - 1)), paramVertexAttributes);
    this.usedMeshes.add(localMesh1);
    return localMesh1;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.ModelCache.SimpleMeshPool
 * JD-Core Version:    0.6.0
 */