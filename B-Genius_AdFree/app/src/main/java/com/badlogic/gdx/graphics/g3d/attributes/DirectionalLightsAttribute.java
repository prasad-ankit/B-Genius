package com.badlogic.gdx.graphics.g3d.attributes;

import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.utils.Array;
import java.util.Iterator;

public class DirectionalLightsAttribute extends Attribute
{
  public static final String Alias = "directionalLights";
  public static final long Type = register("directionalLights");
  public final Array lights = new Array(1);

  public DirectionalLightsAttribute()
  {
    super(Type);
  }

  public DirectionalLightsAttribute(DirectionalLightsAttribute paramDirectionalLightsAttribute)
  {
    this();
    this.lights.addAll(paramDirectionalLightsAttribute.lights);
  }

  public static final boolean is(long paramLong)
  {
    return (paramLong & Type) == paramLong;
  }

  public int compareTo(Attribute paramAttribute)
  {
    if (this.type != paramAttribute.type)
    {
      if (this.type < paramAttribute.type)
        return -1;
      return 1;
    }
    return 0;
  }

  public DirectionalLightsAttribute copy()
  {
    return new DirectionalLightsAttribute(this);
  }

  public int hashCode()
  {
    int i = super.hashCode();
    Iterator localIterator = this.lights.iterator();
    int j = i;
    if (localIterator.hasNext())
    {
      DirectionalLight localDirectionalLight = (DirectionalLight)localIterator.next();
      int k = j * 1229;
      if (localDirectionalLight == null);
      for (int m = 0; ; m = localDirectionalLight.hashCode())
      {
        j = m + k;
        break;
      }
    }
    return j;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.attributes.DirectionalLightsAttribute
 * JD-Core Version:    0.6.0
 */