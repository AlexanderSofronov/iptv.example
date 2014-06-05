IPTV Client Example
============

Example of a custom configured IPTV Android app based on [IPTV Core][1] app.

About
--------

Finctionality of this app is quite similar to [IPTV][2] app, but this app is easier to use for the end users because it doesn't require any complicated settings.

Features similar to IPTV:
 * M3U and XSPF playlists support
 * Grid or list view of TV channels
 * EPG support in JTV format

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
