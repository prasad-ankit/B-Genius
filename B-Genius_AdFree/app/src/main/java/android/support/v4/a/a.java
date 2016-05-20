package android.support.v4.a;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.H;
import com.google.android.gms.ads.internal.client.N;
import com.google.android.gms.ads.internal.client.g;
import com.google.android.gms.ads.internal.client.j;
import com.google.android.gms.ads.internal.client.w;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.ek;
import com.google.android.gms.b.fd;
import com.google.android.gms.b.fw;

public class a
  implements w
{
  public static void a(String paramString)
  {
    if (a(3))
      Log.d("Ads", paramString);
  }

  public static void a(String paramString, Throwable paramThrowable)
  {
    if (a(3))
      Log.d("Ads", paramString, paramThrowable);
  }

  public static boolean a(int paramInt)
  {
    return (paramInt >= 5) || (Log.isLoggable("Ads", paramInt));
  }

  public static void b(String paramString)
  {
    if (a(6))
      Log.e("Ads", paramString);
  }

  public static void b(String paramString, Throwable paramThrowable)
  {
    if (a(6))
      Log.e("Ads", paramString, paramThrowable);
  }

  public static void c(String paramString)
  {
    if (a(4))
      Log.i("Ads", paramString);
  }

  public static void c(String paramString, Throwable paramThrowable)
  {
    if (a(5))
      Log.w("Ads", paramString, paramThrowable);
  }

  public static void d(String paramString)
  {
    if (a(5))
      Log.w("Ads", paramString);
  }

  public H a(Context paramContext, String paramString, ek paramek, VersionInfoParcel paramVersionInfoParcel)
  {
    return new g();
  }

  public N a(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, ek paramek, VersionInfoParcel paramVersionInfoParcel)
  {
    return new j();
  }

  public fw a(Activity paramActivity)
  {
    return null;
  }

  public N b(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, ek paramek, VersionInfoParcel paramVersionInfoParcel)
  {
    return new j();
  }

  public fd b(Activity paramActivity)
  {
    return null;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.a.a
 * JD-Core Version:    0.6.0
 */