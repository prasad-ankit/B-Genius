package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.ads.e.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class SearchAdRequestParcel
  implements SafeParcelable
{
  public static final l CREATOR = new l();
  public final int a;
  public final int b;
  public final int c;
  public final int d;
  public final int e;
  public final int f;
  public final int g;
  public final int h;
  public final int i;
  public final String j;
  public final int k;
  public final String l;
  public final int m;
  public final int n;
  public final String o;

  SearchAdRequestParcel(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, String paramString1, int paramInt10, String paramString2, int paramInt11, int paramInt12, String paramString3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
    this.f = paramInt6;
    this.g = paramInt7;
    this.h = paramInt8;
    this.i = paramInt9;
    this.j = paramString1;
    this.k = paramInt10;
    this.l = paramString2;
    this.m = paramInt11;
    this.n = paramInt12;
    this.o = paramString3;
  }

  public SearchAdRequestParcel(a parama)
  {
    this.a = 1;
    this.b = parama.a();
    this.c = parama.b();
    this.d = parama.c();
    this.e = parama.d();
    this.f = parama.e();
    this.g = parama.f();
    this.h = parama.g();
    this.i = parama.h();
    this.j = parama.i();
    this.k = parama.j();
    this.l = parama.k();
    this.m = parama.l();
    this.n = parama.m();
    this.o = parama.n();
  }

  public final int describeContents()
  {
    return 0;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    l.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.client.SearchAdRequestParcel
 * JD-Core Version:    0.6.0
 */