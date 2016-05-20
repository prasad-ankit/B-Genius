package com.google.android.gms.drive.realtime.internal;

import android.os.IBinder;
import android.os.Parcel;

final class h
  implements f
{
  private IBinder a;

  h(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }

  public final void a(ParcelableCollaborator paramParcelableCollaborator)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
      if (paramParcelableCollaborator != null)
      {
        localParcel1.writeInt(1);
        paramParcelableCollaborator.writeToParcel(localParcel1, 0);
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

  public final void b(ParcelableCollaborator paramParcelableCollaborator)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
      if (paramParcelableCollaborator != null)
      {
        localParcel1.writeInt(1);
        paramParcelableCollaborator.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(2, localParcel1, localParcel2, 0);
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
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.h
 * JD-Core Version:    0.6.0
 */