package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class g extends Binder
  implements f
{
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default:
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902:
      paramParcel2.writeString("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
      return true;
    case 1:
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
      int j = paramParcel1.readInt();
      ParcelableCollaborator localParcelableCollaborator2 = null;
      if (j != 0)
        localParcelableCollaborator2 = (ParcelableCollaborator)ParcelableCollaborator.CREATOR.createFromParcel(paramParcel1);
      a(localParcelableCollaborator2);
      paramParcel2.writeNoException();
      return true;
    case 2:
    }
    paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
    int i = paramParcel1.readInt();
    ParcelableCollaborator localParcelableCollaborator1 = null;
    if (i != 0)
      localParcelableCollaborator1 = (ParcelableCollaborator)ParcelableCollaborator.CREATOR.createFromParcel(paramParcel1);
    b(localParcelableCollaborator1);
    paramParcel2.writeNoException();
    return true;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.g
 * JD-Core Version:    0.6.0
 */