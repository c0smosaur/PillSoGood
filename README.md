# Pilsogd
> 기존의 레포지토리는 비공개로 설정되어 있어, 포트폴리오 용도로 코드만 따로 공개 레포지토리로 옮겨 왔습니다. PR 기록 등이 남아있지 않은 점 참고바랍니다.

## 목차
1. [소개](###-소개)
2. [기능](###-기능)
3. [사용된 기술](###-사용된-기술)
4. [API 문서](###-API-문서)
5. [아키텍처](###-아키텍처)
6. [라이센스](###-라이센스)
7. [팀원 정보](###-팀원-정보)
----

### 소개
![](https://velog.velcdn.com/images/c0smosaur/post/c0389e47-cb78-47a4-a8d5-fa3d6fa9b8a9/image.png)
> 약 복용을 돕고, 나아가 보호자들의 부담을 덜어주는 약물 복용 관리 서비스입니다.
> 
> 공공데이터 포털에서 제공되는 약 데이터를 기반으로 DB를 설계하여, 약물을 검색해 성분을 확인할 수 있습니다. 등록되지 않은 약일 경우, 직접 등록이 가능합니다. 
> 복용 주기 및 복용량 설정하여 루틴을 관리할 수 있으며, 복용 시간 및 요일에 맞춰 카카오톡 메시지로 알림을 보냅니다.

### 기능
- Kakao 소셜 로그인 및 회원가입
- 복용약 검색 및 등록
- 복용 루틴 등록
- 루틴에 맞춰 카카오톡 메시지 전송

### 사용된 기술
- 프레임워크: Spring Boot 3
- DB: MySQL, redis
- 배포: AWS EC2, RDS, gabia
- CI/CD: GitActions, Docker, docker-compose

### API 문서
Swagger: ~~[배포 주소](api.pillsogood.shop/swagger-ui/index.html)~~ **배포중단**

![](https://velog.velcdn.com/images/c0smosaur/post/9cf8acdb-4266-4c5a-94f4-055be7a882a7/image.png)

### 아키텍처
![](https://velog.velcdn.com/images/c0smosaur/post/2b1cbbf9-a17e-4a01-a259-4f97d6eefd8e/image.png)

### 라이센스
- 2024 Blaybus MVP 해커톤 창업팀

### 팀원 정보
|이름|이메일|담당|
|--|--|--|
|강서진|sjkang539@gmail.com|인증/인가, 루틴 API, 카카오 API 활용|
|나도윤|ratcomp9992@gmail.com|혼용 불가능 성분 API, 배포|
|이준엽|fe00000000@gmail.com|공공데이터 API 활용, 약물 검색 API |
