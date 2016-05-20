package com.badlogic.gdx.graphics.g3d.particles.batches;

import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.utils.Pool;

class BillboardParticleBatch$RenderablePool extends Pool
{
  public BillboardParticleBatch$RenderablePool(BillboardParticleBatch paramBillboardParticleBatch)
  {
  }

  public Renderable newObject()
  {
    return this.this$0.allocRenderable();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.batches.BillboardParticleBatch.RenderablePool
 * JD-Core Version:    0.6.0
 */