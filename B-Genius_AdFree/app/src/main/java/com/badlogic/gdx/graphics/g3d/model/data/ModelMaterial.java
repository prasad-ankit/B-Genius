package com.badlogic.gdx.graphics.g3d.model.data;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;

public class ModelMaterial
{
  public Color ambient;
  public Color diffuse;
  public Color emissive;
  public String id;
  public float opacity = 1.0F;
  public Color reflection;
  public float shininess;
  public Color specular;
  public Array textures;
  public ModelMaterial.MaterialType type;
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial
 * JD-Core Version:    0.6.0
 */