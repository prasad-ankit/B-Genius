package com.badlogic.gdx.graphics.g3d.model.data;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.Iterator;

public class ModelData
{
  public final Array animations = new Array();
  public String id;
  public final Array materials = new Array();
  public final Array meshes = new Array();
  public final Array nodes = new Array();
  public final short[] version = new short[2];

  public void addMesh(ModelMesh paramModelMesh)
  {
    Iterator localIterator = this.meshes.iterator();
    while (localIterator.hasNext())
    {
      ModelMesh localModelMesh = (ModelMesh)localIterator.next();
      if (!localModelMesh.id.equals(paramModelMesh.id))
        continue;
      throw new GdxRuntimeException("Mesh with id '" + localModelMesh.id + "' already in model");
    }
    this.meshes.add(paramModelMesh);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.model.data.ModelData
 * JD-Core Version:    0.6.0
 */