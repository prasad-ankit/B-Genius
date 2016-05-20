package com.badlogic.gdx.graphics.g3d.loader;

import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.ModelLoader;
import com.badlogic.gdx.assets.loaders.ModelLoader.ModelParameters;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttribute;
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
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ArrayMap;
import com.badlogic.gdx.utils.BaseJsonReader;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.JsonValue;
import java.util.Iterator;

public class G3dModelLoader extends ModelLoader
{
  public static final short VERSION_HI = 0;
  public static final short VERSION_LO = 1;
  protected final BaseJsonReader reader;
  private final Quaternion tempQ = new Quaternion();

  public G3dModelLoader(BaseJsonReader paramBaseJsonReader)
  {
    this(paramBaseJsonReader, null);
  }

  public G3dModelLoader(BaseJsonReader paramBaseJsonReader, FileHandleResolver paramFileHandleResolver)
  {
    super(paramFileHandleResolver);
    this.reader = paramBaseJsonReader;
  }

  private void parseAnimations(ModelData paramModelData, JsonValue paramJsonValue)
  {
    JsonValue localJsonValue1 = paramJsonValue.get("animations");
    if (localJsonValue1 == null);
    while (true)
    {
      return;
      paramModelData.animations.ensureCapacity(localJsonValue1.size);
      for (JsonValue localJsonValue2 = localJsonValue1.child; localJsonValue2 != null; localJsonValue2 = localJsonValue2.next)
      {
        JsonValue localJsonValue3 = localJsonValue2.get("bones");
        if (localJsonValue3 == null)
          continue;
        ModelAnimation localModelAnimation = new ModelAnimation();
        paramModelData.animations.add(localModelAnimation);
        localModelAnimation.nodeAnimations.ensureCapacity(localJsonValue3.size);
        localModelAnimation.id = localJsonValue2.getString("id");
        for (JsonValue localJsonValue4 = localJsonValue3.child; localJsonValue4 != null; localJsonValue4 = localJsonValue4.next)
        {
          ModelNodeAnimation localModelNodeAnimation = new ModelNodeAnimation();
          localModelAnimation.nodeAnimations.add(localModelNodeAnimation);
          localModelNodeAnimation.nodeId = localJsonValue4.getString("boneId");
          JsonValue localJsonValue5 = localJsonValue4.get("keyframes");
          JsonValue localJsonValue15;
          if ((localJsonValue5 != null) && (localJsonValue5.isArray()))
            localJsonValue15 = localJsonValue5.child;
          while (localJsonValue15 != null)
          {
            float f = localJsonValue15.getFloat("keytime", 0.0F) / 1000.0F;
            JsonValue localJsonValue16 = localJsonValue15.get("translation");
            if ((localJsonValue16 != null) && (localJsonValue16.size == 3))
            {
              if (localModelNodeAnimation.translation == null)
                localModelNodeAnimation.translation = new Array();
              ModelNodeKeyframe localModelNodeKeyframe6 = new ModelNodeKeyframe();
              localModelNodeKeyframe6.keytime = f;
              localModelNodeKeyframe6.value = new Vector3(localJsonValue16.getFloat(0), localJsonValue16.getFloat(1), localJsonValue16.getFloat(2));
              localModelNodeAnimation.translation.add(localModelNodeKeyframe6);
            }
            JsonValue localJsonValue17 = localJsonValue15.get("rotation");
            if ((localJsonValue17 != null) && (localJsonValue17.size == 4))
            {
              if (localModelNodeAnimation.rotation == null)
                localModelNodeAnimation.rotation = new Array();
              ModelNodeKeyframe localModelNodeKeyframe5 = new ModelNodeKeyframe();
              localModelNodeKeyframe5.keytime = f;
              localModelNodeKeyframe5.value = new Quaternion(localJsonValue17.getFloat(0), localJsonValue17.getFloat(1), localJsonValue17.getFloat(2), localJsonValue17.getFloat(3));
              localModelNodeAnimation.rotation.add(localModelNodeKeyframe5);
            }
            JsonValue localJsonValue18 = localJsonValue15.get("scale");
            if ((localJsonValue18 != null) && (localJsonValue18.size == 3))
            {
              if (localModelNodeAnimation.scaling == null)
                localModelNodeAnimation.scaling = new Array();
              ModelNodeKeyframe localModelNodeKeyframe4 = new ModelNodeKeyframe();
              localModelNodeKeyframe4.keytime = f;
              localModelNodeKeyframe4.value = new Vector3(localJsonValue18.getFloat(0), localJsonValue18.getFloat(1), localJsonValue18.getFloat(2));
              localModelNodeAnimation.scaling.add(localModelNodeKeyframe4);
            }
            localJsonValue15 = localJsonValue15.next;
            continue;
            JsonValue localJsonValue6 = localJsonValue4.get("translation");
            if ((localJsonValue6 != null) && (localJsonValue6.isArray()))
            {
              localModelNodeAnimation.translation = new Array();
              localModelNodeAnimation.translation.ensureCapacity(localJsonValue6.size);
              for (JsonValue localJsonValue13 = localJsonValue6.child; localJsonValue13 != null; localJsonValue13 = localJsonValue13.next)
              {
                ModelNodeKeyframe localModelNodeKeyframe3 = new ModelNodeKeyframe();
                localModelNodeAnimation.translation.add(localModelNodeKeyframe3);
                localModelNodeKeyframe3.keytime = (localJsonValue13.getFloat("keytime", 0.0F) / 1000.0F);
                JsonValue localJsonValue14 = localJsonValue13.get("value");
                if ((localJsonValue14 == null) || (localJsonValue14.size < 3))
                  continue;
                localModelNodeKeyframe3.value = new Vector3(localJsonValue14.getFloat(0), localJsonValue14.getFloat(1), localJsonValue14.getFloat(2));
              }
            }
            JsonValue localJsonValue7 = localJsonValue4.get("rotation");
            if ((localJsonValue7 != null) && (localJsonValue7.isArray()))
            {
              localModelNodeAnimation.rotation = new Array();
              localModelNodeAnimation.rotation.ensureCapacity(localJsonValue7.size);
              for (JsonValue localJsonValue11 = localJsonValue7.child; localJsonValue11 != null; localJsonValue11 = localJsonValue11.next)
              {
                ModelNodeKeyframe localModelNodeKeyframe2 = new ModelNodeKeyframe();
                localModelNodeAnimation.rotation.add(localModelNodeKeyframe2);
                localModelNodeKeyframe2.keytime = (localJsonValue11.getFloat("keytime", 0.0F) / 1000.0F);
                JsonValue localJsonValue12 = localJsonValue11.get("value");
                if ((localJsonValue12 == null) || (localJsonValue12.size < 4))
                  continue;
                localModelNodeKeyframe2.value = new Quaternion(localJsonValue12.getFloat(0), localJsonValue12.getFloat(1), localJsonValue12.getFloat(2), localJsonValue12.getFloat(3));
              }
            }
            JsonValue localJsonValue8 = localJsonValue4.get("scaling");
            if ((localJsonValue8 == null) || (!localJsonValue8.isArray()))
              break;
            localModelNodeAnimation.scaling = new Array();
            localModelNodeAnimation.scaling.ensureCapacity(localJsonValue8.size);
            for (JsonValue localJsonValue9 = localJsonValue8.child; localJsonValue9 != null; localJsonValue9 = localJsonValue9.next)
            {
              ModelNodeKeyframe localModelNodeKeyframe1 = new ModelNodeKeyframe();
              localModelNodeAnimation.scaling.add(localModelNodeKeyframe1);
              localModelNodeKeyframe1.keytime = (localJsonValue9.getFloat("keytime", 0.0F) / 1000.0F);
              JsonValue localJsonValue10 = localJsonValue9.get("value");
              if ((localJsonValue10 == null) || (localJsonValue10.size < 3))
                continue;
              localModelNodeKeyframe1.value = new Vector3(localJsonValue10.getFloat(0), localJsonValue10.getFloat(1), localJsonValue10.getFloat(2));
            }
          }
        }
      }
    }
  }

