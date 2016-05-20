package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.ads.internal.P;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.aB;
import com.google.android.gms.b.aD;
import com.google.android.gms.b.au;
import com.google.android.gms.common.q;

final class i
  implements k
{
  i(Context paramContext)
  {
  }

  public final boolean a(VersionInfoParcel paramVersionInfoParcel)
  {
    if (!paramVersionInfoParcel.e)
    {
      if (q.g(this.a))
      {
        au localau = aD.q;
        if (((Boolean)P.n().a(localau)).booleanValue());
      }
    }
    else
      return true;
    return false;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.request.i
 * JD-Core Version:    0.6.0
 */