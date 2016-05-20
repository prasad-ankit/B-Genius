package com.badlogic.gdx.backends.android.surfaceview;

import android.util.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

class GLSurfaceViewAPI18$DefaultWindowSurfaceFactory
  implements GLSurfaceViewAPI18.EGLWindowSurfaceFactory
{
  public EGLSurface createWindowSurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject)
  {
    try
    {
      EGLSurface localEGLSurface = paramEGL10.eglCreateWindowSurface(paramEGLDisplay, paramEGLConfig, paramObject, null);
      return localEGLSurface;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Log.e("GLSurfaceViewAPI18", "eglCreateWindowSurface", localIllegalArgumentException);
    }
    return null;
  }

  public void destroySurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
  {
    paramEGL10.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.surfaceview.GLSurfaceViewAPI18.DefaultWindowSurfaceFactory
 * JD-Core Version:    0.6.0
 */