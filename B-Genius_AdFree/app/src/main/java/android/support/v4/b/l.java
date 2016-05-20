package android.support.v4.b;

public final class l
  implements Cloneable
{
  private static final Object a = new Object();
  private boolean b = false;
  private int[] c;
  private Object[] d;
  private int e;

  public l()
  {
    this(10);
  }

  private l(int paramInt)
  {
    int i = c.a(10);
    this.c = new int[i];
    this.d = new Object[i];
    this.e = 0;
  }

  // ERROR //
  private l c()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 46	java/lang/Object:clone	()Ljava/lang/Object;
    //   4: checkcast 2	android/support/v4/b/l
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: getfield 35	android/support/v4/b/l:c	[I
    //   13: invokevirtual 48	[I:clone	()Ljava/lang/Object;
    //   16: checkcast 47	[I
    //   19: putfield 35	android/support/v4/b/l:c	[I
    //   22: aload_2
    //   23: aload_0
    //   24: getfield 37	android/support/v4/b/l:d	[Ljava/lang/Object;
    //   27: invokevirtual 50	[Ljava/lang/Object;:clone	()Ljava/lang/Object;
    //   30: checkcast 49	[Ljava/lang/Object;
    //   33: putfield 37	android/support/v4/b/l:d	[Ljava/lang/Object;
    //   36: aload_2
    //   37: areturn
    //   38: astore_1
    //   39: aconst_null
    //   40: areturn
    //   41: astore_3
    //   42: aload_2
    //   43: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   0	8	38	java/lang/CloneNotSupportedException
    //   8	36	41	java/lang/CloneNotSupportedException
  }

  public final int a()
  {
    return this.e;
  }

  public final int a(int paramInt)
  {
    return this.c[paramInt];
  }

  public final Object b(int paramInt)
  {
    return this.d[paramInt];
  }

  public final void b()
  {
    int i = this.e;
    Object[] arrayOfObject = this.d;
    for (int j = 0; j < i; j++)
      arrayOfObject[j] = null;
    this.e = 0;
    this.b = false;
  }

  public final String toString()
  {
    if (this.e <= 0)
      return "{}";
    StringBuilder localStringBuilder = new StringBuilder(28 * this.e);
    localStringBuilder.append('{');
    int i = 0;
    if (i < this.e)
    {
      if (i > 0)
        localStringBuilder.append(", ");
      localStringBuilder.append(this.c[i]);
      localStringBuilder.append('=');
      Object localObject = this.d[i];
      if (localObject != this)
        localStringBuilder.append(localObject);
      while (true)
      {
        i++;
        break;
        localStringBuilder.append("(this Map)");
      }
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.b.l
 * JD-Core Version:    0.6.0
 */