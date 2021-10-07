## form 입력 관련 태그

form 태그는 html 웹 문서에서 사용자가 입력하는 특정 양식의 데이터를 지정한 페이지로 전송하는 역할 수행
input 태그들로 형태를 구성한다
| 속성 | 설명 |
| --- | --- |
| action | 작성한 데이터를 보낼 페이지 주소 |
| method | 전달할 전송 방식을 GET/POST와 같은 HTTP 통신 전송방식으로 설정
| GET | 상단 URL에 더해서 보내지는 것, 주소로 확인 가능 but 보안 취약함. 검색, 링크 공유, 일반 페이지 이동에 사용. 주소 길이가 최대치에 달하면 추가 불가능 |
| POST | HTML 바디 부분에 더해져서 보내지는 것, 개발자 도구로 확인 가능 회원가입, 게시물 등록 등에 이용됨. 길이 제한 없음 |

| 태그 | 설명 |
| --- | --- |
| fieldset | 연관된 요소들을 박스 모양의 선을 이용해 하나의 그룹으로 묶음.
| legend | 제목 달기(caption 정의) |
| input | 사용자로부터 입력받을 수 있는 입력 필드를 정의 |
| label | UI 요소의 라벨(이름) 정의 |
| select | 다중 선택 |
| option | 드롭다운 리스트에서 하나의 옵션을 정의할 때 사용, select나 datalist 내부에서만 사용 가능 |
| optgroup | 옵션 내 그룹 지정 |
| button | input 태그에서 버튼 요소들을 독립시키기 위해 만들어진 버튼 전용 태그 |


| input 태그 type 속성 | 설명 |
| --- | --- |
| text | 한 줄로 문자열 작성 |
| required | 필수 입력 사항(미입력시 제출 불가능 |
| password | 비밀번호 작성 |
| url | http://, https:// 형식으로 url 작성 |
| tel | 전화번호 입력, 모바일에서 번호 입력하기 좋은 형식의 키보드 호출, <br>나라마다 번호 형식이 다르기 때문에 자주 사용되지 않음 |
| email | 이메일 입력 |
| submit | 제출하기 |
| reset | 작성 취소 |
| number | 상하 화살표로 숫자 지정 |
| range | 슬라이드바로 숫자 지정 |
| min | 최솟값 |
| max | 최댓값 |
| value | 기본으로 입력되어 있는 값 |
| step | 값 증감 범위 지정 |
| data | 년, 월, 일 입력 |
| month | 년, 월 입력 |
| week | 주, 년 입력 |
| time | 오전/오후, 시, 분 입력 |
| datetime-local | 년, 월, 일, 오전/오후, 시, 분 입력 |
| radio | 옵션 선택, 하나만 선택 가능 |
| checkbox | 옵션 선택, 중복 선택 가능 |
| color | 색상 선택 |
| file | 파일 선택 |
| hidden | 보이지 않는 값 |

| button 태그 속성 | 설명 |
| --- | --- |
| button | 타입 설정하지 않으면  submit 버튼으로 작용함 |
| submit | 전송 버튼 |
| reset | 초기화 버튼 |
| img src | 사진 버튼  ex)`<button type="button> <img src="......"></button>` |

 ** input과 button의 차이<br>
 `<input type="submit">` 닫는 태그 없어 추가 기능 필요 시 CSS 등으로 추가해야 함<br>
 `<button type="submit">` 사이에 이미지 삽입 등 추가적인 기능 넣을 수 있음 `</button>`

