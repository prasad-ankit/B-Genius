package com.google.android.gms.b;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.formats.a;
import java.util.List;

final class gf
  implements ig
{
  gf(gb paramgb, String paramString, Integer paramInteger1, Integer paramInteger2, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  private a a(List paramList)
  {
    if (paramList != null)
      while (true)
      {
        try
        {
          if (paramList.isEmpty())
            break;
          String str = this.a;
          List localList = gb.a(paramList);
          Integer localInteger1 = this.b;
          Integer localInteger2 = this.c;
          if (this.d > 0)
          {
            localInteger3 = Integer.valueOf(this.d);
            a locala = new a(str, localList, localInteger1, localInteger2, localInteger3, this.e + this.f);
            return locala;
          }
        }
        catch (RemoteException localRemoteException)
        {
          hc.b("Could not get attribution icon", localRemoteException);
          return null;
        }
        Integer localInteger3 = null;
      }
    return null;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.gf
 * JD-Core Version:    0.6.0
 */