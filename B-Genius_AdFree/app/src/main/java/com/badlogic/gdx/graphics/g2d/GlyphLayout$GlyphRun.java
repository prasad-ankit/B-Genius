package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.Pool.Poolable;

public class GlyphLayout$GlyphRun
  implements Pool.Poolable
{
  public final Color color = new Color();
  public final Array glyphs = new Array();
  public float width;
  public float x;
  public final FloatArray xAdvances = new FloatArray();
  public float y;

  public void reset()
  {
    this.glyphs.clear();
    this.xAdvances.clear();
    this.width = 0.0F;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.glyphs.size);
    Array localArray = this.glyphs;
    int i = localArray.size;
    for (int j = 0; j < i; j++)
      localStringBuilder.append((char)((BitmapFont.Glyph)localArray.get(j)).id);
    localStringBuilder.append(", #");
    localStringBuilder.append(this.color);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.x);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.y);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.width);
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g2d.GlyphLayout.GlyphRun
 * JD-Core Version:    0.6.0
 */