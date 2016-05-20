package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class p
  implements Parcelable.Creator
{
  static void a(RealtimeDocumentSyncRequest paramRealtimeDocumentSyncRequest, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramRealtimeDocumentSyncRequest.a);
    j.a(paramParcel, 2, paramRealtimeDocumentSyncRequest.b, false);
    j.a(paramParcel, 3, paramRealtimeDocumentSyncRequest.c, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.p
 * JD-Core Version:    0.6.0
 */