package com.google.android.gms.games.multiplayer.realtime;

import B;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.w;

public final class RealTimeMessage
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new a();
  private final String a;
  private final byte[] b;
  private final int c;

  private RealTimeMessage(Parcel paramParcel)
  {
    this(paramParcel.readString(), paramParcel.createByteArray(), paramParcel.readInt());
  }

  private RealTimeMessage(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    this.a = ((String)w.a(paramString));
    this.b = ((byte[])((byte[])w.a(paramArrayOfByte)).clone());
    this.c = paramInt;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeByteArray(this.b);
    paramParcel.writeInt(this.c);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.realtime.RealTimeMessage
 * JD-Core Version:    0.6.0
 */