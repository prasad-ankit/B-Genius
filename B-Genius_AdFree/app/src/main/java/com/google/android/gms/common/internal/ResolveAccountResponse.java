package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ResolveAccountResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new S();
  final int a;
  IBinder b;
  private ConnectionResult c;
  private boolean d;
  private boolean e;

  ResolveAccountResponse(int paramInt, IBinder paramIBinder, ConnectionResult paramConnectionResult, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramInt;
    this.b = paramIBinder;
    this.c = paramConnectionResult;
    this.d = paramBoolean1;
    this.e = paramBoolean2;
  }

  public final A a()
  {
    return B.a(this.b);
  }

  public final ConnectionResult b()
  {
    return this.c;
  }

  public final boolean c()
  {
    return this.d;
  }

  public final boolean d()
  {
    return this.e;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    ResolveAccountResponse localResolveAccountResponse;
    do
    {
      return true;
      if (!(paramObject instanceof ResolveAccountResponse))
        return false;
      localResolveAccountResponse = (ResolveAccountResponse)paramObject;
    }
    while ((this.c.equals(localResolveAccountResponse.c)) && (B.a(this.b).equals(B.a(localResolveAccountResponse.b))));
    return false;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    S.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.ResolveAccountResponse
 * JD-Core Version:    0.6.0
 */