package com.badlogic.gdx.physics.box2d;

public class FixtureDef
{
  public float density = 0.0F;
  public final Filter filter = new Filter();
  public float friction = 0.2F;
  public boolean isSensor = false;
  public float restitution = 0.0F;
  public Shape shape;
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.physics.box2d.FixtureDef
 * JD-Core Version:    0.6.0
 */