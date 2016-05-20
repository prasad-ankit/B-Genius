package com.badlogic.gdx.graphics.g3d.model.data;

import com.badlogic.gdx.math.Vector2;

public class ModelTexture
{
  public static final int USAGE_AMBIENT = 4;
  public static final int USAGE_BUMP = 8;
  public static final int USAGE_DIFFUSE = 2;
  public static final int USAGE_EMISSIVE = 3;
  public static final int USAGE_NONE = 1;
  public static final int USAGE_NORMAL = 7;
  public static final int USAGE_REFLECTION = 10;
  public static final int USAGE_SHININESS = 6;
  public static final int USAGE_SPECULAR = 5;
  public static final int USAGE_TRANSPARENCY = 9;
  public static final int USAGE_UNKNOWN;
  public String fileName;
  public String id;
  public int usage;
  public Vector2 uvScaling;
  public Vector2 uvTranslation;
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.model.data.ModelTexture
 * JD-Core Version:    0.6.0
 */