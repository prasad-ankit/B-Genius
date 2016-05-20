package com.badlogic.gdx.graphics.g3d.attributes;

import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.environment.SpotLight;
import com.badlogic.gdx.utils.Array;
import java.util.Iterator;

public class SpotLightsAttribute extends Attribute
{
  public static final String Alias = "spotLights";
  public static final long Type = register("spotLights");
  public final Array lights = new Array(1);

  public SpotLightsAttribute()
  {
    super(Type);
  }

  public SpotLightsAttribute(SpotLightsAttribute paramSpotLightsAttribute)
  {
    this();
    this.lights.addAll(paramSpotLightsAttribute.lights);
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

  public SpotLightsAttribute copy()
  {
    return new SpotLightsAttribute(this);
  }

  public int hashCode()
  {
    int i = super.hashCode();
    Iterator localIterator = this.lights.iterator();
    int j = i;
    if (localIterator.hasNext())
    {
      SpotLight localSpotLight = (SpotLight)localIterator.next();
      int k = j * 1237;
      if (localSpotLight == null);
      for (int m = 0; ; m = localSpotLight.hashCode())
      {
        j = m + k;
        break;
      }
    }
    return j;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.attributes.SpotLightsAttribute
 * JD-Core Version:    0.6.0
 */