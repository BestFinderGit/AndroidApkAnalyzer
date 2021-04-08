package sk.styk.martin.apkanalyzer.ui.activity.dialog

import android.app.Activity
import sk.styk.martin.apkanalyzer.R

class FeatureDialog {

    companion object {
        const val fromVersion: Int = 38
    }

    fun showFeatureDialog(context: Activity) {
        FancyDialog(context).apply {
            title = R.string.color_theme_promo_title
            message = R.string.color_theme_promo_message
            positiveBtnText = R.string.color_theme_promo_switch_dark
            negativeBtnText = R.string.color_theme_promo_stay_light
            positiveButtonColor = R.color.grey_500
            negativeButtonColor = R.color.grey_500
            gifImageResource = R.drawable.feature_anim
            cancelable = true
//            actionListener = object : FancyDialog.FancyDialogAction {
//                override fun onPositiveButtonClicked(context: Activity) = ColorThemeHelper.setTheme(DARK_THEME, context)
//                override fun onNegativeButtonClicked(context: Activity) = ColorThemeHelper.setTheme(LIGHT_THEME, context)
//            }
        }.build().show()
    }


}