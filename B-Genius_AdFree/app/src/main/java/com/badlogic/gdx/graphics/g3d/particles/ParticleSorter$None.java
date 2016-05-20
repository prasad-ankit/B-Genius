package com.badlogic.gdx.graphics.g3d.particles;

import com.badlogic.gdx.utils.Array;

public class ParticleSorter$None extends ParticleSorter
{
  int currentCapacity = 0;
  int[] indices;

  public void ensureCapacity(int paramInt)
  {
    if (this.currentCapacity < paramInt)
    {
      this.indices = new int[paramInt];
      for (int i = 0; i < paramInt; i++)
        this.indices[i] = i;
      this.currentCapacity = paramInt;
    }
  }

  public int[] sort(Array paramArray)
  {
    return this.indices;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.ParticleSorter.None
 * JD-Core Version:    0.6.0
 */