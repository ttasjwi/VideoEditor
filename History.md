
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

## [Work 02] 비디오

### (v 2.01) Video enum 생성

정해진 비디오들을 기반으로 관리하는 것이므로 enum으로 Video 생성

- enum으로 비디오들을 생성.
  - 필드 : id(String), title(name), time(second)
  - getter : getID, getTitle, getTime

---

### (v 2.02) Video getter 테스트코드 추가

Video의 getter들이 정상적으로 작동하는지에 대한 테스트코드를 작성했다.

- getIdTest() : id를 정상적으로 반환하는지 테스트
- getTitleTest() : title을 정상적으로 반환하는지 테스트
- getTimeTest() : time을 정상적으로 반환하는지 테스트

---


