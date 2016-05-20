package com.badlogic.gdx.backends.android;

class AndroidLiveWallpaperService$AndroidWallpaperEngine$2
  implements Runnable
{
  public void run()
  {
    synchronized (this.this$1.this$0.sync)
    {
      int i;
      if (this.this$1.this$0.isPreviewNotified)
      {
        boolean bool1 = this.this$1.this$0.notifiedPreviewState;
        boolean bool2 = this.val$currentPreviewState;
        i = 0;
        if (bool1 == bool2);
      }
      else
      {
        this.this$1.this$0.notifiedPreviewState = this.val$currentPreviewState;
        this.this$1.this$0.isPreviewNotified = true;
        i = 1;
      }
      if (i != 0)
      {
        AndroidLiveWallpaper localAndroidLiveWallpaper = this.this$1.this$0.app;
        if (localAndroidLiveWallpaper != null)
          ((AndroidWallpaperListener)localAndroidLiveWallpaper.listener).previewStateChange(this.val$currentPreviewState);
      }
      return;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidLiveWallpaperService.AndroidWallpaperEngine.2
 * JD-Core Version:    0.6.0
 */