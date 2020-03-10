
#import "RNWhatsNew.h"

@implementation RNWhatsNew

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(Show:(nonnull NSDictionary *)props onDone:(RCTResponseSenderBlock)onDone onCancel:(RCTResponseSenderBlock)onCancel) {

    dispatch_async(dispatch_get_main_queue(), ^{
        id<UIApplicationDelegate> app = [[UIApplication sharedApplication] delegate];
        UINavigationController *rootViewController = ((UINavigationController*) app.window.rootViewController);

        NSArray *items = [props objectForKey: @"items"];
        NSMutableArray *newItems = [[NSMutableArray alloc] init];
        
        for (NSDictionary *item in items) {
            NSMutableDictionary *newItem = [[NSMutableDictionary alloc] initWithDictionary: item];

            NSDictionary *icon = [newItem objectForKey: @"icon"];
            if (icon == nil || [icon count] == 0) {
                [newItems addObject: newItem];
                continue;
            }

            UIImage *image = [RNImageHelper GenerateImage: icon];
            if (image != nil) {
                [newItem setObject:image forKey: @"icon"];
            }
            
            [newItems addObject: newItem];
        }

        NSMutableDictionary *newProps = [[NSMutableDictionary alloc] initWithDictionary: props];
        [newProps setObject:newItems forKey:@"items"];
        
        [WhatsNewBridge showFrom:rootViewController props: newProps];
    });
}


@end
