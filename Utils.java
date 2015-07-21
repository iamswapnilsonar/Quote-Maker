import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

/**
 * @author Swapnil Sonar
 * @Date 01/07/2015
 */
public class Utils {

	private static final String TAG = "Utils";
	
	/**
	 * It return all installed applications and along with its details.
	 * @param context
	 * @param getSysPackages
	 * @return
	 */
	@SuppressWarnings("unused")
	private List<PackageInfoBean> getInstalledApps(Context context, boolean getSysPackages) {

		List<PackageInfoBean> mPackageInfos = new ArrayList<PackageInfoBean>();
		
        long timeStamp = System.currentTimeMillis();
        List<android.content.pm.PackageInfo> packs = context.getPackageManager()
                .getInstalledPackages(0);

        for (int i = 0; i < packs.size(); i++) {
            android.content.pm.PackageInfo packageInfo = packs.get(i);
//            if ((!getSysPackages) && (packageInfo.versionName == null)) {
//                continue;
//            }

            PackageInfoBean newInfo = new PackageInfoBean();
            newInfo.mAppName = packageInfo.applicationInfo.loadLabel(context.getPackageManager());
            newInfo.mAppPackageName = packageInfo.packageName;
            newInfo.mDataDir = packageInfo.applicationInfo.dataDir;
            
            // .apk file of application
            newInfo.mApkFilePath = packageInfo.applicationInfo.publicSourceDir; 
            
            // apk file size
            File file = new File(newInfo.mApkFilePath);
            newInfo.mApkFileSize = file.length();
            
            newInfo.mVersionName = packageInfo.versionName;
            newInfo.mVersionCode = packageInfo.versionCode;
            newInfo.mApplicationInfo = packageInfo.applicationInfo;
            newInfo.icon = packageInfo.applicationInfo.loadIcon(context.getPackageManager());
            mPackageInfos.add(newInfo);
        }

        long timeInterval = System.currentTimeMillis() - timeStamp;
        Log.e(TAG, "getInstalledApps used: " + timeInterval);
        
        return mPackageInfos;
    }
}
