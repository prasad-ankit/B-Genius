package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

public final class AdResponseParcel
  implements SafeParcelable
{
  public static final t CREATOR = new t();
  public String A;
  public boolean B;
  public boolean C;
  public RewardItemParcel D;
  public List E;
  public List F;
  public boolean G;
  private AdRequestInfoParcel H;
  public final int a;
  public final String b;
  public String c;
  public final List d;
  public final int e;
  public final List f;
  public final long g;
  public final boolean h;
  public final long i;
  public final List j;
  public final long k;
  public final int l;
  public final String m;
  public final long n;
  public final String o;
  public final boolean p;
  public final String q;
  public final String r;
  public final boolean s;
  public final boolean t;
  public final boolean u;
  public final boolean v;
  public final boolean w;
  public final int x;
  public LargeParcelTeleporter y;
  public String z;

  public AdResponseParcel(int paramInt)
  {
    this(16, null, null, null, paramInt, null, -1L, false, -1L, null, -1L, -1, null, -1L, null, false, null, null, false, false, false, true, false, 0, null, null, null, false, false, null, null, null, false);
  }

  public AdResponseParcel(int paramInt, long paramLong)
  {
    this(16, null, null, null, paramInt, null, -1L, false, -1L, null, paramLong, -1, null, -1L, null, false, null, null, false, false, false, true, false, 0, null, null, null, false, false, null, null, null, false);
  }

  AdResponseParcel(int paramInt1, String paramString1, String paramString2, List paramList1, int paramInt2, List paramList2, long paramLong1, boolean paramBoolean1, long paramLong2, List paramList3, long paramLong3, int paramInt3, String paramString3, long paramLong4, String paramString4, boolean paramBoolean2, String paramString5, String paramString6, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, int paramInt4, LargeParcelTeleporter paramLargeParcelTeleporter, String paramString7, String paramString8, boolean paramBoolean8, boolean paramBoolean9, RewardItemParcel paramRewardItemParcel, List paramList4, List paramList5, boolean paramBoolean10)
  {
    this.a = paramInt1;
    this.b = paramString1;
    this.c = paramString2;
    List localList1;
    List localList2;
    if (paramList1 != null)
    {
      localList1 = Collections.unmodifiableList(paramList1);
      this.d = localList1;
      this.e = paramInt2;
      if (paramList2 == null)
        break label296;
      localList2 = Collections.unmodifiableList(paramList2);
      label55: this.f = localList2;
      this.g = paramLong1;
      this.h = paramBoolean1;
      this.i = paramLong2;
      if (paramList3 == null)
        break label302;
    }
    label296: label302: for (List localList3 = Collections.unmodifiableList(paramList3); ; localList3 = null)
    {
      this.j = localList3;
      this.k = paramLong3;
      this.l = paramInt3;
      this.m = paramString3;
      this.n = paramLong4;
      this.o = paramString4;
      this.p = paramBoolean2;
      this.q = paramString5;
      this.r = paramString6;
      this.s = paramBoolean3;
      this.t = paramBoolean4;
      this.u = paramBoolean5;
      this.v = paramBoolean6;
      this.w = paramBoolean7;
      this.x = paramInt4;
      this.y = paramLargeParcelTeleporter;
      this.z = paramString7;
      this.A = paramString8;
      if ((this.c == null) && (this.y != null))
      {
        StringParcel localStringParcel = (StringParcel)this.y.a(StringParcel.CREATOR);
        if ((localStringParcel != null) && (!TextUtils.isEmpty(localStringParcel.b)))
          this.c = localStringParcel.b;
      }
      this.B = paramBoolean8;
      this.C = paramBoolean9;
      this.D = paramRewardItemParcel;
      this.E = paramList4;
      this.F = paramList5;
      this.G = paramBoolean10;
      return;
      localList1 = null;
      break;
      localList2 = null;
      break label55;
    }
  }

  public AdResponseParcel(AdRequestInfoParcel paramAdRequestInfoParcel, String paramString1, String paramString2, List paramList1, List paramList2, long paramLong1, boolean paramBoolean1, long paramLong2, List paramList3, long paramLong3, int paramInt1, String paramString3, long paramLong4, String paramString4, String paramString5, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, int paramInt2, String paramString6, boolean paramBoolean7, boolean paramBoolean8, RewardItemParcel paramRewardItemParcel, List paramList4, List paramList5, boolean paramBoolean9)
  {
    this(16, paramString1, paramString2, paramList1, -2, paramList2, paramLong1, paramBoolean1, -1L, paramList3, paramLong3, paramInt1, paramString3, paramLong4, paramString4, false, null, paramString5, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, false, paramInt2, null, null, paramString6, paramBoolean7, paramBoolean8, paramRewardItemParcel, paramList4, paramList5, paramBoolean9);
    this.H = paramAdRequestInfoParcel;
  }

  public AdResponseParcel(AdRequestInfoParcel paramAdRequestInfoParcel, String paramString1, String paramString2, List paramList1, List paramList2, long paramLong1, boolean paramBoolean1, long paramLong2, List paramList3, long paramLong3, int paramInt1, String paramString3, long paramLong4, String paramString4, boolean paramBoolean2, String paramString5, String paramString6, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, int paramInt2, String paramString7, boolean paramBoolean8, boolean paramBoolean9, RewardItemParcel paramRewardItemParcel, List paramList4, List paramList5, boolean paramBoolean10)
  {
    this(16, paramString1, paramString2, paramList1, -2, paramList2, paramLong1, paramBoolean1, paramLong2, paramList3, paramLong3, paramInt1, paramString3, paramLong4, paramString4, paramBoolean2, paramString5, paramString6, paramBoolean3, paramBoolean4, paramBoolean5, paramBoolean6, paramBoolean7, paramInt2, null, null, paramString7, paramBoolean8, paramBoolean9, paramRewardItemParcel, paramList4, paramList5, paramBoolean10);
    this.H = paramAdRequestInfoParcel;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if ((this.H != null) && (this.H.a >= 9) && (!TextUtils.isEmpty(this.c)))
    {
      this.y = new LargeParcelTeleporter(new StringParcel(this.c));
      this.c = null;
    }
    t.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.request.AdResponseParcel
 * JD-Core Version:    0.6.0
 */