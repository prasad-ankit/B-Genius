package com.google.android.gms.b;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ef
  implements dU
{
  private final AdRequestInfoParcel a;
  private final el b;
  private final Context c;
  private final dW d;
  private final boolean e;
  private final long f;
  private final long g;
  private final int h;
  private final Object i = new Object();
  private boolean j = false;
  private final Map k = new HashMap();
  private final boolean l;

  public ef(Context paramContext, AdRequestInfoParcel paramAdRequestInfoParcel, el paramel, dW paramdW, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2, int paramInt)
  {
    this.c = paramContext;
    this.a = paramAdRequestInfoParcel;
    this.b = paramel;
    this.d = paramdW;
    this.e = paramBoolean1;
    this.l = paramBoolean2;
    this.f = paramLong1;
    this.g = paramLong2;
    this.h = 2;
  }

  private void a(ih paramih)
  {
    hu.a.post(new eh(this, paramih));
  }

  private ec b(List paramList)
  {
    while (true)
    {
      ih localih;
      synchronized (this.i)
      {
        if (!this.j)
          continue;
        ec localec1 = new ec(-1);
        return localec1;
        Iterator localIterator = paramList.iterator();
        if (localIterator.hasNext())
          localih = (ih)localIterator.next();
      }
      try
      {
        ec localec2 = (ec)localih.get();
        if ((localec2 == null) || (localec2.a != 0))
          continue;
        a(localih);
        return localec2;
      }
      catch (InterruptedException localInterruptedException)
      {
        hc.c("Exception while processing an adapter; continuing with other adapters", localInterruptedException);
        continue;
        localObject2 = finally;
        monitorexit;
        throw localObject2;
        a(null);
        return new ec(1);
      }
      catch (ExecutionException localExecutionException)
      {
        label97: break label97;
      }
    }
  }

  // ERROR //
  private ec c(List paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 34	com/google/android/gms/b/ef:i	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 36	com/google/android/gms/b/ef:j	Z
    //   11: ifeq +18 -> 29
    //   14: new 84	com/google/android/gms/b/ec
    //   17: dup
    //   18: iconst_m1
    //   19: invokespecial 87	com/google/android/gms/b/ec:<init>	(I)V
    //   22: astore 4
    //   24: aload_2
    //   25: monitorexit
    //   26: aload 4
    //   28: areturn
    //   29: aload_2
    //   30: monitorexit
    //   31: iconst_m1
    //   32: istore 5
    //   34: aconst_null
    //   35: astore 6
    //   37: aconst_null
    //   38: astore 7
    //   40: aload_0
    //   41: getfield 49	com/google/android/gms/b/ef:d	Lcom/google/android/gms/b/dW;
    //   44: getfield 129	com/google/android/gms/b/dW:i	J
    //   47: ldc2_w 130
    //   50: lcmp
    //   51: ifeq +187 -> 238
    //   54: aload_0
    //   55: getfield 49	com/google/android/gms/b/ef:d	Lcom/google/android/gms/b/dW;
    //   58: getfield 129	com/google/android/gms/b/dW:i	J
    //   61: lstore 8
    //   63: aload_1
    //   64: invokeinterface 93 1 0
    //   69: astore 10
    //   71: lload 8
    //   73: lstore 11
    //   75: aload 10
    //   77: invokeinterface 99 1 0
    //   82: ifeq +240 -> 322
    //   85: aload 10
    //   87: invokeinterface 103 1 0
    //   92: checkcast 105	com/google/android/gms/b/ih
    //   95: astore 13
    //   97: invokestatic 136	com/google/android/gms/ads/internal/P:i	()Lcom/google/android/gms/b/ju;
    //   100: invokeinterface 141 1 0
    //   105: lstore 14
    //   107: lload 11
    //   109: lconst_0
    //   110: lcmp
    //   111: ifne +135 -> 246
    //   114: aload 13
    //   116: invokeinterface 144 1 0
    //   121: ifeq +125 -> 246
    //   124: aload 13
    //   126: invokeinterface 108 1 0
    //   131: checkcast 84	com/google/android/gms/b/ec
    //   134: astore 20
    //   136: aload 20
    //   138: ifnull +219 -> 357
    //   141: aload 20
    //   143: getfield 110	com/google/android/gms/b/ec:a	I
    //   146: ifne +211 -> 357
    //   149: aload 20
    //   151: getfield 147	com/google/android/gms/b/ec:f	Lcom/google/android/gms/b/ev;
    //   154: astore 24
    //   156: aload 24
    //   158: ifnull +199 -> 357
    //   161: aload 24
    //   163: invokeinterface 152 1 0
    //   168: iload 5
    //   170: if_icmple +187 -> 357
    //   173: aload 24
    //   175: invokeinterface 152 1 0
    //   180: istore 25
    //   182: iload 25
    //   184: istore 23
    //   186: aload 20
    //   188: astore 26
    //   190: aload 13
    //   192: astore 22
    //   194: aload 26
    //   196: astore 21
    //   198: lload 11
    //   200: invokestatic 136	com/google/android/gms/ads/internal/P:i	()Lcom/google/android/gms/b/ju;
    //   203: invokeinterface 141 1 0
    //   208: lload 14
    //   210: lsub
    //   211: lsub
    //   212: lconst_0
    //   213: invokestatic 158	java/lang/Math:max	(JJ)J
    //   216: lstore 11
    //   218: aload 22
    //   220: astore 6
    //   222: iload 23
    //   224: istore 5
    //   226: aload 21
    //   228: astore 7
    //   230: goto -155 -> 75
    //   233: astore_3
    //   234: aload_2
    //   235: monitorexit
    //   236: aload_3
    //   237: athrow
    //   238: ldc2_w 159
    //   241: lstore 8
    //   243: goto -180 -> 63
    //   246: aload 13
    //   248: lload 11
    //   250: getstatic 166	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   253: invokeinterface 169 4 0
    //   258: checkcast 84	com/google/android/gms/b/ec
    //   261: astore 20
    //   263: goto -127 -> 136
    //   266: astore 16
    //   268: ldc 114
    //   270: aload 16
    //   272: invokestatic 119	com/google/android/gms/b/hc:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   275: lload 11
    //   277: invokestatic 136	com/google/android/gms/ads/internal/P:i	()Lcom/google/android/gms/b/ju;
    //   280: invokeinterface 141 1 0
    //   285: lload 14
    //   287: lsub
    //   288: lsub
    //   289: lconst_0
    //   290: invokestatic 158	java/lang/Math:max	(JJ)J
    //   293: lstore 11
    //   295: goto -220 -> 75
    //   298: astore 17
    //   300: lload 11
    //   302: invokestatic 136	com/google/android/gms/ads/internal/P:i	()Lcom/google/android/gms/b/ju;
    //   305: invokeinterface 141 1 0
    //   310: lload 14
    //   312: lsub
    //   313: lsub
    //   314: lconst_0
    //   315: invokestatic 158	java/lang/Math:max	(JJ)J
    //   318: pop2
    //   319: aload 17
    //   321: athrow
    //   322: aload_0
    //   323: aload 6
    //   325: invokespecial 112	com/google/android/gms/b/ef:a	(Lcom/google/android/gms/b/ih;)V
    //   328: aload 7
    //   330: ifnonnull +42 -> 372
    //   333: new 84	com/google/android/gms/b/ec
    //   336: dup
    //   337: iconst_1
    //   338: invokespecial 87	com/google/android/gms/b/ec:<init>	(I)V
    //   341: areturn
    //   342: astore 16
    //   344: goto -76 -> 268
    //   347: astore 16
    //   349: goto -81 -> 268
    //   352: astore 16
    //   354: goto -86 -> 268
    //   357: aload 7
    //   359: astore 21
    //   361: aload 6
    //   363: astore 22
    //   365: iload 5
    //   367: istore 23
    //   369: goto -171 -> 198
    //   372: aload 7
    //   374: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   7	26	233	finally
    //   29	31	233	finally
    //   234	236	233	finally
    //   114	136	266	android/os/RemoteException
    //   141	156	266	android/os/RemoteException
    //   161	182	266	android/os/RemoteException
    //   246	263	266	android/os/RemoteException
    //   114	136	298	finally
    //   141	156	298	finally
    //   161	182	298	finally
    //   246	263	298	finally
    //   268	275	298	finally
    //   114	136	342	java/lang/InterruptedException
    //   141	156	342	java/lang/InterruptedException
    //   161	182	342	java/lang/InterruptedException
    //   246	263	342	java/lang/InterruptedException
    //   114	136	347	java/util/concurrent/ExecutionException
    //   141	156	347	java/util/concurrent/ExecutionException
    //   161	182	347	java/util/concurrent/ExecutionException
    //   246	263	347	java/util/concurrent/ExecutionException
    //   114	136	352	java/util/concurrent/TimeoutException
    //   141	156	352	java/util/concurrent/TimeoutException
    //   161	182	352	java/util/concurrent/TimeoutException
    //   246	263	352	java/util/concurrent/TimeoutException
  }

  public final ec a(List paramList)
  {
    hc.a("Starting mediation.");
    ExecutorService localExecutorService = Executors.newCachedThreadPool();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
    {
      dV localdV = (dV)localIterator1.next();
      hc.c("Trying mediation network: " + localdV.b);
      Iterator localIterator2 = localdV.c.iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        dZ localdZ = new dZ(this.c, str, this.b, this.d, localdV, this.a.c, this.a.d, this.a.k, this.e, this.l, this.a.z, this.a.n);
        ih localih = ho.a(localExecutorService, new eg(this, localdZ));
        this.k.put(localih, localdZ);
        localArrayList.add(localih);
      }
    }
    switch (this.h)
    {
    default:
      return b(localArrayList);
    case 2:
    }
    return c(localArrayList);
  }

  public final void a()
  {
    synchronized (this.i)
    {
      this.j = true;
      Iterator localIterator = this.k.values().iterator();
      if (localIterator.hasNext())
        ((dZ)localIterator.next()).a();
    }
    monitorexit;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.ef
 * JD-Core Version:    0.6.0
 */