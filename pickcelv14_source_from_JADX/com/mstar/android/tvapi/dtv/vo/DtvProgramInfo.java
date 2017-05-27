package com.mstar.android.tvapi.dtv.vo;

import com.mstar.android.tvapi.common.vo.DtvTripleId;
import java.util.ArrayList;

public class DtvProgramInfo {
    private short antennaType;
    private int audioPid;
    private short favorite;
    private int frequency;
    private boolean isDelete;
    private boolean isHide;
    private boolean isLock;
    private boolean isOpService;
    private boolean isRename;
    private boolean isScramble;
    private boolean isSelectable;
    private boolean isSelectableOp;
    private boolean isSkip;
    private boolean isSpecialSrv;
    private boolean isVisible;
    private boolean isVisibleOp;
    private int majorNumber;
    private int minorNumber;
    private int number;
    private short nvodRealSrvNumber;
    private ArrayList<DtvTripleId> nvodRealSrvs;
    private int originalNetworkId;
    private int pcrPid;
    private int pmtPid;
    private String providerNameOp;
    private int screenMuteStatus;
    private int serviceId;
    private String serviceName;
    private String serviceNameOp;
    private short serviceType;
    private int transportStreamId;
    private int videoPid;

    public DtvProgramInfo(int number, short favorite, boolean isVisible, boolean isLock, boolean isSkip, boolean isSelectable, boolean isScramble, boolean isDelete, boolean isHide, boolean isRename, boolean isSpecialSrv, int frequency, int transportStreamId, int serviceId, short serviceType, String serviceName, int screenMuteStatus, int pcrPid, int videoPid, int audioPid, int pmtPid, int majorNumber, int minorNumber, short antennaType, int originalNetworkId, short nvodRealSrvNumber, ArrayList<DtvTripleId> nvodRealSrvs, boolean isVisibleOp, boolean isSelectableOp, boolean isOpService, String serviceNameOp, String providerNameOp) {
        this.number = number;
        this.favorite = favorite;
        this.isVisible = isVisible;
        this.isLock = isLock;
        this.isSkip = isSkip;
        this.isSelectable = isSelectable;
        this.isScramble = isScramble;
        this.isDelete = isDelete;
        this.isHide = isHide;
        this.isRename = isRename;
        this.isSpecialSrv = isSpecialSrv;
        this.frequency = frequency;
        this.transportStreamId = transportStreamId;
        this.serviceId = serviceId;
        this.serviceType = serviceType;
        this.serviceName = serviceName;
        this.screenMuteStatus = screenMuteStatus;
        this.pcrPid = pcrPid;
        this.videoPid = videoPid;
        this.audioPid = audioPid;
        this.pmtPid = pmtPid;
        this.majorNumber = majorNumber;
        this.minorNumber = minorNumber;
        this.antennaType = antennaType;
        this.originalNetworkId = originalNetworkId;
        this.nvodRealSrvNumber = nvodRealSrvNumber;
        this.nvodRealSrvs = nvodRealSrvs;
        this.isVisibleOp = isVisibleOp;
        this.isSelectableOp = isSelectableOp;
        this.isOpService = isOpService;
        this.serviceNameOp = serviceNameOp;
        this.providerNameOp = providerNameOp;
    }

