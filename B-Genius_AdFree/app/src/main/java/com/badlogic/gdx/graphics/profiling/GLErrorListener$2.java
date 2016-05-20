package com.badlogic.gdx.graphics.profiling;

import com.badlogic.gdx.utils.GdxRuntimeException;

final class GLErrorListener$2
  implements GLErrorListener
{
  public final void onError(int paramInt)
  {
    throw new GdxRuntimeException("GLProfiler: Got GL error " + GLProfiler.resolveErrorNumber(paramInt));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.profiling.GLErrorListener.2
 * JD-Core Version:    0.6.0
 */