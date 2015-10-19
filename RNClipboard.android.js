'use strict';

var RNClipboard = require('NativeModules').ClipboardAndroid;

var Clipboard = {
    get(callback) {
        RNClipboard.get(callback)
    },

    set(content) {
        RNClipboard.set(content);
    }
};

module.exports = Clipboard;
