package com.google.android.gms.plus.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.common.internal.D;
import com.google.android.gms.common.server.FavaDiagnosticsEntity;
import com.google.android.gms.common.server.response.SafeParcelResponse;
import java.util.List;

public abstract interface d extends IInterface
{
  public abstract D a(a parama, int paramInt1, int paramInt2, int paramInt3, String paramString);

  public abstract String a();

  public abstract void a(SafeParcelResponse paramSafeParcelResponse);

  public abstract void a(a parama);

  public abstract void a(a parama, int paramInt, String paramString1, Uri paramUri, String paramString2, String paramString3);

  public abstract void a(a parama, Uri paramUri, Bundle paramBundle);

  public abstract void a(a parama, SafeParcelResponse paramSafeParcelResponse);

  public abstract void a(a parama, String paramString);

  public abstract void a(a parama, String paramString1, String paramString2);

  public abstract void a(a parama, List paramList);

  public abstract void a(String paramString);

  public abstract void a(String paramString, FavaDiagnosticsEntity paramFavaDiagnosticsEntity1, FavaDiagnosticsEntity paramFavaDiagnosticsEntity2);

  public abstract void b();

  public abstract void b(a parama);

  public abstract void b(a parama, String paramString);

  public abstract String c();

  public abstract void c(a parama, String paramString);

  public abstract void d(a parama, String paramString);

  public abstract boolean d();

  public abstract String e();

  public abstract void e(a parama, String paramString);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.d
 * JD-Core Version:    0.6.0
 */