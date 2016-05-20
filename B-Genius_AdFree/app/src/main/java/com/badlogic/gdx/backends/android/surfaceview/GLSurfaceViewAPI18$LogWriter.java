package com.badlogic.gdx.backends.android.surfaceview;

import android.util.Log;
import java.io.Writer;

class GLSurfaceViewAPI18$LogWriter extends Writer
{
  private StringBuilder mBuilder = new StringBuilder();

  private void flushBuilder()
  {
    if (this.mBuilder.length() > 0)
    {
      Log.v("GLSurfaceView", this.mBuilder.toString());
      this.mBuilder.delete(0, this.mBuilder.length());
    }
  }

  public void close()
  {
    flushBuilder();
  }

  public void flush()
  {
    flushBuilder();
  }

  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = 0;
    if (i < paramInt2)
    {
      char c = paramArrayOfChar[(paramInt1 + i)];
      if (c == '\n')
        flushBuilder();
      while (true)
      {
        i++;
        break;
        this.mBuilder.append(c);
      }
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.surfaceview.GLSurfaceViewAPI18.LogWriter
 * JD-Core Version:    0.6.0
 */