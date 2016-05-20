package com.badlogic.gdx.backends.android;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Pool;
import java.util.ArrayList;

public class AndroidMouseHandler
{
  private int deltaX = 0;
  private int deltaY = 0;

  private void logAction(int paramInt)
  {
    String str;
    if (paramInt == 9)
      str = "HOVER_ENTER";
    while (true)
    {
      Gdx.app.log("AndroidMouseHandler", "action " + str);
      return;
      if (paramInt == 7)
      {
        str = "HOVER_MOVE";
        continue;
      }
      if (paramInt == 10)
      {
        str = "HOVER_EXIT";
        continue;
      }
      if (paramInt == 8)
      {
        str = "SCROLL";
        continue;
      }
      str = "UNKNOWN (" + paramInt + ")";
    }
  }

  private void postTouchEvent(AndroidInput paramAndroidInput, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    AndroidInput.TouchEvent localTouchEvent = (AndroidInput.TouchEvent)paramAndroidInput.usedTouchEvents.obtain();
    localTouchEvent.timeStamp = paramLong;
    localTouchEvent.x = paramInt2;
    localTouchEvent.y = paramInt3;
    localTouchEvent.type = paramInt1;
    localTouchEvent.scrollAmount = paramInt4;
    paramAndroidInput.touchEvents.add(localTouchEvent);
  }

  // ERROR //
  public boolean onGenericMotion(android.view.MotionEvent paramMotionEvent, AndroidInput paramAndroidInput)
  {
    // Byte code:
    //   0: iconst_2
    //   1: aload_1
    //   2: invokevirtual 111	android/view/MotionEvent:getSource	()I
    //   5: iand
    //   6: ifne +5 -> 11
    //   9: iconst_0
    //   10: ireturn
    //   11: sipush 255
    //   14: aload_1
    //   15: invokevirtual 114	android/view/MotionEvent:getAction	()I
    //   18: iand
    //   19: istore_3
    //   20: invokestatic 120	java/lang/System:nanoTime	()J
    //   23: lstore 4
    //   25: aload_2
    //   26: monitorenter
    //   27: iload_3
    //   28: tableswitch	default:+24 -> 52, 7:+41->69, 8:+108->136
    //   53: monitorexit
    //   54: getstatic 25	com/badlogic/gdx/Gdx:app	Lcom/badlogic/gdx/Application;
    //   57: invokeinterface 124 1 0
    //   62: invokeinterface 129 1 0
    //   67: iconst_1
    //   68: ireturn
    //   69: aload_1
    //   70: invokevirtual 133	android/view/MotionEvent:getX	()F
    //   73: f2i
    //   74: istore 7
    //   76: aload_1
    //   77: invokevirtual 136	android/view/MotionEvent:getY	()F
    //   80: f2i
    //   81: istore 8
    //   83: iload 7
    //   85: aload_0
    //   86: getfield 13	com/badlogic/gdx/backends/android/AndroidMouseHandler:deltaX	I
    //   89: if_icmpne +12 -> 101
    //   92: iload 8
    //   94: aload_0
    //   95: getfield 15	com/badlogic/gdx/backends/android/AndroidMouseHandler:deltaY	I
    //   98: if_icmpeq -46 -> 52
    //   101: aload_0
    //   102: aload_2
    //   103: iconst_4
    //   104: iload 7
    //   106: iload 8
    //   108: iconst_0
    //   109: lload 4
    //   111: invokespecial 138	com/badlogic/gdx/backends/android/AndroidMouseHandler:postTouchEvent	(Lcom/badlogic/gdx/backends/android/AndroidInput;IIIIJ)V
    //   114: aload_0
    //   115: iload 7
    //   117: putfield 13	com/badlogic/gdx/backends/android/AndroidMouseHandler:deltaX	I
    //   120: aload_0
    //   121: iload 8
    //   123: putfield 15	com/badlogic/gdx/backends/android/AndroidMouseHandler:deltaY	I
    //   126: goto -74 -> 52
    //   129: astore 6
    //   131: aload_2
    //   132: monitorexit
    //   133: aload 6
    //   135: athrow
    //   136: aload_0
    //   137: aload_2
    //   138: iconst_3
    //   139: iconst_0
    //   140: iconst_0
    //   141: aload_1
    //   142: bipush 9
    //   144: invokevirtual 142	android/view/MotionEvent:getAxisValue	(I)F
    //   147: invokestatic 148	java/lang/Math:signum	(F)F
    //   150: fneg
    //   151: f2i
    //   152: lload 4
    //   154: invokespecial 138	com/badlogic/gdx/backends/android/AndroidMouseHandler:postTouchEvent	(Lcom/badlogic/gdx/backends/android/AndroidInput;IIIIJ)V
    //   157: goto -105 -> 52
    //
    // Exception table:
    //   from	to	target	type
    //   52	54	129	finally
    //   69	101	129	finally
    //   101	126	129	finally
    //   131	133	129	finally
    //   136	157	129	finally
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidMouseHandler
 * JD-Core Version:    0.6.0
 */