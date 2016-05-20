package com.google.android.gms.b;

import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.common.api.g;

final class jb extends ja
{
  private final LogEventParcelable a;

  jb(iW paramiW, LogEventParcelable paramLogEventParcelable, g paramg)
  {
    super(paramg);
    this.a = paramLogEventParcelable;
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof jb))
      return false;
    jb localjb = (jb)paramObject;
    return this.a.equals(localjb.a);
  }

  public final String toString()
  {
    return "MethodImpl(" + this.a + ")";
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.jb
 * JD-Core Version:    0.6.0
 */