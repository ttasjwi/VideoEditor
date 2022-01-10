
# History

이 프로젝트의 역사

---

## [Work 01] 프로젝트 초기화

### (v 1.01) 

프로젝트 관리에 필요한 몇 가지 파일 추가

- `README.md` 파일 추가 : 프로젝트 소개용 마크다운 문서
- `.gitignore` 파일 추가 : git의 tracking에서 예외시킬 파일들 목록


### (v 1.02) History 추가

프로젝트 역사 기록파일 추가

- `History.md` 파일 추가 : 프로젝트의 변경사항 기록

---

## [Work 02] 영상 클립(Video Clip)

### (v 2.01) Video enum 생성

정해진 비디오들을 기반으로 관리하는 것이므로 enum으로 Video 생성

- enum으로 비디오들을 생성.
  - 필드 : id(String), title(name), time(second)
  - getter : getID, getTitle, getTime

### (v 2.02) Video getter 테스트코드 추가

Video의 getter들이 정상적으로 작동하는지에 대한 테스트코드를 작성했다.

- getIdTest() : id를 정상적으로 반환하는지 테스트
- getTitleTest() : title을 정상적으로 반환하는지 테스트
- getTimeTest() : time을 정상적으로 반환하는지 테스트

### (v 2.03) of 메서드 추가, 테스트 코드 추가

id로 Video를 검색해서 `Optional<Video>`로 반환하는 `of`메서드 및 테스트코드를 추가했다.

- of(String id) : Video들 중에서 id가 일치하는 Video를 찾아서 `Optional<Video>`로 반환한다.
  - 만약 존재하지 않으면 `Optional.empty()`를 반환한다.

- 테스트코드
  - `ofTest1()` : 존재하는 id들 전체로 일일이 검색해서 Video가 정상적으로 반환되는지 테스트
  - `ofTest2()` : 존재하지 않는 id로 검색했을 때 `Optional.empty()`가 반환되는지 테스트

### (v 2.04) Main, Prompt 생성

Main 클래스, Prompt 클래스를 생성했다.

- Main : Prompt를 실행.
- Prompt
  - `printVideoClip()` : 비디오 클립들을 일괄 출력한다.

---

### (v 2.05) VideoClip 및 테스트코드 완성, master 브랜치에 병합

Video -> VideoClip 클래스명 변경, VideoClip 클래스의 상수명 변경

- 처음에는 Video 클래스로 생성했으나 비디오 클립 단위의 연속을 비디오로 보기 위해 VideoClip으로 명칭 변경
  - 테스트 클래스명 및 각종 변수명도 이에 대응하여 수정했다.
- DOG_NYAONG 상수를 DOG_MEW 로 상수명을 변경했다.

---

## [Work 03] LinkedList 구현하기

### (v 3.01) List 인터페이스 생성

인터페이스 List를 생성했다. 이는 Java API로 지원되는 컬렉션 프레임워크와 다르며, 일부 기능만 구현하도록 하기로 했다.

### (v 3.02) LinkedList - size(), isEmpty() 구현

LinkedList의 저장데이터 갯수를 반환하는 size, isEmpty 메서드를 구현했다.

- LinkedList 멤버변수 : size
- `size()` : 현재 리스트의 size 반환
- `isEmpty()` : 현재 리스트의 size값이 0일 경우 true 반환

### (v 3.03) LinkedList - 내부 클래스 Node 생성 및 head, tail 멤버변수 추가

내부 클래스 Node 클래스를 생성하고, LinkedList의 멤버변수로 head, tail을 추가했다.

- head : 첫번째 인덱스의 노드
- tail : 마지막 인덱스의 노드
- Node : 연결의 최소 단위
  - prev : 앞 노드
  - data : 저장 객체
  - next: 뒷 노드

### (v 3.04) LinkedList - add 메서드 구현

LinkedList에 새로운 요소를 추가하는 add 메서드를 구현했다.

- add(E element) : 실질적으로 linkToTail 메서드를 호출하여 실행, true를 반환함
  - linkToTail(element) : 기존에 존재하던 tail의 next에 element를 연결함
    - tail이 존재하지 않을 경우(기존 list에 데이터가 존재하지 않은 상황일 경우) : 추가된 node를 head로 함
    
### (v 3.05) LinkedList - insert 메서드 구현

LinkedList에 새로운 요소를 원하는 인덱스에 삽입하는 메서드를 구현했다.

- insert(int index, E element) : 인덱스에 객체 삽입
  - `isInsertableIndex (int index)` : 지정 인덱스가 삽입 가능한 인덱스 번호인가?
  - `linkToPrev(Node<E> oldNode, E element)` : oldNode의 앞에 있는 prev 뒤에 새 요소를 연결하고, 요소 뒤에 oldNode를 추가함
  - `findNodeByIndex(int index)` : 지정 index에 대응하는 Node를 반환. (여기서 인자로 넣어진 index는 유효값임을 가정)

---