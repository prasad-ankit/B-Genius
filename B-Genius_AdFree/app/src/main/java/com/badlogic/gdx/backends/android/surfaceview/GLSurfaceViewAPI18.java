package com.badlogic.gdx.backends.android.surfaceview;

import android.content.Context;
import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import java.lang.ref.WeakReference;

public class GLSurfaceViewAPI18 extends SurfaceView
  implements SurfaceHolder.Callback
{
  public static final int DEBUG_CHECK_GL_ERROR = 1;
  public static final int DEBUG_LOG_GL_CALLS = 2;
  private static final boolean LOG_ATTACH_DETACH = false;
  private static final boolean LOG_EGL = false;
  private static final boolean LOG_PAUSE_RESUME = false;
  private static final boolean LOG_RENDERER = false;
  private static final boolean LOG_RENDERER_DRAW_FRAME = false;
  private static final boolean LOG_SURFACE = false;
  private static final boolean LOG_THREADS = false;
  public static final int RENDERMODE_CONTINUOUSLY = 1;
  public static final int RENDERMODE_WHEN_DIRTY = 0;
  private static final String TAG = "GLSurfaceViewAPI18";
  private static final GLSurfaceViewAPI18.GLThreadManager sGLThreadManager = new GLSurfaceViewAPI18.GLThreadManager(null);
  private int mDebugFlags;
  private boolean mDetached;
  private GLSurfaceView.EGLConfigChooser mEGLConfigChooser;
  private int mEGLContextClientVersion;
  private GLSurfaceViewAPI18.EGLContextFactory mEGLContextFactory;
  private GLSurfaceViewAPI18.EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
  private GLSurfaceViewAPI18.GLThread mGLThread;
  private GLSurfaceViewAPI18.GLWrapper mGLWrapper;
  private boolean mPreserveEGLContextOnPause;
  private GLSurfaceView.Renderer mRenderer;
  private final WeakReference mThisWeakRef = new WeakReference(this);

  public GLSurfaceViewAPI18(Context paramContext)
  {
    super(paramContext);
    init();
  }

  public GLSurfaceViewAPI18(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }

  private void checkRenderThreadState()
  {
    if (this.mGLThread != null)
      throw new IllegalStateException("setRenderer has already been called for this instance.");
  }

  private void init()
  {
    SurfaceHolder localSurfaceHolder = getHolder();
    localSurfaceHolder.addCallback(this);
    if (Build.VERSION.SDK_INT <= 8)
      localSurfaceHolder.setFormat(4);
  }

  protected void finalize()
  {
    try
    {
      if (this.mGLThread != null)
        this.mGLThread.requestExitAndWait();
      return;
    }
    finally
    {
      super.finalize();
    }
    throw localObject;
  }

  public int getDebugFlags()
  {
    return this.mDebugFlags;
  }

  public boolean getPreserveEGLContextOnPause()
  {
    return this.mPreserveEGLContextOnPause;
  }

  public int getRenderMode()
  {
    return this.mGLThread.getRenderMode();
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.mDetached) && (this.mRenderer != null))
      if (this.mGLThread == null)
        break label74;
    label74: for (int i = this.mGLThread.getRenderMode(); ; i = 1)
    {
      this.mGLThread = new GLSurfaceViewAPI18.GLThread(this.mThisWeakRef);
      if (i != 1)
        this.mGLThread.setRenderMode(i);
      this.mGLThread.start();
      this.mDetached = false;
      return;
    }
  }

  protected void onDetachedFromWindow()
  {
    if (this.mGLThread != null)
      this.mGLThread.requestExitAndWait();
    this.mDetached = true;
    super.onDetachedFromWindow();
  }

  public void onPause()
  {
    this.mGLThread.onPause();
  }

  public void onResume()
  {
    this.mGLThread.onResume();
  }

  public void queueEvent(Runnable paramRunnable)
  {
    this.mGLThread.queueEvent(paramRunnable);
  }

  public void requestRender()
  {
    this.mGLThread.requestRender();
  }

  public void setDebugFlags(int paramInt)
  {
    this.mDebugFlags = paramInt;
  }

  public void setEGLConfigChooser(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    setEGLConfigChooser(new GLSurfaceViewAPI18.ComponentSizeChooser(this, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6));
  }

  public void setEGLConfigChooser(GLSurfaceView.EGLConfigChooser paramEGLConfigChooser)
  {
    checkRenderThreadState();
    this.mEGLConfigChooser = paramEGLConfigChooser;
  }

  public void setEGLConfigChooser(boolean paramBoolean)
  {
    setEGLConfigChooser(new GLSurfaceViewAPI18.SimpleEGLConfigChooser(this, paramBoolean));
  }

  public void setEGLContextClientVersion(int paramInt)
  {
    checkRenderThreadState();
    this.mEGLContextClientVersion = paramInt;
  }

  public void setEGLContextFactory(GLSurfaceViewAPI18.EGLContextFactory paramEGLContextFactory)
  {
    checkRenderThreadState();
    this.mEGLContextFactory = paramEGLContextFactory;
  }

  public void setEGLWindowSurfaceFactory(GLSurfaceViewAPI18.EGLWindowSurfaceFactory paramEGLWindowSurfaceFactory)
  {
    checkRenderThreadState();
    this.mEGLWindowSurfaceFactory = paramEGLWindowSurfaceFactory;
  }

  public void setGLWrapper(GLSurfaceViewAPI18.GLWrapper paramGLWrapper)
  {
    this.mGLWrapper = paramGLWrapper;
  }

  public void setPreserveEGLContextOnPause(boolean paramBoolean)
  {
    this.mPreserveEGLContextOnPause = paramBoolean;
  }

  public void setRenderMode(int paramInt)
  {
    this.mGLThread.setRenderMode(paramInt);
  }

  public void setRenderer(GLSurfaceView.Renderer paramRenderer)
  {
    checkRenderThreadState();
    if (this.mEGLConfigChooser == null)
      this.mEGLConfigChooser = new GLSurfaceViewAPI18.SimpleEGLConfigChooser(this, true);
    if (this.mEGLContextFactory == null)
      this.mEGLContextFactory = new GLSurfaceViewAPI18.DefaultContextFactory(this, null);
    if (this.mEGLWindowSurfaceFactory == null)
      this.mEGLWindowSurfaceFactory = new GLSurfaceViewAPI18.DefaultWindowSurfaceFactory(null);
    this.mRenderer = paramRenderer;
    this.mGLThread = new GLSurfaceViewAPI18.GLThread(this.mThisWeakRef);
    this.mGLThread.start();
  }

  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mGLThread.onWindowResize(paramInt2, paramInt3);
  }

  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.mGLThread.surfaceCreated();
  }

  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.mGLThread.surfaceDestroyed();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.surfaceview.GLSurfaceViewAPI18
 * JD-Core Version:    0.6.0
 */