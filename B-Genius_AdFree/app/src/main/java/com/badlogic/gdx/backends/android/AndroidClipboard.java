package com.badlogic.gdx.backends.android;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Context;
import android.os.Build.VERSION;
import com.badlogic.gdx.utils.Clipboard;

public class AndroidClipboard
  implements Clipboard
{
  Context context;

  public AndroidClipboard(Context paramContext)
  {
    this.context = paramContext;
  }

  public String getContents()
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      android.text.ClipboardManager localClipboardManager = (android.text.ClipboardManager)this.context.getSystemService("clipboard");
      if (localClipboardManager.getText() == null)
        return null;
      return localClipboardManager.getText().toString();
    }
    ClipData localClipData = ((android.content.ClipboardManager)this.context.getSystemService("clipboard")).getPrimaryClip();
    if (localClipData == null)
      return null;
    CharSequence localCharSequence = localClipData.getItemAt(0).getText();
    if (localCharSequence == null)
      return null;
    return localCharSequence.toString();
  }

  public void setContents(String paramString)
  {
    try
    {
      ((Activity)this.context).runOnUiThread(new AndroidClipboard.1(this, paramString));
      return;
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidClipboard
 * JD-Core Version:    0.6.0
 */