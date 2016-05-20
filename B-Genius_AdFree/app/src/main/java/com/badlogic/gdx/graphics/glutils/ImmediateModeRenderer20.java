package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.Array;

public class ImmediateModeRenderer20
  implements ImmediateModeRenderer
{
  private final int colorOffset;
  private final int maxVertices;
  private final Mesh mesh;
  private final int normalOffset;
  private int numSetTexCoords;
  private final int numTexCoords;
  private int numVertices;
  private boolean ownsShader;
  private int primitiveType;
  private final Matrix4 projModelView = new Matrix4();
  private ShaderProgram shader;
  private final String[] shaderUniformNames;
  private final int texCoordOffset;
  private int vertexIdx;
  private final int vertexSize;
  private final float[] vertices;

  public ImmediateModeRenderer20(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    this(paramInt1, paramBoolean1, paramBoolean2, paramInt2, createDefaultShader(paramBoolean1, paramBoolean2, paramInt2));
    this.ownsShader = true;
  }

  public ImmediateModeRenderer20(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, ShaderProgram paramShaderProgram)
  {
    this.maxVertices = paramInt1;
    this.numTexCoords = paramInt2;
    this.shader = paramShaderProgram;
    this.mesh = new Mesh(false, paramInt1, 0, buildVertexAttributes(paramBoolean1, paramBoolean2, paramInt2));
    this.vertices = new float[paramInt1 * (this.mesh.getVertexAttributes().vertexSize / 4)];
    this.vertexSize = (this.mesh.getVertexAttributes().vertexSize / 4);
    int j;
    int k;
    if (this.mesh.getVertexAttribute(8) != null)
    {
      j = this.mesh.getVertexAttribute(8).offset / 4;
      this.normalOffset = j;
      if (this.mesh.getVertexAttribute(4) == null)
        break label245;
      k = this.mesh.getVertexAttribute(4).offset / 4;
      label153: this.colorOffset = k;
      if (this.mesh.getVertexAttribute(16) == null)
        break label251;
    }
    label245: label251: for (int m = this.mesh.getVertexAttribute(16).offset / 4; ; m = 0)
    {
      this.texCoordOffset = m;
      this.shaderUniformNames = new String[paramInt2];
      while (i < paramInt2)
      {
        this.shaderUniformNames[i] = ("u_sampler" + i);
        i++;
      }
      j = 0;
      break;
      k = 0;
      break label153;
    }
  }

  public ImmediateModeRenderer20(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this(5000, paramBoolean1, paramBoolean2, paramInt, createDefaultShader(paramBoolean1, paramBoolean2, paramInt));
    this.ownsShader = true;
  }

  private VertexAttribute[] buildVertexAttributes(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    Array localArray = new Array();
    localArray.add(new VertexAttribute(1, 3, "a_position"));
    if (paramBoolean1)
      localArray.add(new VertexAttribute(8, 3, "a_normal"));
    if (paramBoolean2)
      localArray.add(new VertexAttribute(4, 4, "a_color"));
    for (int i = 0; i < paramInt; i++)
      localArray.add(new VertexAttribute(16, 2, "a_texCoord" + i));
    VertexAttribute[] arrayOfVertexAttribute = new VertexAttribute[localArray.size];
    for (int j = 0; j < localArray.size; j++)
      arrayOfVertexAttribute[j] = ((VertexAttribute)localArray.get(j));
    return arrayOfVertexAttribute;
  }

  public static ShaderProgram createDefaultShader(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    return new ShaderProgram(createVertexShader(paramBoolean1, paramBoolean2, paramInt), createFragmentShader(paramBoolean1, paramBoolean2, paramInt));
  }

  private static String createFragmentShader(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    String str1 = "#ifdef GL_ES\nprecision mediump float;\n#endif\n";
    if (paramBoolean2)
      str1 = str1 + "varying vec4 v_col;\n";
    String str2 = str1;
    for (int i = 0; i < paramInt; i++)
    {
      String str5 = str2 + "varying vec2 v_tex" + i + ";\n";
      str2 = str5 + "uniform sampler2D u_sampler" + i + ";\n";
    }
    StringBuilder localStringBuilder = new StringBuilder().append(str2).append("void main() {\n   gl_FragColor = ");
    String str3;
    int j;
    if (paramBoolean2)
    {
      str3 = "v_col";
      str4 = str3;
      j = 0;
      if (paramInt > 0)
        str4 = str4 + " * ";
      label177: if (j >= paramInt)
        break label291;
      if (j != paramInt - 1)
        break label246;
    }
    label246: for (String str4 = str4 + " texture2D(u_sampler" + j + ",  v_tex" + j + ")"; ; str4 = str4 + " texture2D(u_sampler" + j + ",  v_tex" + j + ") *")
    {
      j++;
      break label177;
      str3 = "vec4(1, 1, 1, 1)";
      break;
    }
    label291: return str4 + ";\n}";
  }

  private static String createVertexShader(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    StringBuilder localStringBuilder1 = new StringBuilder("attribute vec4 a_position;\n");
    String str1;
    StringBuilder localStringBuilder2;
    if (paramBoolean1)
    {
      str1 = "attribute vec3 a_normal;\n";
      localStringBuilder2 = localStringBuilder1.append(str1);
      if (!paramBoolean2)
        break label100;
    }
    String str3;
    label100: for (String str2 = "attribute vec4 a_color;\n"; ; str2 = "")
    {
      str3 = str2;
      for (int i = 0; i < paramInt; i++)
        str3 = str3 + "attribute vec2 a_texCoord" + i + ";\n";
      str1 = "";
      break;
    }
    String str4 = str3 + "uniform mat4 u_projModelView;\n";
    StringBuilder localStringBuilder3 = new StringBuilder().append(str4);
    if (paramBoolean2);
    String str6;
    for (String str5 = "varying vec4 v_col;\n"; ; str5 = "")
    {
      str6 = str5;
      for (int j = 0; j < paramInt; j++)
        str6 = str6 + "varying vec2 v_tex" + j + ";\n";
    }
    StringBuilder localStringBuilder4 = new StringBuilder().append(str6).append("void main() {\n   gl_Position = u_projModelView * a_position;\n");
    if (paramBoolean2);
    String str8;
    for (String str7 = "   v_col = a_color;\n"; ; str7 = "")
    {
      str8 = str7;
      for (int k = 0; k < paramInt; k++)
        str8 = str8 + "   v_tex" + k + " = a_texCoord" + k + ";\n";
    }
    String str9 = str8 + "   gl_PointSize = 1.0;\n";
    return str9 + "}\n";
  }

  public void begin(Matrix4 paramMatrix4, int paramInt)
  {
    this.projModelView.set(paramMatrix4);
    this.primitiveType = paramInt;
  }

  public void color(float paramFloat)
  {
    this.vertices[(this.vertexIdx + this.colorOffset)] = paramFloat;
  }

  public void color(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.vertices[(this.vertexIdx + this.colorOffset)] = Color.toFloatBits(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }

  public void color(Color paramColor)
  {
    this.vertices[(this.vertexIdx + this.colorOffset)] = paramColor.toFloatBits();
  }

  public void dispose()
  {
    if ((this.ownsShader) && (this.shader != null))
      this.shader.dispose();
    this.mesh.dispose();
  }

  public void end()
  {
    flush();
  }

  public void flush()
  {
    if (this.numVertices == 0)
      return;
    this.shader.begin();
    this.shader.setUniformMatrix("u_projModelView", this.projModelView);
    for (int i = 0; i < this.numTexCoords; i++)
      this.shader.setUniformi(this.shaderUniformNames[i], i);
    this.mesh.setVertices(this.vertices, 0, this.vertexIdx);
    this.mesh.render(this.shader, this.primitiveType);
    this.shader.end();
    this.numSetTexCoords = 0;
    this.vertexIdx = 0;
    this.numVertices = 0;
  }

  public int getMaxVertices()
  {
    return this.maxVertices;
  }

  public int getNumVertices()
  {
    return this.numVertices;
  }

  public void normal(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    int i = this.vertexIdx + this.normalOffset;
    this.vertices[i] = paramFloat1;
    this.vertices[(i + 1)] = paramFloat2;
    this.vertices[(i + 2)] = paramFloat3;
  }

  public void setShader(ShaderProgram paramShaderProgram)
  {
    if (this.ownsShader)
      this.shader.dispose();
    this.shader = paramShaderProgram;
    this.ownsShader = false;
  }

  public void texCoord(float paramFloat1, float paramFloat2)
  {
    int i = this.vertexIdx + this.texCoordOffset;
    this.vertices[(i + this.numSetTexCoords)] = paramFloat1;
    this.vertices[(1 + (i + this.numSetTexCoords))] = paramFloat2;
    this.numSetTexCoords = (2 + this.numSetTexCoords);
  }

  public void vertex(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    int i = this.vertexIdx;
    this.vertices[i] = paramFloat1;
    this.vertices[(i + 1)] = paramFloat2;
    this.vertices[(i + 2)] = paramFloat3;
    this.numSetTexCoords = 0;
    this.vertexIdx += this.vertexSize;
    this.numVertices = (1 + this.numVertices);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer20
 * JD-Core Version:    0.6.0
 */