
package prscx.whatsnew;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableMap;

import io.github.tonnyl.whatsnew.WhatsNew;
import io.github.tonnyl.whatsnew.item.WhatsNewItem;

public class RNWhatsNewModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNWhatsNewModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNWhatsNew";
  }


  @ReactMethod
  public void Show(final int view, final ReadableMap props, final Callback onDone) {
    WhatsNew whatsnew = WhatsNew.newInstance(
            new WhatsNewItem("Nice Icons", "Completely customize colors, texts and icons.", WhatsNewItem.NO_IMAGE_RES_ID),
            new WhatsNewItem("Such Easy", "Setting this up only takes 2 lines of code, impressive you say?", WhatsNewItem.NO_IMAGE_RES_ID),
            new WhatsNewItem("Very Sleep", "It helps you get more sleep by writing less code.", WhatsNewItem.NO_IMAGE_RES_ID),
            new WhatsNewItem("Text Only", "No icons? Just go with plain text.", WhatsNewItem.NO_IMAGE_RES_ID)
    );//.presentAutomatically(this.getCurrentActivity());
  }
}