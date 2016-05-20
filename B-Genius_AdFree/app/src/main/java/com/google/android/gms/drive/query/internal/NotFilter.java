package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.Filter;

public class NotFilter extends AbstractFilter
{
  public static final Parcelable.Creator CREATOR = new l();
  final FilterHolder a;
  final int b;

  NotFilter(int paramInt, FilterHolder paramFilterHolder)
  {
    this.b = paramInt;
    this.a = paramFilterHolder;
  }

  public final Object a(f paramf)
  {
    return paramf.a(this.a.a().a(paramf));
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    l.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.NotFilter
 * JD-Core Version:    0.6.0
 */