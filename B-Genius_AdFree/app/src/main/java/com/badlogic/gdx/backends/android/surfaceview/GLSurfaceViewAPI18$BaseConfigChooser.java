package com.badlogic.gdx.backends.android.surfaceview;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

abstract class GLSurfaceViewAPI18$BaseConfigChooser
  implements GLSurfaceView.EGLConfigChooser
{
  protected int[] mConfigSpec = filterConfigSpec(paramArrayOfInt);

  public GLSurfaceViewAPI18$BaseConfigChooser(GLSurfaceViewAPI18 paramGLSurfaceViewAPI18, int[] paramArrayOfInt)
  {
  }

  private int[] filterConfigSpec(int[] paramArrayOfInt)
  {
    if (GLSurfaceViewAPI18.access$200(this.this$0) != 2)
      return paramArrayOfInt;
    int i = paramArrayOfInt.length;
    int[] arrayOfInt = new int[i + 2];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, i - 1);
    arrayOfInt[(i - 1)] = 12352;
    arrayOfInt[i] = 4;
    arrayOfInt[(i + 1)] = 12344;
    return arrayOfInt;
  }

  public EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
  {
    int[] arrayOfInt = new int[1];
    if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.mConfigSpec, null, 0, arrayOfInt))
      throw new IllegalArgumentException("eglChooseConfig failed");
    int i = arrayOfInt[0];
    if (i <= 0)
      throw new IllegalArgumentException("No configs match configSpec");
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
    if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.mConfigSpec, arrayOfEGLConfig, i, arrayOfInt))
      throw new IllegalArgumentException("eglChooseConfig#2 failed");
    EGLConfig localEGLConfig = chooseConfig(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
    if (localEGLConfig == null)
      throw new IllegalArgumentException("No config chosen");
    return localEGLConfig;
  }

  abstract EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.surfaceview.GLSurfaceViewAPI18.BaseConfigChooser
 * JD-Core Version:    0.6.0
 */