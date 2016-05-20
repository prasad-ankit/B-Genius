package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.Q;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

public class PlusSession
  implements SafeParcelable
{
  public static final i CREATOR = new i();
  private final int a;
  private final String b;
  private final String[] c;
  private final String[] d;
  private final String[] e;
  private final String f;
  private final String g;
  private final String h;
  private final String i;
  private final PlusCommonExtras j;

  PlusSession(int paramInt, String paramString1, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString2, String paramString3, String paramString4, String paramString5, PlusCommonExtras paramPlusCommonExtras)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.c = paramArrayOfString1;
    this.d = paramArrayOfString2;
    this.e = paramArrayOfString3;
    this.f = paramString2;
    this.g = paramString3;
    this.h = paramString4;
    this.i = paramString5;
    this.j = paramPlusCommonExtras;
  }

  public PlusSession(String paramString1, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString2, String paramString3, String paramString4, PlusCommonExtras paramPlusCommonExtras)
  {
    this.a = 1;
    this.b = paramString1;
    this.c = paramArrayOfString1;
    this.d = paramArrayOfString2;
    this.e = paramArrayOfString3;
    this.f = paramString2;
    this.g = paramString3;
    this.h = null;
    this.i = null;
    this.j = paramPlusCommonExtras;
  }

  public final int a()
  {
    return this.a;
  }

  public final String b()
  {
    return this.b;
  }

  public final String[] c()
  {
    return this.c;
  }

  public final String[] d()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public final String[] e()
  {
    return this.e;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof PlusSession));
    PlusSession localPlusSession;
    do
    {
      return false;
      localPlusSession = (PlusSession)paramObject;
    }
    while ((this.a != localPlusSession.a) || (!f.a(this.b, localPlusSession.b)) || (!Arrays.equals(this.c, localPlusSession.c)) || (!Arrays.equals(this.d, localPlusSession.d)) || (!Arrays.equals(this.e, localPlusSession.e)) || (!f.a(this.f, localPlusSession.f)) || (!f.a(this.g, localPlusSession.g)) || (!f.a(this.h, localPlusSession.h)) || (!f.a(this.i, localPlusSession.i)) || (!f.a(this.j, localPlusSession.j)));
    return true;
  }

  public final String f()
  {
    return this.f;
  }

  public final String g()
  {
    return this.g;
  }

  public final String h()
  {
    return this.h;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[10];
    arrayOfObject[0] = Integer.valueOf(this.a);
    arrayOfObject[1] = this.b;
    arrayOfObject[2] = this.c;
    arrayOfObject[3] = this.d;
    arrayOfObject[4] = this.e;
    arrayOfObject[5] = this.f;
    arrayOfObject[6] = this.g;
    arrayOfObject[7] = this.h;
    arrayOfObject[8] = this.i;
    arrayOfObject[9] = this.j;
    return Arrays.hashCode(arrayOfObject);
  }

  public final String i()
  {
    return this.i;
  }

  public final PlusCommonExtras j()
  {
    return this.j;
  }

  public final Bundle k()
  {
    Bundle localBundle = new Bundle();
    localBundle.setClassLoader(PlusCommonExtras.class.getClassLoader());
    PlusCommonExtras localPlusCommonExtras = this.j;
    Parcel localParcel = Parcel.obtain();
    localPlusCommonExtras.writeToParcel(localParcel, 0);
    byte[] arrayOfByte = localParcel.marshall();
    localParcel.recycle();
    localBundle.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", arrayOfByte);
    return localBundle;
  }

  public String toString()
  {
    return f.a(this).a("versionCode", Integer.valueOf(this.a)).a("accountName", this.b).a("requestedScopes", this.c).a("visibleActivities", this.d).a("requiredFeatures", this.e).a("packageNameForAuth", this.f).a("callingPackageName", this.g).a("applicationName", this.h).a("extra", this.j.toString()).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    i.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.PlusSession
 * JD-Core Version:    0.6.0
 */