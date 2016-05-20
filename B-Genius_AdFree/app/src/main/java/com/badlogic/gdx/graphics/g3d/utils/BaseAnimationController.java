package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.graphics.g3d.model.NodeAnimation;
import com.badlogic.gdx.graphics.g3d.model.NodeKeyframe;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.ObjectMap.Entries;
import com.badlogic.gdx.utils.ObjectMap.Entry;
import com.badlogic.gdx.utils.ObjectMap.Keys;
import com.badlogic.gdx.utils.Pool;
import java.util.Iterator;

public class BaseAnimationController
{
  private static final BaseAnimationController.Transform tmpT;
  private static final ObjectMap transforms = new ObjectMap();
  private boolean applying = false;
  public final ModelInstance target;
  private final Pool transformPool = new BaseAnimationController.1(this);

  static
  {
    tmpT = new BaseAnimationController.Transform();
  }

  public BaseAnimationController(ModelInstance paramModelInstance)
  {
    this.target = paramModelInstance;
  }

  protected static void applyAnimation(ObjectMap paramObjectMap, Pool paramPool, float paramFloat1, Animation paramAnimation, float paramFloat2)
  {
    if (paramObjectMap == null)
    {
      Iterator localIterator2 = paramAnimation.nodeAnimations.iterator();
      while (localIterator2.hasNext())
        applyNodeAnimationDirectly((NodeAnimation)localIterator2.next(), paramFloat2);
    }
    ObjectMap.Keys localKeys = paramObjectMap.keys().iterator();
    while (localKeys.hasNext())
      ((Node)localKeys.next()).isAnimated = false;
    Iterator localIterator1 = paramAnimation.nodeAnimations.iterator();
    while (localIterator1.hasNext())
      applyNodeAnimationBlending((NodeAnimation)localIterator1.next(), paramObjectMap, paramPool, paramFloat1, paramFloat2);
    ObjectMap.Entries localEntries = paramObjectMap.entries().iterator();
    while (localEntries.hasNext())
    {
      ObjectMap.Entry localEntry = (ObjectMap.Entry)localEntries.next();
      if (((Node)localEntry.key).isAnimated)
        continue;
      ((Node)localEntry.key).isAnimated = true;
      ((BaseAnimationController.Transform)localEntry.value).lerp(((Node)localEntry.key).translation, ((Node)localEntry.key).rotation, ((Node)localEntry.key).scale, paramFloat1);
    }
  }

  private static final void applyNodeAnimationBlending(NodeAnimation paramNodeAnimation, ObjectMap paramObjectMap, Pool paramPool, float paramFloat1, float paramFloat2)
  {
    Node localNode = paramNodeAnimation.node;
    localNode.isAnimated = true;
    BaseAnimationController.Transform localTransform1 = getNodeAnimationTransform(paramNodeAnimation, paramFloat2);
    BaseAnimationController.Transform localTransform2 = (BaseAnimationController.Transform)paramObjectMap.get(localNode, null);
    if (localTransform2 != null)
    {
      if (paramFloat1 > 0.999999F)
      {
        localTransform2.set(localTransform1);
        return;
      }
      localTransform2.lerp(localTransform1, paramFloat1);
      return;
    }
    if (paramFloat1 > 0.999999F)
    {
      paramObjectMap.put(localNode, ((BaseAnimationController.Transform)paramPool.obtain()).set(localTransform1));
      return;
    }
    paramObjectMap.put(localNode, ((BaseAnimationController.Transform)paramPool.obtain()).set(localNode.translation, localNode.rotation, localNode.scale).lerp(localTransform1, paramFloat1));
  }

  private static final void applyNodeAnimationDirectly(NodeAnimation paramNodeAnimation, float paramFloat)
  {
    Node localNode = paramNodeAnimation.node;
    localNode.isAnimated = true;
    getNodeAnimationTransform(paramNodeAnimation, paramFloat).toMatrix4(localNode.localTransform);
  }

  private static final int getFirstKeyframeIndexAtTime(Array paramArray, float paramFloat)
  {
    int i = -1 + paramArray.size;
    for (int j = 0; j < i; j++)
      if ((paramFloat >= ((NodeKeyframe)paramArray.get(j)).keytime) && (paramFloat <= ((NodeKeyframe)paramArray.get(j + 1)).keytime))
        return j;
    return 0;
  }

  private static final BaseAnimationController.Transform getNodeAnimationTransform(NodeAnimation paramNodeAnimation, float paramFloat)
  {
    BaseAnimationController.Transform localTransform = tmpT;
    getTranslationAtTime(paramNodeAnimation, paramFloat, localTransform.translation);
    getRotationAtTime(paramNodeAnimation, paramFloat, localTransform.rotation);
    getScalingAtTime(paramNodeAnimation, paramFloat, localTransform.scale);
    return localTransform;
  }

  private static final Quaternion getRotationAtTime(NodeAnimation paramNodeAnimation, float paramFloat, Quaternion paramQuaternion)
  {
    if (paramNodeAnimation.rotation == null)
      paramQuaternion = paramQuaternion.set(paramNodeAnimation.node.rotation);
    NodeKeyframe localNodeKeyframe1;
    int j;
    do
    {
      return paramQuaternion;
      if (paramNodeAnimation.rotation.size == 1)
        return paramQuaternion.set((Quaternion)((NodeKeyframe)paramNodeAnimation.rotation.get(0)).value);
      int i = getFirstKeyframeIndexAtTime(paramNodeAnimation.rotation, paramFloat);
      localNodeKeyframe1 = (NodeKeyframe)paramNodeAnimation.rotation.get(i);
      paramQuaternion.set((Quaternion)localNodeKeyframe1.value);
      j = i + 1;
    }
    while (j >= paramNodeAnimation.rotation.size);
    NodeKeyframe localNodeKeyframe2 = (NodeKeyframe)paramNodeAnimation.rotation.get(j);
    float f = (paramFloat - localNodeKeyframe1.keytime) / (localNodeKeyframe2.keytime - localNodeKeyframe1.keytime);
    paramQuaternion.slerp((Quaternion)localNodeKeyframe2.value, f);
    return paramQuaternion;
  }

