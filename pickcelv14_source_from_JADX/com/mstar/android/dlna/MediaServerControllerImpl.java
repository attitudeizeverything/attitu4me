package com.mstar.android.dlna;

import java.util.ArrayList;

/* compiled from: DLNAImpl */
class MediaServerControllerImpl implements MediaServerController {
    private int handle;

    private native synchronized ShareItem DMSCCreateObject(String str, String str2);

    private native synchronized int DMSCTransferFile(String str, String str2);

    private native synchronized void JNI_DMSC_Authenticate(String str);

    private native synchronized ArrayList<ShareObject> JNI_DMSC_Browse(String str, String str2, int i, int i2, String str3);

    private native synchronized BrowseResult JNI_DMSC_Browse_Ex(String str, BrowseFlag browseFlag, String str2, int i, int i2, String str3);

    private native synchronized DeviceInfo JNI_DMSC_GetDeviceInfo();

    private native synchronized ArrayList<ProtocolInfo> JNI_DMSC_GetProtocolInfo();

    MediaServerControllerImpl() {
    }

    public ArrayList<ProtocolInfo> GetProtocolInfo() {
        return JNI_DMSC_GetProtocolInfo();
    }

    public ArrayList<ShareObject> Browse(String id, String filter, int start_id, int requested_count, String sort_criteria) {
        return JNI_DMSC_Browse(id, filter, start_id, requested_count, sort_criteria);
    }

    public BrowseResult Browse_Ex(String id, BrowseFlag flag, String filter, int start_id, int requested_count, String sort_criteria) throws ActionUnsupportedException, HostUnreachableException, MissingAuthenticationException {
        return JNI_DMSC_Browse_Ex(id, flag, filter, start_id, requested_count, sort_criteria);
    }

    public ShareItem CreateObject(String container_id, String title) {
        return DMSCCreateObject(container_id, title);
    }

    public int TransferFile(String export_uri, String import_uri) {
        return DMSCTransferFile(export_uri, import_uri);
    }

    public DeviceInfo GetDeviceInfo() {
        return JNI_DMSC_GetDeviceInfo();
    }

    public void Authenticate(String pw) {
        JNI_DMSC_Authenticate(pw);
    }
}
