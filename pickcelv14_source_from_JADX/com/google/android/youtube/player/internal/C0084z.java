package com.google.android.youtube.player.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;

/* renamed from: com.google.android.youtube.player.internal.z */
public final class C0084z {
    private static final Uri f44a;
    private static final String[] f45b;

    static {
        f44a = Uri.parse("http://play.google.com/store/apps/details");
        f45b = new String[]{"com.google.android.youtube", "com.google.android.youtube.tv", "com.google.android.youtube.googletv", "com.google.android.gms", null};
    }

    public static Intent m118a(String str) {
        Uri fromParts = Uri.fromParts("package", str, null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(fromParts);
        return intent;
    }

    public static String m119a() {
        return 1 + ".2.1";
    }

    public static String m120a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        for (String str : f45b) {
            ResolveInfo resolveService = packageManager.resolveService(new Intent("com.google.android.youtube.api.service.START").setPackage(str), 0);
            if (resolveService != null && resolveService.serviceInfo != null && resolveService.serviceInfo.packageName != null) {
                return resolveService.serviceInfo.packageName;
            }
        }
        return packageManager.hasSystemFeature("android.software.leanback") ? "com.google.android.youtube.tv" : packageManager.hasSystemFeature("com.google.android.tv") ? "com.google.android.youtube.googletv" : "com.google.android.youtube";
    }

    public static boolean m121a(Context context, String str) {
        try {
            Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(str);
            if (str.equals("com.google.android.youtube.googletvdev")) {
                str = "com.google.android.youtube.googletv";
            }
            int identifier = resourcesForApplication.getIdentifier("youtube_api_version_code", "integer", str);
            return identifier == 0 || 12 > resourcesForApplication.getInteger(identifier) / 100;
        } catch (NameNotFoundException e) {
            return true;
        }
    }

    public static boolean m122a(PackageManager packageManager) {
        return packageManager.hasSystemFeature("com.google.android.tv");
    }

    public static Context m123b(Context context) {
        try {
            return context.createPackageContext(C0084z.m120a(context), 3);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static Intent m124b(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(f44a.buildUpon().appendQueryParameter("id", str).build());
        intent.setPackage("com.android.vending");
        intent.addFlags(SmbConstants.WRITE_OWNER);
        return intent;
    }

    public static boolean m125b(PackageManager packageManager) {
        return packageManager.hasSystemFeature("android.software.leanback");
    }

    public static int m126c(Context context) {
        Context b = C0084z.m123b(context);
        int i = 0;
        if (b != null) {
            i = b.getResources().getIdentifier("clientTheme", "style", C0084z.m120a(context));
        }
        return i == 0 ? VERSION.SDK_INT >= 14 ? 16974120 : VERSION.SDK_INT >= 11 ? 16973931 : 16973829 : i;
    }

    public static String m127d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable e) {
            throw new IllegalStateException("Cannot retrieve calling Context's PackageInfo", e);
        }
    }
}
