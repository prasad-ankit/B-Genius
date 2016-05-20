package com.badlogic.gdx.backends.android;

import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.View;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20;
import com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20API18;
import com.badlogic.gdx.backends.android.surfaceview.GLSurfaceViewAPI18;
import com.badlogic.gdx.backends.android.surfaceview.ResolutionStrategy;
import com.badlogic.gdx.math.WindowedMean;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.lang.reflect.Method;
import javax.microedition.khronos.opengles.GL10;

public final class AndroidGraphicsLiveWallpaper extends AndroidGraphics
{
  public AndroidGraphicsLiveWallpaper(AndroidLiveWallpaper paramAndroidLiveWallpaper, AndroidApplicationConfiguration paramAndroidApplicationConfiguration, ResolutionStrategy paramResolutionStrategy)
  {
    super(paramAndroidLiveWallpaper, paramAndroidApplicationConfiguration, paramResolutionStrategy, false);
  }

  protected final View createGLSurfaceView(AndroidApplicationBase paramAndroidApplicationBase, ResolutionStrategy paramResolutionStrategy)
  {
    if (!checkGL20())
      throw new GdxRuntimeException("Libgdx requires OpenGL ES 2.0");
    GLSurfaceView.EGLConfigChooser localEGLConfigChooser = getEglConfigChooser();
    if ((Build.VERSION.SDK_INT <= 10) && (this.config.useGLSurfaceView20API18))
    {
      AndroidGraphicsLiveWallpaper.1 local1 = new AndroidGraphicsLiveWallpaper.1(this, paramAndroidApplicationBase.getContext(), paramResolutionStrategy);
      if (localEGLConfigChooser != null)
        local1.setEGLConfigChooser(localEGLConfigChooser);
      while (true)
      {
        local1.setRenderer(this);
        return local1;
        local1.setEGLConfigChooser(this.config.r, this.config.g, this.config.b, this.config.a, this.config.depth, this.config.stencil);
      }
    }
    AndroidGraphicsLiveWallpaper.2 local2 = new AndroidGraphicsLiveWallpaper.2(this, paramAndroidApplicationBase.getContext(), paramResolutionStrategy);
    if (localEGLConfigChooser != null)
      local2.setEGLConfigChooser(localEGLConfigChooser);
    while (true)
    {
      local2.setRenderer(this);
      return local2;
      local2.setEGLConfigChooser(this.config.r, this.config.g, this.config.b, this.config.a, this.config.depth, this.config.stencil);
    }
  }

  final SurfaceHolder getSurfaceHolder()
  {
    synchronized (((AndroidLiveWallpaper)this.app).service.sync)
    {
      SurfaceHolder localSurfaceHolder = ((AndroidLiveWallpaper)this.app).service.getSurfaceHolder();
      return localSurfaceHolder;
    }
  }

  protected final void logManagedCachesStatus()
  {
    if (AndroidLiveWallpaperService.DEBUG)
      super.logManagedCachesStatus();
  }

  public final void onDestroyGLSurfaceView()
  {
    if ((this.view != null) && (((this.view instanceof GLSurfaceView)) || ((this.view instanceof GLSurfaceViewAPI18))));
    try
    {
      this.view.getClass().getMethod("onDestroy", new Class[0]).invoke(this.view, new Object[0]);
      if (AndroidLiveWallpaperService.DEBUG)
        Log.d("WallpaperService", " > AndroidLiveWallpaper - onDestroy() stopped GLThread managed by GLSurfaceView");
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("WallpaperService", "failed to destroy GLSurfaceView's thread! GLSurfaceView.onDetachedFromWindow impl changed since API lvl 16!");
      localThrowable.printStackTrace();
    }
  }

  public final void onDrawFrame(GL10 paramGL10)
  {
    long l = System.nanoTime();
    this.deltaTime = ((float)(l - this.lastFrameTime) / 1.0E+009F);
    this.lastFrameTime = l;
    if (!this.resume)
      this.mean.addValue(this.deltaTime);
    boolean bool2;
    boolean bool3;
    while (true)
    {
      synchronized (this.synch)
      {
        boolean bool1 = this.running;
        bool2 = this.pause;
        bool3 = this.destroy;
        boolean bool4 = this.resume;
        if (!this.resume)
          continue;
        this.resume = false;
        this.synch.notifyAll();
        if (!this.pause)
          continue;
        this.pause = false;
        this.synch.notifyAll();
        if (!this.destroy)
          continue;
        this.destroy = false;
        this.synch.notifyAll();
        if (!bool4)
          continue;
        this.app.getApplicationListener().resume();
        Gdx.app.log("AndroidGraphics", "resumed");
        if (!bool1)
          break label354;
      }
      synchronized (this.app.getRunnables())
      {
        this.app.getExecutedRunnables().clear();
        this.app.getExecutedRunnables().addAll(this.app.getRunnables());
        this.app.getRunnables().clear();
        int i = 0;
        label232: int j = this.app.getExecutedRunnables().size;
        if (i >= j)
          break;
        try
        {
          ((Runnable)this.app.getExecutedRunnables().get(i)).run();
          i++;
          break label232;
          this.deltaTime = 0.0F;
          continue;
          localObject2 = finally;
          monitorexit;
          throw localObject2;
        }
        catch (Throwable localThrowable)
        {
          while (true)
            localThrowable.printStackTrace();
        }
      }
    }
    monitorexit;
    this.app.getInput().processEvents();
    this.frameId = (1L + this.frameId);
    this.app.getApplicationListener().render();
    label354: if (bool2)
    {
      this.app.getApplicationListener().pause();
      Gdx.app.log("AndroidGraphics", "paused");
    }
    if (bool3)
    {
      this.app.getApplicationListener().dispose();
      Gdx.app.log("AndroidGraphics", "destroyed");
    }
    if (l - this.frameStart > 1000000000L)
    {
      this.fps = this.frames;
      this.frames = 0;
      this.frameStart = l;
    }
    this.frames = (1 + this.frames);
  }

  final void resume()
  {
    synchronized (this.synch)
    {
      this.running = true;
      this.resume = true;
      while (true)
      {
        boolean bool = this.resume;
        if (bool)
          try
          {
            this.synch.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            Gdx.app.log("AndroidGraphics", "waiting for resume synchronization failed!");
          }
      }
    }
    monitorexit;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidGraphicsLiveWallpaper
 * JD-Core Version:    0.6.0
 */