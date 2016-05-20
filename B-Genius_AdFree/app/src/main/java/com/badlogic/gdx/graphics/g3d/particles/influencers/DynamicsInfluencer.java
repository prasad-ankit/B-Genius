package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import java.util.Arrays;

public class DynamicsInfluencer extends Influencer
{
  private ParallelArray.FloatChannel accellerationChannel;
  private ParallelArray.FloatChannel angularVelocityChannel;
  boolean has2dAngularVelocity;
  boolean has3dAngularVelocity;
  boolean hasAcceleration;
  private ParallelArray.FloatChannel positionChannel;
  private ParallelArray.FloatChannel previousPositionChannel;
  private ParallelArray.FloatChannel rotationChannel;
  public Array velocities;

  public DynamicsInfluencer()
  {
    this.velocities = new Array(true, 3, DynamicsModifier.class);
  }

  public DynamicsInfluencer(DynamicsInfluencer paramDynamicsInfluencer)
  {
    this((DynamicsModifier[])paramDynamicsInfluencer.velocities.toArray(DynamicsModifier.class));
  }

  public DynamicsInfluencer(DynamicsModifier[] paramArrayOfDynamicsModifier)
  {
    this.velocities = new Array(true, paramArrayOfDynamicsModifier.length, DynamicsModifier.class);
    int i = paramArrayOfDynamicsModifier.length;
    for (int j = 0; j < i; j++)
    {
      DynamicsModifier localDynamicsModifier = paramArrayOfDynamicsModifier[j];
      this.velocities.add((DynamicsModifier)localDynamicsModifier.copy());
    }
  }

  public void activateParticles(int paramInt1, int paramInt2)
  {
    if (this.hasAcceleration)
    {
      int i1 = paramInt1 * this.positionChannel.strideSize;
      int i2 = i1 + paramInt2 * this.positionChannel.strideSize;
      while (i1 < i2)
      {
        this.previousPositionChannel.data[i1] = this.positionChannel.data[i1];
        this.previousPositionChannel.data[(i1 + 1)] = this.positionChannel.data[(i1 + 1)];
        this.previousPositionChannel.data[(i1 + 2)] = this.positionChannel.data[(i1 + 2)];
        i1 += this.positionChannel.strideSize;
      }
    }
    if (this.has2dAngularVelocity)
    {
      int m = paramInt1 * this.rotationChannel.strideSize;
      int n = m + paramInt2 * this.rotationChannel.strideSize;
      while (m < n)
      {
        this.rotationChannel.data[m] = 1.0F;
        this.rotationChannel.data[(m + 1)] = 0.0F;
        m += this.rotationChannel.strideSize;
      }
    }
    if (this.has3dAngularVelocity)
    {
      int j = paramInt1 * this.rotationChannel.strideSize;
      int k = j + paramInt2 * this.rotationChannel.strideSize;
      while (j < k)
      {
        this.rotationChannel.data[j] = 0.0F;
        this.rotationChannel.data[(j + 1)] = 0.0F;
        this.rotationChannel.data[(j + 2)] = 0.0F;
        this.rotationChannel.data[(j + 3)] = 1.0F;
        j += this.rotationChannel.strideSize;
      }
    }
    for (int i = 0; i < this.velocities.size; i++)
      ((DynamicsModifier[])this.velocities.items)[i].activateParticles(paramInt1, paramInt2);
  }

