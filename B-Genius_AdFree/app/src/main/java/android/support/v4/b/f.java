package android.support.v4.b;

import java.util.Iterator;

final class f
  implements Iterator
{
  private int a;
  private int b;
  private int c;
  private boolean d = false;

  f(e parame, int paramInt)
  {
    this.a = paramInt;
    this.b = parame.a();
  }

  public final boolean hasNext()
  {
    return this.c < this.b;
  }

  public final Object next()
  {
    Object localObject = this.e.a(this.c, this.a);
    this.c = (1 + this.c);
    this.d = true;
    return localObject;
  }

  public final void remove()
  {
    if (!this.d)
      throw new IllegalStateException();
    this.c = (-1 + this.c);
    this.b = (-1 + this.b);
    this.d = false;
    this.e.a(this.c);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.b.f
 * JD-Core Version:    0.6.0
 */