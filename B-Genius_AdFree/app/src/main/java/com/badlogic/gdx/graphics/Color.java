package com.badlogic.gdx.graphics;

import com.badlogic.gdx.utils.NumberUtils;

public class Color
{
  public static final Color BLACK;
  public static final Color BLUE;
  public static final Color BROWN;
  public static final Color CHARTREUSE;
  public static final Color CLEAR = new Color(0.0F, 0.0F, 0.0F, 0.0F);
  public static final Color CORAL;
  public static final Color CYAN;
  public static final Color DARK_GRAY;
  public static final Color FIREBRICK;
  public static final Color FOREST;
  public static final Color GOLD;
  public static final Color GOLDENROD;
  public static final Color GRAY;
  public static final Color GREEN;
  public static final Color LIGHT_GRAY;
  public static final Color LIME;
  public static final Color MAGENTA;
  public static final Color MAROON;
  public static final Color NAVY;
  public static final Color OLIVE;
  public static final Color ORANGE;
  public static final Color PINK;
  public static final Color PURPLE;
  public static final Color RED;
  public static final Color ROYAL;
  public static final Color SALMON;
  public static final Color SKY;
  public static final Color SLATE;
  public static final Color TAN;
  public static final Color TEAL;
  public static final Color VIOLET;
  public static final Color WHITE;
  public static final Color YELLOW;
  public float a;
  public float b;
  public float g;
  public float r;

  static
  {
    BLACK = new Color(0.0F, 0.0F, 0.0F, 1.0F);
    WHITE = new Color(-1);
    LIGHT_GRAY = new Color(-1077952513);
    GRAY = new Color(2139062271);
    DARK_GRAY = new Color(1061109759);
    SLATE = new Color(1887473919);
    BLUE = new Color(0.0F, 0.0F, 1.0F, 1.0F);
    NAVY = new Color(0.0F, 0.0F, 0.5F, 1.0F);
    ROYAL = new Color(1097458175);
    SKY = new Color(-2016482305);
    CYAN = new Color(0.0F, 1.0F, 1.0F, 1.0F);
    TEAL = new Color(0.0F, 0.5F, 0.5F, 1.0F);
    GREEN = new Color(16711935);
    CHARTREUSE = new Color(2147418367);
    LIME = new Color(852308735);
    FOREST = new Color(579543807);
    OLIVE = new Color(1804477439);
    YELLOW = new Color(-65281);
    GOLD = new Color(-2686721);
    GOLDENROD = new Color(-626712321);
    BROWN = new Color(-1958407169);
    TAN = new Color(-759919361);
    FIREBRICK = new Color(-1306385665);
    RED = new Color(-16776961);
    CORAL = new Color(-8433409);
    ORANGE = new Color(-5963521);
    SALMON = new Color(-92245249);
    PINK = new Color(-9849601);
    MAGENTA = new Color(1.0F, 0.0F, 1.0F, 1.0F);
    PURPLE = new Color(-1608453889);
    VIOLET = new Color(-293409025);
    MAROON = new Color(-1339006721);
  }

  public Color()
  {
  }

  public Color(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.r = paramFloat1;
    this.g = paramFloat2;
    this.b = paramFloat3;
    this.a = paramFloat4;
    clamp();
  }

  public Color(int paramInt)
  {
    rgba8888ToColor(this, paramInt);
  }

  public Color(Color paramColor)
  {
    set(paramColor);
  }

  public static int alpha(float paramFloat)
  {
    return (int)(255.0F * paramFloat);
  }

  public static int argb8888(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (int)(paramFloat1 * 255.0F) << 24 | (int)(paramFloat2 * 255.0F) << 16 | (int)(paramFloat3 * 255.0F) << 8 | (int)(paramFloat4 * 255.0F);
  }

  public static int argb8888(Color paramColor)
  {
    return (int)(255.0F * paramColor.a) << 24 | (int)(255.0F * paramColor.r) << 16 | (int)(255.0F * paramColor.g) << 8 | (int)(255.0F * paramColor.b);
  }

  public static void argb8888ToColor(Color paramColor, int paramInt)
  {
    paramColor.a = (((0xFF000000 & paramInt) >>> 24) / 255.0F);
    paramColor.r = ((0xFF & paramInt >>> 16) / 255.0F);
    paramColor.g = ((0xFF & paramInt >>> 8) / 255.0F);
    paramColor.b = ((paramInt & 0xFF) / 255.0F);
  }

  public static int luminanceAlpha(float paramFloat1, float paramFloat2)
  {
    return (int)(paramFloat1 * 255.0F) << 8 | (int)(255.0F * paramFloat2);
  }

  public static int rgb565(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (int)(paramFloat1 * 31.0F) << 11 | (int)(63.0F * paramFloat2) << 5 | (int)(paramFloat3 * 31.0F);
  }

