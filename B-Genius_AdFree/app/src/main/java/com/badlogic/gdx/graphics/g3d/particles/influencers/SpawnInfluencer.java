package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.graphics.g3d.particles.emitters.Emitter;
import com.badlogic.gdx.graphics.g3d.particles.values.PointSpawnShapeValue;
import com.badlogic.gdx.graphics.g3d.particles.values.SpawnShapeValue;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public class SpawnInfluencer extends Influencer
{
  ParallelArray.FloatChannel positionChannel;
  public SpawnShapeValue spawnShapeValue;

  public SpawnInfluencer()
  {
    this.spawnShapeValue = new PointSpawnShapeValue();
  }

  public SpawnInfluencer(SpawnInfluencer paramSpawnInfluencer)
  {
    this.spawnShapeValue = paramSpawnInfluencer.spawnShapeValue.copy();
  }

  public SpawnInfluencer(SpawnShapeValue paramSpawnShapeValue)
  {
    this.spawnShapeValue = paramSpawnShapeValue;
  }

  public void activateParticles(int paramInt1, int paramInt2)
  {
    int i = paramInt1 * this.positionChannel.strideSize;
    int j = i + paramInt2 * this.positionChannel.strideSize;
    while (i < j)
    {
      this.spawnShapeValue.spawn(TMP_V1, this.controller.emitter.percent);
      TMP_V1.mul(this.controller.transform);
      this.positionChannel.data[i] = TMP_V1.x;
      this.positionChannel.data[(i + 1)] = TMP_V1.y;
      this.positionChannel.data[(i + 2)] = TMP_V1.z;
      i += this.positionChannel.strideSize;
    }
  }

  public void allocateChannels()
  {
    this.positionChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Position));
  }

  public SpawnInfluencer copy()
  {
    return new SpawnInfluencer(this);
  }

  public void init()
  {
    this.spawnShapeValue.init();
  }

  public void load(AssetManager paramAssetManager, ResourceData paramResourceData)
  {
    this.spawnShapeValue.load(paramAssetManager, paramResourceData);
  }

  public void read(Json paramJson, JsonValue paramJsonValue)
  {
    this.spawnShapeValue = ((SpawnShapeValue)paramJson.readValue("spawnShape", SpawnShapeValue.class, paramJsonValue));
  }

  public void save(AssetManager paramAssetManager, ResourceData paramResourceData)
  {
    this.spawnShapeValue.save(paramAssetManager, paramResourceData);
  }

  public void start()
  {
    this.spawnShapeValue.start();
  }

  public void write(Json paramJson)
  {
    paramJson.writeValue("spawnShape", this.spawnShapeValue, SpawnShapeValue.class);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.influencers.SpawnInfluencer
 * JD-Core Version:    0.6.0
 */