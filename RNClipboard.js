'use strict';

var RNClipboard = require('react-native').NativeModules.RNClipboard;

var Clipboard = {
    get(callback) {
        RNClipboard.get(callback)
    },

    set(content) {
        RNClipboard.set(content);
    }
};

module.exports = Clipboard;
