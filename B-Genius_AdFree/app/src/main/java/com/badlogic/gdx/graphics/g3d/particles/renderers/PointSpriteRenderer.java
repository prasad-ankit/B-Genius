package com.badlogic.gdx.graphics.g3d.particles.renderers;

import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels.ColorInitializer;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels.Rotation2dInitializer;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels.ScaleInitializer;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels.TextureRegionInitializer;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent;
import com.badlogic.gdx.graphics.g3d.particles.batches.ParticleBatch;
import com.badlogic.gdx.graphics.g3d.particles.batches.PointSpriteParticleBatch;

public class PointSpriteRenderer extends ParticleControllerRenderer
{
  public PointSpriteRenderer()
  {
    super(new PointSpriteControllerRenderData());
  }

  public PointSpriteRenderer(PointSpriteParticleBatch paramPointSpriteParticleBatch)
  {
    this();
    setBatch(paramPointSpriteParticleBatch);
  }

  public void allocateChannels()
  {
    ((PointSpriteControllerRenderData)this.renderData).positionChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Position));
    ((PointSpriteControllerRenderData)this.renderData).regionChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.TextureRegion, ParticleChannels.TextureRegionInitializer.get()));
    ((PointSpriteControllerRenderData)this.renderData).colorChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Color, ParticleChannels.ColorInitializer.get()));
    ((PointSpriteControllerRenderData)this.renderData).scaleChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Scale, ParticleChannels.ScaleInitializer.get()));
    ((PointSpriteControllerRenderData)this.renderData).rotationChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Rotation2D, ParticleChannels.Rotation2dInitializer.get()));
  }

  public ParticleControllerComponent copy()
  {
    return new PointSpriteRenderer((PointSpriteParticleBatch)this.batch);
  }

  public boolean isCompatible(ParticleBatch paramParticleBatch)
  {
    return paramParticleBatch instanceof PointSpriteParticleBatch;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.renderers.PointSpriteRenderer
 * JD-Core Version:    0.6.0
 */