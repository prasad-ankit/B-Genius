package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class Scope
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new s();
  final int a;
  private final String b;

  Scope(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException(String.valueOf("scopeUri must not be null or empty"));
    this.a = paramInt;
    this.b = paramString;
  }

  public Scope(String paramString)
  {
    this(1, paramString);
  }

  public final String a()
  {
    return this.b;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!(paramObject instanceof Scope))
      return false;
    return this.b.equals(((Scope)paramObject).b);
  }

  public final int hashCode()
  {
    return this.b.hashCode();
  }

  public final String toString()
  {
    return this.b;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    s.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.Scope
 * JD-Core Version:    0.6.0
 */