package com.badlogic.gdx.physics.box2d;

import com.badlogic.gdx.math.Vector2;

public class Manifold$ManifoldPoint
{
  public int contactID = 0;
  public final Vector2 localPoint = new Vector2();
  public float normalImpulse;
  public float tangentImpulse;

  public Manifold$ManifoldPoint(Manifold paramManifold)
  {
  }

  public String toString()
  {
    return "id: " + this.contactID + ", " + this.localPoint + ", " + this.normalImpulse + ", " + this.tangentImpulse;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.physics.box2d.Manifold.ManifoldPoint
 * JD-Core Version:    0.6.0
 */