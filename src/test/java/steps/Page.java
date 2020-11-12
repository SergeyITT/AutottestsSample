package steps;

import com.codeborne.selenide.SelenideElement;
import ui.Config;

public interface Page {

    static int switchLocator() {
        int platformIndex = 0;

        switch (Config.getPlatformName()) {
            case ANDROID:
                platformIndex = 0;
            case IOS:
                platformIndex = 1;
            default:
                System.out.printf("ERROR: Undefined platform. Set Android as default platform");
        }
        return platformIndex;
    }
    static SelenideElement getCurrentLocator(SelenideElement Android, SelenideElement ios){
        SelenideElement[] array = {Android, ios};
        return array[Page.switchLocator()];
    }
}
