package com.badlogic.gdx.backends.android;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.service.dreams.DreamService;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.LifecycleListener;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.backends.android.surfaceview.FillResolutionStrategy;
import com.badlogic.gdx.backends.android.surfaceview.ResolutionStrategy;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Clipboard;
import com.badlogic.gdx.utils.GdxNativesLoader;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AndroidDaydream extends DreamService
  implements AndroidApplicationBase
{
  protected AndroidAudio audio;
  AndroidClipboard clipboard;
  protected final Array executedRunnables = new Array();
  protected AndroidFiles files;
  protected boolean firstResume = true;
  protected AndroidGraphics graphics;
  protected Handler handler;
  protected AndroidInput input;
  protected final Array lifecycleListeners = new Array();
  protected ApplicationListener listener;
  protected int logLevel = 2;
  protected AndroidNet net;
  protected final Array runnables = new Array();

  static
  {
    GdxNativesLoader.load();
  }

  private void init(ApplicationListener paramApplicationListener, AndroidApplicationConfiguration paramAndroidApplicationConfiguration, boolean paramBoolean)
  {
    if (paramAndroidApplicationConfiguration.resolutionStrategy == null);
    for (Object localObject = new FillResolutionStrategy(); ; localObject = paramAndroidApplicationConfiguration.resolutionStrategy)
    {
      this.graphics = new AndroidGraphics(this, paramAndroidApplicationConfiguration, (ResolutionStrategy)localObject);
      this.input = AndroidInputFactory.newAndroidInput(this, this, this.graphics.view, paramAndroidApplicationConfiguration);
      this.audio = new AndroidAudio(this, paramAndroidApplicationConfiguration);
      getFilesDir();
      this.files = new AndroidFiles(getAssets(), getFilesDir().getAbsolutePath());
      this.net = new AndroidNet(this);
      this.listener = paramApplicationListener;
      this.handler = new Handler();
      addLifecycleListener(new AndroidDaydream.1(this));
      Gdx.app = this;
      Gdx.input = getInput();
      Gdx.audio = getAudio();
      Gdx.files = getFiles();
      Gdx.graphics = getGraphics();
      Gdx.net = getNet();
      if (!paramBoolean)
      {
        setFullscreen(true);
        setContentView(this.graphics.getView(), createLayoutParams());
      }
      createWakeLock(paramAndroidApplicationConfiguration.useWakelock);
      hideStatusBar(paramAndroidApplicationConfiguration);
      return;
    }
  }

  public void addLifecycleListener(LifecycleListener paramLifecycleListener)
  {
    synchronized (this.lifecycleListeners)
    {
      this.lifecycleListeners.add(paramLifecycleListener);
      return;
    }
  }

  protected FrameLayout.LayoutParams createLayoutParams()
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 17;
    return localLayoutParams;
  }

  protected void createWakeLock(boolean paramBoolean)
  {
    if (paramBoolean)
      getWindow().addFlags(128);
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
    this.handler.post(new AndroidDaydream.2(this));
  }

  public ApplicationListener getApplicationListener()
  {
    return this.listener;
  }

  public Window getApplicationWindow()
  {
    return getWindow();
  }

  public Audio getAudio()
  {
    return this.audio;
  }

  public Clipboard getClipboard()
  {
    if (this.clipboard == null)
      this.clipboard = new AndroidClipboard(this);
    return this.clipboard;
  }

  public Context getContext()
  {
    return this;
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
    return this.handler;
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
    return new AndroidPreferences(getSharedPreferences(paramString, 0));
  }

  public Array getRunnables()
  {
    return this.runnables;
  }

  public Application.ApplicationType getType()
  {
    return Application.ApplicationType.Android;
  }

  public int getVersion()
  {
    return Build.VERSION.SDK_INT;
  }

  protected void hideStatusBar(AndroidApplicationConfiguration paramAndroidApplicationConfiguration)
  {
    if ((!paramAndroidApplicationConfiguration.hideStatusBar) || (getVersion() < 11))
      return;
    View localView = getWindow().getDecorView();
    try
    {
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Integer.TYPE;
      Method localMethod = View.class.getMethod("setSystemUiVisibility", arrayOfClass);
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(0);
      localMethod.invoke(localView, arrayOfObject1);
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(1);
      localMethod.invoke(localView, arrayOfObject2);
      return;
    }
    catch (Exception localException)
    {
      log("AndroidApplication", "Can't hide status bar", localException);
    }
  }

  public void initialize(ApplicationListener paramApplicationListener)
  {
    initialize(paramApplicationListener, new AndroidApplicationConfiguration());
  }

  public void initialize(ApplicationListener paramApplicationListener, AndroidApplicationConfiguration paramAndroidApplicationConfiguration)
  {
    init(paramApplicationListener, paramAndroidApplicationConfiguration, false);
  }

  public View initializeForView(ApplicationListener paramApplicationListener)
  {
    return initializeForView(paramApplicationListener, new AndroidApplicationConfiguration());
  }

  public View initializeForView(ApplicationListener paramApplicationListener, AndroidApplicationConfiguration paramAndroidApplicationConfiguration)
  {
    init(paramApplicationListener, paramAndroidApplicationConfiguration, true);
    return this.graphics.getView();
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

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    int i = 1;
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.hardKeyboardHidden == i);
    while (true)
    {
      this.input.keyboardAvailable = i;
      return;
      i = 0;
    }
  }

  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }

  public void onDreamingStarted()
  {
    Gdx.app = this;
    Gdx.input = getInput();
    Gdx.audio = getAudio();
    Gdx.files = getFiles();
    Gdx.graphics = getGraphics();
    Gdx.net = getNet();
    getInput().registerSensorListeners();
    if (this.graphics != null)
      this.graphics.onResumeGLSurfaceView();
    if (!this.firstResume)
      this.graphics.resume();
    while (true)
    {
      super.onDreamingStarted();
      return;
      this.firstResume = false;
    }
  }

  public void onDreamingStopped()
  {
    boolean bool = this.graphics.isContinuousRendering();
    this.graphics.setContinuousRendering(true);
    this.graphics.pause();
    this.input.unregisterSensorListeners();
    Arrays.fill(this.input.realId, -1);
    Arrays.fill(this.input.touched, false);
    this.graphics.clearManagedCaches();
    this.graphics.destroy();
    this.graphics.setContinuousRendering(bool);
    this.graphics.onPauseGLSurfaceView();
    super.onDreamingStopped();
  }

  public void postRunnable(Runnable paramRunnable)
  {
    synchronized (this.runnables)
    {
      this.runnables.add(paramRunnable);
      Gdx.graphics.requestRendering();
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

  public void useImmersiveMode(boolean paramBoolean)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidDaydream
 * JD-Core Version:    0.6.0
 */