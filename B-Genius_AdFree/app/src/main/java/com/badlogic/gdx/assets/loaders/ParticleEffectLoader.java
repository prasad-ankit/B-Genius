package com.badlogic.gdx.assets.loaders;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;

public class ParticleEffectLoader extends SynchronousAssetLoader
{
  public ParticleEffectLoader(FileHandleResolver paramFileHandleResolver)
  {
    super(paramFileHandleResolver);
  }

  public Array getDependencies(String paramString, FileHandle paramFileHandle, ParticleEffectLoader.ParticleEffectParameter paramParticleEffectParameter)
  {
    Array localArray = null;
    if (paramParticleEffectParameter != null)
    {
      String str = paramParticleEffectParameter.atlasFile;
      localArray = null;
      if (str != null)
      {
        localArray = new Array();
        localArray.add(new AssetDescriptor(paramParticleEffectParameter.atlasFile, TextureAtlas.class));
      }
    }
    return localArray;
  }

  public ParticleEffect load(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, ParticleEffectLoader.ParticleEffectParameter paramParticleEffectParameter)
  {
    ParticleEffect localParticleEffect = new ParticleEffect();
    if ((paramParticleEffectParameter != null) && (paramParticleEffectParameter.atlasFile != null))
    {
      localParticleEffect.load(paramFileHandle, (TextureAtlas)paramAssetManager.get(paramParticleEffectParameter.atlasFile, TextureAtlas.class), paramParticleEffectParameter.atlasPrefix);
      return localParticleEffect;
    }
    if ((paramParticleEffectParameter != null) && (paramParticleEffectParameter.imagesDir != null))
    {
      localParticleEffect.load(paramFileHandle, paramParticleEffectParameter.imagesDir);
      return localParticleEffect;
    }
    localParticleEffect.load(paramFileHandle, paramFileHandle.parent());
    return localParticleEffect;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.assets.loaders.ParticleEffectLoader
 * JD-Core Version:    0.6.0
 */