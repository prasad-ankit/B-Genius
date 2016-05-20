package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.emitters.Emitter;

public class RegionInfluencer$Single extends RegionInfluencer
{
  public RegionInfluencer$Single()
  {
  }

  public RegionInfluencer$Single(Texture paramTexture)
  {
    super(paramTexture);
  }

  public RegionInfluencer$Single(TextureRegion paramTextureRegion)
  {
    super(new TextureRegion[] { paramTextureRegion });
  }

  public RegionInfluencer$Single(Single paramSingle)
  {
    super(paramSingle);
  }

  public Single copy()
  {
    return new Single(this);
  }

  public void init()
  {
    RegionInfluencer.AspectTextureRegion localAspectTextureRegion = ((RegionInfluencer.AspectTextureRegion[])this.regions.items)[0];
    int i = this.controller.emitter.maxParticleCount * this.regionChannel.strideSize;
    int j = 0;
    while (j < i)
    {
      this.regionChannel.data[j] = localAspectTextureRegion.u;
      this.regionChannel.data[(j + 1)] = localAspectTextureRegion.v;
      this.regionChannel.data[(j + 2)] = localAspectTextureRegion.u2;
      this.regionChannel.data[(j + 3)] = localAspectTextureRegion.v2;
      this.regionChannel.data[(j + 4)] = 0.5F;
      this.regionChannel.data[(j + 5)] = localAspectTextureRegion.halfInvAspectRatio;
      j += this.regionChannel.strideSize;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.influencers.RegionInfluencer.Single
 * JD-Core Version:    0.6.0
 */