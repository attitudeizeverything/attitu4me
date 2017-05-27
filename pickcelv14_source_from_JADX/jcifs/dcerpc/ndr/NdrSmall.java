package jcifs.dcerpc.ndr;

import com.mstar.android.MKeyEvent;

public class NdrSmall extends NdrObject {
    public int value;

    public NdrSmall(int value) {
        this.value = value & MKeyEvent.KEYCODE_SLEEP;
    }

    public void encode(NdrBuffer dst) throws NdrException {
        dst.enc_ndr_small(this.value);
    }

    public void decode(NdrBuffer src) throws NdrException {
        this.value = src.dec_ndr_small();
    }
}
