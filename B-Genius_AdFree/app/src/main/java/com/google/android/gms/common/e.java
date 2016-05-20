package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.support.v4.app.Fragment;
import android.support.v4.app.j;
import android.support.v4.app.r;
import android.support.v4.app.y;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.common.internal.g;

public final class e extends q
{
  public static Dialog a(int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return b(paramInt1, paramActivity, null, 9002, null);
  }

  public static void a(Activity paramActivity, DialogInterface.OnCancelListener paramOnCancelListener, String paramString, Dialog paramDialog)
  {
    if ((paramActivity instanceof r))
    {
      y localy = ((r)paramActivity).a();
      f.a(paramDialog, paramOnCancelListener).a(localy, paramString);
      return;
    }
    if (j.a())
    {
      FragmentManager localFragmentManager = paramActivity.getFragmentManager();
      a.a(paramDialog, paramOnCancelListener).show(localFragmentManager, paramString);
      return;
    }
    throw new RuntimeException("This Activity does not support Fragments.");
  }

  public static boolean a(int paramInt1, Activity paramActivity, Fragment paramFragment, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Dialog localDialog = b(paramInt1, paramActivity, paramFragment, 2, paramOnCancelListener);
    if (localDialog == null)
      return false;
    a(paramActivity, paramOnCancelListener, "GooglePlayServicesErrorDialog", localDialog);
    return true;
  }

  private static Dialog b(int paramInt1, Activity paramActivity, Fragment paramFragment, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (paramInt1 == 0)
      return null;
    if ((j.a(paramActivity)) && (paramInt1 == 2))
      paramInt1 = 42;
    if (q.b(paramActivity, paramInt1))
      paramInt1 = 18;
    if (j.c())
    {
      TypedValue localTypedValue = new TypedValue();
      paramActivity.getTheme().resolveAttribute(16843529, localTypedValue, true);
      if (!"Theme.Dialog.Alert".equals(paramActivity.getResources().getResourceEntryName(localTypedValue.resourceId)));
    }
    for (AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramActivity, 5); ; localBuilder = null)
    {
      if (localBuilder == null)
        localBuilder = new AlertDialog.Builder(paramActivity);
      localBuilder.setMessage(j.a(paramActivity, paramInt1, e(paramActivity)));
      if (paramOnCancelListener != null)
        localBuilder.setOnCancelListener(paramOnCancelListener);
      Intent localIntent = b.a().a(paramActivity, paramInt1, "d");
      g localg;
      Resources localResources1;
      String str;
      label205: Resources localResources2;
      Object localObject;
      if (paramFragment == null)
      {
        localg = new g(paramActivity, localIntent, paramInt2);
        localResources1 = paramActivity.getResources();
        switch (paramInt1)
        {
        default:
          str = localResources1.getString(17039370);
          if (str != null)
            localBuilder.setPositiveButton(str, localg);
          localResources2 = paramActivity.getResources();
          localObject = null;
          switch (paramInt1)
          {
          default:
            Log.e("GoogleApiAvailability", "Unexpected error code " + paramInt1);
          case 4:
          case 6:
          case 1:
          case 3:
          case 18:
          case 2:
          case 42:
          case 9:
          case 7:
          case 8:
          case 10:
          case 5:
          case 11:
          case 16:
          case 17:
          case 20:
          }
        case 1:
        case 3:
        case 2:
        }
      }
      while (true)
      {
        if (localObject != null)
          localBuilder.setTitle((CharSequence)localObject);
        return localBuilder.create();
        localg = new g(paramFragment, localIntent, paramInt2);
        break;
        str = localResources1.getString(2130968580);
        break label205;
        str = localResources1.getString(2130968577);
        break label205;
        str = localResources1.getString(2130968596);
        break label205;
        localObject = localResources2.getString(2130968583);
        continue;
        localObject = localResources2.getString(2130968579);
        continue;
        localObject = localResources2.getString(2130968600);
        continue;
        localObject = localResources2.getString(2130968598);
        continue;
        Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
        localObject = localResources2.getString(2130968595);
        continue;
        Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
        localObject = localResources2.getString(2130968587);
        continue;
        Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
        localObject = null;
        continue;
        Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
        localObject = null;
        continue;
        Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
        localObject = localResources2.getString(2130968585);
        continue;
        Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
        localObject = null;
        continue;
        Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
        localObject = null;
        continue;
        Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
        localObject = localResources2.getString(2130968592);
        continue;
        Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
        localObject = localResources2.getString(2130968590);
      }
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.e
 * JD-Core Version:    0.6.0
 */