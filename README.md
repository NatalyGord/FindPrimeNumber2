# Инструкция по запуску сервиса.

## 1. Для работы сервиса перед запуском необходимо создать новую базу PostgreSQL с именем PrimeNumber(возможно поменять имя базы данных в файле application.properties)
## 2. Если пункт 1 выполнен, то после запуска автоматически создастся таблица в БД.
## 3. Доступные действия:
###  - Получить меньшее простое число ближайшее к X, также внесение данных об этом простом числе в базу данных (GET "/{X}")
###  - Получить все данные из базы данных (GET "/primes")
###  - Получить Max простое число из БД (GET "/max")
