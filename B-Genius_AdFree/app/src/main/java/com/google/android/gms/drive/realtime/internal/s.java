package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.Parcel;

public abstract class s extends Binder
  implements r
{
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default:
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902:
      paramParcel2.writeString("com.google.android.gms.drive.realtime.internal.IDocumentSaveStateEventCallback");
      return true;
    case 1:
    }
    paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IDocumentSaveStateEventCallback");
    if (paramParcel1.readInt() != 0);
    for (boolean bool1 = true; ; bool1 = false)
    {
      int i = paramParcel1.readInt();
      boolean bool2 = false;
      if (i != 0)
        bool2 = true;
      a(bool1, bool2);
      paramParcel2.writeNoException();
      return true;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.s
 * JD-Core Version:    0.6.0
 */