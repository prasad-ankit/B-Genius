package com.badlogic.gdx.graphics.g3d.particles;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g3d.particles.batches.ParticleBatch;
import com.badlogic.gdx.graphics.g3d.particles.renderers.ParticleControllerRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.ObjectMap.Entry;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import java.util.Iterator;

public class ParticleEffectLoader extends AsynchronousAssetLoader
{
  protected Array items = new Array();

  public ParticleEffectLoader(FileHandleResolver paramFileHandleResolver)
  {
    super(paramFileHandleResolver);
  }

  private Object find(Array paramArray, Class paramClass)
  {
    Iterator localIterator = paramArray.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (ClassReflection.isAssignableFrom(paramClass, localObject.getClass()))
        return localObject;
    }
    return null;
  }

  public Array getDependencies(String paramString, FileHandle paramFileHandle, ParticleEffectLoader.ParticleEffectLoadParameter paramParticleEffectLoadParameter)
  {
    ResourceData localResourceData = (ResourceData)new Json().fromJson(ResourceData.class, paramFileHandle);
    Array localArray3;
    while (true)
    {
      ResourceData.AssetData localAssetData;
      synchronized (this.items)
      {
        ObjectMap.Entry localEntry = new ObjectMap.Entry();
        localEntry.key = paramString;
        localEntry.value = localResourceData;
        this.items.add(localEntry);
        Array localArray2 = localResourceData.getAssets();
        localArray3 = new Array();
        Iterator localIterator = localArray2.iterator();
        if (!localIterator.hasNext())
          break;
        localAssetData = (ResourceData.AssetData)localIterator.next();
        if (resolve(localAssetData.filename).exists())
          continue;
        localAssetData.filename = paramFileHandle.parent().child(Gdx.files.internal(localAssetData.filename).name()).path();
        if (localAssetData.type == ParticleEffect.class)
          localArray3.add(new AssetDescriptor(localAssetData.filename, localAssetData.type, paramParticleEffectLoadParameter));
      }
      localArray3.add(new AssetDescriptor(localAssetData.filename, localAssetData.type));
    }
    return localArray3;
  }

  public void loadAsync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, ParticleEffectLoader.ParticleEffectLoadParameter paramParticleEffectLoadParameter)
  {
  }

  public ParticleEffect loadSync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, ParticleEffectLoader.ParticleEffectLoadParameter paramParticleEffectLoadParameter)
  {
    Array localArray = this.items;
    monitorenter;
    int i = 0;
    while (true)
    {
      try
      {
        if (i >= this.items.size)
          break label187;
        ObjectMap.Entry localEntry = (ObjectMap.Entry)this.items.get(i);
        if (!((String)localEntry.key).equals(paramString))
          continue;
        ResourceData localResourceData2 = (ResourceData)localEntry.value;
        this.items.removeIndex(i);
        localResourceData1 = localResourceData2;
        monitorexit;
        ((ParticleEffect)localResourceData1.resource).load(paramAssetManager, localResourceData1);
        if (paramParticleEffectLoadParameter == null)
          break label178;
        if (paramParticleEffectLoadParameter.batches != null)
        {
          Iterator localIterator = paramParticleEffectLoadParameter.batches.iterator();
          if (localIterator.hasNext())
          {
            ((ParticleBatch)localIterator.next()).load(paramAssetManager, localResourceData1);
            continue;
            i++;
            continue;
          }
        }
      }
      finally
      {
        monitorexit;
      }
      ((ParticleEffect)localResourceData1.resource).setBatch(paramParticleEffectLoadParameter.batches);
      label178: return (ParticleEffect)localResourceData1.resource;
      label187: ResourceData localResourceData1 = null;
    }
  }

  public void save(ParticleEffect paramParticleEffect, ParticleEffectLoader.ParticleEffectSaveParameter paramParticleEffectSaveParameter)
  {
    ResourceData localResourceData = new ResourceData(paramParticleEffect);
    paramParticleEffect.save(paramParticleEffectSaveParameter.manager, localResourceData);
    Iterator localIterator1;
    if (paramParticleEffectSaveParameter.batches != null)
      localIterator1 = paramParticleEffectSaveParameter.batches.iterator();
    label139: 
    while (true)
    {
      ParticleBatch localParticleBatch;
      if (localIterator1.hasNext())
      {
        localParticleBatch = (ParticleBatch)localIterator1.next();
        Iterator localIterator2 = paramParticleEffect.getControllers().iterator();
        do
          if (!localIterator2.hasNext())
            break;
        while (!((ParticleController)localIterator2.next()).renderer.isCompatible(localParticleBatch));
      }
      for (int i = 1; ; i = 0)
      {
        if (i == 0)
          break label139;
        localParticleBatch.save(paramParticleEffectSaveParameter.manager, localResourceData);
        break;
        new Json().toJson(localResourceData, paramParticleEffectSaveParameter.file);
        return;
      }
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.ParticleEffectLoader
 * JD-Core Version:    0.6.0
 */