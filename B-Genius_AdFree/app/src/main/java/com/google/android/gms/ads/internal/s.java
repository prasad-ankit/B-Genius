package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.B;
import com.google.android.gms.ads.internal.client.F;
import com.google.android.gms.ads.internal.client.W;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.bq;
import com.google.android.gms.b.bt;
import com.google.android.gms.b.el;
import com.google.android.gms.b.hu;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class s extends F
{
  private final Context a;
  private final B b;
  private final el c;
  private final bq d;
  private final bt e;
  private final android.support.v4.b.k f;
  private final android.support.v4.b.k g;
  private final NativeAdOptionsParcel h;
  private final W i;
  private final String j;
  private final VersionInfoParcel k;
  private WeakReference l;
  private final k m;
  private final Object n = new Object();

  s(Context paramContext, String paramString, el paramel, VersionInfoParcel paramVersionInfoParcel, B paramB, bq parambq, bt parambt, android.support.v4.b.k paramk1, android.support.v4.b.k paramk2, NativeAdOptionsParcel paramNativeAdOptionsParcel, W paramW, k paramk)
  {
    this.a = paramContext;
    this.j = paramString;
    this.c = paramel;
    this.k = paramVersionInfoParcel;
    this.b = paramB;
    this.e = parambt;
    this.d = parambq;
    this.f = paramk1;
    this.g = paramk2;
    this.h = paramNativeAdOptionsParcel;
    d();
    this.i = paramW;
    this.m = paramk;
  }

  private List d()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.e != null)
      localArrayList.add("1");
    if (this.d != null)
      localArrayList.add("2");
    if (this.f.size() > 0)
      localArrayList.add("3");
    return localArrayList;
  }

  public final void a(AdRequestParcel paramAdRequestParcel)
  {
    t localt = new t(this, paramAdRequestParcel);
    hu.a.post(localt);
  }

  public final boolean a()
  {
    while (true)
    {
      synchronized (this.n)
      {
        if (this.l == null)
          continue;
        H localH = (H)this.l.get();
        if (localH != null)
        {
          bool = localH.k();
          return bool;
          return false;
        }
      }
      boolean bool = false;
    }
  }

  public final String b()
  {
    while (true)
    {
      synchronized (this.n)
      {
        if (this.l == null)
          continue;
        H localH = (H)this.l.get();
        if (localH != null)
        {
          str = localH.j();
          return str;
          return null;
        }
      }
      String str = null;
    }
  }

  protected final H c()
  {
    return new H(this.a, this.m, AdSizeParcel.a(), this.j, this.c, this.k);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.s
 * JD-Core Version:    0.6.0
 */