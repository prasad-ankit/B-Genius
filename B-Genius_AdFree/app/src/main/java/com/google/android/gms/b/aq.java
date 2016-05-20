package com.google.android.gms.b;

public final class aq
{
  final long a;
  final String b;
  final int c;

  aq(long paramLong, String paramString, int paramInt)
  {
    this.a = paramLong;
    this.b = paramString;
    this.c = paramInt;
  }

  public final boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof aq)))
      return false;
    return (((aq)paramObject).a == this.a) && (((aq)paramObject).c == this.c);
  }

  public final int hashCode()
  {
    return (int)this.a;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.aq
 * JD-Core Version:    0.6.0
 */