  public static int rgb565(Color paramColor)
  {
    return (int)(31.0F * paramColor.r) << 11 | (int)(63.0F * paramColor.g) << 5 | (int)(31.0F * paramColor.b);
  }

  public static void rgb565ToColor(Color paramColor, int paramInt)
  {
    paramColor.r = (((0xF800 & paramInt) >>> 11) / 31.0F);
    paramColor.g = (((paramInt & 0x7E0) >>> 5) / 63.0F);
    paramColor.b = ((paramInt & 0x1F) / 31.0F);
  }

  public static int rgb888(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (int)(paramFloat1 * 255.0F) << 16 | (int)(paramFloat2 * 255.0F) << 8 | (int)(paramFloat3 * 255.0F);
  }

  public static int rgb888(Color paramColor)
  {
    return (int)(255.0F * paramColor.r) << 16 | (int)(255.0F * paramColor.g) << 8 | (int)(255.0F * paramColor.b);
  }

  public static void rgb888ToColor(Color paramColor, int paramInt)
  {
    paramColor.r = ((0xFF & paramInt >>> 16) / 255.0F);
    paramColor.g = ((0xFF & paramInt >>> 8) / 255.0F);
    paramColor.b = ((paramInt & 0xFF) / 255.0F);
  }

  public static int rgba4444(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (int)(paramFloat1 * 15.0F) << 12 | (int)(paramFloat2 * 15.0F) << 8 | (int)(paramFloat3 * 15.0F) << 4 | (int)(paramFloat4 * 15.0F);
  }

  public static int rgba4444(Color paramColor)
  {
    return (int)(15.0F * paramColor.r) << 12 | (int)(15.0F * paramColor.g) << 8 | (int)(15.0F * paramColor.b) << 4 | (int)(15.0F * paramColor.a);
  }

  public static void rgba4444ToColor(Color paramColor, int paramInt)
  {
    paramColor.r = (((0xF000 & paramInt) >>> 12) / 15.0F);
    paramColor.g = (((paramInt & 0xF00) >>> 8) / 15.0F);
    paramColor.b = (((paramInt & 0xF0) >>> 4) / 15.0F);
    paramColor.a = ((paramInt & 0xF) / 15.0F);
  }

  public static int rgba8888(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (int)(paramFloat1 * 255.0F) << 24 | (int)(paramFloat2 * 255.0F) << 16 | (int)(paramFloat3 * 255.0F) << 8 | (int)(paramFloat4 * 255.0F);
  }

  public static int rgba8888(Color paramColor)
  {
    return (int)(255.0F * paramColor.r) << 24 | (int)(255.0F * paramColor.g) << 16 | (int)(255.0F * paramColor.b) << 8 | (int)(255.0F * paramColor.a);
  }

  public static void rgba8888ToColor(Color paramColor, int paramInt)
  {
    paramColor.r = (((0xFF000000 & paramInt) >>> 24) / 255.0F);
    paramColor.g = ((0xFF & paramInt >>> 16) / 255.0F);
    paramColor.b = ((0xFF & paramInt >>> 8) / 255.0F);
    paramColor.a = ((paramInt & 0xFF) / 255.0F);
  }

  public static float toFloatBits(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return NumberUtils.intToFloatColor((int)(255.0F * paramFloat4) << 24 | (int)(255.0F * paramFloat3) << 16 | (int)(255.0F * paramFloat2) << 8 | (int)(255.0F * paramFloat1));
  }

  public static float toFloatBits(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return NumberUtils.intToFloatColor(paramInt1 | (paramInt4 << 24 | paramInt3 << 16 | paramInt2 << 8));
  }

  public static int toIntBits(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return paramInt1 | (paramInt4 << 24 | paramInt3 << 16 | paramInt2 << 8);
  }

  public static Color valueOf(String paramString)
  {
    if (paramString.charAt(0) == '#')
      paramString = paramString.substring(1);
    int i = Integer.valueOf(paramString.substring(0, 2), 16).intValue();
    int j = Integer.valueOf(paramString.substring(2, 4), 16).intValue();
    int k = Integer.valueOf(paramString.substring(4, 6), 16).intValue();
    if (paramString.length() != 8);
    for (int m = 255; ; m = Integer.valueOf(paramString.substring(6, 8), 16).intValue())
      return new Color(i / 255.0F, j / 255.0F, k / 255.0F, m / 255.0F);
  }

  public Color add(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.r = (paramFloat1 + this.r);
    this.g = (paramFloat2 + this.g);
    this.b = (paramFloat3 + this.b);
    this.a = (paramFloat4 + this.a);
    return clamp();
  }

  public Color add(Color paramColor)
  {
    this.r += paramColor.r;
    this.g += paramColor.g;
    this.b += paramColor.b;
    this.a += paramColor.a;
    return clamp();
  }

