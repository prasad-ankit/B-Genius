package com.badlogic.gdx.graphics.g3d;

import com.badlogic.gdx.graphics.g3d.attributes.DirectionalLightsAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.PointLightsAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.SpotLightsAttribute;
import com.badlogic.gdx.graphics.g3d.environment.BaseLight;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.environment.PointLight;
import com.badlogic.gdx.graphics.g3d.environment.ShadowMap;
import com.badlogic.gdx.graphics.g3d.environment.SpotLight;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.Iterator;

public class Environment extends Attributes
{
  public ShadowMap shadowMap;

  public Environment add(BaseLight paramBaseLight)
  {
    if ((paramBaseLight instanceof DirectionalLight))
    {
      add((DirectionalLight)paramBaseLight);
      return this;
    }
    if ((paramBaseLight instanceof PointLight))
    {
      add((PointLight)paramBaseLight);
      return this;
    }
    if ((paramBaseLight instanceof SpotLight))
    {
      add((SpotLight)paramBaseLight);
      return this;
    }
    throw new GdxRuntimeException("Unknown light type");
  }

  public Environment add(DirectionalLight paramDirectionalLight)
  {
    DirectionalLightsAttribute localDirectionalLightsAttribute = (DirectionalLightsAttribute)get(DirectionalLightsAttribute.Type);
    if (localDirectionalLightsAttribute == null)
    {
      localDirectionalLightsAttribute = new DirectionalLightsAttribute();
      set(localDirectionalLightsAttribute);
    }
    localDirectionalLightsAttribute.lights.add(paramDirectionalLight);
    return this;
  }

  public Environment add(PointLight paramPointLight)
  {
    PointLightsAttribute localPointLightsAttribute = (PointLightsAttribute)get(PointLightsAttribute.Type);
    if (localPointLightsAttribute == null)
    {
      localPointLightsAttribute = new PointLightsAttribute();
      set(localPointLightsAttribute);
    }
    localPointLightsAttribute.lights.add(paramPointLight);
    return this;
  }

  public Environment add(SpotLight paramSpotLight)
  {
    SpotLightsAttribute localSpotLightsAttribute = (SpotLightsAttribute)get(SpotLightsAttribute.Type);
    if (localSpotLightsAttribute == null)
    {
      localSpotLightsAttribute = new SpotLightsAttribute();
      set(localSpotLightsAttribute);
    }
    localSpotLightsAttribute.lights.add(paramSpotLight);
    return this;
  }

  public Environment add(Array paramArray)
  {
    Iterator localIterator = paramArray.iterator();
    while (localIterator.hasNext())
      add((BaseLight)localIterator.next());
    return this;
  }

  public Environment add(BaseLight[] paramArrayOfBaseLight)
  {
    int i = paramArrayOfBaseLight.length;
    for (int j = 0; j < i; j++)
      add(paramArrayOfBaseLight[j]);
    return this;
  }

  public Environment remove(BaseLight paramBaseLight)
  {
    if ((paramBaseLight instanceof DirectionalLight))
    {
      remove((DirectionalLight)paramBaseLight);
      return this;
    }
    if ((paramBaseLight instanceof PointLight))
    {
      remove((PointLight)paramBaseLight);
      return this;
    }
    if ((paramBaseLight instanceof SpotLight))
    {
      remove((SpotLight)paramBaseLight);
      return this;
    }
    throw new GdxRuntimeException("Unknown light type");
  }

  public Environment remove(DirectionalLight paramDirectionalLight)
  {
    if (has(DirectionalLightsAttribute.Type))
    {
      DirectionalLightsAttribute localDirectionalLightsAttribute = (DirectionalLightsAttribute)get(DirectionalLightsAttribute.Type);
      localDirectionalLightsAttribute.lights.removeValue(paramDirectionalLight, false);
      if (localDirectionalLightsAttribute.lights.size == 0)
        remove(DirectionalLightsAttribute.Type);
    }
    return this;
  }

  public Environment remove(PointLight paramPointLight)
  {
    if (has(PointLightsAttribute.Type))
    {
      PointLightsAttribute localPointLightsAttribute = (PointLightsAttribute)get(PointLightsAttribute.Type);
      localPointLightsAttribute.lights.removeValue(paramPointLight, false);
      if (localPointLightsAttribute.lights.size == 0)
        remove(PointLightsAttribute.Type);
    }
    return this;
  }

  public Environment remove(SpotLight paramSpotLight)
  {
    if (has(SpotLightsAttribute.Type))
    {
      SpotLightsAttribute localSpotLightsAttribute = (SpotLightsAttribute)get(SpotLightsAttribute.Type);
      localSpotLightsAttribute.lights.removeValue(paramSpotLight, false);
      if (localSpotLightsAttribute.lights.size == 0)
        remove(SpotLightsAttribute.Type);
    }
    return this;
  }

  public Environment remove(Array paramArray)
  {
    Iterator localIterator = paramArray.iterator();
    while (localIterator.hasNext())
      remove((BaseLight)localIterator.next());
    return this;
  }

  public Environment remove(BaseLight[] paramArrayOfBaseLight)
  {
    int i = paramArrayOfBaseLight.length;
    for (int j = 0; j < i; j++)
      remove(paramArrayOfBaseLight[j]);
    return this;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.Environment
 * JD-Core Version:    0.6.0
 */