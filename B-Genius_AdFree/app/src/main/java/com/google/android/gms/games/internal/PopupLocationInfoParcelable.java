package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class PopupLocationInfoParcelable
  implements SafeParcelable
{
  public static final t CREATOR = new t();
  private final int a;
  private final Bundle b;
  private final IBinder c;

  PopupLocationInfoParcelable(int paramInt, Bundle paramBundle, IBinder paramIBinder)
  {
    this.a = paramInt;
    this.b = paramBundle;
    this.c = paramIBinder;
  }

  public PopupLocationInfoParcelable(v paramv)
  {
    this.a = 1;
    this.b = paramv.a();
    this.c = paramv.a;
  }

  public final int a()
  {
    return this.a;
  }

  public final Bundle b()
  {
    return this.b;
  }

  public final IBinder c()
  {
    return this.c;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    t.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.PopupLocationInfoParcelable
 * JD-Core Version:    0.6.0
 */