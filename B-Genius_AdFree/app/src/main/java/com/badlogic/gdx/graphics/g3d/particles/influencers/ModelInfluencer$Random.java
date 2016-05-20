package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;

public class ModelInfluencer$Random extends ModelInfluencer
{
  ModelInfluencer.Random.ModelInstancePool pool = new ModelInfluencer.Random.ModelInstancePool(this);

  public ModelInfluencer$Random()
  {
  }

  public ModelInfluencer$Random(Random paramRandom)
  {
    super(paramRandom);
  }

  public ModelInfluencer$Random(Model[] paramArrayOfModel)
  {
    super(paramArrayOfModel);
  }

  public void activateParticles(int paramInt1, int paramInt2)
  {
    int i = paramInt1 + paramInt2;
    while (paramInt1 < i)
    {
      ((ModelInstance[])this.modelChannel.data)[paramInt1] = ((ModelInstance)this.pool.obtain());
      paramInt1++;
    }
  }

  public Random copy()
  {
    return new Random(this);
  }

  public void init()
  {
    this.pool.clear();
  }

  public void killParticles(int paramInt1, int paramInt2)
  {
    int i = paramInt1 + paramInt2;
    while (paramInt1 < i)
    {
      this.pool.free(((ModelInstance[])this.modelChannel.data)[paramInt1]);
      ((ModelInstance[])this.modelChannel.data)[paramInt1] = null;
      paramInt1++;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.influencers.ModelInfluencer.Random
 * JD-Core Version:    0.6.0
 */