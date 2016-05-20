package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.w;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class RealtimeDocumentSyncRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new p();
  final int a;
  final List b;
  final List c;

  RealtimeDocumentSyncRequest(int paramInt, List paramList1, List paramList2)
  {
    this.a = paramInt;
    this.b = ((List)w.a(paramList1));
    this.c = ((List)w.a(paramList2));
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    p.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.RealtimeDocumentSyncRequest
 * JD-Core Version:    0.6.0
 */