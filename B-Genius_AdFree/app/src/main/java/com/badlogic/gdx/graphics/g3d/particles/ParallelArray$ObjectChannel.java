package com.badlogic.gdx.graphics.g3d.particles;

import com.badlogic.gdx.utils.reflect.ArrayReflection;

public class ParallelArray$ObjectChannel extends ParallelArray.Channel
{
  Class componentType;
  public Object[] data;

  public ParallelArray$ObjectChannel(ParallelArray paramParallelArray, int paramInt1, int paramInt2, int paramInt3, Class paramClass)
  {
    super(paramParallelArray, paramInt1, ArrayReflection.newInstance(paramClass, paramInt3 * paramInt2), paramInt2);
    this.componentType = paramClass;
    this.data = ((Object[])this.data);
  }

  public void add(int paramInt, Object[] paramArrayOfObject)
  {
    int i = this.strideSize * this.this$0.size;
    int j = i + this.strideSize;
    for (int k = 0; i < j; k++)
    {
      this.data[i] = paramArrayOfObject[k];
      i++;
    }
  }

  public void setCapacity(int paramInt)
  {
    Object[] arrayOfObject = (Object[])ArrayReflection.newInstance(this.componentType, paramInt * this.strideSize);
    System.arraycopy(this.data, 0, arrayOfObject, 0, Math.min(this.data.length, arrayOfObject.length));
    this.data = arrayOfObject;
    this.data = arrayOfObject;
  }

  public void swap(int paramInt1, int paramInt2)
  {
    int i = paramInt1 * this.strideSize;
    int j = paramInt2 * this.strideSize;
    int k = i + this.strideSize;
    while (i < k)
    {
      Object localObject = this.data[i];
      this.data[i] = this.data[j];
      this.data[j] = localObject;
      i++;
      j++;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.ParallelArray.ObjectChannel
 * JD-Core Version:    0.6.0
 */