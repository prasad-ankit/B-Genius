package com.badlogic.gdx.math;

import com.badlogic.gdx.utils.Array;
import java.util.Iterator;

public class CumulativeDistribution
{
  private Array values = new Array(false, 10, CumulativeDistribution.CumulativeValue.class);

  public void add(Object paramObject)
  {
    this.values.add(new CumulativeDistribution.CumulativeValue(this, paramObject, 0.0F, 0.0F));
  }

  public void add(Object paramObject, float paramFloat)
  {
    this.values.add(new CumulativeDistribution.CumulativeValue(this, paramObject, 0.0F, paramFloat));
  }

  public void clear()
  {
    this.values.clear();
  }

  public void generate()
  {
    float f = 0.0F;
    for (int i = 0; i < this.values.size; i++)
    {
      f += ((CumulativeDistribution.CumulativeValue[])this.values.items)[i].interval;
      ((CumulativeDistribution.CumulativeValue[])this.values.items)[i].frequency = f;
    }
  }

  public void generateNormalized()
  {
    int i = 0;
    float f1 = 0.0F;
    int k;
    float f2;
    while (true)
    {
      int j = this.values.size;
      k = 0;
      f2 = 0.0F;
      if (i >= j)
        break;
      f1 += ((CumulativeDistribution.CumulativeValue[])this.values.items)[i].interval;
      i++;
    }
    while (k < this.values.size)
    {
      f2 += ((CumulativeDistribution.CumulativeValue[])this.values.items)[k].interval / f1;
      ((CumulativeDistribution.CumulativeValue[])this.values.items)[k].frequency = f2;
      k++;
    }
  }

  public void generateUniform()
  {
    float f = 1.0F / this.values.size;
    for (int i = 0; i < this.values.size; i++)
    {
      ((CumulativeDistribution.CumulativeValue[])this.values.items)[i].interval = f;
      ((CumulativeDistribution.CumulativeValue[])this.values.items)[i].frequency = (f * (i + 1));
    }
  }

  public float getInterval(int paramInt)
  {
    return ((CumulativeDistribution.CumulativeValue[])this.values.items)[paramInt].interval;
  }

  public Object getValue(int paramInt)
  {
    return ((CumulativeDistribution.CumulativeValue[])this.values.items)[paramInt].value;
  }

  public void setInterval(int paramInt, float paramFloat)
  {
    ((CumulativeDistribution.CumulativeValue[])this.values.items)[paramInt].interval = paramFloat;
  }

  public void setInterval(Object paramObject, float paramFloat)
  {
    Iterator localIterator = this.values.iterator();
    while (localIterator.hasNext())
    {
      CumulativeDistribution.CumulativeValue localCumulativeValue = (CumulativeDistribution.CumulativeValue)localIterator.next();
      if (localCumulativeValue.value != paramObject)
        continue;
      localCumulativeValue.interval = paramFloat;
    }
  }

  public int size()
  {
    return this.values.size;
  }

  public Object value()
  {
    return value(MathUtils.random());
  }

  public Object value(float paramFloat)
  {
    int i = -1 + this.values.size;
    int j = 0;
    while (j <= i)
    {
      int k = j + (i - j) / 2;
      CumulativeDistribution.CumulativeValue localCumulativeValue = ((CumulativeDistribution.CumulativeValue[])this.values.items)[k];
      if (paramFloat < localCumulativeValue.frequency)
      {
        i = k - 1;
        continue;
      }
      if (paramFloat <= localCumulativeValue.frequency)
        break;
      j = k + 1;
    }
    return ((CumulativeDistribution.CumulativeValue[])this.values.items)[j].value;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.CumulativeDistribution
 * JD-Core Version:    0.6.0
 */