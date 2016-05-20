package com.google.android.gms.b;

public final class ky extends kp
{
  private int a = 0;
  private String b = "";
  private String c = "";

  public ky()
  {
    this.f = null;
    this.E = -1;
  }

  protected final int a()
  {
    int i = super.a();
    if (!this.b.equals(""))
      i += kn.b(2, this.b);
    if (!this.c.equals(""))
      i += kn.b(3, this.c);
    return i;
  }

  public final void a(kn paramkn)
  {
    if (!this.b.equals(""))
      paramkn.a(2, this.b);
    if (!this.c.equals(""))
      paramkn.a(3, this.c);
    super.a(paramkn);
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    ky localky;
    while (true)
    {
      return true;
      if (!(paramObject instanceof ky))
        return false;
      localky = (ky)paramObject;
      if (this.b == null)
      {
        if (localky.b != null)
          return false;
      }
      else if (!this.b.equals(localky.b))
        return false;
      if (this.c == null)
      {
        if (localky.c != null)
          return false;
      }
      else if (!this.c.equals(localky.c))
        return false;
      if ((this.f != null) && (!this.f.b()))
        break;
      if ((localky.f != null) && (!localky.f.b()))
        return false;
    }
    return this.f.equals(localky.f);
  }

  public final int hashCode()
  {
    int i = 31 * (31 * (527 + getClass().getName().hashCode()));
    int j;
    int m;
    label47: int n;
    int i1;
    if (this.b == null)
    {
      j = 0;
      int k = 31 * (j + i);
      if (this.c != null)
        break label104;
      m = 0;
      n = 31 * (m + k);
      kr localkr = this.f;
      i1 = 0;
      if (localkr != null)
      {
        boolean bool = this.f.b();
        i1 = 0;
        if (!bool)
          break label116;
      }
    }
    while (true)
    {
      return n + i1;
      j = this.b.hashCode();
      break;
      label104: m = this.c.hashCode();
      break label47;
      label116: i1 = this.f.hashCode();
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.ky
 * JD-Core Version:    0.6.0
 */