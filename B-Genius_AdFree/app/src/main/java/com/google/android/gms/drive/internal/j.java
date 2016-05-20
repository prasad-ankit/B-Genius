package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.IInterface;
import com.google.android.gms.drive.RealtimeDocumentSyncRequest;

public abstract interface j extends IInterface
{
  public abstract IntentSender a(CreateFileIntentSenderRequest paramCreateFileIntentSenderRequest);

  public abstract IntentSender a(OpenFileIntentSenderRequest paramOpenFileIntentSenderRequest);

  public abstract DriveServiceResponse a(OpenContentsRequest paramOpenContentsRequest, m paramm);

  public abstract DriveServiceResponse a(StreamContentsRequest paramStreamContentsRequest, m paramm);

  public abstract void a(RealtimeDocumentSyncRequest paramRealtimeDocumentSyncRequest, m paramm);

  public abstract void a(AddEventListenerRequest paramAddEventListenerRequest, p paramp, String paramString, m paramm);

  public abstract void a(AddPermissionRequest paramAddPermissionRequest, m paramm);

  public abstract void a(AuthorizeAccessRequest paramAuthorizeAccessRequest, m paramm);

  public abstract void a(CancelPendingActionsRequest paramCancelPendingActionsRequest, m paramm);

  public abstract void a(ChangeResourceParentsRequest paramChangeResourceParentsRequest, m paramm);

  public abstract void a(CheckResourceIdsExistRequest paramCheckResourceIdsExistRequest, m paramm);

  public abstract void a(CloseContentsAndUpdateMetadataRequest paramCloseContentsAndUpdateMetadataRequest, m paramm);

  public abstract void a(CloseContentsRequest paramCloseContentsRequest, m paramm);

  public abstract void a(ControlProgressRequest paramControlProgressRequest, m paramm);

  public abstract void a(CreateContentsRequest paramCreateContentsRequest, m paramm);

  public abstract void a(CreateFileRequest paramCreateFileRequest, m paramm);

  public abstract void a(CreateFolderRequest paramCreateFolderRequest, m paramm);

  public abstract void a(DeleteResourceRequest paramDeleteResourceRequest, m paramm);

  public abstract void a(DisconnectRequest paramDisconnectRequest);

  public abstract void a(FetchThumbnailRequest paramFetchThumbnailRequest, m paramm);

  public abstract void a(GetChangesRequest paramGetChangesRequest, m paramm);

  public abstract void a(GetDriveIdFromUniqueIdentifierRequest paramGetDriveIdFromUniqueIdentifierRequest, m paramm);

  public abstract void a(GetMetadataRequest paramGetMetadataRequest, m paramm);

  public abstract void a(GetPermissionsRequest paramGetPermissionsRequest, m paramm);

  public abstract void a(ListParentsRequest paramListParentsRequest, m paramm);

  public abstract void a(LoadRealtimeRequest paramLoadRealtimeRequest, m paramm);

  public abstract void a(QueryRequest paramQueryRequest, m paramm);

  public abstract void a(QueryRequest paramQueryRequest, p paramp, m paramm);

  public abstract void a(RemoveEventListenerRequest paramRemoveEventListenerRequest, p paramp, String paramString, m paramm);

  public abstract void a(RemovePermissionRequest paramRemovePermissionRequest, m paramm);

  public abstract void a(SetFileUploadPreferencesRequest paramSetFileUploadPreferencesRequest, m paramm);

  public abstract void a(SetPinnedDownloadPreferencesRequest paramSetPinnedDownloadPreferencesRequest, m paramm);

  public abstract void a(SetResourceParentsRequest paramSetResourceParentsRequest, m paramm);

  public abstract void a(TrashResourceRequest paramTrashResourceRequest, m paramm);

  public abstract void a(UnsubscribeResourceRequest paramUnsubscribeResourceRequest, m paramm);

  public abstract void a(UntrashResourceRequest paramUntrashResourceRequest, m paramm);

  public abstract void a(UpdateMetadataRequest paramUpdateMetadataRequest, m paramm);

  public abstract void a(UpdatePermissionRequest paramUpdatePermissionRequest, m paramm);

  public abstract void a(m paramm);

  public abstract void a(p paramp, m paramm);

  public abstract void b(QueryRequest paramQueryRequest, m paramm);

  public abstract void b(m paramm);

  public abstract void c(m paramm);

  public abstract void d(m paramm);

  public abstract void e(m paramm);

  public abstract void f(m paramm);

  public abstract void g(m paramm);

  public abstract void h(m paramm);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.j
 * JD-Core Version:    0.6.0
 */