package pro.kuzdowicz.autoreply.ui.activity.settings

import android.os.Bundle
import pro.kuzdowicz.autoreply.R
import pro.kuzdowicz.autoreply.ui.activity.BaseActivity

class SettingsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        window.statusBarColor = resources.getColor(R.color.colorPrimary)
    }
}