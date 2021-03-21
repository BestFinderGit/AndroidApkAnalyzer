package sk.styk.martin.apkanalyzer.util.components

import android.os.Parcelable
import androidx.fragment.app.DialogFragment
import kotlinx.android.parcel.Parcelize
import sk.styk.martin.apkanalyzer.ui.activity.dialog.SimpleTextDialog
import sk.styk.martin.apkanalyzer.util.TextInfo

@Parcelize
data class DialogComponent(
        val title: TextInfo,
        val message: TextInfo,
        val positiveButtonText: TextInfo? = null,
        val negativeButtonText: TextInfo? = null,
) : Parcelable

fun DialogComponent.toDialog(): DialogFragment = SimpleTextDialog.newInstance(this)
