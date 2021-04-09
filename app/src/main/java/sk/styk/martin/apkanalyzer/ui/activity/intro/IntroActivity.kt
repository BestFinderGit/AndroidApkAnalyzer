package sk.styk.martin.apkanalyzer.ui.activity.intro

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.github.paolorotolo.appintro.AppIntro
import com.github.paolorotolo.appintro.AppIntroFragment
import com.github.paolorotolo.appintro.model.SliderPage
import com.google.firebase.analytics.FirebaseAnalytics
import dagger.android.AndroidInjection
import sk.styk.martin.apkanalyzer.R
import sk.styk.martin.apkanalyzer.manager.persistence.PersistenceManager
import javax.inject.Inject

class IntroActivity : AppIntro() {

    @Inject
    lateinit var persistenceManager: PersistenceManager

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        val analyzeAppsSlide = SliderPage()
        analyzeAppsSlide.title = getString(R.string.intro_analyze_apps)
        analyzeAppsSlide.description = getString(R.string.intro_analyze_apps_description)
        analyzeAppsSlide.bgColor = ContextCompat.getColor(this, R.color.accentLight)
        analyzeAppsSlide.imageDrawable = R.drawable.ic_lupa

        val permissionsAppsSlide = SliderPage()
        permissionsAppsSlide.title = getString(R.string.intro_permissions)
        permissionsAppsSlide.description = getString(R.string.intro_permissions_description)
        permissionsAppsSlide.bgColor = ContextCompat.getColor(this, R.color.accentLight)
        permissionsAppsSlide.imageDrawable = R.drawable.ic_permission

        val statisticsAppsSlide = SliderPage()
        statisticsAppsSlide.title = getString(R.string.intro_statistics)
        statisticsAppsSlide.description = getString(R.string.intro_statistics_description)
        statisticsAppsSlide.bgColor = ContextCompat.getColor(this, R.color.accentLight)
        statisticsAppsSlide.imageDrawable = R.drawable.ic_chart

        val uploadAppsSlide = SliderPage()
        uploadAppsSlide.title = getString(R.string.intro_upload)
        uploadAppsSlide.description = getString(R.string.intro_upload_description)
        uploadAppsSlide.bgColor = ContextCompat.getColor(this, R.color.accentLight)
        uploadAppsSlide.imageDrawable = R.drawable.ic_upload

        addSlide(AppIntroFragment.newInstance(analyzeAppsSlide))
        addSlide(AppIntroFragment.newInstance(permissionsAppsSlide))
        addSlide(AppIntroFragment.newInstance(statisticsAppsSlide))

        // Hide Skip/Done button.
        isProgressButtonEnabled = true

        setVibrate(true)
        setVibrateIntensity(30)

        FirebaseAnalytics.getInstance(this).logEvent(FirebaseAnalytics.Event.TUTORIAL_BEGIN, Bundle())
    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        finishIntro()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        finishIntro()
    }

    private fun finishIntro() {
        persistenceManager.isFirstStart = false
        FirebaseAnalytics.getInstance(this).logEvent(FirebaseAnalytics.Event.TUTORIAL_COMPLETE, Bundle())
        finish()
    }

}