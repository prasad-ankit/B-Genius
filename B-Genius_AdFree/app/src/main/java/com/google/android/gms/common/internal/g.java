package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

public final class g
  implements DialogInterface.OnClickListener
{
  private final Activity a;
  private final Fragment b;
  private final Intent c;
  private final int d;

  public g(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    this.a = paramActivity;
    this.b = null;
    this.c = paramIntent;
    this.d = paramInt;
  }

  public g(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    this.a = null;
    this.b = paramFragment;
    this.c = paramIntent;
    this.d = paramInt;
  }

  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if ((this.c != null) && (this.b != null))
        this.b.startActivityForResult(this.c, this.d);
      while (true)
      {
        paramDialogInterface.dismiss();
        return;
        if (this.c == null)
          continue;
        this.a.startActivityForResult(this.c, this.d);
      }
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      Log.e("SettingsRedirect", "Can't redirect to app settings for Google Play services");
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.g
 * JD-Core Version:    0.6.0
 */