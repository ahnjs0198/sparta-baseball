# CH 2 프로그래밍 기초 개인 과제 - 숫자야구
자바의 기본 문법과 객체 지향 프로그래밍의 개념을 익히기 위해 만든 '숫자야구' 프로그램입니다.
## 🤩 프로젝트 소개
목표 : 컴퓨터가 생성한 3자리 숫자를 플레이어가 맞추는 게임
숫자에 대한 요구사항
- 각 자기는 1-9 사이의 숫자
- 동일한 숫자는 사용될 수 없다. 즉, 숫자는 중복되지 않아야 한다.

## 🤪 개발 기간
- 2024.10.22(화) ~ 2024.10.24(목)

## 🥳 개발자 소개
- **안재솔** : 개발자

## 💻 개발환경
- **Version** : Java 17
- **IDE** : IntelliJ

## ☕️ 주요 기능
- Level 1 : 기본 게임 구현 (숫자 야구 게임)
  - 정답 숫자 생성하기
  - 정답을 맞추기 위해 숫자를 입력하기
  - 결과값 출력 및 게임 로직 적용하기
  - 게임 이어서하기
- Level 2 : 입력 및 출력 개선 (숫자 야구 게임)
  - 입력값이 유효한지 검사하기
  - 출력 개선
- Level 3 : 추가 기능 및 개선 (숫자 야구 게임)
  - 게임 기록 통계
  - 출력 개선
- Level 4 : 추가 기능 및 개선 (숫자 야구 게임)
  - 게임 난이도 조절

## 🙈 트러블 슈팅
- 배경 : 숫자야구의 정답을 중복을 없애기 위해 HashSet으로 구현하여 int Array로 변환하여 만들어서 테스트를 하는 중이었습니다.
- 발단 : 이때 모든정답이 랜덤으로 생성되기는 하는데 오름차순으로 정렬이 되는 에러가 발생하였습니다.
- 전개 : 이는 HashSet을 int Array로 변환하는 과정에서 정렬이 되어버려서 발생하는 에러였습니다.
- 위기 : random 클래스에는 이를 해결하는 기능을 가진 메서드가 없었습니다.
- 절정 : list를 활용하면 Collections.shuffle()이라는 요소를 랜덤으로 섞는 메서드를 사용할 수 있었습니다.
- 결말 : 정답을 중복을 없애기 위해 HashSet으로 구현을 하여 list로 변환하여 Collections.shuffle()로 섞은뒤 int Array로 변환하여 작성하였습니다.
