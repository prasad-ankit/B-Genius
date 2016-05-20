package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.ObjectChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.ParticleEffect;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData.SaveData;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.IntArray;
import java.util.Iterator;

public abstract class ParticleControllerInfluencer extends Influencer
{
  ParallelArray.ObjectChannel particleControllerChannel;
  public Array templates;

  public ParticleControllerInfluencer()
  {
    this.templates = new Array(true, 1, ParticleController.class);
  }

  public ParticleControllerInfluencer(ParticleControllerInfluencer paramParticleControllerInfluencer)
  {
    this((ParticleController[])paramParticleControllerInfluencer.templates.items);
  }

  public ParticleControllerInfluencer(ParticleController[] paramArrayOfParticleController)
  {
    this.templates = new Array(paramArrayOfParticleController);
  }

  public void allocateChannels()
  {
    this.particleControllerChannel = ((ParallelArray.ObjectChannel)this.controller.particles.addChannel(ParticleChannels.ParticleController));
  }

  public void dispose()
  {
    if (this.controller != null)
      for (int i = 0; i < this.controller.particles.size; i++)
      {
        ParticleController localParticleController = ((ParticleController[])this.particleControllerChannel.data)[i];
        if (localParticleController == null)
          continue;
        localParticleController.dispose();
        ((ParticleController[])this.particleControllerChannel.data)[i] = null;
      }
  }

  public void end()
  {
    for (int i = 0; i < this.controller.particles.size; i++)
      ((ParticleController[])this.particleControllerChannel.data)[i].end();
  }

  public void load(AssetManager paramAssetManager, ResourceData paramResourceData)
  {
    ResourceData.SaveData localSaveData = paramResourceData.getSaveData();
    Iterator localIterator = ((Array)localSaveData.load("indices")).iterator();
    while (true)
    {
      AssetDescriptor localAssetDescriptor = localSaveData.loadAsset();
      if (localAssetDescriptor == null)
        break;
      ParticleEffect localParticleEffect = (ParticleEffect)paramAssetManager.get(localAssetDescriptor);
      if (localParticleEffect == null)
        throw new RuntimeException("Template is null");
      Array localArray = localParticleEffect.getControllers();
      IntArray localIntArray = (IntArray)localIterator.next();
      int i = 0;
      int j = localIntArray.size;
      while (i < j)
      {
        this.templates.add(localArray.get(localIntArray.get(i)));
        i++;
      }
    }
  }

  public void save(AssetManager paramAssetManager, ResourceData paramResourceData)
  {
    ResourceData.SaveData localSaveData = paramResourceData.createSaveData();
    Array localArray1 = paramAssetManager.getAll(ParticleEffect.class, new Array());
    Array localArray2 = new Array(this.templates);
    Array localArray3 = new Array();
    int i = 0;
    ParticleEffect localParticleEffect;
    Object localObject1;
    label92: Object localObject2;
    if ((i < localArray1.size) && (localArray2.size > 0))
    {
      localParticleEffect = (ParticleEffect)localArray1.get(i);
      Array localArray4 = localParticleEffect.getControllers();
      Iterator localIterator = localArray2.iterator();
      localObject1 = null;
      if (localIterator.hasNext())
      {
        int j = localArray4.indexOf((ParticleController)localIterator.next(), true);
        if (j < 0)
          break label206;
        if (localObject1 != null)
          break label199;
        localObject2 = new IntArray();
        label139: localIterator.remove();
        ((IntArray)localObject2).add(j);
      }
    }
    while (true)
    {
      localObject1 = localObject2;
      break label92;
      if (localObject1 != null)
      {
        localSaveData.saveAsset(paramAssetManager.getAssetFileName(localParticleEffect), ParticleEffect.class);
        localArray3.add(localObject1);
      }
      i++;
      break;
      localSaveData.save("indices", localArray3);
      return;
      label199: localObject2 = localObject1;
      break label139;
      label206: localObject2 = localObject1;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.influencers.ParticleControllerInfluencer
 * JD-Core Version:    0.6.0
 */