  private VertexAttribute[] parseAttributes(JsonValue paramJsonValue)
  {
    int i = 0;
    Array localArray = new Array();
    JsonValue localJsonValue1 = paramJsonValue.child;
    int j = 0;
    JsonValue localJsonValue2 = localJsonValue1;
    if (localJsonValue2 != null)
    {
      String str = localJsonValue2.asString();
      int m;
      if (str.equals("POSITION"))
      {
        localArray.add(VertexAttribute.Position());
        m = j;
      }
      while (true)
      {
        localJsonValue2 = localJsonValue2.next;
        j = m;
        break;
        if (str.equals("NORMAL"))
        {
          localArray.add(VertexAttribute.Normal());
          m = j;
          continue;
        }
        if (str.equals("COLOR"))
        {
          localArray.add(VertexAttribute.ColorUnpacked());
          m = j;
          continue;
        }
        if (str.equals("COLORPACKED"))
        {
          localArray.add(VertexAttribute.ColorPacked());
          m = j;
          continue;
        }
        if (str.equals("TANGENT"))
        {
          localArray.add(VertexAttribute.Tangent());
          m = j;
          continue;
        }
        if (str.equals("BINORMAL"))
        {
          localArray.add(VertexAttribute.Binormal());
          m = j;
          continue;
        }
        if (str.startsWith("TEXCOORD"))
        {
          m = j + 1;
          localArray.add(VertexAttribute.TexCoords(j));
          continue;
        }
        if (!str.startsWith("BLENDWEIGHT"))
          break label251;
        int k = i + 1;
        localArray.add(VertexAttribute.BoneWeight(i));
        i = k;
        m = j;
      }
      label251: throw new GdxRuntimeException("Unknown vertex attribute '" + str + "', should be one of position, normal, uv, tangent or binormal");
    }
    return (VertexAttribute[])localArray.toArray(VertexAttribute.class);
  }

