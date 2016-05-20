package com.badlogic.gdx.graphics.g3d.particles.batches;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.RenderableProvider;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData.Configurable;
import com.badlogic.gdx.graphics.g3d.particles.renderers.ParticleControllerRenderData;

public abstract interface ParticleBatch extends RenderableProvider, ResourceData.Configurable
{
  public abstract void begin();

  public abstract void draw(ParticleControllerRenderData paramParticleControllerRenderData);

  public abstract void end();

  public abstract void load(AssetManager paramAssetManager, ResourceData paramResourceData);

  public abstract void save(AssetManager paramAssetManager, ResourceData paramResourceData);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.batches.ParticleBatch
 * JD-Core Version:    0.6.0
 */