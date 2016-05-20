package com.google.android.gms.common.data;

import java.util.Iterator;

public abstract class a
  implements b
{
  protected final DataHolder a;

  protected a(DataHolder paramDataHolder)
  {
    this.a = paramDataHolder;
    if (this.a != null)
      this.a.a(this);
  }

  public final void a()
  {
    if (this.a != null)
      this.a.g();
  }

  public int b()
  {
    if (this.a == null)
      return 0;
    return this.a.b;
  }

  public Iterator iterator()
  {
    return new g(this);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.a
 * JD-Core Version:    0.6.0
 */