  private Color parseColor(JsonValue paramJsonValue)
  {
    if (paramJsonValue.size >= 3)
      return new Color(paramJsonValue.getFloat(0), paramJsonValue.getFloat(1), paramJsonValue.getFloat(2), 1.0F);
    throw new GdxRuntimeException("Expected Color values <> than three.");
  }

  private void parseMaterials(ModelData paramModelData, JsonValue paramJsonValue, String paramString)
  {
    JsonValue localJsonValue1 = paramJsonValue.get("materials");
    if (localJsonValue1 != null)
    {
      paramModelData.materials.ensureCapacity(localJsonValue1.size);
      for (JsonValue localJsonValue2 = localJsonValue1.child; localJsonValue2 != null; localJsonValue2 = localJsonValue2.next)
      {
        ModelMaterial localModelMaterial = new ModelMaterial();
        String str1 = localJsonValue2.getString("id", null);
        if (str1 == null)
          throw new GdxRuntimeException("Material needs an id.");
        localModelMaterial.id = str1;
        JsonValue localJsonValue3 = localJsonValue2.get("diffuse");
        if (localJsonValue3 != null)
          localModelMaterial.diffuse = parseColor(localJsonValue3);
        JsonValue localJsonValue4 = localJsonValue2.get("ambient");
        if (localJsonValue4 != null)
          localModelMaterial.ambient = parseColor(localJsonValue4);
        JsonValue localJsonValue5 = localJsonValue2.get("emissive");
        if (localJsonValue5 != null)
          localModelMaterial.emissive = parseColor(localJsonValue5);
        JsonValue localJsonValue6 = localJsonValue2.get("specular");
        if (localJsonValue6 != null)
          localModelMaterial.specular = parseColor(localJsonValue6);
        JsonValue localJsonValue7 = localJsonValue2.get("reflection");
        if (localJsonValue7 != null)
          localModelMaterial.reflection = parseColor(localJsonValue7);
        localModelMaterial.shininess = localJsonValue2.getFloat("shininess", 0.0F);
        localModelMaterial.opacity = localJsonValue2.getFloat("opacity", 1.0F);
        JsonValue localJsonValue8 = localJsonValue2.get("textures");
        if (localJsonValue8 != null)
          for (JsonValue localJsonValue9 = localJsonValue8.child; localJsonValue9 != null; localJsonValue9 = localJsonValue9.next)
          {
            ModelTexture localModelTexture = new ModelTexture();
            String str2 = localJsonValue9.getString("id", null);
            if (str2 == null)
              throw new GdxRuntimeException("Texture has no id.");
            localModelTexture.id = str2;
            String str3 = localJsonValue9.getString("filename", null);
            if (str3 == null)
              throw new GdxRuntimeException("Texture needs filename.");
            StringBuilder localStringBuilder = new StringBuilder().append(paramString);
            if ((paramString.length() == 0) || (paramString.endsWith("/")));
            String str5;
            for (String str4 = ""; ; str4 = "/")
            {
              localModelTexture.fileName = (str4 + str3);
              localModelTexture.uvTranslation = readVector2(localJsonValue9.get("uvTranslation"), 0.0F, 0.0F);
              localModelTexture.uvScaling = readVector2(localJsonValue9.get("uvScaling"), 1.0F, 1.0F);
              str5 = localJsonValue9.getString("type", null);
              if (str5 != null)
                break;
              throw new GdxRuntimeException("Texture needs type.");
            }
            localModelTexture.usage = parseTextureUsage(str5);
            if (localModelMaterial.textures == null)
              localModelMaterial.textures = new Array();
            localModelMaterial.textures.add(localModelTexture);
          }
        paramModelData.materials.add(localModelMaterial);
      }
    }
  }

