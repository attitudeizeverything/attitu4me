package com.example.yoho;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
//import jcifs.smb.SmbConstants;

public class OnBoot extends BroadcastReceiver {
	public static final int GENERIC_ALL = 268435456;
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equalsIgnoreCase("android.intent.action.BOOT_COMPLETED")) {
            Intent bootIntent = new Intent(context, Bootstrap.class);
            bootIntent.addFlags(GENERIC_ALL);
            context.startActivity(bootIntent);
        }
    }
}
