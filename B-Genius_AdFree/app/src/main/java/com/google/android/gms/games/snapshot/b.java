package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;
import android.support.v4.app.p;
import com.google.android.gms.common.data.BitmapTeleporter;

public final class b
  implements Parcelable.Creator
{
  public static SnapshotMetadataChangeEntity a(Parcel paramParcel)
  {
    Long localLong1 = null;
    int i = j.a(paramParcel);
    int j = 0;
    Uri localUri = null;
    BitmapTeleporter localBitmapTeleporter = null;
    Long localLong2 = null;
    String str = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = paramParcel.readInt();
      switch (0xFFFF & k)
      {
      default:
        j.b(paramParcel, k);
        break;
      case 1:
        str = j.m(paramParcel, k);
        break;
      case 1000:
        j = j.e(paramParcel, k);
        break;
      case 2:
        localLong2 = j.h(paramParcel, k);
        break;
      case 4:
        localUri = (Uri)j.a(paramParcel, k, Uri.CREATOR);
        break;
      case 5:
        localBitmapTeleporter = (BitmapTeleporter)j.a(paramParcel, k, BitmapTeleporter.CREATOR);
        break;
      case 6:
        localLong1 = j.h(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new p("Overread allowed size end=" + i, paramParcel);
    return new SnapshotMetadataChangeEntity(j, str, localLong2, localBitmapTeleporter, localUri, localLong1);
  }

  static void a(SnapshotMetadataChangeEntity paramSnapshotMetadataChangeEntity, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramSnapshotMetadataChangeEntity.b(), false);
    j.a(paramParcel, 1000, paramSnapshotMetadataChangeEntity.a());
    j.a(paramParcel, 2, paramSnapshotMetadataChangeEntity.c(), false);
    j.a(paramParcel, 4, paramSnapshotMetadataChangeEntity.f(), paramInt, false);
    j.a(paramParcel, 5, paramSnapshotMetadataChangeEntity.e(), paramInt, false);
    j.a(paramParcel, 6, paramSnapshotMetadataChangeEntity.d(), false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.snapshot.b
 * JD-Core Version:    0.6.0
 */