package sk.styk.martin.apkanalyzer.dependencyinjection.activity.detail

import dagger.Module
import dagger.android.ContributesAndroidInjector
import sk.styk.martin.apkanalyzer.dependencyinjection.util.FragmentScope
import sk.styk.martin.apkanalyzer.ui.appdetail.AppDetailFragment
import sk.styk.martin.apkanalyzer.ui.appdetail.page.activity.AppActivityDetailFragment
import sk.styk.martin.apkanalyzer.ui.appdetail.page.certificate.AppCertificateDetailFragment
import sk.styk.martin.apkanalyzer.ui.appdetail.page.feature.AppFeatureDetailPageFragment
import sk.styk.martin.apkanalyzer.ui.appdetail.page.general.AppGeneralDetailFragment
import sk.styk.martin.apkanalyzer.ui.appdetail.page.provider.AppProviderDetailFragment
import sk.styk.martin.apkanalyzer.ui.appdetail.page.receiver.AppReceiverDetailFragment
import sk.styk.martin.apkanalyzer.ui.appdetail.page.resource.AppResourceDetailFragment
import sk.styk.martin.apkanalyzer.ui.appdetail.page.service.AppServiceDetailFragment
import sk.styk.martin.apkanalyzer.ui.appdetail.page.usedpermission.AppDefinedPermissionDetailFragment
import sk.styk.martin.apkanalyzer.ui.appdetail.page.usedpermission.AppUsedPermissionDetailFragment
import sk.styk.martin.apkanalyzer.ui.manifest.AndroidManifestFragment

@Module
abstract class AppDetailActivityCommonModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun appDetailFragmentInjector(): AppDetailFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun generalDetailFragmentInjector(): AppGeneralDetailFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun appCertificateDetailFragmentInjector(): AppCertificateDetailFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun appUsedPermissionDetailFragmentInjector(): AppUsedPermissionDetailFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun appActivityDetailFragmentInjector(): AppActivityDetailFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun appServiceDetailFragmentInjector(): AppServiceDetailFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun appProviderDetailFragmentInjector(): AppProviderDetailFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun appReceiverDetailFragmentInjector(): AppReceiverDetailFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun appFeatureDetailFragmentInjector(): AppFeatureDetailPageFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun appDefinedPermissionDetailFragmentInjector(): AppDefinedPermissionDetailFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun appResourceDetailFragmentInjector(): AppResourceDetailFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun androidManifestFragmentInjector(): AndroidManifestFragment

}