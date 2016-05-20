package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.utils.Array;
import java.util.Iterator;

public abstract class BaseShaderProvider
  implements ShaderProvider
{
  protected Array shaders = new Array();

  protected abstract Shader createShader(Renderable paramRenderable);

  public void dispose()
  {
    Iterator localIterator = this.shaders.iterator();
    while (localIterator.hasNext())
      ((Shader)localIterator.next()).dispose();
    this.shaders.clear();
  }

  public Shader getShader(Renderable paramRenderable)
  {
    Shader localShader1 = paramRenderable.shader;
    if ((localShader1 != null) && (localShader1.canRender(paramRenderable)))
      return localShader1;
    Iterator localIterator = this.shaders.iterator();
    while (localIterator.hasNext())
    {
      Shader localShader3 = (Shader)localIterator.next();
      if (localShader3.canRender(paramRenderable))
        return localShader3;
    }
    Shader localShader2 = createShader(paramRenderable);
    localShader2.init();
    this.shaders.add(localShader2);
    return localShader2;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.utils.BaseShaderProvider
 * JD-Core Version:    0.6.0
 */