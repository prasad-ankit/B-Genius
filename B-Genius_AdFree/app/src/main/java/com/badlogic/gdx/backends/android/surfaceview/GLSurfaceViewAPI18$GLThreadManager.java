package com.badlogic.gdx.backends.android.surfaceview;

import javax.microedition.khronos.opengles.GL10;

class GLSurfaceViewAPI18$GLThreadManager
{
  private static String TAG = "GLThreadManager";
  private static final int kGLES_20 = 131072;
  private static final String kMSM7K_RENDERER_PREFIX = "Q3Dimension MSM7500 ";
  private GLSurfaceViewAPI18.GLThread mEglOwner;
  private boolean mGLESDriverCheckComplete;
  private int mGLESVersion;
  private boolean mGLESVersionCheckComplete;
  private boolean mLimitedGLESContexts;
  private boolean mMultipleGLESContextsAllowed;

  private void checkGLESVersion()
  {
    if (!this.mGLESVersionCheckComplete)
    {
      this.mGLESVersion = 131072;
      if (this.mGLESVersion >= 131072)
        this.mMultipleGLESContextsAllowed = true;
      this.mGLESVersionCheckComplete = true;
    }
  }

  public void checkGLDriver(GL10 paramGL10)
  {
    boolean bool1 = true;
    monitorenter;
    try
    {
      boolean bool2;
      if (!this.mGLESDriverCheckComplete)
      {
        checkGLESVersion();
        String str = paramGL10.glGetString(7937);
        if (this.mGLESVersion < 131072)
        {
          if (str.startsWith("Q3Dimension MSM7500 "))
            break label78;
          bool2 = bool1;
          this.mMultipleGLESContextsAllowed = bool2;
          notifyAll();
        }
        if (this.mMultipleGLESContextsAllowed)
          break label84;
      }
      while (true)
      {
        this.mLimitedGLESContexts = bool1;
        this.mGLESDriverCheckComplete = true;
        return;
        label78: bool2 = false;
        break;
        label84: bool1 = false;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void releaseEglContextLocked(GLSurfaceViewAPI18.GLThread paramGLThread)
  {
    if (this.mEglOwner == paramGLThread)
      this.mEglOwner = null;
    notifyAll();
  }

  public boolean shouldReleaseEGLContextWhenPausing()
  {
    monitorenter;
    try
    {
      boolean bool = this.mLimitedGLESContexts;
      monitorexit;
      return bool;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public boolean shouldTerminateEGLWhenPausing()
  {
    monitorenter;
    try
    {
      checkGLESVersion();
      boolean bool = this.mMultipleGLESContextsAllowed;
      if (!bool)
      {
        i = 1;
        return i;
      }
      int i = 0;
    }
    finally
    {
      monitorexit;
    }
  }

  public void threadExiting(GLSurfaceViewAPI18.GLThread paramGLThread)
  {
    monitorenter;
    try
    {
      GLSurfaceViewAPI18.GLThread.access$1102(paramGLThread, true);
      if (this.mEglOwner == paramGLThread)
        this.mEglOwner = null;
      notifyAll();
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public boolean tryAcquireEglContextLocked(GLSurfaceViewAPI18.GLThread paramGLThread)
  {
    if ((this.mEglOwner == paramGLThread) || (this.mEglOwner == null))
    {
      this.mEglOwner = paramGLThread;
      notifyAll();
    }
    do
    {
      return true;
      checkGLESVersion();
    }
    while (this.mMultipleGLESContextsAllowed);
    if (this.mEglOwner != null)
      this.mEglOwner.requestReleaseEglContextLocked();
    return false;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.surfaceview.GLSurfaceViewAPI18.GLThreadManager
 * JD-Core Version:    0.6.0
 */