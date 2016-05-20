package com.google.android.gms.common.internal;

import java.util.ArrayList;

public abstract class l
{
  private Object a;
  private boolean b;

  public l(i parami, Object paramObject)
  {
    this.a = paramObject;
    this.b = false;
  }

  protected abstract void a(Object paramObject);

  // ERROR //
  public final void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 19	com/google/android/gms/common/internal/l:a	Ljava/lang/Object;
    //   6: astore_2
    //   7: aload_0
    //   8: getfield 21	com/google/android/gms/common/internal/l:b	Z
    //   11: ifeq +30 -> 41
    //   14: ldc 26
    //   16: new 28	java/lang/StringBuilder
    //   19: dup
    //   20: ldc 30
    //   22: invokespecial 33	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   29: ldc 39
    //   31: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 52	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   40: pop
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_2
    //   44: ifnull +8 -> 52
    //   47: aload_0
    //   48: aload_2
    //   49: invokevirtual 54	com/google/android/gms/common/internal/l:a	(Ljava/lang/Object;)V
    //   52: aload_0
    //   53: monitorenter
    //   54: aload_0
    //   55: iconst_1
    //   56: putfield 21	com/google/android/gms/common/internal/l:b	Z
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_0
    //   62: invokevirtual 56	com/google/android/gms/common/internal/l:c	()V
    //   65: return
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    //   71: astore 4
    //   73: aload 4
    //   75: athrow
    //   76: astore_3
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_3
    //   80: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   2	41	66	finally
    //   41	43	66	finally
    //   67	69	66	finally
    //   47	52	71	java/lang/RuntimeException
    //   54	61	76	finally
    //   77	79	76	finally
  }

  public final void c()
  {
    d();
    synchronized (i.d(this.c))
    {
      i.d(this.c).remove(this);
      return;
    }
  }

  public final void d()
  {
    monitorenter;
    try
    {
      this.a = null;
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.l
 * JD-Core Version:    0.6.0
 */