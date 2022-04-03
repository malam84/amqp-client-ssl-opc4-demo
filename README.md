# amqp-client-ssl-opc4-demo
Create Configmap <br> 
oc create configmap amq-openshift-client-config --from-file=src/main/resources/application.properties <br>
Create Secrets <br>
oc create secret generic client-secret --from-file=client.ts <br>
Deploy template<br>
DeploymentConfig.yaml
