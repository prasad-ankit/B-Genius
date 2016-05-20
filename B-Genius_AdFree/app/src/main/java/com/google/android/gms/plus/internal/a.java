package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.server.response.SafeParcelResponse;
import com.google.android.gms.plus.internal.model.people.PersonEntity;

public abstract interface a extends IInterface
{
  public abstract void a(int paramInt, Bundle paramBundle);

  public abstract void a(int paramInt, Bundle paramBundle1, Bundle paramBundle2);

  public abstract void a(int paramInt, Bundle paramBundle, ParcelFileDescriptor paramParcelFileDescriptor);

  public abstract void a(int paramInt, Bundle paramBundle, SafeParcelResponse paramSafeParcelResponse);

  public abstract void a(int paramInt, PersonEntity paramPersonEntity);

  public abstract void a(Status paramStatus);

  public abstract void a(DataHolder paramDataHolder, String paramString);

  public abstract void a(DataHolder paramDataHolder, String paramString1, String paramString2);

  public abstract void a(String paramString);

  public abstract void b(String paramString);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.a
 * JD-Core Version:    0.6.0
 */