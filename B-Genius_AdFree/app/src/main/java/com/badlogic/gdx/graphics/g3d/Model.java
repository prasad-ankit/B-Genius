package com.badlogic.gdx.graphics.g3d;

import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.FloatAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.graphics.g3d.model.NodeAnimation;
import com.badlogic.gdx.graphics.g3d.model.NodeKeyframe;
import com.badlogic.gdx.graphics.g3d.model.NodePart;
import com.badlogic.gdx.graphics.g3d.model.data.ModelAnimation;
import com.badlogic.gdx.graphics.g3d.model.data.ModelData;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMesh;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMeshPart;
import com.badlogic.gdx.graphics.g3d.model.data.ModelNode;
import com.badlogic.gdx.graphics.g3d.model.data.ModelNodeAnimation;
import com.badlogic.gdx.graphics.g3d.model.data.ModelNodeKeyframe;
import com.badlogic.gdx.graphics.g3d.model.data.ModelNodePart;
import com.badlogic.gdx.graphics.g3d.model.data.ModelTexture;
import com.badlogic.gdx.graphics.g3d.utils.TextureDescriptor;
import com.badlogic.gdx.graphics.g3d.utils.TextureProvider;
import com.badlogic.gdx.graphics.g3d.utils.TextureProvider.FileTextureProvider;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ArrayMap;
import com.badlogic.gdx.utils.ArrayMap.Entries;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.ObjectMap.Entries;
import com.badlogic.gdx.utils.ObjectMap.Entry;
import java.nio.ShortBuffer;
import java.util.Iterator;

