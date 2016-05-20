package com.google.android.gms.b;

import android.content.Context;
import com.google.android.gms.ads.c.a;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class v extends t
{
  private static a k = null;
  private static CountDownLatch l = new CountDownLatch(1);
  private boolean m;

  private v(Context paramContext, A paramA, boolean paramBoolean)
  {
    super(paramContext, paramA);
    this.m = paramBoolean;
  }

  public static v a(String paramString, Context paramContext, boolean paramBoolean)
  {
    A localA = new A();
    a(paramString, paramContext, localA);
    if (paramBoolean)
      monitorenter;
    try
    {
      if (k == null)
        new Thread(new x(paramContext)).start();
      return new v(paramContext, localA, paramBoolean);
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private w d()
  {
    try
    {
      if (!l.await(2L, TimeUnit.SECONDS))
      {
        w localw1 = new w(this, null, false);
        return localw1;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      return new w(this, null, false);
    }
    monitorenter;
    try
    {
      if (k == null)
      {
        w localw2 = new w(this, null, false);
        return localw2;
      }
    }
    finally
    {
      monitorexit;
    }
    com.google.android.gms.ads.c.b localb = k.b();
    monitorexit;
    return new w(this, a(localb.a()), localb.b());
  }

  protected final com.google.ads.a.a.b b(Context paramContext)
  {
    com.google.ads.a.a.b localb = super.b(paramContext);
    if (this.m)
      try
      {
        if (a())
        {
          w localw = d();
          String str = localw.a();
          if (str != null)
          {
            localb.C = Boolean.valueOf(localw.b());
            localb.B = Integer.valueOf(5);
            localb.A = str;
            a(28, j);
            return localb;
          }
        }
        else
        {
          localb.A = d(paramContext);
          a(24, j);
          return localb;
        }
      }
      catch (IOException localIOException)
      {
        return localb;
      }
      catch (u localu)
      {
      }
    return localb;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.v
 * JD-Core Version:    0.6.0
 */