package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.w;

public abstract class WriteAwareParcelable
  implements Parcelable
{
  private volatile transient boolean a = false;

  protected abstract void a(Parcel paramParcel, int paramInt);

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (!this.a);
    for (boolean bool = true; ; bool = false)
    {
      w.b(bool);
      this.a = true;
      a(paramParcel, paramInt);
      return;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.WriteAwareParcelable
 * JD-Core Version:    0.6.0
 */