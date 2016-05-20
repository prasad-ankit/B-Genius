package com.badlogic.gdx.graphics.g3d;

import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.graphics.g3d.model.NodeAnimation;
import com.badlogic.gdx.graphics.g3d.model.NodeKeyframe;
import com.badlogic.gdx.graphics.g3d.model.NodePart;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ArrayMap;
import com.badlogic.gdx.utils.Pool;
import java.util.Iterator;

public class ModelInstance
  implements RenderableProvider
{
  public static boolean defaultShareKeyframes = true;
  public final Array animations = new Array();
  public final Array materials = new Array();
  public final Model model;
  public final Array nodes = new Array();
  public Matrix4 transform;
  public Object userData;

  public ModelInstance(Model paramModel)
  {
    this(paramModel, null);
  }

  public ModelInstance(Model paramModel, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this(paramModel);
    this.transform.setToTranslation(paramFloat1, paramFloat2, paramFloat3);
  }

  public ModelInstance(Model paramModel, Matrix4 paramMatrix4)
  {
    this(paramModel, paramMatrix4, null);
  }

  public ModelInstance(Model paramModel, Matrix4 paramMatrix4, Array paramArray)
  {
    this(paramModel, paramMatrix4, paramArray, defaultShareKeyframes);
  }

  public ModelInstance(Model paramModel, Matrix4 paramMatrix4, Array paramArray, boolean paramBoolean)
  {
    this.model = paramModel;
    if (paramMatrix4 == null)
      paramMatrix4 = new Matrix4();
    this.transform = paramMatrix4;
    copyNodes(paramModel.nodes, paramArray);
    copyAnimations(paramModel.animations, paramBoolean);
    calculateTransforms();
  }

  public ModelInstance(Model paramModel, Matrix4 paramMatrix4, String paramString, boolean paramBoolean)
  {
    this(paramModel, paramMatrix4, paramString, false, false, paramBoolean);
  }

  public ModelInstance(Model paramModel, Matrix4 paramMatrix4, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramModel, paramMatrix4, paramString, true, paramBoolean1, paramBoolean2);
  }

  public ModelInstance(Model paramModel, Matrix4 paramMatrix4, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this(paramModel, paramMatrix4, paramString, paramBoolean1, paramBoolean2, paramBoolean3, defaultShareKeyframes);
  }

  public ModelInstance(Model paramModel, Matrix4 paramMatrix4, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.model = paramModel;
    if (paramMatrix4 == null)
      paramMatrix4 = new Matrix4();
    this.transform = paramMatrix4;
    Node localNode1 = paramModel.getNode(paramString, paramBoolean1);
    Array localArray = this.nodes;
    Node localNode2 = localNode1.copy();
    localArray.add(localNode2);
    Matrix4 localMatrix42;
    if (paramBoolean3)
    {
      Matrix4 localMatrix41 = this.transform;
      if (paramBoolean2)
      {
        localMatrix42 = localNode1.globalTransform;
        localMatrix41.mul(localMatrix42);
        localNode2.translation.set(0.0F, 0.0F, 0.0F);
        localNode2.rotation.idt();
        localNode2.scale.set(1.0F, 1.0F, 1.0F);
      }
    }
    while (true)
    {
      invalidate();
      copyAnimations(paramModel.animations, paramBoolean4);
      calculateTransforms();
      return;
      localMatrix42 = localNode1.localTransform;
      break;
      if ((!paramBoolean2) || (!localNode2.hasParent()))
        continue;
      this.transform.mul(localNode1.getParent().globalTransform);
    }
  }

  public ModelInstance(Model paramModel, Matrix4 paramMatrix4, String[] paramArrayOfString)
  {
    this.model = paramModel;
    if (paramMatrix4 == null)
      paramMatrix4 = new Matrix4();
    this.transform = paramMatrix4;
    if (paramArrayOfString == null)
      copyNodes(paramModel.nodes);
    while (true)
    {
      copyAnimations(paramModel.animations, defaultShareKeyframes);
      calculateTransforms();
      return;
      copyNodes(paramModel.nodes, paramArrayOfString);
    }
  }

  public ModelInstance(Model paramModel, Vector3 paramVector3)
  {
    this(paramModel);
    this.transform.setToTranslation(paramVector3);
  }

  public ModelInstance(Model paramModel, Array paramArray)
  {
    this(paramModel, null, paramArray);
  }

  public ModelInstance(Model paramModel, String paramString, boolean paramBoolean)
  {
    this(paramModel, null, paramString, false, false, paramBoolean);
  }

  public ModelInstance(Model paramModel, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramModel, null, paramString, true, paramBoolean1, paramBoolean2);
  }

  public ModelInstance(Model paramModel, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this(paramModel, null, paramString, paramBoolean1, paramBoolean2, paramBoolean3);
  }

  public ModelInstance(Model paramModel, String[] paramArrayOfString)
  {
    this(paramModel, null, paramArrayOfString);
  }

  public ModelInstance(ModelInstance paramModelInstance)
  {
    this(paramModelInstance, paramModelInstance.transform.cpy());
  }

  public ModelInstance(ModelInstance paramModelInstance, Matrix4 paramMatrix4)
  {
    this(paramModelInstance, paramMatrix4, defaultShareKeyframes);
  }

  public ModelInstance(ModelInstance paramModelInstance, Matrix4 paramMatrix4, boolean paramBoolean)
  {
    this.model = paramModelInstance.model;
    if (paramMatrix4 == null)
      paramMatrix4 = new Matrix4();
    this.transform = paramMatrix4;
    copyNodes(paramModelInstance.nodes);
    copyAnimations(paramModelInstance.animations, paramBoolean);
    calculateTransforms();
  }

  private void copyAnimations(Iterable paramIterable, boolean paramBoolean)
  {
    Iterator localIterator1 = paramIterable.iterator();
    while (localIterator1.hasNext())
    {
      Animation localAnimation1 = (Animation)localIterator1.next();
      Animation localAnimation2 = new Animation();
      localAnimation2.id = localAnimation1.id;
      localAnimation2.duration = localAnimation1.duration;
      Iterator localIterator2 = localAnimation1.nodeAnimations.iterator();
      label433: 
      while (true)
      {
        label66: if (!localIterator2.hasNext())
          break label434;
        NodeAnimation localNodeAnimation1 = (NodeAnimation)localIterator2.next();
        Node localNode = getNode(localNodeAnimation1.node.id);
        if (localNode == null)
          continue;
        NodeAnimation localNodeAnimation2 = new NodeAnimation();
        localNodeAnimation2.node = localNode;
        if (paramBoolean)
        {
          localNodeAnimation2.translation = localNodeAnimation1.translation;
          localNodeAnimation2.rotation = localNodeAnimation1.rotation;
          localNodeAnimation2.scaling = localNodeAnimation1.scaling;
        }
        while (true)
        {
          if ((localNodeAnimation2.translation == null) && (localNodeAnimation2.rotation == null) && (localNodeAnimation2.scaling == null))
            break label433;
          localAnimation2.nodeAnimations.add(localNodeAnimation2);
          break label66;
          if (localNodeAnimation1.translation != null)
          {
            localNodeAnimation2.translation = new Array();
            Iterator localIterator5 = localNodeAnimation1.translation.iterator();
            while (localIterator5.hasNext())
            {
              NodeKeyframe localNodeKeyframe3 = (NodeKeyframe)localIterator5.next();
              localNodeAnimation2.translation.add(new NodeKeyframe(localNodeKeyframe3.keytime, localNodeKeyframe3.value));
            }
          }
          if (localNodeAnimation1.rotation != null)
          {
            localNodeAnimation2.rotation = new Array();
            Iterator localIterator4 = localNodeAnimation1.rotation.iterator();
            while (localIterator4.hasNext())
            {
              NodeKeyframe localNodeKeyframe2 = (NodeKeyframe)localIterator4.next();
              localNodeAnimation2.rotation.add(new NodeKeyframe(localNodeKeyframe2.keytime, localNodeKeyframe2.value));
            }
          }
          if (localNodeAnimation1.scaling == null)
            break;
          localNodeAnimation2.scaling = new Array();
          Iterator localIterator3 = localNodeAnimation1.scaling.iterator();
          while (localIterator3.hasNext())
          {
            NodeKeyframe localNodeKeyframe1 = (NodeKeyframe)localIterator3.next();
            localNodeAnimation2.scaling.add(new NodeKeyframe(localNodeKeyframe1.keytime, localNodeKeyframe1.value));
          }
        }
      }
      label434: if (localAnimation2.nodeAnimations.size <= 0)
        continue;
      this.animations.add(localAnimation2);
    }
  }

  private void copyNodes(Array paramArray)
  {
    int i = paramArray.size;
    for (int j = 0; j < i; j++)
    {
      Node localNode = (Node)paramArray.get(j);
      this.nodes.add(localNode.copy());
    }
    invalidate();
  }

  private void copyNodes(Array paramArray1, Array paramArray2)
  {
    int i = paramArray1.size;
    for (int j = 0; j < i; j++)
    {
      Node localNode = (Node)paramArray1.get(j);
      Iterator localIterator = paramArray2.iterator();
      while (localIterator.hasNext())
      {
        if (!((String)localIterator.next()).equals(localNode.id))
          continue;
        this.nodes.add(localNode.copy());
      }
    }
    invalidate();
  }

  private void copyNodes(Array paramArray, String[] paramArrayOfString)
  {
    int i = paramArray.size;
    int j = 0;
    if (j < i)
    {
      Node localNode = (Node)paramArray.get(j);
      int k = paramArrayOfString.length;
      for (int m = 0; ; m++)
      {
        if (m < k)
        {
          if (!paramArrayOfString[m].equals(localNode.id))
            continue;
          this.nodes.add(localNode.copy());
        }
        j++;
        break;
      }
    }
    invalidate();
  }

  private void invalidate()
  {
    int i = this.nodes.size;
    for (int j = 0; j < i; j++)
      invalidate((Node)this.nodes.get(j));
  }

  private void invalidate(Node paramNode)
  {
    int i = 0;
    int j = paramNode.parts.size;
    int k = 0;
    if (k < j)
    {
      NodePart localNodePart = (NodePart)paramNode.parts.get(k);
      ArrayMap localArrayMap = localNodePart.invBoneBindTransforms;
      if (localArrayMap != null)
        for (int i1 = 0; i1 < localArrayMap.size; i1++)
          ((Node[])localArrayMap.keys)[i1] = getNode(((Node[])localArrayMap.keys)[i1].id);
      int n;
      if (!this.materials.contains(localNodePart.material, true))
      {
        n = this.materials.indexOf(localNodePart.material, false);
        if (n >= 0)
          break label165;
        Array localArray = this.materials;
        Material localMaterial = localNodePart.material.copy();
        localNodePart.material = localMaterial;
        localArray.add(localMaterial);
      }
      while (true)
      {
        k++;
        break;
        label165: localNodePart.material = ((Material)this.materials.get(n));
      }
    }
    int m = paramNode.getChildCount();
    while (i < m)
    {
      invalidate(paramNode.getChild(i));
      i++;
    }
  }

  public BoundingBox calculateBoundingBox(BoundingBox paramBoundingBox)
  {
    paramBoundingBox.inf();
    return extendBoundingBox(paramBoundingBox);
  }

  public void calculateTransforms()
  {
    int i = this.nodes.size;
    int k;
    for (int j = 0; ; j++)
    {
      k = 0;
      if (j >= i)
        break;
      ((Node)this.nodes.get(j)).calculateTransforms(true);
    }
    while (k < i)
    {
      ((Node)this.nodes.get(k)).calculateBoneTransforms(true);
      k++;
    }
  }

  public ModelInstance copy()
  {
    return new ModelInstance(this);
  }

  public BoundingBox extendBoundingBox(BoundingBox paramBoundingBox)
  {
    int i = this.nodes.size;
    for (int j = 0; j < i; j++)
      ((Node)this.nodes.get(j)).extendBoundingBox(paramBoundingBox);
    return paramBoundingBox;
  }

  public Animation getAnimation(String paramString)
  {
    return getAnimation(paramString, true);
  }

  public Animation getAnimation(String paramString, boolean paramBoolean)
  {
    int i = this.animations.size;
    Animation localAnimation;
    if (paramBoolean)
      for (int k = 0; k < i; k++)
      {
        localAnimation = (Animation)this.animations.get(k);
        if (localAnimation.id.equalsIgnoreCase(paramString))
          return localAnimation;
      }
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label97;
      localAnimation = (Animation)this.animations.get(j);
      if (localAnimation.id.equals(paramString))
        break;
    }
    label97: return null;
  }

  public Material getMaterial(String paramString)
  {
    return getMaterial(paramString, true);
  }

  public Material getMaterial(String paramString, boolean paramBoolean)
  {
    int i = this.materials.size;
    Material localMaterial;
    if (paramBoolean)
      for (int k = 0; k < i; k++)
      {
        localMaterial = (Material)this.materials.get(k);
        if (localMaterial.id.equalsIgnoreCase(paramString))
          return localMaterial;
      }
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label97;
      localMaterial = (Material)this.materials.get(j);
      if (localMaterial.id.equals(paramString))
        break;
    }
    label97: return null;
  }

  public Node getNode(String paramString)
  {
    return getNode(paramString, true);
  }

  public Node getNode(String paramString, boolean paramBoolean)
  {
    return getNode(paramString, paramBoolean, false);
  }

  public Node getNode(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return Node.getNode(this.nodes, paramString, paramBoolean1, paramBoolean2);
  }

  public Renderable getRenderable(Renderable paramRenderable)
  {
    return getRenderable(paramRenderable, (Node)this.nodes.get(0));
  }

  public Renderable getRenderable(Renderable paramRenderable, Node paramNode)
  {
    return getRenderable(paramRenderable, paramNode, (NodePart)paramNode.parts.get(0));
  }

  public Renderable getRenderable(Renderable paramRenderable, Node paramNode, NodePart paramNodePart)
  {
    paramNodePart.setRenderable(paramRenderable);
    if ((paramNodePart.bones == null) && (this.transform != null))
      paramRenderable.worldTransform.set(this.transform).mul(paramNode.globalTransform);
    while (true)
    {
      paramRenderable.userData = this.userData;
      return paramRenderable;
      if (this.transform != null)
      {
        paramRenderable.worldTransform.set(this.transform);
        continue;
      }
      paramRenderable.worldTransform.idt();
    }
  }

  protected void getRenderables(Node paramNode, Array paramArray, Pool paramPool)
  {
    if (paramNode.parts.size > 0)
    {
      Iterator localIterator2 = paramNode.parts.iterator();
      while (localIterator2.hasNext())
      {
        NodePart localNodePart = (NodePart)localIterator2.next();
        if (!localNodePart.enabled)
          continue;
        paramArray.add(getRenderable((Renderable)paramPool.obtain(), paramNode, localNodePart));
      }
    }
    Iterator localIterator1 = paramNode.getChildren().iterator();
    while (localIterator1.hasNext())
      getRenderables((Node)localIterator1.next(), paramArray, paramPool);
  }

  public void getRenderables(Array paramArray, Pool paramPool)
  {
    Iterator localIterator = this.nodes.iterator();
    while (localIterator.hasNext())
      getRenderables((Node)localIterator.next(), paramArray, paramPool);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.ModelInstance
 * JD-Core Version:    0.6.0
 */