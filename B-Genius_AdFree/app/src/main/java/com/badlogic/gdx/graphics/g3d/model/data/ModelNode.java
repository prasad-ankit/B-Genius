package com.badlogic.gdx.graphics.g3d.model.data;

import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;

public class ModelNode
{
  public int boneId = -1;
  public ModelNode[] children;
  public String id;
  public String meshId;
  public ModelNodePart[] parts;
  public Quaternion rotation;
  public Vector3 scale;
  public Vector3 translation;
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.model.data.ModelNode
 * JD-Core Version:    0.6.0
 */