package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;

public class DynamicsModifier$FaceDirection extends DynamicsModifier
{
  ParallelArray.FloatChannel accellerationChannel;
  ParallelArray.FloatChannel rotationChannel;

  public DynamicsModifier$FaceDirection()
  {
  }

  public DynamicsModifier$FaceDirection(FaceDirection paramFaceDirection)
  {
    super(paramFaceDirection);
  }

  public void allocateChannels()
  {
    this.rotationChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Rotation3D));
    this.accellerationChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Acceleration));
  }

  public ParticleControllerComponent copy()
  {
    return new FaceDirection(this);
  }

  public void update()
  {
    int i = 0 + this.controller.particles.size * this.rotationChannel.strideSize;
    int j = 0;
    int m;
    for (int k = 0; k < i; k = m)
    {
      Vector3 localVector31 = TMP_V1.set(this.accellerationChannel.data[j], this.accellerationChannel.data[(j + 1)], this.accellerationChannel.data[(j + 2)]).nor();
      Vector3 localVector32 = TMP_V2.set(TMP_V1).crs(Vector3.Y).nor().crs(TMP_V1).nor();
      Vector3 localVector33 = TMP_V3.set(localVector32).crs(localVector31).nor();
      TMP_Q.setFromAxes(false, localVector33.x, localVector32.x, localVector31.x, localVector33.y, localVector32.y, localVector31.y, localVector33.z, localVector32.z, localVector31.z);
      this.rotationChannel.data[k] = TMP_Q.x;
      this.rotationChannel.data[(k + 1)] = TMP_Q.y;
      this.rotationChannel.data[(k + 2)] = TMP_Q.z;
      this.rotationChannel.data[(k + 3)] = TMP_Q.w;
      m = k + this.rotationChannel.strideSize;
      j += this.accellerationChannel.strideSize;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.influencers.DynamicsModifier.FaceDirection
 * JD-Core Version:    0.6.0
 */