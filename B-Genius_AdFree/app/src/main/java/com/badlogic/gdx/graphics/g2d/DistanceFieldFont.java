package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.Array;
import java.util.Iterator;

public class DistanceFieldFont extends BitmapFont
{
  private float distanceFieldSmoothing;

  public DistanceFieldFont(FileHandle paramFileHandle)
  {
    super(paramFileHandle);
  }

  public DistanceFieldFont(FileHandle paramFileHandle1, FileHandle paramFileHandle2, boolean paramBoolean)
  {
    super(paramFileHandle1, paramFileHandle2, paramBoolean);
  }

  public DistanceFieldFont(FileHandle paramFileHandle1, FileHandle paramFileHandle2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramFileHandle1, paramFileHandle2, paramBoolean1, paramBoolean2);
  }

  public DistanceFieldFont(FileHandle paramFileHandle, TextureRegion paramTextureRegion)
  {
    super(paramFileHandle, paramTextureRegion);
  }

  public DistanceFieldFont(FileHandle paramFileHandle, TextureRegion paramTextureRegion, boolean paramBoolean)
  {
    super(paramFileHandle, paramTextureRegion, paramBoolean);
  }

  public DistanceFieldFont(FileHandle paramFileHandle, boolean paramBoolean)
  {
    super(paramFileHandle, paramBoolean);
  }

  public DistanceFieldFont(BitmapFont.BitmapFontData paramBitmapFontData, TextureRegion paramTextureRegion, boolean paramBoolean)
  {
    super(paramBitmapFontData, paramTextureRegion, paramBoolean);
  }

  public DistanceFieldFont(BitmapFont.BitmapFontData paramBitmapFontData, Array paramArray, boolean paramBoolean)
  {
    super(paramBitmapFontData, paramArray, paramBoolean);
  }

  public static ShaderProgram createDistanceFieldShader()
  {
    ShaderProgram localShaderProgram = new ShaderProgram("attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\nuniform mat4 u_projTrans;\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main() {\n\tv_color = a_color;\n\tv_color.a = v_color.a * (255.0/254.0);\n\tv_texCoords = a_texCoord0;\n\tgl_Position =  u_projTrans * a_position;\n}\n", "#ifdef GL_ES\n\tprecision mediump float;\n\tprecision mediump int;\n#endif\n\nuniform sampler2D u_texture;\nuniform float u_smoothing;\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main() {\n\tif (u_smoothing > 0.0) {\n\t\tfloat smoothing = 0.25 / u_smoothing;\n\t\tfloat distance = texture2D(u_texture, v_texCoords).a;\n\t\tfloat alpha = smoothstep(0.5 - smoothing, 0.5 + smoothing, distance);\n\t\tgl_FragColor = vec4(v_color.rgb, alpha * v_color.a);\n\t} else {\n\t\tgl_FragColor = v_color * texture2D(u_texture, v_texCoords);\n\t}\n}\n");
    if (!localShaderProgram.isCompiled())
      throw new IllegalArgumentException("Error compiling distance field shader: " + localShaderProgram.getLog());
    return localShaderProgram;
  }

  public float getDistanceFieldSmoothing()
  {
    return this.distanceFieldSmoothing;
  }

  protected void load(BitmapFont.BitmapFontData paramBitmapFontData)
  {
    super.load(paramBitmapFontData);
    Iterator localIterator = getRegions().iterator();
    while (localIterator.hasNext())
      ((TextureRegion)localIterator.next()).getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
  }

  public BitmapFontCache newFontCache()
  {
    return new DistanceFieldFont.DistanceFieldFontCache(this, this.integer);
  }

  public void setDistanceFieldSmoothing(float paramFloat)
  {
    this.distanceFieldSmoothing = paramFloat;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g2d.DistanceFieldFont
 * JD-Core Version:    0.6.0
 */