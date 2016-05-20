package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.a;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class HasFilter extends AbstractFilter
{
  public static final h CREATOR = new h();
  final MetadataBundle a;
  final int b;
  private a c;

  HasFilter(int paramInt, MetadataBundle paramMetadataBundle)
  {
    this.b = paramInt;
    this.a = paramMetadataBundle;
    this.c = e.a(paramMetadataBundle);
  }

  public final Object a(f paramf)
  {
    return paramf.a(this.c, this.a.a(this.c));
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    h.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.HasFilter
 * JD-Core Version:    0.6.0
 */