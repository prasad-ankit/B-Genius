package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.gms.a;
import com.google.android.gms.ads.f;

public final class u
{
  private final f[] a;
  private final String b;

  public u(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.getResources().obtainAttributes(paramAttributeSet, a.a);
    String str1 = localTypedArray.getString(0);
    String str2 = localTypedArray.getString(i);
    int j;
    if (!TextUtils.isEmpty(str1))
    {
      j = i;
      if (TextUtils.isEmpty(str2))
        break label108;
      label54: if ((j == 0) || (i != 0))
        break label113;
    }
    for (this.a = a(str1); ; this.a = a(str2))
    {
      this.b = localTypedArray.getString(2);
      if (!TextUtils.isEmpty(this.b))
        return;
      throw new IllegalArgumentException("Required XML attribute \"adUnitId\" was missing.");
      j = 0;
      break;
      label108: i = 0;
      break label54;
      label113: if ((j != 0) || (i == 0))
        break label134;
    }
    label134: if (j != 0)
      throw new IllegalArgumentException("Either XML attribute \"adSize\" or XML attribute \"supportedAdSizes\" should be specified, but not both.");
    throw new IllegalArgumentException("Required XML attribute \"adSize\" was missing.");
  }

  private static f[] a(String paramString)
  {
    String[] arrayOfString1 = paramString.split("\\s*,\\s*");
    f[] arrayOff = new f[arrayOfString1.length];
    int i = 0;
    if (i < arrayOfString1.length)
    {
      String str = arrayOfString1[i].trim();
      String[] arrayOfString2;
      if (str.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$"))
      {
        arrayOfString2 = str.split("[xX]");
        arrayOfString2[0] = arrayOfString2[0].trim();
        arrayOfString2[1] = arrayOfString2[1].trim();
      }
      while (true)
      {
        try
        {
          if (!"FULL_WIDTH".equals(arrayOfString2[0]))
            continue;
          int j = -1;
          boolean bool = "AUTO_HEIGHT".equals(arrayOfString2[1]);
          if (!bool)
            continue;
          int m = -2;
          arrayOff[i] = new f(j, m);
          i++;
          break;
          j = Integer.parseInt(arrayOfString2[0]);
          continue;
          int k = Integer.parseInt(arrayOfString2[1]);
          m = k;
          continue;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": " + str);
        }
        if ("BANNER".equals(str))
        {
          arrayOff[i] = f.a;
          continue;
        }
        if ("LARGE_BANNER".equals(str))
        {
          arrayOff[i] = f.c;
          continue;
        }
        if ("FULL_BANNER".equals(str))
        {
          arrayOff[i] = f.b;
          continue;
        }
        if ("LEADERBOARD".equals(str))
        {
          arrayOff[i] = f.d;
          continue;
        }
        if ("MEDIUM_RECTANGLE".equals(str))
        {
          arrayOff[i] = f.e;
          continue;
        }
        if ("SMART_BANNER".equals(str))
        {
          arrayOff[i] = f.g;
          continue;
        }
        if ("WIDE_SKYSCRAPER".equals(str))
        {
          arrayOff[i] = f.f;
          continue;
        }
        if (!"FLUID".equals(str))
          break label332;
        arrayOff[i] = f.h;
      }
      label332: throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": " + str);
    }
    if (arrayOff.length == 0)
      throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": " + paramString);
    return arrayOff;
  }

  public final String a()
  {
    return this.b;
  }

  public final f[] a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.a.length != 1))
      throw new IllegalArgumentException("The adSizes XML attribute is only allowed on PublisherAdViews.");
    return this.a;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.client.u
 * JD-Core Version:    0.6.0
 */