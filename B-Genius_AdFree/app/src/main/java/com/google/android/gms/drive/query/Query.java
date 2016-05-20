package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Query
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new a();
  final LogicalFilter a;
  final String b;
  final SortOrder c;
  final List d;
  final boolean e;
  final List f;
  final boolean g;
  final int h;

  private Query(int paramInt, LogicalFilter paramLogicalFilter, String paramString, SortOrder paramSortOrder, List paramList1, boolean paramBoolean1, List paramList2, Set paramSet, boolean paramBoolean2)
  {
    this.h = paramInt;
    this.a = paramLogicalFilter;
    this.b = paramString;
    this.c = paramSortOrder;
    this.d = paramList1;
    this.e = paramBoolean1;
    this.f = paramList2;
    this.g = paramBoolean2;
  }

  Query(int paramInt, LogicalFilter paramLogicalFilter, String paramString, SortOrder paramSortOrder, List paramList1, boolean paramBoolean1, List paramList2, boolean paramBoolean2)
  {
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = this.a;
    arrayOfObject[1] = this.c;
    arrayOfObject[2] = this.b;
    arrayOfObject[3] = this.f;
    return String.format(localLocale, "Query[%s,%s,PageToken=%s,Spaces=%s]", arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.Query
 * JD-Core Version:    0.6.0
 */