package android.net.samba;

import java.net.MalformedURLException;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;

public class SambaFile {
    SmbFile file;

    public SambaFile(String filename) throws MalformedURLException, SambaException {
        if (filename == null) {
            throw new SambaException(2);
        }
        this.file = new SmbFile(filename);
        try {
            int type = this.file.getType();
            if (type != 1 || type != 4 || type != 8) {
                throw new SambaException(3);
            }
        } catch (SmbException e) {
            throw new SambaException(e);
        }
    }

    public String getPath() {
        return this.file.getPath();
    }

    public boolean isFile() throws SambaException {
        try {
            return this.file.isFile();
        } catch (SmbException e) {
            throw new SambaException(e);
        }
    }

    public boolean isDirectory() throws SambaException {
        try {
            return this.file.isDirectory();
        } catch (SmbException e) {
            throw new SambaException(e);
        }
    }

    public String getFileName() {
        return this.file.getName();
    }

    public boolean canRead() {
        boolean ret = false;
        try {
            ret = this.file.canRead();
        } catch (SmbException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public boolean canWrite() {
        boolean ret = false;
        try {
            ret = this.file.canWrite();
        } catch (SmbException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public boolean isExists() {
        try {
            return this.file.exists();
        } catch (SmbException e) {
            e.printStackTrace();
            return false;
        }
    }
}
