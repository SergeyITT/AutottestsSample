# ВASE INFO
#### Используемый стек:
* **Appium** (http://appium.io)
* **Selenide** (https://ru.selenide.org)
* **Java** (https://www.oracle.com/ru/java/technologies/javase-downloads.html)
* **Cucumber** (https://cucumber.io)
* **Allure** (http://allure.qatools.ru)

# QUICK SETUP & START

#### PART 1: Подготовка к запуску тестов
1. Установить **Appium desktop** _https://github.com/appium/appium-desktop/releases/_
2. Установить **Android Studio** (ради **adb** и **sdk**. **Sdk** так же можно установить из под **IDE**, главное - найти путь до него в системе)
3. Прописать переменные среды:
    1. Открыть: **Этот компьютер -> Свойства -> Дополнительные параметры системы -> Переменные среды**
    2. В системыне переменные добавить **ANDROID_HOME** и прописать путь до **SDK** (Пример: ***C:\Users\user\AppData\Local\Android\Sdk***)
    3. В сестемные переменные добавить **JAVA_HOME** и прописать путь до **JDK** (Пример: ***C:\Program Files\Java\jdk1.8.0_241***)
    4. В системных переменных открыть **Path** и добавить следующие строки: 
        1. **%ANDROID_HOME%**
        2. **%ANDROID_HOME%\tools**
        3. **%ANDROID_HOME%\tools\bin**
        4. **%ANDROID_HOME%\platform-tools**
        5. **%JAVA_HOME%**
4. Проверить что **adb** работает: для этого открыть **cmd** и выполнить команду **"adb"** - должно появиться много текста
5. Запустить **Appium server**
6. Проверить что **Appium** видит переменные среды: После запуска приложения не запуская сам сервер нажать на **Adviced**, затем
на **Edit configurations**. В открывшемся окне должны быть прописаны правильные пути **ANDROID_HOME** и **JAVA_HOME**
7. Если будете запускать тесты на реальном девайсе, то просто подключите его проводом USB к пк, если нужен эмулятор, то:
    1. Запустить **Android Studio**
    2. Открыть **AVD manader**
    3. Создать любой эмулятор с простым названием (Пример спеков: Pixel 3a x86 + play market)
    4. Закрыть **Android studio**
    5. Открыть **cmd** и выполнить команду **emulator -avd pixel_api29** (Где **pixel_api29** - название ранее созданного эмулятора)
    6. Запускать эмулятор можно из **Android studio** или командой **cmd** (Сама **Android Studio** для работы эмулятора не нужна)
    

#### PART 2: Запуск тестов

1. Установить и запустить **Appium server**
2. Нажать на **Start expector session** (Кнопка с лупой)
3. Создать и сохранить новый **Desired capabilites** со следующими полями:
    * **"platformName": "Android"**,
    * **"deviceName": "Android"**,
    * **"platformVersion": "<Версия Android тестового девайса>"**,
    * **"appPackage": "<Пакет тестируемого приложения>"**, (Можно узнать установив приложение **Package Name** из Play market)
    * **"appActivity": "<MainActivity тестируемого приложения>"** (Можно узнать установив приложение **Package Name** из Play market)
4. Установить тестовое приложение на девайс и запустить сессию 
(Если все сделано правильно, то должно запуститься приложение, в **Appium** откроется интерфейс инспектора элементов. 
Здесь можно смотреть **xpath** и др. параметрны элементов UI для тестирования)
5. Завершить сессию и закрыть инспектор
6. Скачать фреймворк, запустить **IDE** и открыть ***\AutottestsSample\src\main\java\moblie\AppiumSetup.java***
7. Заполнить поля: 
    * **APP_PACKAGE** (Пакет тестируемого приложения)
    * **APP_MAIN_ACTIVITY** (**MainActivity** тестируемого приложения)
    * **PLATFORM_VERSION** (Версия ОС тестового девайса, по умолчанию - **10.0**)
    * **APPIUM_VERSION** (Версия **Appium desktop**)
8. **apk** тестового приложения переименовать в **test.apk** и кинуть на Рабочий стол (По умолчанию фрейм будет запускать **test.apk**
с рабочего столя Пользователя, настроить можно тут: ***\AutottestsSample\src\test\java\steps\MyStepDefsMobile.java*** - **String pathToApp**)
9. Запустить файл **RunTest** (Правой кнопкой -> Run) (Должно запуститься приложение, **Appium** попытается несколько раз проскролить экран вправо. 
Чтобы это увидеть, можно включить отображение нажатий в меню "Для разработчиков" на девайсе)

# Structure
#### Comming soon!
# Write practice
#### Comming soon!