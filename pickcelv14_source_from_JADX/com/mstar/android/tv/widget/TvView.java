package com.mstar.android.tv.widget;

import android.content.Context;
import android.net.Uri;
import android.support.v4.internal.view.SupportMenu;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.mstar.android.MKeyEvent;
import com.mstar.android.tv.TvChannelManager;
import com.mstar.android.tvapi.common.TvManager;
import com.mstar.android.tvapi.common.exception.TvCommonException;
import com.mstar.android.tvapi.common.vo.EnumScalerWindow;
import com.mstar.android.tvapi.common.vo.TvOsType.EnumInputSource;
import com.mstar.android.tvapi.common.vo.VideoWindowType;
import java.util.ArrayList;

public class TvView extends SurfaceView implements Callback {
    private String TAG;
    private ArrayList<String> availableSrcList;
    private boolean isPowerOn;
    private Context mContext;
    private boolean mCreateFromLayout;
    private SurfaceHolder mSurfaceHolder;
    private int mVideoHeight;
    private int mVideoLeft;
    private int mVideoTop;
    private int mVideoWidth;
    private LayoutParams surfaceParams;
    private String[] totalSrcList;
    private WindowManager wm;

    public TvView(Context context) {
        super(context);
        this.TAG = "TvView";
        this.mContext = null;
        this.mVideoTop = 0;
        this.mVideoLeft = 0;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mCreateFromLayout = false;
        this.mSurfaceHolder = null;
        this.availableSrcList = new ArrayList();
        this.totalSrcList = new String[]{"VGA", "ATV", "CVBS", "CVBS2", "CVBS3", "CVBS4", "CVBS5", "CVBS6", "CVBS7", "CVBS8", "CVBS_MAX", "SVIDEO", "SVIDEO2", "SVIDEO3", "SVIDEO4", "SVIDEO_MAX", "YPBPR1", "YPBPR2", "YPBPR3", "YPBPR_MAX", "SCART", "SCART2", "SCART_MAX", "HDMI1", "HDMI2", "HDMI3", "HDMI4", "HDMI_MAX", "DTV"};
        this.isPowerOn = false;
        this.mCreateFromLayout = true;
    }

