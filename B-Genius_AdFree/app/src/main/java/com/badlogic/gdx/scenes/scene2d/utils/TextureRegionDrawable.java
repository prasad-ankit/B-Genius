package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasSprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureRegionDrawable extends BaseDrawable
  implements TransformDrawable
{
  private TextureRegion region;

  public TextureRegionDrawable()
  {
  }

  public TextureRegionDrawable(TextureRegion paramTextureRegion)
  {
    setRegion(paramTextureRegion);
  }

  public TextureRegionDrawable(TextureRegionDrawable paramTextureRegionDrawable)
  {
    super(paramTextureRegionDrawable);
    setRegion(paramTextureRegionDrawable.region);
  }

  public void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramBatch.draw(this.region, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }

  public void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9)
  {
    paramBatch.draw(this.region, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9);
  }

  public TextureRegion getRegion()
  {
    return this.region;
  }

  public void setRegion(TextureRegion paramTextureRegion)
  {
    this.region = paramTextureRegion;
    setMinWidth(paramTextureRegion.getRegionWidth());
    setMinHeight(paramTextureRegion.getRegionHeight());
  }

  public SpriteDrawable tint(Color paramColor)
  {
    if ((this.region instanceof TextureAtlas.AtlasRegion));
    for (Object localObject = new TextureAtlas.AtlasSprite((TextureAtlas.AtlasRegion)this.region); ; localObject = new Sprite(this.region))
    {
      ((Sprite)localObject).setColor(paramColor);
      return new SpriteDrawable((Sprite)localObject);
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable
 * JD-Core Version:    0.6.0
 */