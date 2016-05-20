package com.badlogic.gdx.graphics.g3d;

import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.math.Matrix4;

public class Renderable
{
  public Matrix4[] bones;
  public Environment environment;
  public Material material;
  public final MeshPart meshPart = new MeshPart();
  public Shader shader;
  public Object userData;
  public final Matrix4 worldTransform = new Matrix4();

  public Renderable set(Renderable paramRenderable)
  {
    this.worldTransform.set(paramRenderable.worldTransform);
    this.material = paramRenderable.material;
    this.meshPart.set(paramRenderable.meshPart);
    this.bones = paramRenderable.bones;
    this.environment = paramRenderable.environment;
    this.shader = paramRenderable.shader;
    this.userData = paramRenderable.userData;
    return this;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.Renderable
 * JD-Core Version:    0.6.0
 */