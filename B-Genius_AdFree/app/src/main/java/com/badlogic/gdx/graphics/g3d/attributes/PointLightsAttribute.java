package com.badlogic.gdx.graphics.g3d.attributes;

import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.environment.PointLight;
import com.badlogic.gdx.utils.Array;
import java.util.Iterator;

public class PointLightsAttribute extends Attribute
{
  public static final String Alias = "pointLights";
  public static final long Type = register("pointLights");
  public final Array lights = new Array(1);

  public PointLightsAttribute()
  {
    super(Type);
  }

  public PointLightsAttribute(PointLightsAttribute paramPointLightsAttribute)
  {
    this();
    this.lights.addAll(paramPointLightsAttribute.lights);
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

  public PointLightsAttribute copy()
  {
    return new PointLightsAttribute(this);
  }

  public int hashCode()
  {
    int i = super.hashCode();
    Iterator localIterator = this.lights.iterator();
    int j = i;
    if (localIterator.hasNext())
    {
      PointLight localPointLight = (PointLight)localIterator.next();
      int k = j * 1231;
      if (localPointLight == null);
      for (int m = 0; ; m = localPointLight.hashCode())
      {
        j = m + k;
        break;
      }
    }
    return j;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.attributes.PointLightsAttribute
 * JD-Core Version:    0.6.0
 */