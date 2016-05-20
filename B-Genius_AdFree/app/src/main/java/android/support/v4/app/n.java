package android.support.v4.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

public class n extends Fragment
  implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener
{
  private int a = 0;
  private int b = 0;
  private boolean c = true;
  private boolean d = true;
  private int e = -1;
  private Dialog f;
  private boolean g;
  private boolean h;
  private boolean i;

  public Dialog a()
  {
    return new Dialog(getActivity(), this.b);
  }

  public void a(y paramy, String paramString)
  {
    this.h = false;
    this.i = true;
    I localI = paramy.a();
    localI.a(this, paramString);
    localI.a();
  }

  public final void a(boolean paramBoolean)
  {
    this.d = false;
  }

  public LayoutInflater getLayoutInflater(Bundle paramBundle)
  {
    if (!this.d)
      return super.getLayoutInflater(paramBundle);
    this.f = a();
    if (this.f != null)
    {
      Dialog localDialog = this.f;
      switch (this.a)
      {
      default:
      case 3:
      case 1:
      case 2:
      }
      while (true)
      {
        return (LayoutInflater)this.f.getContext().getSystemService("layout_inflater");
        localDialog.getWindow().addFlags(24);
        localDialog.requestWindowFeature(1);
      }
    }
    return (LayoutInflater)this.mHost.a.getSystemService("layout_inflater");
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (!this.d);
    Bundle localBundle;
    do
    {
      do
      {
        return;
        View localView = getView();
        if (localView != null)
        {
          if (localView.getParent() != null)
            throw new IllegalStateException("DialogFragment can not be attached to a container view");
          this.f.setContentView(localView);
        }
        this.f.setOwnerActivity(getActivity());
        this.f.setCancelable(this.c);
        this.f.setOnCancelListener(this);
        this.f.setOnDismissListener(this);
      }
      while (paramBundle == null);
      localBundle = paramBundle.getBundle("android:savedDialogState");
    }
    while (localBundle == null);
    this.f.onRestoreInstanceState(localBundle);
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (!this.i)
      this.h = false;
  }

  public void onCancel(DialogInterface paramDialogInterface)
  {
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.mContainerId == 0);
    for (boolean bool = true; ; bool = false)
    {
      this.d = bool;
      if (paramBundle != null)
      {
        this.a = paramBundle.getInt("android:style", 0);
        this.b = paramBundle.getInt("android:theme", 0);
        this.c = paramBundle.getBoolean("android:cancelable", true);
        this.d = paramBundle.getBoolean("android:showsDialog", this.d);
        this.e = paramBundle.getInt("android:backStackId", -1);
      }
      return;
    }
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.f != null)
    {
      this.g = true;
      this.f.dismiss();
      this.f = null;
    }
  }

  public void onDetach()
  {
    super.onDetach();
    if ((!this.i) && (!this.h))
      this.h = true;
  }

  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((!this.g) && (!this.h))
    {
      this.h = true;
      this.i = false;
      if (this.f != null)
      {
        this.f.dismiss();
        this.f = null;
      }
      this.g = true;
      if (this.e >= 0)
      {
        getFragmentManager().a(this.e, 1);
        this.e = -1;
      }
    }
    else
    {
      return;
    }
    I localI = getFragmentManager().a();
    localI.a(this);
    localI.b();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.f != null)
    {
      Bundle localBundle = this.f.onSaveInstanceState();
      if (localBundle != null)
        paramBundle.putBundle("android:savedDialogState", localBundle);
    }
    if (this.a != 0)
      paramBundle.putInt("android:style", this.a);
    if (this.b != 0)
      paramBundle.putInt("android:theme", this.b);
    if (!this.c)
      paramBundle.putBoolean("android:cancelable", this.c);
    if (!this.d)
      paramBundle.putBoolean("android:showsDialog", this.d);
    if (this.e != -1)
      paramBundle.putInt("android:backStackId", this.e);
  }

  public void onStart()
  {
    super.onStart();
    if (this.f != null)
    {
      this.g = false;
      this.f.show();
    }
  }

  public void onStop()
  {
    super.onStop();
    if (this.f != null)
      this.f.hide();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.n
 * JD-Core Version:    0.6.0
 */