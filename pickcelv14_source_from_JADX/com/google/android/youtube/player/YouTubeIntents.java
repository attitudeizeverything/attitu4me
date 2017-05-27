package com.google.android.youtube.player;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import com.google.android.youtube.player.internal.C0084z;
import com.mstar.android.tvapi.common.vo.Constants;
import java.util.List;

public final class YouTubeIntents {
    private YouTubeIntents() {
    }

    static Intent m7a(Intent intent, Context context) {
        intent.putExtra("app_package", context.getPackageName()).putExtra("app_version", C0084z.m127d(context)).putExtra("client_library_version", C0084z.m119a());
        return intent;
    }

    private static Uri m8a(String str) {
        String valueOf = String.valueOf("http://www.youtube.com/playlist?list=");
        String valueOf2 = String.valueOf(str);
        return Uri.parse(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
    }

    private static String m9a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        return C0084z.m125b(packageManager) ? "com.google.android.youtube.tv" : C0084z.m122a(packageManager) ? "com.google.android.youtube.googletv" : "com.google.android.youtube";
    }

    private static boolean m10a(Context context, Intent intent) {
        List queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, SmbConstants.DELETE);
        return (queryIntentActivities == null || queryIntentActivities.isEmpty()) ? false : true;
    }

    private static boolean m11a(Context context, Uri uri) {
        return m10a(context, new Intent("android.intent.action.VIEW", uri).setPackage(m9a(context)));
    }

    private static Intent m12b(Context context, Uri uri) {
        return m7a(new Intent("android.intent.action.VIEW", uri).setPackage(m9a(context)), context);
    }

    public static boolean canResolveOpenPlaylistIntent(Context context) {
        return m11a(context, Uri.parse("http://www.youtube.com/playlist?list="));
    }

    public static boolean canResolvePlayPlaylistIntent(Context context) {
        int installedYouTubeVersionCode = getInstalledYouTubeVersionCode(context);
        boolean z = C0084z.m122a(context.getPackageManager()) ? installedYouTubeVersionCode >= 4700 : installedYouTubeVersionCode >= 4000;
        return z && canResolveOpenPlaylistIntent(context);
    }

    public static boolean canResolvePlayVideoIntent(Context context) {
        return m11a(context, Uri.parse("http://www.youtube.com/watch?v="));
    }

    public static boolean canResolvePlayVideoIntentWithOptions(Context context) {
        int installedYouTubeVersionCode = getInstalledYouTubeVersionCode(context);
        PackageManager packageManager = context.getPackageManager();
        boolean z = C0084z.m125b(packageManager) ? true : C0084z.m122a(packageManager) ? installedYouTubeVersionCode >= Constants.CONNECTION_OK : installedYouTubeVersionCode >= 3300;
        return z && canResolvePlayVideoIntent(context);
    }

    public static boolean canResolveSearchIntent(Context context) {
        return (!C0084z.m122a(context.getPackageManager()) || getInstalledYouTubeVersionCode(context) >= 4700) ? m10a(context, new Intent("android.intent.action.SEARCH").setPackage(m9a(context))) : false;
    }

    public static boolean canResolveUploadIntent(Context context) {
        return m10a(context, new Intent("com.google.android.youtube.intent.action.UPLOAD").setPackage(m9a(context)).setType("video/*"));
    }

    public static boolean canResolveUserIntent(Context context) {
        return m11a(context, Uri.parse("http://www.youtube.com/user/"));
    }

    public static Intent createOpenPlaylistIntent(Context context, String str) {
        return m7a(m12b(context, m8a(str)), context);
    }

    public static Intent createPlayPlaylistIntent(Context context, String str) {
        return m7a(m12b(context, m8a(str).buildUpon().appendQueryParameter("playnext", "1").build()), context);
    }

    public static Intent createPlayVideoIntent(Context context, String str) {
        return createPlayVideoIntentWithOptions(context, str, false, false);
    }

    public static Intent createPlayVideoIntentWithOptions(Context context, String str, boolean z, boolean z2) {
        String valueOf = String.valueOf("http://www.youtube.com/watch?v=");
        String valueOf2 = String.valueOf(str);
        return m12b(context, Uri.parse(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf))).putExtra("force_fullscreen", z).putExtra("finish_on_ended", z2);
    }

    public static Intent createSearchIntent(Context context, String str) {
        return m7a(new Intent("android.intent.action.SEARCH").setPackage(m9a(context)).putExtra("query", str), context);
    }

    public static Intent createUploadIntent(Context context, Uri uri) throws IllegalArgumentException {
        if (uri == null) {
            throw new IllegalArgumentException("videoUri parameter cannot be null.");
        } else if (uri.toString().startsWith("content://media/")) {
            return m7a(new Intent("com.google.android.youtube.intent.action.UPLOAD").setPackage(m9a(context)).setDataAndType(uri, "video/*"), context);
        } else {
            throw new IllegalArgumentException("videoUri parameter must be a URI pointing to a valid video file. It must begin with \"content://media/\"");
        }
    }

    public static Intent createUserIntent(Context context, String str) {
        String valueOf = String.valueOf("http://www.youtube.com/user/");
        String valueOf2 = String.valueOf(str);
        return m12b(context, Uri.parse(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)));
    }

    public static int getInstalledYouTubeVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(m9a(context), 0).versionCode;
        } catch (NameNotFoundException e) {
            return -1;
        }
    }

    public static String getInstalledYouTubeVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(m9a(context), 0).versionName;
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static boolean isYouTubeInstalled(Context context) {
        try {
            context.getPackageManager().getApplicationInfo(m9a(context), 0);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
