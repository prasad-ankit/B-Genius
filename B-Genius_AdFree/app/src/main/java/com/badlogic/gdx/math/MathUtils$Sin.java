package com.badlogic.gdx.math;

class MathUtils$Sin
{
  static final float[] table = new float[16384];

  static
  {
    int j;
    for (int i = 0; ; i++)
    {
      j = 0;
      if (i >= 16384)
        break;
      table[i] = (float)Math.sin(6.283186F * ((0.5F + i) / 16384.0F));
    }
    while (j < 360)
    {
      table[(0x3FFF & (int)(45.511112F * j))] = (float)Math.sin(0.01745329F * j);
      j += 90;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.MathUtils.Sin
 * JD-Core Version:    0.6.0
 */