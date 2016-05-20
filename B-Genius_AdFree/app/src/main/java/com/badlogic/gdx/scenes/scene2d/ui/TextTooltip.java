package com.badlogic.gdx.scenes.scene2d.ui;

public class TextTooltip extends Tooltip
{
  public TextTooltip(String paramString, Skin paramSkin)
  {
    this(paramString, TooltipManager.getInstance(), (TextTooltip.TextTooltipStyle)paramSkin.get(TextTooltip.TextTooltipStyle.class));
  }

  public TextTooltip(String paramString1, Skin paramSkin, String paramString2)
  {
    this(paramString1, TooltipManager.getInstance(), (TextTooltip.TextTooltipStyle)paramSkin.get(paramString2, TextTooltip.TextTooltipStyle.class));
  }

  public TextTooltip(String paramString, TextTooltip.TextTooltipStyle paramTextTooltipStyle)
  {
    this(paramString, TooltipManager.getInstance(), paramTextTooltipStyle);
  }

  public TextTooltip(String paramString, TooltipManager paramTooltipManager, Skin paramSkin)
  {
    this(paramString, paramTooltipManager, (TextTooltip.TextTooltipStyle)paramSkin.get(TextTooltip.TextTooltipStyle.class));
  }

  public TextTooltip(String paramString1, TooltipManager paramTooltipManager, Skin paramSkin, String paramString2)
  {
    this(paramString1, paramTooltipManager, (TextTooltip.TextTooltipStyle)paramSkin.get(paramString2, TextTooltip.TextTooltipStyle.class));
  }

  public TextTooltip(String paramString, TooltipManager paramTooltipManager, TextTooltip.TextTooltipStyle paramTextTooltipStyle)
  {
    super(null, paramTooltipManager);
    Label localLabel = new Label(paramString, paramTextTooltipStyle.label);
    localLabel.setWrap(true);
    this.container.setActor(localLabel);
    this.container.width(new TextTooltip.1(this, paramTooltipManager));
    setStyle(paramTextTooltipStyle);
  }

  public void setStyle(TextTooltip.TextTooltipStyle paramTextTooltipStyle)
  {
    if (paramTextTooltipStyle == null)
      throw new NullPointerException("style cannot be null");
    if (!(paramTextTooltipStyle instanceof TextTooltip.TextTooltipStyle))
      throw new IllegalArgumentException("style must be a TextTooltipStyle.");
    ((Label)this.container.getActor()).setStyle(paramTextTooltipStyle.label);
    this.container.setBackground(paramTextTooltipStyle.background);
    this.container.pack();
    this.container.pack();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.TextTooltip
 * JD-Core Version:    0.6.0
 */