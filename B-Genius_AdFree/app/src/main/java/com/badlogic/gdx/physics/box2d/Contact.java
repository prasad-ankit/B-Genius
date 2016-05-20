package com.badlogic.gdx.physics.box2d;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.LongMap;

public class Contact
{
  protected long addr;
  private final float[] tmp = new float[8];
  protected World world;
  protected final WorldManifold worldManifold = new WorldManifold();

  protected Contact(World paramWorld, long paramLong)
  {
    this.addr = paramLong;
    this.world = paramWorld;
  }

  private native int jniGetChildIndexA(long paramLong);

  private native int jniGetChildIndexB(long paramLong);

  private native long jniGetFixtureA(long paramLong);

  private native long jniGetFixtureB(long paramLong);

  private native float jniGetFriction(long paramLong);

  private native float jniGetRestitution(long paramLong);

  private native float jniGetTangentSpeed(long paramLong);

  private native int jniGetWorldManifold(long paramLong, float[] paramArrayOfFloat);

  private native boolean jniIsEnabled(long paramLong);

  private native boolean jniIsTouching(long paramLong);

  private native void jniResetFriction(long paramLong);

  private native void jniResetRestitution(long paramLong);

  private native void jniSetEnabled(long paramLong, boolean paramBoolean);

  private native void jniSetFriction(long paramLong, float paramFloat);

  private native void jniSetRestitution(long paramLong, float paramFloat);

  private native void jniSetTangentSpeed(long paramLong, float paramFloat);

  public void ResetRestitution()
  {
    jniResetRestitution(this.addr);
  }

  public int getChildIndexA()
  {
    return jniGetChildIndexA(this.addr);
  }

  public int getChildIndexB()
  {
    return jniGetChildIndexB(this.addr);
  }

  public Fixture getFixtureA()
  {
    return (Fixture)this.world.fixtures.get(jniGetFixtureA(this.addr));
  }

  public Fixture getFixtureB()
  {
    return (Fixture)this.world.fixtures.get(jniGetFixtureB(this.addr));
  }

  public float getFriction()
  {
    return jniGetFriction(this.addr);
  }

  public float getRestitution()
  {
    return jniGetRestitution(this.addr);
  }

  public float getTangentSpeed()
  {
    return jniGetTangentSpeed(this.addr);
  }

  public WorldManifold getWorldManifold()
  {
    int i = jniGetWorldManifold(this.addr, this.tmp);
    this.worldManifold.numContactPoints = i;
    this.worldManifold.normal.set(this.tmp[0], this.tmp[1]);
    for (int j = 0; j < i; j++)
    {
      Vector2 localVector2 = this.worldManifold.points[j];
      localVector2.x = this.tmp[(2 + (j << 1))];
      localVector2.y = this.tmp[(1 + (2 + (j << 1)))];
    }
    this.worldManifold.separations[0] = this.tmp[6];
    this.worldManifold.separations[1] = this.tmp[7];
    return this.worldManifold;
  }

  public boolean isEnabled()
  {
    return jniIsEnabled(this.addr);
  }

  public boolean isTouching()
  {
    return jniIsTouching(this.addr);
  }

  public void resetFriction()
  {
    jniResetFriction(this.addr);
  }

  public void setEnabled(boolean paramBoolean)
  {
    jniSetEnabled(this.addr, paramBoolean);
  }

  public void setFriction(float paramFloat)
  {
    jniSetFriction(this.addr, paramFloat);
  }

  public void setRestitution(float paramFloat)
  {
    jniSetRestitution(this.addr, paramFloat);
  }

  public void setTangentSpeed(float paramFloat)
  {
    jniSetTangentSpeed(this.addr, paramFloat);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.physics.box2d.Contact
 * JD-Core Version:    0.6.0
 */