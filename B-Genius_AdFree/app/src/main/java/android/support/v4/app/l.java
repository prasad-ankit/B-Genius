package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

abstract class l extends Activity
{
  abstract View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet);

  protected void onCreate(Bundle paramBundle)
  {
    if ((Build.VERSION.SDK_INT < 11) && (getLayoutInflater().getFactory() == null))
      getLayoutInflater().setFactory(this);
    super.onCreate(paramBundle);
  }

  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    View localView = a(null, paramString, paramContext, paramAttributeSet);
    if (localView == null)
      localView = super.onCreateView(paramString, paramContext, paramAttributeSet);
    return localView;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.l
 * JD-Core Version:    0.6.0
 */