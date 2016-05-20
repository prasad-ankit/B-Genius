package com.badlogic.gdx.graphics.g3d.environment;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;

public class DirectionalLight extends BaseLight
{
  public final Vector3 direction = new Vector3();

  public boolean equals(DirectionalLight paramDirectionalLight)
  {
    return (paramDirectionalLight != null) && ((paramDirectionalLight == this) || ((this.color.equals(paramDirectionalLight.color)) && (this.direction.equals(paramDirectionalLight.direction))));
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof DirectionalLight))
      return equals((DirectionalLight)paramObject);
    return false;
  }

  public DirectionalLight set(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.color.set(paramFloat1, paramFloat2, paramFloat3, 1.0F);
    this.direction.set(paramFloat4, paramFloat5, paramFloat6).nor();
    return this;
  }

  public DirectionalLight set(float paramFloat1, float paramFloat2, float paramFloat3, Vector3 paramVector3)
  {
    this.color.set(paramFloat1, paramFloat2, paramFloat3, 1.0F);
    if (paramVector3 != null)
      this.direction.set(paramVector3).nor();
    return this;
  }

  public DirectionalLight set(Color paramColor, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramColor != null)
      this.color.set(paramColor);
    this.direction.set(paramFloat1, paramFloat2, paramFloat3).nor();
    return this;
  }

  public DirectionalLight set(Color paramColor, Vector3 paramVector3)
  {
    if (paramColor != null)
      this.color.set(paramColor);
    if (paramVector3 != null)
      this.direction.set(paramVector3).nor();
    return this;
  }

  public DirectionalLight set(DirectionalLight paramDirectionalLight)
  {
    return set(paramDirectionalLight.color, paramDirectionalLight.direction);
  }

  public DirectionalLight setDirection(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.direction.set(paramFloat1, paramFloat2, paramFloat3);
    return this;
  }

  public DirectionalLight setDirection(Vector3 paramVector3)
  {
    this.direction.set(paramVector3);
    return this;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.environment.DirectionalLight
 * JD-Core Version:    0.6.0
 */