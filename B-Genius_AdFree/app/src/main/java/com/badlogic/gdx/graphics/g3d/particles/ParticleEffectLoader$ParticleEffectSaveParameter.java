package com.badlogic.gdx.graphics.g3d.particles;

import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;

public class ParticleEffectLoader$ParticleEffectSaveParameter extends AssetLoaderParameters
{
  Array batches;
  FileHandle file;
  AssetManager manager;

  public ParticleEffectLoader$ParticleEffectSaveParameter(FileHandle paramFileHandle, AssetManager paramAssetManager, Array paramArray)
  {
    this.batches = paramArray;
    this.file = paramFileHandle;
    this.manager = paramAssetManager;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.ParticleEffectLoader.ParticleEffectSaveParameter
 * JD-Core Version:    0.6.0
 */