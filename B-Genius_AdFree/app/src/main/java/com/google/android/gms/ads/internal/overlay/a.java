package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.P;
import com.google.android.gms.b.hc;
import com.google.android.gms.b.hu;

public final class a
{
  private static boolean a(Context paramContext, Intent paramIntent, C paramC)
  {
    try
    {
      hc.e("Launching an intent: " + paramIntent.toURI());
      P.e();
      hu.a(paramContext, paramIntent);
      if (paramC != null)
        paramC.l();
      return true;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      hc.d(localActivityNotFoundException.getMessage());
    }
    return false;
  }

  public final boolean a(Context paramContext, AdLauncherIntentInfoParcel paramAdLauncherIntentInfoParcel, C paramC)
  {
    if (paramAdLauncherIntentInfoParcel == null)
    {
      hc.d("No intent data for launcher overlay.");
      return false;
    }
    if (paramAdLauncherIntentInfoParcel.i != null)
      return a(paramContext, paramAdLauncherIntentInfoParcel.i, paramC);
    Intent localIntent = new Intent();
    if (TextUtils.isEmpty(paramAdLauncherIntentInfoParcel.c))
    {
      hc.d("Open GMSG did not contain a URL.");
      return false;
    }
    if (!TextUtils.isEmpty(paramAdLauncherIntentInfoParcel.d))
      localIntent.setDataAndType(Uri.parse(paramAdLauncherIntentInfoParcel.c), paramAdLauncherIntentInfoParcel.d);
    while (true)
    {
      localIntent.setAction("android.intent.action.VIEW");
      if (!TextUtils.isEmpty(paramAdLauncherIntentInfoParcel.e))
        localIntent.setPackage(paramAdLauncherIntentInfoParcel.e);
      if (TextUtils.isEmpty(paramAdLauncherIntentInfoParcel.f))
        break;
      String[] arrayOfString = paramAdLauncherIntentInfoParcel.f.split("/", 2);
      if (arrayOfString.length < 2)
      {
        hc.d("Could not parse component name from open GMSG: " + paramAdLauncherIntentInfoParcel.f);
        return false;
        localIntent.setData(Uri.parse(paramAdLauncherIntentInfoParcel.c));
        continue;
      }
      localIntent.setClassName(arrayOfString[0], arrayOfString[1]);
    }
    String str = paramAdLauncherIntentInfoParcel.g;
    if (!TextUtils.isEmpty(str));
    try
    {
      int j = Integer.parseInt(str);
      i = j;
      localIntent.addFlags(i);
      return a(paramContext, localIntent, paramC);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (true)
      {
        hc.d("Could not parse intent flags.");
        int i = 0;
      }
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.a
 * JD-Core Version:    0.6.0
 */