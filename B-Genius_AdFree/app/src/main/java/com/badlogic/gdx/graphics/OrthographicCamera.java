package com.badlogic.gdx.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.math.Frustum;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class OrthographicCamera extends Camera
{
  private final Vector3 tmp = new Vector3();
  public float zoom = 1.0F;

  public OrthographicCamera()
  {
    this.near = 0.0F;
  }

  public OrthographicCamera(float paramFloat1, float paramFloat2)
  {
    this.viewportWidth = paramFloat1;
    this.viewportHeight = paramFloat2;
    this.near = 0.0F;
    update();
  }

  public void rotate(float paramFloat)
  {
    rotate(this.direction, paramFloat);
  }

  public void setToOrtho(boolean paramBoolean)
  {
    setToOrtho(paramBoolean, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
  }

  public void setToOrtho(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if (paramBoolean)
    {
      this.up.set(0.0F, -1.0F, 0.0F);
      this.direction.set(0.0F, 0.0F, 1.0F);
    }
    while (true)
    {
      this.position.set(paramFloat1 * this.zoom / 2.0F, paramFloat2 * this.zoom / 2.0F, 0.0F);
      this.viewportWidth = paramFloat1;
      this.viewportHeight = paramFloat2;
      update();
      return;
      this.up.set(0.0F, 1.0F, 0.0F);
      this.direction.set(0.0F, 0.0F, -1.0F);
    }
  }

  public void translate(float paramFloat1, float paramFloat2)
  {
    translate(paramFloat1, paramFloat2, 0.0F);
  }

  public void translate(Vector2 paramVector2)
  {
    translate(paramVector2.x, paramVector2.y, 0.0F);
  }

  public void update()
  {
    update(true);
  }

  public void update(boolean paramBoolean)
  {
    this.projection.setToOrtho(this.zoom * -this.viewportWidth / 2.0F, this.zoom * (this.viewportWidth / 2.0F), this.zoom * -(this.viewportHeight / 2.0F), this.zoom * this.viewportHeight / 2.0F, this.near, this.far);
    this.view.setToLookAt(this.position, this.tmp.set(this.position).add(this.direction), this.up);
    this.combined.set(this.projection);
    Matrix4.mul(this.combined.val, this.view.val);
    if (paramBoolean)
    {
      this.invProjectionView.set(this.combined);
      Matrix4.inv(this.invProjectionView.val);
      this.frustum.update(this.invProjectionView);
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.OrthographicCamera
 * JD-Core Version:    0.6.0
 */