IPTV Client Example
============

Example of a custom configured IPTV Android app based on [IPTV Core][1] app.

About
--------

Finctionality of this app is quite similar to [IPTV][2] app, but this app is easier to use for the end users because it doesn't require any complicated settings.

Features similar to IPTV:
 * M3U and XSPF playlists support
 * Grid or list view of TV channels
 * EPG support in JTV (zip) or XMLTV (xml, gz) formats

Differences with IPTV:
 * Single playlist is used, users can't add custom playlists
 * No UDP proxy settings

Building custom IPTV app
--------

To build you custom IPTV app you can do one of the following:
 * Clone iptv.example project, change app name, launcher icon, and package name.
 * Create new Android project with empty activity and use the code from MainActivity.java

You will also need to set custom playlist URL in MainActivity.onStart().

If you're are new in Android development, you can find some useful tutorials [here][3].

Supported playlists formats
--------
IPTV Core app supports M3U and XSPF playlist formats. Additionally to standard M3U file format it supports extended M3U playlists with custom attrubutes.

Here is an example of extended M3U playlist:

    #EXTM3U url-tvg="http://www.teleguide.info/download/new3/xmltv.xml.gz"
    #EXTINF:-1 group-title="Science", Discovery
    http://example.com/channel1
    #EXTINF:-1 group-title="Sport", Eurosport
    http://example.com/channel2
    #EXTINF:-1 tvg-logo="Eurosport" tvg-name="Eurosport" tvg-shift="+1",Eurosport +1
    http://example.com/channel3
    #EXTINF:-1 group-title="Custom" tvg-logo="https://cdn1.iconfinder.com/data/icons/Primo_Icons/PNG/128x128/video.png",My Custom channel
    http://example.com/channel4

* url-tvg - URL for EPG in JTV (zip) or XMLTV (xml, gz) format. Several URLs may be specified separated by comma
* group-title - Title for channels group
* tvg-logo - Channel logo name (from internal database) or URL to the image that will be used as channel logo
* tvg-name - Name of the channel from EPG, should be equal to the value of "display-name" tag in XMLTV
* tvg-id - XMLTV channel id. When both tvg-id and tvg-name are specified for the same channel, tvg-id will be used.
* tvg-shift - Shift in hours for EPG

Intent API
--------
Intent API which is used for launching IPTV Core from third-party package (launcher app)

    Data:
        Playlist URL
        
    Extras (optional):
        package
            Type: String
            Example: intent.putExtra("package", getPackageName());
            
            "package" extra is used for sending package name of your app to IPTV Core. If this extra is set, 
            IPTV Core will be able to show your app name as a title
            
        url-tvg (Since IPTV Core 3.3)
            Type: String
            Example: intent.putExtra("url-tvg", "<Your EPG URL>");
            
            EPG URL can be set either by "url-tvg" parameter in your playlist or by "url-tvg" extra
            
        http_connect_timeout
            Type: int
            Example: intent.putExtra("http_connect_timeout", 30 * 1000); // Set http connect timeout to 30 seconds
            
            Http connect timeout for loading playlist and EPG (not video streams)
        
        http_read_timeout
            Type: int
            Example: intent.putExtra("http_read_timeout", 30 * 1000); // Set http read timeout to 30 seconds
            
            Http read timeout for loading playlist and EPG (not video streams)
            
        http_user_agent (Since IPTV Core 3.3.1)
            Type: String
            Example: intent.putExtra("http_user_agent", "<Custom user agent>")
            
            Custom value for "User-Agent" http request property which is used for loading playlist and EPG (not video streams)
            
        preferred_player_package (Since IPTV Core 3.3.2)
            Type: String
            Example: intent.putExtra("preferred_player_package", "org.videolan.vlc"); // Set VLC as preferrred video player
            
            Preferred video player should be one of the supported players that can be found in IPTV Core settings.
            At the first launch the app will check if one of supported players is installed. 
            When no supported players found, the user will be forced to install the preferred video player.
            By default, the app uses MX Player as preferred player.

        hide_all_channels_tab (Since IPTV Core 3.9.4)
            Type: boolean
            Example: intent.putExtra("hide_all_channels_tab", true);
            
            Option to hide "All Channels" tab. This option works only when you have categories in your playlist.

License
--------

    Copyright (C) 2014 Alexander Sofronov

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
 
 [1]:http://play.google.com/store/apps/details?id=ru.iptvremote.android.iptv.core
 [2]:http://play.google.com/store/apps/details?id=ru.iptvremote.android.iptv
 [3]:http://developer.android.com/training/index.html
