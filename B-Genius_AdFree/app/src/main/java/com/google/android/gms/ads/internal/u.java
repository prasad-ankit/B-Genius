package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.B;
import com.google.android.gms.ads.internal.client.E;
import com.google.android.gms.ads.internal.client.I;
import com.google.android.gms.ads.internal.client.W;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.bq;
import com.google.android.gms.b.bt;
import com.google.android.gms.b.bw;
import com.google.android.gms.b.bz;
import com.google.android.gms.b.el;

public final class u extends I
{
  private B a;
  private bq b;
  private bt c;
  private android.support.v4.b.k d;
  private android.support.v4.b.k e;
  private NativeAdOptionsParcel f;
  private W g;
  private final Context h;
  private final el i;
  private final String j;
  private final VersionInfoParcel k;
  private final k l;

  public u(Context paramContext, String paramString, el paramel, VersionInfoParcel paramVersionInfoParcel, k paramk)
  {
    this.h = paramContext;
    this.j = paramString;
    this.i = paramel;
    this.k = paramVersionInfoParcel;
    this.e = new android.support.v4.b.k();
    this.d = new android.support.v4.b.k();
    this.l = paramk;
  }

  public final E a()
  {
    return new s(this.h, this.j, this.i, this.k, this.a, this.b, this.c, this.e, this.d, this.f, this.g, this.l);
  }

  public final void a(B paramB)
  {
    this.a = paramB;
  }

  public final void a(W paramW)
  {
    this.g = paramW;
  }

  public final void a(NativeAdOptionsParcel paramNativeAdOptionsParcel)
  {
    this.f = paramNativeAdOptionsParcel;
  }

  public final void a(bq parambq)
  {
    this.b = parambq;
  }

  public final void a(bt parambt)
  {
    this.c = parambt;
  }

  public final void a(String paramString, bz parambz, bw parambw)
  {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException("Custom template ID for native custom template ad is empty. Please provide a valid template id.");
    this.e.put(paramString, parambz);
    this.d.put(paramString, parambw);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.u
 * JD-Core Version:    0.6.0
 */