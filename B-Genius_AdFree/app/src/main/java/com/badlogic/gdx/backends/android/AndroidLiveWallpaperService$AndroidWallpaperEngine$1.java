package com.badlogic.gdx.backends.android;

class AndroidLiveWallpaperService$AndroidWallpaperEngine$1
  implements Runnable
{
  public void run()
  {
    synchronized (this.this$1.this$0.sync)
    {
      if (this.this$1.this$0.linkedEngine == this.this$1)
      {
        i = 1;
        if (i != 0)
          ((AndroidWallpaperListener)this.this$1.this$0.app.listener).offsetChange(this.this$1.xOffset, this.this$1.yOffset, this.this$1.xOffsetStep, this.this$1.yOffsetStep, this.this$1.xPixelOffset, this.this$1.yPixelOffset);
        return;
      }
      int i = 0;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidLiveWallpaperService.AndroidWallpaperEngine.1
 * JD-Core Version:    0.6.0
 */