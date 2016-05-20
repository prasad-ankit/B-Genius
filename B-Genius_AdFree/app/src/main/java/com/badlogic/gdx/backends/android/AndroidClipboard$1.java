package com.badlogic.gdx.backends.android;

import android.content.ClipData;
import android.content.Context;
import android.os.Build.VERSION;

class AndroidClipboard$1
  implements Runnable
{
  public void run()
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      ((android.text.ClipboardManager)this.this$0.context.getSystemService("clipboard")).setText(this.val$contents);
      return;
    }
    ((android.content.ClipboardManager)this.this$0.context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(this.val$contents, this.val$contents));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidClipboard.1
 * JD-Core Version:    0.6.0
 */