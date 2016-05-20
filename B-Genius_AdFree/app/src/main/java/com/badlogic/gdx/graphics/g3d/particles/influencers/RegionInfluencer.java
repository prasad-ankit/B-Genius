package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public abstract class RegionInfluencer extends Influencer
{
  ParallelArray.FloatChannel regionChannel;
  public Array regions;

  public RegionInfluencer()
  {
    this(1);
    RegionInfluencer.AspectTextureRegion localAspectTextureRegion = new RegionInfluencer.AspectTextureRegion();
    localAspectTextureRegion.v = 0.0F;
    localAspectTextureRegion.u = 0.0F;
    localAspectTextureRegion.v2 = 1.0F;
    localAspectTextureRegion.u2 = 1.0F;
    localAspectTextureRegion.halfInvAspectRatio = 0.5F;
    this.regions.add(localAspectTextureRegion);
  }

  public RegionInfluencer(int paramInt)
  {
    this.regions = new Array(false, paramInt, RegionInfluencer.AspectTextureRegion.class);
  }

  public RegionInfluencer(Texture paramTexture)
  {
    this(arrayOfTextureRegion);
  }

  public RegionInfluencer(RegionInfluencer paramRegionInfluencer)
  {
    this(paramRegionInfluencer.regions.size);
    this.regions.ensureCapacity(paramRegionInfluencer.regions.size);
    for (int i = 0; i < paramRegionInfluencer.regions.size; i++)
      this.regions.add(new RegionInfluencer.AspectTextureRegion((RegionInfluencer.AspectTextureRegion)paramRegionInfluencer.regions.get(i)));
  }

  public RegionInfluencer(TextureRegion[] paramArrayOfTextureRegion)
  {
    this.regions = new Array(false, paramArrayOfTextureRegion.length, RegionInfluencer.AspectTextureRegion.class);
    add(paramArrayOfTextureRegion);
  }

  public void add(TextureRegion[] paramArrayOfTextureRegion)
  {
    this.regions.ensureCapacity(paramArrayOfTextureRegion.length);
    int i = paramArrayOfTextureRegion.length;
    for (int j = 0; j < i; j++)
    {
      TextureRegion localTextureRegion = paramArrayOfTextureRegion[j];
      this.regions.add(new RegionInfluencer.AspectTextureRegion(localTextureRegion));
    }
  }

  public void allocateChannels()
  {
    this.regionChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.TextureRegion));
  }

  public void clear()
  {
    this.regions.clear();
  }

  public void read(Json paramJson, JsonValue paramJsonValue)
  {
    this.regions.clear();
    this.regions.addAll((Array)paramJson.readValue("regions", Array.class, RegionInfluencer.AspectTextureRegion.class, paramJsonValue));
  }

  public void write(Json paramJson)
  {
    paramJson.writeValue("regions", this.regions, Array.class, RegionInfluencer.AspectTextureRegion.class);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.influencers.RegionInfluencer
 * JD-Core Version:    0.6.0
 */