package com.google.android.gms.b;

import java.util.Arrays;

final class kv
{
  final int a;
  final byte[] b;

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    kv localkv;
    do
    {
      return true;
      if (!(paramObject instanceof kv))
        return false;
      localkv = (kv)paramObject;
    }
    while ((this.a == localkv.a) && (Arrays.equals(this.b, localkv.b)));
    return false;
  }

  public final int hashCode()
  {
    return 31 * (527 + this.a) + Arrays.hashCode(this.b);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.kv
 * JD-Core Version:    0.6.0
 */