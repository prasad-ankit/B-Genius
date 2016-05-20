package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.Locale;

public final class ChangeEvent
  implements SafeParcelable, ResourceEvent
{
  public static final Parcelable.Creator CREATOR = new a();
  final int a;
  final DriveId b;
  final int c;

  ChangeEvent(int paramInt1, DriveId paramDriveId, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramDriveId;
    this.c = paramInt2;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final String toString()
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.b;
    arrayOfObject[1] = Integer.valueOf(this.c);
    return String.format(localLocale, "ChangeEvent [id=%s,changeFlags=%x]", arrayOfObject);
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.events.ChangeEvent
 * JD-Core Version:    0.6.0
 */