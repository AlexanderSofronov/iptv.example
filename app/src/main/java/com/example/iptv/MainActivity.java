/*
 * Copyright (C) 2014 Alexander Sofronov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.iptv;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

public class MainActivity
    extends Activity
{
    @Override
    protected void onStart()
    {
        super.onStart();
        
        try {
            Intent intent = new Intent();
            intent.setClassName(_IPTV_CORE_PACKAGE_NAME, _IPTV_CORE_CLASS_NAME);

            // Set your playlist url and uncomment the lines below   
            // String playlistUrl = "<PLAYLIST URL>";
            // intent.setData(Uri.parse(playlistUrl));
            
            // If "package" extra is set, IPTV Core will be able to show your app name as a title
            intent.putExtra("package", getPackageName());
            
            // EPG URL can be set either by "url-tvg" parameter in your playlist or by the following extra (supported since IPTV Core 3.3)
            // intent.putExtra("url-tvg", "<EPG URL>");

            startActivity(intent);
            finish();
        } catch (ActivityNotFoundException e) {
            // IPTV core app is not installed, let's ask the user to install it.
            showIptvCoreNotFoundDialog();
        }
    }
    
    public void showIptvCoreNotFoundDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.dialog_core_not_installed_title);
        builder.setMessage(R.string.dialog_core_not_installed_message);
        builder.setPositiveButton(R.string.dialog_button_install,
            new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int id)
                {
                    try {
                        // try to open Google Play app first 
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + _IPTV_CORE_PACKAGE_NAME)));
                    } catch (ActivityNotFoundException e) {
                        // if Google Play is not found for some reason, let's open browser
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + _IPTV_CORE_PACKAGE_NAME)));
                    }
                }
            });
        builder.setNegativeButton(R.string.dialog_button_cancel,
            new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int id)
                {
                    // if cancelled - just close the app
                    finish();
                }
            });
        builder.setCancelable(false);
        builder.create().show();
    }

    
    private static final String _IPTV_CORE_PACKAGE_NAME = "ru.iptvremote.android.iptv.core";
    private static final String _IPTV_CORE_CLASS_NAME = _IPTV_CORE_PACKAGE_NAME + ".ChannelsActivity";
}
