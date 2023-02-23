## 1. 소수점 반올림
```sql
SELECT ROUND(0.512) AS '반올림'
      ,ROUND(0.567, 2) AS '반올림 자릿수 설정'
      ,CEIL(0.1) AS '올림'
      ,FLOOR(0.911) AS '소수 모두 버림'
      ,TRUNCATE(0.21, 1) AS '소수 자리수까지 버림'
      ,ABS(-0.5) AS '절대값'
```

<img src="https://user-images.githubusercontent.com/50009240/220894760-8a44942b-4c10-4081-9a53-be3eebe23808.png">

## 2. 집계 함수
```
COUNT()
SUM()
AVG()
MIN()
MAX()
```
**1. COUNT**
* 테이블에 존재하는 데이터 갯수를 가져오고 싶을 때 사용하는 함수
* **전체 행의 갯수를 가져올 때는 null 값도 포함**하여 계산하지만, **특정 컬럼의 갯수를 가져올 때는 null 값은 제외**되어 계산된다.
```sql
<!-- 전체 행 갯수 가져오기 -->
SELECT COUNT(*) FROM 테이블;

<!-- 컬럼 데이터 갯수 가져오기 -->
SELECT COUNT(컬럼) FROM 테이블;
```
**2. SUM**
* 테이블에 존재하는 컬럼의 합을 구하고 싶을 때 사용하는 함수
* 컬럼의 타입이 숫자형인 경우에만 사용 가능
```sql
<!-- 컬럼의 합 구하기 -->
SELECT SUM(컬럼) FROM 테이블;
```
**3. AVG**
* 테이블에 존재하는 컬럼의 평균을 구하고 싶을 때 사용하는 함수 
* 컬럼의 타입이 숫자형인 경우에만 사용 가능하며, **null 값을 제외하여 계산**하는 점에 유의해야 한다.
* 만약 값이 null인 경우에도 포함하여 평균을 구하고 싶을 때는 **SUM 함수와 COUNT 함수를 혼합하여 사용**해야 한다.
```sql
<!-- 컬럼의 평균 구하기 -->
SELECT AVG(컬럼) FROM 테이블;

<!-- null인 경우도 포함하여 평균 구하기 -->
SELECT SUM(컬럼)/COUNT(*) FROM 테이블;
```
**4. MAX / MIN**
* 테이블에 존재하는 컬럼의 최댓값 또는 최솟값을 구하는 함수
* 컬럼의 타입이 숫자형인 경우에만 사용 가능
```sql
<!-- 컬럼의 최댓값 구하기 -->
SELECT MAX(컬럼) FROM 테이블;

<!-- 컬럼의 최솟값 구하기 -->
SELECT MIN(컬럼) FROM 테이블;
```

## 3. 날짜 포멧 함수
**1. DATE_FORMAT()**: 날짜 형식 설정 함수
```sql
DATE_FORMAT(date, format)

SELECT DATE_FORMAT(now(), '%Y-%m-%d');
>> 2022-06-17
```
## 4. 날짜 계산
```
DATE_ADD() : 날짜, 시간 더하기
DATE_SUB() : 날짜, 시간 빼기
DATEDIFF() : 두 기간 사이의 일수 계산
TIMEDIFF() : 두 기간 사이의 시간 계산
PERIOD_DIFF() : 두 기간 사이의 개월 수 계산
TIMESTAMPDIFF() : 두 기간 사이의 시간 계산
```

**1. DATE_ADD()**: 날짜, 시간 더하기
```sql
DATE_ADD(기준날짜, INTERVAL)

SELECT DATE_ADD(NOW(), INTERVAL 1 SECOND)
SELECT DATE_ADD(NOW(), INTERVAL 1 MINUTE)
SELECT DATE_ADD(NOW(), INTERVAL 1 HOUR)
SELECT DATE_ADD(NOW(), INTERVAL 1 DAY)
SELECT DATE_ADD(NOW(), INTERVAL 1 MONTH)
SELECT DATE_ADD(NOW(), INTERVAL 1 YEAR)
SELECT DATE_ADD(NOW(), INTERVAL -1 YEAR)
```
**2. DATE_SUB()**: 날짜, 시간 빼기
```sql
DATE_SUB(기준날짜, INTERVAL)

SELECT DATE_SUB(NOW(), INTERVAL 1 SECOND)
```
**3. DATEDIFF()**: 두 기간 사이의 일수 계산
* expr1 - expr2 ( expr1 : 종료일, expr2 : 시작일 )
* 날짜 포맷에 시간이 포함되어 있는 경우, 시간은 계산에 포함하지 않는다.
* 날짜 범위에서 벗어나는 값을 입력하는 경우 NULL을 반환한다.
```sql
DATEDIFF(expr1, expr2)

SELECT DATEDIFF('2021-12-31','2021-01-02');
>> 345
```
**4. TIMEDIFF()**: 두 기간 사이의 시간 계산
* expr1 - expr2 ( expr1 : 종료 시간, expr2 : 시작 시간 )
* 시간 또는 날짜 범위에서 벗어난 값을 입력하는 경우 NULL을 반환한다.
```sql
TIMEDIFF(expr1,expr2)
SELECT TIMEDIFF('2022-02-01 23:00:00','2022-01-30 00:00:00');
>> 71:00:00
```
**5. PEROID_DIFF()**: 두 기간 사이의 개월 수 차이 계산
* P1 - P2 ( P1 : 종료 년월, P2 : 시작 년월 )
* P1, P2에는 YYYYMM 또는 YYMM 형식으로 값을 지정한다.
```sql
PERIOD_DIFF(P1,P2)

SELECT PERIOD_DIFF('202202','202112');
>> 2

SELECT PERIOD_DIFF('202202','201212');
>> -10

SELECT PERIOD_DIFF('2202','1912');
>> 26
```
**6. TIMESTAMPDIFF()**: 시간, 개월 수 등 여러 가지 형태의 계산을 할 수 있는 함수
* unit - 반환 값 형식 (MONTH, YEAR, HOUR ...)
* datetime_expr1 - 시작일
* datetime_expr2 - 종료일
```sql
TIMESTAMPDIFF(unit, datetime_expr1, datetime_expr2)

SELECT TIMESTAMPDIFF(MONTH,'2021-02-01','2022-03-01');
>> 13
```
