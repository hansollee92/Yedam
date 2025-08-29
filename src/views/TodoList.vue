<!-- Vue 이름 만들때, Todo 이렇게 한 단어로 작성하면 vue 규칙에 어긋나서 오류뜬다. 
     이름 만들 때, 두개의 단어의 조합으로 만들자 -->

<!-- TodoList.vue -->
<template>
  <div id="myDIV" class="header">
    <h2 style="margin: 5px">{{ msg }}</h2>
    <!-- ④ list item 추가를 위해 v-model(양방향 데이터바인딩), v-on:click이벤트 추가 -->
    <input
      type="text"
      v-model="title"
      id="myInput"
      placeholder="todo-list 할일을 작성해보세요"
    />
    <span v-on:click="newElement" class="addBtn">Add</span>
  </div>

  <ul id="myUL">
    <!-- ① 다중리스트 v-for로 작성 -->
    <!-- ② list item 클릭 이벤트 on-click 만들기, i(index)매개변수로 넣는 것은 각 list를 선택하기 위해 -->
    <!-- ③ v-bind:class="{ checked: todo.completed }를 넣어서 선택될때 class에 checked가 들어가고(true) 빠지고(false)를 선택 -->
    <li
      v-bind:class="{ checked: todo.completed }"
      v-on:click="changeStatus(i)"
      v-bind:key="i"
      v-for="(todo, i) in todoList"
    >
      {{ todo.title }}
      <!-- ⑤ list item 삭제를 위한 v-on 이벤트 -->
      <!-- 지금 현재, <span></span>태그가 <li></li>안에 포함되다보니 click을 하면, li에도 click 이벤트가 있어서 changeStatus이벤트가 발생하는 문제점이 있다
        그렇기 때문에 X버튼에는 아래와 같이 .stop을 붙여준다. -->
      <span v-on:click.stop="removeTodo(i)" class="close">X</span>
    </li>
  </ul>
</template>

<script>
export default {
  data() {
    return {
      msg: "Todo List",
      title: "",
      todoList: [
        // ② list item을 클릭할 때마다 --- 취소선이 나타나야하니 아래와 같이 completed 생성
        { title: "정처기 1,2과목 공부하기", completed: true },
        { title: "정처리 시험 치러 가기", completed: false },
        { title: "vue.js 공부하기", completed: false },
      ],
    };
  },
  methods: {
    // ② changeStatus 메서드 정의
    changeStatus(idx) {
      // console.log(this.todoList[idx]);
      // 토글할 때 마다 이벤트 발생하도록 아래와 같이 작업
      this.todoList[idx].completed = !this.todoList[idx].completed;
    },
    // ④ list item 추가 메서드 정의
    newElement() {
      let title = this.title;
      if (!title) {
        //입력을 하지 않았을때
        alert("to-do List를 입력 해주세요!");
        return;
      }
      // 배열에 값을 넣을때 사용하는 건 push
      this.todoList.push({ title, completed: false });
      this.title = ""; //초기화
    },
    // ⑤ list item 삭제
    // 배열을 삭제하기 위해선 splice(start, deleteCount, item1, item2, ...)함수 사용
    // 매개변수 start → 배열에서 작업을 시작할 인덱스 (0부터 시작)
    // 매개변수 deleteCount → start부터 몇 개를 지울지 (0이면 아무것도 안 지움)
    // 매개변수 item1, item2, ... → 지운 자리에 새로 추가할 요소들 (없으면 단순히 삭제만 됨)
    // 반환값 : 잘려나간 요소들을 배열로 반환
    removeTodo(i) {
      // console.log("remove");
      // console.log(this.todoList);
      this.todoList.splice(i, 1);
    },
  },
};
</script>

<style scoped>
body {
  margin: 0;
  min-width: 250px;
}

/* Include the padding and border in an element's total width and height */
* {
  box-sizing: border-box;
}

/* Remove margins and padding from the list */
ul {
  margin: 0;
  padding: 0;
}

/* Style the list items */
ul li {
  cursor: pointer;
  position: relative;
  padding: 12px 8px 12px 40px;
  list-style-type: none;
  background: #eee;
  font-size: 18px;
  transition: 0.2s;

  /* make the list items unselectable */
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

/* Set all odd list items to a different color (zebra-stripes) */
ul li:nth-child(odd) {
  background: #f9f9f9;
}

/* Darker background-color on hover */
ul li:hover {
  background: #ddd;
}

/* When clicked on, add a background color and strike out text */
ul li.checked {
  background: #888;
  color: #fff;
  text-decoration: line-through;
}

/* Add a "checked" mark when clicked on */
ul li.checked::before {
  content: "";
  position: absolute;
  border-color: #fff;
  border-style: solid;
  border-width: 0 2px 2px 0;
  top: 10px;
  left: 16px;
  transform: rotate(45deg);
  height: 15px;
  width: 7px;
}

/* Style the close button */
.close {
  position: absolute;
  right: 0;
  top: 0;
  padding: 12px 16px 12px 16px;
}

.close:hover {
  background-color: #1ecc92;
  color: white;
}

/* Style the header */
.header {
  background-color: #1ecc92;
  padding: 30px 40px;
  color: white;
  text-align: center;
}

/* Clear floats after the header */
.header:after {
  content: "";
  display: table;
  clear: both;
}

/* Style the input */
input {
  margin: 0;
  border: none;
  border-radius: 0;
  width: 75%;
  padding: 10px;
  float: left;
  font-size: 16px;
}

/* Style the "Add" button */
.addBtn {
  padding: 10px;
  width: 25%;
  background: #d9d9d9;
  color: #555;
  float: left;
  text-align: center;
  font-size: 16px;
  cursor: pointer;
  transition: 0.3s;
  border-radius: 0;
}

.addBtn:hover {
  background-color: #bbb;
}
</style>
