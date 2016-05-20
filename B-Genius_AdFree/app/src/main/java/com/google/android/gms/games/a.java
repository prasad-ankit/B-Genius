package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;

final class a extends b
{
  public final GameEntity a(Parcel paramParcel)
  {
    if ((GameEntity.a(GameEntity.y())) || (GameEntity.b(GameEntity.class.getCanonicalName())))
      return super.a(paramParcel);
    String str1 = paramParcel.readString();
    String str2 = paramParcel.readString();
    String str3 = paramParcel.readString();
    String str4 = paramParcel.readString();
    String str5 = paramParcel.readString();
    String str6 = paramParcel.readString();
    String str7 = paramParcel.readString();
    Uri localUri1;
    String str8;
    Uri localUri2;
    label88: String str9;
    Uri localUri3;
    label102: boolean bool1;
    if (str7 == null)
    {
      localUri1 = null;
      str8 = paramParcel.readString();
      if (str8 != null)
        break label188;
      localUri2 = null;
      str9 = paramParcel.readString();
      if (str9 != null)
        break label198;
      localUri3 = null;
      if (paramParcel.readInt() <= 0)
        break label208;
      bool1 = true;
      label112: if (paramParcel.readInt() <= 0)
        break label214;
    }
    label188: label198: label208: label214: for (boolean bool2 = true; ; bool2 = false)
    {
      return new GameEntity(7, str1, str2, str3, str4, str5, str6, localUri1, localUri2, localUri3, bool1, bool2, paramParcel.readString(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), false, false, null, null, null, false, false, false, null, false);
      localUri1 = Uri.parse(str7);
      break;
      localUri2 = Uri.parse(str8);
      break label88;
      localUri3 = Uri.parse(str9);
      break label102;
      bool1 = false;
      break label112;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.a
 * JD-Core Version:    0.6.0
 */