package com.badlogic.gdx.backends.android.surfaceview;

import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.util.Log;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

class GLSurfaceViewAPI18$EglHelper
{
  EGL10 mEgl;
  EGLConfig mEglConfig;
  EGLContext mEglContext;
  EGLDisplay mEglDisplay;
  EGLSurface mEglSurface;
  private WeakReference mGLSurfaceViewWeakRef;

  public GLSurfaceViewAPI18$EglHelper(WeakReference paramWeakReference)
  {
    this.mGLSurfaceViewWeakRef = paramWeakReference;
  }

  private void destroySurfaceImp()
  {
    if ((this.mEglSurface != null) && (this.mEglSurface != EGL10.EGL_NO_SURFACE))
    {
      this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      GLSurfaceViewAPI18 localGLSurfaceViewAPI18 = (GLSurfaceViewAPI18)this.mGLSurfaceViewWeakRef.get();
      if (localGLSurfaceViewAPI18 != null)
        GLSurfaceViewAPI18.access$500(localGLSurfaceViewAPI18).destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
      this.mEglSurface = null;
    }
  }

  public static String formatEglError(String paramString, int paramInt)
  {
    return paramString + " failed: " + getErrorString(paramInt);
  }

  private static String getErrorString(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "0x" + Integer.toHexString(paramInt);
    case 12288:
      return "EGL_SUCCESS";
    case 12289:
      return "EGL_NOT_INITIALIZED";
    case 12290:
      return "EGL_BAD_ACCESS";
    case 12291:
      return "EGL_BAD_ALLOC";
    case 12292:
      return "EGL_BAD_ATTRIBUTE";
    case 12293:
      return "EGL_BAD_CONFIG";
    case 12294:
      return "EGL_BAD_CONTEXT";
    case 12295:
      return "EGL_BAD_CURRENT_SURFACE";
    case 12296:
      return "EGL_BAD_DISPLAY";
    case 12297:
      return "EGL_BAD_MATCH";
    case 12298:
      return "EGL_BAD_NATIVE_PIXMAP";
    case 12299:
      return "EGL_BAD_NATIVE_WINDOW";
    case 12300:
      return "EGL_BAD_PARAMETER";
    case 12301:
      return "EGL_BAD_SURFACE";
    case 12302:
    }
    return "EGL_CONTEXT_LOST";
  }

  public static void logEglErrorAsWarning(String paramString1, String paramString2, int paramInt)
  {
    Log.w(paramString1, formatEglError(paramString2, paramInt));
  }

  private void throwEglException(String paramString)
  {
    throwEglException(paramString, this.mEgl.eglGetError());
  }

  public static void throwEglException(String paramString, int paramInt)
  {
    throw new RuntimeException(formatEglError(paramString, paramInt));
  }

  GL createGL()
  {
    GL localGL = this.mEglContext.getGL();
    GLSurfaceViewAPI18 localGLSurfaceViewAPI18 = (GLSurfaceViewAPI18)this.mGLSurfaceViewWeakRef.get();
    int j;
    if (localGLSurfaceViewAPI18 != null)
    {
      if (GLSurfaceViewAPI18.access$600(localGLSurfaceViewAPI18) != null)
        localGL = GLSurfaceViewAPI18.access$600(localGLSurfaceViewAPI18).wrap(localGL);
      if ((0x3 & GLSurfaceViewAPI18.access$700(localGLSurfaceViewAPI18)) != 0)
      {
        int i = 0x1 & GLSurfaceViewAPI18.access$700(localGLSurfaceViewAPI18);
        j = 0;
        if (i != 0)
          j = 1;
        if ((0x2 & GLSurfaceViewAPI18.access$700(localGLSurfaceViewAPI18)) == 0)
          break label96;
      }
    }
    label96: for (GLSurfaceViewAPI18.LogWriter localLogWriter = new GLSurfaceViewAPI18.LogWriter(); ; localLogWriter = null)
    {
      localGL = GLDebugHelper.wrap(localGL, j, localLogWriter);
      return localGL;
    }
  }

  public boolean createSurface()
  {
    if (this.mEgl == null)
      throw new RuntimeException("egl not initialized");
    if (this.mEglDisplay == null)
      throw new RuntimeException("eglDisplay not initialized");
    if (this.mEglConfig == null)
      throw new RuntimeException("mEglConfig not initialized");
    destroySurfaceImp();
    GLSurfaceViewAPI18 localGLSurfaceViewAPI18 = (GLSurfaceViewAPI18)this.mGLSurfaceViewWeakRef.get();
    if (localGLSurfaceViewAPI18 != null);
    for (this.mEglSurface = GLSurfaceViewAPI18.access$500(localGLSurfaceViewAPI18).createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, localGLSurfaceViewAPI18.getHolder()); (this.mEglSurface == null) || (this.mEglSurface == EGL10.EGL_NO_SURFACE); this.mEglSurface = null)
    {
      if (this.mEgl.eglGetError() == 12299)
        Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
      return false;
    }
    if (!this.mEgl.eglMakeCurrent(this.mEglDisplay, this.mEglSurface, this.mEglSurface, this.mEglContext))
    {
      logEglErrorAsWarning("EGLHelper", "eglMakeCurrent", this.mEgl.eglGetError());
      return false;
    }
    return true;
  }

  public void destroySurface()
  {
    destroySurfaceImp();
  }

  public void finish()
  {
    if (this.mEglContext != null)
    {
      GLSurfaceViewAPI18 localGLSurfaceViewAPI18 = (GLSurfaceViewAPI18)this.mGLSurfaceViewWeakRef.get();
      if (localGLSurfaceViewAPI18 != null)
        GLSurfaceViewAPI18.access$400(localGLSurfaceViewAPI18).destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
      this.mEglContext = null;
    }
    if (this.mEglDisplay != null)
    {
      this.mEgl.eglTerminate(this.mEglDisplay);
      this.mEglDisplay = null;
    }
  }

  public void start()
  {
    this.mEgl = ((EGL10)EGLContext.getEGL());
    this.mEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (this.mEglDisplay == EGL10.EGL_NO_DISPLAY)
      throw new RuntimeException("eglGetDisplay failed");
    int[] arrayOfInt = new int[2];
    if (!this.mEgl.eglInitialize(this.mEglDisplay, arrayOfInt))
      throw new RuntimeException("eglInitialize failed");
    GLSurfaceViewAPI18 localGLSurfaceViewAPI18 = (GLSurfaceViewAPI18)this.mGLSurfaceViewWeakRef.get();
    if (localGLSurfaceViewAPI18 == null)
      this.mEglConfig = null;
    for (this.mEglContext = null; ; this.mEglContext = GLSurfaceViewAPI18.access$400(localGLSurfaceViewAPI18).createContext(this.mEgl, this.mEglDisplay, this.mEglConfig))
    {
      if ((this.mEglContext == null) || (this.mEglContext == EGL10.EGL_NO_CONTEXT))
      {
        this.mEglContext = null;
        throwEglException("createContext");
      }
      this.mEglSurface = null;
      return;
      this.mEglConfig = GLSurfaceViewAPI18.access$300(localGLSurfaceViewAPI18).chooseConfig(this.mEgl, this.mEglDisplay);
    }
  }

  public int swap()
  {
    if (!this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface))
      return this.mEgl.eglGetError();
    return 12288;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.surfaceview.GLSurfaceViewAPI18.EglHelper
 * JD-Core Version:    0.6.0
 */