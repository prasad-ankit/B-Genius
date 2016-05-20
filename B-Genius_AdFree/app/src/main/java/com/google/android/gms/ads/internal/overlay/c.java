package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.MeasureSpec;
import com.google.android.gms.ads.internal.P;
import com.google.android.gms.b.hc;
import com.google.android.gms.b.hu;
import com.google.android.gms.b.ju;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class c extends v
  implements AudioManager.OnAudioFocusChangeListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener
{
  private static final Map a;
  private final E b;
  private int c = 0;
  private int d = 0;
  private MediaPlayer e;
  private Uri f;
  private int g;
  private int h;
  private int i;
  private int j;
  private float k = 1.0F;
  private boolean l;
  private boolean m;
  private int n;
  private u o;

  static
  {
    HashMap localHashMap = new HashMap();
    a = localHashMap;
    localHashMap.put(Integer.valueOf(-1004), "MEDIA_ERROR_IO");
    a.put(Integer.valueOf(-1007), "MEDIA_ERROR_MALFORMED");
    a.put(Integer.valueOf(-1010), "MEDIA_ERROR_UNSUPPORTED");
    a.put(Integer.valueOf(-110), "MEDIA_ERROR_TIMED_OUT");
    a.put(Integer.valueOf(100), "MEDIA_ERROR_SERVER_DIED");
    a.put(Integer.valueOf(1), "MEDIA_ERROR_UNKNOWN");
    a.put(Integer.valueOf(1), "MEDIA_INFO_UNKNOWN");
    a.put(Integer.valueOf(700), "MEDIA_INFO_VIDEO_TRACK_LAGGING");
    a.put(Integer.valueOf(3), "MEDIA_INFO_VIDEO_RENDERING_START");
    a.put(Integer.valueOf(701), "MEDIA_INFO_BUFFERING_START");
    a.put(Integer.valueOf(702), "MEDIA_INFO_BUFFERING_END");
    a.put(Integer.valueOf(800), "MEDIA_INFO_BAD_INTERLEAVING");
    a.put(Integer.valueOf(801), "MEDIA_INFO_NOT_SEEKABLE");
    a.put(Integer.valueOf(802), "MEDIA_INFO_METADATA_UPDATE");
    a.put(Integer.valueOf(901), "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
    a.put(Integer.valueOf(902), "MEDIA_INFO_SUBTITLE_TIMED_OUT");
  }

  public c(Context paramContext, E paramE)
  {
    super(paramContext);
    setSurfaceTextureListener(this);
    this.b = paramE;
    this.b.a(this);
  }

  private void a(boolean paramBoolean)
  {
    hc.e("AdMediaPlayerView release");
    if (this.e != null)
    {
      this.e.reset();
      this.e.release();
      this.e = null;
      b(0);
      if (paramBoolean)
      {
        this.d = 0;
        this.d = 0;
      }
      m();
    }
  }

  private void b(float paramFloat)
  {
    if (this.e != null);
    try
    {
      this.e.setVolume(paramFloat, paramFloat);
      return;
      hc.d("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
    }
  }

  private void b(int paramInt)
  {
    if (paramInt == 3)
      this.b.c();
    while (true)
    {
      this.c = paramInt;
      return;
      if ((this.c != 3) || (paramInt == 3))
        continue;
      this.b.d();
    }
  }

  private void k()
  {
    hc.e("AdMediaPlayerView init MediaPlayer");
    SurfaceTexture localSurfaceTexture = getSurfaceTexture();
    if ((this.f == null) || (localSurfaceTexture == null))
      return;
    a(false);
    try
    {
      this.e = new MediaPlayer();
      this.e.setOnBufferingUpdateListener(this);
      this.e.setOnCompletionListener(this);
      this.e.setOnErrorListener(this);
      this.e.setOnInfoListener(this);
      this.e.setOnPreparedListener(this);
      this.e.setOnVideoSizeChangedListener(this);
      this.e.setDataSource(getContext(), this.f);
      this.e.setSurface(new Surface(localSurfaceTexture));
      this.e.setAudioStreamType(3);
      this.e.setScreenOnWhilePlaying(true);
      this.e.prepareAsync();
      b(1);
      return;
    }
    catch (IOException localIOException)
    {
      hc.c("Failed to initialize MediaPlayer at " + this.f, localIOException);
      onError(this.e, 1, 0);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      label146: break label146;
    }
  }

  private void l()
  {
    if ((n()) && (this.e.getCurrentPosition() > 0) && (this.d != 3))
    {
      hc.e("AdMediaPlayerView nudging MediaPlayer");
      b(0.0F);
      this.e.start();
      int i1 = this.e.getCurrentPosition();
      long l1 = P.i().a();
      while ((n()) && (this.e.getCurrentPosition() == i1) && (P.i().a() - l1 <= 250L));
      this.e.pause();
      p();
    }
  }

  private void m()
  {
    hc.e("AdMediaPlayerView abandon audio focus");
    AudioManager localAudioManager = q();
    if ((localAudioManager != null) && (this.m))
    {
      if (localAudioManager.abandonAudioFocus(this) == 1)
        this.m = false;
    }
    else
      return;
    hc.d("AdMediaPlayerView abandon audio focus failed");
  }

  private boolean n()
  {
    return (this.e != null) && (this.c != -1) && (this.c != 0) && (this.c != 1);
  }

  private void o()
  {
    hc.e("AdMediaPlayerView audio focus gained");
    this.m = true;
    p();
  }

  private void p()
  {
    if ((!this.l) && (this.m))
    {
      b(this.k);
      return;
    }
    b(0.0F);
  }

  private AudioManager q()
  {
    return (AudioManager)getContext().getSystemService("audio");
  }

  public final String a()
  {
    return "MediaPlayer";
  }

  public final void a(float paramFloat)
  {
    this.k = paramFloat;
    p();
  }

  public final void a(int paramInt)
  {
    hc.e("AdMediaPlayerView seek " + paramInt);
    if (n())
    {
      this.e.seekTo(paramInt);
      this.n = 0;
      return;
    }
    this.n = paramInt;
  }

  public final void a(u paramu)
  {
    this.o = paramu;
  }

  public final void a(String paramString)
  {
    this.f = Uri.parse(paramString);
    this.n = 0;
    k();
    requestLayout();
    invalidate();
  }

  public final void b()
  {
    hc.e("AdMediaPlayerView stop");
    if (this.e != null)
    {
      this.e.stop();
      this.e.release();
      this.e = null;
      b(0);
      this.d = 0;
      m();
    }
    this.b.b();
  }

  public final void c()
  {
    hc.e("AdMediaPlayerView play");
    if (n())
    {
      this.e.start();
      b(3);
      hu.a.post(new i(this));
    }
    this.d = 3;
  }

  public final void d()
  {
    hc.e("AdMediaPlayerView pause");
    if ((n()) && (this.e.isPlaying()))
    {
      this.e.pause();
      b(4);
      hu.a.post(new j(this));
    }
    this.d = 4;
  }

  public final int e()
  {
    if (n())
      return this.e.getDuration();
    return -1;
  }

  public final int f()
  {
    if (n())
      return this.e.getCurrentPosition();
    return 0;
  }

  public final void g()
  {
    this.l = true;
    p();
  }

  public final void h()
  {
    this.l = false;
    p();
  }

  public final int i()
  {
    if (this.e != null)
      return this.e.getVideoWidth();
    return 0;
  }

  public final int j()
  {
    if (this.e != null)
      return this.e.getVideoHeight();
    return 0;
  }

  public final void onAudioFocusChange(int paramInt)
  {
    if (paramInt > 0)
      o();
    do
      return;
    while (paramInt >= 0);
    hc.e("AdMediaPlayerView audio focus lost");
    this.m = false;
    p();
  }

  public final void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
  }

  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    hc.e("AdMediaPlayerView completion");
    b(5);
    this.d = 5;
    hu.a.post(new e(this));
  }

  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    String str1 = (String)a.get(Integer.valueOf(paramInt1));
    String str2 = (String)a.get(Integer.valueOf(paramInt2));
    hc.d("AdMediaPlayerView MediaPlayer error: " + str1 + ":" + str2);
    b(-1);
    this.d = -1;
    hu.a.post(new f(this, str1, str2));
    return true;
  }

  public final boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    String str1 = (String)a.get(Integer.valueOf(paramInt1));
    String str2 = (String)a.get(Integer.valueOf(paramInt2));
    hc.e("AdMediaPlayerView MediaPlayer info: " + str1 + ":" + str2);
    return true;
  }

  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = getDefaultSize(this.g, paramInt1);
    int i2 = getDefaultSize(this.h, paramInt2);
    int i3;
    int i4;
    int i5;
    if ((this.g > 0) && (this.h > 0))
    {
      i3 = View.MeasureSpec.getMode(paramInt1);
      i4 = View.MeasureSpec.getSize(paramInt1);
      i5 = View.MeasureSpec.getMode(paramInt2);
      i2 = View.MeasureSpec.getSize(paramInt2);
      if ((i3 != 1073741824) || (i5 != 1073741824))
        break label202;
      if (i2 * this.g >= i4 * this.h)
        break label165;
      i1 = i2 * this.g / this.h;
    }
    while (true)
    {
      setMeasuredDimension(i1, i2);
      if (Build.VERSION.SDK_INT == 16)
      {
        if (((this.i > 0) && (this.i != i1)) || ((this.j > 0) && (this.j != i2)))
          l();
        this.i = i1;
        this.j = i2;
      }
      return;
      label165: if (i2 * this.g > i4 * this.h)
      {
        i2 = i4 * this.h / this.g;
        i1 = i4;
        continue;
        label202: int i8;
        if (i3 == 1073741824)
        {
          i8 = i4 * this.h / this.g;
          if ((i5 == -2147483648) && (i8 > i2))
          {
            i1 = i4;
            continue;
          }
        }
        else
        {
          if (i5 == 1073741824)
          {
            i1 = i2 * this.g / this.h;
            if ((i3 != -2147483648) || (i1 <= i4))
              continue;
            i1 = i4;
            continue;
          }
          int i6 = this.g;
          int i7 = this.h;
          if ((i5 == -2147483648) && (i7 > i2));
          for (i1 = i2 * this.g / this.h; ; i1 = i6)
          {
            if ((i3 != -2147483648) || (i1 <= i4))
              break label368;
            i2 = i4 * this.h / this.g;
            i1 = i4;
            break;
            i2 = i7;
          }
          label368: continue;
        }
        i2 = i8;
        i1 = i4;
        continue;
      }
      i1 = i4;
    }
  }

  public final void onPrepared(MediaPlayer paramMediaPlayer)
  {
    hc.e("AdMediaPlayerView prepared");
    b(2);
    this.b.a();
    hu.a.post(new d(this));
    this.g = paramMediaPlayer.getVideoWidth();
    this.h = paramMediaPlayer.getVideoHeight();
    if (this.n != 0)
      a(this.n);
    l();
    hc.c("AdMediaPlayerView stream dimensions: " + this.g + " x " + this.h);
    if (this.d == 3)
      c();
    AudioManager localAudioManager = q();
    if ((localAudioManager != null) && (!this.m))
    {
      if (localAudioManager.requestAudioFocus(this, 3, 2) != 1)
        break label152;
      o();
    }
    while (true)
    {
      p();
      return;
      label152: hc.d("AdMediaPlayerView audio focus request failed");
    }
  }

  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    hc.e("AdMediaPlayerView surface created");
    k();
    hu.a.post(new g(this));
  }

  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    hc.e("AdMediaPlayerView surface destroyed");
    if ((this.e != null) && (this.n == 0))
      this.n = this.e.getCurrentPosition();
    hu.a.post(new h(this));
    a(true);
    return true;
  }

  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    int i1 = 1;
    hc.e("AdMediaPlayerView surface changed");
    int i2;
    if (this.d == 3)
    {
      i2 = i1;
      if ((this.g != paramInt1) || (this.h != paramInt2))
        break label80;
    }
    while (true)
    {
      if ((this.e != null) && (i2 != 0) && (i1 != 0))
      {
        if (this.n != 0)
          a(this.n);
        c();
      }
      return;
      i2 = 0;
      break;
      label80: i1 = 0;
    }
  }

  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    this.b.b(this);
  }

  public final void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    hc.e("AdMediaPlayerView size changed: " + paramInt1 + " x " + paramInt2);
    this.g = paramMediaPlayer.getVideoWidth();
    this.h = paramMediaPlayer.getVideoHeight();
    if ((this.g != 0) && (this.h != 0))
      requestLayout();
  }

  public final String toString()
  {
    return getClass().getName() + "@" + Integer.toHexString(hashCode());
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.c
 * JD-Core Version:    0.6.0
 */