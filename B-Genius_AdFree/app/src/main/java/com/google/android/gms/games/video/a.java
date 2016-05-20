package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class a
  implements Parcelable.Creator
{
  static void a(VideoCapabilities paramVideoCapabilities, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramVideoCapabilities.c());
    j.a(paramParcel, 1000, paramVideoCapabilities.a());
    j.a(paramParcel, 2, paramVideoCapabilities.b());
    j.a(paramParcel, 3, paramVideoCapabilities.d());
    j.a(paramParcel, 4, paramVideoCapabilities.e(), false);
    j.a(paramParcel, 5, paramVideoCapabilities.f(), false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.video.a
 * JD-Core Version:    0.6.0
 */