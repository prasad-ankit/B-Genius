package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Q;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import java.util.Arrays;

public final class ParticipantEntity extends GamesDowngradeableSafeParcel
  implements Participant
{
  public static final Parcelable.Creator CREATOR = new e();
  private final int a;
  private final String b;
  private final String c;
  private final Uri d;
  private final Uri e;
  private final int f;
  private final String g;
  private final boolean h;
  private final PlayerEntity i;
  private final int j;
  private final ParticipantResult k;
  private final String l;
  private final String m;

  ParticipantEntity(int paramInt1, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2, int paramInt2, String paramString3, boolean paramBoolean, PlayerEntity paramPlayerEntity, int paramInt3, ParticipantResult paramParticipantResult, String paramString4, String paramString5)
  {
    this.a = paramInt1;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramUri1;
    this.e = paramUri2;
    this.f = paramInt2;
    this.g = paramString3;
    this.h = paramBoolean;
    this.i = paramPlayerEntity;
    this.j = paramInt3;
    this.k = paramParticipantResult;
    this.l = paramString4;
    this.m = paramString5;
  }

  public final int a()
  {
    return this.f;
  }

  public final String b()
  {
    return this.g;
  }

  public final int d()
  {
    return this.j;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final boolean e()
  {
    return this.h;
  }

  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Participant))
    {
      if (this == paramObject);
      Participant localParticipant;
      do
      {
        return true;
        localParticipant = (Participant)paramObject;
      }
      while ((com.google.android.gms.common.internal.f.a(localParticipant.j(), j())) && (com.google.android.gms.common.internal.f.a(Integer.valueOf(localParticipant.a()), Integer.valueOf(a()))) && (com.google.android.gms.common.internal.f.a(localParticipant.b(), b())) && (com.google.android.gms.common.internal.f.a(Boolean.valueOf(localParticipant.e()), Boolean.valueOf(e()))) && (com.google.android.gms.common.internal.f.a(localParticipant.f(), f())) && (com.google.android.gms.common.internal.f.a(localParticipant.g(), g())) && (com.google.android.gms.common.internal.f.a(localParticipant.h(), h())) && (com.google.android.gms.common.internal.f.a(Integer.valueOf(localParticipant.d()), Integer.valueOf(d()))) && (com.google.android.gms.common.internal.f.a(localParticipant.k(), k())) && (com.google.android.gms.common.internal.f.a(localParticipant.i(), i())));
    }
    return false;
  }

  public final String f()
  {
    if (this.i == null)
      return this.c;
    return this.i.b();
  }

  public final Uri g()
  {
    if (this.i == null)
      return this.d;
    return this.i.g();
  }

  public final String getHiResImageUrl()
  {
    if (this.i == null)
      return this.m;
    return this.i.getHiResImageUrl();
  }

  public final String getIconImageUrl()
  {
    if (this.i == null)
      return this.l;
    return this.i.getIconImageUrl();
  }

  public final Uri h()
  {
    if (this.i == null)
      return this.e;
    return this.i.h();
  }

  public final int hashCode()
  {
    Object[] arrayOfObject = new Object[10];
    arrayOfObject[0] = j();
    arrayOfObject[1] = Integer.valueOf(a());
    arrayOfObject[2] = b();
    arrayOfObject[3] = Boolean.valueOf(e());
    arrayOfObject[4] = f();
    arrayOfObject[5] = g();
    arrayOfObject[6] = h();
    arrayOfObject[7] = Integer.valueOf(d());
    arrayOfObject[8] = k();
    arrayOfObject[9] = i();
    return Arrays.hashCode(arrayOfObject);
  }

  public final String i()
  {
    return this.b;
  }

  public final Player j()
  {
    return this.i;
  }

  public final ParticipantResult k()
  {
    return this.k;
  }

  public final int l()
  {
    return this.a;
  }

  public final String toString()
  {
    return com.google.android.gms.common.internal.f.a(this).a("ParticipantId", i()).a("Player", j()).a("Status", Integer.valueOf(a())).a("ClientAddress", b()).a("ConnectedToRoom", Boolean.valueOf(e())).a("DisplayName", f()).a("IconImage", g()).a("IconImageUrl", getIconImageUrl()).a("HiResImage", h()).a("HiResImageUrl", getHiResImageUrl()).a("Capabilities", Integer.valueOf(d())).a("Result", k()).toString();
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    f.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.ParticipantEntity
 * JD-Core Version:    0.6.0
 */