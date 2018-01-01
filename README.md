# Hotel hero

Simple project with Spring and Jetty (works without servlet-container)

### Requirement

1. Java 1.8

### Environment variables

| Variable name | Default value | Description |
| ------ | ------ | ------ | 
| /teleportbuyersvc/config/scoring.api.url | https://scoring-stage.devim.team:9999 | ссылка на API сервиса обработки заявок



| Key | Default value | Description |
| ------ | ------ | ------ | 
| DREBEDENGI__WSDL_LOCATION | --- | ссылка на API сервиса обработки заявок
| DREBEDENGI__LOGIN         | https://scoring-stage.devim.team:9999         | ссылка на API сервиса обработки заявок
| DREBEDENGI__PASSWORD      | https://scoring-stage.devim.team:9999         | ссылка на API сервиса обработки заявок
| HOTEL_HERO__VKONTAKTE_TOKEN     | https://scoring-stage.devim.team:9999         | ссылка на API сервиса обработки заявок
| /teleportbuyersvc/config/scoring.api.token   |                                               | токен для API сервиса обработки заявок
| /teleportbuyersvc/db/host        | localhost     | хост
| /teleportbuyersvc/db/port        | 25432         | порт
| /teleportbuyersvc/db/username    | root          | имя пользователя сервера СУБД
| /teleportbuyersvc/db/password    | keepitsimple  | пароль пользователя СУБД
| /teleportbuyersvc/db/database    | teleportbuyersvc     | название базы в СУБД    
| /teleportbuyersvc/gate/secret    |      | секретный ключ для отправки постбеков  

### Useful links

* [jaxws-based WSDL generator for Java](http://www.hascode.com/2010/04/create-a-soap-client-using-the-jax-ws-maven-plugin/)