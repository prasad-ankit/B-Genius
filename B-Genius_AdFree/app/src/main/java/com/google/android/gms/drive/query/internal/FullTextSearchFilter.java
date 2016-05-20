package com.google.android.gms.drive.query.internal;

import android.os.Parcel;

public class FullTextSearchFilter extends AbstractFilter
{
  public static final g CREATOR = new g();
  final String a;
  final int b;

  FullTextSearchFilter(int paramInt, String paramString)
  {
    this.b = paramInt;
    this.a = paramString;
  }

  public final Object a(f paramf)
  {
    return paramf.a(this.a);
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    g.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.FullTextSearchFilter
 * JD-Core Version:    0.6.0
 */