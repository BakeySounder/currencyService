# Currency Service

## Описание
Currency Service - это RESTful API для работы с транзакциями, лимитами и курсами валют. Этот проект реализован с использованием Java и Spring Boot, и использует PostgreSQL в качестве базы данных.

## Требования
- Java 11 или выше
- PostgreSQL
- Gradle

## Установка

### Клонирование репозитория
```bash
git clone https://github.com/yourusername/currency-service.git
cd currency-service
```

### Настройка базы данных
1. Убедитесь, что PostgreSQL установлен и запущен.
2. Создайте новую базу данных:
   ```sql
   CREATE DATABASE currency_service;
   ```
3. Обновите файл `src/main/resources/application.properties` с вашими данными для подключения к базе данных:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/currency_service
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

### Сборка проекта
Соберите проект с помощью Gradle:
```bash
./gradlew build
```

### Запуск приложения
Запустите приложение:
```bash
./gradlew bootRun
```

## Использование API
### Эндпоинты
- **POST /transactions**: Создание новой транзакции.
- **GET /limits**: Получение информации о лимитах.
- **GET /exchange-rates**: Получение текущих курсов валют.

### Примеры запросов
#### Создание транзакции
```bash
curl -X POST http://localhost:8080/transactions -H "Content-Type: application/json" -d '{
    "amount": 100,
    "currency": "USD"
}'
```

#### Получение лимитов
```bash
curl -X GET http://localhost:8080/limits
```

#### Получение курсов валют
```bash
curl -X GET http://localhost:8080/exchange-rates
```

## Тестирование
Для запуска тестов выполните:
```bash
./gradlew test
```

## Лицензия
Этот проект лицензирован под MIT License. См. файл [LICENSE](LICENSE) для подробностей.

## Контрибьюторы
Если вы хотите внести свой вклад в проект, пожалуйста, создайте Pull Request. Все предложения приветствуются!
```

### Замечания
- Замените `yourusername` в URL репозитория на ваше имя пользователя GitHub.
- Убедитесь, что все команды соответствуют вашей проектной структуре.

Если нужны дополнительные изменения или улучшения, дайте знать!
