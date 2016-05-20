package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class ComparisonFilter extends AbstractFilter
{
  public static final a CREATOR = new a();
  final Operator a;
  final MetadataBundle b;
  final int c;
  private com.google.android.gms.drive.metadata.a d;

  ComparisonFilter(int paramInt, Operator paramOperator, MetadataBundle paramMetadataBundle)
  {
    this.c = paramInt;
    this.a = paramOperator;
    this.b = paramMetadataBundle;
    this.d = e.a(paramMetadataBundle);
  }

  public final Object a(f paramf)
  {
    return paramf.a(this.a, this.d, this.b.a(this.d));
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.ComparisonFilter
 * JD-Core Version:    0.6.0
 */