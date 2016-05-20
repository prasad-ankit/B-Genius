package com.badlogic.gdx.graphics.g3d.particles;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g3d.particles.renderers.ParticleControllerRenderData;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.Array;
import java.util.Iterator;

public class ParticleSorter$Distance extends ParticleSorter
{
  private int currentSize = 0;
  private float[] distances;
  private int[] particleIndices;
  private int[] particleOffsets;

  public void ensureCapacity(int paramInt)
  {
    if (this.currentSize < paramInt)
    {
      this.distances = new float[paramInt];
      this.particleIndices = new int[paramInt];
      this.particleOffsets = new int[paramInt];
      this.currentSize = paramInt;
    }
  }

  public void qsort(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
    {
      if (paramInt2 - paramInt1 <= 8)
        for (int n = paramInt1; n <= paramInt2; n++)
          for (int i1 = n; (i1 > paramInt1) && (this.distances[(i1 - 1)] > this.distances[i1]); i1--)
          {
            float f3 = this.distances[i1];
            this.distances[i1] = this.distances[(i1 - 1)];
            this.distances[(i1 - 1)] = f3;
            int i2 = this.particleIndices[i1];
            this.particleIndices[i1] = this.particleIndices[(i1 - 1)];
            this.particleIndices[(i1 - 1)] = i2;
          }
      float f1 = this.distances[paramInt1];
      int i = paramInt1 + 1;
      int j = this.particleIndices[paramInt1];
      for (int k = i; k <= paramInt2; k++)
      {
        if (f1 <= this.distances[k])
          continue;
        if (k > i)
        {
          float f2 = this.distances[k];
          this.distances[k] = this.distances[i];
          this.distances[i] = f2;
          int m = this.particleIndices[k];
          this.particleIndices[k] = this.particleIndices[i];
          this.particleIndices[i] = m;
        }
        i++;
      }
      this.distances[paramInt1] = this.distances[(i - 1)];
      this.distances[(i - 1)] = f1;
      this.particleIndices[paramInt1] = this.particleIndices[(i - 1)];
      this.particleIndices[(i - 1)] = j;
      qsort(paramInt1, i - 2);
      qsort(i, paramInt2);
    }
  }

  public int[] sort(Array paramArray)
  {
    int i = 0;
    float[] arrayOfFloat = this.camera.view.val;
    float f1 = arrayOfFloat[2];
    float f2 = arrayOfFloat[6];
    float f3 = arrayOfFloat[10];
    Iterator localIterator = paramArray.iterator();
    int j = 0;
    int k = 0;
    while (localIterator.hasNext())
    {
      ParticleControllerRenderData localParticleControllerRenderData = (ParticleControllerRenderData)localIterator.next();
      int m = j + localParticleControllerRenderData.controller.particles.size;
      int n = 0;
      while (j < m)
      {
        this.distances[j] = (f1 * localParticleControllerRenderData.positionChannel.data[n] + f2 * localParticleControllerRenderData.positionChannel.data[(n + 1)] + f3 * localParticleControllerRenderData.positionChannel.data[(n + 2)]);
        this.particleIndices[j] = j;
        int i1 = j + 1;
        n += localParticleControllerRenderData.positionChannel.strideSize;
        j = i1;
      }
      k += localParticleControllerRenderData.controller.particles.size;
    }
    qsort(0, k - 1);
    while (i < k)
    {
      this.particleOffsets[this.particleIndices[i]] = i;
      i++;
    }
    return this.particleOffsets;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.ParticleSorter.Distance
 * JD-Core Version:    0.6.0
 */