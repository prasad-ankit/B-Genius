package com.badlogic.gdx.backends.android.surfaceview;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import javax.microedition.khronos.egl.EGL10;

public class GLSurfaceView20 extends GLSurfaceView
{
  private static final boolean DEBUG;
  static String TAG = "GL2JNIView";
  final ResolutionStrategy resolutionStrategy;

  public GLSurfaceView20(Context paramContext, ResolutionStrategy paramResolutionStrategy)
  {
    super(paramContext);
    this.resolutionStrategy = paramResolutionStrategy;
    init(false, 16, 0);
  }

  public GLSurfaceView20(Context paramContext, boolean paramBoolean, int paramInt1, int paramInt2, ResolutionStrategy paramResolutionStrategy)
  {
    super(paramContext);
    this.resolutionStrategy = paramResolutionStrategy;
    init(paramBoolean, paramInt1, paramInt2);
  }

  static void checkEglError(String paramString, EGL10 paramEGL10)
  {
    while (true)
    {
      int i = paramEGL10.eglGetError();
      if (i == 12288)
        break;
      String str = TAG;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramString;
      arrayOfObject[1] = Integer.valueOf(i);
      Log.e(str, String.format("%s: EGL error: 0x%x", arrayOfObject));
    }
  }

  private void init(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
      getHolder().setFormat(-3);
    setEGLContextFactory(new GLSurfaceView20.ContextFactory());
    if (paramBoolean);
    for (GLSurfaceView20.ConfigChooser localConfigChooser = new GLSurfaceView20.ConfigChooser(8, 8, 8, 8, paramInt1, paramInt2); ; localConfigChooser = new GLSurfaceView20.ConfigChooser(5, 6, 5, 0, paramInt1, paramInt2))
    {
      setEGLConfigChooser(localConfigChooser);
      return;
    }
  }

  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    if (paramEditorInfo != null)
      paramEditorInfo.imeOptions = (0x10000000 | paramEditorInfo.imeOptions);
    return new GLSurfaceView20.1(this, this, false);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    ResolutionStrategy.MeasuredDimension localMeasuredDimension = this.resolutionStrategy.calcMeasures(paramInt1, paramInt2);
    setMeasuredDimension(localMeasuredDimension.width, localMeasuredDimension.height);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20
 * JD-Core Version:    0.6.0
 */