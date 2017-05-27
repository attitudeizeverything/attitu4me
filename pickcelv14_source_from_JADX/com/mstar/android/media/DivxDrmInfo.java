package com.mstar.android.media;

import android.media.Metadata;

public class DivxDrmInfo {
    private int mU16CheckSum;
    private int mU32DrmRentalCode;
    private int mU32DrmRentalFile;
    private int mU32DrmRentalLimit;
    private int mU32DrmRentalUseCount;
    private int mU8DrmAuthorization;
    private int mU8DrmFileFormat;
    private int mU8DrmRentalStatus;

    public DivxDrmInfo(Metadata metadata) {
        System.out.println("JAVA, Enter DivxDrmInfo constructure");
        if (metadata.has(46)) {
            this.mU32DrmRentalCode = metadata.getInt(46);
        } else {
            this.mU32DrmRentalCode = -1;
        }
        System.out.println("mU32DrmRentalCode : " + this.mU32DrmRentalCode);
        if (metadata.has(47)) {
            this.mU32DrmRentalFile = metadata.getInt(47);
        } else {
            this.mU32DrmRentalFile = -1;
        }
        System.out.println("mU32DrmRentalFile : " + this.mU32DrmRentalFile);
        if (metadata.has(48)) {
            this.mU32DrmRentalLimit = metadata.getInt(48);
        } else {
            this.mU32DrmRentalLimit = -1;
        }
        System.out.println("mU32DrmRentalLimit : " + this.mU32DrmRentalLimit);
        if (metadata.has(49)) {
            this.mU32DrmRentalUseCount = metadata.getInt(49);
        } else {
            this.mU32DrmRentalUseCount = -1;
        }
        System.out.println("mU32DrmRentalUseCount : " + this.mU32DrmRentalUseCount);
        if (metadata.has(50)) {
            this.mU16CheckSum = metadata.getInt(50);
        } else {
            this.mU16CheckSum = -1;
        }
        System.out.println("mU16CheckSum : " + this.mU16CheckSum);
        if (metadata.has(51)) {
            this.mU8DrmRentalStatus = metadata.getInt(51);
        } else {
            this.mU8DrmRentalStatus = -1;
        }
        System.out.println("mU8DrmRentalStatus : " + this.mU8DrmRentalStatus);
        if (metadata.has(52)) {
            this.mU8DrmFileFormat = metadata.getInt(52);
        } else {
            this.mU8DrmFileFormat = -1;
        }
        System.out.println("mU8DrmFileFormat : " + this.mU8DrmFileFormat);
        if (metadata.has(53)) {
            this.mU8DrmAuthorization = metadata.getInt(53);
        } else {
            this.mU8DrmAuthorization = -1;
        }
        System.out.println("mU8DrmAuthorization : " + this.mU8DrmAuthorization);
        System.out.println("JAVA, Exit DivxDrmInfo constructure");
    }

    public int GetDrmRentalCode() {
        return this.mU32DrmRentalCode;
    }

    public int GetDrmRentalFile() {
        return this.mU32DrmRentalFile;
    }

    public int GetDrmRentalLimit() {
        return this.mU32DrmRentalLimit;
    }

    public int GetDrmRentalUseCount() {
        return this.mU32DrmRentalUseCount;
    }

    public int GetDrmCheckSum() {
        return this.mU16CheckSum;
    }

    public int GetDrmRentalStatus() {
        return this.mU8DrmRentalStatus;
    }

    public int GetDrmFileFormat() {
        return this.mU8DrmFileFormat;
    }

    public int GetDrmAuthorization() {
        return this.mU8DrmAuthorization;
    }
}
