package com.badlogic.gdx.backends.android;

import android.os.Bundle;
import android.service.wallpaper.WallpaperService.Engine;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;

public class AndroidLiveWallpaperService$AndroidWallpaperEngine extends WallpaperService.Engine
{
  protected int engineFormat;
  protected int engineHeight;
  protected boolean engineIsVisible = false;
  protected int engineWidth;
  boolean offsetsConsumed = true;
  float xOffset = 0.0F;
  float xOffsetStep = 0.0F;
  int xPixelOffset = 0;
  float yOffset = 0.0F;
  float yOffsetStep = 0.0F;
  int yPixelOffset = 0;

  public AndroidLiveWallpaperService$AndroidWallpaperEngine(AndroidLiveWallpaperService paramAndroidLiveWallpaperService)
  {
    super(paramAndroidLiveWallpaperService);
    if (AndroidLiveWallpaperService.DEBUG)
      Log.d("WallpaperService", " > AndroidWallpaperEngine() " + hashCode());
  }

  private void notifySurfaceChanged(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramInt1 == this.this$0.viewFormat) && (paramInt2 == this.this$0.viewWidth) && (paramInt3 == this.this$0.viewHeight))
      if (AndroidLiveWallpaperService.DEBUG)
        Log.d("WallpaperService", " > surface is current, skipping surfaceChanged event");
    do
    {
      return;
      this.engineFormat = paramInt1;
      this.engineWidth = paramInt2;
      this.engineHeight = paramInt3;
      if (this.this$0.linkedEngine != this)
        continue;
      this.this$0.viewFormat = this.engineFormat;
      this.this$0.viewWidth = this.engineWidth;
      this.this$0.viewHeight = this.engineHeight;
      this.this$0.view.surfaceChanged(getSurfaceHolder(), this.this$0.viewFormat, this.this$0.viewWidth, this.this$0.viewHeight);
      return;
    }
    while (!AndroidLiveWallpaperService.DEBUG);
    Log.d("WallpaperService", " > engine is not active, skipping surfaceChanged event");
  }

  private void notifyVisibilityChanged(boolean paramBoolean)
  {
    if (this.engineIsVisible != paramBoolean)
    {
      this.engineIsVisible = paramBoolean;
      if (this.engineIsVisible)
        onResume();
    }
    do
    {
      return;
      onPause();
      return;
    }
    while (!AndroidLiveWallpaperService.DEBUG);
    Log.d("WallpaperService", " > visible state is current, skipping visibilityChanged event!");
  }

  protected void notifyOffsetsChanged()
  {
    if ((this.this$0.linkedEngine == this) && ((this.this$0.app.listener instanceof AndroidWallpaperListener)) && (!this.offsetsConsumed))
    {
      this.offsetsConsumed = true;
      this.this$0.app.postRunnable(new AndroidLiveWallpaperService.AndroidWallpaperEngine.1(this));
    }
  }

  protected void notifyPreviewState()
  {
    if ((this.this$0.linkedEngine == this) && ((this.this$0.app.listener instanceof AndroidWallpaperListener)))
    {
      boolean bool = this.this$0.linkedEngine.isPreview();
      this.this$0.app.postRunnable(new AndroidLiveWallpaperService.AndroidWallpaperEngine.2(this, bool));
    }
  }

  public Bundle onCommand(String paramString, int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle, boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (AndroidLiveWallpaperService.DEBUG)
    {
      localStringBuilder = new StringBuilder(" > AndroidWallpaperEngine - onCommand(").append(paramString).append(" ").append(paramInt1).append(" ").append(paramInt2).append(" ").append(paramInt3).append(" ").append(paramBundle).append(" ").append(paramBoolean).append("), linked: ");
      if (this.this$0.linkedEngine != this)
        break label118;
    }
    label118: for (boolean bool = true; ; bool = false)
    {
      Log.d("WallpaperService", bool);
      return super.onCommand(paramString, paramInt1, paramInt2, paramInt3, paramBundle, paramBoolean);
    }
  }

  public void onCreate(SurfaceHolder paramSurfaceHolder)
  {
    StringBuilder localStringBuilder;
    if (AndroidLiveWallpaperService.DEBUG)
    {
      localStringBuilder = new StringBuilder(" > AndroidWallpaperEngine - onCreate() ").append(hashCode()).append(" running: ").append(this.this$0.engines).append(", linked: ");
      if (this.this$0.linkedEngine != this)
        break label90;
    }
    label90: for (boolean bool = true; ; bool = false)
    {
      Log.d("WallpaperService", bool + ", thread: " + Thread.currentThread().toString());
      super.onCreate(paramSurfaceHolder);
      return;
    }
  }

  public void onDestroy()
  {
    super.onDestroy();
  }

  public void onOffsetsChanged(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2)
  {
    this.offsetsConsumed = false;
    this.xOffset = paramFloat1;
    this.yOffset = paramFloat2;
    this.xOffsetStep = paramFloat3;
    this.yOffsetStep = paramFloat4;
    this.xPixelOffset = paramInt1;
    this.yPixelOffset = paramInt2;
    notifyOffsetsChanged();
    if (!Gdx.graphics.isContinuousRendering())
      Gdx.graphics.requestRendering();
    super.onOffsetsChanged(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt1, paramInt2);
  }

  public void onPause()
  {
    AndroidLiveWallpaperService localAndroidLiveWallpaperService = this.this$0;
    localAndroidLiveWallpaperService.visibleEngines = (-1 + localAndroidLiveWallpaperService.visibleEngines);
    StringBuilder localStringBuilder;
    if (AndroidLiveWallpaperService.DEBUG)
    {
      localStringBuilder = new StringBuilder(" > AndroidWallpaperEngine - onPause() ").append(hashCode()).append(", running: ").append(this.this$0.engines).append(", linked: ");
      if (this.this$0.linkedEngine != this)
        break label202;
    }
    label202: for (boolean bool = true; ; bool = false)
    {
      Log.d("WallpaperService", bool + ", visible: " + this.this$0.visibleEngines);
      Log.i("WallpaperService", "engine paused");
      if (this.this$0.visibleEngines >= this.this$0.engines)
      {
        Log.e("WallpaperService", "wallpaper lifecycle error, counted too many visible engines! repairing..");
        this.this$0.visibleEngines = Math.max(-1 + this.this$0.engines, 0);
      }
      if ((this.this$0.linkedEngine != null) && (this.this$0.visibleEngines == 0))
        this.this$0.app.onPause();
      if (AndroidLiveWallpaperService.DEBUG)
        Log.d("WallpaperService", " > AndroidWallpaperEngine - onPause() done!");
      return;
    }
  }

  public void onResume()
  {
    AndroidLiveWallpaperService localAndroidLiveWallpaperService = this.this$0;
    localAndroidLiveWallpaperService.visibleEngines = (1 + localAndroidLiveWallpaperService.visibleEngines);
    boolean bool;
    if (AndroidLiveWallpaperService.DEBUG)
    {
      StringBuilder localStringBuilder = new StringBuilder(" > AndroidWallpaperEngine - onResume() ").append(hashCode()).append(", running: ").append(this.this$0.engines).append(", linked: ");
      if (this.this$0.linkedEngine == this)
      {
        bool = true;
        Log.d("WallpaperService", bool + ", visible: " + this.this$0.visibleEngines);
      }
    }
    else
    {
      Log.i("WallpaperService", "engine resumed");
      if (this.this$0.linkedEngine != null)
      {
        if (this.this$0.linkedEngine == this)
          break label243;
        this.this$0.setLinkedEngine(this);
        this.this$0.view.surfaceDestroyed(getSurfaceHolder());
        notifySurfaceChanged(this.engineFormat, this.engineWidth, this.engineHeight, false);
        this.this$0.view.surfaceCreated(getSurfaceHolder());
      }
    }
    while (true)
    {
      if (this.this$0.visibleEngines == 1)
        this.this$0.app.onResume();
      notifyPreviewState();
      notifyOffsetsChanged();
      if (!Gdx.graphics.isContinuousRendering())
        Gdx.graphics.requestRendering();
      return;
      bool = false;
      break;
      label243: notifySurfaceChanged(this.engineFormat, this.engineWidth, this.engineHeight, false);
    }
  }

  public void onSurfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder;
    if (AndroidLiveWallpaperService.DEBUG)
    {
      localStringBuilder = new StringBuilder(" > AndroidWallpaperEngine - onSurfaceChanged() isPreview: ").append(isPreview()).append(", ").append(hashCode()).append(", running: ").append(this.this$0.engines).append(", linked: ");
      if (this.this$0.linkedEngine != this)
        break label137;
    }
    label137: for (boolean bool = true; ; bool = false)
    {
      Log.d("WallpaperService", bool + ", sufcace valid: " + getSurfaceHolder().getSurface().isValid());
      Log.i("WallpaperService", "engine surface changed");
      super.onSurfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
      notifySurfaceChanged(paramInt1, paramInt2, paramInt3, true);
      return;
    }
  }

  public void onSurfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AndroidLiveWallpaperService localAndroidLiveWallpaperService = this.this$0;
    localAndroidLiveWallpaperService.engines = (1 + localAndroidLiveWallpaperService.engines);
    this.this$0.setLinkedEngine(this);
    StringBuilder localStringBuilder;
    if (AndroidLiveWallpaperService.DEBUG)
    {
      localStringBuilder = new StringBuilder(" > AndroidWallpaperEngine - onSurfaceCreated() ").append(hashCode()).append(", running: ").append(this.this$0.engines).append(", linked: ");
      if (this.this$0.linkedEngine != this)
        break label225;
    }
    label225: for (boolean bool = true; ; bool = false)
    {
      Log.d("WallpaperService", bool);
      Log.i("WallpaperService", "engine surface created");
      super.onSurfaceCreated(paramSurfaceHolder);
      if (this.this$0.engines == 1)
        this.this$0.visibleEngines = 0;
      if ((this.this$0.engines != 1) || (this.this$0.app != null))
        break;
      this.this$0.viewFormat = 0;
      this.this$0.viewWidth = 0;
      this.this$0.viewHeight = 0;
      this.this$0.app = new AndroidLiveWallpaper(this.this$0);
      this.this$0.onCreateApplication();
      if (this.this$0.app.graphics != null)
        break;
      throw new Error("You must override 'AndroidLiveWallpaperService.onCreateApplication' method and call 'initialize' from its body.");
    }
    this.this$0.view = ((SurfaceHolder.Callback)this.this$0.app.graphics.view);
    getSurfaceHolder().removeCallback(this.this$0.view);
    this.engineFormat = this.this$0.viewFormat;
    this.engineWidth = this.this$0.viewWidth;
    this.engineHeight = this.this$0.viewHeight;
    if (this.this$0.engines == 1)
      this.this$0.view.surfaceCreated(paramSurfaceHolder);
    while (true)
    {
      notifyPreviewState();
      notifyOffsetsChanged();
      if (!Gdx.graphics.isContinuousRendering())
        Gdx.graphics.requestRendering();
      return;
      this.this$0.view.surfaceDestroyed(paramSurfaceHolder);
      notifySurfaceChanged(this.engineFormat, this.engineWidth, this.engineHeight, false);
      this.this$0.view.surfaceCreated(paramSurfaceHolder);
    }
  }

  public void onSurfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AndroidLiveWallpaperService localAndroidLiveWallpaperService = this.this$0;
    localAndroidLiveWallpaperService.engines = (-1 + localAndroidLiveWallpaperService.engines);
    StringBuilder localStringBuilder;
    if (AndroidLiveWallpaperService.DEBUG)
    {
      localStringBuilder = new StringBuilder(" > AndroidWallpaperEngine - onSurfaceDestroyed() ").append(hashCode()).append(", running: ").append(this.this$0.engines).append(" ,linked: ");
      if (this.this$0.linkedEngine != this)
        break label203;
    }
    label203: for (boolean bool = true; ; bool = false)
    {
      Log.d("WallpaperService", bool + ", isVisible: " + this.engineIsVisible);
      Log.i("WallpaperService", "engine surface destroyed");
      if (this.this$0.engines == 0)
        this.this$0.onDeepPauseApplication();
      if ((this.this$0.linkedEngine == this) && (this.this$0.view != null))
        this.this$0.view.surfaceDestroyed(paramSurfaceHolder);
      this.engineFormat = 0;
      this.engineWidth = 0;
      this.engineHeight = 0;
      if (this.this$0.engines == 0)
        this.this$0.linkedEngine = null;
      super.onSurfaceDestroyed(paramSurfaceHolder);
      return;
    }
  }

  public void onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.this$0.linkedEngine == this)
      this.this$0.app.input.onTouch(null, paramMotionEvent);
  }

  public void onVisibilityChanged(boolean paramBoolean)
  {
    boolean bool = isVisible();
    if (AndroidLiveWallpaperService.DEBUG)
      Log.d("WallpaperService", " > AndroidWallpaperEngine - onVisibilityChanged(paramVisible: " + paramBoolean + " reportedVisible: " + bool + ") " + hashCode() + ", sufcace valid: " + getSurfaceHolder().getSurface().isValid());
    super.onVisibilityChanged(paramBoolean);
    if ((!bool) && (paramBoolean == true))
    {
      if (AndroidLiveWallpaperService.DEBUG)
        Log.d("WallpaperService", " > fake visibilityChanged event! Android WallpaperService likes do that!");
      return;
    }
    notifyVisibilityChanged(paramBoolean);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidLiveWallpaperService.AndroidWallpaperEngine
 * JD-Core Version:    0.6.0
 */