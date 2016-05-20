package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.utils.Array;

public class RegionInfluencer$Random extends RegionInfluencer
{
  public RegionInfluencer$Random()
  {
  }

  public RegionInfluencer$Random(Texture paramTexture)
  {
    super(paramTexture);
  }

  public RegionInfluencer$Random(TextureRegion paramTextureRegion)
  {
    super(new TextureRegion[] { paramTextureRegion });
  }

  public RegionInfluencer$Random(Random paramRandom)
  {
    super(paramRandom);
  }

  public void activateParticles(int paramInt1, int paramInt2)
  {
    int i = paramInt1 * this.regionChannel.strideSize;
    int j = i + paramInt2 * this.regionChannel.strideSize;
    int k = i;
    while (k < j)
    {
      RegionInfluencer.AspectTextureRegion localAspectTextureRegion = (RegionInfluencer.AspectTextureRegion)this.regions.random();
      this.regionChannel.data[k] = localAspectTextureRegion.u;
      this.regionChannel.data[(k + 1)] = localAspectTextureRegion.v;
      this.regionChannel.data[(k + 2)] = localAspectTextureRegion.u2;
      this.regionChannel.data[(k + 3)] = localAspectTextureRegion.v2;
      this.regionChannel.data[(k + 4)] = 0.5F;
      this.regionChannel.data[(k + 5)] = localAspectTextureRegion.halfInvAspectRatio;
      k += this.regionChannel.strideSize;
    }
  }

  public Random copy()
  {
    return new Random(this);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.influencers.RegionInfluencer.Random
 * JD-Core Version:    0.6.0
 */