package com.google.android.gms.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.google.android.gms.ads.internal.P;

final class eO
  implements DialogInterface.OnClickListener
{
  eO(eN parameN)
  {
  }

  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent = this.a.b();
    P.e();
    hu.a(eN.a(this.a), localIntent);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.eO
 * JD-Core Version:    0.6.0
 */