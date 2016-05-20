package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;
import android.support.v4.app.p;

public final class d
  implements Parcelable.Creator
{
  public static RewardItemParcel a(Parcel paramParcel)
  {
    int i = 0;
    int j = j.a(paramParcel);
    String str = null;
    int k = 0;
    while (paramParcel.dataPosition() < j)
    {
      int m = paramParcel.readInt();
      switch (0xFFFF & m)
      {
      default:
        j.b(paramParcel, m);
        break;
      case 1:
        k = j.e(paramParcel, m);
        break;
      case 2:
        str = j.m(paramParcel, m);
        break;
      case 3:
        i = j.e(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new p("Overread allowed size end=" + j, paramParcel);
    return new RewardItemParcel(k, str, i);
  }

  static void a(RewardItemParcel paramRewardItemParcel, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramRewardItemParcel.a);
    j.a(paramParcel, 2, paramRewardItemParcel.b, false);
    j.a(paramParcel, 3, paramRewardItemParcel.c);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.reward.mediation.client.d
 * JD-Core Version:    0.6.0
 */