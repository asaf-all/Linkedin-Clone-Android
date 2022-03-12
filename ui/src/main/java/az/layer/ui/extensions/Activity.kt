package az.layer.ui.extensions

import android.app.Activity
import android.content.Context
import android.view.Window
import android.view.WindowManager
import androidx.core.content.ContextCompat


fun Activity.changeStatusBarColor(context: Context, color: Int) {

    val window: Window = this.window
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    window.statusBarColor = ContextCompat.getColor(context, color)
}