package com.badlogic.gdx.graphics.g3d.particles.values;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;

public class ParticleValue
  implements Json.Serializable
{
  public boolean active;

  public ParticleValue()
  {
  }

  public ParticleValue(ParticleValue paramParticleValue)
  {
    this.active = paramParticleValue.active;
  }

  public boolean isActive()
  {
    return this.active;
  }

  public void load(ParticleValue paramParticleValue)
  {
    this.active = paramParticleValue.active;
  }

  public void read(Json paramJson, JsonValue paramJsonValue)
  {
    this.active = ((Boolean)paramJson.readValue("active", Boolean.class, paramJsonValue)).booleanValue();
  }

  public void setActive(boolean paramBoolean)
  {
    this.active = paramBoolean;
  }

  public void write(Json paramJson)
  {
    paramJson.writeValue("active", Boolean.valueOf(this.active));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.values.ParticleValue
 * JD-Core Version:    0.6.0
 */