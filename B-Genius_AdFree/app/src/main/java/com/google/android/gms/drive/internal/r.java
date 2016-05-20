package com.google.android.gms.drive.internal;

import android.os.IBinder;
import android.os.Parcel;

final class r
  implements p
{
  private IBinder a;

  r(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }

  public final void a(OnEventResponse paramOnEventResponse)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IEventCallback");
      if (paramOnEventResponse != null)
      {
        localParcel1.writeInt(1);
        paramOnEventResponse.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(1, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final IBinder asBinder()
  {
    return this.a;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.r
 * JD-Core Version:    0.6.0
 */