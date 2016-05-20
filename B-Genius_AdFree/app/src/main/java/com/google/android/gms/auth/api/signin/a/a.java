package com.google.android.gms.auth.api.signin.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.w;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public final class a
{
  private static final Lock a = new ReentrantLock();
  private static a b;
  private final Lock c = new ReentrantLock();
  private final SharedPreferences d;

  private a(Context paramContext)
  {
    this.d = paramContext.getSharedPreferences("com.google.android.gms.signin", 0);
  }

  private GoogleSignInAccount a(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    String str;
    do
    {
      return null;
      str = b("googleSignInAccount" + ":" + paramString);
    }
    while (str == null);
    try
    {
      GoogleSignInAccount localGoogleSignInAccount = GoogleSignInAccount.a(str);
      return localGoogleSignInAccount;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  public static a a(Context paramContext)
  {
    w.a(paramContext);
    a.lock();
    try
    {
      if (b == null)
        b = new a(paramContext.getApplicationContext());
      a locala = b;
      return locala;
    }
    finally
    {
      a.unlock();
    }
    throw localObject;
  }

  private String b(String paramString)
  {
    this.c.lock();
    try
    {
      String str = this.d.getString(paramString, null);
      return str;
    }
    finally
    {
      this.c.unlock();
    }
    throw localObject;
  }

  public final GoogleSignInAccount a()
  {
    return a(b("defaultGoogleSignInAccount"));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.a.a
 * JD-Core Version:    0.6.0
 */