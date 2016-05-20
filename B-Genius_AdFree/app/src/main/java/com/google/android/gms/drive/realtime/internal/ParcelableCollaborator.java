package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableCollaborator
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new Q();
  final int a;
  final boolean b;
  final boolean c;
  final String d;
  final String e;
  final String f;
  final String g;
  final String h;

  ParcelableCollaborator(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = paramInt;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramString3;
    this.g = paramString4;
    this.h = paramString5;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!(paramObject instanceof ParcelableCollaborator))
      return false;
    ParcelableCollaborator localParcelableCollaborator = (ParcelableCollaborator)paramObject;
    return this.d.equals(localParcelableCollaborator.d);
  }

  public int hashCode()
  {
    return this.d.hashCode();
  }

  public String toString()
  {
    return "Collaborator [isMe=" + this.b + ", isAnonymous=" + this.c + ", sessionId=" + this.d + ", userId=" + this.e + ", displayName=" + this.f + ", color=" + this.g + ", photoUrl=" + this.h + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Q.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.ParcelableCollaborator
 * JD-Core Version:    0.6.0
 */