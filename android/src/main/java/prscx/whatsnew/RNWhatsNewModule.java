
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

import java.lang.reflect.Method;
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

    String titleColor = props.getString("titleColor");
    String itemTitleColor = props.getString("itemTitleColor");
    String itemSubtitleColor = props.getString("itemSubtitleColor");
    String buttonTextColor = props.getString("buttonTextColor");
    String buttonBackgroundColor = props.getString("buttonBackgroundColor");

    List<WhatsNewItem> whatsNewItems = new ArrayList<WhatsNewItem>();
    for (int i = 0; i < items.size(); i++) {
      ReadableMap item = items.getMap(i);
      ReadableMap icon = item.getMap("icon");

      int iconID = WhatsNewItem.NO_IMAGE_RES_ID;
      try {
        Class<?> clazz = Class.forName("prscx.imagehelper.RNImageHelperModule"); //Controller A or B
        Class params[] = {ReadableMap.class};
        Method method = clazz.getDeclaredMethod("GenerateImageID", params);

        iconID = (int) method.invoke(null, icon);
      } catch (Exception e) {
      }

      whatsNewItems.add(new WhatsNewItem(item.getString("title"), item.getString("subtitle"), iconID));
    }

    WhatsNew whatsNew = WhatsNew.newInstance(whatsNewItems);

    if (title.length() > 0) {
      whatsNew.setTitleText(title);
    }

    if (titleColor.length() > 0) {
      whatsNew.setButtonTextColor(Color.parseColor(titleColor));
    }
    if (itemTitleColor.length() > 0) {
      whatsNew.setButtonTextColor(Color.parseColor(itemTitleColor));
    }
    if (itemSubtitleColor.length() > 0) {
      whatsNew.setButtonTextColor(Color.parseColor(itemSubtitleColor));
    }
    if (buttonTextColor.length() > 0) {
      whatsNew.setButtonTextColor(Color.parseColor(buttonTextColor));
    }
    if (buttonBackgroundColor.length() > 0) {
      whatsNew.setButtonBackground(Color.parseColor(buttonBackgroundColor));
    }

    whatsNew.setPresentationOption(PresentationOption.DEBUG);
    whatsNew.presentAutomatically((AppCompatActivity) getCurrentActivity());
  }
}