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

* url-tvg - URL for EPG in JTV (zip) or XMLTV (xml, gz) format. Several URLs may be specified separated by comma (',')
* group-title - Title for channels group
* tvg-logo - Channel logo name (from internal database) or URL to the image that will be used as channel logo
* tvg-name - Name of the channel from EPG, should be equal to the value of "display-name" tag in XMLTV
* tvg-id - XMLTV channel id. When both tvg-id and tvg-name are specified for the same channel, tvg-id will be used.
* tvg-shift - Shift in hours for EPG

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
