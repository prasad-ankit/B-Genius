package com.badlogic.gdx.graphics.g2d;

public enum Animation$PlayMode
{
  static
  {
    LOOP = new PlayMode("LOOP", 2);
    LOOP_REVERSED = new PlayMode("LOOP_REVERSED", 3);
    LOOP_PINGPONG = new PlayMode("LOOP_PINGPONG", 4);
    LOOP_RANDOM = new PlayMode("LOOP_RANDOM", 5);
    PlayMode[] arrayOfPlayMode = new PlayMode[6];
    arrayOfPlayMode[0] = NORMAL;
    arrayOfPlayMode[1] = REVERSED;
    arrayOfPlayMode[2] = LOOP;
    arrayOfPlayMode[3] = LOOP_REVERSED;
    arrayOfPlayMode[4] = LOOP_PINGPONG;
    arrayOfPlayMode[5] = LOOP_RANDOM;
    $VALUES = arrayOfPlayMode;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g2d.Animation.PlayMode
 * JD-Core Version:    0.6.0
 */