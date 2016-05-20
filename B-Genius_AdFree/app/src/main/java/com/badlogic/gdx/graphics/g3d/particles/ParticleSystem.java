package com.badlogic.gdx.graphics.g3d.particles;

import com.badlogic.gdx.graphics.g3d.RenderableProvider;
import com.badlogic.gdx.graphics.g3d.particles.batches.ParticleBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import java.util.Iterator;

public final class ParticleSystem
  implements RenderableProvider
{
  private static ParticleSystem instance;
  private Array batches = new Array();
  private Array effects = new Array();

  public static ParticleSystem get()
  {
    if (instance == null)
      instance = new ParticleSystem();
    return instance;
  }

  public final void add(ParticleEffect paramParticleEffect)
  {
    this.effects.add(paramParticleEffect);
  }

  public final void add(ParticleBatch paramParticleBatch)
  {
    this.batches.add(paramParticleBatch);
  }

  public final void begin()
  {
    Iterator localIterator = this.batches.iterator();
    while (localIterator.hasNext())
      ((ParticleBatch)localIterator.next()).begin();
  }

  public final void draw()
  {
    Iterator localIterator = this.effects.iterator();
    while (localIterator.hasNext())
      ((ParticleEffect)localIterator.next()).draw();
  }

  public final void end()
  {
    Iterator localIterator = this.batches.iterator();
    while (localIterator.hasNext())
      ((ParticleBatch)localIterator.next()).end();
  }

  public final Array getBatches()
  {
    return this.batches;
  }

  public final void getRenderables(Array paramArray, Pool paramPool)
  {
    Iterator localIterator = this.batches.iterator();
    while (localIterator.hasNext())
      ((ParticleBatch)localIterator.next()).getRenderables(paramArray, paramPool);
  }

  public final void remove(ParticleEffect paramParticleEffect)
  {
    this.effects.removeValue(paramParticleEffect, true);
  }

  public final void removeAll()
  {
    this.effects.clear();
  }

  public final void update()
  {
    Iterator localIterator = this.effects.iterator();
    while (localIterator.hasNext())
      ((ParticleEffect)localIterator.next()).update();
  }

  public final void updateAndDraw()
  {
    Iterator localIterator = this.effects.iterator();
    while (localIterator.hasNext())
    {
      ParticleEffect localParticleEffect = (ParticleEffect)localIterator.next();
      localParticleEffect.update();
      localParticleEffect.draw();
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.ParticleSystem
 * JD-Core Version:    0.6.0
 */