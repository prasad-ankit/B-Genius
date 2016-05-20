package com.google.android.gms.drive.events.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.Arrays;

public class TransferProgressData
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new a();
  final int a;
  final int b;
  final DriveId c;
  final int d;
  final long e;
  final long f;

  TransferProgressData(int paramInt1, int paramInt2, DriveId paramDriveId, int paramInt3, long paramLong1, long paramLong2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramDriveId;
    this.d = paramInt3;
    this.e = paramLong1;
    this.f = paramLong2;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if ((paramObject == null) || (paramObject.getClass() != getClass()))
      i = 0;
    TransferProgressData localTransferProgressData;
    do
    {
      do
        return i;
      while (paramObject == this);
      localTransferProgressData = (TransferProgressData)paramObject;
    }
    while ((this.b == localTransferProgressData.b) && (f.a(this.c, localTransferProgressData.c)) && (this.d == localTransferProgressData.d) && (this.e == localTransferProgressData.e) && (this.f == localTransferProgressData.f));
    return false;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = Integer.valueOf(this.b);
    arrayOfObject[1] = this.c;
    arrayOfObject[2] = Integer.valueOf(this.d);
    arrayOfObject[3] = Long.valueOf(this.e);
    arrayOfObject[4] = Long.valueOf(this.f);
    return Arrays.hashCode(arrayOfObject);
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = Integer.valueOf(this.b);
    arrayOfObject[1] = this.c;
    arrayOfObject[2] = Integer.valueOf(this.d);
    arrayOfObject[3] = Long.valueOf(this.e);
    arrayOfObject[4] = Long.valueOf(this.f);
    return String.format("TransferProgressData[TransferType: %d, DriveId: %s, status: %d, bytes transferred: %d, total bytes: %d]", arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.events.internal.TransferProgressData
 * JD-Core Version:    0.6.0
 */