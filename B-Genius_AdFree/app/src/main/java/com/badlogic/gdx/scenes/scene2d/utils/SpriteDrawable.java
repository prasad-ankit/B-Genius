package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasSprite;

public class SpriteDrawable extends BaseDrawable
  implements TransformDrawable
{
  private static Color tmpColor = new Color();
  private Sprite sprite;

  public SpriteDrawable()
  {
  }

  public SpriteDrawable(Sprite paramSprite)
  {
    setSprite(paramSprite);
  }

  public SpriteDrawable(SpriteDrawable paramSpriteDrawable)
  {
    super(paramSpriteDrawable);
    setSprite(paramSpriteDrawable.sprite);
  }

  public void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    draw(paramBatch, paramFloat1, paramFloat2, paramFloat3 / 2.0F, paramFloat4 / 2.0F, paramFloat3, paramFloat4, 1.0F, 1.0F, 0.0F);
  }

  public void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9)
  {
    this.sprite.setOrigin(paramFloat3, paramFloat4);
    this.sprite.setRotation(paramFloat9);
    this.sprite.setScale(paramFloat7, paramFloat8);
    this.sprite.setBounds(paramFloat1, paramFloat2, paramFloat5, paramFloat6);
    Color localColor = this.sprite.getColor();
    this.sprite.setColor(tmpColor.set(localColor).mul(paramBatch.getColor()));
    this.sprite.draw(paramBatch);
    this.sprite.setColor(localColor);
  }

  public Sprite getSprite()
  {
    return this.sprite;
  }

  public void setSprite(Sprite paramSprite)
  {
    this.sprite = paramSprite;
    setMinWidth(paramSprite.getWidth());
    setMinHeight(paramSprite.getHeight());
  }

  public SpriteDrawable tint(Color paramColor)
  {
    SpriteDrawable localSpriteDrawable = new SpriteDrawable(this);
    Sprite localSprite = localSpriteDrawable.getSprite();
    if ((localSprite instanceof TextureAtlas.AtlasSprite));
    for (Object localObject = new TextureAtlas.AtlasSprite((TextureAtlas.AtlasSprite)localSprite); ; localObject = new Sprite(localSprite))
    {
      ((Sprite)localObject).setColor(paramColor);
      localSpriteDrawable.setSprite((Sprite)localObject);
      return localSpriteDrawable;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable
 * JD-Core Version:    0.6.0
 */