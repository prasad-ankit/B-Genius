package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.d;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Collection;
import java.util.Iterator;

public class InFilter extends AbstractFilter
{
  public static final i CREATOR = new i();
  final MetadataBundle a;
  final int b;
  private final d c;

  InFilter(int paramInt, MetadataBundle paramMetadataBundle)
  {
    this.b = paramInt;
    this.a = paramMetadataBundle;
    this.c = ((d)e.a(paramMetadataBundle));
  }

  public final Object a(f paramf)
  {
    return paramf.a(this.c, ((Collection)this.a.a(this.c)).iterator().next());
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    i.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.InFilter
 * JD-Core Version:    0.6.0
 */