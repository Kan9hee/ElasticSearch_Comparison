## 개발 환경
- Springboot, Spring JPA
- Kotlin
- QueryDSL, JUnit5
- Mysql, Elasticsearch

## Data Table


## 검색 조건
name에 "여행"을 포함하는 모든 데이터 검색

## 비교 결과
||RDBMS Like 구문|QueryDSL Like 구문|Elasticsearch|
|---|:-:|:-:|:-:|
|1만건|113 ms|523 ms|151 ms|
|10만건|169 ms|592 ms|156 ms|
|52만건|430 ms|784 ms|172 ms|

## 데이터 출처
- https://www.data.go.kr/data/3071094/fileData.do
