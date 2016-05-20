package com.google.android.gms.ads.mediation;

import android.location.Location;
import com.google.android.gms.ads.b.c;
import com.google.android.gms.ads.b.d;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class m
  implements a
{
  private final Date a;
  private final int b;
  private final Set c;
  private final boolean d;
  private final Location e;
  private final int f;
  private final NativeAdOptionsParcel g;
  private final List h;
  private final boolean i;

  public m(Date paramDate, int paramInt1, Set paramSet, Location paramLocation, boolean paramBoolean1, int paramInt2, NativeAdOptionsParcel paramNativeAdOptionsParcel, List paramList, boolean paramBoolean2)
  {
    this.a = paramDate;
    this.b = paramInt1;
    this.c = paramSet;
    this.e = paramLocation;
    this.d = paramBoolean1;
    this.f = paramInt2;
    this.g = paramNativeAdOptionsParcel;
    this.h = paramList;
    this.i = paramBoolean2;
  }

  public Date a()
  {
    return this.a;
  }

  public int b()
  {
    return this.b;
  }

  public Set c()
  {
    return this.c;
  }

  public Location d()
  {
    return this.e;
  }

  public int e()
  {
    return this.f;
  }

  public boolean f()
  {
    return this.d;
  }

  public boolean g()
  {
    return this.i;
  }

  public c h()
  {
    if (this.g == null)
      return null;
    return new d().a(this.g.b).a(this.g.c).b(this.g.d).a();
  }

  public boolean i()
  {
    return (this.h != null) && (this.h.contains("2"));
  }

  public boolean j()
  {
    return (this.h != null) && (this.h.contains("1"));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.m
 * JD-Core Version:    0.6.0
 */