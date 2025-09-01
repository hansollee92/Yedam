<!-- views/NestedComponent.vue -->
<!-- 부모컴포넌트 -> 자식컴포넌트로 데이터 전달하기 : props  -->

<template>
  <div class="parent-container">
    {{ msg }} / {{ age }}
    <button @click="toggleDetails">Toggle</button>
    <PageTitle
      v-bind:title="title"
      v-bind:likes="likeCnt"
      v-bind:isOk="okVal"
      :memberList="members"
      :isShow="showDetail"
      ref="page-component"
      @child-clicked="handleChildClick"
    />
    <!-- @child-clicked="handleChildClick"은
    하위요소로부터 이벤트가 발생하면 해당 이벤트가 실행될 수 있도록 child-clicked 등록 
    (child-clicked는 사용자정의 이벤트로 실제적으로 @click처럼 존재하는게 아니라 자식에서 이벤트가 실행되었을때
    부모한테 그 이벤트가 전달되어 실행될 수 있도록 사용자가 정의한 이벤트이다.)
    => 실제 자식한테 이 이벤트가 실행될 수 있도록 존재해야함 -->
  </div>
</template>

<script>
import PageTitle from "../components/PageTitle.vue";
export default {
  components: {
    PageTitle,
  },
  data() {
    return {
      msg: "Parent Component",
      age: 0,
      title: "Dynamic Data from Parent",
      likeCnt: 3,
      okVal: true,
      showDetail: true,
      members: [
        { name: "father", age: 40 },
        { name: "mother", age: 35 },
        { name: "son", age: 6 },
      ],
    };
  },
  methods: {
    toggleDetails() {
      this.showDetail = !this.showDetail;
    },
    handleChildClick(payload = { name: "Lee", age: 0 }) {
      this.msg = payload.name;
      this.age = payload.age;
      // 자식 컴포넌트가 전달한 값을 위와 같이 매개변수로 받아서 나타낼수도 있다.
    },
  },
  mounted() {
    //console.log(this);
  },
};
</script>

<style scoped>
.parent-container {
  border: 1px solid #eee;
  background-color: #bbffe8;
  padding: 10px;
}
</style>