  private static final Vector3 getScalingAtTime(NodeAnimation paramNodeAnimation, float paramFloat, Vector3 paramVector3)
  {
    if (paramNodeAnimation.scaling == null)
      paramVector3 = paramVector3.set(paramNodeAnimation.node.scale);
    NodeKeyframe localNodeKeyframe1;
    int j;
    do
    {
      return paramVector3;
      if (paramNodeAnimation.scaling.size == 1)
        return paramVector3.set((Vector3)((NodeKeyframe)paramNodeAnimation.scaling.get(0)).value);
      int i = getFirstKeyframeIndexAtTime(paramNodeAnimation.scaling, paramFloat);
      localNodeKeyframe1 = (NodeKeyframe)paramNodeAnimation.scaling.get(i);
      paramVector3.set((Vector3)localNodeKeyframe1.value);
      j = i + 1;
    }
    while (j >= paramNodeAnimation.scaling.size);
    NodeKeyframe localNodeKeyframe2 = (NodeKeyframe)paramNodeAnimation.scaling.get(j);
    float f = (paramFloat - localNodeKeyframe1.keytime) / (localNodeKeyframe2.keytime - localNodeKeyframe1.keytime);
    paramVector3.lerp((Vector3)localNodeKeyframe2.value, f);
    return paramVector3;
  }

  private static final Vector3 getTranslationAtTime(NodeAnimation paramNodeAnimation, float paramFloat, Vector3 paramVector3)
  {
    if (paramNodeAnimation.translation == null)
      paramVector3 = paramVector3.set(paramNodeAnimation.node.translation);
    NodeKeyframe localNodeKeyframe1;
    int j;
    do
    {
      return paramVector3;
      if (paramNodeAnimation.translation.size == 1)
        return paramVector3.set((Vector3)((NodeKeyframe)paramNodeAnimation.translation.get(0)).value);
      int i = getFirstKeyframeIndexAtTime(paramNodeAnimation.translation, paramFloat);
      localNodeKeyframe1 = (NodeKeyframe)paramNodeAnimation.translation.get(i);
      paramVector3.set((Vector3)localNodeKeyframe1.value);
      j = i + 1;
    }
    while (j >= paramNodeAnimation.translation.size);
    NodeKeyframe localNodeKeyframe2 = (NodeKeyframe)paramNodeAnimation.translation.get(j);
    float f = (paramFloat - localNodeKeyframe1.keytime) / (localNodeKeyframe2.keytime - localNodeKeyframe1.keytime);
    paramVector3.lerp((Vector3)localNodeKeyframe2.value, f);
    return paramVector3;
  }

  protected void apply(Animation paramAnimation, float paramFloat1, float paramFloat2)
  {
    if (!this.applying)
      throw new GdxRuntimeException("You must call begin() before adding an animation");
    applyAnimation(transforms, this.transformPool, paramFloat2, paramAnimation, paramFloat1);
  }

  protected void applyAnimation(Animation paramAnimation, float paramFloat)
  {
    if (this.applying)
      throw new GdxRuntimeException("Call end() first");
    applyAnimation(null, null, 1.0F, paramAnimation, paramFloat);
    this.target.calculateTransforms();
  }

  protected void applyAnimations(Animation paramAnimation1, float paramFloat1, Animation paramAnimation2, float paramFloat2, float paramFloat3)
  {
    if ((paramAnimation2 == null) || (paramFloat3 == 0.0F))
    {
      applyAnimation(paramAnimation1, paramFloat1);
      return;
    }
    if ((paramAnimation1 == null) || (paramFloat3 == 1.0F))
    {
      applyAnimation(paramAnimation2, paramFloat2);
      return;
    }
    if (this.applying)
      throw new GdxRuntimeException("Call end() first");
    begin();
    apply(paramAnimation1, paramFloat1, 1.0F);
    apply(paramAnimation2, paramFloat2, paramFloat3);
    end();
  }

  protected void begin()
  {
    if (this.applying)
      throw new GdxRuntimeException("You must call end() after each call to being()");
    this.applying = true;
  }

  protected void end()
  {
    if (!this.applying)
      throw new GdxRuntimeException("You must call begin() first");
    ObjectMap.Entries localEntries = transforms.entries().iterator();
    while (localEntries.hasNext())
    {
      ObjectMap.Entry localEntry = (ObjectMap.Entry)localEntries.next();
      ((BaseAnimationController.Transform)localEntry.value).toMatrix4(((Node)localEntry.key).localTransform);
      this.transformPool.free(localEntry.value);
    }
    transforms.clear();
    this.target.calculateTransforms();
    this.applying = false;
  }

  protected void removeAnimation(Animation paramAnimation)
  {
    Iterator localIterator = paramAnimation.nodeAnimations.iterator();
    while (localIterator.hasNext())
      ((NodeAnimation)localIterator.next()).node.isAnimated = false;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.utils.BaseAnimationController
 * JD-Core Version:    0.6.0
 */