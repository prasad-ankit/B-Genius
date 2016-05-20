package com.google.ads.a.a;

import com.google.android.gms.b.kn;
import com.google.android.gms.b.ku;

public final class b extends ku
{
  public String A = null;
  public Integer B = null;
  public Boolean C = null;
  public Long D = null;
  private Long F = null;
  private Long G = null;
  private Long H = null;
  private Long I = null;
  private Long J = null;
  private Long K = null;
  private String L = null;
  private Long M = null;
  private Long N = null;
  private Long O = null;
  private d P = null;
  private Long Q = null;
  private String R = null;
  private e S = null;
  public String a = null;
  public String b = null;
  public Long c = null;
  public Long d = null;
  public Long e = null;
  public Long f = null;
  public Long g = null;
  public Long h = null;
  public Long i = null;
  public Long j = null;
  public Long k = null;
  public Long l = null;
  public String m = null;
  public String n = null;
  public Long o = null;
  public Long p = null;
  public Long q = null;
  public String r = null;
  public Long s = null;
  public Long t = null;
  public Long u = null;
  public Long v = null;
  public Long w = null;
  public Long x = null;
  public Long y = null;
  public c[] z = c.a_();

  public b()
  {
    this.E = -1;
  }

  protected final int a()
  {
    int i1 = super.a();
    if (this.a != null)
      i1 += kn.b(1, this.a);
    if (this.b != null)
      i1 += kn.b(2, this.b);
    if (this.c != null)
      i1 += kn.c(3, this.c.longValue());
    if (this.d != null)
      i1 += kn.c(5, this.d.longValue());
    if (this.e != null)
      i1 += kn.c(6, this.e.longValue());
    if (this.f != null)
      i1 += kn.c(12, this.f.longValue());
    if (this.g != null)
      i1 += kn.c(14, this.g.longValue());
    if (this.h != null)
      i1 += kn.c(15, this.h.longValue());
    if (this.i != null)
      i1 += kn.c(16, this.i.longValue());
    if (this.j != null)
      i1 += kn.c(17, this.j.longValue());
    if (this.k != null)
      i1 += kn.c(20, this.k.longValue());
    if (this.l != null)
      i1 += kn.c(23, this.l.longValue());
    if (this.A != null)
      i1 += kn.b(24, this.A);
    if (this.D != null)
      i1 += kn.c(25, this.D.longValue());
    if (this.B != null)
      i1 += kn.b(26, this.B.intValue());
    if (this.m != null)
      i1 += kn.b(27, this.m);
    if (this.C != null)
    {
      this.C.booleanValue();
      i1 += 1 + kn.c(28);
    }
    if (this.n != null)
      i1 += kn.b(29, this.n);
    if (this.o != null)
      i1 += kn.c(31, this.o.longValue());
    if (this.p != null)
      i1 += kn.c(32, this.p.longValue());
    if (this.q != null)
      i1 += kn.c(33, this.q.longValue());
    if (this.r != null)
      i1 += kn.b(34, this.r);
    if (this.s != null)
      i1 += kn.c(35, this.s.longValue());
    if (this.t != null)
      i1 += kn.c(36, this.t.longValue());
    if (this.u != null)
      i1 += kn.c(37, this.u.longValue());
    if (this.v != null)
      i1 += kn.c(39, this.v.longValue());
    if (this.w != null)
      i1 += kn.c(40, this.w.longValue());
    if (this.x != null)
      i1 += kn.c(41, this.x.longValue());
    if (this.y != null)
      i1 += kn.c(42, this.y.longValue());
    if ((this.z != null) && (this.z.length > 0))
    {
      int i2 = i1;
      for (int i3 = 0; i3 < this.z.length; i3++)
      {
        c localc = this.z[i3];
        if (localc == null)
          continue;
        i2 += kn.b(43, localc);
      }
      i1 = i2;
    }
    return i1;
  }

  public final void a(kn paramkn)
  {
    int i1 = 1;
    if (this.a != null)
      paramkn.a(i1, this.a);
    if (this.b != null)
      paramkn.a(2, this.b);
    if (this.c != null)
      paramkn.a(3, this.c.longValue());
    if (this.d != null)
      paramkn.a(5, this.d.longValue());
    if (this.e != null)
      paramkn.a(6, this.e.longValue());
    if (this.f != null)
      paramkn.a(12, this.f.longValue());
    if (this.g != null)
      paramkn.a(14, this.g.longValue());
    if (this.h != null)
      paramkn.a(15, this.h.longValue());
    if (this.i != null)
      paramkn.a(16, this.i.longValue());
    if (this.j != null)
      paramkn.a(17, this.j.longValue());
    if (this.k != null)
      paramkn.a(20, this.k.longValue());
    if (this.l != null)
      paramkn.a(23, this.l.longValue());
    if (this.A != null)
      paramkn.a(24, this.A);
    if (this.D != null)
      paramkn.a(25, this.D.longValue());
    if (this.B != null)
      paramkn.a(26, this.B.intValue());
    if (this.m != null)
      paramkn.a(27, this.m);
    if (this.C != null)
    {
      boolean bool = this.C.booleanValue();
      paramkn.c(28, 0);
      if (!bool)
        break label631;
    }
    while (true)
    {
      paramkn.b(i1);
      if (this.n != null)
        paramkn.a(29, this.n);
      if (this.o != null)
        paramkn.a(31, this.o.longValue());
      if (this.p != null)
        paramkn.a(32, this.p.longValue());
      if (this.q != null)
        paramkn.a(33, this.q.longValue());
      if (this.r != null)
        paramkn.a(34, this.r);
      if (this.s != null)
        paramkn.a(35, this.s.longValue());
      if (this.t != null)
        paramkn.a(36, this.t.longValue());
      if (this.u != null)
        paramkn.a(37, this.u.longValue());
      if (this.v != null)
        paramkn.a(39, this.v.longValue());
      if (this.w != null)
        paramkn.a(40, this.w.longValue());
      if (this.x != null)
        paramkn.a(41, this.x.longValue());
      if (this.y != null)
        paramkn.a(42, this.y.longValue());
      if (this.z == null)
        break;
      int i2 = this.z.length;
      int i3 = 0;
      if (i2 <= 0)
        break;
      while (i3 < this.z.length)
      {
        c localc = this.z[i3];
        if (localc != null)
          paramkn.a(43, localc);
        i3++;
      }
      label631: i1 = 0;
    }
    super.a(paramkn);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.a.a.b
 * JD-Core Version:    0.6.0
 */