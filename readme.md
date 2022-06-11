> Проект запускается через Dockerfile (Docker должен быть установлен на компьютере).
### `Terminal`
- Создаем image с помощью команды => docker build `.` -t `<name custom image>`
- Запускаем наш `<name custom image>` с помощью команды docker run - p 8080:8080 `<name custom image>`


> Rest api endpoints:


#### https://openexchangerates.org/api/latest.json

- QueryParam 
  - app_id (Обязательный) Ключ приложения.
  - symbols (Не обязательный) по дефолту стоит RUB. Данный параметр задает типа валюты для определения курса к USD

- Description: Данный url возвращает объект usd Model который содержит курс запрашиваемой валюты на данный момент дня.
#### https://openexchangerates.org/api/historical/{date}

- PathVariable
  - date (Обязательный) данный параметр ставится по дефолту, отвечает за поиск курса валюты по дате.


- QueryParam 
  - app_id (Обязательный) Ключ приложения.
  - symbols (Не обязательный) по дефолту стоит RUB.

- Description: Данный url возвращает объект usd Model который содержит курс запрашиваемой валюты по определенному дню.

___

 `app_id от курса валют:` f149b4d3188d4cc58406422aa880564e