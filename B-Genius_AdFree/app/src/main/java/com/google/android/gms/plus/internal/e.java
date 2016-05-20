package com.google.android.gms.plus.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.D;
import com.google.android.gms.common.server.FavaDiagnosticsEntity;
import com.google.android.gms.common.server.response.SafeParcelResponse;

public abstract class e extends Binder
  implements d
{
  public static d a(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusService");
    if ((localIInterface != null) && ((localIInterface instanceof d)))
      return (d)localIInterface;
    return new f(paramIBinder);
  }

  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default:
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902:
      paramParcel2.writeString("com.google.android.gms.plus.internal.IPlusService");
      return true;
    case 1:
      paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
      a(b.a(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 2:
      paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
      a(b.a(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 3:
      paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
      b(b.a(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 4:
      paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
      if (paramParcel1.readInt() != 0);
      for (SafeParcelResponse localSafeParcelResponse2 = com.google.android.gms.common.server.response.f.a(paramParcel1); ; localSafeParcelResponse2 = null)
      {
        a(localSafeParcelResponse2);
        paramParcel2.writeNoException();
        return true;
      }
    case 5:
      paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
      String str5 = a();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str5);
      return true;
    case 6:
      paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
      b();
      paramParcel2.writeNoException();
      return true;
    case 8:
      paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
      a(b.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 9:
      paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
      a locala3 = b.a(paramParcel1.readStrongBinder());
      Uri localUri2;
      if (paramParcel1.readInt() != 0)
      {
        localUri2 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0)
          break label474;
      }
      for (Bundle localBundle = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle = null)
      {
        a(locala3, localUri2, localBundle);
        paramParcel2.writeNoException();
        return true;
        localUri2 = null;
        break;
      }
    case 14:
      paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
      a locala2 = b.a(paramParcel1.readStrongBinder());
      int m = paramParcel1.readInt();
      String str4 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0);
      for (Uri localUri1 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1); ; localUri1 = null)
      {
        a(locala2, m, str4, localUri1, paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      }
    case 16:
      paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
      D localD = a(b.a(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      IBinder localIBinder = null;
      if (localD != null)
        localIBinder = localD.asBinder();
      paramParcel2.writeStrongBinder(localIBinder);
      return true;
    case 17:
      paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
      a(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 18:
      paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
      c(b.a(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 19:
      paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
      b(b.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 34:
      paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
      a(b.a(paramParcel1.readStrongBinder()), paramParcel1.createStringArrayList());
      paramParcel2.writeNoException();
      return true;
    case 40:
      paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
      d(b.a(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 41:
      paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
      String str3 = c();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str3);
      return true;
    case 42:
      paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
      boolean bool = d();
      paramParcel2.writeNoException();
      if (bool);
      for (int k = 1; ; k = 0)
      {
        paramParcel2.writeInt(k);
        return true;
      }
    case 43:
      paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
      String str2 = e();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str2);
      return true;
    case 44:
      paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
      e(b.a(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 45:
      label474: paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
      a locala1 = b.a(paramParcel1.readStrongBinder());
      int j = paramParcel1.readInt();
      SafeParcelResponse localSafeParcelResponse1 = null;
      if (j != 0)
        localSafeParcelResponse1 = com.google.android.gms.common.server.response.f.a(paramParcel1);
      a(locala1, localSafeParcelResponse1);
      paramParcel2.writeNoException();
      return true;
    case 46:
    }
    paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
    String str1 = paramParcel1.readString();
    if (paramParcel1.readInt() != 0);
    for (FavaDiagnosticsEntity localFavaDiagnosticsEntity1 = com.google.android.gms.common.server.a.a(paramParcel1); ; localFavaDiagnosticsEntity1 = null)
    {
      int i = paramParcel1.readInt();
      FavaDiagnosticsEntity localFavaDiagnosticsEntity2 = null;
      if (i != 0)
        localFavaDiagnosticsEntity2 = com.google.android.gms.common.server.a.a(paramParcel1);
      a(str1, localFavaDiagnosticsEntity1, localFavaDiagnosticsEntity2);
      paramParcel2.writeNoException();
      return true;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.e
 * JD-Core Version:    0.6.0
 */