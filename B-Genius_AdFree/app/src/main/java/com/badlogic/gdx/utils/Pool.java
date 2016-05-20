package com.badlogic.gdx.utils;

public abstract class Pool
{
  private final Array freeObjects;
  public final int max;
  public int peak;

  public Pool()
  {
    this(16, 2147483647);
  }

  public Pool(int paramInt)
  {
    this(paramInt, 2147483647);
  }

  public Pool(int paramInt1, int paramInt2)
  {
    this.freeObjects = new Array(false, paramInt1);
    this.max = paramInt2;
  }

  public void clear()
  {
    this.freeObjects.clear();
  }

  public void free(Object paramObject)
  {
    if (paramObject == null)
      throw new IllegalArgumentException("object cannot be null.");
    if (this.freeObjects.size < this.max)
    {
      this.freeObjects.add(paramObject);
      this.peak = Math.max(this.peak, this.freeObjects.size);
    }
    if ((paramObject instanceof Pool.Poolable))
      ((Pool.Poolable)paramObject).reset();
  }

  public void freeAll(Array paramArray)
  {
    if (paramArray == null)
      throw new IllegalArgumentException("object cannot be null.");
    Array localArray = this.freeObjects;
    int i = this.max;
    for (int j = 0; j < paramArray.size; j++)
    {
      Object localObject = paramArray.get(j);
      if (localObject == null)
        continue;
      if (localArray.size < i)
        localArray.add(localObject);
      if (!(localObject instanceof Pool.Poolable))
        continue;
      ((Pool.Poolable)localObject).reset();
    }
    this.peak = Math.max(this.peak, localArray.size);
  }

  public int getFree()
  {
    return this.freeObjects.size;
  }

  protected abstract Object newObject();

  public Object obtain()
  {
    if (this.freeObjects.size == 0)
      return newObject();
    return this.freeObjects.pop();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.Pool
 * JD-Core Version:    0.6.0
 */