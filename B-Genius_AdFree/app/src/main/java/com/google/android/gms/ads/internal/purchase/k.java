package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.b.hc;
import org.json.JSONException;
import org.json.JSONObject;

public final class k
{
  public static int a(Intent paramIntent)
  {
    if (paramIntent == null)
      return 5;
    Object localObject = paramIntent.getExtras().get("RESPONSE_CODE");
    if (localObject == null)
    {
      hc.d("Intent with no response code, assuming OK (known issue)");
      return 0;
    }
    if ((localObject instanceof Integer))
      return ((Integer)localObject).intValue();
    if ((localObject instanceof Long))
      return (int)((Long)localObject).longValue();
    hc.d("Unexpected type for intent response code. " + localObject.getClass().getName());
    return 5;
  }

  public static int a(Bundle paramBundle)
  {
    Object localObject = paramBundle.get("RESPONSE_CODE");
    if (localObject == null)
    {
      hc.d("Bundle with null response code, assuming OK (known issue)");
      return 0;
    }
    if ((localObject instanceof Integer))
      return ((Integer)localObject).intValue();
    if ((localObject instanceof Long))
      return (int)((Long)localObject).longValue();
    hc.d("Unexpected type for intent response code. " + localObject.getClass().getName());
    return 5;
  }

  public static String a(String paramString)
  {
    if (paramString == null)
      return null;
    try
    {
      String str = new JSONObject(paramString).getString("developerPayload");
      return str;
    }
    catch (JSONException localJSONException)
    {
      hc.d("Fail to parse purchase data");
    }
    return null;
  }

  public static String b(Intent paramIntent)
  {
    if (paramIntent == null)
      return null;
    return paramIntent.getStringExtra("INAPP_PURCHASE_DATA");
  }

  public static String b(String paramString)
  {
    if (paramString == null)
      return null;
    try
    {
      String str = new JSONObject(paramString).getString("purchaseToken");
      return str;
    }
    catch (JSONException localJSONException)
    {
      hc.d("Fail to parse purchase data");
    }
    return null;
  }

  public final void a(Context paramContext)
  {
    l locall = new l(this, paramContext);
    Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
    localIntent.setPackage("com.android.vending");
    paramContext.bindService(localIntent, locall, 1);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.purchase.k
 * JD-Core Version:    0.6.0
 */