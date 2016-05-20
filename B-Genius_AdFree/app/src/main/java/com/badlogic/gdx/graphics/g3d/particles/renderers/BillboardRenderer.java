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
import com.badlogic.gdx.graphics.g3d.particles.batches.BillboardParticleBatch;
import com.badlogic.gdx.graphics.g3d.particles.batches.ParticleBatch;

public class BillboardRenderer extends ParticleControllerRenderer
{
  public BillboardRenderer()
  {
    super(new BillboardControllerRenderData());
  }

  public BillboardRenderer(BillboardParticleBatch paramBillboardParticleBatch)
  {
    this();
    setBatch(paramBillboardParticleBatch);
  }

  public void allocateChannels()
  {
    ((BillboardControllerRenderData)this.renderData).positionChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Position));
    ((BillboardControllerRenderData)this.renderData).regionChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.TextureRegion, ParticleChannels.TextureRegionInitializer.get()));
    ((BillboardControllerRenderData)this.renderData).colorChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Color, ParticleChannels.ColorInitializer.get()));
    ((BillboardControllerRenderData)this.renderData).scaleChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Scale, ParticleChannels.ScaleInitializer.get()));
    ((BillboardControllerRenderData)this.renderData).rotationChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Rotation2D, ParticleChannels.Rotation2dInitializer.get()));
  }

  public ParticleControllerComponent copy()
  {
    return new BillboardRenderer((BillboardParticleBatch)this.batch);
  }

  public boolean isCompatible(ParticleBatch paramParticleBatch)
  {
    return paramParticleBatch instanceof BillboardParticleBatch;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.renderers.BillboardRenderer
 * JD-Core Version:    0.6.0
 */