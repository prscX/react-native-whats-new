
#if __has_include("RCTBridgeModule.h")
#import "RCTBridgeModule.h"
#else
#import <React/RCTBridgeModule.h>
#endif

#import "WhatsNewKit/WhatsNewKit-Swift.h"
#import "RNImageHelper.h"

@interface RNWhatsNew : NSObject <RCTBridgeModule>

@end