  private void parseMeshes(ModelData paramModelData, JsonValue paramJsonValue)
  {
    JsonValue localJsonValue1 = paramJsonValue.get("meshes");
    if (localJsonValue1 != null)
    {
      paramModelData.meshes.ensureCapacity(localJsonValue1.size);
      for (JsonValue localJsonValue2 = localJsonValue1.child; localJsonValue2 != null; localJsonValue2 = localJsonValue2.next)
      {
        ModelMesh localModelMesh = new ModelMesh();
        localModelMesh.id = localJsonValue2.getString("id", "");
        localModelMesh.attributes = parseAttributes(localJsonValue2.require("attributes"));
        localModelMesh.vertices = localJsonValue2.require("vertices").asFloatArray();
        JsonValue localJsonValue3 = localJsonValue2.require("parts");
        Array localArray = new Array();
        for (JsonValue localJsonValue4 = localJsonValue3.child; localJsonValue4 != null; localJsonValue4 = localJsonValue4.next)
        {
          ModelMeshPart localModelMeshPart = new ModelMeshPart();
          String str1 = localJsonValue4.getString("id", null);
          if (str1 == null)
            throw new GdxRuntimeException("Not id given for mesh part");
          Iterator localIterator = localArray.iterator();
          while (localIterator.hasNext())
          {
            if (!((ModelMeshPart)localIterator.next()).id.equals(str1))
              continue;
            throw new GdxRuntimeException("Mesh part with id '" + str1 + "' already in defined");
          }
          localModelMeshPart.id = str1;
          String str2 = localJsonValue4.getString("type", null);
          if (str2 == null)
            throw new GdxRuntimeException("No primitive type given for mesh part '" + str1 + "'");
          localModelMeshPart.primitiveType = parseType(str2);
          localModelMeshPart.indices = localJsonValue4.require("indices").asShortArray();
          localArray.add(localModelMeshPart);
        }
        localModelMesh.parts = ((ModelMeshPart[])localArray.toArray(ModelMeshPart.class));
        paramModelData.meshes.add(localModelMesh);
      }
    }
  }

  private Array parseNodes(ModelData paramModelData, JsonValue paramJsonValue)
  {
    JsonValue localJsonValue1 = paramJsonValue.get("nodes");
    if (localJsonValue1 != null)
    {
      paramModelData.nodes.ensureCapacity(localJsonValue1.size);
      for (JsonValue localJsonValue2 = localJsonValue1.child; localJsonValue2 != null; localJsonValue2 = localJsonValue2.next)
        paramModelData.nodes.add(parseNodesRecursively(localJsonValue2));
    }
    return paramModelData.nodes;
  }

