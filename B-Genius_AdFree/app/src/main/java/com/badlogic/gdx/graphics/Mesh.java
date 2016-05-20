package com.badlogic.gdx.graphics;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.IndexArray;
import com.badlogic.gdx.graphics.glutils.IndexBufferObject;
import com.badlogic.gdx.graphics.glutils.IndexBufferObjectSubData;
import com.badlogic.gdx.graphics.glutils.IndexData;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.graphics.glutils.VertexArray;
import com.badlogic.gdx.graphics.glutils.VertexBufferObject;
import com.badlogic.gdx.graphics.glutils.VertexBufferObjectSubData;
import com.badlogic.gdx.graphics.glutils.VertexBufferObjectWithVAO;
import com.badlogic.gdx.graphics.glutils.VertexData;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Mesh
  implements Disposable
{
  static final Map meshes = new HashMap();
  boolean autoBind = true;
  final IndexData indices;
  final boolean isVertexArray;
  private final Vector3 tmpV = new Vector3();
  final VertexData vertices;

  public Mesh(Mesh.VertexDataType paramVertexDataType, boolean paramBoolean, int paramInt1, int paramInt2, VertexAttribute[] paramArrayOfVertexAttribute)
  {
    switch (Mesh.1.$SwitchMap$com$badlogic$gdx$graphics$Mesh$VertexDataType[paramVertexDataType.ordinal()])
    {
    default:
      this.vertices = new VertexArray(paramInt1, paramArrayOfVertexAttribute);
      this.indices = new IndexArray(paramInt2);
      this.isVertexArray = true;
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      addManagedMesh(Gdx.app, this);
      return;
      this.vertices = new VertexBufferObject(paramBoolean, paramInt1, paramArrayOfVertexAttribute);
      this.indices = new IndexBufferObject(paramBoolean, paramInt2);
      this.isVertexArray = false;
      continue;
      this.vertices = new VertexBufferObjectSubData(paramBoolean, paramInt1, paramArrayOfVertexAttribute);
      this.indices = new IndexBufferObjectSubData(paramBoolean, paramInt2);
      this.isVertexArray = false;
      continue;
      this.vertices = new VertexBufferObjectWithVAO(paramBoolean, paramInt1, paramArrayOfVertexAttribute);
      this.indices = new IndexBufferObjectSubData(paramBoolean, paramInt2);
      this.isVertexArray = false;
    }
  }

  protected Mesh(VertexData paramVertexData, IndexData paramIndexData, boolean paramBoolean)
  {
    this.vertices = paramVertexData;
    this.indices = paramIndexData;
    this.isVertexArray = paramBoolean;
    addManagedMesh(Gdx.app, this);
  }

  public Mesh(boolean paramBoolean, int paramInt1, int paramInt2, VertexAttributes paramVertexAttributes)
  {
    this.vertices = makeVertexBuffer(paramBoolean, paramInt1, paramVertexAttributes);
    this.indices = new IndexBufferObject(paramBoolean, paramInt2);
    this.isVertexArray = false;
    addManagedMesh(Gdx.app, this);
  }

  public Mesh(boolean paramBoolean, int paramInt1, int paramInt2, VertexAttribute[] paramArrayOfVertexAttribute)
  {
    this.vertices = makeVertexBuffer(paramBoolean, paramInt1, new VertexAttributes(paramArrayOfVertexAttribute));
    this.indices = new IndexBufferObject(paramBoolean, paramInt2);
    this.isVertexArray = false;
    addManagedMesh(Gdx.app, this);
  }

  public Mesh(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, VertexAttributes paramVertexAttributes)
  {
    this.vertices = makeVertexBuffer(paramBoolean1, paramInt1, paramVertexAttributes);
    this.indices = new IndexBufferObject(paramBoolean2, paramInt2);
    this.isVertexArray = false;
    addManagedMesh(Gdx.app, this);
  }

  private static void addManagedMesh(Application paramApplication, Mesh paramMesh)
  {
    Array localArray = (Array)meshes.get(paramApplication);
    if (localArray == null)
      localArray = new Array();
    localArray.add(paramMesh);
    meshes.put(paramApplication, localArray);
  }

  public static void clearAllMeshes(Application paramApplication)
  {
    meshes.remove(paramApplication);
  }

  public static String getManagedStatus()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Managed meshes/app: { ");
    Iterator localIterator = meshes.keySet().iterator();
    while (localIterator.hasNext())
    {
      Application localApplication = (Application)localIterator.next();
      localStringBuilder.append(((Array)meshes.get(localApplication)).size);
      localStringBuilder.append(" ");
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }

  public static void invalidateAllMeshes(Application paramApplication)
  {
    Array localArray = (Array)meshes.get(paramApplication);
    if (localArray == null);
    while (true)
    {
      return;
      for (int i = 0; i < localArray.size; i++)
      {
        ((Mesh)localArray.get(i)).vertices.invalidate();
        ((Mesh)localArray.get(i)).indices.invalidate();
      }
    }
  }

  private VertexData makeVertexBuffer(boolean paramBoolean, int paramInt, VertexAttributes paramVertexAttributes)
  {
    if (Gdx.gl30 != null)
      return new VertexBufferObjectWithVAO(paramBoolean, paramInt, paramVertexAttributes);
    return new VertexBufferObject(paramBoolean, paramInt, paramVertexAttributes);
  }

  public static void transform(Matrix4 paramMatrix4, float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((paramInt2 < 0) || (paramInt3 <= 0) || (paramInt2 + paramInt3 > paramInt1))
      throw new IndexOutOfBoundsException();
    if ((paramInt4 < 0) || (paramInt5 <= 0) || (paramInt1 * (paramInt4 + paramInt5) > paramArrayOfFloat.length))
      throw new IndexOutOfBoundsException("start = " + paramInt4 + ", count = " + paramInt5 + ", vertexSize = " + paramInt1 + ", length = " + paramArrayOfFloat.length);
    Vector3 localVector3 = new Vector3();
    int i = paramInt2 + paramInt4 * paramInt1;
    int j = 0;
    switch (paramInt3)
    {
    default:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return;
      while (j < paramInt5)
      {
        localVector3.set(paramArrayOfFloat[i], 0.0F, 0.0F).mul(paramMatrix4);
        paramArrayOfFloat[i] = localVector3.x;
        i += paramInt1;
        j++;
      }
      while (j < paramInt5)
      {
        localVector3.set(paramArrayOfFloat[i], paramArrayOfFloat[(i + 1)], 0.0F).mul(paramMatrix4);
        paramArrayOfFloat[i] = localVector3.x;
        paramArrayOfFloat[(i + 1)] = localVector3.y;
        i += paramInt1;
        j++;
      }
      continue;
      while (j < paramInt5)
      {
        localVector3.set(paramArrayOfFloat[i], paramArrayOfFloat[(i + 1)], paramArrayOfFloat[(i + 2)]).mul(paramMatrix4);
        paramArrayOfFloat[i] = localVector3.x;
        paramArrayOfFloat[(i + 1)] = localVector3.y;
        paramArrayOfFloat[(i + 2)] = localVector3.z;
        i += paramInt1;
        j++;
      }
    }
  }

  public static void transformUV(Matrix3 paramMatrix3, float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt3 < 0) || (paramInt4 <= 0) || (paramInt1 * (paramInt3 + paramInt4) > paramArrayOfFloat.length))
      throw new IndexOutOfBoundsException("start = " + paramInt3 + ", count = " + paramInt4 + ", vertexSize = " + paramInt1 + ", length = " + paramArrayOfFloat.length);
    Vector2 localVector2 = new Vector2();
    int i = paramInt2 + paramInt3 * paramInt1;
    for (int j = 0; j < paramInt4; j++)
    {
      localVector2.set(paramArrayOfFloat[i], paramArrayOfFloat[(i + 1)]).mul(paramMatrix3);
      paramArrayOfFloat[i] = localVector2.x;
      paramArrayOfFloat[(i + 1)] = localVector2.y;
      i += paramInt1;
    }
  }

  public void bind(ShaderProgram paramShaderProgram)
  {
    bind(paramShaderProgram, null);
  }

  public void bind(ShaderProgram paramShaderProgram, int[] paramArrayOfInt)
  {
    this.vertices.bind(paramShaderProgram, paramArrayOfInt);
    if (this.indices.getNumIndices() > 0)
      this.indices.bind();
  }

  public BoundingBox calculateBoundingBox()
  {
    BoundingBox localBoundingBox = new BoundingBox();
    calculateBoundingBox(localBoundingBox);
    return localBoundingBox;
  }

  public BoundingBox calculateBoundingBox(BoundingBox paramBoundingBox, int paramInt1, int paramInt2)
  {
    return extendBoundingBox(paramBoundingBox.inf(), paramInt1, paramInt2);
  }

  public BoundingBox calculateBoundingBox(BoundingBox paramBoundingBox, int paramInt1, int paramInt2, Matrix4 paramMatrix4)
  {
    return extendBoundingBox(paramBoundingBox.inf(), paramInt1, paramInt2, paramMatrix4);
  }

  public void calculateBoundingBox(BoundingBox paramBoundingBox)
  {
    int i = getNumVertices();
    if (i == 0)
      throw new GdxRuntimeException("No vertices defined");
    FloatBuffer localFloatBuffer = this.vertices.getBuffer();
    paramBoundingBox.inf();
    VertexAttribute localVertexAttribute = getVertexAttribute(1);
    int j = localVertexAttribute.offset / 4;
    int k = this.vertices.getAttributes().vertexSize / 4;
    int m = localVertexAttribute.numComponents;
    int n = 0;
    switch (m)
    {
    default:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return;
      while (n < i)
      {
        paramBoundingBox.ext(localFloatBuffer.get(j), 0.0F, 0.0F);
        j += k;
        n++;
      }
      while (n < i)
      {
        paramBoundingBox.ext(localFloatBuffer.get(j), localFloatBuffer.get(j + 1), 0.0F);
        j += k;
        n++;
      }
      continue;
      while (n < i)
      {
        paramBoundingBox.ext(localFloatBuffer.get(j), localFloatBuffer.get(j + 1), localFloatBuffer.get(j + 2));
        j += k;
        n++;
      }
    }
  }

  public float calculateRadius(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return calculateRadius(paramFloat1, paramFloat2, paramFloat3, 0, getNumIndices(), null);
  }

  public float calculateRadius(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2)
  {
    return calculateRadius(paramFloat1, paramFloat2, paramFloat3, paramInt1, paramInt2, null);
  }

  public float calculateRadius(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, Matrix4 paramMatrix4)
  {
    return (float)Math.sqrt(calculateRadiusSquared(paramFloat1, paramFloat2, paramFloat3, paramInt1, paramInt2, paramMatrix4));
  }

  public float calculateRadius(Vector3 paramVector3)
  {
    return calculateRadius(paramVector3.x, paramVector3.y, paramVector3.z, 0, getNumIndices(), null);
  }

  public float calculateRadius(Vector3 paramVector3, int paramInt1, int paramInt2)
  {
    return calculateRadius(paramVector3.x, paramVector3.y, paramVector3.z, paramInt1, paramInt2, null);
  }

  public float calculateRadius(Vector3 paramVector3, int paramInt1, int paramInt2, Matrix4 paramMatrix4)
  {
    return calculateRadius(paramVector3.x, paramVector3.y, paramVector3.z, paramInt1, paramInt2, paramMatrix4);
  }

  public float calculateRadiusSquared(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, Matrix4 paramMatrix4)
  {
    int i = getNumIndices();
    if ((paramInt1 < 0) || (paramInt2 <= 0) || (paramInt1 + paramInt2 > i))
      throw new GdxRuntimeException("Not enough indices");
    FloatBuffer localFloatBuffer = this.vertices.getBuffer();
    ShortBuffer localShortBuffer = this.indices.getBuffer();
    VertexAttribute localVertexAttribute = getVertexAttribute(1);
    int j = localVertexAttribute.offset / 4;
    int k = this.vertices.getAttributes().vertexSize / 4;
    int m = paramInt1 + paramInt2;
    int n = localVertexAttribute.numComponents;
    float f1 = 0.0F;
    label139: float f4;
    switch (n)
    {
    default:
    case 1:
      do
        return f1;
      while (paramInt1 >= m);
      int i3 = j + k * localShortBuffer.get(paramInt1);
      this.tmpV.set(localFloatBuffer.get(i3), 0.0F, 0.0F);
      if (paramMatrix4 != null)
        this.tmpV.mul(paramMatrix4);
      f4 = this.tmpV.sub(paramFloat1, paramFloat2, paramFloat3).len2();
      if (f4 <= f1)
        break;
    case 2:
    case 3:
    }
    while (true)
    {
      paramInt1++;
      f1 = f4;
      break label139;
      label226: if (paramInt1 >= m)
        break;
      int i2 = j + k * localShortBuffer.get(paramInt1);
      this.tmpV.set(localFloatBuffer.get(i2), localFloatBuffer.get(i2 + 1), 0.0F);
      if (paramMatrix4 != null)
        this.tmpV.mul(paramMatrix4);
      float f3 = this.tmpV.sub(paramFloat1, paramFloat2, paramFloat3).len2();
      if (f3 > f1);
      while (true)
      {
        paramInt1++;
        f1 = f3;
        break label226;
        label321: float f2;
        if (paramInt1 < m)
        {
          int i1 = j + k * localShortBuffer.get(paramInt1);
          this.tmpV.set(localFloatBuffer.get(i1), localFloatBuffer.get(i1 + 1), localFloatBuffer.get(i1 + 2));
          if (paramMatrix4 != null)
            this.tmpV.mul(paramMatrix4);
          f2 = this.tmpV.sub(paramFloat1, paramFloat2, paramFloat3).len2();
          if (f2 <= f1)
            break label424;
        }
        while (true)
        {
          paramInt1++;
          f1 = f2;
          break label321;
          break;
          label424: f2 = f1;
        }
        f3 = f1;
      }
      f4 = f1;
    }
  }

  public Mesh copy(boolean paramBoolean)
  {
    return copy(paramBoolean, false, null);
  }

  public Mesh copy(boolean paramBoolean1, boolean paramBoolean2, int[] paramArrayOfInt)
  {
    int i = getVertexSize() / 4;
    int j = getNumVertices();
    float[] arrayOfFloat1 = new float[j * i];
    getVertices(0, arrayOfFloat1.length, arrayOfFloat1);
    int k = 0;
    int m;
    VertexAttribute[] arrayOfVertexAttribute1;
    Object localObject;
    if (paramArrayOfInt != null)
    {
      int i15 = 0;
      int i16 = 0;
      for (int i17 = 0; i17 < paramArrayOfInt.length; i17++)
      {
        if (getVertexAttribute(paramArrayOfInt[i17]) == null)
          continue;
        i15 += getVertexAttribute(paramArrayOfInt[i17]).numComponents;
        i16++;
      }
      if (i15 > 0)
      {
        VertexAttribute[] arrayOfVertexAttribute2 = new VertexAttribute[i16];
        short[] arrayOfShort4 = new short[i15];
        int i18 = -1;
        int i19 = -1;
        for (int i20 = 0; i20 < paramArrayOfInt.length; i20++)
        {
          VertexAttribute localVertexAttribute = getVertexAttribute(paramArrayOfInt[i20]);
          if (localVertexAttribute == null)
            continue;
          int i21 = i18;
          for (int i22 = 0; i22 < localVertexAttribute.numComponents; i22++)
          {
            i21++;
            arrayOfShort4[i21] = (short)(i22 + localVertexAttribute.offset);
          }
          i19++;
          arrayOfVertexAttribute2[i19] = new VertexAttribute(localVertexAttribute.usage, localVertexAttribute.numComponents, localVertexAttribute.alias);
          k += localVertexAttribute.numComponents;
          i18 = i21;
        }
        m = k;
        arrayOfVertexAttribute1 = arrayOfVertexAttribute2;
        localObject = arrayOfShort4;
      }
    }
    while (true)
    {
      if (localObject == null)
      {
        short[] arrayOfShort3 = new short[i];
        for (int i14 = 0; i14 < i; i14 = (short)(i14 + 1))
          arrayOfShort3[i14] = i14;
        localObject = arrayOfShort3;
        m = i;
      }
      int n = getNumIndices();
      short[] arrayOfShort2;
      int i5;
      int i13;
      short[] arrayOfShort1;
      float[] arrayOfFloat2;
      if (n > 0)
      {
        arrayOfShort2 = new short[n];
        getIndices(arrayOfShort2);
        if ((paramBoolean2) || (m != i))
        {
          float[] arrayOfFloat3 = new float[arrayOfFloat1.length];
          j = 0;
          int i3 = 0;
          if (i3 < n)
          {
            int i4 = i * arrayOfShort2[i3];
            i5 = -1;
            if (paramBoolean2)
            {
              int i9 = 0;
              while ((i9 < j) && (i5 < 0))
              {
                int i10 = i9 * m;
                int i11 = 1;
                for (int i12 = 0; (i12 < localObject.length) && (i11 != 0); i12++)
                {
                  if (arrayOfFloat3[(i10 + i12)] == arrayOfFloat1[(i4 + localObject[i12])])
                    continue;
                  i11 = 0;
                }
                if (i11 == 0)
                  break label650;
                i13 = i9;
                i9 = (short)(i9 + 1);
                i5 = i13;
              }
            }
            if (i5 > 0)
              arrayOfShort2[i3] = i5;
            for (int i8 = j; ; i8 = j + 1)
            {
              i3++;
              j = i8;
              break;
              int i6 = j * m;
              for (int i7 = 0; i7 < localObject.length; i7++)
                arrayOfFloat3[(i6 + i7)] = arrayOfFloat1[(i4 + localObject[i7])];
              arrayOfShort2[i3] = (short)j;
            }
          }
          arrayOfShort1 = arrayOfShort2;
          arrayOfFloat2 = arrayOfFloat3;
        }
      }
      while (true)
      {
        Mesh localMesh;
        if (arrayOfVertexAttribute1 == null)
        {
          if (arrayOfShort1 == null);
          for (int i2 = 0; ; i2 = arrayOfShort1.length)
          {
            localMesh = new Mesh(paramBoolean1, j, i2, getVertexAttributes());
            localMesh.setVertices(arrayOfFloat2, 0, m * j);
            localMesh.setIndices(arrayOfShort1);
            return localMesh;
          }
        }
        if (arrayOfShort1 == null);
        for (int i1 = 0; ; i1 = arrayOfShort1.length)
        {
          localMesh = new Mesh(paramBoolean1, j, i1, arrayOfVertexAttribute1);
          break;
        }
        label650: i13 = i5;
        break;
        arrayOfShort1 = arrayOfShort2;
        arrayOfFloat2 = arrayOfFloat1;
        continue;
        arrayOfFloat2 = arrayOfFloat1;
        arrayOfShort1 = null;
      }
      m = 0;
      localObject = null;
      arrayOfVertexAttribute1 = null;
    }
  }

  public void dispose()
  {
    if (meshes.get(Gdx.app) != null)
      ((Array)meshes.get(Gdx.app)).removeValue(this, true);
    this.vertices.dispose();
    this.indices.dispose();
  }

  public BoundingBox extendBoundingBox(BoundingBox paramBoundingBox, int paramInt1, int paramInt2)
  {
    return extendBoundingBox(paramBoundingBox, paramInt1, paramInt2, null);
  }

  public BoundingBox extendBoundingBox(BoundingBox paramBoundingBox, int paramInt1, int paramInt2, Matrix4 paramMatrix4)
  {
    int i = getNumIndices();
    int j = getNumVertices();
    if (i == 0);
    while ((paramInt1 < 0) || (paramInt2 <= 0) || (paramInt1 + paramInt2 > j))
    {
      throw new GdxRuntimeException("Invalid part specified ( offset=" + paramInt1 + ", count=" + paramInt2 + ", max=" + j + " )");
      j = i;
    }
    FloatBuffer localFloatBuffer = this.vertices.getBuffer();
    ShortBuffer localShortBuffer = this.indices.getBuffer();
    VertexAttribute localVertexAttribute = getVertexAttribute(1);
    int k = localVertexAttribute.offset / 4;
    int m = this.vertices.getAttributes().vertexSize / 4;
    int n = paramInt1 + paramInt2;
    switch (localVertexAttribute.numComponents)
    {
    default:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return paramBoundingBox;
      if (i > 0)
        while (paramInt1 < n)
        {
          int i6 = k + m * localShortBuffer.get(paramInt1);
          this.tmpV.set(localFloatBuffer.get(i6), 0.0F, 0.0F);
          if (paramMatrix4 != null)
            this.tmpV.mul(paramMatrix4);
          paramBoundingBox.ext(this.tmpV);
          paramInt1++;
        }
      while (paramInt1 < n)
      {
        int i5 = k + paramInt1 * m;
        this.tmpV.set(localFloatBuffer.get(i5), 0.0F, 0.0F);
        if (paramMatrix4 != null)
          this.tmpV.mul(paramMatrix4);
        paramBoundingBox.ext(this.tmpV);
        paramInt1++;
      }
      if (i > 0)
        while (paramInt1 < n)
        {
          int i4 = k + m * localShortBuffer.get(paramInt1);
          this.tmpV.set(localFloatBuffer.get(i4), localFloatBuffer.get(i4 + 1), 0.0F);
          if (paramMatrix4 != null)
            this.tmpV.mul(paramMatrix4);
          paramBoundingBox.ext(this.tmpV);
          paramInt1++;
        }
      while (paramInt1 < n)
      {
        int i3 = k + paramInt1 * m;
        this.tmpV.set(localFloatBuffer.get(i3), localFloatBuffer.get(i3 + 1), 0.0F);
        if (paramMatrix4 != null)
          this.tmpV.mul(paramMatrix4);
        paramBoundingBox.ext(this.tmpV);
        paramInt1++;
      }
      if (i > 0)
      {
        while (paramInt1 < n)
        {
          int i2 = k + m * localShortBuffer.get(paramInt1);
          this.tmpV.set(localFloatBuffer.get(i2), localFloatBuffer.get(i2 + 1), localFloatBuffer.get(i2 + 2));
          if (paramMatrix4 != null)
            this.tmpV.mul(paramMatrix4);
          paramBoundingBox.ext(this.tmpV);
          paramInt1++;
        }
        continue;
      }
      while (paramInt1 < n)
      {
        int i1 = k + paramInt1 * m;
        this.tmpV.set(localFloatBuffer.get(i1), localFloatBuffer.get(i1 + 1), localFloatBuffer.get(i1 + 2));
        if (paramMatrix4 != null)
          this.tmpV.mul(paramMatrix4);
        paramBoundingBox.ext(this.tmpV);
        paramInt1++;
      }
    }
  }

  public void getIndices(int paramInt1, int paramInt2, short[] paramArrayOfShort, int paramInt3)
  {
    int i = getNumIndices();
    if (paramInt2 < 0)
      paramInt2 = i - paramInt1;
    if ((paramInt1 < 0) || (paramInt1 >= i) || (paramInt1 + paramInt2 > i))
      throw new IllegalArgumentException("Invalid range specified, offset: " + paramInt1 + ", count: " + paramInt2 + ", max: " + i);
    if (paramArrayOfShort.length - paramInt3 < paramInt2)
      throw new IllegalArgumentException("not enough room in indices array, has " + paramArrayOfShort.length + " shorts, needs " + paramInt2);
    int j = getIndicesBuffer().position();
    getIndicesBuffer().position(paramInt1);
    getIndicesBuffer().get(paramArrayOfShort, paramInt3, paramInt2);
    getIndicesBuffer().position(j);
  }

  public void getIndices(int paramInt1, short[] paramArrayOfShort, int paramInt2)
  {
    getIndices(paramInt1, -1, paramArrayOfShort, paramInt2);
  }

  public void getIndices(short[] paramArrayOfShort)
  {
    getIndices(paramArrayOfShort, 0);
  }

  public void getIndices(short[] paramArrayOfShort, int paramInt)
  {
    getIndices(0, paramArrayOfShort, paramInt);
  }

  public ShortBuffer getIndicesBuffer()
  {
    return this.indices.getBuffer();
  }

  public int getMaxIndices()
  {
    return this.indices.getNumMaxIndices();
  }

  public int getMaxVertices()
  {
    return this.vertices.getNumMaxVertices();
  }

  public int getNumIndices()
  {
    return this.indices.getNumIndices();
  }

  public int getNumVertices()
  {
    return this.vertices.getNumVertices();
  }

  public VertexAttribute getVertexAttribute(int paramInt)
  {
    VertexAttributes localVertexAttributes = this.vertices.getAttributes();
    int i = localVertexAttributes.size();
    for (int j = 0; j < i; j++)
      if (localVertexAttributes.get(j).usage == paramInt)
        return localVertexAttributes.get(j);
    return null;
  }

  public VertexAttributes getVertexAttributes()
  {
    return this.vertices.getAttributes();
  }

  public int getVertexSize()
  {
    return this.vertices.getAttributes().vertexSize;
  }

  public float[] getVertices(int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    return getVertices(paramInt1, paramInt2, paramArrayOfFloat, 0);
  }

  public float[] getVertices(int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3)
  {
    int i = getNumVertices() * getVertexSize() / 4;
    if (paramInt2 == -1)
    {
      paramInt2 = i - paramInt1;
      if (paramInt2 > paramArrayOfFloat.length - paramInt3)
        paramInt2 = paramArrayOfFloat.length - paramInt3;
    }
    if ((paramInt1 < 0) || (paramInt2 <= 0) || (paramInt1 + paramInt2 > i) || (paramInt3 < 0) || (paramInt3 >= paramArrayOfFloat.length))
      throw new IndexOutOfBoundsException();
    if (paramArrayOfFloat.length - paramInt3 < paramInt2)
      throw new IllegalArgumentException("not enough room in vertices array, has " + paramArrayOfFloat.length + " floats, needs " + paramInt2);
    int j = getVerticesBuffer().position();
    getVerticesBuffer().position(paramInt1);
    getVerticesBuffer().get(paramArrayOfFloat, paramInt3, paramInt2);
    getVerticesBuffer().position(j);
    return paramArrayOfFloat;
  }

  public float[] getVertices(int paramInt, float[] paramArrayOfFloat)
  {
    return getVertices(paramInt, -1, paramArrayOfFloat);
  }

  public float[] getVertices(float[] paramArrayOfFloat)
  {
    return getVertices(0, -1, paramArrayOfFloat);
  }

  public FloatBuffer getVerticesBuffer()
  {
    return this.vertices.getBuffer();
  }

  public void render(ShaderProgram paramShaderProgram, int paramInt)
  {
    if (this.indices.getNumMaxIndices() > 0);
    for (int i = getNumIndices(); ; i = getNumVertices())
    {
      render(paramShaderProgram, paramInt, 0, i, this.autoBind);
      return;
    }
  }

  public void render(ShaderProgram paramShaderProgram, int paramInt1, int paramInt2, int paramInt3)
  {
    render(paramShaderProgram, paramInt1, paramInt2, paramInt3, this.autoBind);
  }

  public void render(ShaderProgram paramShaderProgram, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramInt3 == 0);
    while (true)
    {
      return;
      if (paramBoolean)
        bind(paramShaderProgram);
      if (this.isVertexArray)
        if (this.indices.getNumIndices() > 0)
        {
          ShortBuffer localShortBuffer = this.indices.getBuffer();
          int i = localShortBuffer.position();
          int j = localShortBuffer.limit();
          localShortBuffer.position(paramInt2);
          localShortBuffer.limit(paramInt2 + paramInt3);
          Gdx.gl20.glDrawElements(paramInt1, paramInt3, 5123, localShortBuffer);
          localShortBuffer.position(i);
          localShortBuffer.limit(j);
        }
      while (paramBoolean)
      {
        unbind(paramShaderProgram);
        return;
        Gdx.gl20.glDrawArrays(paramInt1, paramInt2, paramInt3);
        continue;
        if (this.indices.getNumIndices() > 0)
        {
          Gdx.gl20.glDrawElements(paramInt1, paramInt3, 5123, paramInt2 << 1);
          continue;
        }
        Gdx.gl20.glDrawArrays(paramInt1, paramInt2, paramInt3);
      }
    }
  }

  public void scale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    VertexAttribute localVertexAttribute = getVertexAttribute(1);
    int i = localVertexAttribute.offset / 4;
    int j = localVertexAttribute.numComponents;
    int k = getNumVertices();
    int m = getVertexSize() / 4;
    float[] arrayOfFloat = new float[k * m];
    getVertices(arrayOfFloat);
    int n = 0;
    switch (j)
    {
    default:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      setVertices(arrayOfFloat);
      return;
      while (n < k)
      {
        arrayOfFloat[i] = (paramFloat1 * arrayOfFloat[i]);
        i += m;
        n++;
      }
      while (n < k)
      {
        arrayOfFloat[i] = (paramFloat1 * arrayOfFloat[i]);
        int i3 = i + 1;
        arrayOfFloat[i3] = (paramFloat2 * arrayOfFloat[i3]);
        i += m;
        n++;
      }
      while (n < k)
      {
        arrayOfFloat[i] = (paramFloat1 * arrayOfFloat[i]);
        int i1 = i + 1;
        arrayOfFloat[i1] = (paramFloat2 * arrayOfFloat[i1]);
        int i2 = i + 2;
        arrayOfFloat[i2] = (paramFloat3 * arrayOfFloat[i2]);
        i += m;
        n++;
      }
    }
  }

  public void setAutoBind(boolean paramBoolean)
  {
    this.autoBind = paramBoolean;
  }

  public Mesh setIndices(short[] paramArrayOfShort)
  {
    this.indices.setIndices(paramArrayOfShort, 0, paramArrayOfShort.length);
    return this;
  }

  public Mesh setIndices(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    this.indices.setIndices(paramArrayOfShort, paramInt1, paramInt2);
    return this;
  }

  public Mesh setVertices(float[] paramArrayOfFloat)
  {
    this.vertices.setVertices(paramArrayOfFloat, 0, paramArrayOfFloat.length);
    return this;
  }

  public Mesh setVertices(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    this.vertices.setVertices(paramArrayOfFloat, paramInt1, paramInt2);
    return this;
  }

  public void transform(Matrix4 paramMatrix4)
  {
    transform(paramMatrix4, 0, getNumVertices());
  }

  public void transform(Matrix4 paramMatrix4, int paramInt1, int paramInt2)
  {
    VertexAttribute localVertexAttribute = getVertexAttribute(1);
    int i = localVertexAttribute.offset / 4;
    int j = getVertexSize() / 4;
    int k = localVertexAttribute.numComponents;
    getNumVertices();
    float[] arrayOfFloat = new float[paramInt2 * j];
    getVertices(paramInt1 * j, paramInt2 * j, arrayOfFloat);
    transform(paramMatrix4, arrayOfFloat, j, i, k, 0, paramInt2);
    updateVertices(paramInt1 * j, arrayOfFloat);
  }

  public void transformUV(Matrix3 paramMatrix3)
  {
    transformUV(paramMatrix3, 0, getNumVertices());
  }

  protected void transformUV(Matrix3 paramMatrix3, int paramInt1, int paramInt2)
  {
    int i = getVertexAttribute(16).offset / 4;
    int j = getVertexSize() / 4;
    float[] arrayOfFloat = new float[j * getNumVertices()];
    getVertices(0, arrayOfFloat.length, arrayOfFloat);
    transformUV(paramMatrix3, arrayOfFloat, j, i, paramInt1, paramInt2);
    setVertices(arrayOfFloat, 0, arrayOfFloat.length);
  }

  public void unbind(ShaderProgram paramShaderProgram)
  {
    unbind(paramShaderProgram, null);
  }

  public void unbind(ShaderProgram paramShaderProgram, int[] paramArrayOfInt)
  {
    this.vertices.unbind(paramShaderProgram, paramArrayOfInt);
    if (this.indices.getNumIndices() > 0)
      this.indices.unbind();
  }

  public Mesh updateVertices(int paramInt, float[] paramArrayOfFloat)
  {
    return updateVertices(paramInt, paramArrayOfFloat, 0, paramArrayOfFloat.length);
  }

  public Mesh updateVertices(int paramInt1, float[] paramArrayOfFloat, int paramInt2, int paramInt3)
  {
    this.vertices.updateVertices(paramInt1, paramArrayOfFloat, paramInt2, paramInt3);
    return this;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.Mesh
 * JD-Core Version:    0.6.0
 */