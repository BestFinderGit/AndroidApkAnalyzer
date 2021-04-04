package sk.styk.martin.apkanalyzer.business.analysis.logic

import android.content.pm.FeatureInfo
import android.content.pm.PackageInfo
import androidx.annotation.WorkerThread
import sk.styk.martin.apkanalyzer.model.detail.FeatureData
import java.util.*
import javax.inject.Inject

@WorkerThread
class FeaturesManager @Inject constructor() {

    fun get(packageInfo: PackageInfo): List<FeatureData> {

        val featureInfos = packageInfo.reqFeatures ?: return ArrayList(0)

        return featureInfos.mapTo(ArrayList<FeatureData>(featureInfos.size)) {
            FeatureData(
                    name = it.name ?: it.glEsVersion,
                    isRequired = (it.flags and FeatureInfo.FLAG_REQUIRED) > 0
            )
        }
    }
}
