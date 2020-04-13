
package prscx.whatsnew;

import android.content.Intent;
import android.graphics.Color;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

import java.util.ArrayList;
import java.util.List;

import io.github.tonnyl.whatsnew.WhatsNew;
import io.github.tonnyl.whatsnew.item.WhatsNewItem;
import io.github.tonnyl.whatsnew.util.PresentationOption;

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
  public void Show(final ReadableMap props, final Callback onDone, final Callback onCancel) {
    String title = props.getString("title");
    ReadableArray items = props.getArray("items");

    List<WhatsNewItem> whatsNewItems = new ArrayList<WhatsNewItem>();
    for (int i = 0; i < items.size(); i++) {
      ReadableMap item = items.getMap(i);

      whatsNewItems.add(new WhatsNewItem(item.getString("title"), item.getString("subtitle"), WhatsNewItem.NO_IMAGE_RES_ID));
    }

    WhatsNew whatsNew = WhatsNew.newInstance(whatsNewItems);

    whatsNew.setTitleText(title);

    whatsNew.setButtonTextColor(Color.parseColor("#ffffff"));
    whatsNew.setButtonBackground(Color.parseColor("#2777ae"));

    whatsNew.setPresentationOption(PresentationOption.DEBUG);
    whatsNew.presentAutomatically((AppCompatActivity) getCurrentActivity());
  }
}