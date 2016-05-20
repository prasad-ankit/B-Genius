package com.badlogic.gdx.graphics.g3d.model;

import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.ArrayMap;

public class NodePart
{
  public Matrix4[] bones;
  public boolean enabled = true;
  public ArrayMap invBoneBindTransforms;
  public Material material;
  public MeshPart meshPart;

  public NodePart()
  {
  }

  public NodePart(MeshPart paramMeshPart, Material paramMaterial)
  {
    this.meshPart = paramMeshPart;
    this.material = paramMaterial;
  }

  public NodePart copy()
  {
    return new NodePart().set(this);
  }

  protected NodePart set(NodePart paramNodePart)
  {
    this.meshPart = new MeshPart(paramNodePart.meshPart);
    this.material = paramNodePart.material;
    this.enabled = paramNodePart.enabled;
    if (paramNodePart.invBoneBindTransforms == null)
    {
      this.invBoneBindTransforms = null;
      this.bones = null;
      return this;
    }
    if (this.invBoneBindTransforms == null)
      this.invBoneBindTransforms = new ArrayMap(true, paramNodePart.invBoneBindTransforms.size, Node.class, Matrix4.class);
    while (true)
    {
      this.invBoneBindTransforms.putAll(paramNodePart.invBoneBindTransforms);
      if ((this.bones == null) || (this.bones.length != this.invBoneBindTransforms.size))
        this.bones = new Matrix4[this.invBoneBindTransforms.size];
      for (int i = 0; i < this.bones.length; i++)
      {
        if (this.bones[i] != null)
          continue;
        this.bones[i] = new Matrix4();
      }
      break;
      this.invBoneBindTransforms.clear();
    }
  }

  public Renderable setRenderable(Renderable paramRenderable)
  {
    paramRenderable.material = this.material;
    paramRenderable.meshPart.set(this.meshPart);
    paramRenderable.bones = this.bones;
    return paramRenderable;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.model.NodePart
 * JD-Core Version:    0.6.0
 */