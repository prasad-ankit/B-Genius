package com.google.android.gms.b;

import android.os.Handler;
import com.google.android.gms.ads.internal.util.client.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class ii
{
  private final Object a = new Object();
  private final List b = new ArrayList();
  private final List c = new ArrayList();
  private boolean d = false;

  private static void c(Runnable paramRunnable)
  {
    a.a.post(paramRunnable);
  }

  public final void a()
  {
    synchronized (this.a)
    {
      if (this.d)
        return;
      Iterator localIterator1 = this.b.iterator();
      if (localIterator1.hasNext())
        ho.a((Runnable)localIterator1.next());
    }
    Iterator localIterator2 = this.c.iterator();
    while (localIterator2.hasNext())
      c((Runnable)localIterator2.next());
    this.b.clear();
    this.c.clear();
    this.d = true;
    monitorexit;
  }

  public final void a(Runnable paramRunnable)
  {
    synchronized (this.a)
    {
      if (this.d)
      {
        ho.a(paramRunnable);
        return;
      }
      this.b.add(paramRunnable);
    }
  }

  public final void b(Runnable paramRunnable)
  {
    synchronized (this.a)
    {
      if (this.d)
      {
        c(paramRunnable);
        return;
      }
      this.c.add(paramRunnable);
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.ii
 * JD-Core Version:    0.6.0
 */