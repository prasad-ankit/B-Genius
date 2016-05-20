package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;

public class FilterHolder
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new d();
  final int a;
  final ComparisonFilter b;
  final FieldOnlyFilter c;
  final LogicalFilter d;
  final NotFilter e;
  final InFilter f;
  final MatchAllFilter g;
  final HasFilter h;
  final FullTextSearchFilter i;
  final OwnedByMeFilter j;
  private final Filter k;

  FilterHolder(int paramInt, ComparisonFilter paramComparisonFilter, FieldOnlyFilter paramFieldOnlyFilter, LogicalFilter paramLogicalFilter, NotFilter paramNotFilter, InFilter paramInFilter, MatchAllFilter paramMatchAllFilter, HasFilter paramHasFilter, FullTextSearchFilter paramFullTextSearchFilter, OwnedByMeFilter paramOwnedByMeFilter)
  {
    this.a = paramInt;
    this.b = paramComparisonFilter;
    this.c = paramFieldOnlyFilter;
    this.d = paramLogicalFilter;
    this.e = paramNotFilter;
    this.f = paramInFilter;
    this.g = paramMatchAllFilter;
    this.h = paramHasFilter;
    this.i = paramFullTextSearchFilter;
    this.j = paramOwnedByMeFilter;
    if (this.b != null)
    {
      this.k = this.b;
      return;
    }
    if (this.c != null)
    {
      this.k = this.c;
      return;
    }
    if (this.d != null)
    {
      this.k = this.d;
      return;
    }
    if (this.e != null)
    {
      this.k = this.e;
      return;
    }
    if (this.f != null)
    {
      this.k = this.f;
      return;
    }
    if (this.g != null)
    {
      this.k = this.g;
      return;
    }
    if (this.h != null)
    {
      this.k = this.h;
      return;
    }
    if (this.i != null)
    {
      this.k = this.i;
      return;
    }
    if (this.j != null)
    {
      this.k = this.j;
      return;
    }
    throw new IllegalArgumentException("At least one filter must be set.");
  }

  public final Filter a()
  {
    return this.k;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.k;
    return String.format("FilterHolder[%s]", arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    d.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.FilterHolder
 * JD-Core Version:    0.6.0
 */