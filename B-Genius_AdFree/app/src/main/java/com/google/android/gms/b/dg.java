package com.google.android.gms.b;

import android.os.Parcel;
import android.util.Base64;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.r;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

final class dg
{
  final AdRequestParcel a;
  final String b;
  final int c;

  private dg(AdRequestParcel paramAdRequestParcel, String paramString, int paramInt)
  {
    this.a = paramAdRequestParcel;
    this.b = paramString;
    this.c = paramInt;
  }

  dg(dd paramdd)
  {
    this(paramdd.a(), paramdd.c(), paramdd.b());
  }

  dg(String paramString)
  {
    String[] arrayOfString = paramString.split("");
    if (arrayOfString.length != 3)
      throw new IOException("Incorrect field count for QueueSeed.");
    Parcel localParcel = Parcel.obtain();
    try
    {
      this.b = new String(Base64.decode(arrayOfString[0], 0), "UTF-8");
      this.c = Integer.parseInt(arrayOfString[1]);
      byte[] arrayOfByte = Base64.decode(arrayOfString[2], 0);
      localParcel.unmarshall(arrayOfByte, 0, arrayOfByte.length);
      localParcel.setDataPosition(0);
      this.a = r.a(localParcel);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new IOException("Malformed QueueSeed encoding.");
    }
    finally
    {
      localParcel.recycle();
    }
    throw localObject;
  }

  final String a()
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      String str1 = Base64.encodeToString(this.b.getBytes("UTF-8"), 0);
      String str2 = Integer.toString(this.c);
      this.a.writeToParcel(localParcel, 0);
      String str3 = Base64.encodeToString(localParcel.marshall(), 0);
      String str4 = str1 + "" + str2 + "" + str3;
      return str4;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      hc.b("QueueSeed encode failed because UTF-8 is not available.");
      return "";
    }
    finally
    {
      localParcel.recycle();
    }
    throw localObject;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.dg
 * JD-Core Version:    0.6.0
 */