package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.w;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class VideoConfiguration
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new b();
  private final int a;
  private final int b;
  private final int c;
  private final String d;
  private final String e;

  public VideoConfiguration(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    this.a = paramInt1;
    switch (paramInt2)
    {
    default:
      boolean bool1 = false;
      w.c(bool1);
      switch (paramInt3)
      {
      default:
      case 0:
      case 1:
      }
    case 0:
    case 1:
    case 2:
    case 3:
    }
    int k;
    for (boolean bool2 = false; ; k = i)
    {
      w.c(bool2);
      this.b = paramInt2;
      this.c = paramInt3;
      if (paramInt3 != i)
        break label127;
      this.e = paramString2;
      this.d = paramString1;
      return;
      int j = i;
      break;
    }
    label127: if (paramString2 == null)
    {
      int m = i;
      w.b(m, "Stream key should be null when not streaming");
      if (paramString1 != null)
        break label172;
    }
    while (true)
    {
      w.b(i, "Stream url should be null when not streaming");
      this.e = null;
      this.d = null;
      return;
      int n = 0;
      break;
      label172: i = 0;
    }
  }

  public final int a()
  {
    return this.a;
  }

  public final int b()
  {
    return this.b;
  }

  public final int c()
  {
    return this.c;
  }

  public final String d()
  {
    return this.e;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final String e()
  {
    return this.d;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.video.VideoConfiguration
 * JD-Core Version:    0.6.0
 */