package ui;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

public class Container {
    Platform platform;

    //Singleton
    private static Container instance;
    private Container(){}
    public static Container getInstance(){
        if(instance == null){
            instance = new Container();
        }
        return instance;
    }

    // Инициализирует платформу контейнера необходимой платформой
    public void setPlatform(Platform platform){
        this.platform = platform;
    }

    // Отдает платформу, записанную в контейнер
    public Platform getPlatform(){
        return platform;
    }

    // Получает Singleton контейнера и запускает записанную в него платформу
    public void runPlatform(Platform platform) {
        Container container = Container.getInstance();
        container.setPlatform(platform);
        container.getPlatform().runDriver();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }
}
