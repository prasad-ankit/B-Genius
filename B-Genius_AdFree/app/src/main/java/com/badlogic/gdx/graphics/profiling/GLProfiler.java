package com.badlogic.gdx.graphics.profiling;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.FloatCounter;

public abstract class GLProfiler
{
  public static int calls;
  public static int drawCalls;
  public static GLErrorListener listener;
  public static int shaderSwitches;
  public static int textureBindings;
  public static final FloatCounter vertexCount = new FloatCounter(0);

  static
  {
    listener = GLErrorListener.LOGGING_LISTENER;
  }

  public static void disable()
  {
    if ((Gdx.gl30 != null) && ((Gdx.gl30 instanceof GL30Profiler)))
      Gdx.gl30 = ((GL30Profiler)Gdx.gl30).gl30;
    if ((Gdx.gl20 != null) && ((Gdx.gl20 instanceof GL20Profiler)))
      Gdx.gl20 = ((GL20Profiler)Gdx.gl).gl20;
    if ((Gdx.gl != null) && ((Gdx.gl instanceof GL20Profiler)))
      Gdx.gl = ((GL20Profiler)Gdx.gl).gl20;
  }

  public static void enable()
  {
    GL30Profiler localGL30Profiler;
    if (!isEnabled())
    {
      if (Gdx.gl30 != null)
        break label35;
      localGL30Profiler = null;
      Gdx.gl30 = localGL30Profiler;
      if (localGL30Profiler == null)
        break label49;
    }
    label35: label49: for (Object localObject = Gdx.gl30; ; localObject = new GL20Profiler(Gdx.gl20))
    {
      Gdx.gl20 = (GL20)localObject;
      Gdx.gl = (GL20)localObject;
      return;
      localGL30Profiler = new GL30Profiler(Gdx.gl30);
      break;
    }
  }

  public static boolean isEnabled()
  {
    return ((Gdx.gl30 instanceof GL30Profiler)) || ((Gdx.gl20 instanceof GL20Profiler));
  }

  public static void reset()
  {
    calls = 0;
    textureBindings = 0;
    drawCalls = 0;
    shaderSwitches = 0;
    vertexCount.reset();
  }

  public static String resolveErrorNumber(int paramInt)
  {
    switch (paramInt)
    {
    case 1283:
    case 1284:
    default:
      return "number " + paramInt;
    case 1281:
      return "GL_INVALID_VALUE";
    case 1282:
      return "GL_INVALID_OPERATION";
    case 1286:
      return "GL_INVALID_FRAMEBUFFER_OPERATION";
    case 1280:
      return "GL_INVALID_ENUM";
    case 1285:
    }
    return "GL_OUT_OF_MEMORY";
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.profiling.GLProfiler
 * JD-Core Version:    0.6.0
 */