package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.utils.Array;

public class RegionInfluencer$Animated extends RegionInfluencer
{
  ParallelArray.FloatChannel lifeChannel;

  public RegionInfluencer$Animated()
  {
  }

  public RegionInfluencer$Animated(Texture paramTexture)
  {
    super(paramTexture);
  }

  public RegionInfluencer$Animated(TextureRegion paramTextureRegion)
  {
    super(new TextureRegion[] { paramTextureRegion });
  }

  public RegionInfluencer$Animated(Animated paramAnimated)
  {
    super(paramAnimated);
  }

  public void allocateChannels()
  {
    super.allocateChannels();
    this.lifeChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Life));
  }

  public Animated copy()
  {
    return new Animated(this);
  }

  public void update()
  {
    int i = this.controller.particles.size * this.regionChannel.strideSize;
    int j = 0;
    int k = 2;
    while (j < i)
    {
      RegionInfluencer.AspectTextureRegion localAspectTextureRegion = (RegionInfluencer.AspectTextureRegion)this.regions.get((int)(this.lifeChannel.data[k] * (-1 + this.regions.size)));
      this.regionChannel.data[j] = localAspectTextureRegion.u;
      this.regionChannel.data[(j + 1)] = localAspectTextureRegion.v;
      this.regionChannel.data[(j + 2)] = localAspectTextureRegion.u2;
      this.regionChannel.data[(j + 3)] = localAspectTextureRegion.v2;
      this.regionChannel.data[(j + 4)] = 0.5F;
      this.regionChannel.data[(j + 5)] = localAspectTextureRegion.halfInvAspectRatio;
      j += this.regionChannel.strideSize;
      k += this.lifeChannel.strideSize;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.influencers.RegionInfluencer.Animated
 * JD-Core Version:    0.6.0
 */