package com.google.android.gms.ads.c;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.v4.app.w;
import com.google.android.gms.b.D;
import com.google.android.gms.b.E;
import com.google.android.gms.common.g;
import com.google.android.gms.common.i;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public final class a
{
  private g a;
  private D b;
  private boolean c;
  private Object d = new Object();
  private c e;
  private final Context f;
  private long g;

  public a(Context paramContext)
  {
    this(paramContext, 30000L);
  }

  private a(Context paramContext, long paramLong)
  {
    w.a(paramContext);
    this.f = paramContext;
    this.c = false;
    this.g = paramLong;
  }

  public static b a(Context paramContext)
  {
    a locala = new a(paramContext, -1L);
    try
    {
      locala.a(false);
      b localb = locala.b();
      return localb;
    }
    finally
    {
      locala.c();
    }
    throw localObject;
  }

  private static D a(g paramg)
  {
    try
    {
      D localD = E.a(paramg.a());
      return localD;
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new IOException("Interrupted exception");
    }
    catch (Throwable localThrowable)
    {
    }
    throw new IOException(localThrowable);
  }

  private void a(boolean paramBoolean)
  {
    w.c("Calling this from your main thread can lead to deadlock");
    monitorenter;
    try
    {
      if (this.c)
        c();
      this.a = b(this.f);
      this.b = a(this.a);
      this.c = true;
      if (paramBoolean)
        d();
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private static g b(Context paramContext)
  {
    try
    {
      paramContext.getPackageManager().getPackageInfo("com.android.vending", 0);
      switch (i.b().a(paramContext))
      {
      case 1:
      default:
        throw new IOException("Google Play services not available");
      case 0:
      case 2:
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      throw new com.google.android.gms.common.c(9);
    }
    g localg = new g();
    Intent localIntent = new Intent("com.google.android.gms.ads.identifier.service.START");
    localIntent.setPackage("com.google.android.gms");
    try
    {
      boolean bool = com.google.android.gms.common.stats.b.a().a(paramContext, localIntent, localg, 1);
      if (bool)
        return localg;
    }
    catch (Throwable localThrowable)
    {
      throw new IOException(localThrowable);
    }
    throw new IOException("Connection failure");
  }

  private void d()
  {
    synchronized (this.d)
    {
      if (this.e != null)
        this.e.a.countDown();
    }
    try
    {
      this.e.join();
      label31: if (this.g > 0L)
        this.e = new c(this, this.g);
      monitorexit;
      return;
      localObject2 = finally;
      monitorexit;
      throw localObject2;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label31;
    }
  }

  public final void a()
  {
    a(true);
  }

  // ERROR //
  public final b b()
  {
    // Byte code:
    //   0: ldc 79
    //   2: invokestatic 81	android/support/v4/app/w:c	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 39	com/google/android/gms/ads/c/a:c	Z
    //   11: ifne +91 -> 102
    //   14: aload_0
    //   15: getfield 30	com/google/android/gms/ads/c/a:d	Ljava/lang/Object;
    //   18: astore 7
    //   20: aload 7
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 147	com/google/android/gms/ads/c/a:e	Lcom/google/android/gms/ads/c/c;
    //   27: ifnull +13 -> 40
    //   30: aload_0
    //   31: getfield 147	com/google/android/gms/ads/c/a:e	Lcom/google/android/gms/ads/c/c;
    //   34: getfield 169	com/google/android/gms/ads/c/c:b	Z
    //   37: ifne +26 -> 63
    //   40: new 69	java/io/IOException
    //   43: dup
    //   44: ldc 171
    //   46: invokespecial 74	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   49: athrow
    //   50: astore 8
    //   52: aload 7
    //   54: monitorexit
    //   55: aload 8
    //   57: athrow
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    //   63: aload 7
    //   65: monitorexit
    //   66: aload_0
    //   67: iconst_0
    //   68: invokespecial 47	com/google/android/gms/ads/c/a:a	(Z)V
    //   71: aload_0
    //   72: getfield 39	com/google/android/gms/ads/c/a:c	Z
    //   75: ifne +27 -> 102
    //   78: new 69	java/io/IOException
    //   81: dup
    //   82: ldc 173
    //   84: invokespecial 74	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   87: athrow
    //   88: astore 9
    //   90: new 69	java/io/IOException
    //   93: dup
    //   94: ldc 173
    //   96: aload 9
    //   98: invokespecial 176	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   101: athrow
    //   102: aload_0
    //   103: getfield 86	com/google/android/gms/ads/c/a:a	Lcom/google/android/gms/common/g;
    //   106: invokestatic 35	android/support/v4/app/w:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   109: pop
    //   110: aload_0
    //   111: getfield 90	com/google/android/gms/ads/c/a:b	Lcom/google/android/gms/b/D;
    //   114: invokestatic 35	android/support/v4/app/w:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   117: pop
    //   118: new 178	com/google/android/gms/ads/c/b
    //   121: dup
    //   122: aload_0
    //   123: getfield 90	com/google/android/gms/ads/c/a:b	Lcom/google/android/gms/b/D;
    //   126: invokeinterface 183 1 0
    //   131: aload_0
    //   132: getfield 90	com/google/android/gms/ads/c/a:b	Lcom/google/android/gms/b/D;
    //   135: iconst_1
    //   136: invokeinterface 186 2 0
    //   141: invokespecial 189	com/google/android/gms/ads/c/b:<init>	(Ljava/lang/String;Z)V
    //   144: astore 4
    //   146: aload_0
    //   147: monitorexit
    //   148: aload_0
    //   149: invokespecial 92	com/google/android/gms/ads/c/a:d	()V
    //   152: aload 4
    //   154: areturn
    //   155: astore 5
    //   157: ldc 191
    //   159: ldc 193
    //   161: aload 5
    //   163: invokestatic 199	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   166: pop
    //   167: new 69	java/io/IOException
    //   170: dup
    //   171: ldc 201
    //   173: invokespecial 74	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   176: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   23	40	50	finally
    //   40	50	50	finally
    //   52	55	50	finally
    //   63	66	50	finally
    //   7	23	58	finally
    //   55	58	58	finally
    //   59	61	58	finally
    //   66	71	58	finally
    //   71	88	58	finally
    //   90	102	58	finally
    //   102	118	58	finally
    //   118	146	58	finally
    //   146	148	58	finally
    //   157	177	58	finally
    //   66	71	88	java/lang/Exception
    //   118	146	155	android/os/RemoteException
  }

  // ERROR //
  public final void c()
  {
    // Byte code:
    //   0: ldc 79
    //   2: invokestatic 81	android/support/v4/app/w:c	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 37	com/google/android/gms/ads/c/a:f	Landroid/content/Context;
    //   11: ifnull +10 -> 21
    //   14: aload_0
    //   15: getfield 86	com/google/android/gms/ads/c/a:a	Lcom/google/android/gms/common/g;
    //   18: ifnonnull +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 39	com/google/android/gms/ads/c/a:c	Z
    //   28: ifeq +17 -> 45
    //   31: invokestatic 140	com/google/android/gms/common/stats/b:a	()Lcom/google/android/gms/common/stats/b;
    //   34: aload_0
    //   35: getfield 37	com/google/android/gms/ads/c/a:f	Landroid/content/Context;
    //   38: aload_0
    //   39: getfield 86	com/google/android/gms/ads/c/a:a	Lcom/google/android/gms/common/g;
    //   42: invokevirtual 206	com/google/android/gms/common/stats/b:a	(Landroid/content/Context;Landroid/content/ServiceConnection;)V
    //   45: aload_0
    //   46: iconst_0
    //   47: putfield 39	com/google/android/gms/ads/c/a:c	Z
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield 90	com/google/android/gms/ads/c/a:b	Lcom/google/android/gms/b/D;
    //   55: aload_0
    //   56: aconst_null
    //   57: putfield 86	com/google/android/gms/ads/c/a:a	Lcom/google/android/gms/common/g;
    //   60: aload_0
    //   61: monitorexit
    //   62: return
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    //   68: astore_2
    //   69: ldc 191
    //   71: ldc 208
    //   73: aload_2
    //   74: invokestatic 199	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   77: pop
    //   78: goto -33 -> 45
    //
    // Exception table:
    //   from	to	target	type
    //   7	21	63	finally
    //   21	23	63	finally
    //   24	45	63	finally
    //   45	62	63	finally
    //   64	66	63	finally
    //   69	78	63	finally
    //   24	45	68	java/lang/IllegalArgumentException
  }

  protected final void finalize()
  {
    c();
    super.finalize();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.c.a
 * JD-Core Version:    0.6.0
 */