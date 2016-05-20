package com.badlogic.gdx.graphics.g3d;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.graphics.g3d.utils.DefaultRenderableSorter;
import com.badlogic.gdx.graphics.g3d.utils.DefaultShaderProvider;
import com.badlogic.gdx.graphics.g3d.utils.DefaultTextureBinder;
import com.badlogic.gdx.graphics.g3d.utils.RenderContext;
import com.badlogic.gdx.graphics.g3d.utils.RenderableSorter;
import com.badlogic.gdx.graphics.g3d.utils.ShaderProvider;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.Iterator;

public class ModelBatch
  implements Disposable
{
  protected Camera camera;
  protected final RenderContext context;
  private final boolean ownContext;
  protected final Array renderables = new Array();
  protected final ModelBatch.RenderablePool renderablesPool = new ModelBatch.RenderablePool();
  protected final ShaderProvider shaderProvider;
  protected final RenderableSorter sorter;

  public ModelBatch()
  {
    this(null, null, null);
  }

  public ModelBatch(FileHandle paramFileHandle1, FileHandle paramFileHandle2)
  {
    this(null, new DefaultShaderProvider(paramFileHandle1, paramFileHandle2), null);
  }

  public ModelBatch(RenderContext paramRenderContext)
  {
    this(paramRenderContext, null, null);
  }

  public ModelBatch(RenderContext paramRenderContext, RenderableSorter paramRenderableSorter)
  {
    this(paramRenderContext, null, paramRenderableSorter);
  }

  public ModelBatch(RenderContext paramRenderContext, ShaderProvider paramShaderProvider)
  {
    this(paramRenderContext, paramShaderProvider, null);
  }

  public ModelBatch(RenderContext paramRenderContext, ShaderProvider paramShaderProvider, RenderableSorter paramRenderableSorter)
  {
    if (paramRenderableSorter == null)
      paramRenderableSorter = new DefaultRenderableSorter();
    this.sorter = paramRenderableSorter;
    if (paramRenderContext == null);
    for (boolean bool = true; ; bool = false)
    {
      this.ownContext = bool;
      if (paramRenderContext == null)
        paramRenderContext = new RenderContext(new DefaultTextureBinder(1, 1));
      this.context = paramRenderContext;
      if (paramShaderProvider == null)
        paramShaderProvider = new DefaultShaderProvider();
      this.shaderProvider = paramShaderProvider;
      return;
    }
  }

  public ModelBatch(RenderableSorter paramRenderableSorter)
  {
    this(null, null, paramRenderableSorter);
  }

  public ModelBatch(ShaderProvider paramShaderProvider)
  {
    this(null, paramShaderProvider, null);
  }

  public ModelBatch(ShaderProvider paramShaderProvider, RenderableSorter paramRenderableSorter)
  {
    this(null, paramShaderProvider, paramRenderableSorter);
  }

  public ModelBatch(String paramString1, String paramString2)
  {
    this(null, new DefaultShaderProvider(paramString1, paramString2), null);
  }

  public void begin(Camera paramCamera)
  {
    if (this.camera != null)
      throw new GdxRuntimeException("Call end() first.");
    this.camera = paramCamera;
    if (this.ownContext)
      this.context.begin();
  }

  public void dispose()
  {
    this.shaderProvider.dispose();
  }

  public void end()
  {
    flush();
    if (this.ownContext)
      this.context.end();
    this.camera = null;
  }

  public void flush()
  {
    this.sorter.sort(this.camera, this.renderables);
    Shader localShader = null;
    for (int i = 0; i < this.renderables.size; i++)
    {
      Renderable localRenderable = (Renderable)this.renderables.get(i);
      if (localShader != localRenderable.shader)
      {
        if (localShader != null)
          localShader.end();
        localShader = localRenderable.shader;
        localShader.begin(this.camera, this.context);
      }
      localShader.render(localRenderable);
    }
    if (localShader != null)
      localShader.end();
    this.renderablesPool.flush();
    this.renderables.clear();
  }

  public Camera getCamera()
  {
    return this.camera;
  }

  public RenderContext getRenderContext()
  {
    return this.context;
  }

  public RenderableSorter getRenderableSorter()
  {
    return this.sorter;
  }

  public ShaderProvider getShaderProvider()
  {
    return this.shaderProvider;
  }

  public boolean ownsRenderContext()
  {
    return this.ownContext;
  }

  public void render(Renderable paramRenderable)
  {
    paramRenderable.shader = this.shaderProvider.getShader(paramRenderable);
    paramRenderable.meshPart.mesh.setAutoBind(false);
    this.renderables.add(paramRenderable);
  }

  public void render(RenderableProvider paramRenderableProvider)
  {
    int i = this.renderables.size;
    paramRenderableProvider.getRenderables(this.renderables, this.renderablesPool);
    for (int j = i; j < this.renderables.size; j++)
    {
      Renderable localRenderable = (Renderable)this.renderables.get(j);
      localRenderable.shader = this.shaderProvider.getShader(localRenderable);
    }
  }

  public void render(RenderableProvider paramRenderableProvider, Environment paramEnvironment)
  {
    int i = this.renderables.size;
    paramRenderableProvider.getRenderables(this.renderables, this.renderablesPool);
    for (int j = i; j < this.renderables.size; j++)
    {
      Renderable localRenderable = (Renderable)this.renderables.get(j);
      localRenderable.environment = paramEnvironment;
      localRenderable.shader = this.shaderProvider.getShader(localRenderable);
    }
  }

  public void render(RenderableProvider paramRenderableProvider, Environment paramEnvironment, Shader paramShader)
  {
    int i = this.renderables.size;
    paramRenderableProvider.getRenderables(this.renderables, this.renderablesPool);
    for (int j = i; j < this.renderables.size; j++)
    {
      Renderable localRenderable = (Renderable)this.renderables.get(j);
      localRenderable.environment = paramEnvironment;
      localRenderable.shader = paramShader;
      localRenderable.shader = this.shaderProvider.getShader(localRenderable);
    }
  }

  public void render(RenderableProvider paramRenderableProvider, Shader paramShader)
  {
    int i = this.renderables.size;
    paramRenderableProvider.getRenderables(this.renderables, this.renderablesPool);
    for (int j = i; j < this.renderables.size; j++)
    {
      Renderable localRenderable = (Renderable)this.renderables.get(j);
      localRenderable.shader = paramShader;
      localRenderable.shader = this.shaderProvider.getShader(localRenderable);
    }
  }

  public void render(Iterable paramIterable)
  {
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
      render((RenderableProvider)localIterator.next());
  }

  public void render(Iterable paramIterable, Environment paramEnvironment)
  {
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
      render((RenderableProvider)localIterator.next(), paramEnvironment);
  }

  public void render(Iterable paramIterable, Environment paramEnvironment, Shader paramShader)
  {
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
      render((RenderableProvider)localIterator.next(), paramEnvironment, paramShader);
  }

  public void render(Iterable paramIterable, Shader paramShader)
  {
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
      render((RenderableProvider)localIterator.next(), paramShader);
  }

  public void setCamera(Camera paramCamera)
  {
    if (this.camera == null)
      throw new GdxRuntimeException("Call begin() first.");
    if (this.renderables.size > 0)
      flush();
    this.camera = paramCamera;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.ModelBatch
 * JD-Core Version:    0.6.0
 */