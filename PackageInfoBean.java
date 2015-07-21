import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;

/**
 * @author Swapnil Sonar
 * @Date 01/07/2015
 */
public class PackageInfoBean {
    
    public CharSequence mAppName = "";
    public String mAppPackageName = "";
    public String mVersionName = "";
    public int mVersionCode = 0;
    public Drawable icon;
    public String mDataDir = "";
    public long cacheSize = 0;
    public ApplicationInfo mApplicationInfo;
    public String mApkFilePath = "";
    public long mApkFileSize = 0;
    
}
