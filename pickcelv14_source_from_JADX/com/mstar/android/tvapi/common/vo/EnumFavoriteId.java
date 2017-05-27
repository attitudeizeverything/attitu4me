package com.mstar.android.tvapi.common.vo;

import android.support.v4.media.TransportMediator;

public enum EnumFavoriteId {
    E_FAVORITE_ID_1(1),
    E_FAVORITE_ID_2(2),
    E_FAVORITE_ID_3(4),
    E_FAVORITE_ID_4(8),
    E_FAVORITE_ID_5(16),
    E_FAVORITE_ID_6(32),
    E_FAVORITE_ID_7(64),
    E_FAVORITE_ID_8(TransportMediator.FLAG_KEY_MEDIA_NEXT);
    
    private final int value;

    private EnumFavoriteId(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
