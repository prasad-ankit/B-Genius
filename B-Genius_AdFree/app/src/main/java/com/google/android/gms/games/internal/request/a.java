package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;
import android.support.v4.app.p;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;

public final class a
  implements Parcelable.Creator
{
  public static GameRequestCluster a(Parcel paramParcel)
  {
    int i = j.a(paramParcel);
    int j = 0;
    ArrayList localArrayList = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = paramParcel.readInt();
      switch (0xFFFF & k)
      {
      default:
        j.b(paramParcel, k);
        break;
      case 1:
        localArrayList = j.c(paramParcel, k, GameRequestEntity.CREATOR);
        break;
      case 1000:
        j = j.e(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new p("Overread allowed size end=" + i, paramParcel);
    return new GameRequestCluster(j, localArrayList);
  }

  static void a(GameRequestCluster paramGameRequestCluster, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    j.b(paramParcel, 1, paramGameRequestCluster.b(), false);
    j.a(paramParcel, 1000, paramGameRequestCluster.a());
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.request.a
 * JD-Core Version:    0.6.0
 */