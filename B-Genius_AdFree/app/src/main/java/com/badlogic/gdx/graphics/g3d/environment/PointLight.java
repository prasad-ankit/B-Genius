package com.badlogic.gdx.graphics.g3d.environment;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;

public class PointLight extends BaseLight
{
  public float intensity;
  public final Vector3 position = new Vector3();

  public boolean equals(PointLight paramPointLight)
  {
    return (paramPointLight != null) && ((paramPointLight == this) || ((this.color.equals(paramPointLight.color)) && (this.position.equals(paramPointLight.position)) && (this.intensity == paramPointLight.intensity)));
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof PointLight))
      return equals((PointLight)paramObject);
    return false;
  }

  public PointLight set(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    this.color.set(paramFloat1, paramFloat2, paramFloat3, 1.0F);
    this.position.set(paramFloat4, paramFloat5, paramFloat6);
    this.intensity = paramFloat7;
    return this;
  }

  public PointLight set(float paramFloat1, float paramFloat2, float paramFloat3, Vector3 paramVector3, float paramFloat4)
  {
    this.color.set(paramFloat1, paramFloat2, paramFloat3, 1.0F);
    if (paramVector3 != null)
      this.position.set(paramVector3);
    this.intensity = paramFloat4;
    return this;
  }

  public PointLight set(Color paramColor, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (paramColor != null)
      this.color.set(paramColor);
    this.position.set(paramFloat1, paramFloat2, paramFloat3);
    this.intensity = paramFloat4;
    return this;
  }

  public PointLight set(Color paramColor, Vector3 paramVector3, float paramFloat)
  {
    if (paramColor != null)
      this.color.set(paramColor);
    if (paramVector3 != null)
      this.position.set(paramVector3);
    this.intensity = paramFloat;
    return this;
  }

  public PointLight set(PointLight paramPointLight)
  {
    return set(paramPointLight.color, paramPointLight.position, paramPointLight.intensity);
  }

  public PointLight setIntensity(float paramFloat)
  {
    this.intensity = paramFloat;
    return this;
  }

  public PointLight setPosition(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.position.set(paramFloat1, paramFloat2, paramFloat3);
    return this;
  }

  public PointLight setPosition(Vector3 paramVector3)
  {
    this.position.set(paramVector3);
    return this;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.environment.PointLight
 * JD-Core Version:    0.6.0
 */