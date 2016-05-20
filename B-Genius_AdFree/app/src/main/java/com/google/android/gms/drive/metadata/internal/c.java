package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.b.jB;
import com.google.android.gms.b.jK;
import com.google.android.gms.b.jM;
import com.google.android.gms.b.jU;
import com.google.android.gms.drive.metadata.a;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private static final Map a = new HashMap();
  private static final Map b = new HashMap();

  static
  {
    a(jB.a);
    a(jB.G);
    a(jB.x);
    a(jB.E);
    a(jB.H);
    a(jB.n);
    a(jB.m);
    a(jB.o);
    a(jB.p);
    a(jB.q);
    a(jB.k);
    a(jB.s);
    a(jB.t);
    a(jB.u);
    a(jB.C);
    a(jB.b);
    a(jB.z);
    a(jB.d);
    a(jB.l);
    a(jB.e);
    a(jB.f);
    a(jB.g);
    a(jB.h);
    a(jB.w);
    a(jB.r);
    a(jB.y);
    a(jB.A);
    a(jB.B);
    a(jB.D);
    a(jB.I);
    a(jB.J);
    a(jB.j);
    a(jB.i);
    a(jB.F);
    a(jB.v);
    a(jB.c);
    a(jB.K);
    a(jB.L);
    a(jB.M);
    a(jB.N);
    a(jB.O);
    a(jB.P);
    a(jB.Q);
    a(jM.a);
    a(jM.c);
    a(jM.d);
    a(jM.e);
    a(jM.b);
    a(jM.f);
    a(jU.a);
    a(jU.b);
    a(j.a);
    a(jK.a);
  }

  public static a a(String paramString)
  {
    return (a)a.get(paramString);
  }

  private static void a(a parama)
  {
    if (a.containsKey(parama.d()))
      throw new IllegalArgumentException("Duplicate field name registered: " + parama.d());
    a.put(parama.d(), parama);
  }

  private static void a(d paramd)
  {
    if (b.put(paramd.a(), paramd) != null)
      throw new IllegalStateException("A cleaner for key " + paramd.a() + " has already been registered");
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.metadata.internal.c
 * JD-Core Version:    0.6.0
 */