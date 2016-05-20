package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.b.k;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public final class r extends m
  implements c, e
{
  final Handler a = new s(this);
  final w b = w.a(new t(this));
  boolean c;
  boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;

  private static String a(View paramView)
  {
    char c1 = 'F';
    char c2 = '.';
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append(paramView.getClass().getName());
    localStringBuilder.append('{');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(paramView)));
    localStringBuilder.append(' ');
    switch (paramView.getVisibility())
    {
    default:
      localStringBuilder.append(c2);
    case 0:
    case 4:
    case 8:
    }
    while (true)
    {
      char c3;
      label108: char c4;
      label126: char c5;
      label143: char c6;
      label161: char c7;
      label179: char c8;
      label197: char c9;
      label215: label236: char c10;
      label253: int j;
      Resources localResources;
      if (paramView.isFocusable())
      {
        c3 = c1;
        localStringBuilder.append(c3);
        if (!paramView.isEnabled())
          break label533;
        c4 = 'E';
        localStringBuilder.append(c4);
        if (!paramView.willNotDraw())
          break label539;
        c5 = c2;
        localStringBuilder.append(c5);
        if (!paramView.isHorizontalScrollBarEnabled())
          break label546;
        c6 = 'H';
        localStringBuilder.append(c6);
        if (!paramView.isVerticalScrollBarEnabled())
          break label552;
        c7 = 'V';
        localStringBuilder.append(c7);
        if (!paramView.isClickable())
          break label558;
        c8 = 'C';
        localStringBuilder.append(c8);
        if (!paramView.isLongClickable())
          break label564;
        c9 = 'L';
        localStringBuilder.append(c9);
        localStringBuilder.append(' ');
        if (!paramView.isFocused())
          break label570;
        localStringBuilder.append(c1);
        if (!paramView.isSelected())
          break label575;
        c10 = 'S';
        localStringBuilder.append(c10);
        if (paramView.isPressed())
          c2 = 'P';
        localStringBuilder.append(c2);
        localStringBuilder.append(' ');
        localStringBuilder.append(paramView.getLeft());
        localStringBuilder.append(',');
        localStringBuilder.append(paramView.getTop());
        localStringBuilder.append('-');
        localStringBuilder.append(paramView.getRight());
        localStringBuilder.append(',');
        localStringBuilder.append(paramView.getBottom());
        j = paramView.getId();
        if (j != -1)
        {
          localStringBuilder.append(" #");
          localStringBuilder.append(Integer.toHexString(j));
          localResources = paramView.getResources();
          if ((j != 0) && (localResources != null))
            switch (0xFF000000 & j)
            {
            default:
            case 2130706432:
            case 16777216:
            }
        }
      }
      try
      {
        String str1 = localResources.getResourcePackageName(j);
        while (true)
        {
          String str2 = localResources.getResourceTypeName(j);
          String str3 = localResources.getResourceEntryName(j);
          localStringBuilder.append(" ");
          localStringBuilder.append(str1);
          localStringBuilder.append(":");
          localStringBuilder.append(str2);
          localStringBuilder.append("/");
          localStringBuilder.append(str3);
          label485: localStringBuilder.append("}");
          return localStringBuilder.toString();
          localStringBuilder.append('V');
          break;
          localStringBuilder.append('I');
          break;
          localStringBuilder.append('G');
          break;
          c3 = c2;
          break label108;
          label533: c4 = c2;
          break label126;
          label539: c5 = 'D';
          break label143;
          label546: c6 = c2;
          break label161;
          label552: c7 = c2;
          break label179;
          label558: c8 = c2;
          break label197;
          label564: c9 = c2;
          break label215;
          label570: c1 = c2;
          break label236;
          label575: c10 = c2;
          break label253;
          str1 = "app";
          continue;
          str1 = "android";
        }
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        break label485;
      }
    }
  }

  private void a(String paramString, PrintWriter paramPrintWriter, View paramView)
  {
    paramPrintWriter.print(paramString);
    if (paramView == null)
      paramPrintWriter.println("null");
    while (true)
    {
      return;
      paramPrintWriter.println(a(paramView));
      if (!(paramView instanceof ViewGroup))
        continue;
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = localViewGroup.getChildCount();
      if (j <= 0)
        continue;
      String str = paramString + "  ";
      for (int k = 0; k < j; k++)
        a(str, paramPrintWriter, localViewGroup.getChildAt(k));
    }
  }

  public final y a()
  {
    return this.b.a();
  }

  final View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return this.b.a(paramView, paramString, paramContext, paramAttributeSet);
  }

  public final void a(int paramInt)
  {
    if (this.i)
      this.i = false;
    do
      return;
    while ((paramInt & 0xFFFFFF00) == 0);
    throw new IllegalArgumentException("Can only use lower 8 bits for requestCode");
  }

  public final void a(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    if (paramInt == -1)
    {
      super.startActivityForResult(paramIntent, -1);
      return;
    }
    if ((0xFFFF0000 & paramInt) != 0)
      throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    super.startActivityForResult(paramIntent, (1 + paramFragment.mIndex << 16) + (0xFFFF & paramInt));
  }

  final void a(boolean paramBoolean)
  {
    if (!this.g)
    {
      this.g = true;
      this.h = paramBoolean;
      this.a.removeMessages(1);
      this.b.a(this.h);
      this.b.l();
    }
  }

  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("Local FragmentActivity ");
    paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
    paramPrintWriter.println(" State:");
    String str = paramString + "  ";
    paramPrintWriter.print(str);
    paramPrintWriter.print("mCreated=");
    paramPrintWriter.print(this.e);
    paramPrintWriter.print("mResumed=");
    paramPrintWriter.print(this.f);
    paramPrintWriter.print(" mStopped=");
    paramPrintWriter.print(this.c);
    paramPrintWriter.print(" mReallyStopped=");
    paramPrintWriter.println(this.g);
    this.b.a(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    this.b.a().a(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.print(paramString);
    paramPrintWriter.println("View Hierarchy:");
    a(paramString + "  ", paramPrintWriter, getWindow().getDecorView());
  }

  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.b.c();
    int j = paramInt1 >> 16;
    if (j != 0)
    {
      int k = j - 1;
      int m = this.b.b();
      if ((m == 0) || (k < 0) || (k >= m))
      {
        Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(paramInt1));
        return;
      }
      Fragment localFragment = (Fragment)this.b.a(new ArrayList(m)).get(k);
      if (localFragment == null)
      {
        Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(paramInt1));
        return;
      }
      localFragment.onActivityResult(0xFFFF & paramInt1, paramInt2, paramIntent);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public final void onBackPressed()
  {
    if (!this.b.a().c())
    {
      if (Build.VERSION.SDK_INT >= 21)
        finishAfterTransition();
    }
    else
      return;
    finish();
  }

  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.b.a(paramConfiguration);
  }

  protected final void onCreate(Bundle paramBundle)
  {
    this.b.a(null);
    super.onCreate(paramBundle);
    u localu = (u)getLastNonConfigurationInstance();
    if (localu != null)
      this.b.a(localu.b);
    Parcelable localParcelable;
    w localw;
    if (paramBundle != null)
    {
      localParcelable = paramBundle.getParcelable("android:support:fragments");
      localw = this.b;
      if (localu == null)
        break label80;
    }
    label80: for (List localList = localu.a; ; localList = null)
    {
      localw.a(localParcelable, localList);
      this.b.f();
      return;
    }
  }

  public final boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    if (paramInt == 0)
    {
      boolean bool = super.onCreatePanelMenu(paramInt, paramMenu) | this.b.a(paramMenu, getMenuInflater());
      if (Build.VERSION.SDK_INT >= 11)
        return bool;
      return true;
    }
    return super.onCreatePanelMenu(paramInt, paramMenu);
  }

  protected final void onDestroy()
  {
    super.onDestroy();
    a(false);
    this.b.m();
    this.b.q();
  }

  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((Build.VERSION.SDK_INT < 5) && (paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      onBackPressed();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }

  public final void onLowMemory()
  {
    super.onLowMemory();
    this.b.n();
  }

  public final boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (super.onMenuItemSelected(paramInt, paramMenuItem))
      return true;
    switch (paramInt)
    {
    default:
      return false;
    case 0:
      return this.b.a(paramMenuItem);
    case 6:
    }
    return this.b.b(paramMenuItem);
  }

  protected final void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.b.c();
  }

  public final void onPanelClosed(int paramInt, Menu paramMenu)
  {
    switch (paramInt)
    {
    default:
    case 0:
    }
    while (true)
    {
      super.onPanelClosed(paramInt, paramMenu);
      return;
      this.b.b(paramMenu);
    }
  }

  protected final void onPause()
  {
    super.onPause();
    this.f = false;
    if (this.a.hasMessages(2))
    {
      this.a.removeMessages(2);
      this.b.i();
    }
    this.b.j();
  }

  protected final void onPostResume()
  {
    super.onPostResume();
    this.a.removeMessages(2);
    this.b.i();
    this.b.o();
  }

  public final boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    if ((paramInt == 0) && (paramMenu != null))
    {
      if (this.d)
      {
        this.d = false;
        paramMenu.clear();
        onCreatePanelMenu(paramInt, paramMenu);
      }
      return super.onPreparePanel(0, paramView, paramMenu) | this.b.a(paramMenu);
    }
    return super.onPreparePanel(paramInt, paramView, paramMenu);
  }

  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int j = 0xFF & paramInt >> 8;
    int k;
    int m;
    if (j != 0)
    {
      k = j - 1;
      m = this.b.b();
      if ((m == 0) || (k < 0) || (k >= m))
        Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(paramInt));
    }
    else
    {
      return;
    }
    Fragment localFragment = (Fragment)this.b.a(new ArrayList(m)).get(k);
    if (localFragment == null)
    {
      Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(paramInt));
      return;
    }
    localFragment.onRequestPermissionsResult(paramInt & 0xFF, paramArrayOfString, paramArrayOfInt);
  }

  protected final void onResume()
  {
    super.onResume();
    this.a.sendEmptyMessage(2);
    this.f = true;
    this.b.o();
  }

  public final Object onRetainNonConfigurationInstance()
  {
    if (this.c)
      a(true);
    List localList = this.b.e();
    k localk = this.b.s();
    if ((localList == null) && (localk == null))
      return null;
    u localu = new u();
    localu.a = localList;
    localu.b = localk;
    return localu;
  }

  protected final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    Parcelable localParcelable = this.b.d();
    if (localParcelable != null)
      paramBundle.putParcelable("android:support:fragments", localParcelable);
  }

  protected final void onStart()
  {
    super.onStart();
    this.c = false;
    this.g = false;
    this.a.removeMessages(1);
    if (!this.e)
    {
      this.e = true;
      this.b.g();
    }
    this.b.c();
    this.b.o();
    this.b.p();
    this.b.h();
    this.b.r();
  }

  public final void onStateNotSaved()
  {
    this.b.c();
  }

  protected final void onStop()
  {
    super.onStop();
    this.c = true;
    this.a.sendEmptyMessage(1);
    this.b.k();
  }

  public final void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if ((paramInt != -1) && ((0xFFFF0000 & paramInt) != 0))
      throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    super.startActivityForResult(paramIntent, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.r
 * JD-Core Version:    0.6.0
 */