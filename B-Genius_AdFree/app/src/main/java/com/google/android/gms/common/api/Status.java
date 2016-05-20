package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;
import com.google.android.gms.common.internal.Q;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

public final class Status
  implements p, SafeParcelable
{
  public static final Parcelable.Creator CREATOR;
  public static final Status a = new Status(0);
  public static final Status b;
  public static final Status c;
  public static final Status d;
  private final int e;
  private final int f;
  private final String g;
  private final PendingIntent h;

  static
  {
    new Status(14);
    b = new Status(8);
    c = new Status(15);
    d = new Status(16);
    CREATOR = new t();
  }

  public Status(int paramInt)
  {
    this(paramInt, null);
  }

  Status(int paramInt1, int paramInt2, String paramString, PendingIntent paramPendingIntent)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = paramString;
    this.h = paramPendingIntent;
  }

  public Status(int paramInt, String paramString)
  {
    this(1, paramInt, paramString, null);
  }

  public Status(int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    this(1, paramInt, paramString, paramPendingIntent);
  }

  final PendingIntent a()
  {
    return this.h;
  }

  public final Status b()
  {
    return this;
  }

  public final String c()
  {
    return this.g;
  }

  final int d()
  {
    return this.e;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final boolean e()
  {
    return this.f <= 0;
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Status));
    Status localStatus;
    do
    {
      return false;
      localStatus = (Status)paramObject;
    }
    while ((this.e != localStatus.e) || (this.f != localStatus.f) || (!f.a(this.g, localStatus.g)) || (!f.a(this.h, localStatus.h)));
    return true;
  }

  public final int f()
  {
    return this.f;
  }

  public final int hashCode()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(this.e);
    arrayOfObject[1] = Integer.valueOf(this.f);
    arrayOfObject[2] = this.g;
    arrayOfObject[3] = this.h;
    return Arrays.hashCode(arrayOfObject);
  }

  public final String toString()
  {
    Q localQ = f.a(this);
    if (this.g != null);
    for (String str = this.g; ; str = j.a(this.f))
      return localQ.a("statusCode", str).a("resolution", this.h).toString();
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    t.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.Status
 * JD-Core Version:    0.6.0
 */