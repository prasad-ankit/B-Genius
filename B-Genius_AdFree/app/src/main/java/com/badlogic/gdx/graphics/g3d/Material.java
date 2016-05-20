package com.badlogic.gdx.graphics.g3d;

import com.badlogic.gdx.utils.Array;
import java.util.Iterator;

public class Material extends Attributes
{
  private static int counter = 0;
  public String id;

  public Material()
  {
    this(i);
  }

  public Material(Material paramMaterial)
  {
    this(paramMaterial.id, paramMaterial);
  }

  public Material(Array paramArray)
  {
    this();
    set(paramArray);
  }

  public Material(String paramString)
  {
    this.id = paramString;
  }

  public Material(String paramString, Material paramMaterial)
  {
    this(paramString);
    Iterator localIterator = paramMaterial.iterator();
    while (localIterator.hasNext())
      set(((Attribute)localIterator.next()).copy());
  }

  public Material(String paramString, Array paramArray)
  {
    this(paramString);
    set(paramArray);
  }

  public Material(String paramString, Attribute[] paramArrayOfAttribute)
  {
    this(paramString);
    set(paramArrayOfAttribute);
  }

  public Material(Attribute[] paramArrayOfAttribute)
  {
    this();
    set(paramArrayOfAttribute);
  }

  public final Material copy()
  {
    return new Material(this);
  }

  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof Material)) && ((paramObject == this) || ((((Material)paramObject).id.equals(this.id)) && (super.equals(paramObject))));
  }

  public int hashCode()
  {
    return super.hashCode() + 3 * this.id.hashCode();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.Material
 * JD-Core Version:    0.6.0
 */