package com.google.android.gms.b;

import B;
import D;
import F;
import I;
import J;
import Z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

final class ks
  implements Cloneable
{
  private kq a;
  private Object b;
  private List c = new ArrayList();

  private byte[] c()
  {
    byte[] arrayOfByte = new byte[a()];
    a(kn.a(arrayOfByte));
    return arrayOfByte;
  }

  final int a()
  {
    int i;
    if (this.b != null)
      i = this.a.a(this.b);
    while (true)
    {
      return i;
      Iterator localIterator = this.c.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        kv localkv = (kv)localIterator.next();
        i += 0 + kn.e(localkv.a) + localkv.b.length;
      }
    }
  }

  final void a(kn paramkn)
  {
    if (this.b != null)
      this.a.a(this.b, paramkn);
    while (true)
    {
      return;
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        kv localkv = (kv)localIterator.next();
        paramkn.d(localkv.a);
        paramkn.c(localkv.b);
      }
    }
  }

  public final ks b()
  {
    int i = 0;
    ks localks = new ks();
    try
    {
      localks.a = this.a;
      if (this.c == null)
        localks.c = null;
      while (true)
      {
        if (this.b == null)
          break label369;
        if (!(this.b instanceof ku))
          break;
        localks.b = ((ku)this.b).b();
        return localks;
        localks.c.addAll(this.c);
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
    if ((this.b instanceof byte[]))
    {
      localks.b = ((byte[])this.b).clone();
      return localks;
    }
    if ((this.b instanceof byte[][]))
    {
      byte[][] arrayOfByte = (byte[][])this.b;
      byte[][] arrayOfByte1 = new byte[arrayOfByte.length][];
      localks.b = arrayOfByte1;
      for (int j = 0; j < arrayOfByte.length; j++)
        arrayOfByte1[j] = ((byte[])arrayOfByte[j].clone());
    }
    if ((this.b instanceof boolean[]))
    {
      localks.b = ((boolean[])this.b).clone();
      return localks;
    }
    if ((this.b instanceof int[]))
    {
      localks.b = ((int[])this.b).clone();
      return localks;
    }
    if ((this.b instanceof long[]))
    {
      localks.b = ((long[])this.b).clone();
      return localks;
    }
    if ((this.b instanceof float[]))
    {
      localks.b = ((float[])this.b).clone();
      return localks;
    }
    if ((this.b instanceof double[]))
    {
      localks.b = ((double[])this.b).clone();
      return localks;
    }
    if ((this.b instanceof ku[]))
    {
      ku[] arrayOfku1 = (ku[])this.b;
      ku[] arrayOfku2 = new ku[arrayOfku1.length];
      localks.b = arrayOfku2;
      while (i < arrayOfku1.length)
      {
        arrayOfku2[i] = arrayOfku1[i].b();
        i++;
      }
    }
    label369: return localks;
  }

  public final boolean equals(Object paramObject)
  {
    int i;
    if (paramObject == this)
      i = 1;
    ks localks;
    while (true)
    {
      return i;
      boolean bool1 = paramObject instanceof ks;
      i = 0;
      if (!bool1)
        continue;
      localks = (ks)paramObject;
      if ((this.b == null) || (localks.b == null))
        break;
      kq localkq1 = this.a;
      kq localkq2 = localks.a;
      i = 0;
      if (localkq1 != localkq2)
        continue;
      if (!this.a.a.isArray())
        return this.b.equals(localks.b);
      if ((this.b instanceof byte[]))
        return Arrays.equals((byte[])this.b, (byte[])localks.b);
      if ((this.b instanceof int[]))
        return Arrays.equals((int[])this.b, (int[])localks.b);
      if ((this.b instanceof long[]))
        return Arrays.equals((long[])this.b, (long[])localks.b);
      if ((this.b instanceof float[]))
        return Arrays.equals((float[])this.b, (float[])localks.b);
      if ((this.b instanceof double[]))
        return Arrays.equals((double[])this.b, (double[])localks.b);
      if ((this.b instanceof boolean[]))
        return Arrays.equals((boolean[])this.b, (boolean[])localks.b);
      return Arrays.deepEquals((Object[])this.b, (Object[])localks.b);
    }
    if ((this.c != null) && (localks.c != null))
      return this.c.equals(localks.c);
    try
    {
      boolean bool2 = Arrays.equals(c(), localks.c());
      return bool2;
    }
    catch (IOException localIOException)
    {
    }
    throw new IllegalStateException(localIOException);
  }

  public final int hashCode()
  {
    try
    {
      int i = Arrays.hashCode(c());
      return i + 527;
    }
    catch (IOException localIOException)
    {
    }
    throw new IllegalStateException(localIOException);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.ks
 * JD-Core Version:    0.6.0
 */