package com.google.android.gms.common.data;

import android.support.v4.app.w;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class g
  implements Iterator
{
  private b a;
  private int b;

  public g(b paramb)
  {
    this.a = ((b)w.a(paramb));
    this.b = -1;
  }

  public final boolean hasNext()
  {
    return this.b < -1 + this.a.b();
  }

  public final Object next()
  {
    if (!hasNext())
      throw new NoSuchElementException("Cannot advance the iterator beyond " + this.b);
    b localb = this.a;
    int i = 1 + this.b;
    this.b = i;
    return localb.a(i);
  }

  public final void remove()
  {
    throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.g
 * JD-Core Version:    0.6.0
 */