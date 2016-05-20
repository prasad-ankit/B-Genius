package com.badlogic.gdx.backends.android.surfaceview;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.util.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

public class GdxEglConfigChooser
  implements GLSurfaceView.EGLConfigChooser
{
  public static final int EGL_COVERAGE_BUFFERS_NV = 12512;
  public static final int EGL_COVERAGE_SAMPLES_NV = 12513;
  private static final int EGL_OPENGL_ES2_BIT = 4;
  private static final String TAG = "GdxEglConfigChooser";
  protected int mAlphaSize;
  protected int mBlueSize;
  protected final int[] mConfigAttribs;
  protected int mDepthSize;
  protected int mGreenSize;
  protected int mNumSamples;
  protected int mRedSize;
  protected int mStencilSize;
  private int[] mValue = new int[1];

  public GdxEglConfigChooser(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.mRedSize = paramInt1;
    this.mGreenSize = paramInt2;
    this.mBlueSize = paramInt3;
    this.mAlphaSize = paramInt4;
    this.mDepthSize = paramInt5;
    this.mStencilSize = paramInt6;
    this.mNumSamples = paramInt7;
    this.mConfigAttribs = new int[] { 12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344 };
  }

  private int findConfigAttrib(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt1, int paramInt2)
  {
    if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt1, this.mValue))
      paramInt2 = this.mValue[0];
    return paramInt2;
  }

  private void printConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    int[] arrayOfInt1 = { 12320, 12321, 12322, 12323, 12324, 12325, 12326, 12327, 12328, 12329, 12330, 12331, 12332, 12333, 12334, 12335, 12336, 12337, 12338, 12339, 12340, 12343, 12342, 12341, 12345, 12346, 12347, 12348, 12349, 12350, 12351, 12352, 12354, 12512, 12513 };
    String[] arrayOfString = { "EGL_BUFFER_SIZE", "EGL_ALPHA_SIZE", "EGL_BLUE_SIZE", "EGL_GREEN_SIZE", "EGL_RED_SIZE", "EGL_DEPTH_SIZE", "EGL_STENCIL_SIZE", "EGL_CONFIG_CAVEAT", "EGL_CONFIG_ID", "EGL_LEVEL", "EGL_MAX_PBUFFER_HEIGHT", "EGL_MAX_PBUFFER_PIXELS", "EGL_MAX_PBUFFER_WIDTH", "EGL_NATIVE_RENDERABLE", "EGL_NATIVE_VISUAL_ID", "EGL_NATIVE_VISUAL_TYPE", "EGL_PRESERVED_RESOURCES", "EGL_SAMPLES", "EGL_SAMPLE_BUFFERS", "EGL_SURFACE_TYPE", "EGL_TRANSPARENT_TYPE", "EGL_TRANSPARENT_RED_VALUE", "EGL_TRANSPARENT_GREEN_VALUE", "EGL_TRANSPARENT_BLUE_VALUE", "EGL_BIND_TO_TEXTURE_RGB", "EGL_BIND_TO_TEXTURE_RGBA", "EGL_MIN_SWAP_INTERVAL", "EGL_MAX_SWAP_INTERVAL", "EGL_LUMINANCE_SIZE", "EGL_ALPHA_MASK_SIZE", "EGL_COLOR_BUFFER_TYPE", "EGL_RENDERABLE_TYPE", "EGL_CONFORMANT", "EGL_COVERAGE_BUFFERS_NV", "EGL_COVERAGE_SAMPLES_NV" };
    int[] arrayOfInt2 = new int[1];
    int i = 0;
    if (i < 35)
    {
      int j = arrayOfInt1[i];
      String str = arrayOfString[i];
      if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, j, arrayOfInt2))
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = str;
        arrayOfObject[1] = Integer.valueOf(arrayOfInt2[0]);
        Log.w("GdxEglConfigChooser", String.format("  %s: %d\n", arrayOfObject));
      }
      while (true)
      {
        i++;
        break;
        paramEGL10.eglGetError();
      }
    }
  }

  private void printConfigs(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
  {
    int i = paramArrayOfEGLConfig.length;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = Integer.valueOf(i);
    Log.w("GdxEglConfigChooser", String.format("%d configurations", arrayOfObject1));
    for (int j = 0; j < i; j++)
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(j);
      Log.w("GdxEglConfigChooser", String.format("Configuration %d:\n", arrayOfObject2));
      printConfig(paramEGL10, paramEGLDisplay, paramArrayOfEGLConfig[j]);
    }
  }

  public EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
  {
    int[] arrayOfInt = new int[1];
    paramEGL10.eglChooseConfig(paramEGLDisplay, this.mConfigAttribs, null, 0, arrayOfInt);
    int i = arrayOfInt[0];
    if (i <= 0)
      throw new IllegalArgumentException("No configs match configSpec");
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
    paramEGL10.eglChooseConfig(paramEGLDisplay, this.mConfigAttribs, arrayOfEGLConfig, i, arrayOfInt);
    return chooseConfig(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
  }

  public EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    int i = paramArrayOfEGLConfig.length;
    int j = 0;
    Object localObject6;
    Object localObject7;
    Object localObject8;
    Object localObject4;
    if (j < i)
    {
      localObject6 = paramArrayOfEGLConfig[j];
      int k = findConfigAttrib(paramEGL10, paramEGLDisplay, (EGLConfig)localObject6, 12325, 0);
      int m = findConfigAttrib(paramEGL10, paramEGLDisplay, (EGLConfig)localObject6, 12326, 0);
      if ((k >= this.mDepthSize) && (m >= this.mStencilSize))
      {
        int n = findConfigAttrib(paramEGL10, paramEGLDisplay, (EGLConfig)localObject6, 12324, 0);
        int i1 = findConfigAttrib(paramEGL10, paramEGLDisplay, (EGLConfig)localObject6, 12323, 0);
        int i2 = findConfigAttrib(paramEGL10, paramEGLDisplay, (EGLConfig)localObject6, 12322, 0);
        int i3 = findConfigAttrib(paramEGL10, paramEGLDisplay, (EGLConfig)localObject6, 12321, 0);
        if ((localObject3 == null) && (n == 5) && (i1 == 6) && (i2 == 5) && (i3 == 0))
          localObject3 = localObject6;
        if ((localObject1 == null) && (n == this.mRedSize) && (i1 == this.mGreenSize) && (i2 == this.mBlueSize) && (i3 == this.mAlphaSize))
        {
          if (this.mNumSamples != 0)
            localObject1 = localObject6;
        }
        else
        {
          int i4 = findConfigAttrib(paramEGL10, paramEGLDisplay, (EGLConfig)localObject6, 12338, 0);
          int i5 = findConfigAttrib(paramEGL10, paramEGLDisplay, (EGLConfig)localObject6, 12337, 0);
          if ((localObject2 == null) && (i4 == 1) && (i5 >= this.mNumSamples) && (n == this.mRedSize) && (i1 == this.mGreenSize) && (i2 == this.mBlueSize) && (i3 == this.mAlphaSize))
            localObject7 = localObject3;
          for (localObject8 = localObject1; ; localObject8 = localObject1)
          {
            j++;
            localObject3 = localObject7;
            localObject2 = localObject6;
            localObject1 = localObject8;
            break;
            int i6 = findConfigAttrib(paramEGL10, paramEGLDisplay, (EGLConfig)localObject6, 12512, 0);
            int i7 = findConfigAttrib(paramEGL10, paramEGLDisplay, (EGLConfig)localObject6, 12513, 0);
            if ((localObject2 != null) || (i6 != 1) || (i7 < this.mNumSamples) || (n != this.mRedSize) || (i1 != this.mGreenSize) || (i2 != this.mBlueSize) || (i3 != this.mAlphaSize))
              break label448;
            localObject7 = localObject3;
          }
        }
        localObject4 = localObject3;
      }
    }
    for (Object localObject5 = localObject6; ; localObject5 = localObject1)
    {
      if (localObject2 != null)
        return localObject2;
      if (localObject5 != null)
        return localObject5;
      return localObject4;
      label448: localObject7 = localObject3;
      localObject6 = localObject2;
      localObject8 = localObject1;
      break;
      localObject4 = localObject3;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.surfaceview.GdxEglConfigChooser
 * JD-Core Version:    0.6.0
 */