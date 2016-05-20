package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.ProgressBar;

public final class b extends i
{
  private static final b b = new b();

  public static Dialog a(Activity paramActivity, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    ProgressBar localProgressBar = new ProgressBar(paramActivity, null, 16842874);
    localProgressBar.setIndeterminate(true);
    localProgressBar.setVisibility(0);
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramActivity);
    localBuilder.setView(localProgressBar);
    String str = e.e(paramActivity);
    localBuilder.setMessage(paramActivity.getResources().getString(2130968599, new Object[] { str }));
    localBuilder.setTitle(2130968600);
    localBuilder.setPositiveButton("", null);
    AlertDialog localAlertDialog = localBuilder.create();
    e.a(paramActivity, paramOnCancelListener, "GooglePlayServicesUpdatingDialog", localAlertDialog);
    return localAlertDialog;
  }

  public static b a()
  {
    return b;
  }

  public final int a(Context paramContext)
  {
    return super.a(paramContext);
  }

  public final Intent a(Context paramContext, int paramInt, String paramString)
  {
    return super.a(paramContext, paramInt, paramString);
  }

  public final boolean a(int paramInt)
  {
    return super.a(paramInt);
  }

  public final boolean a(Context paramContext, int paramInt)
  {
    return super.a(paramContext, paramInt);
  }

  public final int b(Context paramContext)
  {
    return super.b(paramContext);
  }

  public final Intent b(int paramInt)
  {
    return super.b(paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.b
 * JD-Core Version:    0.6.0
 */