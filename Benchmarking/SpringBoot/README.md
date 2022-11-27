# API with Spring Boot 3

Simple back-end Java RESTful API using Spring Boot that connects with a PostgreSQL database via JPA.

## Run App

Run the application with command: `mvn spring-boot:run`

## Observability

https://spring.io/blog/2022/10/12/observability-with-spring-boot-3
https://www.baeldung.com/micrometer

We will get insights into the application using Micrometer, a library for collecting metrics.

We will use Prometheus instead of Spring Boot Actuator and Grafana instead of Spring Boot Admin.

Metrics are collected from and held in a Meter Registry. The registry implementation can be
registered in a monitoring system such as Atlas, Inflix or Prometheus.

[Micrometer Tracing](https://micrometer.io/docs/tracing) is for efficiently recording application metrics with
Micrometer,
and implementing tracing through providers, such as OpenZipkin or OpenTelemetry.
