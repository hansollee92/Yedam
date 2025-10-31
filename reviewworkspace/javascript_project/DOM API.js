/*

DOM API 


1) 태그

-- 메소드 
  document.querySelector() ✅
  document.querySelectorAll() ✅

  document.getElementById()
  document.getElementsByTagName()
  document.getElementsByClassName()

  * query : 질문 / Selector : 선택자
  * querySelector : 질문을 던지는 선택자 
  * querySeelctorAll : return 값이 배열이니 주의! 
  
-- 관계 관련 속성 ✅
  부모 : parentElement
  자식 : children, firstElementChild, lastElementChild
  형제 : previousElementSibling, nextElementSibling

  * 주의 : 메소드는 ()가 붙지만, 속성값은 ()가 붙지 않음
  * Elentment : 태그를 말함
  * children 복수 child 단수니깐 복수는 배열로 받는 것 
  * http://poiemaweb.com/js-dom DOM-TREE 구조 
  


2) Event 

  ① 이벤트 버블링

  ② document.addEventListener('이벤트명', 이벤트 핸들러)
    * removeEventListener() : add로 등록된 이벤트를 제거해야 할 때
    * 이벤트 핸들러 : 이벤트를 제어하는 함수 -> 이벤트만 발생했을 때만 발생, 매개변수로 이벤트 객체를 가짐 

  ③ 이벤트 객체 
    * 지금 현재 어디서 이벤트가 발생했을지 정보를 가지고 있는 것이 이벤트 객체

    1. target : 실제 이벤트가 발생한 태그(고정값)
    2. currentTarget : 이벤트가 전파된 태그(유동값)
    3. preventDefault() ✅
    4. stopPropagation() ✅

    * <a></a> 태그는 get방식으로밖에 전달이 안되는데 버튼으로 많이 사용을 하기 때문에 post형식으로 정보를 전달해야 할 때 사용하는 것이 preventDefault()로 일시정지 시킴
    * form 태그는 페이지를 전달하고 ajax는 데이터만 전달하는데 둘이 같이 사용된다. => 왜? 
    * stopPropagation() 은 이벤트버블링과 함께 설명해줄 것이다. 
      * 버블링, 거품! 거품이 발생하면 막 위로 올라오는데, 이것과 같이 동작하는 것을 말한다. DOM은 트리구조라고 했는데 li를 클릭했을 때, document에서 쭈욱 찾아 들어가서 li를 찾고 그 다음 그 이벤트가 발생하는데 그 이벤트가 올라옴. 그래서 이벤트는 기본적으로 위로 계속적으로 끊임없이 올라가는 구조를 가지고 있는데 이걸 끊어내고 싶을 때가 있다. 
      * 그때 사용하는 것이 stopPropagation()이다. (propagation : 전파)
    * target, currentTarget 


*/
