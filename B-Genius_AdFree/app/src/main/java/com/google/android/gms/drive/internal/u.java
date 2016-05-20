package com.google.android.gms.drive.internal;

import com.google.android.gms.b.kn;
import com.google.android.gms.b.kp;
import com.google.android.gms.b.kr;

public final class u extends kp
{
  public int a = 1;
  public long b = -1L;
  public long c = -1L;
  public long d = -1L;

  public u()
  {
    this.f = null;
    this.E = -1;
  }

  protected final int a()
  {
    return super.a() + kn.b(1, this.a) + kn.d(2, this.b) + kn.d(3, this.c) + kn.d(4, this.d);
  }

  public final void a(kn paramkn)
  {
    paramkn.a(1, this.a);
    paramkn.b(2, this.b);
    paramkn.b(3, this.c);
    paramkn.b(4, this.d);
    super.a(paramkn);
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    u localu;
    while (true)
    {
      return true;
      if (!(paramObject instanceof u))
        return false;
      localu = (u)paramObject;
      if (this.a != localu.a)
        return false;
      if (this.b != localu.b)
        return false;
      if (this.c != localu.c)
        return false;
      if (this.d != localu.d)
        return false;
      if ((this.f != null) && (!this.f.b()))
        break;
      if ((localu.f != null) && (!localu.f.b()))
        return false;
    }
    return this.f.equals(localu.f);
  }

  public final int hashCode()
  {
    int i = 31 * (31 * (31 * (31 * (31 * (527 + getClass().getName().hashCode()) + this.a) + (int)(this.b ^ this.b >>> 32)) + (int)(this.c ^ this.c >>> 32)) + (int)(this.d ^ this.d >>> 32));
    if ((this.f == null) || (this.f.b()));
    for (int j = 0; ; j = this.f.hashCode())
      return j + i;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.u
 * JD-Core Version:    0.6.0
 */