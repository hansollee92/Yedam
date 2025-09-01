<!-- views/NestedComponent.vue -->
<!-- 부모컴포넌트 -> 자식컴포넌트로 데이터 전달하기 : props  -->

<template>
  <div class="parent-container">
    {{ msg }}
    <PageTitle
      v-bind:title="title"
      v-bind:likes="likeCnt"
      v-bind:isOk="okVal"
      :memberList="members"
    />
    <!-- 상위 컴포넌트에서 위와 같이 다양한 데이터타입으로 데이터를 전달해서 페이지를 구성할 수 있다 -->
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
      title: "Dynamic Data from Parent",
      likeCnt: 3,
      okVal: true,
      members: [
        { name: "father", age: 40 },
        { name: "mother", age: 35 },
        { name: "son", age: 6 },
      ],
    };
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
