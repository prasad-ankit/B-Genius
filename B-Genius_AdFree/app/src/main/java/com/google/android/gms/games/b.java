package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;
import android.support.v4.app.p;

public class b
  implements Parcelable.Creator
{
  static void a(GameEntity paramGameEntity, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramGameEntity.a(), false);
    j.a(paramParcel, 2, paramGameEntity.b(), false);
    j.a(paramParcel, 3, paramGameEntity.d(), false);
    j.a(paramParcel, 4, paramGameEntity.e(), false);
    j.a(paramParcel, 5, paramGameEntity.f(), false);
    j.a(paramParcel, 6, paramGameEntity.g(), false);
    j.a(paramParcel, 7, paramGameEntity.h(), paramInt, false);
    j.a(paramParcel, 8, paramGameEntity.i(), paramInt, false);
    j.a(paramParcel, 9, paramGameEntity.j(), paramInt, false);
    j.a(paramParcel, 10, paramGameEntity.k());
    j.a(paramParcel, 11, paramGameEntity.n());
    j.a(paramParcel, 12, paramGameEntity.o(), false);
    j.a(paramParcel, 13, paramGameEntity.p());
    j.a(paramParcel, 14, paramGameEntity.q());
    j.a(paramParcel, 15, paramGameEntity.r());
    j.a(paramParcel, 17, paramGameEntity.t());
    j.a(paramParcel, 16, paramGameEntity.s());
    j.a(paramParcel, 1000, paramGameEntity.x());
    j.a(paramParcel, 19, paramGameEntity.getHiResImageUrl(), false);
    j.a(paramParcel, 18, paramGameEntity.getIconImageUrl(), false);
    j.a(paramParcel, 21, paramGameEntity.l());
    j.a(paramParcel, 20, paramGameEntity.getFeaturedImageUrl(), false);
    j.a(paramParcel, 23, paramGameEntity.u());
    j.a(paramParcel, 22, paramGameEntity.m());
    j.a(paramParcel, 25, paramGameEntity.w());
    j.a(paramParcel, 24, paramGameEntity.v(), false);
    j.x(paramParcel, i);
  }

  public GameEntity a(Parcel paramParcel)
  {
    int i = j.a(paramParcel);
    int j = 0;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    String str6 = null;
    Uri localUri1 = null;
    Uri localUri2 = null;
    Uri localUri3 = null;
    boolean bool1 = false;
    boolean bool2 = false;
    String str7 = null;
    int k = 0;
    int m = 0;
    int n = 0;
    boolean bool3 = false;
    boolean bool4 = false;
    String str8 = null;
    String str9 = null;
    String str10 = null;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool7 = false;
    String str11 = null;
    boolean bool8 = false;
    while (paramParcel.dataPosition() < i)
    {
      int i1 = paramParcel.readInt();
      switch (0xFFFF & i1)
      {
      default:
        j.b(paramParcel, i1);
        break;
      case 1:
        str1 = j.m(paramParcel, i1);
        break;
      case 2:
        str2 = j.m(paramParcel, i1);
        break;
      case 3:
        str3 = j.m(paramParcel, i1);
        break;
      case 4:
        str4 = j.m(paramParcel, i1);
        break;
      case 5:
        str5 = j.m(paramParcel, i1);
        break;
      case 6:
        str6 = j.m(paramParcel, i1);
        break;
      case 7:
        localUri1 = (Uri)j.a(paramParcel, i1, Uri.CREATOR);
        break;
      case 8:
        localUri2 = (Uri)j.a(paramParcel, i1, Uri.CREATOR);
        break;
      case 9:
        localUri3 = (Uri)j.a(paramParcel, i1, Uri.CREATOR);
        break;
      case 10:
        bool1 = j.c(paramParcel, i1);
        break;
      case 11:
        bool2 = j.c(paramParcel, i1);
        break;
      case 12:
        str7 = j.m(paramParcel, i1);
        break;
      case 13:
        k = j.e(paramParcel, i1);
        break;
      case 14:
        m = j.e(paramParcel, i1);
        break;
      case 15:
        n = j.e(paramParcel, i1);
        break;
      case 17:
        bool4 = j.c(paramParcel, i1);
        break;
      case 16:
        bool3 = j.c(paramParcel, i1);
        break;
      case 1000:
        j = j.e(paramParcel, i1);
        break;
      case 19:
        str9 = j.m(paramParcel, i1);
        break;
      case 18:
        str8 = j.m(paramParcel, i1);
        break;
      case 21:
        bool5 = j.c(paramParcel, i1);
        break;
      case 20:
        str10 = j.m(paramParcel, i1);
        break;
      case 23:
        bool7 = j.c(paramParcel, i1);
        break;
      case 22:
        bool6 = j.c(paramParcel, i1);
        break;
      case 25:
        bool8 = j.c(paramParcel, i1);
        break;
      case 24:
        str11 = j.m(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new p("Overread allowed size end=" + i, paramParcel);
    return new GameEntity(j, str1, str2, str3, str4, str5, str6, localUri1, localUri2, localUri3, bool1, bool2, str7, k, m, n, bool3, bool4, str8, str9, str10, bool5, bool6, bool7, str11, bool8);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.b
 * JD-Core Version:    0.6.0
 */