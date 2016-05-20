package com.google.android.gms.drive.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnStartStreamSession
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new K();
  final int a;
  final ParcelFileDescriptor b;
  final IBinder c;
  final String d;

  OnStartStreamSession(int paramInt, ParcelFileDescriptor paramParcelFileDescriptor, IBinder paramIBinder, String paramString)
  {
    this.a = paramInt;
    this.b = paramParcelFileDescriptor;
    this.c = paramIBinder;
    this.d = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    K.a(this, paramParcel, paramInt | 0x1);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.OnStartStreamSession
 * JD-Core Version:    0.6.0
 */