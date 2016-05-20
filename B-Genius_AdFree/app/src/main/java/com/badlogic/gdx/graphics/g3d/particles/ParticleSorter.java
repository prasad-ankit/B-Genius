package com.badlogic.gdx.graphics.g3d.particles;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

public abstract class ParticleSorter
{
  static final Vector3 TMP_V1 = new Vector3();
  protected Camera camera;

  public void ensureCapacity(int paramInt)
  {
  }

  public void setCamera(Camera paramCamera)
  {
    this.camera = paramCamera;
  }

  public abstract int[] sort(Array paramArray);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.ParticleSorter
 * JD-Core Version:    0.6.0
 */