package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.List;

public final class AdRequestParcel
  implements SafeParcelable
{
  public static final r CREATOR = new r();
  public final int a;
  public final long b;
  public final Bundle c;
  public final int d;
  public final List e;
  public final boolean f;
  public final int g;
  public final boolean h;
  public final String i;
  public final SearchAdRequestParcel j;
  public final Location k;
  public final String l;
  public final Bundle m;
  public final Bundle n;
  public final List o;
  public final String p;
  public final String q;
  public final boolean r;

  public AdRequestParcel(int paramInt1, long paramLong, Bundle paramBundle1, int paramInt2, List paramList1, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, SearchAdRequestParcel paramSearchAdRequestParcel, Location paramLocation, String paramString2, Bundle paramBundle2, Bundle paramBundle3, List paramList2, String paramString3, String paramString4, boolean paramBoolean3)
  {
    this.a = paramInt1;
    this.b = paramLong;
    if (paramBundle1 == null)
      paramBundle1 = new Bundle();
    this.c = paramBundle1;
    this.d = paramInt2;
    this.e = paramList1;
    this.f = paramBoolean1;
    this.g = paramInt3;
    this.h = paramBoolean2;
    this.i = paramString1;
    this.j = paramSearchAdRequestParcel;
    this.k = paramLocation;
    this.l = paramString2;
    this.m = paramBundle2;
    this.n = paramBundle3;
    this.o = paramList2;
    this.p = paramString3;
    this.q = paramString4;
    this.r = paramBoolean3;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof AdRequestParcel));
    AdRequestParcel localAdRequestParcel;
    do
    {
      return false;
      localAdRequestParcel = (AdRequestParcel)paramObject;
    }
    while ((this.a != localAdRequestParcel.a) || (this.b != localAdRequestParcel.b) || (!f.a(this.c, localAdRequestParcel.c)) || (this.d != localAdRequestParcel.d) || (!f.a(this.e, localAdRequestParcel.e)) || (this.f != localAdRequestParcel.f) || (this.g != localAdRequestParcel.g) || (this.h != localAdRequestParcel.h) || (!f.a(this.i, localAdRequestParcel.i)) || (!f.a(this.j, localAdRequestParcel.j)) || (!f.a(this.k, localAdRequestParcel.k)) || (!f.a(this.l, localAdRequestParcel.l)) || (!f.a(this.m, localAdRequestParcel.m)) || (!f.a(this.n, localAdRequestParcel.n)) || (!f.a(this.o, localAdRequestParcel.o)) || (!f.a(this.p, localAdRequestParcel.p)) || (!f.a(this.q, localAdRequestParcel.q)) || (this.r != localAdRequestParcel.r));
    return true;
  }

  public final int hashCode()
  {
    Object[] arrayOfObject = new Object[18];
    arrayOfObject[0] = Integer.valueOf(this.a);
    arrayOfObject[1] = Long.valueOf(this.b);
    arrayOfObject[2] = this.c;
    arrayOfObject[3] = Integer.valueOf(this.d);
    arrayOfObject[4] = this.e;
    arrayOfObject[5] = Boolean.valueOf(this.f);
    arrayOfObject[6] = Integer.valueOf(this.g);
    arrayOfObject[7] = Boolean.valueOf(this.h);
    arrayOfObject[8] = this.i;
    arrayOfObject[9] = this.j;
    arrayOfObject[10] = this.k;
    arrayOfObject[11] = this.l;
    arrayOfObject[12] = this.m;
    arrayOfObject[13] = this.n;
    arrayOfObject[14] = this.o;
    arrayOfObject[15] = this.p;
    arrayOfObject[16] = this.q;
    arrayOfObject[17] = Boolean.valueOf(this.r);
    return Arrays.hashCode(arrayOfObject);
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    r.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.client.AdRequestParcel
 * JD-Core Version:    0.6.0
 */