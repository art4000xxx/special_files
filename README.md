# Домашнее задание: CSV, XML, JSON парсеры

Этот проект содержит реализацию трех задач по обработке данных:

1.  **CSV в JSON:**  Преобразование данных из CSV файла (`data.csv`) в JSON формат и сохранение в файл (`data.json`).
2.  **XML в JSON:**  Преобразование данных из XML файла (`data.xml`) в JSON формат и сохранение в файл (`data2.json`).
3.  **JSON в Java:**  Чтение данных из JSON файла (`new_data.json`), парсинг в Java объекты класса `Employee` и вывод информации о сотрудниках в консоль.

## Структура проекта

*   `src/main/java/org/example/`
    *   `Main.java`:  Основной класс, содержащий реализацию всех задач.
    *   `Employee.java`:  Класс, представляющий информацию о сотруднике.
*   `data.csv`:  CSV файл с данными для первой задачи.
*   `data.xml`:  XML файл с данными для второй задачи.
*   `new_data.json`:  JSON файл с данными для третьей задачи.
*   `data2.json`:  JSON файл, создаваемый в результате выполнения второй задачи.
*   `build.gradle.kts`:  Файл конфигурации Gradle.
*   `settings.gradle.kts`:  Файл настроек Gradle.
*   `gradlew`, `gradlew.bat`:  Скрипты Gradle Wrapper для запуска проекта без необходимости установки Gradle.
*   `gradle/wrapper/gradle-wrapper.jar`, `gradle/wrapper/gradle-wrapper.properties`:  Файлы Gradle Wrapper.
*   `.gitignore`:  Файл, содержащий список исключений для системы контроля версий Git.

## Зависимости

Проект использует следующие библиотеки:

*   `com.opencsv:opencsv`
*   `com.googlecode.json-simple:json-simple`
*   `com.google.code.gson:gson`
    *   `javax.xml.bind:jaxb-api`
    *   `com.sun.xml.bind:jaxb-impl`
    *   `com.sun.xml.bind:jaxb-core`

## Сборка и запуск

1.  Клонируйте репозиторий.
2.  Убедитесь, что у вас установлен Java Development Kit (JDK).
3.  Используйте Gradle Wrapper для сборки и запуска проекта:

    ```bash
    ./gradlew run  # (Linux/macOS)
    gradlew.bat run # (Windows)
    ```

## Результат

После запуска программы будут выполнены все три задачи.  Результат выполнения третьей задачи (вывод информации о сотрудниках из JSON файла) будет отображен в консоли. Файлы `data.json` и `data2.json` будут созданы в корневой директории проекта.
