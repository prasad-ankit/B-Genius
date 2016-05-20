package com.badlogic.gdx.backends.android;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

class AndroidNet$1
  implements Runnable
{
  public void run()
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", this.val$uri);
    if (!(this.this$0.app.getContext() instanceof Activity))
      localIntent.addFlags(268435456);
    this.this$0.app.startActivity(localIntent);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidNet.1
 * JD-Core Version:    0.6.0
 */