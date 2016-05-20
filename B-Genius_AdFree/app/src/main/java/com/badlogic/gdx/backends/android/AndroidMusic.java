package com.badlogic.gdx.backends.android;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Music.OnCompletionListener;
import java.io.IOException;

public class AndroidMusic
  implements MediaPlayer.OnCompletionListener, Music
{
  private final AndroidAudio audio;
  private boolean isPrepared = true;
  protected Music.OnCompletionListener onCompletionListener;
  private MediaPlayer player;
  private float volume = 1.0F;
  protected boolean wasPlaying = false;

  AndroidMusic(AndroidAudio paramAndroidAudio, MediaPlayer paramMediaPlayer)
  {
    this.audio = paramAndroidAudio;
    this.player = paramMediaPlayer;
    this.onCompletionListener = null;
    this.player.setOnCompletionListener(this);
  }

  // ERROR //
  public void dispose()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 34	com/badlogic/gdx/backends/android/AndroidMusic:player	Landroid/media/MediaPlayer;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 34	com/badlogic/gdx/backends/android/AndroidMusic:player	Landroid/media/MediaPlayer;
    //   12: invokevirtual 48	android/media/MediaPlayer:release	()V
    //   15: aload_0
    //   16: aconst_null
    //   17: putfield 34	com/badlogic/gdx/backends/android/AndroidMusic:player	Landroid/media/MediaPlayer;
    //   20: aload_0
    //   21: aconst_null
    //   22: putfield 36	com/badlogic/gdx/backends/android/AndroidMusic:onCompletionListener	Lcom/badlogic/gdx/audio/Music$OnCompletionListener;
    //   25: aload_0
    //   26: getfield 32	com/badlogic/gdx/backends/android/AndroidMusic:audio	Lcom/badlogic/gdx/backends/android/AndroidAudio;
    //   29: getfield 54	com/badlogic/gdx/backends/android/AndroidAudio:musics	Ljava/util/List;
    //   32: astore 9
    //   34: aload 9
    //   36: monitorenter
    //   37: aload_0
    //   38: getfield 32	com/badlogic/gdx/backends/android/AndroidMusic:audio	Lcom/badlogic/gdx/backends/android/AndroidAudio;
    //   41: getfield 54	com/badlogic/gdx/backends/android/AndroidAudio:musics	Ljava/util/List;
    //   44: aload_0
    //   45: invokeinterface 60 2 0
    //   50: pop
    //   51: aload 9
    //   53: monitorexit
    //   54: return
    //   55: astore 10
    //   57: aload 9
    //   59: monitorexit
    //   60: aload 10
    //   62: athrow
    //   63: astore 5
    //   65: getstatic 66	com/badlogic/gdx/Gdx:app	Lcom/badlogic/gdx/Application;
    //   68: ldc 68
    //   70: ldc 70
    //   72: invokeinterface 76 3 0
    //   77: aload_0
    //   78: aconst_null
    //   79: putfield 34	com/badlogic/gdx/backends/android/AndroidMusic:player	Landroid/media/MediaPlayer;
    //   82: aload_0
    //   83: aconst_null
    //   84: putfield 36	com/badlogic/gdx/backends/android/AndroidMusic:onCompletionListener	Lcom/badlogic/gdx/audio/Music$OnCompletionListener;
    //   87: aload_0
    //   88: getfield 32	com/badlogic/gdx/backends/android/AndroidMusic:audio	Lcom/badlogic/gdx/backends/android/AndroidAudio;
    //   91: getfield 54	com/badlogic/gdx/backends/android/AndroidAudio:musics	Ljava/util/List;
    //   94: astore 6
    //   96: aload 6
    //   98: monitorenter
    //   99: aload_0
    //   100: getfield 32	com/badlogic/gdx/backends/android/AndroidMusic:audio	Lcom/badlogic/gdx/backends/android/AndroidAudio;
    //   103: getfield 54	com/badlogic/gdx/backends/android/AndroidAudio:musics	Ljava/util/List;
    //   106: aload_0
    //   107: invokeinterface 60 2 0
    //   112: pop
    //   113: aload 6
    //   115: monitorexit
    //   116: return
    //   117: astore 7
    //   119: aload 6
    //   121: monitorexit
    //   122: aload 7
    //   124: athrow
    //   125: astore_1
    //   126: aload_0
    //   127: aconst_null
    //   128: putfield 34	com/badlogic/gdx/backends/android/AndroidMusic:player	Landroid/media/MediaPlayer;
    //   131: aload_0
    //   132: aconst_null
    //   133: putfield 36	com/badlogic/gdx/backends/android/AndroidMusic:onCompletionListener	Lcom/badlogic/gdx/audio/Music$OnCompletionListener;
    //   136: aload_0
    //   137: getfield 32	com/badlogic/gdx/backends/android/AndroidMusic:audio	Lcom/badlogic/gdx/backends/android/AndroidAudio;
    //   140: getfield 54	com/badlogic/gdx/backends/android/AndroidAudio:musics	Ljava/util/List;
    //   143: astore_2
    //   144: aload_2
    //   145: monitorenter
    //   146: aload_0
    //   147: getfield 32	com/badlogic/gdx/backends/android/AndroidMusic:audio	Lcom/badlogic/gdx/backends/android/AndroidAudio;
    //   150: getfield 54	com/badlogic/gdx/backends/android/AndroidAudio:musics	Ljava/util/List;
    //   153: aload_0
    //   154: invokeinterface 60 2 0
    //   159: pop
    //   160: aload_2
    //   161: monitorexit
    //   162: aload_1
    //   163: athrow
    //   164: astore_3
    //   165: aload_2
    //   166: monitorexit
    //   167: aload_3
    //   168: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   37	54	55	finally
    //   57	60	55	finally
    //   8	15	63	java/lang/Throwable
    //   99	116	117	finally
    //   119	122	117	finally
    //   8	15	125	finally
    //   65	77	125	finally
    //   146	162	164	finally
    //   165	167	164	finally
  }

  public float getDuration()
  {
    if (this.player == null)
      return 0.0F;
    return this.player.getDuration() / 1000.0F;
  }

  public float getPosition()
  {
    if (this.player == null)
      return 0.0F;
    return this.player.getCurrentPosition() / 1000.0F;
  }

  public float getVolume()
  {
    return this.volume;
  }

  public boolean isLooping()
  {
    if (this.player == null)
      return false;
    return this.player.isLooping();
  }

  public boolean isPlaying()
  {
    if (this.player == null)
      return false;
    return this.player.isPlaying();
  }

  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (this.onCompletionListener != null)
      Gdx.app.postRunnable(new AndroidMusic.1(this));
  }

  public void pause()
  {
    if (this.player == null)
      return;
    if (this.player.isPlaying())
      this.player.pause();
    this.wasPlaying = false;
  }

  public void play()
  {
    if (this.player == null);
    do
      return;
    while (this.player.isPlaying());
    try
    {
      if (!this.isPrepared)
      {
        this.player.prepare();
        this.isPrepared = true;
      }
      this.player.start();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      localIllegalStateException.printStackTrace();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }

  public void setLooping(boolean paramBoolean)
  {
    if (this.player == null)
      return;
    this.player.setLooping(paramBoolean);
  }

  public void setOnCompletionListener(Music.OnCompletionListener paramOnCompletionListener)
  {
    this.onCompletionListener = paramOnCompletionListener;
  }

  public void setPan(float paramFloat1, float paramFloat2)
  {
    if (this.player == null)
      return;
    float f1;
    float f2;
    if (paramFloat1 < 0.0F)
    {
      f1 = paramFloat2 * (1.0F - Math.abs(paramFloat1));
      f2 = paramFloat2;
    }
    while (true)
    {
      this.player.setVolume(f2, f1);
      this.volume = paramFloat2;
      return;
      if (paramFloat1 > 0.0F)
      {
        f2 = paramFloat2 * (1.0F - Math.abs(paramFloat1));
        f1 = paramFloat2;
        continue;
      }
      f1 = paramFloat2;
      f2 = paramFloat2;
    }
  }

  public void setPosition(float paramFloat)
  {
    if (this.player == null)
      return;
    try
    {
      if (!this.isPrepared)
      {
        this.player.prepare();
        this.isPrepared = true;
      }
      this.player.seekTo((int)(1000.0F * paramFloat));
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      localIllegalStateException.printStackTrace();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }

  public void setVolume(float paramFloat)
  {
    if (this.player == null)
      return;
    this.player.setVolume(paramFloat, paramFloat);
    this.volume = paramFloat;
  }

  public void stop()
  {
    if (this.player == null)
      return;
    if (this.isPrepared)
      this.player.seekTo(0);
    this.player.stop();
    this.isPrepared = false;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidMusic
 * JD-Core Version:    0.6.0
 */