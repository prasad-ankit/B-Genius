package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;

public class TextButton extends Button
{
  private final Label label;
  private TextButton.TextButtonStyle style;

  public TextButton(String paramString, Skin paramSkin)
  {
    this(paramString, (TextButton.TextButtonStyle)paramSkin.get(TextButton.TextButtonStyle.class));
    setSkin(paramSkin);
  }

  public TextButton(String paramString1, Skin paramSkin, String paramString2)
  {
    this(paramString1, (TextButton.TextButtonStyle)paramSkin.get(paramString2, TextButton.TextButtonStyle.class));
    setSkin(paramSkin);
  }

  public TextButton(String paramString, TextButton.TextButtonStyle paramTextButtonStyle)
  {
    setStyle(paramTextButtonStyle);
    this.style = paramTextButtonStyle;
    this.label = new Label(paramString, new Label.LabelStyle(paramTextButtonStyle.font, paramTextButtonStyle.fontColor));
    this.label.setAlignment(1);
    add(this.label).expand().fill();
    setSize(getPrefWidth(), getPrefHeight());
  }

  public void draw(Batch paramBatch, float paramFloat)
  {
    Color localColor;
    if ((isDisabled()) && (this.style.disabledFontColor != null))
      localColor = this.style.disabledFontColor;
    while (true)
    {
      if (localColor != null)
        this.label.getStyle().fontColor = localColor;
      super.draw(paramBatch, paramFloat);
      return;
      if ((isPressed()) && (this.style.downFontColor != null))
      {
        localColor = this.style.downFontColor;
        continue;
      }
      if ((this.isChecked) && (this.style.checkedFontColor != null))
      {
        if ((isOver()) && (this.style.checkedOverFontColor != null))
        {
          localColor = this.style.checkedOverFontColor;
          continue;
        }
        localColor = this.style.checkedFontColor;
        continue;
      }
      if ((isOver()) && (this.style.overFontColor != null))
      {
        localColor = this.style.overFontColor;
        continue;
      }
      localColor = this.style.fontColor;
    }
  }

  public Label getLabel()
  {
    return this.label;
  }

  public Cell getLabelCell()
  {
    return getCell(this.label);
  }

  public TextButton.TextButtonStyle getStyle()
  {
    return this.style;
  }

  public CharSequence getText()
  {
    return this.label.getText();
  }

  public void setStyle(Button.ButtonStyle paramButtonStyle)
  {
    if (paramButtonStyle == null)
      throw new NullPointerException("style cannot be null");
    if (!(paramButtonStyle instanceof TextButton.TextButtonStyle))
      throw new IllegalArgumentException("style must be a TextButtonStyle.");
    super.setStyle(paramButtonStyle);
    this.style = ((TextButton.TextButtonStyle)paramButtonStyle);
    if (this.label != null)
    {
      TextButton.TextButtonStyle localTextButtonStyle = (TextButton.TextButtonStyle)paramButtonStyle;
      Label.LabelStyle localLabelStyle = this.label.getStyle();
      localLabelStyle.font = localTextButtonStyle.font;
      localLabelStyle.fontColor = localTextButtonStyle.fontColor;
      this.label.setStyle(localLabelStyle);
    }
  }

  public void setText(String paramString)
  {
    this.label.setText(paramString);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.TextButton
 * JD-Core Version:    0.6.0
 */