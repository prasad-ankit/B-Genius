package android.support.v4.b;

import java.util.Collection;
import java.util.Iterator;

final class j
  implements Collection
{
  j(e parame)
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
    return this.a.b(paramObject) >= 0;
  }

  public final boolean containsAll(Collection paramCollection)
  {
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
      if (!contains(localIterator.next()))
        return false;
    return true;
  }

  public final boolean isEmpty()
  {
    return this.a.a() == 0;
  }

  public final Iterator iterator()
  {
    return new f(this.a, 1);
  }

  public final boolean remove(Object paramObject)
  {
    int i = this.a.b(paramObject);
    if (i >= 0)
    {
      this.a.a(i);
      return true;
    }
    return false;
  }

  public final boolean removeAll(Collection paramCollection)
  {
    int i = 0;
    int j = this.a.a();
    int k = 0;
    while (i < j)
    {
      if (paramCollection.contains(this.a.a(i, 1)))
      {
        this.a.a(i);
        i--;
        j--;
        k = 1;
      }
      i++;
    }
    return k;
  }

  public final boolean retainAll(Collection paramCollection)
  {
    int i = 0;
    int j = this.a.a();
    int k = 0;
    while (i < j)
    {
      if (!paramCollection.contains(this.a.a(i, 1)))
      {
        this.a.a(i);
        i--;
        j--;
        k = 1;
      }
      i++;
    }
    return k;
  }

  public final int size()
  {
    return this.a.a();
  }

  public final Object[] toArray()
  {
    return this.a.b(1);
  }

  public final Object[] toArray(Object[] paramArrayOfObject)
  {
    return this.a.a(paramArrayOfObject, 1);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.b.j
 * JD-Core Version:    0.6.0
 */