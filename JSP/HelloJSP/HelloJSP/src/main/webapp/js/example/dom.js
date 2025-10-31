/**
 * dom.js
 * 
 * dom을 활용하면 추가적으로 화면을 만들어줄수 있는데 
 * 예를 들어서 
 * 
 * 	<ul id="target">
 *    <li>apple</li>
 *    <li>banana</li>
 *  </ul>
 * 
 * 이와 같은 형식으로 #show div안에
 * dom객체의 메소드를 활용하여 위와 같은 형태로 만들 수 있다.
 * 
 */


// createElement() : 자바스크립트로 새로운 HTML 요소(Node) 를 만들 때 쓰는 DOM 메서드
// setAttribute() : HTML 요소(노드)에 속성(attribute)을 추가하거나 수정할 때 쓰는 DOM 메서드
// innerText() : 해당 요소 안의 텍스트(글자) 를 읽거나 바꾸는 프로퍼티
// appendChild() :  "자식 요소를 추가" 하는 메서드, 부모 요소에 새롭게 만든 요소(Node) 를 붙일 때 씀
//                  부모.appendChild(자식요소)

let ul = document.createElement('ul'); // ① <ul> 요소 생성
ul.setAttribute('id', 'target');       // ② id="target" 속성 부여
 
let li = document.createElement('li'); // ③ <li> 요소 생성
li.innerText = 'apple';                // ④ li 안에 텍스트 "apple" 넣기
ul.appendChild(li);                    // ⑤ li를 ul의 자식으로 추가

// 바나나 추가를 할려면? apple 아래에 
// 오류 1 : let li 이렇게 하면 
// Uncaught SyntaxError: Identifier 'li' has already been declared (at dom.js:29:5) 이렇게 오류남
li = document.createElement('li'); // <li>
li.innerText = 'banana';
ul.appendChild(li); 

document.querySelector('#show').appendChild(ul);  // ⑥ ul을 #show 요소에 붙이기
console.log(ul);                       // ⑦ ul DOM 구조 콘솔에 출력