  public Color clamp()
  {
    if (this.r < 0.0F)
    {
      this.r = 0.0F;
      if (this.g >= 0.0F)
        break label75;
      this.g = 0.0F;
      label28: if (this.b >= 0.0F)
        break label92;
      this.b = 0.0F;
      label42: if (this.a >= 0.0F)
        break label109;
      this.a = 0.0F;
    }
    label75: label92: label109: 
    do
    {
      return this;
      if (this.r <= 1.0F)
        break;
      this.r = 1.0F;
      break;
      if (this.g <= 1.0F)
        break label28;
      this.g = 1.0F;
      break label28;
      if (this.b <= 1.0F)
        break label42;
      this.b = 1.0F;
      break label42;
    }
    while (this.a <= 1.0F);
    this.a = 1.0F;
    return this;
  }

  public Color cpy()
  {
    return new Color(this);
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Color localColor;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localColor = (Color)paramObject;
    }
    while (toIntBits() == localColor.toIntBits());
    return false;
  }

  public int hashCode()
  {
    int i;
    int k;
    label39: int m;
    if (this.r != 0.0F)
    {
      i = NumberUtils.floatToIntBits(this.r);
      int j = i * 31;
      if (this.g == 0.0F)
        break label111;
      k = NumberUtils.floatToIntBits(this.g);
      m = 31 * (k + j);
      if (this.b == 0.0F)
        break label116;
    }
    label111: label116: for (int n = NumberUtils.floatToIntBits(this.b); ; n = 0)
    {
      int i1 = 31 * (n + m);
      boolean bool = this.a < 0.0F;
      int i2 = 0;
      if (bool)
        i2 = NumberUtils.floatToIntBits(this.a);
      return i1 + i2;
      i = 0;
      break;
      k = 0;
      break label39;
    }
  }

  public Color lerp(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    this.r += paramFloat5 * (paramFloat1 - this.r);
    this.g += paramFloat5 * (paramFloat2 - this.g);
    this.b += paramFloat5 * (paramFloat3 - this.b);
    this.a += paramFloat5 * (paramFloat4 - this.a);
    return clamp();
  }

  public Color lerp(Color paramColor, float paramFloat)
  {
    this.r += paramFloat * (paramColor.r - this.r);
    this.g += paramFloat * (paramColor.g - this.g);
    this.b += paramFloat * (paramColor.b - this.b);
    this.a += paramFloat * (paramColor.a - this.a);
    return clamp();
  }

  public Color mul(float paramFloat)
  {
    this.r = (paramFloat * this.r);
    this.g = (paramFloat * this.g);
    this.b = (paramFloat * this.b);
    this.a = (paramFloat * this.a);
    return clamp();
  }

  public Color mul(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.r = (paramFloat1 * this.r);
    this.g = (paramFloat2 * this.g);
    this.b = (paramFloat3 * this.b);
    this.a = (paramFloat4 * this.a);
    return clamp();
  }

  public Color mul(Color paramColor)
  {
    this.r *= paramColor.r;
    this.g *= paramColor.g;
    this.b *= paramColor.b;
    this.a *= paramColor.a;
    return clamp();
  }

  public Color premultiplyAlpha()
  {
    this.r *= this.a;
    this.g *= this.a;
    this.b *= this.a;
    return this;
  }

  public Color set(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.r = paramFloat1;
    this.g = paramFloat2;
    this.b = paramFloat3;
    this.a = paramFloat4;
    return clamp();
  }

  public Color set(int paramInt)
  {
    rgba8888ToColor(this, paramInt);
    return this;
  }

  public Color set(Color paramColor)
  {
    this.r = paramColor.r;
    this.g = paramColor.g;
    this.b = paramColor.b;
    this.a = paramColor.a;
    return this;
  }

  public Color sub(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.r -= paramFloat1;
    this.g -= paramFloat2;
    this.b -= paramFloat3;
    this.a -= paramFloat4;
    return clamp();
  }

  public Color sub(Color paramColor)
  {
    this.r -= paramColor.r;
    this.g -= paramColor.g;
    this.b -= paramColor.b;
    this.a -= paramColor.a;
    return clamp();
  }

  public float toFloatBits()
  {
    return NumberUtils.intToFloatColor((int)(255.0F * this.a) << 24 | (int)(255.0F * this.b) << 16 | (int)(255.0F * this.g) << 8 | (int)(255.0F * this.r));
  }

  public int toIntBits()
  {
    return (int)(255.0F * this.a) << 24 | (int)(255.0F * this.b) << 16 | (int)(255.0F * this.g) << 8 | (int)(255.0F * this.r);
  }

  public String toString()
  {
    for (String str = Integer.toHexString((int)(255.0F * this.r) << 24 | (int)(255.0F * this.g) << 16 | (int)(255.0F * this.b) << 8 | (int)(255.0F * this.a)); str.length() < 8; str = "0" + str);
    return str;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.Color
 * JD-Core Version:    0.6.0
 */