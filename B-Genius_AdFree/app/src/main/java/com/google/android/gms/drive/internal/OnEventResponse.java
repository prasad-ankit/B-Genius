package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;
import com.google.android.gms.drive.events.TransferProgressEvent;
import com.google.android.gms.drive.events.TransferStateEvent;

public class OnEventResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new C();
  final int a;
  final int b;
  final ChangeEvent c;
  final CompletionEvent d;
  final QueryResultEventParcelable e;
  final ChangesAvailableEvent f;
  final TransferStateEvent g;
  final TransferProgressEvent h;

  OnEventResponse(int paramInt1, int paramInt2, ChangeEvent paramChangeEvent, CompletionEvent paramCompletionEvent, QueryResultEventParcelable paramQueryResultEventParcelable, ChangesAvailableEvent paramChangesAvailableEvent, TransferStateEvent paramTransferStateEvent, TransferProgressEvent paramTransferProgressEvent)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramChangeEvent;
    this.d = paramCompletionEvent;
    this.e = paramQueryResultEventParcelable;
    this.f = paramChangesAvailableEvent;
    this.g = paramTransferStateEvent;
    this.h = paramTransferProgressEvent;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    C.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.OnEventResponse
 * JD-Core Version:    0.6.0
 */