package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ConnectionEvent extends g
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new a();
  final int a;
  private final long b;
  private int c;
  private final String d;
  private final String e;
  private final String f;
  private final String g;
  private final String h;
  private final String i;
  private final long j;
  private final long k;
  private long l;

  ConnectionEvent(int paramInt1, long paramLong1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong2, long paramLong3)
  {
    this.a = paramInt1;
    this.b = paramLong1;
    this.c = paramInt2;
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramString3;
    this.g = paramString4;
    this.l = -1L;
    this.h = paramString5;
    this.i = paramString6;
    this.j = paramLong2;
    this.k = paramLong3;
  }

  public ConnectionEvent(long paramLong1, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong2, long paramLong3)
  {
    this(1, paramLong1, paramInt, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramLong2, paramLong3);
  }

  public final long a()
  {
    return this.b;
  }

  public final int b()
  {
    return this.c;
  }

  public final String c()
  {
    return this.d;
  }

  public final String d()
  {
    return this.e;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final String e()
  {
    return this.f;
  }

  public final String f()
  {
    return this.g;
  }

  public final String g()
  {
    return this.h;
  }

  public final String h()
  {
    return this.i;
  }

  public final long i()
  {
    return this.l;
  }

  public final long j()
  {
    return this.k;
  }

  public final long k()
  {
    return this.j;
  }

  public final String l()
  {
    StringBuilder localStringBuilder = new StringBuilder("\t").append(this.d).append("/").append(this.e).append("\t").append(this.f).append("/").append(this.g).append("\t");
    if (this.h == null);
    for (String str = ""; ; str = this.h)
      return str + "\t" + this.k;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.stats.ConnectionEvent
 * JD-Core Version:    0.6.0
 */