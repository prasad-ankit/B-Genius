package com.badlogic.gdx.backends.android.surfaceview;

import android.util.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

class GLSurfaceView20API18$ContextFactory
  implements GLSurfaceViewAPI18.EGLContextFactory
{
  private static int EGL_CONTEXT_CLIENT_VERSION = 12440;

  public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    Log.w(GLSurfaceView20API18.TAG, "creating OpenGL ES 2.0 context");
    GLSurfaceView20API18.checkEglError("Before eglCreateContext", paramEGL10);
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = EGL_CONTEXT_CLIENT_VERSION;
    arrayOfInt[1] = 2;
    arrayOfInt[2] = 12344;
    EGLContext localEGLContext = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, arrayOfInt);
    GLSurfaceView20API18.checkEglError("After eglCreateContext", paramEGL10);
    return localEGLContext;
  }

  public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20API18.ContextFactory
 * JD-Core Version:    0.6.0
 */