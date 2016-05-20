package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.w;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ParticipantResult
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new g();
  private final int a;
  private final String b;
  private final int c;
  private final int d;

  public ParticipantResult(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = ((String)w.a(paramString));
    switch (paramInt2)
    {
    default:
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    for (boolean bool = false; ; bool = true)
    {
      w.b(bool);
      this.c = paramInt2;
      this.d = paramInt3;
      return;
    }
  }

  public final int a()
  {
    return this.a;
  }

  public final String b()
  {
    return this.b;
  }

  public final int c()
  {
    return this.c;
  }

  public final int d()
  {
    return this.d;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    g.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.ParticipantResult
 * JD-Core Version:    0.6.0
 */