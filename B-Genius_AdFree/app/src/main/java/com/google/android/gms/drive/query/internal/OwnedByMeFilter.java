package com.google.android.gms.drive.query.internal;

import android.os.Parcel;

public class OwnedByMeFilter extends AbstractFilter
{
  public static final n CREATOR = new n();
  final int a;

  public OwnedByMeFilter()
  {
    this(1);
  }

  OwnedByMeFilter(int paramInt)
  {
    this.a = paramInt;
  }

  public final Object a(f paramf)
  {
    return paramf.b();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    n.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.OwnedByMeFilter
 * JD-Core Version:    0.6.0
 */