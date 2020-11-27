package ui;



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
        System.out.print("WORKLOG: Container.setPlatform\n");
        this.platform = platform;
    }

    // Отдает платформу, записанную в контейнер
    public Platform getPlatform(){
        System.out.print("WORKLOG: Container.getPlatform\n");
        return platform;
    }

    // Получает Singleton контейнера и запускает записанную в него платформу
    public void runPlatform(Platform platform) {
        Container container = Container.getInstance();
        container.setPlatform(platform);
        container.getPlatform().runDriver();
        System.out.print("WORKLOG: Container.runPlatform\n");
    }
}
