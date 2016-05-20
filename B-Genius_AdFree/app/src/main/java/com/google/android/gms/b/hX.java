package com.google.android.gms.b;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.P;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public final class hX extends ha
{
  private final String a;
  private final Context b;
  private final String c;
  private String d = null;

  public hX(Context paramContext, String paramString1, String paramString2)
  {
    this.b = paramContext;
    this.a = paramString1;
    this.c = paramString2;
  }

  public hX(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.b = paramContext;
    this.a = paramString1;
    this.c = paramString2;
    this.d = paramString3;
  }

  public final void a()
  {
    try
    {
      hc.e("Pinging URL: " + this.c);
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(this.c).openConnection();
      try
      {
        if (TextUtils.isEmpty(this.d))
          P.e().a(this.b, this.a, true, localHttpURLConnection);
        while (true)
        {
          int i = localHttpURLConnection.getResponseCode();
          if ((i < 200) || (i >= 300))
            hc.d("Received non-success response code " + i + " from pinging URL: " + this.c);
          return;
          P.e();
          hu.a(true, localHttpURLConnection, this.d);
        }
      }
      finally
      {
        localHttpURLConnection.disconnect();
      }
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      hc.d("Error while parsing ping URL: " + this.c + ". " + localIndexOutOfBoundsException.getMessage());
      return;
    }
    catch (IOException localIOException)
    {
      hc.d("Error while pinging URL: " + this.c + ". " + localIOException.getMessage());
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      hc.d("Error while pinging URL: " + this.c + ". " + localRuntimeException.getMessage());
    }
  }

  public final void b()
  {
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.hX
 * JD-Core Version:    0.6.0
 */