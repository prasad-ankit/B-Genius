package com.google.android.gms.b;

public abstract class jl
{
  private static jp c;
  private static int d;
  protected final String a;
  protected final Object b;
  private Object e = null;

  static
  {
    new Object();
    c = null;
    d = 0;
  }

  protected jl(String paramString, Object paramObject)
  {
    this.a = paramString;
    this.b = paramObject;
  }

  public static int a()
  {
    return 0;
  }

  public static jl a(String paramString, Integer paramInteger)
  {
    return new jn(paramString, paramInteger);
  }

  public static jl a(String paramString, Long paramLong)
  {
    return new jm(paramString, paramLong);
  }

  public static jl a(String paramString1, String paramString2)
  {
    return new jo(paramString1, paramString2);
  }

  public static boolean b()
  {
    return false;
  }

  protected abstract Object a(String paramString);

  public final Object c()
  {
    return a(this.a);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.jl
 * JD-Core Version:    0.6.0
 */