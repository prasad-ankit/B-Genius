package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.graphics.g3d.model.NodePart;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.Iterator;

public class ModelBuilder
{
  private Array builders = new Array();
  private Model model;
  private Node node;
  private Matrix4 tmpTransform = new Matrix4();

  private void endnode()
  {
    if (this.node != null)
      this.node = null;
  }

  private MeshBuilder getBuilder(VertexAttributes paramVertexAttributes)
  {
    Iterator localIterator = this.builders.iterator();
    while (localIterator.hasNext())
    {
      MeshBuilder localMeshBuilder2 = (MeshBuilder)localIterator.next();
      if ((localMeshBuilder2.getAttributes().equals(paramVertexAttributes)) && (localMeshBuilder2.lastIndex() < 16383))
        return localMeshBuilder2;
    }
    MeshBuilder localMeshBuilder1 = new MeshBuilder();
    localMeshBuilder1.begin(paramVertexAttributes);
    this.builders.add(localMeshBuilder1);
    return localMeshBuilder1;
  }

  public static void rebuildReferences(Model paramModel)
  {
    paramModel.materials.clear();
    paramModel.meshes.clear();
    paramModel.meshParts.clear();
    Iterator localIterator = paramModel.nodes.iterator();
    while (localIterator.hasNext())
      rebuildReferences(paramModel, (Node)localIterator.next());
  }

  private static void rebuildReferences(Model paramModel, Node paramNode)
  {
    Iterator localIterator1 = paramNode.parts.iterator();
    while (localIterator1.hasNext())
    {
      NodePart localNodePart = (NodePart)localIterator1.next();
      if (!paramModel.materials.contains(localNodePart.material, true))
        paramModel.materials.add(localNodePart.material);
      if (paramModel.meshParts.contains(localNodePart.meshPart, true))
        continue;
      paramModel.meshParts.add(localNodePart.meshPart);
      if (!paramModel.meshes.contains(localNodePart.meshPart.mesh, true))
        paramModel.meshes.add(localNodePart.meshPart.mesh);
      paramModel.manageDisposable(localNodePart.meshPart.mesh);
    }
    Iterator localIterator2 = paramNode.getChildren().iterator();
    while (localIterator2.hasNext())
      rebuildReferences(paramModel, (Node)localIterator2.next());
  }

  public void begin()
  {
    if (this.model != null)
      throw new GdxRuntimeException("Call end() first");
    this.node = null;
    this.model = new Model();
    this.builders.clear();
  }

  public Model createArrow(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, int paramInt1, int paramInt2, Material paramMaterial, long paramLong)
  {
    begin();
    part("arrow", paramInt2, paramLong, paramMaterial).arrow(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramInt1);
    return end();
  }

  public Model createArrow(Vector3 paramVector31, Vector3 paramVector32, Material paramMaterial, long paramLong)
  {
    return createArrow(paramVector31.x, paramVector31.y, paramVector31.z, paramVector32.x, paramVector32.y, paramVector32.z, 0.1F, 0.1F, 5, 4, paramMaterial, paramLong);
  }

  public Model createBox(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, Material paramMaterial, long paramLong)
  {
    begin();
    part("box", paramInt, paramLong, paramMaterial).box(paramFloat1, paramFloat2, paramFloat3);
    return end();
  }

  public Model createBox(float paramFloat1, float paramFloat2, float paramFloat3, Material paramMaterial, long paramLong)
  {
    return createBox(paramFloat1, paramFloat2, paramFloat3, 4, paramMaterial, paramLong);
  }

  public Model createCapsule(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, Material paramMaterial, long paramLong)
  {
    begin();
    part("capsule", paramInt2, paramLong, paramMaterial).capsule(paramFloat1, paramFloat2, paramInt1);
    return end();
  }

  public Model createCapsule(float paramFloat1, float paramFloat2, int paramInt, Material paramMaterial, long paramLong)
  {
    return createCapsule(paramFloat1, paramFloat2, paramInt, 4, paramMaterial, paramLong);
  }

  public Model createCone(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, Material paramMaterial, long paramLong)
  {
    return createCone(paramFloat1, paramFloat2, paramFloat3, paramInt1, paramInt2, paramMaterial, paramLong, 0.0F, 360.0F);
  }

