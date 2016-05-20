package com.google.android.gms.drive.query.internal;

import android.os.Parcel;

public class MatchAllFilter extends AbstractFilter
{
  public static final k CREATOR = new k();
  final int a;

  public MatchAllFilter()
  {
    this(1);
  }

  MatchAllFilter(int paramInt)
  {
    this.a = paramInt;
  }

  public final Object a(f paramf)
  {
    return paramf.a();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    k.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.MatchAllFilter
 * JD-Core Version:    0.6.0
 */