  private ModelNode parseNodesRecursively(JsonValue paramJsonValue)
  {
    ModelNode localModelNode = new ModelNode();
    String str1 = paramJsonValue.getString("id", null);
    if (str1 == null)
      throw new GdxRuntimeException("Node id missing.");
    localModelNode.id = str1;
    JsonValue localJsonValue1 = paramJsonValue.get("translation");
    if ((localJsonValue1 != null) && (localJsonValue1.size != 3))
      throw new GdxRuntimeException("Node translation incomplete");
    if (localJsonValue1 == null);
    JsonValue localJsonValue2;
    for (Vector3 localVector31 = null; ; localVector31 = new Vector3(localJsonValue1.getFloat(0), localJsonValue1.getFloat(1), localJsonValue1.getFloat(2)))
    {
      localModelNode.translation = localVector31;
      localJsonValue2 = paramJsonValue.get("rotation");
      if ((localJsonValue2 == null) || (localJsonValue2.size == 4))
        break;
      throw new GdxRuntimeException("Node rotation incomplete");
    }
    if (localJsonValue2 == null);
    JsonValue localJsonValue3;
    for (Quaternion localQuaternion = null; ; localQuaternion = new Quaternion(localJsonValue2.getFloat(0), localJsonValue2.getFloat(1), localJsonValue2.getFloat(2), localJsonValue2.getFloat(3)))
    {
      localModelNode.rotation = localQuaternion;
      localJsonValue3 = paramJsonValue.get("scale");
      if ((localJsonValue3 == null) || (localJsonValue3.size == 3))
        break;
      throw new GdxRuntimeException("Node scale incomplete");
    }
    Vector3 localVector32;
    JsonValue localJsonValue7;
    if (localJsonValue3 == null)
    {
      localVector32 = null;
      localModelNode.scale = localVector32;
      String str2 = paramJsonValue.getString("mesh", null);
      if (str2 != null)
        localModelNode.meshId = str2;
      JsonValue localJsonValue4 = paramJsonValue.get("parts");
      if (localJsonValue4 != null)
      {
        localModelNode.parts = new ModelNodePart[localJsonValue4.size];
        localJsonValue7 = localJsonValue4.child;
      }
    }
    else
    {
      for (int j = 0; ; j++)
      {
        if (localJsonValue7 == null)
          break label705;
        ModelNodePart localModelNodePart = new ModelNodePart();
        String str3 = localJsonValue7.getString("meshpartid", null);
        String str4 = localJsonValue7.getString("materialid", null);
        if ((str3 == null) || (str4 == null))
        {
          throw new GdxRuntimeException("Node " + str1 + " part is missing meshPartId or materialId");
          localVector32 = new Vector3(localJsonValue3.getFloat(0), localJsonValue3.getFloat(1), localJsonValue3.getFloat(2));
          break;
        }
        localModelNodePart.materialId = str4;
        localModelNodePart.meshPartId = str3;
        JsonValue localJsonValue8 = localJsonValue7.get("bones");
        if (localJsonValue8 != null)
        {
          localModelNodePart.bones = new ArrayMap(true, localJsonValue8.size, String.class, Matrix4.class);
          for (JsonValue localJsonValue9 = localJsonValue8.child; localJsonValue9 != null; localJsonValue9 = localJsonValue9.next)
          {
            String str5 = localJsonValue9.getString("node", null);
            if (str5 == null)
              throw new GdxRuntimeException("Bone node ID missing");
            Matrix4 localMatrix4 = new Matrix4();
            JsonValue localJsonValue10 = localJsonValue9.get("translation");
            if ((localJsonValue10 != null) && (localJsonValue10.size >= 3))
              localMatrix4.translate(localJsonValue10.getFloat(0), localJsonValue10.getFloat(1), localJsonValue10.getFloat(2));
            JsonValue localJsonValue11 = localJsonValue9.get("rotation");
            if ((localJsonValue11 != null) && (localJsonValue11.size >= 4))
              localMatrix4.rotate(this.tempQ.set(localJsonValue11.getFloat(0), localJsonValue11.getFloat(1), localJsonValue11.getFloat(2), localJsonValue11.getFloat(3)));
            JsonValue localJsonValue12 = localJsonValue9.get("scale");
            if ((localJsonValue12 != null) && (localJsonValue12.size >= 3))
              localMatrix4.scale(localJsonValue12.getFloat(0), localJsonValue12.getFloat(1), localJsonValue12.getFloat(2));
            localModelNodePart.bones.put(str5, localMatrix4);
          }
        }
        localModelNode.parts[j] = localModelNodePart;
        localJsonValue7 = localJsonValue7.next;
      }
    }
    label705: JsonValue localJsonValue5 = paramJsonValue.get("children");
    if (localJsonValue5 != null)
    {
      localModelNode.children = new ModelNode[localJsonValue5.size];
      int i = 0;
      JsonValue localJsonValue6 = localJsonValue5.child;
      while (localJsonValue6 != null)
      {
        localModelNode.children[i] = parseNodesRecursively(localJsonValue6);
        localJsonValue6 = localJsonValue6.next;
        i++;
      }
    }
    return localModelNode;
  }

