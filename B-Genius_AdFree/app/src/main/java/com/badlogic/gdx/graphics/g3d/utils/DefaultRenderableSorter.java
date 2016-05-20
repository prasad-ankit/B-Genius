package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import java.util.Comparator;

public class DefaultRenderableSorter
  implements RenderableSorter, Comparator
{
  private Camera camera;
  private final Vector3 tmpV1 = new Vector3();
  private final Vector3 tmpV2 = new Vector3();

  public int compare(Renderable paramRenderable1, Renderable paramRenderable2)
  {
    int i = 1;
    int j;
    int k;
    if ((paramRenderable1.material.has(BlendingAttribute.Type)) && (((BlendingAttribute)paramRenderable1.material.get(BlendingAttribute.Type)).blended))
    {
      j = i;
      if ((!paramRenderable2.material.has(BlendingAttribute.Type)) || (!((BlendingAttribute)paramRenderable2.material.get(BlendingAttribute.Type)).blended))
        break label92;
      k = i;
      label72: if (j == k)
        break label100;
      if (j == 0)
        break label98;
    }
    while (true)
    {
      return i;
      j = 0;
      break;
      label92: k = 0;
      break label72;
      label98: return -1;
      label100: paramRenderable1.worldTransform.getTranslation(this.tmpV1);
      paramRenderable2.worldTransform.getTranslation(this.tmpV2);
      float f = (int)(1000.0F * this.camera.position.dst2(this.tmpV1)) - (int)(1000.0F * this.camera.position.dst2(this.tmpV2));
      if (f < 0.0F)
        i = -1;
      while (j != 0)
      {
        return -i;
        if (f > 0.0F)
          continue;
        i = 0;
      }
    }
  }

  public void sort(Camera paramCamera, Array paramArray)
  {
    this.camera = paramCamera;
    paramArray.sort(this);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.utils.DefaultRenderableSorter
 * JD-Core Version:    0.6.0
 */