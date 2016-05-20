package com.badlogic.gdx.graphics.g3d.particles;

public abstract class ParallelArray$Channel
{
  public Object data;
  public int id;
  public int strideSize;

  public ParallelArray$Channel(ParallelArray paramParallelArray, int paramInt1, Object paramObject, int paramInt2)
  {
    this.id = paramInt1;
    this.strideSize = paramInt2;
    this.data = paramObject;
  }

  public abstract void add(int paramInt, Object[] paramArrayOfObject);

  protected abstract void setCapacity(int paramInt);

  public abstract void swap(int paramInt1, int paramInt2);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.ParallelArray.Channel
 * JD-Core Version:    0.6.0
 */