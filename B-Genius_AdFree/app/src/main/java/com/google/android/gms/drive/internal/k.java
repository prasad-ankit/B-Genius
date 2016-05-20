package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.RealtimeDocumentSyncRequest;

public abstract class k extends Binder
  implements j
{
  public static j a(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveService");
    if ((localIInterface != null) && ((localIInterface instanceof j)))
      return (j)localIInterface;
    return new l(paramIBinder);
  }

  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default:
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902:
      paramParcel2.writeString("com.google.android.gms.drive.internal.IDriveService");
      return true;
    case 1:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i34 = paramParcel1.readInt();
      GetMetadataRequest localGetMetadataRequest = null;
      if (i34 != 0)
        localGetMetadataRequest = (GetMetadataRequest)GetMetadataRequest.CREATOR.createFromParcel(paramParcel1);
      a(localGetMetadataRequest, n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 2:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i33 = paramParcel1.readInt();
      QueryRequest localQueryRequest3 = null;
      if (i33 != 0)
        localQueryRequest3 = (QueryRequest)QueryRequest.CREATOR.createFromParcel(paramParcel1);
      a(localQueryRequest3, n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 3:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i32 = paramParcel1.readInt();
      UpdateMetadataRequest localUpdateMetadataRequest = null;
      if (i32 != 0)
        localUpdateMetadataRequest = (UpdateMetadataRequest)UpdateMetadataRequest.CREATOR.createFromParcel(paramParcel1);
      a(localUpdateMetadataRequest, n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 4:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i31 = paramParcel1.readInt();
      CreateContentsRequest localCreateContentsRequest = null;
      if (i31 != 0)
        localCreateContentsRequest = (CreateContentsRequest)CreateContentsRequest.CREATOR.createFromParcel(paramParcel1);
      a(localCreateContentsRequest, n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 5:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i30 = paramParcel1.readInt();
      CreateFileRequest localCreateFileRequest = null;
      if (i30 != 0)
        localCreateFileRequest = (CreateFileRequest)CreateFileRequest.CREATOR.createFromParcel(paramParcel1);
      a(localCreateFileRequest, n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 6:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i29 = paramParcel1.readInt();
      CreateFolderRequest localCreateFolderRequest = null;
      if (i29 != 0)
        localCreateFolderRequest = (CreateFolderRequest)CreateFolderRequest.CREATOR.createFromParcel(paramParcel1);
      a(localCreateFolderRequest, n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 7:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i28 = paramParcel1.readInt();
      OpenContentsRequest localOpenContentsRequest = null;
      if (i28 != 0)
        localOpenContentsRequest = (OpenContentsRequest)OpenContentsRequest.CREATOR.createFromParcel(paramParcel1);
      DriveServiceResponse localDriveServiceResponse2 = a(localOpenContentsRequest, n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      if (localDriveServiceResponse2 != null)
      {
        paramParcel2.writeInt(1);
        localDriveServiceResponse2.writeToParcel(paramParcel2, 1);
      }
      while (true)
      {
        return true;
        paramParcel2.writeInt(0);
      }
    case 8:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i27 = paramParcel1.readInt();
      CloseContentsRequest localCloseContentsRequest = null;
      if (i27 != 0)
        localCloseContentsRequest = (CloseContentsRequest)CloseContentsRequest.CREATOR.createFromParcel(paramParcel1);
      a(localCloseContentsRequest, n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 9:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      a(n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 10:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i26 = paramParcel1.readInt();
      OpenFileIntentSenderRequest localOpenFileIntentSenderRequest = null;
      if (i26 != 0)
        localOpenFileIntentSenderRequest = (OpenFileIntentSenderRequest)OpenFileIntentSenderRequest.CREATOR.createFromParcel(paramParcel1);
      IntentSender localIntentSender2 = a(localOpenFileIntentSenderRequest);
      paramParcel2.writeNoException();
      if (localIntentSender2 != null)
      {
        paramParcel2.writeInt(1);
        localIntentSender2.writeToParcel(paramParcel2, 1);
      }
      while (true)
      {
        return true;
        paramParcel2.writeInt(0);
      }
    case 11:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i25 = paramParcel1.readInt();
      CreateFileIntentSenderRequest localCreateFileIntentSenderRequest = null;
      if (i25 != 0)
        localCreateFileIntentSenderRequest = (CreateFileIntentSenderRequest)CreateFileIntentSenderRequest.CREATOR.createFromParcel(paramParcel1);
      IntentSender localIntentSender1 = a(localCreateFileIntentSenderRequest);
      paramParcel2.writeNoException();
      if (localIntentSender1 != null)
      {
        paramParcel2.writeInt(1);
        localIntentSender1.writeToParcel(paramParcel2, 1);
      }
      while (true)
      {
        return true;
        paramParcel2.writeInt(0);
      }
    case 12:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i24 = paramParcel1.readInt();
      AuthorizeAccessRequest localAuthorizeAccessRequest = null;
      if (i24 != 0)
        localAuthorizeAccessRequest = (AuthorizeAccessRequest)AuthorizeAccessRequest.CREATOR.createFromParcel(paramParcel1);
      a(localAuthorizeAccessRequest, n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 13:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i23 = paramParcel1.readInt();
      ListParentsRequest localListParentsRequest = null;
      if (i23 != 0)
        localListParentsRequest = (ListParentsRequest)ListParentsRequest.CREATOR.createFromParcel(paramParcel1);
      a(localListParentsRequest, n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 14:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i22 = paramParcel1.readInt();
      AddEventListenerRequest localAddEventListenerRequest = null;
      if (i22 != 0)
        localAddEventListenerRequest = (AddEventListenerRequest)AddEventListenerRequest.CREATOR.createFromParcel(paramParcel1);
      a(localAddEventListenerRequest, q.a(paramParcel1.readStrongBinder()), paramParcel1.readString(), n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 15:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i21 = paramParcel1.readInt();
      RemoveEventListenerRequest localRemoveEventListenerRequest = null;
      if (i21 != 0)
        localRemoveEventListenerRequest = (RemoveEventListenerRequest)RemoveEventListenerRequest.CREATOR.createFromParcel(paramParcel1);
      a(localRemoveEventListenerRequest, q.a(paramParcel1.readStrongBinder()), paramParcel1.readString(), n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 16:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i20 = paramParcel1.readInt();
      DisconnectRequest localDisconnectRequest = null;
      if (i20 != 0)
        localDisconnectRequest = (DisconnectRequest)DisconnectRequest.CREATOR.createFromParcel(paramParcel1);
      a(localDisconnectRequest);
      paramParcel2.writeNoException();
      return true;
    case 17:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i19 = paramParcel1.readInt();
      TrashResourceRequest localTrashResourceRequest = null;
      if (i19 != 0)
        localTrashResourceRequest = (TrashResourceRequest)TrashResourceRequest.CREATOR.createFromParcel(paramParcel1);
      a(localTrashResourceRequest, n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 18:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i18 = paramParcel1.readInt();
      CloseContentsAndUpdateMetadataRequest localCloseContentsAndUpdateMetadataRequest = null;
      if (i18 != 0)
        localCloseContentsAndUpdateMetadataRequest = (CloseContentsAndUpdateMetadataRequest)CloseContentsAndUpdateMetadataRequest.CREATOR.createFromParcel(paramParcel1);
      a(localCloseContentsAndUpdateMetadataRequest, n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 19:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i17 = paramParcel1.readInt();
      QueryRequest localQueryRequest2 = null;
      if (i17 != 0)
        localQueryRequest2 = (QueryRequest)QueryRequest.CREATOR.createFromParcel(paramParcel1);
      b(localQueryRequest2, n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 24:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i16 = paramParcel1.readInt();
      DeleteResourceRequest localDeleteResourceRequest = null;
      if (i16 != 0)
        localDeleteResourceRequest = (DeleteResourceRequest)DeleteResourceRequest.CREATOR.createFromParcel(paramParcel1);
      a(localDeleteResourceRequest, n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 27:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i15 = paramParcel1.readInt();
      LoadRealtimeRequest localLoadRealtimeRequest = null;
      if (i15 != 0)
        localLoadRealtimeRequest = (LoadRealtimeRequest)LoadRealtimeRequest.CREATOR.createFromParcel(paramParcel1);
      a(localLoadRealtimeRequest, n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 28:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i14 = paramParcel1.readInt();
      SetResourceParentsRequest localSetResourceParentsRequest = null;
      if (i14 != 0)
        localSetResourceParentsRequest = (SetResourceParentsRequest)SetResourceParentsRequest.CREATOR.createFromParcel(paramParcel1);
      a(localSetResourceParentsRequest, n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 29:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i13 = paramParcel1.readInt();
      GetDriveIdFromUniqueIdentifierRequest localGetDriveIdFromUniqueIdentifierRequest = null;
      if (i13 != 0)
        localGetDriveIdFromUniqueIdentifierRequest = (GetDriveIdFromUniqueIdentifierRequest)GetDriveIdFromUniqueIdentifierRequest.CREATOR.createFromParcel(paramParcel1);
      a(localGetDriveIdFromUniqueIdentifierRequest, n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 30:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i12 = paramParcel1.readInt();
      CheckResourceIdsExistRequest localCheckResourceIdsExistRequest = null;
      if (i12 != 0)
        localCheckResourceIdsExistRequest = (CheckResourceIdsExistRequest)CheckResourceIdsExistRequest.CREATOR.createFromParcel(paramParcel1);
      a(localCheckResourceIdsExistRequest, n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 31:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      b(n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 32:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      c(n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 33:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i11 = paramParcel1.readInt();
      SetPinnedDownloadPreferencesRequest localSetPinnedDownloadPreferencesRequest = null;
      if (i11 != 0)
        localSetPinnedDownloadPreferencesRequest = (SetPinnedDownloadPreferencesRequest)SetPinnedDownloadPreferencesRequest.CREATOR.createFromParcel(paramParcel1);
      a(localSetPinnedDownloadPreferencesRequest, n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 34:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i10 = paramParcel1.readInt();
      RealtimeDocumentSyncRequest localRealtimeDocumentSyncRequest = null;
      if (i10 != 0)
        localRealtimeDocumentSyncRequest = (RealtimeDocumentSyncRequest)RealtimeDocumentSyncRequest.CREATOR.createFromParcel(paramParcel1);
      a(localRealtimeDocumentSyncRequest, n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 35:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      d(n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 36:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i9 = paramParcel1.readInt();
      SetFileUploadPreferencesRequest localSetFileUploadPreferencesRequest = null;
      if (i9 != 0)
        localSetFileUploadPreferencesRequest = (SetFileUploadPreferencesRequest)SetFileUploadPreferencesRequest.CREATOR.createFromParcel(paramParcel1);
      a(localSetFileUploadPreferencesRequest, n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 37:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i8 = paramParcel1.readInt();
      CancelPendingActionsRequest localCancelPendingActionsRequest = null;
      if (i8 != 0)
        localCancelPendingActionsRequest = (CancelPendingActionsRequest)CancelPendingActionsRequest.CREATOR.createFromParcel(paramParcel1);
      a(localCancelPendingActionsRequest, n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 38:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i7 = paramParcel1.readInt();
      UntrashResourceRequest localUntrashResourceRequest = null;
      if (i7 != 0)
        localUntrashResourceRequest = (UntrashResourceRequest)UntrashResourceRequest.CREATOR.createFromParcel(paramParcel1);
      a(localUntrashResourceRequest, n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 41:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      e(n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 42:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i6 = paramParcel1.readInt();
      FetchThumbnailRequest localFetchThumbnailRequest = null;
      if (i6 != 0)
        localFetchThumbnailRequest = (FetchThumbnailRequest)FetchThumbnailRequest.CREATOR.createFromParcel(paramParcel1);
      a(localFetchThumbnailRequest, n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 43:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      f(n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 44:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i5 = paramParcel1.readInt();
      GetChangesRequest localGetChangesRequest = null;
      if (i5 != 0)
        localGetChangesRequest = (GetChangesRequest)GetChangesRequest.CREATOR.createFromParcel(paramParcel1);
      a(localGetChangesRequest, n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 46:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i4 = paramParcel1.readInt();
      UnsubscribeResourceRequest localUnsubscribeResourceRequest = null;
      if (i4 != 0)
        localUnsubscribeResourceRequest = (UnsubscribeResourceRequest)UnsubscribeResourceRequest.CREATOR.createFromParcel(paramParcel1);
      a(localUnsubscribeResourceRequest, n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 47:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i3 = paramParcel1.readInt();
      GetPermissionsRequest localGetPermissionsRequest = null;
      if (i3 != 0)
        localGetPermissionsRequest = (GetPermissionsRequest)GetPermissionsRequest.CREATOR.createFromParcel(paramParcel1);
      a(localGetPermissionsRequest, n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 48:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i2 = paramParcel1.readInt();
      AddPermissionRequest localAddPermissionRequest = null;
      if (i2 != 0)
        localAddPermissionRequest = (AddPermissionRequest)AddPermissionRequest.CREATOR.createFromParcel(paramParcel1);
      a(localAddPermissionRequest, n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 49:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i1 = paramParcel1.readInt();
      UpdatePermissionRequest localUpdatePermissionRequest = null;
      if (i1 != 0)
        localUpdatePermissionRequest = (UpdatePermissionRequest)UpdatePermissionRequest.CREATOR.createFromParcel(paramParcel1);
      a(localUpdatePermissionRequest, n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 50:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int n = paramParcel1.readInt();
      RemovePermissionRequest localRemovePermissionRequest = null;
      if (n != 0)
        localRemovePermissionRequest = (RemovePermissionRequest)RemovePermissionRequest.CREATOR.createFromParcel(paramParcel1);
      a(localRemovePermissionRequest, n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 51:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int m = paramParcel1.readInt();
      QueryRequest localQueryRequest1 = null;
      if (m != 0)
        localQueryRequest1 = (QueryRequest)QueryRequest.CREATOR.createFromParcel(paramParcel1);
      a(localQueryRequest1, q.a(paramParcel1.readStrongBinder()), n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 52:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      a(q.a(paramParcel1.readStrongBinder()), n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 53:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int k = paramParcel1.readInt();
      ControlProgressRequest localControlProgressRequest = null;
      if (k != 0)
        localControlProgressRequest = (ControlProgressRequest)ControlProgressRequest.CREATOR.createFromParcel(paramParcel1);
      a(localControlProgressRequest, n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 54:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      g(n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 55:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int j = paramParcel1.readInt();
      ChangeResourceParentsRequest localChangeResourceParentsRequest = null;
      if (j != 0)
        localChangeResourceParentsRequest = (ChangeResourceParentsRequest)ChangeResourceParentsRequest.CREATOR.createFromParcel(paramParcel1);
      a(localChangeResourceParentsRequest, n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 56:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i = paramParcel1.readInt();
      StreamContentsRequest localStreamContentsRequest = null;
      if (i != 0)
        localStreamContentsRequest = (StreamContentsRequest)StreamContentsRequest.CREATOR.createFromParcel(paramParcel1);
      DriveServiceResponse localDriveServiceResponse1 = a(localStreamContentsRequest, n.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      if (localDriveServiceResponse1 != null)
      {
        paramParcel2.writeInt(1);
        localDriveServiceResponse1.writeToParcel(paramParcel2, 1);
      }
      while (true)
      {
        return true;
        paramParcel2.writeInt(0);
      }
    case 57:
    }
    paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
    h(n.a(paramParcel1.readStrongBinder()));
    paramParcel2.writeNoException();
    return true;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.k
 * JD-Core Version:    0.6.0
 */