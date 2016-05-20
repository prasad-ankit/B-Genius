package com.google.android.gms.b;

public final class jq
{
  public final Object a;
  public final U b;
  public final kb c;
  public boolean d = false;

  private jq(kb paramkb)
  {
    this.a = null;
    this.b = null;
    this.c = paramkb;
  }

  private jq(Object paramObject, U paramU)
  {
    this.a = paramObject;
    this.b = paramU;
    this.c = null;
  }

  public static jq a(kb paramkb)
  {
    return new jq(paramkb);
  }

  public static jq a(Object paramObject, U paramU)
  {
    return new jq(paramObject, paramU);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.jq
 * JD-Core Version:    0.6.0
 */