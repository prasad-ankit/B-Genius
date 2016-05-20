package com.google.android.gms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.w;

public final class a extends DialogFragment
{
  private Dialog a = null;
  private DialogInterface.OnCancelListener b = null;

  public static a a(Dialog paramDialog, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    a locala = new a();
    Dialog localDialog = (Dialog)w.a(paramDialog, "Cannot display null dialog");
    localDialog.setOnCancelListener(null);
    localDialog.setOnDismissListener(null);
    locala.a = localDialog;
    if (paramOnCancelListener != null)
      locala.b = paramOnCancelListener;
    return locala;
  }

  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.b != null)
      this.b.onCancel(paramDialogInterface);
  }

  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    if (this.a == null)
      setShowsDialog(false);
    return this.a;
  }

  public final void show(FragmentManager paramFragmentManager, String paramString)
  {
    super.show(paramFragmentManager, paramString);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.a
 * JD-Core Version:    0.6.0
 */