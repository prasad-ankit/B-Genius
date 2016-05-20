package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;

class ModelInfluencer$Random$ModelInstancePool extends Pool
{
  public ModelInfluencer$Random$ModelInstancePool(ModelInfluencer.Random paramRandom)
  {
  }

  public ModelInstance newObject()
  {
    return new ModelInstance((Model)this.this$0.models.random());
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.influencers.ModelInfluencer.Random.ModelInstancePool
 * JD-Core Version:    0.6.0
 */