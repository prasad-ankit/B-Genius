package com.badlogic.gdx.graphics.g3d.particles;

public class ParallelArray$IntChannel extends ParallelArray.Channel
{
  public int[] data = (int[])this.data;

  public ParallelArray$IntChannel(ParallelArray paramParallelArray, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramParallelArray, paramInt1, new int[paramInt3 * paramInt2], paramInt2);
  }

  public void add(int paramInt, Object[] paramArrayOfObject)
  {
    int i = this.strideSize * this.this$0.size;
    int j = i + this.strideSize;
    int k = i;
    for (int m = 0; k < j; m++)
    {
      this.data[k] = ((Integer)paramArrayOfObject[m]).intValue();
      k++;
    }
  }

  public void setCapacity(int paramInt)
  {
    int[] arrayOfInt = new int[paramInt * this.strideSize];
    System.arraycopy(this.data, 0, arrayOfInt, 0, Math.min(this.data.length, arrayOfInt.length));
    this.data = arrayOfInt;
    this.data = arrayOfInt;
  }

  public void swap(int paramInt1, int paramInt2)
  {
    int i = paramInt1 * this.strideSize;
    int j = paramInt2 * this.strideSize;
    int k = i + this.strideSize;
    while (i < k)
    {
      int m = this.data[i];
      this.data[i] = this.data[j];
      this.data[j] = m;
      i++;
      j++;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.ParallelArray.IntChannel
 * JD-Core Version:    0.6.0
 */