package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

public class Permission
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new o();
  final int a;
  private String b;
  private int c;
  private String d;
  private String e;
  private int f;
  private boolean g;

  Permission(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, int paramInt3, boolean paramBoolean)
  {
    this.a = paramInt1;
    this.b = paramString1;
    this.c = paramInt2;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramInt3;
    this.g = paramBoolean;
  }

  private static boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return false;
    case 256:
    case 257:
    case 258:
    }
    return true;
  }

  public final String a()
  {
    if (!a(this.c))
      return null;
    return this.b;
  }

  public final int b()
  {
    if (!a(this.c))
      return -1;
    return this.c;
  }

  public final String c()
  {
    return this.d;
  }

  public final String d()
  {
    return this.e;
  }

  public int describeContents()
  {
    return 0;
  }

  public final int e()
  {
    switch (this.f)
    {
    default:
    case 0:
    case 1:
    case 2:
    case 3:
    }
    for (int i = 0; i == 0; i = 1)
      return -1;
    return this.f;
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if ((paramObject == null) || (paramObject.getClass() != getClass()))
      i = 0;
    Permission localPermission;
    do
    {
      do
        return i;
      while (paramObject == this);
      localPermission = (Permission)paramObject;
    }
    while ((f.a(this.b, localPermission.b)) && (this.c == localPermission.c) && (this.f == localPermission.f) && (this.g == localPermission.g));
    return false;
  }

  public final boolean f()
  {
    return this.g;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = this.b;
    arrayOfObject[1] = Integer.valueOf(this.c);
    arrayOfObject[2] = Integer.valueOf(this.f);
    arrayOfObject[3] = Boolean.valueOf(this.g);
    return Arrays.hashCode(arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    o.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.Permission
 * JD-Core Version:    0.6.0
 */