package com.badlogic.gdx.graphics.g3d;

import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;

public class ModelBatch$RenderablePool extends Pool
{
  protected Array obtained = new Array();

  public void flush()
  {
    super.freeAll(this.obtained);
    this.obtained.clear();
  }

  protected Renderable newObject()
  {
    return new Renderable();
  }

  public Renderable obtain()
  {
    Renderable localRenderable = (Renderable)super.obtain();
    localRenderable.environment = null;
    localRenderable.material = null;
    localRenderable.meshPart.set("", null, 0, 0, 0);
    localRenderable.shader = null;
    this.obtained.add(localRenderable);
    return localRenderable;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.ModelBatch.RenderablePool
 * JD-Core Version:    0.6.0
 */