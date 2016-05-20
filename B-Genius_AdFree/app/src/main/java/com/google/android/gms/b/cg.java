package com.google.android.gms.b;

import android.support.v4.b.a;
import com.google.android.gms.ads.internal.l;
import java.util.Collections;
import java.util.Map;

public final class cg
  implements bU
{
  private static Map c;
  private final l a;
  private final eQ b;

  static
  {
    Integer localInteger1 = Integer.valueOf(1);
    Integer localInteger2 = Integer.valueOf(2);
    Integer localInteger3 = Integer.valueOf(3);
    Integer localInteger4 = Integer.valueOf(4);
    Integer localInteger5 = Integer.valueOf(5);
    Integer localInteger6 = Integer.valueOf(6);
    a locala = new a(6);
    locala.put("resize", localInteger1);
    locala.put("playVideo", localInteger2);
    locala.put("storePicture", localInteger3);
    locala.put("createCalendarEvent", localInteger4);
    locala.put("setOrientationProperties", localInteger5);
    locala.put("closeResizedAd", localInteger6);
    c = Collections.unmodifiableMap(locala);
  }

  public cg(l paraml, eQ parameQ)
  {
    this.a = paraml;
    this.b = parameQ;
  }

  public final void a(is paramis, Map paramMap)
  {
    String str = (String)paramMap.get("a");
    int i = ((Integer)c.get(str)).intValue();
    if ((i != 5) && (this.a != null) && (!this.a.b()))
    {
      this.a.a(null);
      return;
    }
    switch (i)
    {
    case 2:
    default:
      hc.c("Unknown MRAID command called.");
      return;
    case 1:
      this.b.a(paramMap);
      return;
    case 4:
      new eN(paramis, paramMap).a();
      return;
    case 3:
      new eT(paramis, paramMap).a();
      return;
    case 5:
      new eS(paramis, paramMap).a();
      return;
    case 6:
    }
    this.b.a(true);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.cg
 * JD-Core Version:    0.6.0
 */