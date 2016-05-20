package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.PlayerEntity;

final class e extends f
{
  public final ParticipantEntity a(Parcel paramParcel)
  {
    boolean bool1 = true;
    if ((ParticipantEntity.a(ParticipantEntity.m())) || (ParticipantEntity.b(ParticipantEntity.class.getCanonicalName())))
      return super.a(paramParcel);
    String str1 = paramParcel.readString();
    String str2 = paramParcel.readString();
    String str3 = paramParcel.readString();
    Uri localUri1;
    String str4;
    Uri localUri2;
    label67: int i;
    String str5;
    boolean bool2;
    if (str3 == null)
    {
      localUri1 = null;
      str4 = paramParcel.readString();
      if (str4 != null)
        break label153;
      localUri2 = null;
      i = paramParcel.readInt();
      str5 = paramParcel.readString();
      if (paramParcel.readInt() <= 0)
        break label163;
      bool2 = bool1;
      label89: if (paramParcel.readInt() <= 0)
        break label169;
      label96: if (!bool1)
        break label174;
    }
    label153: label163: label169: label174: for (PlayerEntity localPlayerEntity = (PlayerEntity)PlayerEntity.CREATOR.createFromParcel(paramParcel); ; localPlayerEntity = null)
    {
      return new ParticipantEntity(3, str1, str2, localUri1, localUri2, i, str5, bool2, localPlayerEntity, 7, null, null, null);
      localUri1 = Uri.parse(str3);
      break;
      localUri2 = Uri.parse(str4);
      break label67;
      bool2 = false;
      break label89;
      bool1 = false;
      break label96;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.e
 * JD-Core Version:    0.6.0
 */