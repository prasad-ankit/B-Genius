package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.support.v4.app.w;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class SnapshotMetadataChangeEntity extends a
  implements SafeParcelable
{
  public static final b CREATOR = new b();
  private final int a;
  private final String b;
  private final Long c;
  private final Uri d;
  private BitmapTeleporter e;
  private final Long f;

  SnapshotMetadataChangeEntity()
  {
    this(5, null, null, null, null, null);
  }

  SnapshotMetadataChangeEntity(int paramInt, String paramString, Long paramLong1, BitmapTeleporter paramBitmapTeleporter, Uri paramUri, Long paramLong2)
  {
    this.a = paramInt;
    this.b = paramString;
    this.c = paramLong1;
    this.e = paramBitmapTeleporter;
    this.d = paramUri;
    this.f = paramLong2;
    if (this.e != null)
      if (this.d == null)
        w.a(bool, "Cannot set both a URI and an image");
    do
    {
      return;
      bool = false;
      break;
    }
    while (this.d == null);
    if (this.e == null);
    while (true)
    {
      w.a(bool, "Cannot set both a URI and an image");
      return;
      bool = false;
    }
  }

  public final int a()
  {
    return this.a;
  }

  public final String b()
  {
    return this.b;
  }

  public final Long c()
  {
    return this.c;
  }

  public final Long d()
  {
    return this.f;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final BitmapTeleporter e()
  {
    return this.e;
  }

  public final Uri f()
  {
    return this.d;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity
 * JD-Core Version:    0.6.0
 */