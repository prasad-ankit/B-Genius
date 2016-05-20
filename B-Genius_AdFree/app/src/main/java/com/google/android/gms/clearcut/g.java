package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;
import android.support.v4.app.p;
import com.google.android.gms.playlog.internal.PlayLoggerContext;

public final class g
  implements Parcelable.Creator
{
  public static LogEventParcelable a(Parcel paramParcel)
  {
    int i = j.a(paramParcel);
    byte[] arrayOfByte = null;
    PlayLoggerContext localPlayLoggerContext = null;
    int j = 0;
    int[] arrayOfInt = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = paramParcel.readInt();
      switch (0xFFFF & k)
      {
      default:
        j.b(paramParcel, k);
        break;
      case 1:
        j = j.e(paramParcel, k);
        break;
      case 2:
        localPlayLoggerContext = (PlayLoggerContext)j.a(paramParcel, k, PlayLoggerContext.CREATOR);
        break;
      case 3:
        arrayOfByte = j.p(paramParcel, k);
        break;
      case 4:
        arrayOfInt = j.r(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new p("Overread allowed size end=" + i, paramParcel);
    return new LogEventParcelable(j, localPlayLoggerContext, arrayOfByte, arrayOfInt);
  }

  static void a(LogEventParcelable paramLogEventParcelable, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramLogEventParcelable.a);
    j.a(paramParcel, 2, paramLogEventParcelable.b, paramInt, false);
    j.a(paramParcel, 3, paramLogEventParcelable.c, false);
    j.a(paramParcel, 4, paramLogEventParcelable.d, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.clearcut.g
 * JD-Core Version:    0.6.0
 */