package com.badlogic.gdx.backends.android.surfaceview;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

class GLSurfaceViewAPI18$GLThread extends Thread
{
  private GLSurfaceViewAPI18.EglHelper mEglHelper;
  private ArrayList mEventQueue = new ArrayList();
  private boolean mExited;
  private boolean mFinishedCreatingEglSurface;
  private WeakReference mGLSurfaceViewWeakRef;
  private boolean mHasSurface;
  private boolean mHaveEglContext;
  private boolean mHaveEglSurface;
  private int mHeight = 0;
  private boolean mPaused;
  private boolean mRenderComplete;
  private int mRenderMode = 1;
  private boolean mRequestPaused;
  private boolean mRequestRender = true;
  private boolean mShouldExit;
  private boolean mShouldReleaseEglContext;
  private boolean mSizeChanged = true;
  private boolean mSurfaceIsBad;
  private boolean mWaitingForSurface;
  private int mWidth = 0;

  GLSurfaceViewAPI18$GLThread(WeakReference paramWeakReference)
  {
    this.mGLSurfaceViewWeakRef = paramWeakReference;
  }

  // ERROR //
  private void guardedRun()
  {
    // Byte code:
    //   0: aload_0
    //   1: new 60	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$EglHelper
    //   4: dup
    //   5: aload_0
    //   6: getfield 51	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   9: invokespecial 62	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$EglHelper:<init>	(Ljava/lang/ref/WeakReference;)V
    //   12: putfield 64	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mEglHelper	Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$EglHelper;
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield 66	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mHaveEglContext	Z
    //   20: aload_0
    //   21: iconst_0
    //   22: putfield 68	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mHaveEglSurface	Z
    //   25: iconst_0
    //   26: istore_1
    //   27: aconst_null
    //   28: astore_2
    //   29: iconst_0
    //   30: istore_3
    //   31: iconst_0
    //   32: istore 4
    //   34: iconst_0
    //   35: istore 5
    //   37: iconst_0
    //   38: istore 6
    //   40: iconst_0
    //   41: istore 7
    //   43: iconst_0
    //   44: istore 8
    //   46: iconst_0
    //   47: istore 9
    //   49: aconst_null
    //   50: astore 10
    //   52: iconst_0
    //   53: istore 11
    //   55: iconst_0
    //   56: istore 12
    //   58: invokestatic 74	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18:access$800	()Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThreadManager;
    //   61: astore 16
    //   63: aload 16
    //   65: monitorenter
    //   66: aload_0
    //   67: getfield 76	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mShouldExit	Z
    //   70: ifeq +34 -> 104
    //   73: aload 16
    //   75: monitorexit
    //   76: invokestatic 74	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18:access$800	()Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThreadManager;
    //   79: astore 61
    //   81: aload 61
    //   83: monitorenter
    //   84: aload_0
    //   85: invokespecial 79	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:stopEglSurfaceLocked	()V
    //   88: aload_0
    //   89: invokespecial 82	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:stopEglContextLocked	()V
    //   92: aload 61
    //   94: monitorexit
    //   95: return
    //   96: astore 62
    //   98: aload 61
    //   100: monitorexit
    //   101: aload 62
    //   103: athrow
    //   104: aload_0
    //   105: getfield 39	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mEventQueue	Ljava/util/ArrayList;
    //   108: invokevirtual 86	java/util/ArrayList:isEmpty	()Z
    //   111: ifne +115 -> 226
    //   114: aload_0
    //   115: getfield 39	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mEventQueue	Ljava/util/ArrayList;
    //   118: iconst_0
    //   119: invokevirtual 90	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   122: checkcast 92	java/lang/Runnable
    //   125: astore 60
    //   127: iload 12
    //   129: istore 31
    //   131: iload 11
    //   133: istore 32
    //   135: aload 60
    //   137: astore 30
    //   139: iload 9
    //   141: istore 34
    //   143: iload 8
    //   145: istore 28
    //   147: iload 7
    //   149: istore 35
    //   151: iload 6
    //   153: istore 36
    //   155: iload 5
    //   157: istore 29
    //   159: iload 4
    //   161: istore 37
    //   163: iload_3
    //   164: istore 38
    //   166: aload 16
    //   168: monitorexit
    //   169: aload 30
    //   171: ifnull +552 -> 723
    //   174: aload 30
    //   176: invokeinterface 95 1 0
    //   181: iload 38
    //   183: istore_3
    //   184: iload 37
    //   186: istore 4
    //   188: iload 29
    //   190: istore 5
    //   192: iload 36
    //   194: istore 6
    //   196: iload 35
    //   198: istore 7
    //   200: iload 28
    //   202: istore 8
    //   204: iload 34
    //   206: istore 9
    //   208: iload 31
    //   210: istore 55
    //   212: iload 32
    //   214: istore 11
    //   216: iload 55
    //   218: istore 12
    //   220: aconst_null
    //   221: astore 10
    //   223: goto -165 -> 58
    //   226: aload_0
    //   227: getfield 97	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mPaused	Z
    //   230: aload_0
    //   231: getfield 99	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mRequestPaused	Z
    //   234: if_icmpeq +959 -> 1193
    //   237: aload_0
    //   238: getfield 99	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mRequestPaused	Z
    //   241: istore 59
    //   243: aload_0
    //   244: aload_0
    //   245: getfield 99	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mRequestPaused	Z
    //   248: putfield 97	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mPaused	Z
    //   251: invokestatic 74	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18:access$800	()Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThreadManager;
    //   254: invokevirtual 104	java/lang/Object:notifyAll	()V
    //   257: iload 59
    //   259: istore 18
    //   261: aload_0
    //   262: getfield 106	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mShouldReleaseEglContext	Z
    //   265: ifeq +19 -> 284
    //   268: aload_0
    //   269: invokespecial 79	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:stopEglSurfaceLocked	()V
    //   272: aload_0
    //   273: invokespecial 82	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:stopEglContextLocked	()V
    //   276: aload_0
    //   277: iconst_0
    //   278: putfield 106	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mShouldReleaseEglContext	Z
    //   281: iconst_1
    //   282: istore 4
    //   284: iload 7
    //   286: ifeq +14 -> 300
    //   289: aload_0
    //   290: invokespecial 79	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:stopEglSurfaceLocked	()V
    //   293: aload_0
    //   294: invokespecial 82	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:stopEglContextLocked	()V
    //   297: iconst_0
    //   298: istore 7
    //   300: iload 18
    //   302: ifeq +14 -> 316
    //   305: aload_0
    //   306: getfield 68	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mHaveEglSurface	Z
    //   309: ifeq +7 -> 316
    //   312: aload_0
    //   313: invokespecial 79	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:stopEglSurfaceLocked	()V
    //   316: iload 18
    //   318: ifeq +48 -> 366
    //   321: aload_0
    //   322: getfield 66	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mHaveEglContext	Z
    //   325: ifeq +41 -> 366
    //   328: aload_0
    //   329: getfield 51	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   332: invokevirtual 112	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   335: checkcast 70	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18
    //   338: astore 57
    //   340: aload 57
    //   342: ifnonnull +281 -> 623
    //   345: iconst_0
    //   346: istore 58
    //   348: iload 58
    //   350: ifeq +12 -> 362
    //   353: invokestatic 74	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18:access$800	()Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThreadManager;
    //   356: invokevirtual 117	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThreadManager:shouldReleaseEGLContextWhenPausing	()Z
    //   359: ifeq +7 -> 366
    //   362: aload_0
    //   363: invokespecial 82	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:stopEglContextLocked	()V
    //   366: iload 18
    //   368: ifeq +19 -> 387
    //   371: invokestatic 74	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18:access$800	()Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThreadManager;
    //   374: invokevirtual 120	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThreadManager:shouldTerminateEGLWhenPausing	()Z
    //   377: ifeq +10 -> 387
    //   380: aload_0
    //   381: getfield 64	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mEglHelper	Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$EglHelper;
    //   384: invokevirtual 123	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$EglHelper:finish	()V
    //   387: aload_0
    //   388: getfield 125	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mHasSurface	Z
    //   391: ifne +37 -> 428
    //   394: aload_0
    //   395: getfield 127	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mWaitingForSurface	Z
    //   398: ifne +30 -> 428
    //   401: aload_0
    //   402: getfield 68	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mHaveEglSurface	Z
    //   405: ifeq +7 -> 412
    //   408: aload_0
    //   409: invokespecial 79	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:stopEglSurfaceLocked	()V
    //   412: aload_0
    //   413: iconst_1
    //   414: putfield 127	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mWaitingForSurface	Z
    //   417: aload_0
    //   418: iconst_0
    //   419: putfield 129	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mSurfaceIsBad	Z
    //   422: invokestatic 74	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18:access$800	()Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThreadManager;
    //   425: invokevirtual 104	java/lang/Object:notifyAll	()V
    //   428: aload_0
    //   429: getfield 125	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mHasSurface	Z
    //   432: ifeq +21 -> 453
    //   435: aload_0
    //   436: getfield 127	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mWaitingForSurface	Z
    //   439: ifeq +14 -> 453
    //   442: aload_0
    //   443: iconst_0
    //   444: putfield 127	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mWaitingForSurface	Z
    //   447: invokestatic 74	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18:access$800	()Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThreadManager;
    //   450: invokevirtual 104	java/lang/Object:notifyAll	()V
    //   453: iload 12
    //   455: ifeq +20 -> 475
    //   458: iconst_0
    //   459: istore 5
    //   461: iconst_0
    //   462: istore 12
    //   464: aload_0
    //   465: iconst_1
    //   466: putfield 131	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mRenderComplete	Z
    //   469: invokestatic 74	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18:access$800	()Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThreadManager;
    //   472: invokevirtual 104	java/lang/Object:notifyAll	()V
    //   475: aload_0
    //   476: invokespecial 134	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:readyToDraw	()Z
    //   479: ifeq +235 -> 714
    //   482: aload_0
    //   483: getfield 66	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mHaveEglContext	Z
    //   486: ifne +11 -> 497
    //   489: iload 4
    //   491: ifeq +142 -> 633
    //   494: iconst_0
    //   495: istore 4
    //   497: aload_0
    //   498: getfield 66	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mHaveEglContext	Z
    //   501: ifeq +681 -> 1182
    //   504: aload_0
    //   505: getfield 68	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mHaveEglSurface	Z
    //   508: ifne +674 -> 1182
    //   511: aload_0
    //   512: iconst_1
    //   513: putfield 68	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mHaveEglSurface	Z
    //   516: iconst_1
    //   517: istore 9
    //   519: iconst_1
    //   520: istore 21
    //   522: iconst_1
    //   523: istore 22
    //   525: aload_0
    //   526: getfield 68	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mHaveEglSurface	Z
    //   529: ifeq +677 -> 1206
    //   532: aload_0
    //   533: getfield 41	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mSizeChanged	Z
    //   536: ifeq +620 -> 1156
    //   539: iconst_1
    //   540: istore 23
    //   542: aload_0
    //   543: getfield 43	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mWidth	I
    //   546: istore 24
    //   548: aload_0
    //   549: getfield 45	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mHeight	I
    //   552: istore 25
    //   554: iconst_1
    //   555: istore 26
    //   557: iconst_1
    //   558: istore 27
    //   560: aload_0
    //   561: iconst_0
    //   562: putfield 41	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mSizeChanged	Z
    //   565: aload_0
    //   566: iconst_0
    //   567: putfield 47	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mRequestRender	Z
    //   570: invokestatic 74	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18:access$800	()Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThreadManager;
    //   573: invokevirtual 104	java/lang/Object:notifyAll	()V
    //   576: iload 22
    //   578: istore 28
    //   580: iload 26
    //   582: istore 29
    //   584: aload 10
    //   586: astore 30
    //   588: iload 12
    //   590: istore 31
    //   592: iload 24
    //   594: istore 32
    //   596: iload 25
    //   598: istore 33
    //   600: iload 27
    //   602: istore 34
    //   604: iload 7
    //   606: istore 35
    //   608: iload 23
    //   610: istore 36
    //   612: iload 4
    //   614: istore 37
    //   616: iload 33
    //   618: istore 38
    //   620: goto -454 -> 166
    //   623: aload 57
    //   625: invokestatic 138	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18:access$900	(Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18;)Z
    //   628: istore 58
    //   630: goto -282 -> 348
    //   633: invokestatic 74	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18:access$800	()Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThreadManager;
    //   636: aload_0
    //   637: invokevirtual 142	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThreadManager:tryAcquireEglContextLocked	(Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread;)Z
    //   640: istore 19
    //   642: iload 19
    //   644: ifeq -147 -> 497
    //   647: aload_0
    //   648: getfield 64	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mEglHelper	Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$EglHelper;
    //   651: invokevirtual 145	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$EglHelper:start	()V
    //   654: aload_0
    //   655: iconst_1
    //   656: putfield 66	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mHaveEglContext	Z
    //   659: iconst_1
    //   660: istore_1
    //   661: invokestatic 74	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18:access$800	()Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThreadManager;
    //   664: invokevirtual 104	java/lang/Object:notifyAll	()V
    //   667: goto -170 -> 497
    //   670: astore 17
    //   672: aload 16
    //   674: monitorexit
    //   675: aload 17
    //   677: athrow
    //   678: astore 13
    //   680: invokestatic 74	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18:access$800	()Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThreadManager;
    //   683: astore 14
    //   685: aload 14
    //   687: monitorenter
    //   688: aload_0
    //   689: invokespecial 79	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:stopEglSurfaceLocked	()V
    //   692: aload_0
    //   693: invokespecial 82	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:stopEglContextLocked	()V
    //   696: aload 14
    //   698: monitorexit
    //   699: aload 13
    //   701: athrow
    //   702: astore 20
    //   704: invokestatic 74	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18:access$800	()Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThreadManager;
    //   707: aload_0
    //   708: invokevirtual 149	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThreadManager:releaseEglContextLocked	(Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread;)V
    //   711: aload 20
    //   713: athrow
    //   714: invokestatic 74	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18:access$800	()Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThreadManager;
    //   717: invokevirtual 152	java/lang/Object:wait	()V
    //   720: goto -654 -> 66
    //   723: iload 34
    //   725: ifeq +424 -> 1149
    //   728: aload_0
    //   729: getfield 64	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mEglHelper	Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$EglHelper;
    //   732: invokevirtual 155	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$EglHelper:createSurface	()Z
    //   735: ifeq +305 -> 1040
    //   738: invokestatic 74	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18:access$800	()Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThreadManager;
    //   741: astore 53
    //   743: aload 53
    //   745: monitorenter
    //   746: aload_0
    //   747: iconst_1
    //   748: putfield 157	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mFinishedCreatingEglSurface	Z
    //   751: invokestatic 74	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18:access$800	()Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThreadManager;
    //   754: invokevirtual 104	java/lang/Object:notifyAll	()V
    //   757: aload 53
    //   759: monitorexit
    //   760: iconst_0
    //   761: istore 39
    //   763: iload 28
    //   765: ifeq +378 -> 1143
    //   768: aload_0
    //   769: getfield 64	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mEglHelper	Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$EglHelper;
    //   772: invokevirtual 161	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$EglHelper:createGL	()Ljavax/microedition/khronos/opengles/GL;
    //   775: checkcast 163	javax/microedition/khronos/opengles/GL10
    //   778: astore 49
    //   780: invokestatic 74	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18:access$800	()Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThreadManager;
    //   783: aload 49
    //   785: invokevirtual 167	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThreadManager:checkGLDriver	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   788: iconst_0
    //   789: istore 28
    //   791: aload 49
    //   793: astore 40
    //   795: iload_1
    //   796: ifeq +42 -> 838
    //   799: aload_0
    //   800: getfield 51	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   803: invokevirtual 112	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   806: checkcast 70	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18
    //   809: astore 41
    //   811: aload 41
    //   813: ifnull +404 -> 1217
    //   816: aload 41
    //   818: invokestatic 171	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18:access$1000	(Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18;)Landroid/opengl/GLSurfaceView$Renderer;
    //   821: aload 40
    //   823: aload_0
    //   824: getfield 64	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mEglHelper	Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$EglHelper;
    //   827: getfield 175	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$EglHelper:mEglConfig	Ljavax/microedition/khronos/egl/EGLConfig;
    //   830: invokeinterface 181 3 0
    //   835: goto +382 -> 1217
    //   838: iload 36
    //   840: ifeq +39 -> 879
    //   843: aload_0
    //   844: getfield 51	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   847: invokevirtual 112	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   850: checkcast 70	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18
    //   853: astore 42
    //   855: aload 42
    //   857: ifnull +365 -> 1222
    //   860: aload 42
    //   862: invokestatic 171	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18:access$1000	(Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18;)Landroid/opengl/GLSurfaceView$Renderer;
    //   865: aload 40
    //   867: iload 32
    //   869: iload 38
    //   871: invokeinterface 185 4 0
    //   876: goto +346 -> 1222
    //   879: aload_0
    //   880: getfield 51	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   883: invokevirtual 112	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   886: checkcast 70	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18
    //   889: astore 43
    //   891: aload 43
    //   893: ifnull +15 -> 908
    //   896: aload 43
    //   898: invokestatic 171	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18:access$1000	(Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18;)Landroid/opengl/GLSurfaceView$Renderer;
    //   901: aload 40
    //   903: invokeinterface 188 2 0
    //   908: aload_0
    //   909: getfield 64	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mEglHelper	Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$EglHelper;
    //   912: invokevirtual 192	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$EglHelper:swap	()I
    //   915: istore 44
    //   917: iload 44
    //   919: lookupswitch	default:+25->944, 12288:+56->975, 12302:+202->1121
    //   945: monitorenter
    //   946: ldc 196
    //   948: iload 44
    //   950: invokestatic 200	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$EglHelper:logEglErrorAsWarning	(Ljava/lang/String;Ljava/lang/String;I)V
    //   953: invokestatic 74	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18:access$800	()Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThreadManager;
    //   956: astore 47
    //   958: aload 47
    //   960: monitorenter
    //   961: aload_0
    //   962: iconst_1
    //   963: putfield 129	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mSurfaceIsBad	Z
    //   966: invokestatic 74	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18:access$800	()Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThreadManager;
    //   969: invokevirtual 104	java/lang/Object:notifyAll	()V
    //   972: aload 47
    //   974: monitorexit
    //   975: iload 29
    //   977: ifeq +222 -> 1199
    //   980: iconst_1
    //   981: istore 45
    //   983: aload 30
    //   985: astore 10
    //   987: aload 40
    //   989: astore_2
    //   990: iload 32
    //   992: istore 11
    //   994: iload 45
    //   996: istore 12
    //   998: iload 37
    //   1000: istore 46
    //   1002: iload 29
    //   1004: istore 5
    //   1006: iload 36
    //   1008: istore 6
    //   1010: iload 35
    //   1012: istore 7
    //   1014: iload 28
    //   1016: istore 8
    //   1018: iload 39
    //   1020: istore 9
    //   1022: iload 38
    //   1024: istore_3
    //   1025: iload 46
    //   1027: istore 4
    //   1029: goto -971 -> 58
    //   1032: astore 54
    //   1034: aload 53
    //   1036: monitorexit
    //   1037: aload 54
    //   1039: athrow
    //   1040: invokestatic 74	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18:access$800	()Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThreadManager;
    //   1043: astore 50
    //   1045: aload 50
    //   1047: monitorenter
    //   1048: aload_0
    //   1049: iconst_1
    //   1050: putfield 157	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mFinishedCreatingEglSurface	Z
    //   1053: aload_0
    //   1054: iconst_1
    //   1055: putfield 129	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:mSurfaceIsBad	Z
    //   1058: invokestatic 74	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18:access$800	()Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThreadManager;
    //   1061: invokevirtual 104	java/lang/Object:notifyAll	()V
    //   1064: aload 50
    //   1066: monitorexit
    //   1067: iload 38
    //   1069: istore_3
    //   1070: iload 37
    //   1072: istore 4
    //   1074: iload 29
    //   1076: istore 5
    //   1078: iload 36
    //   1080: istore 6
    //   1082: iload 35
    //   1084: istore 7
    //   1086: iload 28
    //   1088: istore 8
    //   1090: iload 34
    //   1092: istore 9
    //   1094: iload 31
    //   1096: istore 52
    //   1098: aload 30
    //   1100: astore 10
    //   1102: iload 32
    //   1104: istore 11
    //   1106: iload 52
    //   1108: istore 12
    //   1110: goto -1052 -> 58
    //   1113: astore 51
    //   1115: aload 50
    //   1117: monitorexit
    //   1118: aload 51
    //   1120: athrow
    //   1121: iconst_1
    //   1122: istore 35
    //   1124: goto -149 -> 975
    //   1127: astore 48
    //   1129: aload 47
    //   1131: monitorexit
    //   1132: aload 48
    //   1134: athrow
    //   1135: astore 15
    //   1137: aload 14
    //   1139: monitorexit
    //   1140: aload 15
    //   1142: athrow
    //   1143: aload_2
    //   1144: astore 40
    //   1146: goto -351 -> 795
    //   1149: iload 34
    //   1151: istore 39
    //   1153: goto -390 -> 763
    //   1156: iload 9
    //   1158: istore 27
    //   1160: iload 11
    //   1162: istore 56
    //   1164: iload 5
    //   1166: istore 26
    //   1168: iload 21
    //   1170: istore 23
    //   1172: iload_3
    //   1173: istore 25
    //   1175: iload 56
    //   1177: istore 24
    //   1179: goto -614 -> 565
    //   1182: iload 6
    //   1184: istore 21
    //   1186: iload 8
    //   1188: istore 22
    //   1190: goto -665 -> 525
    //   1193: iconst_0
    //   1194: istore 18
    //   1196: goto -935 -> 261
    //   1199: iload 31
    //   1201: istore 45
    //   1203: goto -220 -> 983
    //   1206: iload 22
    //   1208: istore 8
    //   1210: iload 21
    //   1212: istore 6
    //   1214: goto -500 -> 714
    //   1217: iconst_0
    //   1218: istore_1
    //   1219: goto -381 -> 838
    //   1222: iconst_0
    //   1223: istore 36
    //   1225: goto -346 -> 879
    //
    // Exception table:
    //   from	to	target	type
    //   84	95	96	finally
    //   98	101	96	finally
    //   66	76	670	finally
    //   104	127	670	finally
    //   166	169	670	finally
    //   226	257	670	finally
    //   261	281	670	finally
    //   289	297	670	finally
    //   305	316	670	finally
    //   321	340	670	finally
    //   353	362	670	finally
    //   362	366	670	finally
    //   371	387	670	finally
    //   387	412	670	finally
    //   412	428	670	finally
    //   428	453	670	finally
    //   464	475	670	finally
    //   475	489	670	finally
    //   497	516	670	finally
    //   525	539	670	finally
    //   542	554	670	finally
    //   560	565	670	finally
    //   565	576	670	finally
    //   623	630	670	finally
    //   633	642	670	finally
    //   647	654	670	finally
    //   654	659	670	finally
    //   661	667	670	finally
    //   672	675	670	finally
    //   704	714	670	finally
    //   714	720	670	finally
    //   58	66	678	finally
    //   174	181	678	finally
    //   675	678	678	finally
    //   728	746	678	finally
    //   768	788	678	finally
    //   799	811	678	finally
    //   816	835	678	finally
    //   843	855	678	finally
    //   860	876	678	finally
    //   879	891	678	finally
    //   896	908	678	finally
    //   908	917	678	finally
    //   944	961	678	finally
    //   1037	1040	678	finally
    //   1040	1048	678	finally
    //   1118	1121	678	finally
    //   1132	1135	678	finally
    //   647	654	702	java/lang/RuntimeException
    //   746	760	1032	finally
    //   1034	1037	1032	finally
    //   1048	1067	1113	finally
    //   1115	1118	1113	finally
    //   961	975	1127	finally
    //   1129	1132	1127	finally
    //   688	699	1135	finally
    //   1137	1140	1135	finally
  }

