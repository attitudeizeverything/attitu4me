package com.google.android.youtube.player;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.google.android.youtube.player.internal.C0067m;
import com.google.android.youtube.player.internal.C0083y;
import com.google.android.youtube.player.internal.C0084z;
import com.google.android.youtube.player.internal.ab;
import jcifs.smb.SmbNamedPipe;

public enum YouTubeInitializationResult {
    SUCCESS,
    INTERNAL_ERROR,
    UNKNOWN_ERROR,
    SERVICE_MISSING,
    SERVICE_VERSION_UPDATE_REQUIRED,
    SERVICE_DISABLED,
    SERVICE_INVALID,
    ERROR_CONNECTING_TO_SERVICE,
    CLIENT_LIBRARY_UPDATE_REQUIRED,
    NETWORK_ERROR,
    DEVELOPER_KEY_INVALID,
    INVALID_APPLICATION_SIGNATURE;

    /* renamed from: com.google.android.youtube.player.YouTubeInitializationResult.1 */
    static /* synthetic */ class C00531 {
        static final /* synthetic */ int[] f6a;

        static {
            f6a = new int[YouTubeInitializationResult.values().length];
            try {
                f6a[YouTubeInitializationResult.SERVICE_MISSING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6a[YouTubeInitializationResult.SERVICE_DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6a[YouTubeInitializationResult.SERVICE_VERSION_UPDATE_REQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* renamed from: com.google.android.youtube.player.YouTubeInitializationResult.a */
    private static final class C0054a implements OnClickListener {
        private final Activity f7a;
        private final Intent f8b;
        private final int f9c;

        public C0054a(Activity activity, Intent intent, int i) {
            this.f7a = (Activity) ab.m25a((Object) activity);
            this.f8b = (Intent) ab.m25a((Object) intent);
            this.f9c = ((Integer) ab.m25a(Integer.valueOf(i))).intValue();
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            try {
                this.f7a.startActivityForResult(this.f8b, this.f9c);
                dialogInterface.dismiss();
            } catch (Throwable e) {
                C0083y.m116a("Can't perform resolution for YouTubeInitalizationError", e);
            }
        }
    }

    public final Dialog getErrorDialog(Activity activity, int i) {
        return getErrorDialog(activity, i, null);
    }

    public final Dialog getErrorDialog(Activity activity, int i, OnCancelListener onCancelListener) {
        Intent b;
        Builder builder = new Builder(activity);
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        switch (C00531.f6a[ordinal()]) {
            case SmbNamedPipe.PIPE_TYPE_RDONLY /*1*/:
            case SmbNamedPipe.PIPE_TYPE_RDWR /*3*/:
                b = C0084z.m124b(C0084z.m120a((Context) activity));
                break;
            case SmbNamedPipe.PIPE_TYPE_WRONLY /*2*/:
                b = C0084z.m118a(C0084z.m120a((Context) activity));
                break;
            default:
                b = null;
                break;
        }
        OnClickListener c0054a = new C0054a(activity, b, i);
        C0067m c0067m = new C0067m(activity);
        switch (C00531.f6a[ordinal()]) {
            case SmbNamedPipe.PIPE_TYPE_RDONLY /*1*/:
                return builder.setTitle(c0067m.f19b).setMessage(c0067m.f20c).setPositiveButton(c0067m.f21d, c0054a).create();
            case SmbNamedPipe.PIPE_TYPE_WRONLY /*2*/:
                return builder.setTitle(c0067m.f22e).setMessage(c0067m.f23f).setPositiveButton(c0067m.f24g, c0054a).create();
            case SmbNamedPipe.PIPE_TYPE_RDWR /*3*/:
                return builder.setTitle(c0067m.f25h).setMessage(c0067m.f26i).setPositiveButton(c0067m.f27j, c0054a).create();
            default:
                String str = "Unexpected errorReason: ";
                String valueOf = String.valueOf(name());
                throw new IllegalArgumentException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    public final boolean isUserRecoverableError() {
        switch (C00531.f6a[ordinal()]) {
            case SmbNamedPipe.PIPE_TYPE_RDONLY /*1*/:
            case SmbNamedPipe.PIPE_TYPE_WRONLY /*2*/:
            case SmbNamedPipe.PIPE_TYPE_RDWR /*3*/:
                return true;
            default:
                return false;
        }
    }
}
