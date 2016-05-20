package com.badlogic.gdx.backends.android;

import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Graphics.BufferFormat;
import com.badlogic.gdx.Graphics.DisplayMode;
import com.badlogic.gdx.Graphics.GraphicsType;
import com.badlogic.gdx.LifecycleListener;
import com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20;
import com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20API18;
import com.badlogic.gdx.backends.android.surfaceview.GLSurfaceViewAPI18;
import com.badlogic.gdx.backends.android.surfaceview.GdxEglConfigChooser;
import com.badlogic.gdx.backends.android.surfaceview.ResolutionStrategy;
import com.badlogic.gdx.graphics.Cubemap;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.WindowedMean;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.lang.reflect.Method;
import java.util.Iterator;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

public class AndroidGraphics
  implements GLSurfaceView.Renderer, Graphics
{
  private static final String LOG_TAG = "AndroidGraphics";
  static volatile boolean enforceContinuousRendering = false;
  AndroidApplicationBase app;
  private Graphics.BufferFormat bufferFormat = new Graphics.BufferFormat(5, 6, 5, 0, 16, 0, 0, false);
  protected final AndroidApplicationConfiguration config;
  volatile boolean created = false;
  protected float deltaTime = 0.0F;
  private float density = 1.0F;
  volatile boolean destroy = false;
  EGLContext eglContext;
  String extensions;
  protected int fps;
  protected long frameId = -1L;
  protected long frameStart = System.nanoTime();
  protected int frames = 0;
  GL20 gl20;
  GL30 gl30;
  int height;
  private boolean isContinuous = true;
  protected long lastFrameTime = System.nanoTime();
  protected WindowedMean mean = new WindowedMean(5);
  volatile boolean pause = false;
  private float ppcX = 0.0F;
  private float ppcY = 0.0F;
  private float ppiX = 0.0F;
  private float ppiY = 0.0F;
  volatile boolean resume = false;
  volatile boolean running = false;
  Object synch = new Object();
  int[] value = new int[1];
  final View view;
  int width;

  public AndroidGraphics(AndroidApplicationBase paramAndroidApplicationBase, AndroidApplicationConfiguration paramAndroidApplicationConfiguration, ResolutionStrategy paramResolutionStrategy)
  {
    this(paramAndroidApplicationBase, paramAndroidApplicationConfiguration, paramResolutionStrategy, true);
  }

  public AndroidGraphics(AndroidApplicationBase paramAndroidApplicationBase, AndroidApplicationConfiguration paramAndroidApplicationConfiguration, ResolutionStrategy paramResolutionStrategy, boolean paramBoolean)
  {
    this.config = paramAndroidApplicationConfiguration;
    this.app = paramAndroidApplicationBase;
    this.view = createGLSurfaceView(paramAndroidApplicationBase, paramResolutionStrategy);
    preserveEGLContextOnPause();
    if (paramBoolean)
    {
      this.view.setFocusable(true);
      this.view.setFocusableInTouchMode(true);
    }
  }

  private int getAttrib(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt1, int paramInt2)
  {
    if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt1, this.value))
      paramInt2 = this.value[0];
    return paramInt2;
  }

  private void logConfig(EGLConfig paramEGLConfig)
  {
    EGL10 localEGL10 = (EGL10)EGLContext.getEGL();
    EGLDisplay localEGLDisplay = localEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    int i = getAttrib(localEGL10, localEGLDisplay, paramEGLConfig, 12324, 0);
    int j = getAttrib(localEGL10, localEGLDisplay, paramEGLConfig, 12323, 0);
    int k = getAttrib(localEGL10, localEGLDisplay, paramEGLConfig, 12322, 0);
    int m = getAttrib(localEGL10, localEGLDisplay, paramEGLConfig, 12321, 0);
    int n = getAttrib(localEGL10, localEGLDisplay, paramEGLConfig, 12325, 0);
    int i1 = getAttrib(localEGL10, localEGLDisplay, paramEGLConfig, 12326, 0);
    int i2 = Math.max(getAttrib(localEGL10, localEGLDisplay, paramEGLConfig, 12337, 0), getAttrib(localEGL10, localEGLDisplay, paramEGLConfig, 12513, 0));
    if (getAttrib(localEGL10, localEGLDisplay, paramEGLConfig, 12513, 0) != 0);
    for (boolean bool = true; ; bool = false)
    {
      Gdx.app.log("AndroidGraphics", "framebuffer: (" + i + ", " + j + ", " + k + ", " + m + ")");
      Gdx.app.log("AndroidGraphics", "depthbuffer: (" + n + ")");
      Gdx.app.log("AndroidGraphics", "stencilbuffer: (" + i1 + ")");
      Gdx.app.log("AndroidGraphics", "samples: (" + i2 + ")");
      Gdx.app.log("AndroidGraphics", "coverage sampling: (" + bool + ")");
      this.bufferFormat = new Graphics.BufferFormat(i, j, k, m, n, i1, i2, bool);
      return;
    }
  }

  private void setupGL(GL10 paramGL10)
  {
    if (this.gl20 != null)
      return;
    this.gl20 = new AndroidGL20();
    Gdx.gl = this.gl20;
    Gdx.gl20 = this.gl20;
    Gdx.app.log("AndroidGraphics", "OGL renderer: " + paramGL10.glGetString(7937));
    Gdx.app.log("AndroidGraphics", "OGL vendor: " + paramGL10.glGetString(7936));
    Gdx.app.log("AndroidGraphics", "OGL version: " + paramGL10.glGetString(7938));
    Gdx.app.log("AndroidGraphics", "OGL extensions: " + paramGL10.glGetString(7939));
  }

  private void updatePpi()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    this.app.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.ppiX = localDisplayMetrics.xdpi;
    this.ppiY = localDisplayMetrics.ydpi;
    this.ppcX = (localDisplayMetrics.xdpi / 2.54F);
    this.ppcY = (localDisplayMetrics.ydpi / 2.54F);
    this.density = localDisplayMetrics.density;
  }

  protected boolean checkGL20()
  {
    EGL10 localEGL10 = (EGL10)EGLContext.getEGL();
    EGLDisplay localEGLDisplay = localEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    localEGL10.eglInitialize(localEGLDisplay, new int[2]);
    int[] arrayOfInt1 = { 12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344 };
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[10];
    int[] arrayOfInt2 = new int[1];
    localEGL10.eglChooseConfig(localEGLDisplay, arrayOfInt1, arrayOfEGLConfig, 10, arrayOfInt2);
    localEGL10.eglTerminate(localEGLDisplay);
    return arrayOfInt2[0] > 0;
  }

  public void clearManagedCaches()
  {
    Mesh.clearAllMeshes(this.app);
    Texture.clearAllTextures(this.app);
    Cubemap.clearAllCubemaps(this.app);
    ShaderProgram.clearAllShaderPrograms(this.app);
    FrameBuffer.clearAllFrameBuffers(this.app);
    logManagedCachesStatus();
  }

  protected View createGLSurfaceView(AndroidApplicationBase paramAndroidApplicationBase, ResolutionStrategy paramResolutionStrategy)
  {
    if (!checkGL20())
      throw new GdxRuntimeException("Libgdx requires OpenGL ES 2.0");
    GLSurfaceView.EGLConfigChooser localEGLConfigChooser = getEglConfigChooser();
    if ((Build.VERSION.SDK_INT <= 10) && (this.config.useGLSurfaceView20API18))
    {
      GLSurfaceView20API18 localGLSurfaceView20API18 = new GLSurfaceView20API18(paramAndroidApplicationBase.getContext(), paramResolutionStrategy);
      if (localEGLConfigChooser != null)
        localGLSurfaceView20API18.setEGLConfigChooser(localEGLConfigChooser);
      while (true)
      {
        localGLSurfaceView20API18.setRenderer(this);
        return localGLSurfaceView20API18;
        localGLSurfaceView20API18.setEGLConfigChooser(this.config.r, this.config.g, this.config.b, this.config.a, this.config.depth, this.config.stencil);
      }
    }
    GLSurfaceView20 localGLSurfaceView20 = new GLSurfaceView20(paramAndroidApplicationBase.getContext(), paramResolutionStrategy);
    if (localEGLConfigChooser != null)
      localGLSurfaceView20.setEGLConfigChooser(localEGLConfigChooser);
    while (true)
    {
      localGLSurfaceView20.setRenderer(this);
      return localGLSurfaceView20;
      localGLSurfaceView20.setEGLConfigChooser(this.config.r, this.config.g, this.config.b, this.config.a, this.config.depth, this.config.stencil);
    }
  }

  void destroy()
  {
    synchronized (this.synch)
    {
      this.running = false;
      this.destroy = true;
      while (true)
      {
        boolean bool = this.destroy;
        if (bool)
          try
          {
            this.synch.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            Gdx.app.log("AndroidGraphics", "waiting for destroy synchronization failed!");
          }
      }
    }
    monitorexit;
  }

  public Graphics.BufferFormat getBufferFormat()
  {
    return this.bufferFormat;
  }

  public float getDeltaTime()
  {
    if (this.mean.getMean() == 0.0F)
      return this.deltaTime;
    return this.mean.getMean();
  }

  public float getDensity()
  {
    return this.density;
  }

  public Graphics.DisplayMode getDesktopDisplayMode()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    this.app.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return new AndroidGraphics.AndroidDisplayMode(this, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels, 0, 0);
  }

  public Graphics.DisplayMode[] getDisplayModes()
  {
    Graphics.DisplayMode[] arrayOfDisplayMode = new Graphics.DisplayMode[1];
    arrayOfDisplayMode[0] = getDesktopDisplayMode();
    return arrayOfDisplayMode;
  }

  protected GLSurfaceView.EGLConfigChooser getEglConfigChooser()
  {
    return new GdxEglConfigChooser(this.config.r, this.config.g, this.config.b, this.config.a, this.config.depth, this.config.stencil, this.config.numSamples);
  }

  public long getFrameId()
  {
    return this.frameId;
  }

  public int getFramesPerSecond()
  {
    return this.fps;
  }

  public GL20 getGL20()
  {
    return this.gl20;
  }

  public GL30 getGL30()
  {
    return this.gl30;
  }

  public int getHeight()
  {
    return this.height;
  }

  public float getPpcX()
  {
    return this.ppcX;
  }

  public float getPpcY()
  {
    return this.ppcY;
  }

  public float getPpiX()
  {
    return this.ppiX;
  }

  public float getPpiY()
  {
    return this.ppiY;
  }

  public float getRawDeltaTime()
  {
    return this.deltaTime;
  }

  public Graphics.GraphicsType getType()
  {
    return Graphics.GraphicsType.AndroidGL;
  }

  public View getView()
  {
    return this.view;
  }

  public int getWidth()
  {
    return this.width;
  }

  public boolean isContinuousRendering()
  {
    return this.isContinuous;
  }

  public boolean isFullscreen()
  {
    return true;
  }

  public boolean isGL30Available()
  {
    return this.gl30 != null;
  }

  protected void logManagedCachesStatus()
  {
    Gdx.app.log("AndroidGraphics", Mesh.getManagedStatus());
    Gdx.app.log("AndroidGraphics", Texture.getManagedStatus());
    Gdx.app.log("AndroidGraphics", Cubemap.getManagedStatus());
    Gdx.app.log("AndroidGraphics", ShaderProgram.getManagedStatus());
    Gdx.app.log("AndroidGraphics", FrameBuffer.getManagedStatus());
  }

  public Cursor newCursor(Pixmap paramPixmap, int paramInt1, int paramInt2)
  {
    return null;
  }

  public void onDrawFrame(GL10 paramGL10)
  {
    long l = System.nanoTime();
    this.deltaTime = ((float)(l - this.lastFrameTime) / 1.0E+009F);
    this.lastFrameTime = l;
    if (!this.resume)
      this.mean.addValue(this.deltaTime);
    boolean bool1;
    boolean bool2;
    boolean bool3;
    synchronized (this.synch)
    {
      bool1 = this.running;
      bool2 = this.pause;
      bool3 = this.destroy;
      boolean bool4 = this.resume;
      if (this.resume)
        this.resume = false;
      if (this.pause)
      {
        this.pause = false;
        this.synch.notifyAll();
      }
      if (this.destroy)
      {
        this.destroy = false;
        this.synch.notifyAll();
      }
      if (!bool4)
        break label236;
      synchronized (this.app.getLifecycleListeners())
      {
        Iterator localIterator3 = ???.iterator();
        if (!localIterator3.hasNext())
          break label206;
        ((LifecycleListener)localIterator3.next()).resume();
      }
      this.deltaTime = 0.0F;
    }
    label206: monitorexit;
    this.app.getApplicationListener().resume();
    Gdx.app.log("AndroidGraphics", "resumed");
    label236: if (bool1)
    {
      while (true)
      {
        int i;
        synchronized (this.app.getRunnables())
        {
          this.app.getExecutedRunnables().clear();
          this.app.getExecutedRunnables().addAll(this.app.getRunnables());
          this.app.getRunnables().clear();
          i = 0;
          if (i >= this.app.getExecutedRunnables().size)
            break label369;
        }
        try
        {
          ((Runnable)this.app.getExecutedRunnables().get(i)).run();
          i++;
          continue;
          localObject5 = finally;
          monitorexit;
          throw localObject5;
        }
        catch (Throwable localThrowable)
        {
          while (true)
            localThrowable.printStackTrace();
        }
      }
      label369: this.app.getInput().processEvents();
      this.frameId = (1L + this.frameId);
      this.app.getApplicationListener().render();
    }
    if (bool2)
    {
      synchronized (this.app.getLifecycleListeners())
      {
        Iterator localIterator2 = ???.iterator();
        if (localIterator2.hasNext())
          ((LifecycleListener)localIterator2.next()).pause();
      }
      monitorexit;
      this.app.getApplicationListener().pause();
      Gdx.app.log("AndroidGraphics", "paused");
    }
    if (bool3)
    {
      synchronized (this.app.getLifecycleListeners())
      {
        Iterator localIterator1 = ???.iterator();
        if (localIterator1.hasNext())
          ((LifecycleListener)localIterator1.next()).dispose();
      }
      monitorexit;
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

  public void onPauseGLSurfaceView()
  {
    if (this.view != null)
    {
      if ((this.view instanceof GLSurfaceViewAPI18))
        ((GLSurfaceViewAPI18)this.view).onPause();
      if ((this.view instanceof GLSurfaceView))
        ((GLSurfaceView)this.view).onPause();
    }
  }

  public void onResumeGLSurfaceView()
  {
    if (this.view != null)
    {
      if ((this.view instanceof GLSurfaceViewAPI18))
        ((GLSurfaceViewAPI18)this.view).onResume();
      if ((this.view instanceof GLSurfaceView))
        ((GLSurfaceView)this.view).onResume();
    }
  }

  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    updatePpi();
    paramGL10.glViewport(0, 0, this.width, this.height);
    if (!this.created)
    {
      this.app.getApplicationListener().create();
      this.created = true;
      monitorenter;
    }
    try
    {
      this.running = true;
      monitorexit;
      this.app.getApplicationListener().resize(paramInt1, paramInt2);
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    this.eglContext = ((EGL10)EGLContext.getEGL()).eglGetCurrentContext();
    setupGL(paramGL10);
    logConfig(paramEGLConfig);
    updatePpi();
    Mesh.invalidateAllMeshes(this.app);
    Texture.invalidateAllTextures(this.app);
    Cubemap.invalidateAllCubemaps(this.app);
    ShaderProgram.invalidateAllShaderPrograms(this.app);
    FrameBuffer.invalidateAllFrameBuffers(this.app);
    logManagedCachesStatus();
    Display localDisplay = this.app.getWindowManager().getDefaultDisplay();
    this.width = localDisplay.getWidth();
    this.height = localDisplay.getHeight();
    this.mean = new WindowedMean(5);
    this.lastFrameTime = System.nanoTime();
    paramGL10.glViewport(0, 0, this.width, this.height);
  }

  void pause()
  {
    synchronized (this.synch)
    {
      if (!this.running)
        return;
      this.running = false;
      this.pause = true;
      while (true)
      {
        boolean bool = this.pause;
        if (bool)
          try
          {
            this.synch.wait(4000L);
            if (!this.pause)
              continue;
            Gdx.app.error("AndroidGraphics", "waiting for pause synchronization took too long; assuming deadlock and killing");
            Process.killProcess(Process.myPid());
          }
          catch (InterruptedException localInterruptedException)
          {
            Gdx.app.log("AndroidGraphics", "waiting for pause synchronization failed!");
          }
      }
    }
    monitorexit;
  }

  protected void preserveEGLContextOnPause()
  {
    if (((Build.VERSION.SDK_INT >= 11) && ((this.view instanceof GLSurfaceView20))) || ((this.view instanceof GLSurfaceView20API18)));
    try
    {
      Class localClass = this.view.getClass();
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Boolean.TYPE;
      Method localMethod = localClass.getMethod("setPreserveEGLContextOnPause", arrayOfClass);
      View localView = this.view;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Boolean.valueOf(true);
      localMethod.invoke(localView, arrayOfObject);
      return;
    }
    catch (Exception localException)
    {
      Gdx.app.log("AndroidGraphics", "Method GLSurfaceView.setPreserveEGLContextOnPause not found");
    }
  }

  public void requestRendering()
  {
    if (this.view != null)
    {
      if ((this.view instanceof GLSurfaceViewAPI18))
        ((GLSurfaceViewAPI18)this.view).requestRender();
      if ((this.view instanceof GLSurfaceView))
        ((GLSurfaceView)this.view).requestRender();
    }
  }

  void resume()
  {
    synchronized (this.synch)
    {
      this.running = true;
      this.resume = true;
      return;
    }
  }

  public void setContinuousRendering(boolean paramBoolean)
  {
    int i = 1;
    int j;
    if (this.view != null)
    {
      if ((!enforceContinuousRendering) && (!paramBoolean))
        break label83;
      j = i;
      this.isContinuous = j;
      if (!this.isContinuous)
        break label88;
    }
    while (true)
    {
      if ((this.view instanceof GLSurfaceViewAPI18))
        ((GLSurfaceViewAPI18)this.view).setRenderMode(i);
      if ((this.view instanceof GLSurfaceView))
        ((GLSurfaceView)this.view).setRenderMode(i);
      this.mean.clear();
      return;
      label83: j = 0;
      break;
      label88: i = 0;
    }
  }

  public void setCursor(Cursor paramCursor)
  {
  }

  public boolean setDisplayMode(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return false;
  }

  public boolean setDisplayMode(Graphics.DisplayMode paramDisplayMode)
  {
    return false;
  }

  public void setTitle(String paramString)
  {
  }

  public void setVSync(boolean paramBoolean)
  {
  }

  public boolean supportsDisplayModeChange()
  {
    return false;
  }

  public boolean supportsExtension(String paramString)
  {
    if (this.extensions == null)
      this.extensions = Gdx.gl.glGetString(7939);
    return this.extensions.contains(paramString);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidGraphics
 * JD-Core Version:    0.6.0
 */