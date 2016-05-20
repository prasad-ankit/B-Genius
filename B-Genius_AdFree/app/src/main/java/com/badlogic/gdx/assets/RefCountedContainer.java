package com.badlogic.gdx.assets;

public class RefCountedContainer
{
  Object object;
  int refCount = 1;

  public RefCountedContainer(Object paramObject)
  {
    if (paramObject == null)
      throw new IllegalArgumentException("Object must not be null");
    this.object = paramObject;
  }

  public void decRefCount()
  {
    this.refCount = (-1 + this.refCount);
  }

  public Object getObject(Class paramClass)
  {
    return this.object;
  }

  public int getRefCount()
  {
    return this.refCount;
  }

  public void incRefCount()
  {
    this.refCount = (1 + this.refCount);
  }

  public void setObject(Object paramObject)
  {
    this.object = paramObject;
  }

  public void setRefCount(int paramInt)
  {
    this.refCount = paramInt;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.assets.RefCountedContainer
 * JD-Core Version:    0.6.0
 */