package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class RegionInfluencer$AspectTextureRegion
{
  public float halfInvAspectRatio;
  public float u;
  public float u2;
  public float v;
  public float v2;

  public RegionInfluencer$AspectTextureRegion()
  {
  }

  public RegionInfluencer$AspectTextureRegion(TextureRegion paramTextureRegion)
  {
    set(paramTextureRegion);
  }

  public RegionInfluencer$AspectTextureRegion(AspectTextureRegion paramAspectTextureRegion)
  {
    set(paramAspectTextureRegion);
  }

  public void set(TextureRegion paramTextureRegion)
  {
    this.u = paramTextureRegion.getU();
    this.v = paramTextureRegion.getV();
    this.u2 = paramTextureRegion.getU2();
    this.v2 = paramTextureRegion.getV2();
    this.halfInvAspectRatio = (0.5F * (paramTextureRegion.getRegionHeight() / paramTextureRegion.getRegionWidth()));
  }

  public void set(AspectTextureRegion paramAspectTextureRegion)
  {
    this.u = paramAspectTextureRegion.u;
    this.v = paramAspectTextureRegion.v;
    this.u2 = paramAspectTextureRegion.u2;
    this.v2 = paramAspectTextureRegion.v2;
    this.halfInvAspectRatio = paramAspectTextureRegion.halfInvAspectRatio;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.influencers.RegionInfluencer.AspectTextureRegion
 * JD-Core Version:    0.6.0
 */