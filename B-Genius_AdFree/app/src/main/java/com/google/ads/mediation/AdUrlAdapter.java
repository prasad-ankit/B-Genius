package com.google.ads.mediation;

import android.os.Bundle;
import com.google.android.gms.ads.mediation.d;
import com.google.android.gms.ads.mediation.f;
import com.google.android.gms.ads.mediation.h;

public final class AdUrlAdapter extends a
  implements d, f, h
{
  protected final Bundle a(Bundle paramBundle1, Bundle paramBundle2)
  {
    if (paramBundle1 != null);
    while (true)
    {
      paramBundle1.putBundle("sdk_less_server_data", paramBundle2);
      paramBundle1.putBoolean("_noRefresh", true);
      return paramBundle1;
      paramBundle1 = new Bundle();
    }
  }

  public final String a(Bundle paramBundle)
  {
    return "adurl";
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.mediation.AdUrlAdapter
 * JD-Core Version:    0.6.0
 */