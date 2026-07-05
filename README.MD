###
eureka url:
http://localhost:10086/

user url:
http://localhost:8080/user/1

order url:
http://localhost:9090/order/101

gateWay url:
http://localhost:10010/order/101?authorization=admin

postman request POST 'http://localhost:10010/ficc/prodAssetValu/queryList' \
--header 'Authorization: Bearer eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJ1c2VyLTA' \
--header 'Content-Type: application/json' \
--body '{
"pageNum": 1,
"pageSize": 15,
"secuAccname": "华润",
"startDate": "2025-01-01",
"endDate": "2026-06-12"
}'

swagger url：
http://localhost:9089/swagger-ui.html