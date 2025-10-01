# BIGDATAUI_TEAMPJ
---
안심데이터 대회(저번회차)
https://www.youtube.com/watch?v=qGuE8CYek_c

## 우리만의 창업성공지수라는 수치를 새로 만들 필요가 있을까? 한다면 들어가야 하는 변수는 무엇이 필요할까?
- 그 지역의 평균소득(시군구 단위소득부채인구 통계(전북특별자치도 국민연금공단))
- 그 지역의 매출액(지역별 매출 및 이용고객 정보[경진대회 공용](경북대))
- 그 지역의 유동인구수? 인구수? 
- 

#### 경북대 - 자격_사업장가입자[경진대회 공용]
https://daegu.dsz.or.kr/intro/data/search

#### 자격_사업장가입자 데이터셋에서 매출이 큰 지역을 잡고 그 안에서 군집화를 한다면?

- 결제금액 합이 큰 지역 뽑기
→ UMD_CD 단위로 SALE_AMT를 합계(Aggregation)

- 특징 추출

1. 시간대별 (TIZO_CLCD) 매출 비중

2. 업종별 (TOBU_BIDVS_CD) 매출 비중

3. 성별(SEX_CLCD), 연령(N10_UNIT_AGE_CLCD) 분포

4. 개인/법인(PERS_CORP_CLCD) 구매 비중

군집화(Clustering)
→ 각 지역별로 위 특징들을 벡터로 만들고, K-means 같은 클러스터링 적용

창업 컨설팅 활용
→ 군집별 특성을 “A그룹은 저녁 매출 비중 ↑ → 음식점 유리”, “B그룹은 특정 업종 매출 ↑ → 서비스업 유리”처럼 해석





[전북특별자치도 ‧ 국민연금공단](https://data.nps.or.kr/service/svc/data/search.do?page=1&keyword=G007)
- 있는 데이터
  1. 내국인 소비데이터
  2. 외국인 소비데이터
  3. 상권분석용 데이터
  4. 가맹점 휴폐업 데이터 등등
  5. 배달앱 소비 데이
