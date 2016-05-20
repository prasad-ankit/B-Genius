package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public abstract class DynamicsModifier extends Influencer
{
  protected static final Quaternion TMP_Q;
  protected static final Vector3 TMP_V1 = new Vector3();
  protected static final Vector3 TMP_V2 = new Vector3();
  protected static final Vector3 TMP_V3 = new Vector3();
  public boolean isGlobal = false;
  protected ParallelArray.FloatChannel lifeChannel;

  static
  {
    TMP_Q = new Quaternion();
  }

  public DynamicsModifier()
  {
  }

  public DynamicsModifier(DynamicsModifier paramDynamicsModifier)
  {
    this.isGlobal = paramDynamicsModifier.isGlobal;
  }

  public void allocateChannels()
  {
    this.lifeChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Life));
  }

  public void read(Json paramJson, JsonValue paramJsonValue)
  {
    super.read(paramJson, paramJsonValue);
    this.isGlobal = ((Boolean)paramJson.readValue("isGlobal", Boolean.TYPE, paramJsonValue)).booleanValue();
  }

  public void write(Json paramJson)
  {
    super.write(paramJson);
    paramJson.writeValue("isGlobal", Boolean.valueOf(this.isGlobal));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.influencers.DynamicsModifier
 * JD-Core Version:    0.6.0
 */