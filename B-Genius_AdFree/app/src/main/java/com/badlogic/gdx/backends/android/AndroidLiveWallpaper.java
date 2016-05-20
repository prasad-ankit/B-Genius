package com.badlogic.gdx.backends.android;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.LifecycleListener;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.backends.android.surfaceview.FillResolutionStrategy;
import com.badlogic.gdx.backends.android.surfaceview.ResolutionStrategy;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Clipboard;
import com.badlogic.gdx.utils.GdxNativesLoader;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.File;

public class AndroidLiveWallpaper
  implements AndroidApplicationBase
{
  protected AndroidAudio audio;
  AndroidClipboard clipboard;
  protected final Array executedRunnables = new Array();
  protected AndroidFiles files;
  protected boolean firstResume = true;
  protected AndroidGraphicsLiveWallpaper graphics;
  protected AndroidInput input;
  protected final Array lifecycleListeners = new Array();
  protected ApplicationListener listener;
  protected int logLevel = 2;
  protected AndroidNet net;
  protected final Array runnables = new Array();
  protected AndroidLiveWallpaperService service;

  static
  {
    GdxNativesLoader.load();
  }

  public AndroidLiveWallpaper(AndroidLiveWallpaperService paramAndroidLiveWallpaperService)
  {
    this.service = paramAndroidLiveWallpaperService;
  }

  public void addLifecycleListener(LifecycleListener paramLifecycleListener)
  {
    synchronized (this.lifecycleListeners)
    {
      this.lifecycleListeners.add(paramLifecycleListener);
      return;
    }
  }

  public void debug(String paramString1, String paramString2)
  {
    if (this.logLevel >= 3)
      Log.d(paramString1, paramString2);
  }

  public void debug(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (this.logLevel >= 3)
      Log.d(paramString1, paramString2, paramThrowable);
  }

  public void error(String paramString1, String paramString2)
  {
    if (this.logLevel > 0)
      Log.e(paramString1, paramString2);
  }

  public void error(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (this.logLevel > 0)
      Log.e(paramString1, paramString2, paramThrowable);
  }

  public void exit()
  {
  }

  public ApplicationListener getApplicationListener()
  {
    return this.listener;
  }

  public Window getApplicationWindow()
  {
    throw new UnsupportedOperationException();
  }

  public Audio getAudio()
  {
    return this.audio;
  }

  public Clipboard getClipboard()
  {
    if (this.clipboard == null)
      this.clipboard = new AndroidClipboard(this.service);
    return this.clipboard;
  }

  public Context getContext()
  {
    return this.service;
  }

  public Array getExecutedRunnables()
  {
    return this.executedRunnables;
  }

  public Files getFiles()
  {
    return this.files;
  }

  public Graphics getGraphics()
  {
    return this.graphics;
  }

  public Handler getHandler()
  {
    throw new UnsupportedOperationException();
  }

  public AndroidInput getInput()
  {
    return this.input;
  }

  public long getJavaHeap()
  {
    return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
  }

  public Array getLifecycleListeners()
  {
    return this.lifecycleListeners;
  }

  public int getLogLevel()
  {
    return this.logLevel;
  }

  public long getNativeHeap()
  {
    return Debug.getNativeHeapAllocatedSize();
  }

  public Net getNet()
  {
    return this.net;
  }

  public Preferences getPreferences(String paramString)
  {
    return new AndroidPreferences(this.service.getSharedPreferences(paramString, 0));
  }

  public Array getRunnables()
  {
    return this.runnables;
  }

  public AndroidLiveWallpaperService getService()
  {
    return this.service;
  }

  public Application.ApplicationType getType()
  {
    return Application.ApplicationType.Android;
  }

  public int getVersion()
  {
    return Build.VERSION.SDK_INT;
  }

  public WindowManager getWindowManager()
  {
    return this.service.getWindowManager();
  }

  public void initialize(ApplicationListener paramApplicationListener, AndroidApplicationConfiguration paramAndroidApplicationConfiguration)
  {
    if (getVersion() < 8)
      throw new GdxRuntimeException("LibGDX requires Android API Level 8 or later.");
    if (paramAndroidApplicationConfiguration.resolutionStrategy == null);
    for (Object localObject = new FillResolutionStrategy(); ; localObject = paramAndroidApplicationConfiguration.resolutionStrategy)
    {
      this.graphics = new AndroidGraphicsLiveWallpaper(this, paramAndroidApplicationConfiguration, (ResolutionStrategy)localObject);
      this.input = AndroidInputFactory.newAndroidInput(this, getService(), this.graphics.view, paramAndroidApplicationConfiguration);
      this.audio = new AndroidAudio(getService(), paramAndroidApplicationConfiguration);
      getService().getFilesDir();
      this.files = new AndroidFiles(getService().getAssets(), getService().getFilesDir().getAbsolutePath());
      this.net = new AndroidNet(this);
      this.listener = paramApplicationListener;
      com.badlogic.gdx.Gdx.app = this;
      com.badlogic.gdx.Gdx.input = this.input;
      com.badlogic.gdx.Gdx.audio = this.audio;
      com.badlogic.gdx.Gdx.files = this.files;
      com.badlogic.gdx.Gdx.graphics = this.graphics;
      com.badlogic.gdx.Gdx.net = this.net;
      return;
    }
  }

  public void log(String paramString1, String paramString2)
  {
    if (this.logLevel >= 2)
      Log.i(paramString1, paramString2);
  }

  public void log(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (this.logLevel >= 2)
      Log.i(paramString1, paramString2, paramThrowable);
  }

  public void onDestroy()
  {
    if (this.graphics != null)
      this.graphics.onDestroyGLSurfaceView();
    if (this.audio != null)
      this.audio.dispose();
  }

  public void onPause()
  {
    if (AndroidLiveWallpaperService.DEBUG)
      Log.d("WallpaperService", " > AndroidLiveWallpaper - onPause()");
    this.audio.pause();
    this.input.onPause();
    if (this.graphics != null)
      this.graphics.onPauseGLSurfaceView();
    if (AndroidLiveWallpaperService.DEBUG)
      Log.d("WallpaperService", " > AndroidLiveWallpaper - onPause() done!");
  }

  public void onResume()
  {
    com.badlogic.gdx.Gdx.app = this;
    com.badlogic.gdx.Gdx.input = this.input;
    com.badlogic.gdx.Gdx.audio = this.audio;
    com.badlogic.gdx.Gdx.files = this.files;
    com.badlogic.gdx.Gdx.graphics = this.graphics;
    com.badlogic.gdx.Gdx.net = this.net;
    this.input.onResume();
    if (this.graphics != null)
      this.graphics.onResumeGLSurfaceView();
    if (!this.firstResume)
    {
      this.audio.resume();
      this.graphics.resume();
      return;
    }
    this.firstResume = false;
  }

  public void postRunnable(Runnable paramRunnable)
  {
    synchronized (this.runnables)
    {
      this.runnables.add(paramRunnable);
      return;
    }
  }

  public void removeLifecycleListener(LifecycleListener paramLifecycleListener)
  {
    synchronized (this.lifecycleListeners)
    {
      this.lifecycleListeners.removeValue(paramLifecycleListener, true);
      return;
    }
  }

  public void runOnUiThread(Runnable paramRunnable)
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      new Handler(Looper.getMainLooper()).post(paramRunnable);
      return;
    }
    paramRunnable.run();
  }

  public void setLogLevel(int paramInt)
  {
    this.logLevel = paramInt;
  }

  public void startActivity(Intent paramIntent)
  {
    this.service.startActivity(paramIntent);
  }

  public void useImmersiveMode(boolean paramBoolean)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidLiveWallpaper
 * JD-Core Version:    0.6.0
 */