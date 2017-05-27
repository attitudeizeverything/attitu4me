package com.pickcel.agent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class OnBoot extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equalsIgnoreCase("android.intent.action.BOOT_COMPLETED")) {
            Intent bootIntent = new Intent(context, Bootstrap.class);
            bootIntent.addFlags(SmbConstants.GENERIC_ALL);
            context.startActivity(bootIntent);
        }
    }
}