    public TvView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.TAG = "TvView";
        this.mContext = null;
        this.mVideoTop = 0;
        this.mVideoLeft = 0;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mCreateFromLayout = false;
        this.mSurfaceHolder = null;
        this.availableSrcList = new ArrayList();
        this.totalSrcList = new String[]{"VGA", "ATV", "CVBS", "CVBS2", "CVBS3", "CVBS4", "CVBS5", "CVBS6", "CVBS7", "CVBS8", "CVBS_MAX", "SVIDEO", "SVIDEO2", "SVIDEO3", "SVIDEO4", "SVIDEO_MAX", "YPBPR1", "YPBPR2", "YPBPR3", "YPBPR_MAX", "SCART", "SCART2", "SCART_MAX", "HDMI1", "HDMI2", "HDMI3", "HDMI4", "HDMI_MAX", "DTV"};
        this.isPowerOn = false;
        this.mContext = context;
        this.mCreateFromLayout = true;
    }

    public TvView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.TAG = "TvView";
        this.mContext = null;
        this.mVideoTop = 0;
        this.mVideoLeft = 0;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mCreateFromLayout = false;
        this.mSurfaceHolder = null;
        this.availableSrcList = new ArrayList();
        this.totalSrcList = new String[]{"VGA", "ATV", "CVBS", "CVBS2", "CVBS3", "CVBS4", "CVBS5", "CVBS6", "CVBS7", "CVBS8", "CVBS_MAX", "SVIDEO", "SVIDEO2", "SVIDEO3", "SVIDEO4", "SVIDEO_MAX", "YPBPR1", "YPBPR2", "YPBPR3", "YPBPR_MAX", "SCART", "SCART2", "SCART_MAX", "HDMI1", "HDMI2", "HDMI3", "HDMI4", "HDMI_MAX", "DTV"};
        this.isPowerOn = false;
        this.mContext = context;
        this.mCreateFromLayout = true;
    }

    public TvView(Context context, int X, int Y, int Width, int Height) {
        super(context);
        this.TAG = "TvView";
        this.mContext = null;
        this.mVideoTop = 0;
        this.mVideoLeft = 0;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mCreateFromLayout = false;
        this.mSurfaceHolder = null;
        this.availableSrcList = new ArrayList();
        this.totalSrcList = new String[]{"VGA", "ATV", "CVBS", "CVBS2", "CVBS3", "CVBS4", "CVBS5", "CVBS6", "CVBS7", "CVBS8", "CVBS_MAX", "SVIDEO", "SVIDEO2", "SVIDEO3", "SVIDEO4", "SVIDEO_MAX", "YPBPR1", "YPBPR2", "YPBPR3", "YPBPR_MAX", "SCART", "SCART2", "SCART_MAX", "HDMI1", "HDMI2", "HDMI3", "HDMI4", "HDMI_MAX", "DTV"};
        this.isPowerOn = false;
        this.mVideoTop = Y;
        this.mVideoLeft = X;
        this.mVideoWidth = Width;
        this.mVideoHeight = Height;
        this.mContext = context;
        this.mCreateFromLayout = false;
    }

    public void openView(Boolean isPowerOn) {
        this.isPowerOn = isPowerOn.booleanValue();
        if (this.mCreateFromLayout) {
            initVideoView();
        } else {
            initWMVideoView();
        }
    }

    public void destroy() {
        if (!this.mCreateFromLayout) {
            this.wm.removeView(this);
        }
    }

    private void initVideoView() {
        this.mSurfaceHolder = getHolder();
        this.mSurfaceHolder.addCallback(this);
        this.mSurfaceHolder.setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    private void initWMVideoView() {
        this.surfaceParams = new LayoutParams();
        this.surfaceParams.x = this.mVideoLeft;
        this.surfaceParams.y = this.mVideoTop;
        this.surfaceParams.width = this.mVideoWidth;
        this.surfaceParams.height = this.mVideoHeight;
        this.surfaceParams.type = 2;
        this.surfaceParams.flags = 24;
        Log.v(this.TAG, "openSurfaceView===" + this.surfaceParams);
        this.surfaceParams.gravity = 51;
        this.wm = (WindowManager) this.mContext.getSystemService("window");
        initVideoView();
        this.wm.addView(this, this.surfaceParams);
    }

    private void initSrcList() {
        try {
            int[] srcList = TvManager.getInstance().getSourceList();
            for (int i = 0; i < this.totalSrcList.length; i++) {
                if (srcList[i] != 0) {
                    this.availableSrcList.add(this.totalSrcList[i]);
                }
            }
        } catch (TvCommonException e) {
            e.printStackTrace();
        }
    }

    private void setVideoFullRectangle() {
        try {
            VideoWindowType videoWindowType = new VideoWindowType();
            videoWindowType.height = SupportMenu.USER_MASK;
            videoWindowType.width = SupportMenu.USER_MASK;
            videoWindowType.f60x = SupportMenu.USER_MASK;
            videoWindowType.f61y = SupportMenu.USER_MASK;
            TvManager.getInstance().getPictureManager().selectWindow(EnumScalerWindow.E_MAIN_WINDOW);
            TvManager.getInstance().getPictureManager().setDisplayWindow(videoWindowType);
            TvManager.getInstance().getPictureManager().scaleWindow();
        } catch (TvCommonException e) {
            e.printStackTrace();
        }
    }

    private void setVideoRectangle() {
        try {
            VideoWindowType videoWindowType = new VideoWindowType();
            videoWindowType.f60x = this.mVideoLeft;
            videoWindowType.f61y = this.mVideoTop;
            videoWindowType.width = this.mVideoWidth;
            videoWindowType.height = this.mVideoHeight;
            TvManager.getInstance().getPictureManager().selectWindow(EnumScalerWindow.E_MAIN_WINDOW);
            TvManager.getInstance().getPictureManager().setDisplayWindow(videoWindowType);
            TvManager.getInstance().getPictureManager().scaleWindow();
        } catch (TvCommonException e) {
            e.printStackTrace();
        }
    }

    public void setTvURI(Uri uri) {
        if (uri != null && uri.getScheme() != null && uri.getPathSegments() != null && uri.getAuthority() != null && uri.getScheme().equalsIgnoreCase("command") && uri.getAuthority().equalsIgnoreCase("mstar.tv")) {
            String command = (String) uri.getPathSegments().get(0);
            if (command.equalsIgnoreCase("setinputsrc")) {
                String srcName = uri.getLastPathSegment();
                int channelNum = -1;
                try {
                    channelNum = uri.getFragment() == null ? -1 : Integer.parseInt(uri.getFragment());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                if (srcName.equalsIgnoreCase("ATV")) {
                    doSourceSwitch(EnumInputSource.E_INPUT_SOURCE_ATV);
                    if (channelNum < 0) {
                        int curChannelNumber = TvChannelManager.getInstance().getCurrentChannelNumber();
                        if (curChannelNumber > MKeyEvent.KEYCODE_SLEEP) {
                            curChannelNumber = 0;
                        }
                        TvChannelManager.getInstance().setAtvChannel(curChannelNumber);
                        return;
                    }
                    TvChannelManager.getInstance().setAtvChannel(channelNum);
                } else if (srcName.equalsIgnoreCase("DTV")) {
                    doSourceSwitch(EnumInputSource.E_INPUT_SOURCE_DTV);
                    if (channelNum < 0) {
                        TvChannelManager.getInstance().playDtvCurrentProgram();
                    } else {
                        selectDTVProgram(channelNum);
                    }
                } else if (srcName.equalsIgnoreCase("VGA")) {
                    doSourceSwitch(EnumInputSource.E_INPUT_SOURCE_VGA);
                } else if (srcName.equalsIgnoreCase("CVBS")) {
                    if (channelNum - 1 <= 0) {
                        doSourceSwitch(EnumInputSource.E_INPUT_SOURCE_CVBS);
                    } else if (this.availableSrcList.contains("CVBS" + channelNum)) {
                        doSourceSwitch((EnumInputSource.E_INPUT_SOURCE_CVBS.ordinal() + channelNum) - 1);
                    }
                } else if (srcName.equalsIgnoreCase("SVIDEO")) {
                    if (channelNum - 1 <= 0) {
                        doSourceSwitch(EnumInputSource.E_INPUT_SOURCE_SVIDEO);
                    } else if (this.availableSrcList.contains("SVIDEO" + channelNum)) {
                        doSourceSwitch((EnumInputSource.E_INPUT_SOURCE_SVIDEO.ordinal() + channelNum) - 1);
                    }
                } else if (srcName.equalsIgnoreCase("YPBPR")) {
                    if (channelNum - 1 <= 0) {
                        doSourceSwitch(EnumInputSource.E_INPUT_SOURCE_YPBPR);
                    } else if (this.availableSrcList.contains("YPBPR" + channelNum)) {
                        doSourceSwitch((EnumInputSource.E_INPUT_SOURCE_YPBPR.ordinal() + channelNum) - 1);
                    }
                } else if (srcName.equalsIgnoreCase("SCART")) {
                    if (channelNum - 1 <= 0) {
                        doSourceSwitch(EnumInputSource.E_INPUT_SOURCE_SCART);
                    } else if (this.availableSrcList.contains("SCART" + channelNum)) {
                        doSourceSwitch((EnumInputSource.E_INPUT_SOURCE_SCART.ordinal() + channelNum) - 1);
                    }
                } else if (!srcName.equalsIgnoreCase("HDMI")) {
                } else {
                    if (channelNum - 1 <= 0) {
                        doSourceSwitch(EnumInputSource.E_INPUT_SOURCE_HDMI);
                    } else if (this.availableSrcList.contains("HDMI" + channelNum)) {
                        doSourceSwitch((EnumInputSource.E_INPUT_SOURCE_HDMI.ordinal() + channelNum) - 1);
                    }
                }
            } else if (command.equalsIgnoreCase("setfullscale")) {
                setVideoFullRectangle();
            }
        }
    }

    private void doSourceSwitch(EnumInputSource inputsrc) {
        try {
            if (inputsrc != TvManager.getInstance().getCurrentInputSource()) {
                TvManager.getInstance().setInputSource(inputsrc);
            }
        } catch (TvCommonException e) {
            e.printStackTrace();
        }
    }

    private void doSourceSwitch(int inputnum) {
        EnumInputSource inputsrc = EnumInputSource.values()[inputnum];
        try {
            if (inputsrc != TvManager.getInstance().getCurrentInputSource()) {
                TvManager.getInstance().setInputSource(inputsrc);
            }
        } catch (TvCommonException e) {
            e.printStackTrace();
        }
    }

    public boolean selectDTVProgram(int u32Number) {
        try {
            if (TvManager.getInstance() != null) {
                TvManager.getInstance().getChannelManager().selectProgram(u32Number, (short) 1, 0);
            }
        } catch (TvCommonException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void surfaceCreated(SurfaceHolder holder) {
        if (holder.getSurface().isValid()) {
            try {
                if (TvManager.getInstance() != null) {
                    TvManager.getInstance().getPlayerManager().setDisplay(this.mSurfaceHolder);
                }
            } catch (TvCommonException e) {
                e.printStackTrace();
            }
            this.mVideoWidth = getWidth();
            this.mVideoHeight = getHeight();
            this.mVideoLeft = (int) getX();
            this.mVideoTop = (int) getY();
            if (!this.isPowerOn) {
                this.isPowerOn = false;
                setVideoFullRectangle();
            }
            initSrcList();
        }
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
    }
}
