package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.ObjectChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData.SaveData;
import com.badlogic.gdx.utils.Array;
import java.util.Iterator;

public abstract class ModelInfluencer extends Influencer
{
  ParallelArray.ObjectChannel modelChannel;
  public Array models;

  public ModelInfluencer()
  {
    this.models = new Array(true, 1, Model.class);
  }

  public ModelInfluencer(ModelInfluencer paramModelInfluencer)
  {
    this((Model[])paramModelInfluencer.models.toArray(Model.class));
  }

  public ModelInfluencer(Model[] paramArrayOfModel)
  {
    this.models = new Array(paramArrayOfModel);
  }

  public void allocateChannels()
  {
    this.modelChannel = ((ParallelArray.ObjectChannel)this.controller.particles.addChannel(ParticleChannels.ModelInstance));
  }

  public void load(AssetManager paramAssetManager, ResourceData paramResourceData)
  {
    ResourceData.SaveData localSaveData = paramResourceData.getSaveData();
    while (true)
    {
      AssetDescriptor localAssetDescriptor = localSaveData.loadAsset();
      if (localAssetDescriptor == null)
        break;
      Model localModel = (Model)paramAssetManager.get(localAssetDescriptor);
      if (localModel == null)
        throw new RuntimeException("Model is null");
      this.models.add(localModel);
    }
  }

  public void save(AssetManager paramAssetManager, ResourceData paramResourceData)
  {
    ResourceData.SaveData localSaveData = paramResourceData.createSaveData();
    Iterator localIterator = this.models.iterator();
    while (localIterator.hasNext())
      localSaveData.saveAsset(paramAssetManager.getAssetFileName((Model)localIterator.next()), Model.class);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.influencers.ModelInfluencer
 * JD-Core Version:    0.6.0
 */