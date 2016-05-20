package com.google.android.gms.drive.internal;

import com.google.android.gms.b.kn;
import com.google.android.gms.b.kp;
import com.google.android.gms.b.kr;

public final class v extends kp
{
  public int a = 1;
  public String b = "";
  public long c = -1L;
  public long d = -1L;
  public int e = -1;

  public v()
  {
    this.f = null;
    this.E = -1;
  }

  protected final int a()
  {
    int i = super.a() + kn.b(1, this.a) + kn.b(2, this.b) + kn.d(3, this.c) + kn.d(4, this.d);
    if (this.e != -1)
      i += kn.b(5, this.e);
    return i;
  }

  public final void a(kn paramkn)
  {
    paramkn.a(1, this.a);
    paramkn.a(2, this.b);
    paramkn.b(3, this.c);
    paramkn.b(4, this.d);
    if (this.e != -1)
      paramkn.a(5, this.e);
    super.a(paramkn);
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    v localv;
    while (true)
    {
      return true;
      if (!(paramObject instanceof v))
        return false;
      localv = (v)paramObject;
      if (this.a != localv.a)
        return false;
      if (this.b == null)
      {
        if (localv.b != null)
          return false;
      }
      else if (!this.b.equals(localv.b))
        return false;
      if (this.c != localv.c)
        return false;
      if (this.d != localv.d)
        return false;
      if (this.e != localv.e)
        return false;
      if ((this.f != null) && (!this.f.b()))
        break;
      if ((localv.f != null) && (!localv.f.b()))
        return false;
    }
    return this.f.equals(localv.f);
  }

  public final int hashCode()
  {
    int i = 31 * (31 * (527 + getClass().getName().hashCode()) + this.a);
    int j;
    int k;
    int m;
    if (this.b == null)
    {
      j = 0;
      k = 31 * (31 * (31 * (31 * (j + i) + (int)(this.c ^ this.c >>> 32)) + (int)(this.d ^ this.d >>> 32)) + this.e);
      kr localkr = this.f;
      m = 0;
      if (localkr != null)
      {
        boolean bool = this.f.b();
        m = 0;
        if (!bool)
          break label131;
      }
    }
    while (true)
    {
      return k + m;
      j = this.b.hashCode();
      break;
      label131: m = this.f.hashCode();
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.v
 * JD-Core Version:    0.6.0
 */