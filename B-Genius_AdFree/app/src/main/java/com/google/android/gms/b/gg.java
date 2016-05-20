package com.google.android.gms.b;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v4.app.j;
import com.google.android.gms.ads.internal.formats.b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

final class gg
  implements hR
{
  gg(gb paramgb, boolean paramBoolean, double paramDouble, String paramString)
  {
  }

  private b b(InputStream paramInputStream)
  {
    Bitmap localBitmap;
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      j.a(paramInputStream, localByteArrayOutputStream, true, 1024);
      byte[] arrayOfByte2 = localByteArrayOutputStream.toByteArray();
      arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte1 == null)
      {
        this.d.a(2, this.a);
        return null;
      }
    }
    catch (IOException localIOException)
    {
      byte[] arrayOfByte1;
      while (true)
        arrayOfByte1 = null;
      localBitmap = BitmapFactory.decodeByteArray(arrayOfByte1, 0, arrayOfByte1.length);
      if (localBitmap == null)
      {
        this.d.a(2, this.a);
        return null;
      }
      localBitmap.setDensity((int)(160.0D * this.b));
    }
    return new b(new BitmapDrawable(Resources.getSystem(), localBitmap), Uri.parse(this.c), this.b);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.gg
 * JD-Core Version:    0.6.0
 */