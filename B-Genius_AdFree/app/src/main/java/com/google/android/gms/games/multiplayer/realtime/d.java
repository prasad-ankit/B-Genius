package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;
import android.support.v4.app.p;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

public class d
  implements Parcelable.Creator
{
  static void a(RoomEntity paramRoomEntity, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramRoomEntity.a(), false);
    j.a(paramParcel, 1000, paramRoomEntity.j());
    j.a(paramParcel, 2, paramRoomEntity.b(), false);
    j.a(paramParcel, 3, paramRoomEntity.d());
    j.a(paramParcel, 4, paramRoomEntity.e());
    j.a(paramParcel, 5, paramRoomEntity.f(), false);
    j.a(paramParcel, 6, paramRoomEntity.g());
    j.a(paramParcel, 7, paramRoomEntity.h(), false);
    j.b(paramParcel, 8, paramRoomEntity.k(), false);
    j.a(paramParcel, 9, paramRoomEntity.i());
    j.x(paramParcel, i);
  }

  public RoomEntity a(Parcel paramParcel)
  {
    int i = 0;
    ArrayList localArrayList = null;
    int j = j.a(paramParcel);
    long l = 0L;
    Bundle localBundle = null;
    int k = 0;
    String str1 = null;
    int m = 0;
    String str2 = null;
    String str3 = null;
    int n = 0;
    while (paramParcel.dataPosition() < j)
    {
      int i1 = paramParcel.readInt();
      switch (0xFFFF & i1)
      {
      default:
        j.b(paramParcel, i1);
        break;
      case 1:
        str3 = j.m(paramParcel, i1);
        break;
      case 1000:
        n = j.e(paramParcel, i1);
        break;
      case 2:
        str2 = j.m(paramParcel, i1);
        break;
      case 3:
        l = j.g(paramParcel, i1);
        break;
      case 4:
        m = j.e(paramParcel, i1);
        break;
      case 5:
        str1 = j.m(paramParcel, i1);
        break;
      case 6:
        k = j.e(paramParcel, i1);
        break;
      case 7:
        localBundle = j.o(paramParcel, i1);
        break;
      case 8:
        localArrayList = j.c(paramParcel, i1, ParticipantEntity.CREATOR);
        break;
      case 9:
        i = j.e(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new p("Overread allowed size end=" + j, paramParcel);
    return new RoomEntity(n, str3, str2, l, m, str1, k, localBundle, localArrayList, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.realtime.d
 * JD-Core Version:    0.6.0
 */