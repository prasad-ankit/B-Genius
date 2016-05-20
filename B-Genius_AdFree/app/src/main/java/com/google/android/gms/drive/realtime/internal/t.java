package com.google.android.gms.drive.realtime.internal;

import android.os.IBinder;
import android.os.Parcel;

final class t
  implements r
{
  private IBinder a;

  t(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }

  public final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IDocumentSaveStateEventCallback");
      int j;
      if (paramBoolean1)
      {
        j = i;
        localParcel1.writeInt(j);
        if (!paramBoolean2)
          break label81;
      }
      while (true)
      {
        localParcel1.writeInt(i);
        this.a.transact(1, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        j = 0;
        break;
        label81: i = 0;
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
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.t
 * JD-Core Version:    0.6.0
 */