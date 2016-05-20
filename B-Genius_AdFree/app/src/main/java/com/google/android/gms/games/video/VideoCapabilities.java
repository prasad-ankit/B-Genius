package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Q;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

public final class VideoCapabilities
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new a();
  private final int a;
  private final boolean b;
  private final boolean c;
  private final boolean d;
  private final boolean[] e;
  private final boolean[] f;

  public VideoCapabilities(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
  {
    this.a = paramInt;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.d = paramBoolean3;
    this.e = paramArrayOfBoolean1;
    this.f = paramArrayOfBoolean2;
  }

  public final int a()
  {
    return this.a;
  }

  public final boolean b()
  {
    return this.c;
  }

  public final boolean c()
  {
    return this.b;
  }

  public final boolean d()
  {
    return this.d;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final boolean[] e()
  {
    return this.e;
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof VideoCapabilities));
    VideoCapabilities localVideoCapabilities;
    do
    {
      return false;
      if (this == paramObject)
        return true;
      localVideoCapabilities = (VideoCapabilities)paramObject;
    }
    while ((!f.a(localVideoCapabilities.e, this.e)) || (!f.a(localVideoCapabilities.f, this.f)) || (!f.a(Boolean.valueOf(localVideoCapabilities.b), Boolean.valueOf(this.b))) || (!f.a(Boolean.valueOf(localVideoCapabilities.c), Boolean.valueOf(this.c))) || (!f.a(Boolean.valueOf(localVideoCapabilities.d), Boolean.valueOf(this.d))));
    return true;
  }

  public final boolean[] f()
  {
    return this.f;
  }

  public final int hashCode()
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = this.e;
    arrayOfObject[1] = this.f;
    arrayOfObject[2] = Boolean.valueOf(this.b);
    arrayOfObject[3] = Boolean.valueOf(this.c);
    arrayOfObject[4] = Boolean.valueOf(this.d);
    return Arrays.hashCode(arrayOfObject);
  }

  public final String toString()
  {
    return f.a(this).a("SupportedCaptureModes", this.e).a("SupportedQualityLevels", this.f).a("CameraSupported", Boolean.valueOf(this.b)).a("MicSupported", Boolean.valueOf(this.c)).a("StorageWriteSupported", Boolean.valueOf(this.d)).toString();
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.video.VideoCapabilities
 * JD-Core Version:    0.6.0
 */