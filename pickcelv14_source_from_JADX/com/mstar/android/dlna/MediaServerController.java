package com.mstar.android.dlna;

import java.util.ArrayList;

public interface MediaServerController {
    void Authenticate(String str) throws ActionUnsupportedException, HostUnreachableException, AuthenticateFailedException;

    @Deprecated
    ArrayList<ShareObject> Browse(String str, String str2, int i, int i2, String str3) throws ActionUnsupportedException, HostUnreachableException, MissingAuthenticationException;

    BrowseResult Browse_Ex(String str, BrowseFlag browseFlag, String str2, int i, int i2, String str3) throws ActionUnsupportedException, HostUnreachableException, MissingAuthenticationException;

    ShareItem CreateObject(String str, String str2);

    DeviceInfo GetDeviceInfo() throws ActionUnsupportedException, HostUnreachableException;

    ArrayList<ProtocolInfo> GetProtocolInfo() throws ActionUnsupportedException, HostUnreachableException;

    int TransferFile(String str, String str2);
}
