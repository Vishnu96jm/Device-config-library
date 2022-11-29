package com.eginnovations.mydeviceconfig;

import static android.content.Context.ACTIVITY_SERVICE;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;

import java.io.File;

public class DeviceConfig {

    public static String getTotalInternalMemorySize(Activity activity) {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSizeLong();
        long totalBlocks = stat.getBlockCountLong();
        long bytesTotal = totalBlocks * blockSize;
        return Math.round(bytesTotal / (1024.0 * 1024.0 * 1024.0) * 10.0) / 10.0 +" " +activity.getString(R.string.gb);
    }

    public static double getAvailableInternalMemorySize() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSizeLong();
        long availableBlocks = stat.getAvailableBlocksLong();
        long bytesAvailable = blockSize * availableBlocks;
        return Math.round(bytesAvailable / (1024.0 * 1024.0 * 1024.0) * 10.0) / 10.0;
    }

    public static String getTotalRam(Activity act) {
        ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager) act.getSystemService(ACTIVITY_SERVICE);
        activityManager.getMemoryInfo(mi);
        return Math.round(mi.totalMem / (1024.0 * 1024.0 * 1024.0) * 10.0) / 10.0+" " +act.getString(R.string.gb);
    }

    public static double getAvailableRam(Context context) {
        ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(ACTIVITY_SERVICE);
        activityManager.getMemoryInfo(mi);
        return Math.round(mi.availMem / (1024.0 * 1024.0 * 1024.0) * 10.0) / 10.0;
    }
}


