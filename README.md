# Backend движок форума
## Организация Эндпойнтов REST API пользователей
*/api/v1 - корневой путь*

___

**GET /topic** - получить страницу топиков. Регулировать возвращаемую страницу можно с помощью @RequestParam offset *(default=0)* и limit *(default=10)*

**POST /topic** - создать топик

___

**GET /topic/{topicId}/massages** - получить страницу сообщений в указанном топике. Регулировать возвращаемую страницу можно с помощью @RequestParam offset *(default=0)* и limit *(default=10)*

**POST /topic/{topicId}/massages** - создать сообщение в указанном топике

**PUT /topic/{topicId}/massages/{massageId}** - редактировать сообщение с указанным massageId, если оно принадлежит пользователю

**DELETE /topic/{topicId}/massages/{massageId}** - удалить сообщение с указанным massageId, если оно принадлежит пользователю

## Организация Эндпойнтов REST API администратора
*/admin/api/v1 - корневой путь*
___
**GET /topic** - получить страницу топиков. Регулировать возвращаемую страницу можно с помощью @RequestParam offset *(default=0)* и limit *(default=10)*

**PUT /topic** - изменить топик, указанный в @RequestBody

**DELETE /topic/{topicId}** - удалить топик с указанным topicId
___
**DELETE /topic/{topicId}/massages/{massageId}** - удалить сообщение с указанным massageId

**PUT /topic/{topicId}/massages** - редактировать сообщение

**GET /topic/{topicId}/massages** - получить страницу сообщений, в указанном топике
___
## Аутентификация
### Сгенерированные изначально пользователи
    username = Тимур, password = password
    username = Ваня, password = password
    username = Петя, password = password
    username = Асим, password = password
    username = Влад, password = password
### Admin
    username = admin, password = admin
