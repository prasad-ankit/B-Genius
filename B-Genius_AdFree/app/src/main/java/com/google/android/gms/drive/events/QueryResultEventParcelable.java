package com.google.android.gms.drive.events;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.WriteAwareParcelable;

public class QueryResultEventParcelable extends WriteAwareParcelable
  implements DriveEvent
{
  public static final e CREATOR = new e();
  final int a;
  final DataHolder b;
  final boolean c;
  final int d;

  QueryResultEventParcelable(int paramInt1, DataHolder paramDataHolder, boolean paramBoolean, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramDataHolder;
    this.c = paramBoolean;
    this.d = paramInt2;
  }

  public final void a(Parcel paramParcel, int paramInt)
  {
    e.a(this, paramParcel, paramInt);
  }

  public int describeContents()
  {
    return 0;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.events.QueryResultEventParcelable
 * JD-Core Version:    0.6.0
 */