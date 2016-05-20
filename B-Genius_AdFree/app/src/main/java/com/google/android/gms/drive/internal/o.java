package com.google.android.gms.drive.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.realtime.internal.G;

final class o
  implements m
{
  private IBinder a;

  o(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }

  public final void a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      this.a.transact(7, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(Status paramStatus)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if (paramStatus != null)
      {
        localParcel1.writeInt(1);
        paramStatus.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(6, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(ChangeSequenceNumber paramChangeSequenceNumber)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if (paramChangeSequenceNumber != null)
      {
        localParcel1.writeInt(1);
        paramChangeSequenceNumber.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(17, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(GetPermissionsResponse paramGetPermissionsResponse)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if (paramGetPermissionsResponse != null)
      {
        localParcel1.writeInt(1);
        paramGetPermissionsResponse.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(20, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(OnChangesResponse paramOnChangesResponse)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if (paramOnChangesResponse != null)
      {
        localParcel1.writeInt(1);
        paramOnChangesResponse.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(18, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(OnContentsResponse paramOnContentsResponse)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if (paramOnContentsResponse != null)
      {
        localParcel1.writeInt(1);
        paramOnContentsResponse.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(5, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(OnDeviceUsagePreferenceResponse paramOnDeviceUsagePreferenceResponse)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if (paramOnDeviceUsagePreferenceResponse != null)
      {
        localParcel1.writeInt(1);
        paramOnDeviceUsagePreferenceResponse.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(14, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(OnDownloadProgressResponse paramOnDownloadProgressResponse)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if (paramOnDownloadProgressResponse != null)
      {
        localParcel1.writeInt(1);
        paramOnDownloadProgressResponse.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(1, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(OnDriveIdResponse paramOnDriveIdResponse)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if (paramOnDriveIdResponse != null)
      {
        localParcel1.writeInt(1);
        paramOnDriveIdResponse.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(3, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(OnFetchThumbnailResponse paramOnFetchThumbnailResponse)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if (paramOnFetchThumbnailResponse != null)
      {
        localParcel1.writeInt(1);
        paramOnFetchThumbnailResponse.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(16, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(OnListEntriesResponse paramOnListEntriesResponse)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if (paramOnListEntriesResponse != null)
      {
        localParcel1.writeInt(1);
        paramOnListEntriesResponse.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(2, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(OnListParentsResponse paramOnListParentsResponse)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if (paramOnListParentsResponse != null)
      {
        localParcel1.writeInt(1);
        paramOnListParentsResponse.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(8, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(OnLoadRealtimeResponse paramOnLoadRealtimeResponse, G paramG)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        if (paramOnLoadRealtimeResponse == null)
          continue;
        localParcel1.writeInt(1);
        paramOnLoadRealtimeResponse.writeToParcel(localParcel1, 0);
        if (paramG != null)
        {
          localIBinder = paramG.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(11, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
          localParcel1.writeInt(0);
          continue;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      IBinder localIBinder = null;
    }
  }

  public final void a(OnMetadataResponse paramOnMetadataResponse)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if (paramOnMetadataResponse != null)
      {
        localParcel1.writeInt(1);
        paramOnMetadataResponse.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(4, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(OnPinnedDownloadPreferencesResponse paramOnPinnedDownloadPreferencesResponse)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if (paramOnPinnedDownloadPreferencesResponse != null)
      {
        localParcel1.writeInt(1);
        paramOnPinnedDownloadPreferencesResponse.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(13, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(OnResourceIdSetResponse paramOnResourceIdSetResponse)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if (paramOnResourceIdSetResponse != null)
      {
        localParcel1.writeInt(1);
        paramOnResourceIdSetResponse.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(12, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(OnStartStreamSession paramOnStartStreamSession)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if (paramOnStartStreamSession != null)
      {
        localParcel1.writeInt(1);
        paramOnStartStreamSession.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(22, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(OnSyncMoreResponse paramOnSyncMoreResponse)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if (paramOnSyncMoreResponse != null)
      {
        localParcel1.writeInt(1);
        paramOnSyncMoreResponse.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(9, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(StringListResponse paramStringListResponse)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if (paramStringListResponse != null)
      {
        localParcel1.writeInt(1);
        paramStringListResponse.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(21, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      int i = 0;
      if (paramBoolean)
        i = 1;
      localParcel1.writeInt(i);
      this.a.transact(15, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final IBinder asBinder()
  {
    return this.a;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.o
 * JD-Core Version:    0.6.0
 */