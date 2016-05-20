package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.Filter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LogicalFilter extends AbstractFilter
{
  public static final Parcelable.Creator CREATOR = new j();
  final Operator a;
  final List b;
  final int c;

  LogicalFilter(int paramInt, Operator paramOperator, List paramList)
  {
    this.c = paramInt;
    this.a = paramOperator;
    this.b = paramList;
  }

  public final Object a(f paramf)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      localArrayList.add(((FilterHolder)localIterator.next()).a().a(paramf));
    return paramf.a(this.a, localArrayList);
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    j.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.LogicalFilter
 * JD-Core Version:    0.6.0
 */