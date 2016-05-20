package com.google.android.gms.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.clearcut.g;

public abstract class jj extends Binder
  implements ji
{
  public static ji a(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
    if ((localIInterface != null) && ((localIInterface instanceof ji)))
      return (ji)localIInterface;
    return new jk(paramIBinder);
  }

  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default:
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902:
      paramParcel2.writeString("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
      return true;
    case 1:
    }
    paramParcel1.enforceInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
    IBinder localIBinder = paramParcel1.readStrongBinder();
    Object localObject;
    if (localIBinder == null)
      localObject = null;
    while (true)
    {
      int i = paramParcel1.readInt();
      LogEventParcelable localLogEventParcelable = null;
      if (i != 0)
        localLogEventParcelable = g.a(paramParcel1);
      a((jf)localObject, localLogEventParcelable);
      return true;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerCallbacks");
      if ((localIInterface != null) && ((localIInterface instanceof jf)))
      {
        localObject = (jf)localIInterface;
        continue;
      }
      localObject = new jh(localIBinder);
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.jj
 * JD-Core Version:    0.6.0
 */