  private int parseTextureUsage(String paramString)
  {
    if (paramString.equalsIgnoreCase("AMBIENT"))
      return 4;
    if (paramString.equalsIgnoreCase("BUMP"))
      return 8;
    if (paramString.equalsIgnoreCase("DIFFUSE"))
      return 2;
    if (paramString.equalsIgnoreCase("EMISSIVE"))
      return 3;
    if (paramString.equalsIgnoreCase("NONE"))
      return 1;
    if (paramString.equalsIgnoreCase("NORMAL"))
      return 7;
    if (paramString.equalsIgnoreCase("REFLECTION"))
      return 10;
    if (paramString.equalsIgnoreCase("SHININESS"))
      return 6;
    if (paramString.equalsIgnoreCase("SPECULAR"))
      return 5;
    if (paramString.equalsIgnoreCase("TRANSPARENCY"))
      return 9;
    return 0;
  }

  private int parseType(String paramString)
  {
    if (paramString.equals("TRIANGLES"))
      return 4;
    if (paramString.equals("LINES"))
      return 1;
    if (paramString.equals("POINTS"))
      return 0;
    if (paramString.equals("TRIANGLE_STRIP"))
      return 5;
    if (paramString.equals("LINE_STRIP"))
      return 3;
    throw new GdxRuntimeException("Unknown primitive type '" + paramString + "', should be one of triangle, trianglestrip, line, linestrip, lineloop or point");
  }

  private Vector2 readVector2(JsonValue paramJsonValue, float paramFloat1, float paramFloat2)
  {
    if (paramJsonValue == null)
      return new Vector2(paramFloat1, paramFloat2);
    if (paramJsonValue.size == 2)
      return new Vector2(paramJsonValue.getFloat(0), paramJsonValue.getFloat(1));
    throw new GdxRuntimeException("Expected Vector2 values <> than two.");
  }

  public ModelData loadModelData(FileHandle paramFileHandle, ModelLoader.ModelParameters paramModelParameters)
  {
    return parseModel(paramFileHandle);
  }

  public ModelData parseModel(FileHandle paramFileHandle)
  {
    JsonValue localJsonValue1 = this.reader.parse(paramFileHandle);
    ModelData localModelData = new ModelData();
    JsonValue localJsonValue2 = localJsonValue1.require("version");
    localModelData.version[0] = localJsonValue2.getShort(0);
    localModelData.version[1] = localJsonValue2.getShort(1);
    if ((localModelData.version[0] != 0) || (localModelData.version[1] != 1))
      throw new GdxRuntimeException("Model version not supported");
    localModelData.id = localJsonValue1.getString("id", "");
    parseMeshes(localModelData, localJsonValue1);
    parseMaterials(localModelData, localJsonValue1, paramFileHandle.parent().path());
    parseNodes(localModelData, localJsonValue1);
    parseAnimations(localModelData, localJsonValue1);
    return localModelData;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader
 * JD-Core Version:    0.6.0
 */