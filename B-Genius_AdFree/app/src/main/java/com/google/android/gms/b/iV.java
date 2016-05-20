package com.google.android.gms.b;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class iV
{
  private AtomicInteger a = new AtomicInteger();
  private final Map b = new HashMap();
  private final Set c = new HashSet();
  private final PriorityBlockingQueue d = new PriorityBlockingQueue();
  private final PriorityBlockingQueue e = new PriorityBlockingQueue();
  private final T f;
  private final eu g;
  private final jx h;
  private fl[] i;
  private aO j;
  private List k = new ArrayList();

  public iV(T paramT, eu parameu)
  {
    this(paramT, parameu, 4);
  }

  private iV(T paramT, eu parameu, int paramInt)
  {
    this(paramT, parameu, 4, new jx(new Handler(Looper.getMainLooper())));
  }

  private iV(T paramT, eu parameu, int paramInt, jx paramjx)
  {
    this.f = paramT;
    this.g = parameu;
    this.i = new fl[paramInt];
    this.h = paramjx;
  }

  public final iR a(iR paramiR)
  {
    paramiR.a(this);
    synchronized (this.c)
    {
      this.c.add(paramiR);
      paramiR.a(this.a.incrementAndGet());
      paramiR.a("add-to-queue");
      if (!paramiR.j())
      {
        this.e.add(paramiR);
        return paramiR;
      }
    }
    while (true)
    {
      String str;
      synchronized (this.b)
      {
        str = paramiR.e();
        if (this.b.containsKey(str))
        {
          Object localObject3 = (Queue)this.b.get(str);
          if (localObject3 != null)
            continue;
          localObject3 = new LinkedList();
          ((Queue)localObject3).add(paramiR);
          this.b.put(str, localObject3);
          if (!kj.a)
            continue;
          kj.a("Request for cacheKey=%s is in flight, putting on hold.", new Object[] { str });
          return paramiR;
        }
      }
      this.b.put(str, null);
      this.d.add(paramiR);
    }
  }

  public final void a()
  {
    int m = 0;
    if (this.j != null)
      this.j.a();
    for (int n = 0; n < this.i.length; n++)
    {
      if (this.i[n] == null)
        continue;
      this.i[n].a();
    }
    this.j = new aO(this.d, this.e, this.f, this.h);
    this.j.start();
    while (m < this.i.length)
    {
      fl localfl = new fl(this.e, this.g, this.f, this.h);
      this.i[m] = localfl;
      localfl.start();
      m++;
    }
  }

  final void b(iR paramiR)
  {
    synchronized (this.c)
    {
      this.c.remove(paramiR);
      synchronized (this.k)
      {
        Iterator localIterator = this.k.iterator();
        if (localIterator.hasNext())
          localIterator.next();
      }
    }
    monitorexit;
    if (paramiR.j())
      synchronized (this.b)
      {
        String str = paramiR.e();
        Queue localQueue = (Queue)this.b.remove(str);
        if (localQueue != null)
        {
          if (kj.a)
          {
            Object[] arrayOfObject = new Object[2];
            arrayOfObject[0] = Integer.valueOf(localQueue.size());
            arrayOfObject[1] = str;
            kj.a("Releasing %d waiting requests for cacheKey=%s.", arrayOfObject);
          }
          this.d.addAll(localQueue);
        }
        return;
      }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.iV
 * JD-Core Version:    0.6.0
 */