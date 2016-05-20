package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.n;
import android.support.v4.app.w;
import android.support.v4.app.y;

public final class f extends n
{
  private Dialog a = null;
  private DialogInterface.OnCancelListener b = null;

  public static f a(Dialog paramDialog, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    f localf = new f();
    Dialog localDialog = (Dialog)w.a(paramDialog, "Cannot display null dialog");
    localDialog.setOnCancelListener(null);
    localDialog.setOnDismissListener(null);
    localf.a = localDialog;
    if (paramOnCancelListener != null)
      localf.b = paramOnCancelListener;
    return localf;
  }

  public final Dialog a()
  {
    if (this.a == null)
      a(false);
    return this.a;
  }

  public final void a(y paramy, String paramString)
  {
    super.a(paramy, paramString);
  }

  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.b != null)
      this.b.onCancel(paramDialogInterface);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.f
 * JD-Core Version:    0.6.0
 */