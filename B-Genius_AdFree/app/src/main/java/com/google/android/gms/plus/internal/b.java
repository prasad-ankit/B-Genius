package com.google.android.gms.plus.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.i;
import com.google.android.gms.common.server.response.SafeParcelResponse;
import com.google.android.gms.common.server.response.f;
import com.google.android.gms.plus.internal.model.people.PersonEntity;

public abstract class b extends Binder
  implements a
{
  public static a a(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
    if ((localIInterface != null) && ((localIInterface instanceof a)))
      return (a)localIInterface;
    return new c(paramIBinder);
  }

  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default:
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902:
      paramParcel2.writeString("com.google.android.gms.plus.internal.IPlusCallbacks");
      return true;
    case 1:
      paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
      int i4 = paramParcel1.readInt();
      Bundle localBundle4;
      if (paramParcel1.readInt() != 0)
      {
        localBundle4 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0)
          break label194;
      }
      for (Bundle localBundle5 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle5 = null)
      {
        a(i4, localBundle4, localBundle5);
        paramParcel2.writeNoException();
        return true;
        localBundle4 = null;
        break;
      }
    case 2:
      paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
      int i3 = paramParcel1.readInt();
      Bundle localBundle3;
      if (paramParcel1.readInt() != 0)
      {
        localBundle3 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0)
          break label276;
      }
      for (ParcelFileDescriptor localParcelFileDescriptor = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(paramParcel1); ; localParcelFileDescriptor = null)
      {
        a(i3, localBundle3, localParcelFileDescriptor);
        paramParcel2.writeNoException();
        return true;
        localBundle3 = null;
        break;
      }
    case 3:
      paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
      a(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 4:
      paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
      int i2 = paramParcel1.readInt();
      DataHolder localDataHolder2 = null;
      if (i2 != 0)
        localDataHolder2 = i.a(paramParcel1);
      a(localDataHolder2, paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 5:
      paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
      int n = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0);
      for (Bundle localBundle2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle2 = null)
      {
        int i1 = paramParcel1.readInt();
        SafeParcelResponse localSafeParcelResponse = null;
        if (i1 != 0)
          localSafeParcelResponse = f.a(paramParcel1);
        a(n, localBundle2, localSafeParcelResponse);
        paramParcel2.writeNoException();
        return true;
      }
    case 6:
      paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
      int m = paramParcel1.readInt();
      DataHolder localDataHolder1 = null;
      if (m != 0)
        localDataHolder1 = i.a(paramParcel1);
      a(localDataHolder1, paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 7:
      paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
      int k = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0);
      for (Bundle localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle1 = null)
      {
        a(k, localBundle1);
        paramParcel2.writeNoException();
        return true;
      }
    case 8:
      paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
      b(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 9:
      label194: paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
      label276: int i = paramParcel1.readInt();
      int j = paramParcel1.readInt();
      PersonEntity localPersonEntity = null;
      if (j != 0)
        localPersonEntity = com.google.android.gms.plus.internal.model.people.a.a(paramParcel1);
      a(i, localPersonEntity);
      paramParcel2.writeNoException();
      return true;
    case 10:
    }
    paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
    if (paramParcel1.readInt() != 0);
    for (Status localStatus = (Status)Status.CREATOR.createFromParcel(paramParcel1); ; localStatus = null)
    {
      a(localStatus);
      paramParcel2.writeNoException();
      return true;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.b
 * JD-Core Version:    0.6.0
 */