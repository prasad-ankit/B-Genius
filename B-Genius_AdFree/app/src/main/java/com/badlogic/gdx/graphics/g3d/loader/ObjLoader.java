package com.badlogic.gdx.graphics.g3d.loader;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.ModelLoader;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.model.data.ModelData;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMesh;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMeshPart;
import com.badlogic.gdx.graphics.g3d.model.data.ModelNode;
import com.badlogic.gdx.graphics.g3d.model.data.ModelNodePart;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.FloatArray;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class ObjLoader extends ModelLoader
{
  public static boolean logWarning = false;
  final Array groups = new Array(10);
  final FloatArray norms = new FloatArray(300);
  final FloatArray uvs = new FloatArray(200);
  final FloatArray verts = new FloatArray(300);

  public ObjLoader()
  {
    this(null);
  }

  public ObjLoader(FileHandleResolver paramFileHandleResolver)
  {
    super(paramFileHandleResolver);
  }

  private int getIndex(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return 0;
    int i = Integer.parseInt(paramString);
    if (i < 0)
      return i + paramInt;
    return i - 1;
  }

  private ObjLoader.Group setActiveGroup(String paramString)
  {
    Iterator localIterator = this.groups.iterator();
    while (localIterator.hasNext())
    {
      ObjLoader.Group localGroup2 = (ObjLoader.Group)localIterator.next();
      if (localGroup2.name.equals(paramString))
        return localGroup2;
    }
    ObjLoader.Group localGroup1 = new ObjLoader.Group(this, paramString);
    this.groups.add(localGroup1);
    return localGroup1;
  }

  public Model loadModel(FileHandle paramFileHandle, boolean paramBoolean)
  {
    return loadModel(paramFileHandle, new ObjLoader.ObjLoaderParameters(paramBoolean));
  }

  public ModelData loadModelData(FileHandle paramFileHandle, ObjLoader.ObjLoaderParameters paramObjLoaderParameters)
  {
    if (paramObjLoaderParameters == null);
    for (boolean bool = false; ; bool = paramObjLoaderParameters.flipV)
      return loadModelData(paramFileHandle, bool);
  }

  protected ModelData loadModelData(FileHandle paramFileHandle, boolean paramBoolean)
  {
    if (logWarning)
      Gdx.app.error("ObjLoader", "Wavefront (OBJ) is not fully supported, consult the documentation for more information");
    MtlLoader localMtlLoader = new MtlLoader();
    ObjLoader.Group localGroup1 = new ObjLoader.Group(this, "default");
    this.groups.add(localGroup1);
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramFileHandle.read()), 4096);
    ObjLoader.Group localGroup2 = localGroup1;
    while (true)
    {
      int i32;
      try
      {
        String str1 = localBufferedReader.readLine();
        if (str1 == null)
          continue;
        String[] arrayOfString1 = str1.split("\\s+");
        if (arrayOfString1.length > 0)
          continue;
        localBufferedReader.close();
        int i = 0;
        if (i >= this.groups.size)
          continue;
        if (((ObjLoader.Group)this.groups.get(i)).numFaces > 0)
          continue;
        this.groups.removeIndex(i);
        i--;
        i++;
        continue;
        if (arrayOfString1[0].length() == 0)
          continue;
        i32 = arrayOfString1[0].toLowerCase().charAt(0);
        if (i32 == 35)
          continue;
        if (i32 != 118)
          continue;
        if (arrayOfString1[0].length() != 1)
          continue;
        this.verts.add(Float.parseFloat(arrayOfString1[1]));
        this.verts.add(Float.parseFloat(arrayOfString1[2]));
        this.verts.add(Float.parseFloat(arrayOfString1[3]));
        continue;
        if (arrayOfString1[0].charAt(1) != 'n')
          continue;
        this.norms.add(Float.parseFloat(arrayOfString1[1]));
        this.norms.add(Float.parseFloat(arrayOfString1[2]));
        this.norms.add(Float.parseFloat(arrayOfString1[3]));
        continue;
        if (arrayOfString1[0].charAt(1) != 't')
          continue;
        this.uvs.add(Float.parseFloat(arrayOfString1[1]));
        FloatArray localFloatArray6 = this.uvs;
        if (!paramBoolean)
          continue;
        float f = 1.0F - Float.parseFloat(arrayOfString1[2]);
        localFloatArray6.add(f);
        continue;
        f = Float.parseFloat(arrayOfString1[2]);
        continue;
        if (i32 == 102)
        {
          Array localArray3 = localGroup2.faces;
          int i33 = 1;
          if (i33 >= -2 + arrayOfString1.length)
            continue;
          String[] arrayOfString2 = arrayOfString1[1].split("/");
          localArray3.add(Integer.valueOf(getIndex(arrayOfString2[0], this.verts.size)));
          if (arrayOfString2.length <= 2)
            continue;
          if (i33 != 1)
            continue;
          localGroup2.hasNorms = true;
          localArray3.add(Integer.valueOf(getIndex(arrayOfString2[2], this.norms.size)));
          if ((arrayOfString2.length <= 1) || (arrayOfString2[1].length() <= 0))
            continue;
          if (i33 != 1)
            continue;
          localGroup2.hasUVs = true;
          localArray3.add(Integer.valueOf(getIndex(arrayOfString2[1], this.uvs.size)));
          int i34 = i33 + 1;
          String[] arrayOfString3 = arrayOfString1[i34].split("/");
          localArray3.add(Integer.valueOf(getIndex(arrayOfString3[0], this.verts.size)));
          if (arrayOfString3.length <= 2)
            continue;
          localArray3.add(Integer.valueOf(getIndex(arrayOfString3[2], this.norms.size)));
          if ((arrayOfString3.length <= 1) || (arrayOfString3[1].length() <= 0))
            continue;
          localArray3.add(Integer.valueOf(getIndex(arrayOfString3[1], this.uvs.size)));
          int i35 = i34 + 1;
          String[] arrayOfString4 = arrayOfString1[i35].split("/");
          localArray3.add(Integer.valueOf(getIndex(arrayOfString4[0], this.verts.size)));
          if (arrayOfString4.length <= 2)
            continue;
          localArray3.add(Integer.valueOf(getIndex(arrayOfString4[2], this.norms.size)));
          if ((arrayOfString4.length <= 1) || (arrayOfString4[1].length() <= 0))
            continue;
          localArray3.add(Integer.valueOf(getIndex(arrayOfString4[1], this.uvs.size)));
          localGroup2.numFaces = (1 + localGroup2.numFaces);
          i33 = i35 - 1;
          continue;
          if (arrayOfString1.length <= 1)
            continue;
          localGroup2 = setActiveGroup(arrayOfString1[1]);
          continue;
          localGroup2 = setActiveGroup("default");
          continue;
          if (!arrayOfString1[0].equals("mtllib"))
            continue;
          localMtlLoader.load(paramFileHandle.parent().child(arrayOfString1[1]));
          continue;
          if (!arrayOfString1[0].equals("usemtl"))
            continue;
          if (arrayOfString1.length != 1)
            continue;
          localGroup2.materialName = "default";
          continue;
          localGroup2.materialName = arrayOfString1[1].replace('.', '_');
          continue;
          if (this.groups.size <= 0)
            return null;
          int j = this.groups.size;
          ModelData localModelData = new ModelData();
          int k = 0;
          int m = 0;
          if (k >= j)
            continue;
          ObjLoader.Group localGroup3 = (ObjLoader.Group)this.groups.get(k);
          Array localArray1 = localGroup3.faces;
          int n = localArray1.size;
          int i1 = localGroup3.numFaces;
          boolean bool1 = localGroup3.hasNorms;
          boolean bool2 = localGroup3.hasUVs;
          int i2 = i1 * 3;
          if (!bool1)
            continue;
          int i3 = 3;
          int i4 = i3 + 3;
          if (!bool2)
            continue;
          int i5 = 2;
          float[] arrayOfFloat = new float[i2 * (i5 + i4)];
          int i6 = 0;
          int i7 = 0;
          if (i6 >= n)
            continue;
          int i10 = i6 + 1;
          int i11 = 3 * ((Integer)localArray1.get(i6)).intValue();
          int i12 = i7 + 1;
          FloatArray localFloatArray1 = this.verts;
          int i13 = i11 + 1;
          arrayOfFloat[i7] = localFloatArray1.get(i11);
          int i14 = i12 + 1;
          FloatArray localFloatArray2 = this.verts;
          int i15 = i13 + 1;
          arrayOfFloat[i12] = localFloatArray2.get(i13);
          int i16 = i14 + 1;
          arrayOfFloat[i14] = this.verts.get(i15);
          if (!bool1)
            continue;
          int i26 = i10 + 1;
          int i27 = 3 * ((Integer)localArray1.get(i10)).intValue();
          int i28 = i16 + 1;
          FloatArray localFloatArray4 = this.norms;
          int i29 = i27 + 1;
          arrayOfFloat[i16] = localFloatArray4.get(i27);
          int i30 = i28 + 1;
          FloatArray localFloatArray5 = this.norms;
          int i31 = i29 + 1;
          arrayOfFloat[i28] = localFloatArray5.get(i29);
          i16 = i30 + 1;
          arrayOfFloat[i30] = this.norms.get(i31);
          int i17 = i26;
          if (!bool2)
            continue;
          int i22 = i17 + 1;
          int i23 = ((Integer)localArray1.get(i17)).intValue() << 1;
          int i24 = i16 + 1;
          FloatArray localFloatArray3 = this.uvs;
          int i25 = i23 + 1;
          arrayOfFloat[i16] = localFloatArray3.get(i23);
          int i20 = i24 + 1;
          arrayOfFloat[i24] = this.uvs.get(i25);
          int i19 = i22;
          int i21 = i20;
          i6 = i19;
          i7 = i21;
          continue;
          i3 = 0;
          continue;
          i5 = 0;
          continue;
          if (i1 * 3 < 32767)
            continue;
          int i8 = 0;
          short[] arrayOfShort = new short[i8];
          if (i8 <= 0)
            continue;
          int i9 = 0;
          if (i9 >= i8)
            continue;
          arrayOfShort[i9] = (short)i9;
          i9++;
          continue;
          i8 = i1 * 3;
          continue;
          Array localArray2 = new Array();
          localArray2.add(new VertexAttribute(1, 3, "a_position"));
          if (!bool1)
            continue;
          localArray2.add(new VertexAttribute(8, 3, "a_normal"));
          if (!bool2)
            continue;
          localArray2.add(new VertexAttribute(16, 2, "a_texCoord0"));
          m++;
          String str2 = Integer.toString(m);
          if (!"default".equals(localGroup3.name))
            continue;
          String str3 = "node" + str2;
          if (!"default".equals(localGroup3.name))
            continue;
          String str4 = "mesh" + str2;
          if (!"default".equals(localGroup3.name))
            continue;
          String str5 = "part" + str2;
          ModelNode localModelNode = new ModelNode();
          localModelNode.id = str3;
          localModelNode.meshId = str4;
          localModelNode.scale = new Vector3(1.0F, 1.0F, 1.0F);
          localModelNode.translation = new Vector3();
          localModelNode.rotation = new Quaternion();
          ModelNodePart localModelNodePart = new ModelNodePart();
          localModelNodePart.meshPartId = str5;
          localModelNodePart.materialId = localGroup3.materialName;
          localModelNode.parts = new ModelNodePart[] { localModelNodePart };
          ModelMeshPart localModelMeshPart = new ModelMeshPart();
          localModelMeshPart.id = str5;
          localModelMeshPart.indices = arrayOfShort;
          localModelMeshPart.primitiveType = 4;
          ModelMesh localModelMesh = new ModelMesh();
          localModelMesh.id = str4;
          localModelMesh.attributes = ((VertexAttribute[])localArray2.toArray(VertexAttribute.class));
          localModelMesh.vertices = arrayOfFloat;
          localModelMesh.parts = new ModelMeshPart[] { localModelMeshPart };
          localModelData.nodes.add(localModelNode);
          localModelData.meshes.add(localModelMesh);
          ModelMaterial localModelMaterial = localMtlLoader.getMaterial(localGroup3.materialName);
          localModelData.materials.add(localModelMaterial);
          k++;
          continue;
          str3 = localGroup3.name;
          continue;
          str4 = localGroup3.name;
          continue;
          str5 = localGroup3.name;
          continue;
          if (this.verts.size <= 0)
            continue;
          this.verts.clear();
          if (this.norms.size <= 0)
            continue;
          this.norms.clear();
          if (this.uvs.size <= 0)
            continue;
          this.uvs.clear();
          if (this.groups.size <= 0)
            continue;
          this.groups.clear();
          return localModelData;
          int i18 = i16;
          i19 = i17;
          i20 = i18;
          continue;
          i17 = i10;
          continue;
        }
      }
      catch (IOException localIOException)
      {
        return null;
      }
      if (i32 == 111)
        continue;
      if (i32 != 103)
        continue;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.loader.ObjLoader
 * JD-Core Version:    0.6.0
 */