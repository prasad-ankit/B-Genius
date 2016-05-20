package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangesAvailableOptions;
import com.google.android.gms.drive.events.TransferProgressOptions;
import com.google.android.gms.drive.events.TransferStateOptions;

public class AddEventListenerRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new a();
  final int a;
  final DriveId b;
  final int c;
  final ChangesAvailableOptions d;
  final TransferStateOptions e;
  final TransferProgressOptions f;

  AddEventListenerRequest(int paramInt1, DriveId paramDriveId, int paramInt2, ChangesAvailableOptions paramChangesAvailableOptions, TransferStateOptions paramTransferStateOptions, TransferProgressOptions paramTransferProgressOptions)
  {
    this.a = paramInt1;
    this.b = paramDriveId;
    this.c = paramInt2;
    this.d = paramChangesAvailableOptions;
    this.e = paramTransferStateOptions;
    this.f = paramTransferProgressOptions;
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
 * Qualified Name:     com.google.android.gms.drive.internal.AddEventListenerRequest
 * JD-Core Version:    0.6.0
 */