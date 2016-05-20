package com.google.android.gms.ads.internal.request;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

public abstract class z extends Binder
  implements y
{
  public z()
  {
    attachInterface(this, "com.google.android.gms.ads.internal.request.IAdResponseListener");
  }

  public IBinder asBinder()
  {
    return this;
  }

  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default:
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902:
      paramParcel2.writeString("com.google.android.gms.ads.internal.request.IAdResponseListener");
      return true;
    case 1:
    }
    paramParcel1.enforceInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
    if (paramParcel1.readInt() != 0);
    for (AdResponseParcel localAdResponseParcel = t.a(paramParcel1); ; localAdResponseParcel = null)
    {
      a(localAdResponseParcel);
      paramParcel2.writeNoException();
      return true;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.request.z
 * JD-Core Version:    0.6.0
 */