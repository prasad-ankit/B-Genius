package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.i;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetServiceRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new h();
  final int a;
  final int b;
  int c;
  String d;
  IBinder e;
  Scope[] f;
  Bundle g;
  Account h;

  public GetServiceRequest(int paramInt)
  {
    this.a = 2;
    this.c = i.a;
    this.b = paramInt;
  }

  GetServiceRequest(int paramInt1, int paramInt2, int paramInt3, String paramString, IBinder paramIBinder, Scope[] paramArrayOfScope, Bundle paramBundle, Account paramAccount)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramString;
    Account localAccount;
    if (paramInt1 < 2)
    {
      localAccount = null;
      if (paramIBinder != null)
        localAccount = b.a(B.a(paramIBinder));
    }
    for (this.h = localAccount; ; this.h = paramAccount)
    {
      this.f = paramArrayOfScope;
      this.g = paramBundle;
      return;
      this.e = paramIBinder;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    h.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.GetServiceRequest
 * JD-Core Version:    0.6.0
 */