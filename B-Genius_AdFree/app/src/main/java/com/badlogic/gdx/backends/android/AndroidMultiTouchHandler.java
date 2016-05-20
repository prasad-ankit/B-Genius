package com.badlogic.gdx.backends.android;

import android.content.Context;
import android.content.pm.PackageManager;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Pool;
import java.util.ArrayList;

public class AndroidMultiTouchHandler
  implements AndroidTouchHandler
{
  private void logAction(int paramInt1, int paramInt2)
  {
    String str;
    if (paramInt1 == 0)
      str = "DOWN";
    while (true)
    {
      Gdx.app.log("AndroidMultiTouchHandler", "action " + str + ", Android pointer id: " + paramInt2);
      return;
      if (paramInt1 == 5)
      {
        str = "POINTER DOWN";
        continue;
      }
      if (paramInt1 == 1)
      {
        str = "UP";
        continue;
      }
      if (paramInt1 == 6)
      {
        str = "POINTER UP";
        continue;
      }
      if (paramInt1 == 4)
      {
        str = "OUTSIDE";
        continue;
      }
      if (paramInt1 == 3)
      {
        str = "CANCEL";
        continue;
      }
      if (paramInt1 == 2)
      {
        str = "MOVE";
        continue;
      }
      str = "UNKNOWN (" + paramInt1 + ")";
    }
  }

  private void postTouchEvent(AndroidInput paramAndroidInput, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong)
  {
    AndroidInput.TouchEvent localTouchEvent = (AndroidInput.TouchEvent)paramAndroidInput.usedTouchEvents.obtain();
    localTouchEvent.timeStamp = paramLong;
    localTouchEvent.pointer = paramInt4;
    localTouchEvent.x = paramInt2;
    localTouchEvent.y = paramInt3;
    localTouchEvent.type = paramInt1;
    localTouchEvent.button = paramInt5;
    paramAndroidInput.touchEvents.add(localTouchEvent);
  }

  private int toGdxButton(int paramInt)
  {
    int i = 1;
    if ((paramInt == 0) || (paramInt == i))
      i = 0;
    do
      return i;
    while (paramInt == 2);
    if (paramInt == 4)
      return 2;
    if (paramInt == 8)
      return 3;
    if (paramInt == 16)
      return 4;
    return -1;
  }

  // ERROR //
  public void onTouch(android.view.MotionEvent paramMotionEvent, AndroidInput paramAndroidInput)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: sipush 255
    //   5: aload_1
    //   6: invokevirtual 120	android/view/MotionEvent:getAction	()I
    //   9: iand
    //   10: istore 4
    //   12: sipush 255
    //   15: aload_1
    //   16: invokevirtual 120	android/view/MotionEvent:getAction	()I
    //   19: bipush 8
    //   21: ishr
    //   22: iand
    //   23: istore 5
    //   25: aload_1
    //   26: iload 5
    //   28: invokevirtual 123	android/view/MotionEvent:getPointerId	(I)I
    //   31: istore 6
    //   33: invokestatic 129	java/lang/System:nanoTime	()J
    //   36: lstore 7
    //   38: aload_2
    //   39: monitorenter
    //   40: iload 4
    //   42: tableswitch	default:+42 -> 84, 0:+58->100, 1:+216->258, 2:+347->389, 3:+216->258, 4:+216->258, 5:+58->100, 6:+216->258
    //   85: monitorexit
    //   86: getstatic 20	com/badlogic/gdx/Gdx:app	Lcom/badlogic/gdx/Application;
    //   89: invokeinterface 133 1 0
    //   94: invokeinterface 138 1 0
    //   99: return
    //   100: aload_2
    //   101: invokevirtual 141	com/badlogic/gdx/backends/android/AndroidInput:getFreePointerIndex	()I
    //   104: istore 20
    //   106: iload 20
    //   108: bipush 20
    //   110: if_icmpge -26 -> 84
    //   113: aload_2
    //   114: getfield 145	com/badlogic/gdx/backends/android/AndroidInput:realId	[I
    //   117: iload 20
    //   119: iload 6
    //   121: iastore
    //   122: aload_1
    //   123: iload 5
    //   125: invokevirtual 149	android/view/MotionEvent:getX	(I)F
    //   128: f2i
    //   129: istore 21
    //   131: aload_1
    //   132: iload 5
    //   134: invokevirtual 152	android/view/MotionEvent:getY	(I)F
    //   137: f2i
    //   138: istore 22
    //   140: getstatic 157	android/os/Build$VERSION:SDK_INT	I
    //   143: bipush 14
    //   145: if_icmplt +404 -> 549
    //   148: aload_0
    //   149: aload_1
    //   150: invokevirtual 160	android/view/MotionEvent:getButtonState	()I
    //   153: invokespecial 162	com/badlogic/gdx/backends/android/AndroidMultiTouchHandler:toGdxButton	(I)I
    //   156: istore 23
    //   158: iload 23
    //   160: iconst_m1
    //   161: if_icmpeq +19 -> 180
    //   164: aload_0
    //   165: aload_2
    //   166: iconst_0
    //   167: iload 21
    //   169: iload 22
    //   171: iload 20
    //   173: iload 23
    //   175: lload 7
    //   177: invokespecial 164	com/badlogic/gdx/backends/android/AndroidMultiTouchHandler:postTouchEvent	(Lcom/badlogic/gdx/backends/android/AndroidInput;IIIIIJ)V
    //   180: aload_2
    //   181: getfield 167	com/badlogic/gdx/backends/android/AndroidInput:touchX	[I
    //   184: iload 20
    //   186: iload 21
    //   188: iastore
    //   189: aload_2
    //   190: getfield 170	com/badlogic/gdx/backends/android/AndroidInput:touchY	[I
    //   193: iload 20
    //   195: iload 22
    //   197: iastore
    //   198: aload_2
    //   199: getfield 173	com/badlogic/gdx/backends/android/AndroidInput:deltaX	[I
    //   202: iload 20
    //   204: iconst_0
    //   205: iastore
    //   206: aload_2
    //   207: getfield 176	com/badlogic/gdx/backends/android/AndroidInput:deltaY	[I
    //   210: iload 20
    //   212: iconst_0
    //   213: iastore
    //   214: aload_2
    //   215: getfield 180	com/badlogic/gdx/backends/android/AndroidInput:touched	[Z
    //   218: astore 24
    //   220: iconst_0
    //   221: istore 25
    //   223: iload 23
    //   225: iconst_m1
    //   226: if_icmpeq +6 -> 232
    //   229: iconst_1
    //   230: istore 25
    //   232: aload 24
    //   234: iload 20
    //   236: iload 25
    //   238: bastore
    //   239: aload_2
    //   240: getfield 182	com/badlogic/gdx/backends/android/AndroidInput:button	[I
    //   243: iload 20
    //   245: iload 23
    //   247: iastore
    //   248: goto -164 -> 84
    //   251: astore 15
    //   253: aload_2
    //   254: monitorexit
    //   255: aload 15
    //   257: athrow
    //   258: aload_2
    //   259: iload 6
    //   261: invokevirtual 185	com/badlogic/gdx/backends/android/AndroidInput:lookUpPointerIndex	(I)I
    //   264: istore 16
    //   266: iload 16
    //   268: iconst_m1
    //   269: if_icmpeq -185 -> 84
    //   272: iload 16
    //   274: bipush 20
    //   276: if_icmpge -192 -> 84
    //   279: aload_2
    //   280: getfield 145	com/badlogic/gdx/backends/android/AndroidInput:realId	[I
    //   283: iload 16
    //   285: iconst_m1
    //   286: iastore
    //   287: aload_1
    //   288: iload 5
    //   290: invokevirtual 149	android/view/MotionEvent:getX	(I)F
    //   293: f2i
    //   294: istore 17
    //   296: aload_1
    //   297: iload 5
    //   299: invokevirtual 152	android/view/MotionEvent:getY	(I)F
    //   302: f2i
    //   303: istore 18
    //   305: aload_2
    //   306: getfield 182	com/badlogic/gdx/backends/android/AndroidInput:button	[I
    //   309: iload 16
    //   311: iaload
    //   312: istore 19
    //   314: iload 19
    //   316: iconst_m1
    //   317: if_icmpeq +19 -> 336
    //   320: aload_0
    //   321: aload_2
    //   322: iconst_1
    //   323: iload 17
    //   325: iload 18
    //   327: iload 16
    //   329: iload 19
    //   331: lload 7
    //   333: invokespecial 164	com/badlogic/gdx/backends/android/AndroidMultiTouchHandler:postTouchEvent	(Lcom/badlogic/gdx/backends/android/AndroidInput;IIIIIJ)V
    //   336: aload_2
    //   337: getfield 167	com/badlogic/gdx/backends/android/AndroidInput:touchX	[I
    //   340: iload 16
    //   342: iload 17
    //   344: iastore
    //   345: aload_2
    //   346: getfield 170	com/badlogic/gdx/backends/android/AndroidInput:touchY	[I
    //   349: iload 16
    //   351: iload 18
    //   353: iastore
    //   354: aload_2
    //   355: getfield 173	com/badlogic/gdx/backends/android/AndroidInput:deltaX	[I
    //   358: iload 16
    //   360: iconst_0
    //   361: iastore
    //   362: aload_2
    //   363: getfield 176	com/badlogic/gdx/backends/android/AndroidInput:deltaY	[I
    //   366: iload 16
    //   368: iconst_0
    //   369: iastore
    //   370: aload_2
    //   371: getfield 180	com/badlogic/gdx/backends/android/AndroidInput:touched	[Z
    //   374: iload 16
    //   376: iconst_0
    //   377: bastore
    //   378: aload_2
    //   379: getfield 182	com/badlogic/gdx/backends/android/AndroidInput:button	[I
    //   382: iload 16
    //   384: iconst_0
    //   385: iastore
    //   386: goto -302 -> 84
    //   389: aload_1
    //   390: invokevirtual 188	android/view/MotionEvent:getPointerCount	()I
    //   393: istore 9
    //   395: iload_3
    //   396: iload 9
    //   398: if_icmpge -314 -> 84
    //   401: aload_1
    //   402: iload_3
    //   403: invokevirtual 123	android/view/MotionEvent:getPointerId	(I)I
    //   406: istore 10
    //   408: aload_1
    //   409: iload_3
    //   410: invokevirtual 149	android/view/MotionEvent:getX	(I)F
    //   413: f2i
    //   414: istore 11
    //   416: aload_1
    //   417: iload_3
    //   418: invokevirtual 152	android/view/MotionEvent:getY	(I)F
    //   421: f2i
    //   422: istore 12
    //   424: aload_2
    //   425: iload 10
    //   427: invokevirtual 185	com/badlogic/gdx/backends/android/AndroidInput:lookUpPointerIndex	(I)I
    //   430: istore 13
    //   432: iload 13
    //   434: iconst_m1
    //   435: if_icmpeq +120 -> 555
    //   438: iload 13
    //   440: bipush 20
    //   442: if_icmpge -358 -> 84
    //   445: aload_2
    //   446: getfield 182	com/badlogic/gdx/backends/android/AndroidInput:button	[I
    //   449: iload 13
    //   451: iaload
    //   452: istore 14
    //   454: iload 14
    //   456: iconst_m1
    //   457: if_icmpeq +74 -> 531
    //   460: aload_0
    //   461: aload_2
    //   462: iconst_2
    //   463: iload 11
    //   465: iload 12
    //   467: iload 13
    //   469: iload 14
    //   471: lload 7
    //   473: invokespecial 164	com/badlogic/gdx/backends/android/AndroidMultiTouchHandler:postTouchEvent	(Lcom/badlogic/gdx/backends/android/AndroidInput;IIIIIJ)V
    //   476: aload_2
    //   477: getfield 173	com/badlogic/gdx/backends/android/AndroidInput:deltaX	[I
    //   480: iload 13
    //   482: iload 11
    //   484: aload_2
    //   485: getfield 167	com/badlogic/gdx/backends/android/AndroidInput:touchX	[I
    //   488: iload 13
    //   490: iaload
    //   491: isub
    //   492: iastore
    //   493: aload_2
    //   494: getfield 176	com/badlogic/gdx/backends/android/AndroidInput:deltaY	[I
    //   497: iload 13
    //   499: iload 12
    //   501: aload_2
    //   502: getfield 170	com/badlogic/gdx/backends/android/AndroidInput:touchY	[I
    //   505: iload 13
    //   507: iaload
    //   508: isub
    //   509: iastore
    //   510: aload_2
    //   511: getfield 167	com/badlogic/gdx/backends/android/AndroidInput:touchX	[I
    //   514: iload 13
    //   516: iload 11
    //   518: iastore
    //   519: aload_2
    //   520: getfield 170	com/badlogic/gdx/backends/android/AndroidInput:touchY	[I
    //   523: iload 13
    //   525: iload 12
    //   527: iastore
    //   528: goto +27 -> 555
    //   531: aload_0
    //   532: aload_2
    //   533: iconst_4
    //   534: iload 11
    //   536: iload 12
    //   538: iload 13
    //   540: iconst_0
    //   541: lload 7
    //   543: invokespecial 164	com/badlogic/gdx/backends/android/AndroidMultiTouchHandler:postTouchEvent	(Lcom/badlogic/gdx/backends/android/AndroidInput;IIIIIJ)V
    //   546: goto -70 -> 476
    //   549: iconst_0
    //   550: istore 23
    //   552: goto -394 -> 158
    //   555: iinc 3 1
    //   558: goto -163 -> 395
    //
    // Exception table:
    //   from	to	target	type
    //   84	86	251	finally
    //   100	106	251	finally
    //   113	158	251	finally
    //   164	180	251	finally
    //   180	220	251	finally
    //   232	248	251	finally
    //   253	255	251	finally
    //   258	266	251	finally
    //   279	314	251	finally
    //   320	336	251	finally
    //   336	386	251	finally
    //   389	395	251	finally
    //   401	432	251	finally
    //   445	454	251	finally
    //   460	476	251	finally
    //   476	528	251	finally
    //   531	546	251	finally
  }

  public boolean supportsMultitouch(Context paramContext)
  {
    return paramContext.getPackageManager().hasSystemFeature("android.hardware.touchscreen.multitouch");
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidMultiTouchHandler
 * JD-Core Version:    0.6.0
 */