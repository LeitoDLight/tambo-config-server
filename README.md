# tambo-config-server

Servidor de **configuración centralizada** (Spring Cloud Config) de Tambo Market.

| Dato | Valor |
|---|---|
| Puerto | 8888 |
| Tecnología | Java 21, Spring Boot 4.1.1, Spring Cloud 2025.1.1, `@EnableConfigServer` |
| Responsable | Leonardo Dorregaray |

## Qué hace

Entrega a los 4 microservicios, al arrancar, la configuración que antes estaba repetida en cada uno (por ejemplo, el secreto JWT estaba escrito 4 veces). Usa el perfil `native`: lee los archivos de `src/main/resources/config/`.

| Archivo | Contenido |
|---|---|
| `application.yaml` | Compartido por todos: usuario y clave de la base de datos, credenciales de RabbitMQ, secreto JWT |
| `auth-service.yaml` | Vigencia del token JWT (120 minutos) |
| `ventas-service.yaml` | Tiempos de espera del cliente Feign hacia catálogo |

## Comprobar que funciona

```
http://localhost:8888/auth-service/default
http://localhost:8888/ventas-service/default
```

## Cómo lo usan los servicios

Cada servicio incluye `spring-cloud-starter-config` y declara `spring.config.import`. En Docker Compose, el config-server arranca primero y los demás esperan a que esté `healthy`.

Lo que depende del entorno (host de base de datos, host de RabbitMQ, URL del catálogo) **no** se centralizó: entra por variables de entorno de Docker Compose.

## Proyecto completo

Este repositorio es **un microservicio de Tambo Market**. El proyecto completo (todos los servicios, `docker-compose.yml`, colección de Postman, informe y el historial de trabajo del equipo) está en el repositorio de integración, que es privado y tiene acceso concedido al docente:

https://github.com/LeitoDLight/tambo-market

Para levantar todo el sistema:

```
git clone https://github.com/LeitoDLight/tambo-market.git
cd tambo-market
docker compose up -d --build
```

Luego abrir http://localhost (usuario `admin` / `Admin123`).

## Equipo

Leonardo Fabricio Dorregaray Guevara · José Miguel Yataco Quispe · Alberto Muzaurieta Hidalgo · Joselin Carhuapoma Poma

Curso: Desarrollo de Aplicaciones Web II — Cibertec.