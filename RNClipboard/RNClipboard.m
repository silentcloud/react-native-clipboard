//
//  RNClipboard.m
//  RNClipboard
//
//  Created by silentcloud on 7/16/15.
//  Copyright (c) 2015 qiang.mou. All rights reserved.
//

#import "RNClipboard.h"

@import UIKit.UIPasteboard;

@implementation RNClipboard
RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(get:(RCTResponseSenderBlock)callback)
{
    UIPasteboard *pasteBoard = [UIPasteboard generalPasteboard];
    callback(@[pasteBoard.string ? pasteBoard.string : @""]);
}

RCT_EXPORT_METHOD(set:(NSString *)content)
{
    if (content) {
        UIPasteboard *pasteBoard = [UIPasteboard generalPasteboard];
        pasteBoard.string = content;
    }
}
@end
