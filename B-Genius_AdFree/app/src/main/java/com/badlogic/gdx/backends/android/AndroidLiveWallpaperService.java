package com.badlogic.gdx.backends.android;

import android.os.Build.VERSION;
import android.service.wallpaper.WallpaperService;
import android.service.wallpaper.WallpaperService.Engine;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.WindowManager;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.utils.GdxNativesLoader;

public abstract class AndroidLiveWallpaperService extends WallpaperService
{
  static boolean DEBUG = false;
  static final String TAG = "WallpaperService";
  protected volatile AndroidLiveWallpaper app = null;
  protected int engines = 0;
  protected volatile boolean isPreviewNotified = false;
  protected volatile AndroidLiveWallpaperService.AndroidWallpaperEngine linkedEngine = null;
  protected volatile boolean notifiedPreviewState = false;
  volatile int[] sync = new int[0];
  protected SurfaceHolder.Callback view = null;
  protected int viewFormat;
  protected int viewHeight;
  protected int viewWidth;
  protected int visibleEngines = 0;

  static
  {
    GdxNativesLoader.load();
    DEBUG = false;
  }

  protected void finalize()
  {
    Log.i("WallpaperService", "service finalized");
    super.finalize();
  }

  public AndroidLiveWallpaper getLiveWallpaper()
  {
    return this.app;
  }

  public SurfaceHolder getSurfaceHolder()
  {
    if (DEBUG)
      Log.d("WallpaperService", " > AndroidLiveWallpaperService - getSurfaceHolder()");
    synchronized (this.sync)
    {
      if (this.linkedEngine == null)
        return null;
      SurfaceHolder localSurfaceHolder = this.linkedEngine.getSurfaceHolder();
      return localSurfaceHolder;
    }
  }

  public WindowManager getWindowManager()
  {
    return (WindowManager)getSystemService("window");
  }

  public void initialize(ApplicationListener paramApplicationListener)
  {
    initialize(paramApplicationListener, new AndroidApplicationConfiguration());
  }

  public void initialize(ApplicationListener paramApplicationListener, AndroidApplicationConfiguration paramAndroidApplicationConfiguration)
  {
    if (DEBUG)
      Log.d("WallpaperService", " > AndroidLiveWallpaperService - initialize()");
    this.app.initialize(paramApplicationListener, paramAndroidApplicationConfiguration);
    if ((paramAndroidApplicationConfiguration.getTouchEventsForLiveWallpaper) && (Integer.parseInt(Build.VERSION.SDK) >= 7))
      this.linkedEngine.setTouchEventsEnabled(true);
  }

  public void onCreate()
  {
    if (DEBUG)
      Log.d("WallpaperService", " > AndroidLiveWallpaperService - onCreate() " + hashCode());
    Log.i("WallpaperService", "service created");
    super.onCreate();
  }

  public void onCreateApplication()
  {
    if (DEBUG)
      Log.d("WallpaperService", " > AndroidLiveWallpaperService - onCreateApplication()");
  }

  public WallpaperService.Engine onCreateEngine()
  {
    if (DEBUG)
      Log.d("WallpaperService", " > AndroidLiveWallpaperService - onCreateEngine()");
    Log.i("WallpaperService", "engine created");
    return new AndroidLiveWallpaperService.AndroidWallpaperEngine(this);
  }

  public void onDeepPauseApplication()
  {
    if (DEBUG)
      Log.d("WallpaperService", " > AndroidLiveWallpaperService - onDeepPauseApplication()");
    if (this.app != null)
      this.app.graphics.clearManagedCaches();
  }

  public void onDestroy()
  {
    if (DEBUG)
      Log.d("WallpaperService", " > AndroidLiveWallpaperService - onDestroy() " + hashCode());
    Log.i("WallpaperService", "service destroyed");
    super.onDestroy();
    if (this.app != null)
    {
      this.app.onDestroy();
      this.app = null;
      this.view = null;
    }
  }

  protected void setLinkedEngine(AndroidLiveWallpaperService.AndroidWallpaperEngine paramAndroidWallpaperEngine)
  {
    synchronized (this.sync)
    {
      this.linkedEngine = paramAndroidWallpaperEngine;
      return;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidLiveWallpaperService
 * JD-Core Version:    0.6.0
 */