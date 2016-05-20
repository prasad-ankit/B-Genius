package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.support.v4.app.w;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.i;
import com.google.android.gms.common.internal.s;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;

public final class y extends com.google.android.gms.common.api.g
  implements N
{
  final Queue a = new LinkedList();
  Set b = new HashSet();
  final Set c = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75F, 2));
  Set d = null;
  private final Lock e;
  private final com.google.android.gms.common.internal.r f;
  private M g = null;
  private final int h;
  private final Context i;
  private final Looper j;
  private volatile boolean k;
  private long l = 120000L;
  private long m = 5000L;
  private final B n;
  private final i o;
  private D p;
  private Map q;
  private com.google.android.gms.common.internal.f r;
  private Map s;
  private d t;
  private final Set u = Collections.newSetFromMap(new WeakHashMap());
  private final ArrayList v;
  private Integer w = null;
  private final E x = new z(this);
  private final s y = new A(this);

  public y(Context paramContext, Lock paramLock, Looper paramLooper, com.google.android.gms.common.internal.f paramf, i parami, d paramd, Map paramMap1, List paramList1, List paramList2, Map paramMap2, int paramInt1, int paramInt2, ArrayList paramArrayList)
  {
    this.i = paramContext;
    this.e = paramLock;
    this.f = new com.google.android.gms.common.internal.r(paramLooper, this.y);
    this.j = paramLooper;
    this.n = new B(this, paramLooper);
    this.o = parami;
    this.h = paramInt1;
    if (this.h >= 0)
      this.w = Integer.valueOf(paramInt2);
    this.s = paramMap1;
    this.q = paramMap2;
    this.v = paramArrayList;
    Iterator localIterator1 = paramList1.iterator();
    while (localIterator1.hasNext())
    {
      j localj = (j)localIterator1.next();
      this.f.a(localj);
    }
    Iterator localIterator2 = paramList2.iterator();
    while (localIterator2.hasNext())
    {
      k localk = (k)localIterator2.next();
      this.f.a(localk);
    }
    this.r = paramf;
    this.t = paramd;
  }

  public static int a(Iterable paramIterable, boolean paramBoolean)
  {
    Iterator localIterator = paramIterable.iterator();
    int i1 = 0;
    if (localIterator.hasNext())
      if (!((com.google.android.gms.common.api.e)localIterator.next()).f())
        break label52;
    label52: for (int i2 = 1; ; i2 = i1)
    {
      i1 = i2;
      break;
      if (i1 != 0)
        return 1;
      return 3;
    }
  }

  private void a(int paramInt)
  {
    if (this.w == null)
      this.w = Integer.valueOf(paramInt);
    while (this.g != null)
    {
      return;
      if (this.w.intValue() == paramInt)
        continue;
      throw new IllegalStateException("Cannot use sign-in mode: " + b(paramInt) + ". Mode was already set to " + b(this.w.intValue()));
    }
    Iterator localIterator = this.q.values().iterator();
    int i1 = 0;
    if (localIterator.hasNext())
      if (!((com.google.android.gms.common.api.e)localIterator.next()).f())
        break label281;
    label281: for (int i2 = 1; ; i2 = i1)
    {
      i1 = i2;
      break;
      switch (this.w.intValue())
      {
      case 3:
      default:
      case 1:
      case 2:
      }
      do
      {
        do
        {
          this.g = new H(this.i, this, this.e, this.j, this.o, this.q, this.r, this.s, this.t, this.v, this);
          return;
        }
        while (i1 != 0);
        throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
      }
      while (i1 == 0);
      this.g = new g(this.i, this, this.e, this.j, this.o, this.q, this.r, this.s, this.t, this.v);
      return;
    }
  }

  private static String b(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "UNKNOWN";
    case 3:
      return "SIGN_IN_MODE_NONE";
    case 1:
      return "SIGN_IN_MODE_REQUIRED";
    case 2:
    }
    return "SIGN_IN_MODE_OPTIONAL";
  }

  private void i()
  {
    this.f.b();
    this.g.a();
  }

  public final Looper a()
  {
    return this.j;
  }

  public final com.google.android.gms.common.api.e a(com.google.android.gms.common.api.f paramf)
  {
    com.google.android.gms.common.api.e locale = (com.google.android.gms.common.api.e)this.q.get(paramf);
    w.a(locale, "Appropriate Api was not requested.");
    return locale;
  }

  public final b a(b paramb)
  {
    boolean bool;
    if (paramb.b() != null)
      bool = true;
    while (true)
    {
      w.b(bool, "This task can not be enqueued (it's probably a Batch or malformed)");
      w.b(this.q.containsKey(paramb.b()), "GoogleApiClient is not configured to use the API required for this call.");
      this.e.lock();
      try
      {
        if (this.g == null)
        {
          this.a.add(paramb);
          return paramb;
          bool = false;
          continue;
        }
        b localb = this.g.a(paramb);
        return localb;
      }
      finally
      {
        this.e.unlock();
      }
    }
    throw localObject;
  }

  public final void a(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == 1) && (!paramBoolean) && (!this.k))
    {
      this.k = true;
      if (this.p == null)
        this.p = ((D)L.a(this.i.getApplicationContext(), new D(this), this.o));
      this.n.sendMessageDelayed(this.n.obtainMessage(1), this.l);
      this.n.sendMessageDelayed(this.n.obtainMessage(2), this.m);
    }
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      F localF = (F)localIterator.next();
      if (paramBoolean)
        localF.c();
      localF.b(new Status(8, "The connection to Google Play services was lost"));
    }
    this.c.clear();
    this.f.a(paramInt);
    this.f.a();
    if (paramInt == 2)
      i();
  }

  public final void a(Bundle paramBundle)
  {
    while (!this.a.isEmpty())
      b((b)this.a.remove());
    this.f.a(paramBundle);
  }

  public final void a(ConnectionResult paramConnectionResult)
  {
    if (!this.o.a(this.i, paramConnectionResult.c()))
      f();
    if (!this.k)
    {
      this.f.a(paramConnectionResult);
      this.f.a();
    }
  }

  final void a(F paramF)
  {
    this.c.add(paramF);
    paramF.a(this.x);
  }

  public final void a(k paramk)
  {
    this.f.a(paramk);
  }

  public final void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.append(paramString).append("mContext=").println(this.i);
    paramPrintWriter.append(paramString).append("mResuming=").print(this.k);
    paramPrintWriter.append(" mWorkQueue.size()=").print(this.a.size());
    paramPrintWriter.append(" mUnconsumedRunners.size()=").println(this.c.size());
    if (this.g != null)
      this.g.a(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }

  final void a(boolean paramBoolean)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      F localF = (F)localIterator.next();
      if (localF.a() == null)
      {
        if (paramBoolean)
        {
          localF.g();
          continue;
        }
        localF.f();
        this.c.remove(localF);
        continue;
      }
      localF.c();
      IBinder localIBinder = a(localF.b()).h();
      if (localF.e())
        localF.a(new C(localF, null, localIBinder, 0));
      while (true)
      {
        this.c.remove(localF);
        break;
        if ((localIBinder != null) && (localIBinder.isBinderAlive()))
        {
          C localC = new C(localF, null, localIBinder, 0);
          localF.a(localC);
          try
          {
            localIBinder.linkToDeath(localC, 0);
          }
          catch (RemoteException localRemoteException)
          {
            localF.f();
            localF.a().intValue();
            null.a();
          }
          continue;
        }
        localF.a(null);
        localF.f();
        localF.a().intValue();
        null.a();
      }
    }
  }

  public final boolean a(a parama)
  {
    return this.q.containsKey(parama.b());
  }

  public final b b(b paramb)
  {
    if (paramb.b() != null);
    for (boolean bool = true; ; bool = false)
    {
      w.b(bool, "This task can not be executed (it's probably a Batch or malformed)");
      this.e.lock();
      try
      {
        if (this.g != null)
          break;
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
      }
      finally
      {
        this.e.unlock();
      }
    }
    if (this.k)
    {
      this.a.add(paramb);
      while (!this.a.isEmpty())
      {
        F localF = (F)this.a.remove();
        a(localF);
        localF.a(Status.b);
      }
      this.e.unlock();
      return paramb;
    }
    b localb = this.g.b(paramb);
    this.e.unlock();
    return localb;
  }

  // ERROR //
  public final void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 115	com/google/android/gms/common/api/internal/y:e	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 248 1 0
    //   9: aload_0
    //   10: getfield 135	com/google/android/gms/common/api/internal/y:h	I
    //   13: iflt +112 -> 125
    //   16: aload_0
    //   17: getfield 97	com/google/android/gms/common/api/internal/y:w	Ljava/lang/Integer;
    //   20: ifnull +99 -> 119
    //   23: iconst_1
    //   24: istore 5
    //   26: iload 5
    //   28: ldc_w 461
    //   31: invokestatic 463	android/support/v4/app/w:a	(ZLjava/lang/Object;)V
    //   34: aload_0
    //   35: getfield 97	com/google/android/gms/common/api/internal/y:w	Ljava/lang/Integer;
    //   38: invokevirtual 191	java/lang/Integer:intValue	()I
    //   41: istore_2
    //   42: aload_0
    //   43: getfield 115	com/google/android/gms/common/api/internal/y:e	Ljava/util/concurrent/locks/Lock;
    //   46: invokeinterface 248 1 0
    //   51: iload_2
    //   52: iconst_3
    //   53: if_icmpeq +15 -> 68
    //   56: iload_2
    //   57: iconst_1
    //   58: if_icmpeq +10 -> 68
    //   61: iconst_0
    //   62: istore_3
    //   63: iload_2
    //   64: iconst_2
    //   65: if_icmpne +5 -> 70
    //   68: iconst_1
    //   69: istore_3
    //   70: iload_3
    //   71: new 195	java/lang/StringBuilder
    //   74: dup
    //   75: ldc_w 465
    //   78: invokespecial 200	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   81: iload_2
    //   82: invokevirtual 468	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   85: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 286	android/support/v4/app/w:b	(ZLjava/lang/Object;)V
    //   91: aload_0
    //   92: iload_2
    //   93: invokespecial 469	com/google/android/gms/common/api/internal/y:a	(I)V
    //   96: aload_0
    //   97: invokespecial 252	com/google/android/gms/common/api/internal/y:i	()V
    //   100: aload_0
    //   101: getfield 115	com/google/android/gms/common/api/internal/y:e	Ljava/util/concurrent/locks/Lock;
    //   104: invokeinterface 255 1 0
    //   109: aload_0
    //   110: getfield 115	com/google/android/gms/common/api/internal/y:e	Ljava/util/concurrent/locks/Lock;
    //   113: invokeinterface 255 1 0
    //   118: return
    //   119: iconst_0
    //   120: istore 5
    //   122: goto -96 -> 26
    //   125: aload_0
    //   126: getfield 97	com/google/android/gms/common/api/internal/y:w	Ljava/lang/Integer;
    //   129: ifnonnull +38 -> 167
    //   132: aload_0
    //   133: aload_0
    //   134: getfield 145	com/google/android/gms/common/api/internal/y:q	Ljava/util/Map;
    //   137: invokeinterface 220 1 0
    //   142: iconst_0
    //   143: invokestatic 471	com/google/android/gms/common/api/internal/y:a	(Ljava/lang/Iterable;Z)I
    //   146: invokestatic 141	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   149: putfield 97	com/google/android/gms/common/api/internal/y:w	Ljava/lang/Integer;
    //   152: goto -118 -> 34
    //   155: astore_1
    //   156: aload_0
    //   157: getfield 115	com/google/android/gms/common/api/internal/y:e	Ljava/util/concurrent/locks/Lock;
    //   160: invokeinterface 255 1 0
    //   165: aload_1
    //   166: athrow
    //   167: aload_0
    //   168: getfield 97	com/google/android/gms/common/api/internal/y:w	Ljava/lang/Integer;
    //   171: invokevirtual 191	java/lang/Integer:intValue	()I
    //   174: iconst_2
    //   175: if_icmpne -141 -> 34
    //   178: new 193	java/lang/IllegalStateException
    //   181: dup
    //   182: ldc_w 473
    //   185: invokespecial 214	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   188: athrow
    //   189: astore 4
    //   191: aload_0
    //   192: getfield 115	com/google/android/gms/common/api/internal/y:e	Ljava/util/concurrent/locks/Lock;
    //   195: invokeinterface 255 1 0
    //   200: aload 4
    //   202: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   9	23	155	finally
    //   26	34	155	finally
    //   34	51	155	finally
    //   100	109	155	finally
    //   125	152	155	finally
    //   167	189	155	finally
    //   191	203	155	finally
    //   70	100	189	finally
  }

  public final void b(k paramk)
  {
    this.f.b(paramk);
  }

  public final boolean b(a parama)
  {
    com.google.android.gms.common.api.e locale = (com.google.android.gms.common.api.e)this.q.get(parama.b());
    return (locale != null) && (locale.e());
  }

  public final void c()
  {
    this.e.lock();
    while (true)
    {
      try
      {
        if ((this.g != null) && (!this.g.b()))
        {
          bool = true;
          a(bool);
          Iterator localIterator1 = this.u.iterator();
          if (!localIterator1.hasNext())
            break;
          ((com.google.android.gms.drive.e)localIterator1.next()).b();
          continue;
        }
      }
      finally
      {
        this.e.unlock();
      }
      boolean bool = false;
    }
    this.u.clear();
    Iterator localIterator2 = this.a.iterator();
    while (localIterator2.hasNext())
    {
      F localF = (F)localIterator2.next();
      localF.a(null);
      localF.f();
    }
    this.a.clear();
    M localM = this.g;
    if (localM == null)
    {
      this.e.unlock();
      return;
    }
    f();
    this.f.a();
    this.e.unlock();
  }

  public final boolean d()
  {
    return (this.g != null) && (this.g.c());
  }

  final boolean f()
  {
    if (!this.k)
      return false;
    this.k = false;
    this.n.removeMessages(2);
    this.n.removeMessages(1);
    if (this.p != null)
    {
      this.p.b();
      this.p = null;
    }
    return true;
  }

  final boolean g()
  {
    this.e.lock();
    try
    {
      Set localSet = this.d;
      if (localSet == null)
        return false;
      boolean bool = this.d.isEmpty();
      int i1 = 0;
      if (!bool)
        i1 = 1;
      return i1;
    }
    finally
    {
      this.e.unlock();
    }
    throw localObject;
  }

  final String h()
  {
    StringWriter localStringWriter = new StringWriter();
    a("", null, new PrintWriter(localStringWriter), null);
    return localStringWriter.toString();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.y
 * JD-Core Version:    0.6.0
 */