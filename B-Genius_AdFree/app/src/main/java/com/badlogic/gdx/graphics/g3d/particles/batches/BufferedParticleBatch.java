package com.badlogic.gdx.graphics.g3d.particles.batches;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.ParticleSorter;
import com.badlogic.gdx.graphics.g3d.particles.ParticleSorter.Distance;
import com.badlogic.gdx.graphics.g3d.particles.renderers.ParticleControllerRenderData;
import com.badlogic.gdx.utils.Array;

public abstract class BufferedParticleBatch
  implements ParticleBatch
{
  protected int bufferedParticlesCount;
  protected Camera camera;
  protected int currentCapacity = 0;
  protected Array renderData;
  protected ParticleSorter sorter = new ParticleSorter.Distance();

  protected BufferedParticleBatch(Class paramClass)
  {
    this.renderData = new Array(false, 10, paramClass);
  }

  protected abstract void allocParticlesData(int paramInt);

  public void begin()
  {
    this.renderData.clear();
    this.bufferedParticlesCount = 0;
  }

  public void draw(ParticleControllerRenderData paramParticleControllerRenderData)
  {
    if (paramParticleControllerRenderData.controller.particles.size > 0)
    {
      this.renderData.add(paramParticleControllerRenderData);
      this.bufferedParticlesCount += paramParticleControllerRenderData.controller.particles.size;
    }
  }

  public void end()
  {
    if (this.bufferedParticlesCount > 0)
    {
      ensureCapacity(this.bufferedParticlesCount);
      flush(this.sorter.sort(this.renderData));
    }
  }

  public void ensureCapacity(int paramInt)
  {
    if (this.currentCapacity >= paramInt)
      return;
    this.sorter.ensureCapacity(paramInt);
    allocParticlesData(paramInt);
    this.currentCapacity = paramInt;
  }

  protected abstract void flush(int[] paramArrayOfInt);

  public int getBufferedCount()
  {
    return this.bufferedParticlesCount;
  }

  public ParticleSorter getSorter()
  {
    return this.sorter;
  }

  public void resetCapacity()
  {
    this.bufferedParticlesCount = 0;
    this.currentCapacity = 0;
  }

  public void setCamera(Camera paramCamera)
  {
    this.camera = paramCamera;
    this.sorter.setCamera(paramCamera);
  }

  public void setSorter(ParticleSorter paramParticleSorter)
  {
    this.sorter = paramParticleSorter;
    paramParticleSorter.setCamera(this.camera);
    paramParticleSorter.ensureCapacity(this.currentCapacity);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.batches.BufferedParticleBatch
 * JD-Core Version:    0.6.0
 */