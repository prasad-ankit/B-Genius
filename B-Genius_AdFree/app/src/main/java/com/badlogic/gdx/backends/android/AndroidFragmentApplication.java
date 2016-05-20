package com.badlogic.gdx.backends.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.r;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
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
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.File;
import java.lang.reflect.Method;

public class AndroidFragmentApplication extends Fragment
  implements AndroidApplicationBase
{
  private final Array androidEventListeners = new Array();
  protected AndroidAudio audio;
  protected AndroidFragmentApplication.Callbacks callbacks;
  AndroidClipboard clipboard;
  protected final Array executedRunnables = new Array();
  protected AndroidFiles files;
  protected boolean firstResume = true;
  protected AndroidGraphics graphics;
  public Handler handler;
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

  private boolean isAnyParentFragmentRemoving()
  {
    for (Fragment localFragment = getParentFragment(); localFragment != null; localFragment = localFragment.getParentFragment())
      if (localFragment.isRemoving())
        return true;
    return false;
  }

  public void addAndroidEventListener(AndroidEventListener paramAndroidEventListener)
  {
    synchronized (this.androidEventListeners)
    {
      this.androidEventListeners.add(paramAndroidEventListener);
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
      getActivity().getWindow().addFlags(128);
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
    this.handler.post(new AndroidFragmentApplication.2(this));
  }

  public ApplicationListener getApplicationListener()
  {
    return this.listener;
  }

  public Window getApplicationWindow()
  {
    return getActivity().getWindow();
  }

  public Audio getAudio()
  {
    return this.audio;
  }

  public Clipboard getClipboard()
  {
    if (this.clipboard == null)
      this.clipboard = new AndroidClipboard(getActivity());
    return this.clipboard;
  }

  public Context getContext()
  {
    return getActivity();
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
    return new AndroidPreferences(getActivity().getSharedPreferences(paramString, 0));
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

  public WindowManager getWindowManager()
  {
    return (WindowManager)getContext().getSystemService("window");
  }

  public View initializeForView(ApplicationListener paramApplicationListener)
  {
    return initializeForView(paramApplicationListener, new AndroidApplicationConfiguration());
  }

  public View initializeForView(ApplicationListener paramApplicationListener, AndroidApplicationConfiguration paramAndroidApplicationConfiguration)
  {
    if (getVersion() < 8)
      throw new GdxRuntimeException("LibGDX requires Android API Level 8 or later.");
    Object localObject1;
    if (paramAndroidApplicationConfiguration.resolutionStrategy == null)
      localObject1 = new FillResolutionStrategy();
    while (true)
    {
      this.graphics = new AndroidGraphics(this, paramAndroidApplicationConfiguration, (ResolutionStrategy)localObject1);
      this.input = AndroidInputFactory.newAndroidInput(this, getActivity(), this.graphics.view, paramAndroidApplicationConfiguration);
      this.audio = new AndroidAudio(getActivity(), paramAndroidApplicationConfiguration);
      this.files = new AndroidFiles(getResources().getAssets(), getActivity().getFilesDir().getAbsolutePath());
      this.net = new AndroidNet(this);
      this.listener = paramApplicationListener;
      this.handler = new Handler();
      addLifecycleListener(new AndroidFragmentApplication.1(this));
      Gdx.app = this;
      Gdx.input = getInput();
      Gdx.audio = getAudio();
      Gdx.files = getFiles();
      Gdx.graphics = getGraphics();
      Gdx.net = getNet();
      createWakeLock(paramAndroidApplicationConfiguration.useWakelock);
      useImmersiveMode(paramAndroidApplicationConfiguration.useImmersiveMode);
      if ((paramAndroidApplicationConfiguration.useImmersiveMode) && (getVersion() >= 19));
      try
      {
        Class localClass = Class.forName("com.badlogic.gdx.backends.android.AndroidVisibilityListener");
        Object localObject2 = localClass.newInstance();
        localClass.getDeclaredMethod("createListener", new Class[] { AndroidApplicationBase.class }).invoke(localObject2, new Object[] { this });
        return this.graphics.getView();
        localObject1 = paramAndroidApplicationConfiguration.resolutionStrategy;
      }
      catch (Exception localException)
      {
        while (true)
          log("AndroidApplication", "Failed to create AndroidVisibilityListener", localException);
      }
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

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Array localArray = this.androidEventListeners;
    monitorenter;
    int i = 0;
    try
    {
      while (i < this.androidEventListeners.size)
      {
        ((AndroidEventListener)this.androidEventListeners.get(i)).onActivityResult(paramInt1, paramInt2, paramIntent);
        i++;
      }
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void onAttach(Activity paramActivity)
  {
    if ((paramActivity instanceof AndroidFragmentApplication.Callbacks))
      this.callbacks = ((AndroidFragmentApplication.Callbacks)paramActivity);
    while (true)
    {
      super.onAttach(paramActivity);
      return;
      if ((getParentFragment() instanceof AndroidFragmentApplication.Callbacks))
      {
        this.callbacks = ((AndroidFragmentApplication.Callbacks)getParentFragment());
        continue;
      }
      if (!(getTargetFragment() instanceof AndroidFragmentApplication.Callbacks))
        break;
      this.callbacks = ((AndroidFragmentApplication.Callbacks)getTargetFragment());
    }
    throw new RuntimeException("Missing AndroidFragmentApplication.Callbacks. Please implement AndroidFragmentApplication.Callbacks on the parent activity, fragment or target fragment.");
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

  public void onDetach()
  {
    super.onDetach();
    this.callbacks = null;
  }

  public void onPause()
  {
    boolean bool1 = this.graphics.isContinuousRendering();
    boolean bool2 = AndroidGraphics.enforceContinuousRendering;
    AndroidGraphics.enforceContinuousRendering = true;
    this.graphics.setContinuousRendering(true);
    this.graphics.pause();
    this.input.onPause();
    if ((isRemoving()) || (isAnyParentFragmentRemoving()) || (getActivity().isFinishing()))
    {
      this.graphics.clearManagedCaches();
      this.graphics.destroy();
    }
    AndroidGraphics.enforceContinuousRendering = bool2;
    this.graphics.setContinuousRendering(bool1);
    this.graphics.onPauseGLSurfaceView();
    super.onPause();
  }

  public void onResume()
  {
    Gdx.app = this;
    Gdx.input = getInput();
    Gdx.audio = getAudio();
    Gdx.files = getFiles();
    Gdx.graphics = getGraphics();
    Gdx.net = getNet();
    this.input.onResume();
    if (this.graphics != null)
      this.graphics.onResumeGLSurfaceView();
    if (!this.firstResume)
      this.graphics.resume();
    while (true)
    {
      super.onResume();
      return;
      this.firstResume = false;
    }
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

  public void removeAndroidEventListener(AndroidEventListener paramAndroidEventListener)
  {
    synchronized (this.androidEventListeners)
    {
      this.androidEventListeners.removeValue(paramAndroidEventListener, true);
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
    getActivity().runOnUiThread(paramRunnable);
  }

  public void setLogLevel(int paramInt)
  {
    this.logLevel = paramInt;
  }

  public void useImmersiveMode(boolean paramBoolean)
  {
    if ((!paramBoolean) || (getVersion() < 19))
      return;
    try
    {
      View localView = this.graphics.getView();
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Integer.TYPE;
      Method localMethod = View.class.getMethod("setSystemUiVisibility", arrayOfClass);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(5894);
      localMethod.invoke(localView, arrayOfObject);
      return;
    }
    catch (Exception localException)
    {
      log("AndroidApplication", "Failed to setup immersive mode, a throwable has occurred.", localException);
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidFragmentApplication
 * JD-Core Version:    0.6.0
 */