  public Model createCone(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, Material paramMaterial, long paramLong, float paramFloat4, float paramFloat5)
  {
    begin();
    part("cone", paramInt2, paramLong, paramMaterial).cone(paramFloat1, paramFloat2, paramFloat3, paramInt1, paramFloat4, paramFloat5);
    return end();
  }

  public Model createCone(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, Material paramMaterial, long paramLong)
  {
    return createCone(paramFloat1, paramFloat2, paramFloat3, paramInt, 4, paramMaterial, paramLong);
  }

  public Model createCone(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, Material paramMaterial, long paramLong, float paramFloat4, float paramFloat5)
  {
    return createCone(paramFloat1, paramFloat2, paramFloat3, paramInt, 4, paramMaterial, paramLong, paramFloat4, paramFloat5);
  }

  public Model createCylinder(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, Material paramMaterial, long paramLong)
  {
    return createCylinder(paramFloat1, paramFloat2, paramFloat3, paramInt1, paramInt2, paramMaterial, paramLong, 0.0F, 360.0F);
  }

  public Model createCylinder(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, Material paramMaterial, long paramLong, float paramFloat4, float paramFloat5)
  {
    begin();
    part("cylinder", paramInt2, paramLong, paramMaterial).cylinder(paramFloat1, paramFloat2, paramFloat3, paramInt1, paramFloat4, paramFloat5);
    return end();
  }

  public Model createCylinder(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, Material paramMaterial, long paramLong)
  {
    return createCylinder(paramFloat1, paramFloat2, paramFloat3, paramInt, 4, paramMaterial, paramLong);
  }

  public Model createCylinder(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, Material paramMaterial, long paramLong, float paramFloat4, float paramFloat5)
  {
    return createCylinder(paramFloat1, paramFloat2, paramFloat3, paramInt, 4, paramMaterial, paramLong, paramFloat4, paramFloat5);
  }

  public Model createLineGrid(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, Material paramMaterial, long paramLong)
  {
    begin();
    MeshPartBuilder localMeshPartBuilder = part("lines", 1, paramLong, paramMaterial);
    float f1 = paramFloat1 * paramInt1;
    float f2 = paramFloat2 * paramInt2;
    float f3 = f1 / 2.0F;
    float f4 = f2 / 2.0F;
    float f5 = -f3;
    float f6 = -f4;
    int i = 0;
    float f7 = f5;
    while (i <= paramInt1)
    {
      localMeshPartBuilder.line(f7, 0.0F, f4, f5, 0.0F, f6);
      float f10 = f7 + paramFloat1;
      f5 += paramFloat1;
      i++;
      f7 = f10;
    }
    float f8 = -f3;
    int j = 0;
    float f9 = f6;
    while (j <= paramInt2)
    {
      localMeshPartBuilder.line(f8, 0.0F, f9, f3, 0.0F, f6);
      f9 += paramFloat2;
      f6 += paramFloat2;
      j++;
    }
    return end();
  }

