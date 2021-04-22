# Service Discovery Client (Order Service)
- - -
## 소프트웨어 구성
1. OpenJDK 11
2. Spring Boot 2.4.5
3. Spring Web
4. Netflix-Eureka-Client
5. Spring Boot DevTools
6. Spring Data Jpa
7. H2 Database
8. org.modelmapper 2.3.8
- - -
- Netflix Eureka Client Setting
- - -
Build
 * IDE VM 옵션 Build
> - -Dserver.port=9002
 * Maven Build
> - mvn spring-boot:run -Dspring-boot.run.jvmArguments='-Dserver.port={port}'
> - mvn spring-boot:run (port random)
 * Maven Package After jar Build
> - mvn clean
> - mvn compile package
> - java -jar -Dserver.port={port} ./target/user-service-0.1.jar
- - -
## Order Service  
### 주문 API

- 주문 등록
<pre>
  POST /order-service/{userId}/orders
  {
      "productId": "CATALOG-001",
      "qty": 10,
      "unitPrice": 10000
  }
</pre>
- 주문 조회
<pre>
  GET /order-service/{userId}/orders
</pre>