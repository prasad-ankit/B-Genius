package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class g
  implements Parcelable.Creator
{
  static void a(ParticipantResult paramParticipantResult, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramParticipantResult.b(), false);
    j.a(paramParcel, 1000, paramParticipantResult.a());
    j.a(paramParcel, 2, paramParticipantResult.c());
    j.a(paramParcel, 3, paramParticipantResult.d());
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.g
 * JD-Core Version:    0.6.0
 */