package com.mstar.android.tvapi.dtv.vo;

public class CaServiceEntitles {
    public CaServiceEntitle[] cEntitles;
    public short sEntitlesState;
    public short sProductCount;

    public CaServiceEntitles() {
        this.cEntitles = new CaServiceEntitle[300];
        this.sEntitlesState = (short) 0;
        this.sProductCount = (short) 0;
        for (int i = 0; i < 300; i++) {
            this.cEntitles[i] = new CaServiceEntitle();
        }
    }
}