  public Model createRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, int paramInt, Material paramMaterial, long paramLong)
  {
    begin();
    part("rect", paramInt, paramLong, paramMaterial).rect(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13, paramFloat14, paramFloat15);
    return end();
  }

  public Model createRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, Material paramMaterial, long paramLong)
  {
    return createRect(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13, paramFloat14, paramFloat15, 4, paramMaterial, paramLong);
  }

  public Model createSphere(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, int paramInt3, Material paramMaterial, long paramLong)
  {
    return createSphere(paramFloat1, paramFloat2, paramFloat3, paramInt1, paramInt2, paramInt3, paramMaterial, paramLong, 0.0F, 360.0F, 0.0F, 180.0F);
  }

  public Model createSphere(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, int paramInt3, Material paramMaterial, long paramLong, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    begin();
    part("cylinder", paramInt3, paramLong, paramMaterial).sphere(paramFloat1, paramFloat2, paramFloat3, paramInt1, paramInt2, paramFloat4, paramFloat5, paramFloat6, paramFloat7);
    return end();
  }

  public Model createSphere(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, Material paramMaterial, long paramLong)
  {
    return createSphere(paramFloat1, paramFloat2, paramFloat3, paramInt1, paramInt2, 4, paramMaterial, paramLong);
  }

  public Model createSphere(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, Material paramMaterial, long paramLong, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    return createSphere(paramFloat1, paramFloat2, paramFloat3, paramInt1, paramInt2, 4, paramMaterial, paramLong, paramFloat4, paramFloat5, paramFloat6, paramFloat7);
  }

  public Model createXYZCoordinates(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, Material paramMaterial, long paramLong)
  {
    begin();
    node();
    MeshPartBuilder localMeshPartBuilder = part("xyz", paramInt2, paramLong, paramMaterial);
    localMeshPartBuilder.setColor(Color.RED);
    localMeshPartBuilder.arrow(0.0F, 0.0F, 0.0F, paramFloat1, 0.0F, 0.0F, paramFloat2, paramFloat3, paramInt1);
    localMeshPartBuilder.setColor(Color.GREEN);
    localMeshPartBuilder.arrow(0.0F, 0.0F, 0.0F, 0.0F, paramFloat1, 0.0F, paramFloat2, paramFloat3, paramInt1);
    localMeshPartBuilder.setColor(Color.BLUE);
    localMeshPartBuilder.arrow(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, paramFloat1, paramFloat2, paramFloat3, paramInt1);
    return end();
  }

  public Model createXYZCoordinates(float paramFloat, Material paramMaterial, long paramLong)
  {
    return createXYZCoordinates(paramFloat, 0.1F, 0.1F, 5, 4, paramMaterial, paramLong);
  }

  public Model end()
  {
    if (this.model == null)
      throw new GdxRuntimeException("Call begin() first");
    Model localModel = this.model;
    endnode();
    this.model = null;
    Iterator localIterator = this.builders.iterator();
    while (localIterator.hasNext())
      ((MeshBuilder)localIterator.next()).end();
    this.builders.clear();
    rebuildReferences(localModel);
    return localModel;
  }

  public void manage(Disposable paramDisposable)
  {
    if (this.model == null)
      throw new GdxRuntimeException("Call begin() first");
    this.model.manageDisposable(paramDisposable);
  }

  public Node node()
  {
    Node localNode = new Node();
    node(localNode);
    localNode.id = ("node" + this.model.nodes.size);
    return localNode;
  }

  protected Node node(Node paramNode)
  {
    if (this.model == null)
      throw new GdxRuntimeException("Call begin() first");
    endnode();
    this.model.nodes.add(paramNode);
    this.node = paramNode;
    return paramNode;
  }

  public Node node(String paramString, Model paramModel)
  {
    Node localNode = new Node();
    localNode.id = paramString;
    localNode.addChildren(paramModel.nodes);
    node(localNode);
    Iterator localIterator = paramModel.getManagedDisposables().iterator();
    while (localIterator.hasNext())
      manage((Disposable)localIterator.next());
    return localNode;
  }

  public MeshPart part(String paramString, Mesh paramMesh, int paramInt1, int paramInt2, int paramInt3, Material paramMaterial)
  {
    MeshPart localMeshPart = new MeshPart();
    localMeshPart.id = paramString;
    localMeshPart.primitiveType = paramInt1;
    localMeshPart.mesh = paramMesh;
    localMeshPart.offset = paramInt2;
    localMeshPart.size = paramInt3;
    part(localMeshPart, paramMaterial);
    return localMeshPart;
  }

  public MeshPart part(String paramString, Mesh paramMesh, int paramInt, Material paramMaterial)
  {
    return part(paramString, paramMesh, paramInt, 0, paramMesh.getNumIndices(), paramMaterial);
  }

  public MeshPartBuilder part(String paramString, int paramInt, long paramLong, Material paramMaterial)
  {
    return part(paramString, paramInt, MeshBuilder.createAttributes(paramLong), paramMaterial);
  }

  public MeshPartBuilder part(String paramString, int paramInt, VertexAttributes paramVertexAttributes, Material paramMaterial)
  {
    MeshBuilder localMeshBuilder = getBuilder(paramVertexAttributes);
    part(localMeshBuilder.part(paramString, paramInt), paramMaterial);
    return localMeshBuilder;
  }

  public void part(MeshPart paramMeshPart, Material paramMaterial)
  {
    if (this.node == null)
      node();
    this.node.parts.add(new NodePart(paramMeshPart, paramMaterial));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.utils.ModelBuilder
 * JD-Core Version:    0.6.0
 */