    public DtvProgramInfo() {
        this.number = 0;
        this.favorite = (short) 0;
        this.isVisible = false;
        this.isLock = false;
        this.isSkip = false;
        this.isSelectable = false;
        this.isScramble = false;
        this.isDelete = false;
        this.isHide = false;
        this.isRename = false;
        this.isSpecialSrv = false;
        this.frequency = 0;
        this.transportStreamId = 0;
        this.serviceId = 0;
        this.serviceType = (short) 0;
        this.serviceName = "";
        this.screenMuteStatus = 0;
        this.pcrPid = 0;
        this.videoPid = 0;
        this.audioPid = 0;
        this.pmtPid = 0;
        this.majorNumber = 0;
        this.minorNumber = 0;
        this.antennaType = (short) 0;
        this.originalNetworkId = 0;
        this.nvodRealSrvNumber = (short) 0;
        this.nvodRealSrvs = new ArrayList();
        this.isVisibleOp = false;
        this.isSelectableOp = false;
        this.isOpService = false;
        this.serviceNameOp = "";
        this.providerNameOp = "";
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public short getFavorite() {
        return this.favorite;
    }

    public void setFavorite(short favorite) {
        this.favorite = favorite;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public boolean isLock() {
        return this.isLock;
    }

    public void setLock(boolean isLock) {
        this.isLock = isLock;
    }

    public boolean isSkip() {
        return this.isSkip;
    }

    public void setSkip(boolean isSkip) {
        this.isSkip = isSkip;
    }

    public boolean isSelectable() {
        return this.isSelectable;
    }

    public void setSelectable(boolean isSelectable) {
        this.isSelectable = isSelectable;
    }

    public boolean isScramble() {
        return this.isScramble;
    }

    public void setScramble(boolean isScramble) {
        this.isScramble = isScramble;
    }

    public boolean isDelete() {
        return this.isDelete;
    }

    public void setDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public boolean isHide() {
        return this.isHide;
    }

    public void setHide(boolean isHide) {
        this.isHide = isHide;
    }

    public boolean isRename() {
        return this.isRename;
    }

    public void setRename(boolean isRename) {
        this.isRename = isRename;
    }

    public boolean isSpecialSrv() {
        return this.isSpecialSrv;
    }

    public void setSpecialSrv(boolean isSpecialSrv) {
        this.isSpecialSrv = isSpecialSrv;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getTransportStreamId() {
        return this.transportStreamId;
    }

    public void setTransportStreamId(int transportStreamId) {
        this.transportStreamId = transportStreamId;
    }

    public int getServiceId() {
        return this.serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public short getServiceType() {
        return this.serviceType;
    }

    public void setServiceType(short serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getScreenMuteStatus() {
        return this.screenMuteStatus;
    }

    public void setScreenMuteStatus(int screenMuteStatus) {
        this.screenMuteStatus = screenMuteStatus;
    }

    public int getPcrPid() {
        return this.pcrPid;
    }

    public void setPcrPid(int pcrPid) {
        this.pcrPid = pcrPid;
    }

    public int getVideoPid() {
        return this.videoPid;
    }

    public void setVideoPid(int videoPid) {
        this.videoPid = videoPid;
    }

    public int getAudioPid() {
        return this.audioPid;
    }

    public void setAudioPid(int audioPid) {
        this.audioPid = audioPid;
    }

    public int getPmtPid() {
        return this.pmtPid;
    }

    public void setPmtPid(int pmtPid) {
        this.pmtPid = pmtPid;
    }

    public int getMajorNumber() {
        return this.majorNumber;
    }

    public void setMajorNumber(int majorNumber) {
        this.majorNumber = majorNumber;
    }

    public int getMinorNumber() {
        return this.minorNumber;
    }

    public void setMinorNumber(int minorNumber) {
        this.minorNumber = minorNumber;
    }

    public short getAntennaType() {
        return this.antennaType;
    }

    public void setAntennaType(short antennaType) {
        this.antennaType = antennaType;
    }

    public int getOriginalNetworkId() {
        return this.originalNetworkId;
    }

    public void setOriginalNetworkId(int originalNetworkId) {
        this.originalNetworkId = originalNetworkId;
    }

    public short getNvodRealSrvNumber() {
        return this.nvodRealSrvNumber;
    }

    public void setNvodRealSrvNumber(short nvodRealSrvNumber) {
        this.nvodRealSrvNumber = nvodRealSrvNumber;
    }

    public ArrayList<DtvTripleId> getNvodRealSrvs() {
        return this.nvodRealSrvs;
    }

    public void setNvodRealSrvs(ArrayList<DtvTripleId> nvodRealSrvs) {
        this.nvodRealSrvs = nvodRealSrvs;
    }

    public boolean isVisibleOp() {
        return this.isVisibleOp;
    }

    public void setVisibleOp(boolean isVisibleOp) {
        this.isVisibleOp = isVisibleOp;
    }

    public boolean isSelectableOp() {
        return this.isSelectableOp;
    }

    public void setSelectableOp(boolean isSelectableOp) {
        this.isSelectableOp = isSelectableOp;
    }

    public boolean isOpService() {
        return this.isOpService;
    }

    public void setOpService(boolean isOpService) {
        this.isOpService = isOpService;
    }

    public String getServiceNameOp() {
        return this.serviceNameOp;
    }

    public void setServiceNameOp(String serviceNameOp) {
        this.serviceNameOp = serviceNameOp;
    }

    public String getProviderNameOp() {
        return this.providerNameOp;
    }

    public void setProviderNameOp(String providerNameOp) {
        this.providerNameOp = providerNameOp;
    }
}
