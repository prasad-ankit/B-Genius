package com.badlogic.gdx.assets.loaders;

import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;

public class SoundLoader extends AsynchronousAssetLoader
{
  private Sound sound;

  public SoundLoader(FileHandleResolver paramFileHandleResolver)
  {
    super(paramFileHandleResolver);
  }

  public Array getDependencies(String paramString, FileHandle paramFileHandle, SoundLoader.SoundParameter paramSoundParameter)
  {
    return null;
  }

  public void loadAsync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, SoundLoader.SoundParameter paramSoundParameter)
  {
    this.sound = Gdx.audio.newSound(paramFileHandle);
  }

  public Sound loadSync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, SoundLoader.SoundParameter paramSoundParameter)
  {
    Sound localSound = this.sound;
    this.sound = null;
    return localSound;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.assets.loaders.SoundLoader
 * JD-Core Version:    0.6.0
 */