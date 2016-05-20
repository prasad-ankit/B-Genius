package com.badlogic.gdx.graphics.g3d.particles;

public class ParallelArray$FloatChannel extends ParallelArray.Channel
{
  public float[] data = (float[])this.data;

  public ParallelArray$FloatChannel(ParallelArray paramParallelArray, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramParallelArray, paramInt1, new float[paramInt3 * paramInt2], paramInt2);
  }

  public void add(int paramInt, Object[] paramArrayOfObject)
  {
    int i = this.strideSize * this.this$0.size;
    int j = i + this.strideSize;
    int k = i;
    for (int m = 0; k < j; m++)
    {
      this.data[k] = ((Float)paramArrayOfObject[m]).floatValue();
      k++;
    }
  }

  public void setCapacity(int paramInt)
  {
    float[] arrayOfFloat = new float[paramInt * this.strideSize];
    System.arraycopy(this.data, 0, arrayOfFloat, 0, Math.min(this.data.length, arrayOfFloat.length));
    this.data = arrayOfFloat;
    this.data = arrayOfFloat;
  }

  public void swap(int paramInt1, int paramInt2)
  {
    int i = paramInt1 * this.strideSize;
    int j = paramInt2 * this.strideSize;
    int k = i + this.strideSize;
    while (i < k)
    {
      float f = this.data[i];
      this.data[i] = this.data[j];
      this.data[j] = f;
      i++;
      j++;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel
 * JD-Core Version:    0.6.0
 */