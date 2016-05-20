package com.badlogic.gdx.graphics.g3d;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.graphics.g3d.utils.MeshBuilder;
import com.badlogic.gdx.graphics.g3d.utils.RenderableSorter;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Pool;
import java.util.Iterator;

public class ModelCache
  implements RenderableProvider, Disposable
{
  private boolean building;
  private Camera camera;
  private Array items = new Array();
  private MeshBuilder meshBuilder;
  private ModelCache.FlushablePool meshPartPool = new ModelCache.2(this);
  private ModelCache.MeshPool meshPool;
  private Array renderables = new Array();
  private ModelCache.FlushablePool renderablesPool = new ModelCache.1(this);
  private RenderableSorter sorter;
  private Array tmp = new Array();

  public ModelCache()
  {
    this(new ModelCache.Sorter(), new ModelCache.SimpleMeshPool());
  }

  public ModelCache(RenderableSorter paramRenderableSorter, ModelCache.MeshPool paramMeshPool)
  {
    this.sorter = paramRenderableSorter;
    this.meshPool = paramMeshPool;
    this.meshBuilder = new MeshBuilder();
  }

  private Renderable obtainRenderable(Material paramMaterial, int paramInt)
  {
    Renderable localRenderable = (Renderable)this.renderablesPool.obtain();
    localRenderable.bones = null;
    localRenderable.environment = null;
    localRenderable.material = paramMaterial;
    localRenderable.meshPart.mesh = null;
    localRenderable.meshPart.offset = 0;
    localRenderable.meshPart.size = 0;
    localRenderable.meshPart.primitiveType = paramInt;
    localRenderable.meshPart.center.set(0.0F, 0.0F, 0.0F);
    localRenderable.meshPart.halfExtents.set(0.0F, 0.0F, 0.0F);
    localRenderable.meshPart.radius = -1.0F;
    localRenderable.shader = null;
    localRenderable.userData = null;
    localRenderable.worldTransform.idt();
    return localRenderable;
  }

  public void add(Renderable paramRenderable)
  {
    if (!this.building)
      throw new GdxRuntimeException("Can only add items to the ModelCache in between .begin() and .end()");
    if (paramRenderable.bones == null)
    {
      this.items.add(paramRenderable);
      return;
    }
    this.renderables.add(paramRenderable);
  }

  public void add(RenderableProvider paramRenderableProvider)
  {
    paramRenderableProvider.getRenderables(this.tmp, this.renderablesPool);
    int i = this.tmp.size;
    for (int j = 0; j < i; j++)
      add((Renderable)this.tmp.get(j));
    this.tmp.clear();
  }

  public void add(Iterable paramIterable)
  {
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
      add((Disposable)localIterator.next());
  }

  public void begin()
  {
    begin(null);
  }

  public void begin(Camera paramCamera)
  {
    if (this.building)
      throw new GdxRuntimeException("Call end() after calling begin()");
    this.building = true;
    this.camera = paramCamera;
    this.renderablesPool.flush();
    this.renderables.clear();
    this.items.clear();
    this.meshPartPool.flush();
    this.meshPool.flush();
  }

  public void dispose()
  {
    if (this.building)
      throw new GdxRuntimeException("Cannot dispose a ModelCache in between .begin() and .end()");
    this.meshPool.dispose();
  }

  public void end()
  {
    if (!this.building)
      throw new GdxRuntimeException("Call begin() prior to calling end()");
    this.building = false;
    if (this.items.size == 0)
      return;
    this.sorter.sort(this.camera, this.items);
    Renderable localRenderable1 = (Renderable)this.items.get(0);
    Object localObject1 = localRenderable1.meshPart.mesh.getVertexAttributes();
    Object localObject2 = localRenderable1.material;
    int i = localRenderable1.meshPart.primitiveType;
    int j = this.renderables.size;
    this.meshBuilder.begin((VertexAttributes)localObject1);
    Object localObject3 = this.meshBuilder.part("", i, (MeshPart)this.meshPartPool.obtain());
    this.renderables.add(obtainRenderable((Material)localObject2, i));
    int k = this.items.size;
    int m = 0;
    Renderable localRenderable3;
    Object localObject4;
    label361: int i4;
    label380: Object localObject7;
    int i5;
    Object localObject6;
    Object localObject5;
    if (m < k)
    {
      localRenderable3 = (Renderable)this.items.get(m);
      localObject4 = localRenderable3.meshPart.mesh.getVertexAttributes();
      Material localMaterial = localRenderable3.material;
      int i1 = localRenderable3.meshPart.primitiveType;
      int i2;
      if ((((VertexAttributes)localObject4).equals(localObject1)) && (localRenderable3.meshPart.size + this.meshBuilder.getNumVertices() < 32767))
      {
        i2 = 1;
        if ((i2 == 0) || (i1 != i) || (!localMaterial.same((Attributes)localObject2, true)))
          break label361;
      }
      for (int i3 = 1; ; i3 = 0)
      {
        if (i3 != 0)
          break label688;
        if (i2 != 0)
          break label678;
        Mesh localMesh2 = this.meshBuilder.end(this.meshPool.obtain((VertexAttributes)localObject1, this.meshBuilder.getNumVertices(), this.meshBuilder.getNumIndices()));
        while (j < this.renderables.size)
        {
          Array localArray2 = this.renderables;
          int i6 = j + 1;
          ((Renderable)localArray2.get(j)).meshPart.mesh = localMesh2;
          j = i6;
        }
        i2 = 0;
        break;
      }
      this.meshBuilder.begin((VertexAttributes)localObject4);
      i4 = j;
      MeshPart localMeshPart = this.meshBuilder.part("", i1, (MeshPart)this.meshPartPool.obtain());
      Renderable localRenderable4 = (Renderable)this.renderables.get(-1 + this.renderables.size);
      localRenderable4.meshPart.offset = ((MeshPart)localObject3).offset;
      localRenderable4.meshPart.size = ((MeshPart)localObject3).size;
      this.renderables.add(obtainRenderable(localMaterial, i1));
      localObject7 = localMeshPart;
      i5 = i1;
      localObject6 = localObject4;
      localObject5 = localMaterial;
    }
    while (true)
    {
      this.meshBuilder.setVertexTransform(localRenderable3.worldTransform);
      this.meshBuilder.addMesh(localRenderable3.meshPart.mesh, localRenderable3.meshPart.offset, localRenderable3.meshPart.size);
      m++;
      i = i5;
      localObject3 = localObject7;
      j = i4;
      localObject1 = localObject6;
      localObject2 = localObject5;
      break;
      Mesh localMesh1 = this.meshBuilder.end(this.meshPool.obtain((VertexAttributes)localObject1, this.meshBuilder.getNumVertices(), this.meshBuilder.getNumIndices()));
      while (j < this.renderables.size)
      {
        Array localArray1 = this.renderables;
        int n = j + 1;
        ((Renderable)localArray1.get(j)).meshPart.mesh = localMesh1;
        j = n;
      }
      Renderable localRenderable2 = (Renderable)this.renderables.get(-1 + this.renderables.size);
      localRenderable2.meshPart.offset = ((MeshPart)localObject3).offset;
      localRenderable2.meshPart.size = ((MeshPart)localObject3).size;
      return;
      label678: localObject4 = localObject1;
      i4 = j;
      break label380;
      label688: localObject5 = localObject2;
      localObject6 = localObject1;
      i4 = j;
      localObject7 = localObject3;
      i5 = i;
    }
  }

  public void getRenderables(Array paramArray, Pool paramPool)
  {
    if (this.building)
      throw new GdxRuntimeException("Cannot render a ModelCache in between .begin() and .end()");
    paramArray.addAll(this.renderables);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.ModelCache
 * JD-Core Version:    0.6.0
 */