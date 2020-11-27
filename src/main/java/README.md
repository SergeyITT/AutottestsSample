# ВASE INFO
#### Используемый стек:
* **Appium** (http://appium.io)
* **Selenide** (https://ru.selenide.org)
* **Java** (https://www.oracle.com/ru/java/technologies/javase-downloads.html)
* **Cucumber** (https://cucumber.io)
* **Maven** (https://maven.apache.org/download.cgi)
* **Allure** (http://allure.qatools.ru)

# QUICK SETUP & START

#### PART 1: Подготовка к запуску Appium тестов
1. Установить **Appium desktop** _https://github.com/appium/appium-desktop/releases/_
2. Установить **Android Studio** _https://developer.android.com/studio_ (Нам нужны **adb** и **sdk**. **Sdk** так же можно установить из под **IDE**, главное - найти путь до него в системе)
3. Установить **Maven** _https://maven.apache.org/download.cgi_ (Binary zip archive)
3. Прописать переменные среды:
    * Открыть: **Этот компьютер -> Свойства -> Дополнительные параметры системы -> Переменные среды**
    * В системыне переменные добавить **ANDROID_HOME** и прописать путь до **SDK** (Пример: ***C:\Users\user\AppData\Local\Android\Sdk***)
    * В сестемные переменные добавить **JAVA_HOME** и прописать путь до **JDK** (Пример: ***C:\Program Files\Java\jdk1.8.0_241***)
    * В сестемные переменные добавить **M2_HOME** и прописать путь до папки с распакованным **Maven** (Пример: ***C:\Program Files\Java\jdk1.8.0_241***)
    * В системных переменных открыть **Path** и добавить следующие строки: 
        * **%ANDROID_HOME%**
        * **%ANDROID_HOME%\tools**
        * **%ANDROID_HOME%\tools\bin**
        * **%ANDROID_HOME%\platform-tools**
        * **%JAVA_HOME%**
        * **%M2_HOME%**
        * **%M2_HOME%\bin**
4. Проверить что **adb** работает: для этого открыть **cmd** и выполнить команду **"adb"** - должно появиться много текста
5. Проверить что **maven** работает: для этого открыть **cmd** и выполнить команду **"mvn -version"**
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
    

#### PART 2: Запуск Appium тестов

1. Запустить **Appium server**
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
6. Скачать фреймворк, запустить **IDE** и открыть ***\AutottestsSample\src\main\java\ui\Config.java***
7. Заполнить поля: 
    * **ANDROID_APP_PACKAGE** (Пакет тестируемого приложения)
    * **ANDROID_APP_MAIN_ACTIVITY** (**MainActivity** тестируемого приложения)
    * **PLATFORM_VERSION** (Версия ОС тестового девайса, по умолчанию - **10.0**)
    * **APPIUM_VERSION** (Версия **Appium desktop**)
    * **PLATFORM** (Тестируемая платформа. Прим.: **Android**)
8. **apk** тестового приложения переименовать в **test.apk** и кинуть на Рабочий стол (По умолчанию фрейм будет запускать **test.apk**
с рабочего стола Пользователя
9. Запустить файл **RunTest** (Правой кнопкой -> Run) (Должно запуститься приложение, **Appium** попытается несколько раз проскролить экран вправо. 
Чтобы это увидеть, можно включить отображение нажатий в меню "Для разработчиков" на девайсе)

# Structure
#### Comming soon!
# Write practice
#### Comming soon!