  public void allocateChannels()
  {
    boolean bool1 = true;
    for (int i = 0; i < this.velocities.size; i++)
      ((DynamicsModifier[])this.velocities.items)[i].allocateChannels();
    this.accellerationChannel = ((ParallelArray.FloatChannel)this.controller.particles.getChannel(ParticleChannels.Acceleration));
    boolean bool2;
    if (this.accellerationChannel != null)
    {
      bool2 = bool1;
      this.hasAcceleration = bool2;
      if (this.hasAcceleration)
      {
        this.positionChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Position));
        this.previousPositionChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.PreviousPosition));
      }
      this.angularVelocityChannel = ((ParallelArray.FloatChannel)this.controller.particles.getChannel(ParticleChannels.AngularVelocity2D));
      if (this.angularVelocityChannel == null)
        break label191;
    }
    label191: for (boolean bool3 = bool1; ; bool3 = false)
    {
      this.has2dAngularVelocity = bool3;
      if (!this.has2dAngularVelocity)
        break label197;
      this.rotationChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Rotation2D));
      this.has3dAngularVelocity = false;
      return;
      bool2 = false;
      break;
    }
    label197: this.angularVelocityChannel = ((ParallelArray.FloatChannel)this.controller.particles.getChannel(ParticleChannels.AngularVelocity3D));
    if (this.angularVelocityChannel != null);
    while (true)
    {
      this.has3dAngularVelocity = bool1;
      if (!this.has3dAngularVelocity)
        break;
      this.rotationChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Rotation3D));
      return;
      bool1 = false;
    }
  }

  public DynamicsInfluencer copy()
  {
    return new DynamicsInfluencer(this);
  }

  public void init()
  {
    for (int i = 0; i < this.velocities.size; i++)
      ((DynamicsModifier[])this.velocities.items)[i].init();
  }

  public void read(Json paramJson, JsonValue paramJsonValue)
  {
    this.velocities.addAll((Array)paramJson.readValue("velocities", Array.class, DynamicsModifier.class, paramJsonValue));
  }

  public void set(ParticleController paramParticleController)
  {
    super.set(paramParticleController);
    for (int i = 0; i < this.velocities.size; i++)
      ((DynamicsModifier[])this.velocities.items)[i].set(paramParticleController);
  }

  public void update()
  {
    int i = 0;
    if (this.hasAcceleration)
      Arrays.fill(this.accellerationChannel.data, 0, this.controller.particles.size * this.accellerationChannel.strideSize, 0.0F);
    if ((this.has2dAngularVelocity) || (this.has3dAngularVelocity))
      Arrays.fill(this.angularVelocityChannel.data, 0, this.controller.particles.size * this.angularVelocityChannel.strideSize, 0.0F);
    for (int j = 0; j < this.velocities.size; j++)
      ((DynamicsModifier[])this.velocities.items)[j].update();
    if (this.hasAcceleration)
    {
      int i1 = 0;
      int i2 = 0;
      while (i2 < this.controller.particles.size)
      {
        float f15 = this.positionChannel.data[i1];
        float f16 = this.positionChannel.data[(i1 + 1)];
        float f17 = this.positionChannel.data[(i1 + 2)];
        this.positionChannel.data[i1] = (f15 * 2.0F - this.previousPositionChannel.data[i1] + this.accellerationChannel.data[i1] * this.controller.deltaTimeSqr);
        this.positionChannel.data[(i1 + 1)] = (f16 * 2.0F - this.previousPositionChannel.data[(i1 + 1)] + this.accellerationChannel.data[(i1 + 1)] * this.controller.deltaTimeSqr);
        this.positionChannel.data[(i1 + 2)] = (f17 * 2.0F - this.previousPositionChannel.data[(i1 + 2)] + this.accellerationChannel.data[(i1 + 2)] * this.controller.deltaTimeSqr);
        this.previousPositionChannel.data[i1] = f15;
        this.previousPositionChannel.data[(i1 + 1)] = f16;
        this.previousPositionChannel.data[(i1 + 2)] = f17;
        i2++;
        i1 += this.positionChannel.strideSize;
      }
    }
    if (this.has2dAngularVelocity)
    {
      int n = 0;
      while (n < this.controller.particles.size)
      {
        float f8 = this.angularVelocityChannel.data[n] * this.controller.deltaTime;
        if (f8 != 0.0F)
        {
          float f9 = MathUtils.cosDeg(f8);
          float f10 = MathUtils.sinDeg(f8);
          float f11 = this.rotationChannel.data[i];
          float f12 = this.rotationChannel.data[(i + 1)];
          float f13 = f11 * f9 - f12 * f10;
          float f14 = f9 * f12 + f10 * f11;
          this.rotationChannel.data[i] = f13;
          this.rotationChannel.data[(i + 1)] = f14;
        }
        n++;
        i += this.rotationChannel.strideSize;
      }
    }
    if (this.has3dAngularVelocity)
    {
      int k = 0;
      int m = 0;
      while (m < this.controller.particles.size)
      {
        float f1 = this.angularVelocityChannel.data[i];
        float f2 = this.angularVelocityChannel.data[(i + 1)];
        float f3 = this.angularVelocityChannel.data[(i + 2)];
        float f4 = this.rotationChannel.data[k];
        float f5 = this.rotationChannel.data[(k + 1)];
        float f6 = this.rotationChannel.data[(k + 2)];
        float f7 = this.rotationChannel.data[(k + 3)];
        TMP_Q.set(f1, f2, f3, 0.0F).mul(f4, f5, f6, f7).mul(0.5F * this.controller.deltaTime).add(f4, f5, f6, f7).nor();
        this.rotationChannel.data[k] = TMP_Q.x;
        this.rotationChannel.data[(k + 1)] = TMP_Q.y;
        this.rotationChannel.data[(k + 2)] = TMP_Q.z;
        this.rotationChannel.data[(k + 3)] = TMP_Q.w;
        m++;
        k += this.rotationChannel.strideSize;
        i += this.angularVelocityChannel.strideSize;
      }
    }
  }

  public void write(Json paramJson)
  {
    paramJson.writeValue("velocities", this.velocities, Array.class, DynamicsModifier.class);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.influencers.DynamicsInfluencer
 * JD-Core Version:    0.6.0
 */