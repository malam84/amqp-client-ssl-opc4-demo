FROM java:11
EXPOSE 8088
ADD /target/amqp-client-ssl-opc4-demo.jar amqp-client-ssl-opc4-demo.jar
ENTRYPOINT ["java", "-jar", "amqp-client-ssl-opc4-demo.jar"]
