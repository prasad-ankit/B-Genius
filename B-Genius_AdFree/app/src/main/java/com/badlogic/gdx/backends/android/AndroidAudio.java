package com.badlogic.gdx.backends.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.audio.AudioDevice;
import com.badlogic.gdx.audio.AudioRecorder;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class AndroidAudio
  implements Audio
{
  private final AudioManager manager;
  protected final List musics = new ArrayList();
  private final SoundPool soundPool;

  public AndroidAudio(Context paramContext, AndroidApplicationConfiguration paramAndroidApplicationConfiguration)
  {
    if (!paramAndroidApplicationConfiguration.disableAudio)
    {
      this.soundPool = new SoundPool(paramAndroidApplicationConfiguration.maxSimultaneousSounds, 3, 100);
      this.manager = ((AudioManager)paramContext.getSystemService("audio"));
      if ((paramContext instanceof Activity))
        ((Activity)paramContext).setVolumeControlStream(3);
      return;
    }
    this.soundPool = null;
    this.manager = null;
  }

  public final void dispose()
  {
    if (this.soundPool == null)
      return;
    synchronized (this.musics)
    {
      Iterator localIterator = new ArrayList(this.musics).iterator();
      if (localIterator.hasNext())
        ((AndroidMusic)localIterator.next()).dispose();
    }
    monitorexit;
    this.soundPool.release();
  }

  public final AudioDevice newAudioDevice(int paramInt, boolean paramBoolean)
  {
    if (this.soundPool == null)
      throw new GdxRuntimeException("Android audio is not enabled by the application config.");
    return new AndroidAudioDevice(paramInt, paramBoolean);
  }

  public final AudioRecorder newAudioRecorder(int paramInt, boolean paramBoolean)
  {
    if (this.soundPool == null)
      throw new GdxRuntimeException("Android audio is not enabled by the application config.");
    return new AndroidAudioRecorder(paramInt, paramBoolean);
  }

  public final Music newMusic(FileHandle paramFileHandle)
  {
    if (this.soundPool == null)
      throw new GdxRuntimeException("Android audio is not enabled by the application config.");
    AndroidFileHandle localAndroidFileHandle = (AndroidFileHandle)paramFileHandle;
    MediaPlayer localMediaPlayer = new MediaPlayer();
    if (localAndroidFileHandle.type() == Files.FileType.Internal)
      try
      {
        AssetFileDescriptor localAssetFileDescriptor = localAndroidFileHandle.getAssetFileDescriptor();
        localMediaPlayer.setDataSource(localAssetFileDescriptor.getFileDescriptor(), localAssetFileDescriptor.getStartOffset(), localAssetFileDescriptor.getLength());
        localAssetFileDescriptor.close();
        localMediaPlayer.prepare();
        AndroidMusic localAndroidMusic2 = new AndroidMusic(this, localMediaPlayer);
        synchronized (this.musics)
        {
          this.musics.add(localAndroidMusic2);
          return localAndroidMusic2;
        }
      }
      catch (Exception localException2)
      {
        throw new GdxRuntimeException("Error loading audio file: " + paramFileHandle + "\nNote: Internal audio files must be placed in the assets directory.", localException2);
      }
    try
    {
      localMediaPlayer.setDataSource(localAndroidFileHandle.file().getPath());
      localMediaPlayer.prepare();
      AndroidMusic localAndroidMusic1 = new AndroidMusic(this, localMediaPlayer);
      synchronized (this.musics)
      {
        this.musics.add(localAndroidMusic1);
        return localAndroidMusic1;
      }
    }
    catch (Exception localException1)
    {
    }
    throw new GdxRuntimeException("Error loading audio file: " + paramFileHandle, localException1);
  }

  public final Sound newSound(FileHandle paramFileHandle)
  {
    if (this.soundPool == null)
      throw new GdxRuntimeException("Android audio is not enabled by the application config.");
    AndroidFileHandle localAndroidFileHandle = (AndroidFileHandle)paramFileHandle;
    if (localAndroidFileHandle.type() == Files.FileType.Internal)
      try
      {
        AssetFileDescriptor localAssetFileDescriptor = localAndroidFileHandle.getAssetFileDescriptor();
        AndroidSound localAndroidSound2 = new AndroidSound(this.soundPool, this.manager, this.soundPool.load(localAssetFileDescriptor, 1));
        localAssetFileDescriptor.close();
        return localAndroidSound2;
      }
      catch (IOException localIOException)
      {
        throw new GdxRuntimeException("Error loading audio file: " + paramFileHandle + "\nNote: Internal audio files must be placed in the assets directory.", localIOException);
      }
    try
    {
      AndroidSound localAndroidSound1 = new AndroidSound(this.soundPool, this.manager, this.soundPool.load(localAndroidFileHandle.file().getPath(), 1));
      return localAndroidSound1;
    }
    catch (Exception localException)
    {
    }
    throw new GdxRuntimeException("Error loading audio file: " + paramFileHandle, localException);
  }

  protected final void pause()
  {
    if (this.soundPool == null)
      return;
    while (true)
    {
      AndroidMusic localAndroidMusic;
      synchronized (this.musics)
      {
        Iterator localIterator = this.musics.iterator();
        if (!localIterator.hasNext())
          break;
        localAndroidMusic = (AndroidMusic)localIterator.next();
        if (localAndroidMusic.isPlaying())
        {
          localAndroidMusic.pause();
          localAndroidMusic.wasPlaying = true;
        }
      }
      localAndroidMusic.wasPlaying = false;
    }
    monitorexit;
    this.soundPool.autoPause();
  }

  protected final void resume()
  {
    if (this.soundPool == null)
      return;
    List localList = this.musics;
    monitorenter;
    for (int i = 0; ; i++)
      try
      {
        if (i < this.musics.size())
        {
          if (!((AndroidMusic)this.musics.get(i)).wasPlaying)
            continue;
          ((AndroidMusic)this.musics.get(i)).play();
        }
        else
        {
          monitorexit;
          this.soundPool.autoResume();
          return;
        }
      }
      finally
      {
        monitorexit;
      }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidAudio
 * JD-Core Version:    0.6.0
 */