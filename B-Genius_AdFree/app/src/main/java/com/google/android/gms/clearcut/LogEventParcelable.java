package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.support.v4.app.z;
import com.google.android.gms.b.kA;
import com.google.android.gms.common.internal.P;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.Arrays;
import java.util.List;

public class LogEventParcelable
  implements SafeParcelable
{
  public static final g CREATOR = new g();
  public final int a;
  public PlayLoggerContext b;
  public byte[] c;
  public int[] d;
  public final kA e;
  public final z f;
  public final z g;

  LogEventParcelable(int paramInt, PlayLoggerContext paramPlayLoggerContext, byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    this.a = paramInt;
    this.b = paramPlayLoggerContext;
    this.c = paramArrayOfByte;
    this.d = paramArrayOfInt;
    this.e = null;
    this.f = null;
    this.g = null;
  }

  public LogEventParcelable(PlayLoggerContext paramPlayLoggerContext, kA paramkA, z paramz1, z paramz2, int[] paramArrayOfInt)
  {
    this.a = 1;
    this.b = paramPlayLoggerContext;
    this.e = paramkA;
    this.f = paramz1;
    this.g = paramz2;
    this.d = paramArrayOfInt;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    while (true)
    {
      return true;
      if (!(paramObject instanceof LogEventParcelable))
        break;
      LogEventParcelable localLogEventParcelable = (LogEventParcelable)paramObject;
      if ((this.a != localLogEventParcelable.a) || (!f.a(this.b, localLogEventParcelable.b)) || (!Arrays.equals(this.c, localLogEventParcelable.c)) || (!Arrays.equals(this.d, localLogEventParcelable.d)) || (!f.a(this.e, localLogEventParcelable.e)) || (!f.a(this.f, localLogEventParcelable.f)) || (!f.a(this.g, localLogEventParcelable.g)))
        return false;
    }
    return false;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[7];
    arrayOfObject[0] = Integer.valueOf(this.a);
    arrayOfObject[1] = this.b;
    arrayOfObject[2] = this.c;
    arrayOfObject[3] = this.d;
    arrayOfObject[4] = this.e;
    arrayOfObject[5] = this.f;
    arrayOfObject[6] = this.g;
    return Arrays.hashCode(arrayOfObject);
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("LogEventParcelable[");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", ");
    String str1;
    String str2;
    if (this.c == null)
    {
      str1 = null;
      localStringBuilder.append(str1);
      localStringBuilder.append(", ");
      int[] arrayOfInt = this.d;
      str2 = null;
      if (arrayOfInt != null)
        break label163;
    }
    while (true)
    {
      localStringBuilder.append(str2);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.e);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.f);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.g);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      str1 = new String(this.c);
      break;
      label163: P localP = P.a(", ");
      int[][] arrayOfInt1 = new int[1][];
      arrayOfInt1[0] = this.d;
      List localList = Arrays.asList(arrayOfInt1);
      str2 = localP.a(new StringBuilder(), localList).toString();
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    g.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.clearcut.LogEventParcelable
 * JD-Core Version:    0.6.0
 */