package com.badlogic.gdx.backends.android.surfaceview;

import android.util.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

class GLSurfaceViewAPI18$DefaultContextFactory
  implements GLSurfaceViewAPI18.EGLContextFactory
{
  private int EGL_CONTEXT_CLIENT_VERSION = 12440;

  private GLSurfaceViewAPI18$DefaultContextFactory(GLSurfaceViewAPI18 paramGLSurfaceViewAPI18)
  {
  }

  public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = this.EGL_CONTEXT_CLIENT_VERSION;
    arrayOfInt[1] = GLSurfaceViewAPI18.access$200(this.this$0);
    arrayOfInt[2] = 12344;
    EGLContext localEGLContext = EGL10.EGL_NO_CONTEXT;
    if (GLSurfaceViewAPI18.access$200(this.this$0) != 0);
    while (true)
    {
      return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, localEGLContext, arrayOfInt);
      arrayOfInt = null;
    }
  }

  public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
    {
      Log.e("DefaultContextFactory", "display:" + paramEGLDisplay + " context: " + paramEGLContext);
      GLSurfaceViewAPI18.EglHelper.throwEglException("eglDestroyContex", paramEGL10.eglGetError());
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.surfaceview.GLSurfaceViewAPI18.DefaultContextFactory
 * JD-Core Version:    0.6.0
 */