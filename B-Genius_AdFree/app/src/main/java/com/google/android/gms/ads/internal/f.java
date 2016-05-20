package com.google.android.gms.ads.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import android.util.Base64;
import android.view.View;
import com.google.android.gms.a.a;
import com.google.android.gms.ads.internal.formats.c;
import com.google.android.gms.b.R;
import com.google.android.gms.b.aZ;
import com.google.android.gms.b.bU;
import com.google.android.gms.b.dV;
import com.google.android.gms.b.eB;
import com.google.android.gms.b.ec;
import com.google.android.gms.b.eo;
import com.google.android.gms.b.ey;
import com.google.android.gms.b.gS;
import com.google.android.gms.b.hc;
import com.google.android.gms.b.is;
import com.google.android.gms.b.it;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class f
  implements bU
{
  f(e parame)
  {
  }

  public static View a(gS paramgS)
  {
    if (paramgS == null)
    {
      hc.b("AdState is null");
      return null;
    }
    if (b(paramgS))
      return paramgS.b.b();
    try
    {
      a locala = paramgS.o.a();
      if (locala == null)
      {
        hc.d("View in mediation adapter is null.");
        return null;
      }
      View localView = (View)com.google.android.gms.a.d.a(locala);
      return localView;
    }
    catch (RemoteException localRemoteException)
    {
      hc.c("Could not get View from mediation adapter.", localRemoteException);
    }
    return null;
  }

  static bU a(ey paramey, eB parameB, p paramp)
  {
    return new E(paramey, paramp, parameB);
  }

  private static String a(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    if (paramBitmap == null)
    {
      hc.d("Bitmap is null. Returning empty string");
      return "";
    }
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    String str = Base64.encodeToString(localByteArrayOutputStream.toByteArray(), 0);
    return "data:image/png;base64," + str;
  }

  static String a(aZ paramaZ)
  {
    if (paramaZ == null)
    {
      hc.d("Image is null. Returning empty string");
      return "";
    }
    try
    {
      Uri localUri = paramaZ.b();
      if (localUri != null)
      {
        String str = localUri.toString();
        return str;
      }
    }
    catch (RemoteException localRemoteException)
    {
      hc.d("Unable to get image uri. Trying data uri next");
    }
    return b(paramaZ);
  }

  public static boolean a(is paramis, ec paramec, CountDownLatch paramCountDownLatch)
  {
    while (true)
    {
      try
      {
        View localView = paramis.b();
        if (localView != null)
          continue;
        hc.d("AdWebView is null");
        i = 0;
        if (i != 0)
          continue;
        paramCountDownLatch.countDown();
        return i;
        localView.setVisibility(4);
        List localList = paramec.b.l;
        if ((localList != null) && (!localList.isEmpty()))
          continue;
        hc.d("No template ids present in mediation response");
        i = 0;
        continue;
        paramis.l().a("/nativeExpressAssetsLoaded", new C(paramCountDownLatch));
        paramis.l().a("/nativeExpressAssetsLoadingFailed", new D(paramCountDownLatch));
        ey localey = paramec.c.h();
        eB localeB = paramec.c.i();
        if ((!localList.contains("2")) || (localey == null))
          continue;
        c localc = new c(localey.a(), localey.b(), localey.c(), localey.d(), localey.e(), localey.f(), localey.g(), localey.h(), null, localey.l());
        String str1 = paramec.b.k;
        paramis.l().a(new A(localc, str1, paramis));
        str2 = paramec.b.i;
        String str3 = paramec.b.j;
        if (str3 == null)
          continue;
        paramis.loadDataWithBaseURL(str3, str2, "text/html", "UTF-8", null);
        break label461;
        if ((!localList.contains("1")) || (localeB == null))
          continue;
        com.google.android.gms.ads.internal.formats.d locald = new com.google.android.gms.ads.internal.formats.d(localeB.a(), localeB.b(), localeB.c(), localeB.d(), localeB.e(), localeB.f(), null, localeB.j());
        String str4 = paramec.b.k;
        paramis.l().a(new B(locald, str4, paramis));
        continue;
      }
      catch (RemoteException localRemoteException)
      {
        String str2;
        hc.c("Unable to invoke load assets", localRemoteException);
        i = 0;
        continue;
        hc.d("No matching template id and mapper");
        i = 0;
        continue;
        paramis.loadData(str2, "text/html", "UTF-8");
      }
      catch (RuntimeException localRuntimeException)
      {
        paramCountDownLatch.countDown();
        throw localRuntimeException;
      }
      label461: int i = 1;
    }
  }

  private static String b(aZ paramaZ)
  {
    Drawable localDrawable;
    try
    {
      a locala = paramaZ.a();
      if (locala == null)
      {
        hc.d("Drawable is null. Returning empty string");
        return "";
      }
      localDrawable = (Drawable)com.google.android.gms.a.d.a(locala);
      if (!(localDrawable instanceof BitmapDrawable))
      {
        hc.d("Drawable is not an instance of BitmapDrawable. Returning empty string");
        return "";
      }
    }
    catch (RemoteException localRemoteException)
    {
      hc.d("Unable to get drawable. Returning empty string");
      return "";
    }
    return a(((BitmapDrawable)localDrawable).getBitmap());
  }

  public static boolean b(gS paramgS)
  {
    return (paramgS != null) && (paramgS.m) && (paramgS.n != null) && (paramgS.n.i != null);
  }

  public final void a(is paramis, Map paramMap)
  {
    if (this.a.d.j != null)
    {
      this.a.f.a(this.a.d.i, this.a.d.j, paramis.b(), paramis);
      return;
    }
    hc.d("Request to enable ActiveView before adState is available.");
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.f
 * JD-Core Version:    0.6.0
 */