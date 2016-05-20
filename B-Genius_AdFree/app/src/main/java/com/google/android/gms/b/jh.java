package com.google.android.gms.b;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;

final class jh
  implements jf
{
  private IBinder a;

  jh(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }

  public final void a(Status paramStatus)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.clearcut.internal.IClearcutLoggerCallbacks");
      if (paramStatus != null)
      {
        localParcel.writeInt(1);
        paramStatus.writeToParcel(localParcel, 0);
      }
      while (true)
      {
        this.a.transact(1, localParcel, null, 1);
        return;
        localParcel.writeInt(0);
      }
    }
    finally
    {
      localParcel.recycle();
    }
    throw localObject;
  }

  public final IBinder asBinder()
  {
    return this.a;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.jh
 * JD-Core Version:    0.6.0
 */