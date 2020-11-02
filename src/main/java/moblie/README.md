# ВASE INFO
Используемый стек:
* Appium (http://appium.io)
* Selenide (https://ru.selenide.org)
* Java
* JUnit (https://junit.org/junit5/)
* Allure (http://allure.qatools.ru)

# QUICK SETUP & START
1. Открыть src\test\kotlin\MobileExample\Setup\AppiumSetup
2. Заполнить поля: 
* appPackage (Пакет тестируемого приложения)
* appMainActivity (MainActivity тестируемого приложения)
* PLATFORM_VERSION (Версия ОС тестового девайса)
* localApp (Название apk приложения)
* appPath (Путь до apk)
3. Запустить Appium
* Нажать на Start expection session
* Создать и сохранить новый Desired capabilites со следующими полями (Заполнить так же как во 2 шаге):
* "platformName": "Android",
* "deviceName": "Android",
* "platformVersion": "",
* "appPackage": "",
* "appActivity": ""
* Запустить сессию