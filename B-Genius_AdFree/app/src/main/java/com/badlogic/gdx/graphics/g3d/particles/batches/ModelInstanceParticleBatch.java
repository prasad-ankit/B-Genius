package com.badlogic.gdx.graphics.g3d.particles.batches;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.graphics.g3d.particles.renderers.ModelInstanceControllerRenderData;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import java.util.Iterator;

public class ModelInstanceParticleBatch
  implements ParticleBatch
{
  int bufferedParticlesCount;
  Array controllersRenderData = new Array(false, 5);

  public void begin()
  {
    this.controllersRenderData.clear();
    this.bufferedParticlesCount = 0;
  }

  public void draw(ModelInstanceControllerRenderData paramModelInstanceControllerRenderData)
  {
    this.controllersRenderData.add(paramModelInstanceControllerRenderData);
    this.bufferedParticlesCount += paramModelInstanceControllerRenderData.controller.particles.size;
  }

  public void end()
  {
  }

  public int getBufferedCount()
  {
    return this.bufferedParticlesCount;
  }

  public void getRenderables(Array paramArray, Pool paramPool)
  {
    Iterator localIterator = this.controllersRenderData.iterator();
    while (localIterator.hasNext())
    {
      ModelInstanceControllerRenderData localModelInstanceControllerRenderData = (ModelInstanceControllerRenderData)localIterator.next();
      int i = localModelInstanceControllerRenderData.controller.particles.size;
      for (int j = 0; j < i; j++)
        ((ModelInstance[])localModelInstanceControllerRenderData.modelInstanceChannel.data)[j].getRenderables(paramArray, paramPool);
    }
  }

  public void load(AssetManager paramAssetManager, ResourceData paramResourceData)
  {
  }

  public void save(AssetManager paramAssetManager, ResourceData paramResourceData)
  {
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.batches.ModelInstanceParticleBatch
 * JD-Core Version:    0.6.0
 */