public class Model
  implements Disposable
{
  public final Array animations = new Array();
  protected final Array disposables = new Array();
  public final Array materials = new Array();
  public final Array meshParts = new Array();
  public final Array meshes = new Array();
  private ObjectMap nodePartBones = new ObjectMap();
  public final Array nodes = new Array();

  public Model()
  {
  }

  public Model(ModelData paramModelData)
  {
    this(paramModelData, new TextureProvider.FileTextureProvider());
  }

  public Model(ModelData paramModelData, TextureProvider paramTextureProvider)
  {
    load(paramModelData, paramTextureProvider);
  }

  private Material convertMaterial(ModelMaterial paramModelMaterial, TextureProvider paramTextureProvider)
  {
    Material localMaterial = new Material();
    localMaterial.id = paramModelMaterial.id;
    if (paramModelMaterial.ambient != null)
      localMaterial.set(new ColorAttribute(ColorAttribute.Ambient, paramModelMaterial.ambient));
    if (paramModelMaterial.diffuse != null)
      localMaterial.set(new ColorAttribute(ColorAttribute.Diffuse, paramModelMaterial.diffuse));
    if (paramModelMaterial.specular != null)
      localMaterial.set(new ColorAttribute(ColorAttribute.Specular, paramModelMaterial.specular));
    if (paramModelMaterial.emissive != null)
      localMaterial.set(new ColorAttribute(ColorAttribute.Emissive, paramModelMaterial.emissive));
    if (paramModelMaterial.reflection != null)
      localMaterial.set(new ColorAttribute(ColorAttribute.Reflection, paramModelMaterial.reflection));
    if (paramModelMaterial.shininess > 0.0F)
      localMaterial.set(new FloatAttribute(FloatAttribute.Shininess, paramModelMaterial.shininess));
    if (paramModelMaterial.opacity != 1.0F)
      localMaterial.set(new BlendingAttribute(770, 771, paramModelMaterial.opacity));
    ObjectMap localObjectMap = new ObjectMap();
    if (paramModelMaterial.textures != null)
    {
      Iterator localIterator = paramModelMaterial.textures.iterator();
      while (localIterator.hasNext())
      {
        ModelTexture localModelTexture = (ModelTexture)localIterator.next();
        Texture localTexture;
        label273: TextureDescriptor localTextureDescriptor;
        float f1;
        label335: float f2;
        label346: float f3;
        label357: float f4;
        if (localObjectMap.containsKey(localModelTexture.fileName))
        {
          localTexture = (Texture)localObjectMap.get(localModelTexture.fileName);
          localTextureDescriptor = new TextureDescriptor(localTexture);
          localTextureDescriptor.minFilter = localTexture.getMinFilter();
          localTextureDescriptor.magFilter = localTexture.getMagFilter();
          localTextureDescriptor.uWrap = localTexture.getUWrap();
          localTextureDescriptor.vWrap = localTexture.getVWrap();
          if (localModelTexture.uvTranslation != null)
            break label492;
          f1 = 0.0F;
          if (localModelTexture.uvTranslation != null)
            break label505;
          f2 = 0.0F;
          if (localModelTexture.uvScaling != null)
            break label518;
          f3 = 1.0F;
          if (localModelTexture.uvScaling != null)
            break label531;
          f4 = 1.0F;
        }
        while (true)
          switch (localModelTexture.usage)
          {
          case 6:
          case 9:
          default:
            break;
          case 2:
            localMaterial.set(new TextureAttribute(TextureAttribute.Diffuse, localTextureDescriptor, f1, f2, f3, f4));
            break;
            localTexture = paramTextureProvider.load(localModelTexture.fileName);
            localObjectMap.put(localModelTexture.fileName, localTexture);
            this.disposables.add(localTexture);
            break label273;
            label492: f1 = localModelTexture.uvTranslation.x;
            break label335;
            label505: f2 = localModelTexture.uvTranslation.y;
            break label346;
            label518: f3 = localModelTexture.uvScaling.x;
            break label357;
            label531: f4 = localModelTexture.uvScaling.y;
          case 5:
          case 8:
          case 7:
          case 4:
          case 3:
          case 10:
          }
        localMaterial.set(new TextureAttribute(TextureAttribute.Specular, localTextureDescriptor, f1, f2, f3, f4));
        continue;
        localMaterial.set(new TextureAttribute(TextureAttribute.Bump, localTextureDescriptor, f1, f2, f3, f4));
        continue;
        localMaterial.set(new TextureAttribute(TextureAttribute.Normal, localTextureDescriptor, f1, f2, f3, f4));
        continue;
        localMaterial.set(new TextureAttribute(TextureAttribute.Ambient, localTextureDescriptor, f1, f2, f3, f4));
        continue;
        localMaterial.set(new TextureAttribute(TextureAttribute.Emissive, localTextureDescriptor, f1, f2, f3, f4));
        continue;
        localMaterial.set(new TextureAttribute(TextureAttribute.Reflection, localTextureDescriptor, f1, f2, f3, f4));
      }
    }
    return localMaterial;
  }

  private void convertMesh(ModelMesh paramModelMesh)
  {
    ModelMeshPart[] arrayOfModelMeshPart1 = paramModelMesh.parts;
    int i = arrayOfModelMeshPart1.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      k += arrayOfModelMeshPart1[j].indices.length;
      j++;
    }
    VertexAttributes localVertexAttributes = new VertexAttributes(paramModelMesh.attributes);
    Mesh localMesh = new Mesh(true, paramModelMesh.vertices.length / (localVertexAttributes.vertexSize / 4), k, localVertexAttributes);
    this.meshes.add(localMesh);
    this.disposables.add(localMesh);
    BufferUtils.copy(paramModelMesh.vertices, localMesh.getVerticesBuffer(), paramModelMesh.vertices.length, 0);
    localMesh.getIndicesBuffer().clear();
    ModelMeshPart[] arrayOfModelMeshPart2 = paramModelMesh.parts;
    int m = arrayOfModelMeshPart2.length;
    int n = 0;
    for (int i1 = 0; i1 < m; i1++)
    {
      ModelMeshPart localModelMeshPart = arrayOfModelMeshPart2[i1];
      MeshPart localMeshPart = new MeshPart();
      localMeshPart.id = localModelMeshPart.id;
      localMeshPart.primitiveType = localModelMeshPart.primitiveType;
      localMeshPart.offset = n;
      localMeshPart.size = localModelMeshPart.indices.length;
      localMeshPart.mesh = localMesh;
      localMesh.getIndicesBuffer().put(localModelMeshPart.indices);
      n += localMeshPart.size;
      this.meshParts.add(localMeshPart);
    }
    localMesh.getIndicesBuffer().position(0);
    Iterator localIterator = this.meshParts.iterator();
    while (localIterator.hasNext())
      ((MeshPart)localIterator.next()).update();
  }

  private void load(ModelData paramModelData, TextureProvider paramTextureProvider)
  {
    loadMeshes(paramModelData.meshes);
    loadMaterials(paramModelData.materials, paramTextureProvider);
    loadNodes(paramModelData.nodes);
    loadAnimations(paramModelData.animations);
    calculateTransforms();
  }

  private void loadAnimations(Iterable paramIterable)
  {
    Iterator localIterator1 = paramIterable.iterator();
    while (localIterator1.hasNext())
    {
      ModelAnimation localModelAnimation = (ModelAnimation)localIterator1.next();
      Animation localAnimation = new Animation();
      localAnimation.id = localModelAnimation.id;
      Iterator localIterator2 = localModelAnimation.nodeAnimations.iterator();
      while (localIterator2.hasNext())
      {
        ModelNodeAnimation localModelNodeAnimation = (ModelNodeAnimation)localIterator2.next();
        Node localNode = getNode(localModelNodeAnimation.nodeId);
        if (localNode == null)
          continue;
        NodeAnimation localNodeAnimation = new NodeAnimation();
        localNodeAnimation.node = localNode;
        if (localModelNodeAnimation.translation != null)
        {
          localNodeAnimation.translation = new Array();
          localNodeAnimation.translation.ensureCapacity(localModelNodeAnimation.translation.size);
          Iterator localIterator5 = localModelNodeAnimation.translation.iterator();
          if (localIterator5.hasNext())
          {
            ModelNodeKeyframe localModelNodeKeyframe3 = (ModelNodeKeyframe)localIterator5.next();
            if (localModelNodeKeyframe3.keytime > localAnimation.duration)
              localAnimation.duration = localModelNodeKeyframe3.keytime;
            Array localArray3 = localNodeAnimation.translation;
            float f3 = localModelNodeKeyframe3.keytime;
            if (localModelNodeKeyframe3.value == null);
            for (Vector3 localVector32 = localNode.translation; ; localVector32 = (Vector3)localModelNodeKeyframe3.value)
            {
              localArray3.add(new NodeKeyframe(f3, new Vector3(localVector32)));
              break;
            }
          }
        }
        if (localModelNodeAnimation.rotation != null)
        {
          localNodeAnimation.rotation = new Array();
          localNodeAnimation.rotation.ensureCapacity(localModelNodeAnimation.rotation.size);
          Iterator localIterator4 = localModelNodeAnimation.rotation.iterator();
          if (localIterator4.hasNext())
          {
            ModelNodeKeyframe localModelNodeKeyframe2 = (ModelNodeKeyframe)localIterator4.next();
            if (localModelNodeKeyframe2.keytime > localAnimation.duration)
              localAnimation.duration = localModelNodeKeyframe2.keytime;
            Array localArray2 = localNodeAnimation.rotation;
            float f2 = localModelNodeKeyframe2.keytime;
            if (localModelNodeKeyframe2.value == null);
            for (Quaternion localQuaternion = localNode.rotation; ; localQuaternion = (Quaternion)localModelNodeKeyframe2.value)
            {
              localArray2.add(new NodeKeyframe(f2, new Quaternion(localQuaternion)));
              break;
            }
          }
        }
        if (localModelNodeAnimation.scaling != null)
        {
          localNodeAnimation.scaling = new Array();
          localNodeAnimation.scaling.ensureCapacity(localModelNodeAnimation.scaling.size);
          Iterator localIterator3 = localModelNodeAnimation.scaling.iterator();
          if (localIterator3.hasNext())
          {
            ModelNodeKeyframe localModelNodeKeyframe1 = (ModelNodeKeyframe)localIterator3.next();
            if (localModelNodeKeyframe1.keytime > localAnimation.duration)
              localAnimation.duration = localModelNodeKeyframe1.keytime;
            Array localArray1 = localNodeAnimation.scaling;
            float f1 = localModelNodeKeyframe1.keytime;
            if (localModelNodeKeyframe1.value == null);
            for (Vector3 localVector31 = localNode.scale; ; localVector31 = (Vector3)localModelNodeKeyframe1.value)
            {
              localArray1.add(new NodeKeyframe(f1, new Vector3(localVector31)));
              break;
            }
          }
        }
        if (((localNodeAnimation.translation == null) || (localNodeAnimation.translation.size <= 0)) && ((localNodeAnimation.rotation == null) || (localNodeAnimation.rotation.size <= 0)) && ((localNodeAnimation.scaling == null) || (localNodeAnimation.scaling.size <= 0)))
          continue;
        localAnimation.nodeAnimations.add(localNodeAnimation);
      }
      if (localAnimation.nodeAnimations.size <= 0)
        continue;
      this.animations.add(localAnimation);
    }
  }

  private void loadMaterials(Iterable paramIterable, TextureProvider paramTextureProvider)
  {
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
    {
      ModelMaterial localModelMaterial = (ModelMaterial)localIterator.next();
      this.materials.add(convertMaterial(localModelMaterial, paramTextureProvider));
    }
  }

  private void loadMeshes(Iterable paramIterable)
  {
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
      convertMesh((ModelMesh)localIterator.next());
  }

  private Node loadNode(ModelNode paramModelNode)
  {
    Node localNode = new Node();
    localNode.id = paramModelNode.id;
    if (paramModelNode.translation != null)
      localNode.translation.set(paramModelNode.translation);
    if (paramModelNode.rotation != null)
      localNode.rotation.set(paramModelNode.rotation);
    if (paramModelNode.scale != null)
      localNode.scale.set(paramModelNode.scale);
    int m;
    ModelNodePart localModelNodePart;
    MeshPart localMeshPart2;
    if (paramModelNode.parts != null)
    {
      ModelNodePart[] arrayOfModelNodePart = paramModelNode.parts;
      int k = arrayOfModelNodePart.length;
      m = 0;
      if (m < k)
      {
        localModelNodePart = arrayOfModelNodePart[m];
        if (localModelNodePart.meshPartId == null)
          break label384;
        Iterator localIterator2 = this.meshParts.iterator();
        do
        {
          if (!localIterator2.hasNext())
            break;
          localMeshPart2 = (MeshPart)localIterator2.next();
        }
        while (!localModelNodePart.meshPartId.equals(localMeshPart2.id));
      }
    }
    label384: for (MeshPart localMeshPart1 = localMeshPart2; ; localMeshPart1 = null)
    {
      Material localMaterial;
      if (localModelNodePart.materialId != null)
      {
        Iterator localIterator1 = this.materials.iterator();
        do
        {
          if (!localIterator1.hasNext())
            break;
          localMaterial = (Material)localIterator1.next();
        }
        while (!localModelNodePart.materialId.equals(localMaterial.id));
      }
      while (true)
      {
        if ((localMeshPart1 == null) || (localMaterial == null))
          throw new GdxRuntimeException("Invalid node: " + localNode.id);
        if ((localMeshPart1 != null) && (localMaterial != null))
        {
          NodePart localNodePart = new NodePart();
          localNodePart.meshPart = localMeshPart1;
          localNodePart.material = localMaterial;
          localNode.parts.add(localNodePart);
          if (localModelNodePart.bones != null)
            this.nodePartBones.put(localNodePart, localModelNodePart.bones);
        }
        m++;
        break;
        if (paramModelNode.children != null)
        {
          ModelNode[] arrayOfModelNode = paramModelNode.children;
          int i = arrayOfModelNode.length;
          for (int j = 0; j < i; j++)
            localNode.addChild(loadNode(arrayOfModelNode[j]));
        }
        return localNode;
        localMaterial = null;
      }
    }
  }

  private void loadNodes(Iterable paramIterable)
  {
    this.nodePartBones.clear();
    Iterator localIterator1 = paramIterable.iterator();
    while (localIterator1.hasNext())
    {
      ModelNode localModelNode = (ModelNode)localIterator1.next();
      this.nodes.add(loadNode(localModelNode));
    }
    ObjectMap.Entries localEntries = this.nodePartBones.entries().iterator();
    while (localEntries.hasNext())
    {
      ObjectMap.Entry localEntry1 = (ObjectMap.Entry)localEntries.next();
      if (((NodePart)localEntry1.key).invBoneBindTransforms == null)
        ((NodePart)localEntry1.key).invBoneBindTransforms = new ArrayMap(Node.class, Matrix4.class);
      ((NodePart)localEntry1.key).invBoneBindTransforms.clear();
      Iterator localIterator2 = ((ArrayMap)localEntry1.value).entries().iterator();
      while (localIterator2.hasNext())
      {
        ObjectMap.Entry localEntry2 = (ObjectMap.Entry)localIterator2.next();
        ((NodePart)localEntry1.key).invBoneBindTransforms.put(getNode((String)localEntry2.key), new Matrix4((Matrix4)localEntry2.value).inv());
      }
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

  public void dispose()
  {
    Iterator localIterator = this.disposables.iterator();
    while (localIterator.hasNext())
      ((Disposable)localIterator.next()).dispose();
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

  public Iterable getManagedDisposables()
  {
    return this.disposables;
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

  public void manageDisposable(Disposable paramDisposable)
  {
    if (!this.disposables.contains(paramDisposable, true))
      this.disposables.add(paramDisposable);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.Model
 * JD-Core Version:    0.6.0
 */