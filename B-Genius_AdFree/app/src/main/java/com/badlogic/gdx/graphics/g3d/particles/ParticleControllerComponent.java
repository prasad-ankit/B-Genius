package com.badlogic.gdx.graphics.g3d.particles;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;

public abstract class ParticleControllerComponent
  implements ResourceData.Configurable, Disposable, Json.Serializable
{
  protected static final Matrix3 TMP_M3;
  protected static final Matrix4 TMP_M4;
  protected static final Quaternion TMP_Q;
  protected static final Quaternion TMP_Q2;
  protected static final Vector3 TMP_V1 = new Vector3();
  protected static final Vector3 TMP_V2 = new Vector3();
  protected static final Vector3 TMP_V3 = new Vector3();
  protected static final Vector3 TMP_V4 = new Vector3();
  protected static final Vector3 TMP_V5 = new Vector3();
  protected static final Vector3 TMP_V6 = new Vector3();
  protected ParticleController controller;

  static
  {
    TMP_Q = new Quaternion();
    TMP_Q2 = new Quaternion();
    TMP_M3 = new Matrix3();
    TMP_M4 = new Matrix4();
  }

  public void activateParticles(int paramInt1, int paramInt2)
  {
  }

  public void allocateChannels()
  {
  }

  public abstract ParticleControllerComponent copy();

  public void dispose()
  {
  }

  public void end()
  {
  }

  public void init()
  {
  }

  public void killParticles(int paramInt1, int paramInt2)
  {
  }

  public void load(AssetManager paramAssetManager, ResourceData paramResourceData)
  {
  }

  public void read(Json paramJson, JsonValue paramJsonValue)
  {
  }

  public void save(AssetManager paramAssetManager, ResourceData paramResourceData)
  {
  }

  public void set(ParticleController paramParticleController)
  {
    this.controller = paramParticleController;
  }

  public void start()
  {
  }

  public void update()
  {
  }

  public void write(Json paramJson)
  {
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent
 * JD-Core Version:    0.6.0
 */