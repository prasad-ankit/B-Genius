package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.emitters.Emitter;
import com.badlogic.gdx.utils.Array;

public class ModelInfluencer$Single extends ModelInfluencer
{
  public ModelInfluencer$Single()
  {
  }

  public ModelInfluencer$Single(Single paramSingle)
  {
    super(paramSingle);
  }

  public ModelInfluencer$Single(Model[] paramArrayOfModel)
  {
    super(paramArrayOfModel);
  }

  public Single copy()
  {
    return new Single(this);
  }

  public void init()
  {
    Model localModel = (Model)this.models.first();
    int i = this.controller.emitter.maxParticleCount;
    for (int j = 0; j < i; j++)
      ((ModelInstance[])this.modelChannel.data)[j] = new ModelInstance(localModel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.influencers.ModelInfluencer.Single
 * JD-Core Version:    0.6.0
 */