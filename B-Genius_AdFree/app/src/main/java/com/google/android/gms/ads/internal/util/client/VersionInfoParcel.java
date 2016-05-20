package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class VersionInfoParcel
  implements SafeParcelable
{
  public static final b CREATOR = new b();
  public final int a;
  public String b;
  public int c;
  public int d;
  public boolean e;

  public VersionInfoParcel(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this(1, "afma-sdk-a-v" + 8487000 + ".8487000" + ".0", 8487000, 8487000, true);
  }

  VersionInfoParcel(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.a = paramInt1;
    this.b = paramString;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramBoolean;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.util.client.VersionInfoParcel
 * JD-Core Version:    0.6.0
 */