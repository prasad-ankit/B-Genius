package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;

final class n extends o
{
  public final PlayerEntity a(Parcel paramParcel)
  {
    if ((PlayerEntity.a(PlayerEntity.s())) || (PlayerEntity.b(PlayerEntity.class.getCanonicalName())))
      return super.a(paramParcel);
    String str1 = paramParcel.readString();
    String str2 = paramParcel.readString();
    String str3 = paramParcel.readString();
    String str4 = paramParcel.readString();
    Uri localUri1;
    if (str3 == null)
    {
      localUri1 = null;
      if (str4 != null)
        break label117;
    }
    label117: for (Uri localUri2 = null; ; localUri2 = Uri.parse(str4))
    {
      return new PlayerEntity(13, str1, str2, localUri1, localUri2, paramParcel.readLong(), -1, -1L, null, null, null, null, null, true, false, paramParcel.readString(), paramParcel.readString(), null, null, null, null);
      localUri1 = Uri.parse(str3);
      break;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.n
 * JD-Core Version:    0.6.0
 */