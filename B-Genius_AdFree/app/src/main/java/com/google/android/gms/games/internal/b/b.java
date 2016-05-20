package com.google.android.gms.games.internal.b;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public abstract class b
{
  private final AtomicReference a = new AtomicReference();

  public final void a()
  {
    a locala = (a)this.a.get();
    if (locala != null)
    {
      synchronized (locala.a)
      {
        Iterator localIterator = null.entrySet().iterator();
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          localEntry.getKey();
          ((AtomicInteger)localEntry.getValue()).get();
        }
      }
      null.clear();
      monitorexit;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.b.b
 * JD-Core Version:    0.6.0
 */