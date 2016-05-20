package com.badlogic.gdx.assets.loaders;

import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;

public class MusicLoader extends AsynchronousAssetLoader
{
  private Music music;

  public MusicLoader(FileHandleResolver paramFileHandleResolver)
  {
    super(paramFileHandleResolver);
  }

  public Array getDependencies(String paramString, FileHandle paramFileHandle, MusicLoader.MusicParameter paramMusicParameter)
  {
    return null;
  }

  public void loadAsync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, MusicLoader.MusicParameter paramMusicParameter)
  {
    this.music = Gdx.audio.newMusic(paramFileHandle);
  }

  public Music loadSync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, MusicLoader.MusicParameter paramMusicParameter)
  {
    Music localMusic = this.music;
    this.music = null;
    return localMusic;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.assets.loaders.MusicLoader
 * JD-Core Version:    0.6.0
 */