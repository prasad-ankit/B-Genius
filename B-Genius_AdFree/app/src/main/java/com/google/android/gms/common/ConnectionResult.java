package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Q;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

public final class ConnectionResult
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR;
  public static final ConnectionResult a = new ConnectionResult(0);
  final int b;
  private final int c;
  private final PendingIntent d;
  private final String e;

  static
  {
    CREATOR = new h();
  }

  private ConnectionResult(int paramInt)
  {
    this(0, null, null);
  }

  ConnectionResult(int paramInt1, int paramInt2, PendingIntent paramPendingIntent, String paramString)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramPendingIntent;
    this.e = paramString;
  }

  public ConnectionResult(int paramInt, PendingIntent paramPendingIntent)
  {
    this(paramInt, paramPendingIntent, null);
  }

  private ConnectionResult(int paramInt, PendingIntent paramPendingIntent, String paramString)
  {
    this(1, paramInt, paramPendingIntent, null);
  }

  static String a(int paramInt)
  {
    switch (paramInt)
    {
    case 12:
    default:
      return "UNKNOWN_ERROR_CODE(" + paramInt + ")";
    case 0:
      return "SUCCESS";
    case 1:
      return "SERVICE_MISSING";
    case 2:
      return "SERVICE_VERSION_UPDATE_REQUIRED";
    case 3:
      return "SERVICE_DISABLED";
    case 4:
      return "SIGN_IN_REQUIRED";
    case 5:
      return "INVALID_ACCOUNT";
    case 6:
      return "RESOLUTION_REQUIRED";
    case 7:
      return "NETWORK_ERROR";
    case 8:
      return "INTERNAL_ERROR";
    case 9:
      return "SERVICE_INVALID";
    case 10:
      return "DEVELOPER_ERROR";
    case 11:
      return "LICENSE_CHECK_FAILED";
    case 13:
      return "CANCELED";
    case 14:
      return "TIMEOUT";
    case 15:
      return "INTERRUPTED";
    case 16:
      return "API_UNAVAILABLE";
    case 17:
      return "SIGN_IN_FAILED";
    case 18:
      return "SERVICE_UPDATING";
    case 19:
      return "SERVICE_MISSING_PERMISSION";
    case 20:
    }
    return "RESTRICTED_PROFILE";
  }

  public final void a(Activity paramActivity, int paramInt)
  {
    if (!a())
      return;
    paramActivity.startIntentSenderForResult(this.d.getIntentSender(), paramInt, null, 0, 0, 0);
  }

  public final boolean a()
  {
    return (this.c != 0) && (this.d != null);
  }

  public final boolean b()
  {
    return this.c == 0;
  }

  public final int c()
  {
    return this.c;
  }

  public final PendingIntent d()
  {
    return this.d;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final String e()
  {
    return this.e;
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    ConnectionResult localConnectionResult;
    do
    {
      return true;
      if (!(paramObject instanceof ConnectionResult))
        return false;
      localConnectionResult = (ConnectionResult)paramObject;
    }
    while ((this.c == localConnectionResult.c) && (f.a(this.d, localConnectionResult.d)) && (f.a(this.e, localConnectionResult.e)));
    return false;
  }

  public final int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(this.c);
    arrayOfObject[1] = this.d;
    arrayOfObject[2] = this.e;
    return Arrays.hashCode(arrayOfObject);
  }

  public final String toString()
  {
    return f.a(this).a("statusCode", a(this.c)).a("resolution", this.d).a("message", this.e).toString();
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    h.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.ConnectionResult
 * JD-Core Version:    0.6.0
 */