package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.p;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AuthAccountResult
  implements p, SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new a();
  final int a;
  private int b;
  private Intent c;

  public AuthAccountResult()
  {
    this(0, null);
  }

  AuthAccountResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramIntent;
  }

  private AuthAccountResult(int paramInt, Intent paramIntent)
  {
    this(2, 0, null);
  }

  public final int a()
  {
    return this.b;
  }

  public final Status b()
  {
    if (this.b == 0)
      return Status.a;
    return Status.d;
  }

  public final Intent c()
  {
    return this.c;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.signin.internal.AuthAccountResult
 * JD-Core Version:    0.6.0
 */