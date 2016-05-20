package com.badlogic.gdx.graphics.profiling;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;

final class GLErrorListener$1
  implements GLErrorListener
{
  public final void onError(int paramInt)
  {
    try
    {
      StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
      for (int i = 0; ; i++)
      {
        int j = arrayOfStackTraceElement.length;
        localObject = null;
        if (i < j)
        {
          if (!"check".equals(arrayOfStackTraceElement[i].getMethodName()))
            continue;
          int k = i + 1;
          int m = arrayOfStackTraceElement.length;
          localObject = null;
          if (k < m)
          {
            String str = arrayOfStackTraceElement[(i + 1)].getMethodName();
            localObject = str;
          }
        }
        if (localObject == null)
          break;
        Gdx.app.error("GLProfiler", "Error " + GLProfiler.resolveErrorNumber(paramInt) + " from " + localObject);
        return;
      }
      Gdx.app.error("GLProfiler", "Error " + GLProfiler.resolveErrorNumber(paramInt) + " at: ", new Exception());
      return;
    }
    catch (Exception localException)
    {
      while (true)
        Object localObject = null;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.profiling.GLErrorListener.1
 * JD-Core Version:    0.6.0
 */