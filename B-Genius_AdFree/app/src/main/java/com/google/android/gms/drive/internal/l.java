package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.RealtimeDocumentSyncRequest;

final class l
  implements j
{
  private IBinder a;

  l(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }

  public final IntentSender a(CreateFileIntentSenderRequest paramCreateFileIntentSenderRequest)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramCreateFileIntentSenderRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramCreateFileIntentSenderRequest.writeToParcel(localParcel1, 0);
        this.a.transact(11, localParcel1, localParcel2, 0);
        localParcel2.readException();
        if (localParcel2.readInt() != 0)
        {
          localIntentSender = (IntentSender)IntentSender.CREATOR.createFromParcel(localParcel2);
          return localIntentSender;
          localParcel1.writeInt(0);
          continue;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      IntentSender localIntentSender = null;
    }
  }

  public final IntentSender a(OpenFileIntentSenderRequest paramOpenFileIntentSenderRequest)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramOpenFileIntentSenderRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramOpenFileIntentSenderRequest.writeToParcel(localParcel1, 0);
        this.a.transact(10, localParcel1, localParcel2, 0);
        localParcel2.readException();
        if (localParcel2.readInt() != 0)
        {
          localIntentSender = (IntentSender)IntentSender.CREATOR.createFromParcel(localParcel2);
          return localIntentSender;
          localParcel1.writeInt(0);
          continue;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      IntentSender localIntentSender = null;
    }
  }

  public final DriveServiceResponse a(OpenContentsRequest paramOpenContentsRequest, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramOpenContentsRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramOpenContentsRequest.writeToParcel(localParcel1, 0);
        if (paramm != null)
        {
          localIBinder = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          DriveServiceResponse localDriveServiceResponse = null;
          if (i == 0)
            continue;
          localDriveServiceResponse = (DriveServiceResponse)DriveServiceResponse.CREATOR.createFromParcel(localParcel2);
          return localDriveServiceResponse;
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

  public final DriveServiceResponse a(StreamContentsRequest paramStreamContentsRequest, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramStreamContentsRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramStreamContentsRequest.writeToParcel(localParcel1, 0);
        if (paramm != null)
        {
          localIBinder = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(56, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          DriveServiceResponse localDriveServiceResponse = null;
          if (i == 0)
            continue;
          localDriveServiceResponse = (DriveServiceResponse)DriveServiceResponse.CREATOR.createFromParcel(localParcel2);
          return localDriveServiceResponse;
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

  public final void a(RealtimeDocumentSyncRequest paramRealtimeDocumentSyncRequest, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramRealtimeDocumentSyncRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramRealtimeDocumentSyncRequest.writeToParcel(localParcel1, 0);
        if (paramm != null)
        {
          localIBinder = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(34, localParcel1, localParcel2, 0);
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

  public final void a(AddEventListenerRequest paramAddEventListenerRequest, p paramp, String paramString, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramAddEventListenerRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramAddEventListenerRequest.writeToParcel(localParcel1, 0);
        if (paramp != null)
        {
          localIBinder1 = paramp.asBinder();
          localParcel1.writeStrongBinder(localIBinder1);
          localParcel1.writeString(paramString);
          IBinder localIBinder2 = null;
          if (paramm == null)
            continue;
          localIBinder2 = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder2);
          this.a.transact(14, localParcel1, localParcel2, 0);
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
      IBinder localIBinder1 = null;
    }
  }

  public final void a(AddPermissionRequest paramAddPermissionRequest, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramAddPermissionRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramAddPermissionRequest.writeToParcel(localParcel1, 0);
        if (paramm != null)
        {
          localIBinder = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(48, localParcel1, localParcel2, 0);
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

  public final void a(AuthorizeAccessRequest paramAuthorizeAccessRequest, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramAuthorizeAccessRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramAuthorizeAccessRequest.writeToParcel(localParcel1, 0);
        if (paramm != null)
        {
          localIBinder = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(12, localParcel1, localParcel2, 0);
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

  public final void a(CancelPendingActionsRequest paramCancelPendingActionsRequest, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramCancelPendingActionsRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramCancelPendingActionsRequest.writeToParcel(localParcel1, 0);
        if (paramm != null)
        {
          localIBinder = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(37, localParcel1, localParcel2, 0);
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

  public final void a(ChangeResourceParentsRequest paramChangeResourceParentsRequest, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramChangeResourceParentsRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramChangeResourceParentsRequest.writeToParcel(localParcel1, 0);
        if (paramm != null)
        {
          localIBinder = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(55, localParcel1, localParcel2, 0);
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

  public final void a(CheckResourceIdsExistRequest paramCheckResourceIdsExistRequest, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramCheckResourceIdsExistRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramCheckResourceIdsExistRequest.writeToParcel(localParcel1, 0);
        if (paramm != null)
        {
          localIBinder = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(30, localParcel1, localParcel2, 0);
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

  public final void a(CloseContentsAndUpdateMetadataRequest paramCloseContentsAndUpdateMetadataRequest, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramCloseContentsAndUpdateMetadataRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramCloseContentsAndUpdateMetadataRequest.writeToParcel(localParcel1, 0);
        if (paramm != null)
        {
          localIBinder = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(18, localParcel1, localParcel2, 0);
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

  public final void a(CloseContentsRequest paramCloseContentsRequest, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramCloseContentsRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramCloseContentsRequest.writeToParcel(localParcel1, 0);
        if (paramm != null)
        {
          localIBinder = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(8, localParcel1, localParcel2, 0);
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

  public final void a(ControlProgressRequest paramControlProgressRequest, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramControlProgressRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramControlProgressRequest.writeToParcel(localParcel1, 0);
        if (paramm != null)
        {
          localIBinder = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(53, localParcel1, localParcel2, 0);
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

  public final void a(CreateContentsRequest paramCreateContentsRequest, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramCreateContentsRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramCreateContentsRequest.writeToParcel(localParcel1, 0);
        if (paramm != null)
        {
          localIBinder = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(4, localParcel1, localParcel2, 0);
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

  public final void a(CreateFileRequest paramCreateFileRequest, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramCreateFileRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramCreateFileRequest.writeToParcel(localParcel1, 0);
        if (paramm != null)
        {
          localIBinder = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(5, localParcel1, localParcel2, 0);
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

  public final void a(CreateFolderRequest paramCreateFolderRequest, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramCreateFolderRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramCreateFolderRequest.writeToParcel(localParcel1, 0);
        if (paramm != null)
        {
          localIBinder = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(6, localParcel1, localParcel2, 0);
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

  public final void a(DeleteResourceRequest paramDeleteResourceRequest, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramDeleteResourceRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramDeleteResourceRequest.writeToParcel(localParcel1, 0);
        if (paramm != null)
        {
          localIBinder = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(24, localParcel1, localParcel2, 0);
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

  public final void a(DisconnectRequest paramDisconnectRequest)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
      if (paramDisconnectRequest != null)
      {
        localParcel1.writeInt(1);
        paramDisconnectRequest.writeToParcel(localParcel1, 0);
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

  public final void a(FetchThumbnailRequest paramFetchThumbnailRequest, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramFetchThumbnailRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramFetchThumbnailRequest.writeToParcel(localParcel1, 0);
        if (paramm != null)
        {
          localIBinder = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(42, localParcel1, localParcel2, 0);
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

  public final void a(GetChangesRequest paramGetChangesRequest, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramGetChangesRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramGetChangesRequest.writeToParcel(localParcel1, 0);
        if (paramm != null)
        {
          localIBinder = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(44, localParcel1, localParcel2, 0);
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

  public final void a(GetDriveIdFromUniqueIdentifierRequest paramGetDriveIdFromUniqueIdentifierRequest, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramGetDriveIdFromUniqueIdentifierRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramGetDriveIdFromUniqueIdentifierRequest.writeToParcel(localParcel1, 0);
        if (paramm != null)
        {
          localIBinder = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(29, localParcel1, localParcel2, 0);
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

  public final void a(GetMetadataRequest paramGetMetadataRequest, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramGetMetadataRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramGetMetadataRequest.writeToParcel(localParcel1, 0);
        if (paramm != null)
        {
          localIBinder = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(1, localParcel1, localParcel2, 0);
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

  public final void a(GetPermissionsRequest paramGetPermissionsRequest, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramGetPermissionsRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramGetPermissionsRequest.writeToParcel(localParcel1, 0);
        if (paramm != null)
        {
          localIBinder = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(47, localParcel1, localParcel2, 0);
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

  public final void a(ListParentsRequest paramListParentsRequest, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramListParentsRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramListParentsRequest.writeToParcel(localParcel1, 0);
        if (paramm != null)
        {
          localIBinder = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(13, localParcel1, localParcel2, 0);
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

  public final void a(LoadRealtimeRequest paramLoadRealtimeRequest, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramLoadRealtimeRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramLoadRealtimeRequest.writeToParcel(localParcel1, 0);
        if (paramm != null)
        {
          localIBinder = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(27, localParcel1, localParcel2, 0);
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

  public final void a(QueryRequest paramQueryRequest, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramQueryRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramQueryRequest.writeToParcel(localParcel1, 0);
        if (paramm != null)
        {
          localIBinder = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(2, localParcel1, localParcel2, 0);
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

  public final void a(QueryRequest paramQueryRequest, p paramp, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramQueryRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramQueryRequest.writeToParcel(localParcel1, 0);
        if (paramp != null)
        {
          localIBinder1 = paramp.asBinder();
          localParcel1.writeStrongBinder(localIBinder1);
          IBinder localIBinder2 = null;
          if (paramm == null)
            continue;
          localIBinder2 = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder2);
          this.a.transact(51, localParcel1, localParcel2, 0);
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
      IBinder localIBinder1 = null;
    }
  }

  public final void a(RemoveEventListenerRequest paramRemoveEventListenerRequest, p paramp, String paramString, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramRemoveEventListenerRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramRemoveEventListenerRequest.writeToParcel(localParcel1, 0);
        if (paramp != null)
        {
          localIBinder1 = paramp.asBinder();
          localParcel1.writeStrongBinder(localIBinder1);
          localParcel1.writeString(paramString);
          IBinder localIBinder2 = null;
          if (paramm == null)
            continue;
          localIBinder2 = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder2);
          this.a.transact(15, localParcel1, localParcel2, 0);
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
      IBinder localIBinder1 = null;
    }
  }

  public final void a(RemovePermissionRequest paramRemovePermissionRequest, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramRemovePermissionRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramRemovePermissionRequest.writeToParcel(localParcel1, 0);
        if (paramm != null)
        {
          localIBinder = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(50, localParcel1, localParcel2, 0);
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

  public final void a(SetFileUploadPreferencesRequest paramSetFileUploadPreferencesRequest, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramSetFileUploadPreferencesRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramSetFileUploadPreferencesRequest.writeToParcel(localParcel1, 0);
        if (paramm != null)
        {
          localIBinder = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(36, localParcel1, localParcel2, 0);
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

  public final void a(SetPinnedDownloadPreferencesRequest paramSetPinnedDownloadPreferencesRequest, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramSetPinnedDownloadPreferencesRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramSetPinnedDownloadPreferencesRequest.writeToParcel(localParcel1, 0);
        if (paramm != null)
        {
          localIBinder = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(33, localParcel1, localParcel2, 0);
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

  public final void a(SetResourceParentsRequest paramSetResourceParentsRequest, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramSetResourceParentsRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramSetResourceParentsRequest.writeToParcel(localParcel1, 0);
        if (paramm != null)
        {
          localIBinder = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(28, localParcel1, localParcel2, 0);
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

  public final void a(TrashResourceRequest paramTrashResourceRequest, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramTrashResourceRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramTrashResourceRequest.writeToParcel(localParcel1, 0);
        if (paramm != null)
        {
          localIBinder = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(17, localParcel1, localParcel2, 0);
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

  public final void a(UnsubscribeResourceRequest paramUnsubscribeResourceRequest, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramUnsubscribeResourceRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramUnsubscribeResourceRequest.writeToParcel(localParcel1, 0);
        if (paramm != null)
        {
          localIBinder = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(46, localParcel1, localParcel2, 0);
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

  public final void a(UntrashResourceRequest paramUntrashResourceRequest, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramUntrashResourceRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramUntrashResourceRequest.writeToParcel(localParcel1, 0);
        if (paramm != null)
        {
          localIBinder = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(38, localParcel1, localParcel2, 0);
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

  public final void a(UpdateMetadataRequest paramUpdateMetadataRequest, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramUpdateMetadataRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramUpdateMetadataRequest.writeToParcel(localParcel1, 0);
        if (paramm != null)
        {
          localIBinder = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(3, localParcel1, localParcel2, 0);
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

  public final void a(UpdatePermissionRequest paramUpdatePermissionRequest, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramUpdatePermissionRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramUpdatePermissionRequest.writeToParcel(localParcel1, 0);
        if (paramm != null)
        {
          localIBinder = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(49, localParcel1, localParcel2, 0);
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

  public final void a(m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
      if (paramm != null);
      for (IBinder localIBinder = paramm.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        this.a.transact(9, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(p paramp, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
      if (paramp != null);
      for (IBinder localIBinder1 = paramp.asBinder(); ; localIBinder1 = null)
      {
        localParcel1.writeStrongBinder(localIBinder1);
        IBinder localIBinder2 = null;
        if (paramm != null)
          localIBinder2 = paramm.asBinder();
        localParcel1.writeStrongBinder(localIBinder2);
        this.a.transact(52, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
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

  public final void b(QueryRequest paramQueryRequest, m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramQueryRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramQueryRequest.writeToParcel(localParcel1, 0);
        if (paramm != null)
        {
          localIBinder = paramm.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(19, localParcel1, localParcel2, 0);
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

  public final void b(m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
      if (paramm != null);
      for (IBinder localIBinder = paramm.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        this.a.transact(31, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void c(m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
      if (paramm != null);
      for (IBinder localIBinder = paramm.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        this.a.transact(32, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void d(m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
      if (paramm != null);
      for (IBinder localIBinder = paramm.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        this.a.transact(35, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void e(m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
      if (paramm != null);
      for (IBinder localIBinder = paramm.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        this.a.transact(41, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void f(m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
      if (paramm != null);
      for (IBinder localIBinder = paramm.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        this.a.transact(43, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void g(m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
      if (paramm != null);
      for (IBinder localIBinder = paramm.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        this.a.transact(54, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void h(m paramm)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
      if (paramm != null);
      for (IBinder localIBinder = paramm.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        this.a.transact(57, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.l
 * JD-Core Version:    0.6.0
 */