package com.badlogic.gdx.graphics.g3d;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.graphics.g3d.utils.RenderableSorter;
import com.badlogic.gdx.utils.Array;
import java.util.Comparator;

public class ModelCache$Sorter
  implements RenderableSorter, Comparator
{
  public int compare(Renderable paramRenderable1, Renderable paramRenderable2)
  {
    int i = paramRenderable1.meshPart.mesh.getVertexAttributes().compareTo(paramRenderable2.meshPart.mesh.getVertexAttributes());
    if (i == 0)
    {
      i = paramRenderable1.material.compareTo(paramRenderable2.material);
      if (i == 0)
        i = paramRenderable1.meshPart.primitiveType - paramRenderable2.meshPart.primitiveType;
    }
    return i;
  }

  public void sort(Camera paramCamera, Array paramArray)
  {
    paramArray.sort(this);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.ModelCache.Sorter
 * JD-Core Version:    0.6.0
 */