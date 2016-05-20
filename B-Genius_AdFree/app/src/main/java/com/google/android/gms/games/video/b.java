package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class b
  implements Parcelable.Creator
{
  static void a(VideoConfiguration paramVideoConfiguration, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramVideoConfiguration.b());
    j.a(paramParcel, 1000, paramVideoConfiguration.a());
    j.a(paramParcel, 2, paramVideoConfiguration.c());
    j.a(paramParcel, 3, paramVideoConfiguration.e(), false);
    j.a(paramParcel, 4, paramVideoConfiguration.d(), false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.video.b
 * JD-Core Version:    0.6.0
 */