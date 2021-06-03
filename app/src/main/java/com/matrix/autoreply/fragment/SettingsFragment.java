package com.matrix.autoreply.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreference;

import com.matrix.autoreply.R;
import com.matrix.autoreply.activity.MainActivity;

public class SettingsFragment extends PreferenceFragmentCompat {
//    private ListPreference languagePref;
    private SwitchPreference showNotificationPref;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.fragment_settings, rootKey);

//        languagePref = findPreference(getString(R.string.key_pref_app_language));
//        languagePref.setOnPreferenceChangeListener((preference, newValue) -> {
//            String thisLangStr = PreferencesManager.getPreferencesInstance(getActivity()).getSelectedLanguageStr(null);
//            if(thisLangStr == null || !thisLangStr.equals(newValue)){
//                //switch app language here
//                //Should restart the app for language change to take into account
//                restartApp();
//            }
//            return true;
//        });

        showNotificationPref = findPreference(getString(R.string.pref_show_notification_replied_msg));
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.M) {
            showNotificationPref.setTitle(getString(R.string.show_notification_label) + "(Beta)");
        }
    }

    private void restartApp() {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        getActivity().startActivity(intent);
        getActivity().finishAffinity();
    }
}
