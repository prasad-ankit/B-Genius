package android.support.v4.b;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class h
  implements Set
{
  h(e parame)
  {
  }

  public final boolean add(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }

  public final boolean addAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException();
  }

  public final void clear()
  {
    this.a.c();
  }

  public final boolean contains(Object paramObject)
  {
    return this.a.a(paramObject) >= 0;
  }

  public final boolean containsAll(Collection paramCollection)
  {
    Map localMap = this.a.b();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
      if (!localMap.containsKey(localIterator.next()))
        return false;
    return true;
  }

  public final boolean equals(Object paramObject)
  {
    return e.a(this, paramObject);
  }

  public final int hashCode()
  {
    int i = -1 + this.a.a();
    int j = 0;
    if (i >= 0)
    {
      Object localObject = this.a.a(i, 0);
      if (localObject == null);
      for (int k = 0; ; k = localObject.hashCode())
      {
        j += k;
        i--;
        break;
      }
    }
    return j;
  }

  public final boolean isEmpty()
  {
    return this.a.a() == 0;
  }

  public final Iterator iterator()
  {
    return new f(this.a, 0);
  }

  public final boolean remove(Object paramObject)
  {
    int i = this.a.a(paramObject);
    if (i >= 0)
    {
      this.a.a(i);
      return true;
    }
    return false;
  }

  public final boolean removeAll(Collection paramCollection)
  {
    Map localMap = this.a.b();
    int i = localMap.size();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
      localMap.remove(localIterator.next());
    return i != localMap.size();
  }

  public final boolean retainAll(Collection paramCollection)
  {
    return e.a(this.a.b(), paramCollection);
  }

  public final int size()
  {
    return this.a.a();
  }

  public final Object[] toArray()
  {
    return this.a.b(0);
  }

  public final Object[] toArray(Object[] paramArrayOfObject)
  {
    return this.a.a(paramArrayOfObject, 0);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.b.h
 * JD-Core Version:    0.6.0
 */