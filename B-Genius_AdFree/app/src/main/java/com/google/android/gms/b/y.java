package com.google.android.gms.b;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.view.MotionEvent;

public final class y
{
  private static final String[] c = { "/aclk", "/pcs/click" };
  private String a = "ad.doubleclick.net";
  private String[] b = { ".doubleclick.net", ".googleadservices.com", ".googlesyndication.com" };
  private r d;

  public y(r paramr)
  {
    this.d = paramr;
  }

  private Uri a(Uri paramUri, Context paramContext, String paramString, boolean paramBoolean)
  {
    boolean bool;
    try
    {
      bool = c(paramUri);
      if (bool)
      {
        if (!paramUri.toString().contains("dc_ms="))
          break label65;
        throw new z("Parameter already exists: dc_ms");
      }
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      throw new z("Provided Uri is not in a valid state");
    }
    if (paramUri.getQueryParameter("ms") != null)
      throw new z("Query parameter already exists: ms");
    label65: String str1 = this.d.a(paramContext, paramString);
    if (bool)
    {
      String str2 = paramUri.toString();
      int i = str2.indexOf(";adurl");
      if (i != -1)
        return Uri.parse(str2.substring(0, i + 1) + "dc_ms" + "=" + str1 + ";" + str2.substring(i + 1));
      String str3 = paramUri.getEncodedPath();
      int j = str2.indexOf(str3);
      return Uri.parse(str2.substring(0, j + str3.length()) + ";" + "dc_ms" + "=" + str1 + ";" + str2.substring(j + str3.length()));
    }
    String str4 = paramUri.toString();
    int k = str4.indexOf("&adurl");
    if (k == -1)
      k = str4.indexOf("?adurl");
    if (k != -1)
      return Uri.parse(str4.substring(0, k + 1) + "ms" + "=" + str1 + "&" + str4.substring(k + 1));
    Uri localUri = paramUri.buildUpon().appendQueryParameter("ms", str1).build();
    return localUri;
  }

  private boolean c(Uri paramUri)
  {
    if (paramUri == null)
      throw new NullPointerException();
    try
    {
      boolean bool = paramUri.getHost().equals(this.a);
      return bool;
    }
    catch (NullPointerException localNullPointerException)
    {
    }
    return false;
  }

  public final Uri a(Uri paramUri, Context paramContext)
  {
    try
    {
      Uri localUri = a(paramUri, paramContext, paramUri.getQueryParameter("ai"), true);
      return localUri;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
    }
    throw new z("Provided Uri is not in a valid state");
  }

  public final r a()
  {
    return this.d;
  }

  public final void a(MotionEvent paramMotionEvent)
  {
    this.d.a(paramMotionEvent);
  }

  public final boolean a(Uri paramUri)
  {
    if (paramUri == null)
      throw new NullPointerException();
    try
    {
      String str = paramUri.getHost();
      String[] arrayOfString = this.b;
      int i = arrayOfString.length;
      for (int j = 0; ; j++)
      {
        int k = 0;
        if (j < i)
        {
          boolean bool = str.endsWith(arrayOfString[j]);
          if (!bool)
            continue;
          k = 1;
        }
        return k;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
    }
    return false;
  }

  public final boolean b(Uri paramUri)
  {
    boolean bool = a(paramUri);
    int i = 0;
    String[] arrayOfString;
    if (bool)
      arrayOfString = c;
    for (int j = 0; ; j++)
    {
      i = 0;
      if (j < 2)
      {
        String str = arrayOfString[j];
        if (!paramUri.getPath().endsWith(str))
          continue;
        i = 1;
      }
      return i;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.y
 * JD-Core Version:    0.6.0
 */