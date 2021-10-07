# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 목록
* 1 ~ 9의 숫자 중 랜덤으로 3개의 숫자를 구한다.
* 사용자로부터 입력 받는 3개 숫자 예외 처리
  * 1 ~ 9의 숫자인가?
  * 중복 값이 있는가?
  * 3자리인가?
* 위치와 숫자 값이 같은 경우 - 스트라이크
* 위치는 다른데 숫자 값이 같은 경우 - 볼
* 숫자 값이 다른 경우 - 낫싱
* 사용자가 입력한 값에 대한 실행 결과를 구한다.

---
com / user
123, 456 -> nothing
123, 245 -> 1ball
123, 145 -> 1strike

PlayResult result = BaseBall.play(Arrays.asList(1, 2, 3), Arrays.asList(4 5, 6));

---
com / user
123 / 1 4 -> nothing
123 / 1 2 -> ball
123 / 1 1 -> strike

---
com / user
1 4 , 1 4 -> 1strike
1 4 , 2 4 -> ball
1 4 , 2 5 -> nothing