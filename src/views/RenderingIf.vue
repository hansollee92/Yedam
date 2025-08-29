<!-- v-if / v-else-if / v-else 
   : vue 컴포넌트에서 조건에 따라 랜더링 하는 방식은 위의 지시자를 사용하는 방법이 있음
   표현식은 아래와 같다.  
-->

<template>
  <div>
    <h3>{{ msg }}</h3>
    <p v-if="type == 'A'">A를 선택했습니다.</p>
    <p v-else-if="type == 'B'">B를 선택했습니다.</p>
    <p v-else>A,B가 아닙니다.</p>
  </div>
  <div>
    <p v-if="showItem">v-if 조건을 만족함</p>
    <p v-else>v-if조건을 만족하지 않음</p>
    <!-- click 이벤트를 넣어서 showItem의 값이 변경 -->
    <button v-on:click="changeValue">show값을 변경</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      msg: "v-if 지시자",
      type: "B",
      showItem: true,
    };
  },
  methods: {
    //이벤트들은 이곳에 정의
    changeValue() {
      // 이 함수가 실행될때마다 toggle 형태로 이벤트가 발생해야해서 아래와 같은 조건을 넣을 수 있음
      this.showItem = !this.showItem;
    },
  },
};
</script>
