package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.w;
import android.util.Base64;
import com.google.android.gms.b.ku;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.aq;
import com.google.android.gms.drive.internal.v;

public class DriveId
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new l();
  final int a;
  final String b;
  final long c;
  final long d;
  final int e;
  private volatile String f = null;
  private volatile String g = null;

  DriveId(int paramInt1, String paramString, long paramLong1, long paramLong2, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramString;
    if (!"".equals(paramString));
    for (boolean bool1 = true; ; bool1 = false)
    {
      w.c(bool1);
      boolean bool2;
      if (paramString == null)
      {
        boolean bool3 = paramLong1 < -1L;
        bool2 = false;
        if (!bool3);
      }
      else
      {
        bool2 = true;
      }
      w.c(bool2);
      this.c = paramLong1;
      this.d = paramLong2;
      this.e = paramInt2;
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof DriveId));
    DriveId localDriveId;
    do
      while (true)
      {
        return false;
        localDriveId = (DriveId)paramObject;
        if (localDriveId.d != this.d)
          continue;
        if ((localDriveId.c == -1L) && (this.c == -1L))
          return localDriveId.b.equals(this.b);
        if ((this.b != null) && (localDriveId.b != null))
          break;
        if (localDriveId.c == this.c)
          return true;
      }
    while (localDriveId.c != this.c);
    if (localDriveId.b.equals(this.b))
      return true;
    aq.a("DriveId", "Unexpected unequal resourceId for same DriveId object.");
    return false;
  }

  public int hashCode()
  {
    if (this.c == -1L)
      return this.b.hashCode();
    return (String.valueOf(this.d) + String.valueOf(this.c)).hashCode();
  }

  public String toString()
  {
    v localv;
    if (this.f == null)
    {
      localv = new v();
      localv.a = this.a;
      if (this.b != null)
        break label97;
    }
    label97: for (String str1 = ""; ; str1 = this.b)
    {
      localv.b = str1;
      localv.c = this.c;
      localv.d = this.d;
      localv.e = this.e;
      String str2 = Base64.encodeToString(ku.a(localv), 10);
      this.f = ("DriveId:" + str2);
      return this.f;
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    l.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.DriveId
 * JD-Core Version:    0.6.0
 */