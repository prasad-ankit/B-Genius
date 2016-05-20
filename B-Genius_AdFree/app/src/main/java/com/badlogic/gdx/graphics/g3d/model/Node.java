package com.badlogic.gdx.graphics.g3d.model;

import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ArrayMap;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.Iterator;

public class Node
{
  private final Array children = new Array(2);
  public final Matrix4 globalTransform = new Matrix4();
  public String id;
  public boolean inheritTransform = true;
  public boolean isAnimated;
  public final Matrix4 localTransform = new Matrix4();
  protected Node parent;
  public Array parts = new Array(2);
  public final Quaternion rotation = new Quaternion(0.0F, 0.0F, 0.0F, 1.0F);
  public final Vector3 scale = new Vector3(1.0F, 1.0F, 1.0F);
  public final Vector3 translation = new Vector3();

  public static Node getNode(Array paramArray, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = paramArray.size;
    Node localNode;
    if (paramBoolean2)
      for (int m = 0; m < i; m++)
      {
        localNode = (Node)paramArray.get(m);
        if (localNode.id.equalsIgnoreCase(paramString))
          return localNode;
      }
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label91;
      localNode = (Node)paramArray.get(j);
      if (localNode.id.equals(paramString))
        break;
    }
    label91: int k = 0;
    if (paramBoolean1)
      while (true)
      {
        if (k >= i)
          break label136;
        localNode = getNode(((Node)paramArray.get(k)).children, paramString, true, paramBoolean2);
        if (localNode != null)
          break;
        k++;
      }
    label136: return null;
  }

  public int addChild(Node paramNode)
  {
    return insertChild(-1, paramNode);
  }

  public int addChildren(Iterable paramIterable)
  {
    return insertChildren(-1, paramIterable);
  }

  public void attachTo(Node paramNode)
  {
    paramNode.addChild(this);
  }

  public void calculateBoneTransforms(boolean paramBoolean)
  {
    Iterator localIterator1 = this.parts.iterator();
    while (localIterator1.hasNext())
    {
      NodePart localNodePart = (NodePart)localIterator1.next();
      if ((localNodePart.invBoneBindTransforms == null) || (localNodePart.bones == null) || (localNodePart.invBoneBindTransforms.size != localNodePart.bones.length))
        continue;
      int i = localNodePart.invBoneBindTransforms.size;
      for (int j = 0; j < i; j++)
        localNodePart.bones[j].set(((Node[])localNodePart.invBoneBindTransforms.keys)[j].globalTransform).mul(((Matrix4[])localNodePart.invBoneBindTransforms.values)[j]);
    }
    if (paramBoolean)
    {
      Iterator localIterator2 = this.children.iterator();
      while (localIterator2.hasNext())
        ((Node)localIterator2.next()).calculateBoneTransforms(true);
    }
  }

  public BoundingBox calculateBoundingBox(BoundingBox paramBoundingBox)
  {
    paramBoundingBox.inf();
    return extendBoundingBox(paramBoundingBox);
  }

  public BoundingBox calculateBoundingBox(BoundingBox paramBoundingBox, boolean paramBoolean)
  {
    paramBoundingBox.inf();
    return extendBoundingBox(paramBoundingBox, paramBoolean);
  }

  public Matrix4 calculateLocalTransform()
  {
    if (!this.isAnimated)
      this.localTransform.set(this.translation, this.rotation, this.scale);
    return this.localTransform;
  }

  public void calculateTransforms(boolean paramBoolean)
  {
    calculateLocalTransform();
    calculateWorldTransform();
    if (paramBoolean)
    {
      Iterator localIterator = this.children.iterator();
      while (localIterator.hasNext())
        ((Node)localIterator.next()).calculateTransforms(true);
    }
  }

  public Matrix4 calculateWorldTransform()
  {
    if ((this.inheritTransform) && (this.parent != null))
      this.globalTransform.set(this.parent.globalTransform).mul(this.localTransform);
    while (true)
    {
      return this.globalTransform;
      this.globalTransform.set(this.localTransform);
    }
  }

  public Node copy()
  {
    return new Node().set(this);
  }

  public void detach()
  {
    if (this.parent != null)
    {
      this.parent.removeChild(this);
      this.parent = null;
    }
  }

  public BoundingBox extendBoundingBox(BoundingBox paramBoundingBox)
  {
    return extendBoundingBox(paramBoundingBox, true);
  }

  public BoundingBox extendBoundingBox(BoundingBox paramBoundingBox, boolean paramBoolean)
  {
    int i = 0;
    int j = this.parts.size;
    int k = 0;
    if (k < j)
    {
      NodePart localNodePart = (NodePart)this.parts.get(k);
      MeshPart localMeshPart;
      if (localNodePart.enabled)
      {
        localMeshPart = localNodePart.meshPart;
        if (!paramBoolean)
          break label84;
        localMeshPart.mesh.extendBoundingBox(paramBoundingBox, localMeshPart.offset, localMeshPart.size, this.globalTransform);
      }
      while (true)
      {
        k++;
        break;
        label84: localMeshPart.mesh.extendBoundingBox(paramBoundingBox, localMeshPart.offset, localMeshPart.size);
      }
    }
    int m = this.children.size;
    while (i < m)
    {
      ((Node)this.children.get(i)).extendBoundingBox(paramBoundingBox);
      i++;
    }
    return paramBoundingBox;
  }

  public Node getChild(int paramInt)
  {
    return (Node)this.children.get(paramInt);
  }

  public Node getChild(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return getNode(this.children, paramString, paramBoolean1, paramBoolean2);
  }

  public int getChildCount()
  {
    return this.children.size;
  }

  public Iterable getChildren()
  {
    return this.children;
  }

  public Node getParent()
  {
    return this.parent;
  }

  public boolean hasChildren()
  {
    return (this.children != null) && (this.children.size > 0);
  }

  public boolean hasParent()
  {
    return this.parent != null;
  }

  public int insertChild(int paramInt, Node paramNode)
  {
    for (Node localNode1 = this; localNode1 != null; localNode1 = localNode1.getParent())
    {
      if (localNode1 != paramNode)
        continue;
      throw new GdxRuntimeException("Cannot add a parent as a child");
    }
    Node localNode2 = paramNode.getParent();
    if ((localNode2 != null) && (!localNode2.removeChild(paramNode)))
      throw new GdxRuntimeException("Could not remove child from its current parent");
    if ((paramInt < 0) || (paramInt >= this.children.size))
    {
      paramInt = this.children.size;
      this.children.add(paramNode);
    }
    while (true)
    {
      paramNode.parent = this;
      return paramInt;
      this.children.insert(paramInt, paramNode);
    }
  }

  public int insertChildren(int paramInt, Iterable paramIterable)
  {
    if ((paramInt < 0) || (paramInt > this.children.size))
      paramInt = this.children.size;
    Iterator localIterator = paramIterable.iterator();
    int j;
    for (int i = paramInt; localIterator.hasNext(); i = j)
    {
      Node localNode = (Node)localIterator.next();
      j = i + 1;
      insertChild(i, localNode);
    }
    return paramInt;
  }

  public boolean removeChild(Node paramNode)
  {
    if (!this.children.removeValue(paramNode, true))
      return false;
    paramNode.parent = null;
    return true;
  }

  protected Node set(Node paramNode)
  {
    detach();
    this.id = paramNode.id;
    this.isAnimated = paramNode.isAnimated;
    this.inheritTransform = paramNode.inheritTransform;
    this.translation.set(paramNode.translation);
    this.rotation.set(paramNode.rotation);
    this.scale.set(paramNode.scale);
    this.localTransform.set(paramNode.localTransform);
    this.globalTransform.set(paramNode.globalTransform);
    this.parts.clear();
    Iterator localIterator1 = paramNode.parts.iterator();
    while (localIterator1.hasNext())
    {
      NodePart localNodePart = (NodePart)localIterator1.next();
      this.parts.add(localNodePart.copy());
    }
    this.children.clear();
    Iterator localIterator2 = paramNode.getChildren().iterator();
    while (localIterator2.hasNext())
      addChild(((Node)localIterator2.next()).copy());
    return this;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.model.Node
 * JD-Core Version:    0.6.0
 */