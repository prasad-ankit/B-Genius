package com.google.android.gms.b;

import android.support.v4.b.a;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class jt extends AbstractSet
{
  private final a a;

  public jt()
  {
    this.a = new a();
  }

  public jt(int paramInt)
  {
    this.a = new a(paramInt);
  }

  public jt(Collection paramCollection)
  {
    this(paramCollection.size());
    addAll(paramCollection);
  }

  public final boolean add(Object paramObject)
  {
    if (this.a.containsKey(paramObject))
      return false;
    this.a.put(paramObject, paramObject);
    return true;
  }

  public final boolean addAll(Collection paramCollection)
  {
    if ((paramCollection instanceof jt))
    {
      jt localjt = (jt)paramCollection;
      int i = size();
      this.a.a(localjt.a);
      return size() > i;
    }
    return super.addAll(paramCollection);
  }

  public final void clear()
  {
    this.a.clear();
  }

  public final boolean contains(Object paramObject)
  {
    return this.a.containsKey(paramObject);
  }

  public final Iterator iterator()
  {
    return this.a.keySet().iterator();
  }

  public final boolean remove(Object paramObject)
  {
    if (!this.a.containsKey(paramObject))
      return false;
    this.a.remove(paramObject);
    return true;
  }

  public final int size()
  {
    return this.a.size();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.jt
 * JD-Core Version:    0.6.0
 */