  private boolean readyToDraw()
  {
    return (!this.mPaused) && (this.mHasSurface) && (!this.mSurfaceIsBad) && (this.mWidth > 0) && (this.mHeight > 0) && ((this.mRequestRender) || (this.mRenderMode == 1));
  }

  private void stopEglContextLocked()
  {
    if (this.mHaveEglContext)
    {
      this.mEglHelper.finish();
      this.mHaveEglContext = false;
      GLSurfaceViewAPI18.access$800().releaseEglContextLocked(this);
    }
  }

  private void stopEglSurfaceLocked()
  {
    if (this.mHaveEglSurface)
    {
      this.mHaveEglSurface = false;
      this.mEglHelper.destroySurface();
    }
  }

  public boolean ableToDraw()
  {
    return (this.mHaveEglContext) && (this.mHaveEglSurface) && (readyToDraw());
  }

  public int getRenderMode()
  {
    synchronized (GLSurfaceViewAPI18.access$800())
    {
      int i = this.mRenderMode;
      return i;
    }
  }

  public void onPause()
  {
    synchronized (GLSurfaceViewAPI18.access$800())
    {
      this.mRequestPaused = true;
      GLSurfaceViewAPI18.access$800().notifyAll();
      while (true)
        if (!this.mExited)
        {
          boolean bool = this.mPaused;
          if (!bool)
            try
            {
              GLSurfaceViewAPI18.access$800().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
        }
    }
    monitorexit;
  }

  public void onResume()
  {
    synchronized (GLSurfaceViewAPI18.access$800())
    {
      this.mRequestPaused = false;
      this.mRequestRender = true;
      this.mRenderComplete = false;
      GLSurfaceViewAPI18.access$800().notifyAll();
      while (true)
        if ((!this.mExited) && (this.mPaused))
        {
          boolean bool = this.mRenderComplete;
          if (!bool)
            try
            {
              GLSurfaceViewAPI18.access$800().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
        }
    }
    monitorexit;
  }

  public void onWindowResize(int paramInt1, int paramInt2)
  {
    synchronized (GLSurfaceViewAPI18.access$800())
    {
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
      this.mSizeChanged = true;
      this.mRequestRender = true;
      this.mRenderComplete = false;
      GLSurfaceViewAPI18.access$800().notifyAll();
      while (true)
        if ((!this.mExited) && (!this.mPaused) && (!this.mRenderComplete))
        {
          boolean bool = ableToDraw();
          if (bool)
            try
            {
              GLSurfaceViewAPI18.access$800().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
        }
    }
    monitorexit;
  }

  public void queueEvent(Runnable paramRunnable)
  {
    if (paramRunnable == null)
      throw new IllegalArgumentException("r must not be null");
    synchronized (GLSurfaceViewAPI18.access$800())
    {
      this.mEventQueue.add(paramRunnable);
      GLSurfaceViewAPI18.access$800().notifyAll();
      return;
    }
  }

  public void requestExitAndWait()
  {
    synchronized (GLSurfaceViewAPI18.access$800())
    {
      this.mShouldExit = true;
      GLSurfaceViewAPI18.access$800().notifyAll();
      while (true)
      {
        boolean bool = this.mExited;
        if (!bool)
          try
          {
            GLSurfaceViewAPI18.access$800().wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
          }
      }
    }
    monitorexit;
  }

  public void requestReleaseEglContextLocked()
  {
    this.mShouldReleaseEglContext = true;
    GLSurfaceViewAPI18.access$800().notifyAll();
  }

  public void requestRender()
  {
    synchronized (GLSurfaceViewAPI18.access$800())
    {
      this.mRequestRender = true;
      GLSurfaceViewAPI18.access$800().notifyAll();
      return;
    }
  }

  // ERROR //
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: new 238	java/lang/StringBuilder
    //   4: dup
    //   5: ldc 240
    //   7: invokespecial 241	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   10: aload_0
    //   11: invokevirtual 245	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:getId	()J
    //   14: invokevirtual 249	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   17: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20: invokevirtual 256	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:setName	(Ljava/lang/String;)V
    //   23: aload_0
    //   24: invokespecial 258	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread:guardedRun	()V
    //   27: invokestatic 74	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18:access$800	()Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThreadManager;
    //   30: aload_0
    //   31: invokevirtual 261	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThreadManager:threadExiting	(Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread;)V
    //   34: return
    //   35: astore_2
    //   36: invokestatic 74	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18:access$800	()Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThreadManager;
    //   39: aload_0
    //   40: invokevirtual 261	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThreadManager:threadExiting	(Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread;)V
    //   43: return
    //   44: astore_1
    //   45: invokestatic 74	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18:access$800	()Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThreadManager;
    //   48: aload_0
    //   49: invokevirtual 261	com/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThreadManager:threadExiting	(Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceViewAPI18$GLThread;)V
    //   52: aload_1
    //   53: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   23	27	35	java/lang/InterruptedException
    //   23	27	44	finally
  }

  public void setRenderMode(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 1))
      throw new IllegalArgumentException("renderMode");
    synchronized (GLSurfaceViewAPI18.access$800())
    {
      this.mRenderMode = paramInt;
      GLSurfaceViewAPI18.access$800().notifyAll();
      return;
    }
  }

  public void surfaceCreated()
  {
    synchronized (GLSurfaceViewAPI18.access$800())
    {
      this.mHasSurface = true;
      this.mFinishedCreatingEglSurface = false;
      GLSurfaceViewAPI18.access$800().notifyAll();
      while (true)
        if ((this.mWaitingForSurface) && (!this.mFinishedCreatingEglSurface))
        {
          boolean bool = this.mExited;
          if (!bool)
            try
            {
              GLSurfaceViewAPI18.access$800().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
        }
    }
    monitorexit;
  }

  public void surfaceDestroyed()
  {
    synchronized (GLSurfaceViewAPI18.access$800())
    {
      this.mHasSurface = false;
      GLSurfaceViewAPI18.access$800().notifyAll();
      while (true)
        if (!this.mWaitingForSurface)
        {
          boolean bool = this.mExited;
          if (!bool)
            try
            {
              GLSurfaceViewAPI18.access$800().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
        }
    }
    monitorexit;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.surfaceview.GLSurfaceViewAPI18.GLThread
 * JD-Core Version:    0.6.0
 */