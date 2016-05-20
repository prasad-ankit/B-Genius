package com.google.android.gms.plus.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.Q;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

public class PlusCommonExtras
  implements SafeParcelable
{
  public static final h CREATOR = new h();
  private final int a;
  private String b;
  private String c;

  public PlusCommonExtras()
  {
    this.a = 1;
    this.b = "";
    this.c = "";
  }

  PlusCommonExtras(int paramInt, String paramString1, String paramString2)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.c = paramString2;
  }

  public final int a()
  {
    return this.a;
  }

  public final String b()
  {
    return this.b;
  }

  public final String c()
  {
    return this.c;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof PlusCommonExtras));
    PlusCommonExtras localPlusCommonExtras;
    do
    {
      return false;
      localPlusCommonExtras = (PlusCommonExtras)paramObject;
    }
    while ((this.a != localPlusCommonExtras.a) || (!f.a(this.b, localPlusCommonExtras.b)) || (!f.a(this.c, localPlusCommonExtras.c)));
    return true;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(this.a);
    arrayOfObject[1] = this.b;
    arrayOfObject[2] = this.c;
    return Arrays.hashCode(arrayOfObject);
  }

  public String toString()
  {
    return f.a(this).a("versionCode", Integer.valueOf(this.a)).a("Gpsrc", this.b).a("ClientCallingPackage", this.c).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    h.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.PlusCommonExtras
 * JD-Core Version:    0.6.0
 */