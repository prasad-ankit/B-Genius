package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import java.util.Locale;

public class SortOrder
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new b();
  final List a;
  final boolean b;
  final int c;

  SortOrder(int paramInt, List paramList, boolean paramBoolean)
  {
    this.c = paramInt;
    this.a = paramList;
    this.b = paramBoolean;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = TextUtils.join(",", this.a);
    arrayOfObject[1] = Boolean.valueOf(this.b);
    return String.format(localLocale, "SortOrder[%s, %s]", arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.SortOrder
 * JD-Core Version:    0.6.0
 */