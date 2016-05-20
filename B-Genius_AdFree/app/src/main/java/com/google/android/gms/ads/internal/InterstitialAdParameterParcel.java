package com.google.android.gms.ads.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class InterstitialAdParameterParcel
  implements SafeParcelable
{
  public static final z CREATOR = new z();
  public final int a;
  public final boolean b;
  public final boolean c;
  public final String d;
  public final boolean e;
  public final float f;

  InterstitialAdParameterParcel(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3, float paramFloat)
  {
    this.a = paramInt;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.d = paramString;
    this.e = paramBoolean3;
    this.f = paramFloat;
  }

  public InterstitialAdParameterParcel(boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3, float paramFloat)
  {
    this(2, paramBoolean1, paramBoolean2, paramString, paramBoolean3, paramFloat);
  }

  public final int describeContents()
  {
    return 0;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    z.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.InterstitialAdParameterParcel
 * JD-Core Version:    0.6.0
 */