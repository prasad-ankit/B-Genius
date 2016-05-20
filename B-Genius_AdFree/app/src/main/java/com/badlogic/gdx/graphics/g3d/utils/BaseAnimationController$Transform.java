package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Pool.Poolable;

public final class BaseAnimationController$Transform
  implements Pool.Poolable
{
  public final Quaternion rotation = new Quaternion();
  public final Vector3 scale = new Vector3(1.0F, 1.0F, 1.0F);
  public final Vector3 translation = new Vector3();

  public final Transform idt()
  {
    this.translation.set(0.0F, 0.0F, 0.0F);
    this.rotation.idt();
    this.scale.set(1.0F, 1.0F, 1.0F);
    return this;
  }

  public final Transform lerp(Transform paramTransform, float paramFloat)
  {
    return lerp(paramTransform.translation, paramTransform.rotation, paramTransform.scale, paramFloat);
  }

  public final Transform lerp(Vector3 paramVector31, Quaternion paramQuaternion, Vector3 paramVector32, float paramFloat)
  {
    this.translation.lerp(paramVector31, paramFloat);
    this.rotation.slerp(paramQuaternion, paramFloat);
    this.scale.lerp(paramVector32, paramFloat);
    return this;
  }

  public final void reset()
  {
    idt();
  }

  public final Transform set(Transform paramTransform)
  {
    return set(paramTransform.translation, paramTransform.rotation, paramTransform.scale);
  }

  public final Transform set(Vector3 paramVector31, Quaternion paramQuaternion, Vector3 paramVector32)
  {
    this.translation.set(paramVector31);
    this.rotation.set(paramQuaternion);
    this.scale.set(paramVector32);
    return this;
  }

  public final Matrix4 toMatrix4(Matrix4 paramMatrix4)
  {
    return paramMatrix4.set(this.translation, this.rotation, this.scale);
  }

  public final String toString()
  {
    return this.translation.toString() + " - " + this.rotation.toString() + " - " + this.scale.toString();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.utils.BaseAnimationController.Transform
 * JD-Core Version:    0.6.0
 */