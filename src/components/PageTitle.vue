<template>
  <div class="child-container">
    {{ msg }}

    <h3>{{ title }}</h3>

    <div v-if="isShow">
      <p>Likes: {{ likes }}</p>
      <p>isOk: {{ isOk ? "Yes" : "No" }}</p>
    </div>
    <!-- ◎ 그러면, 상위요소의 isShow가 true, false가 바뀔때마다
     하위컴포넌트의 이곳이 v-if로 해당 <p></p>들이 보였다가 보이지 않았다가 한다. -->

    <h3>MemberList</h3>
    <ul>
      <li :key="i" v-for="(family, i) in memberList">
        {{ family.name }} - {{ family.age }} year old.
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  data() {
    return {
      msg: "Child Component",
    };
  },
  props: {
    title: { type: String, default: "Default Title" },
    likes: { type: Number, default: 0 },
    isOk: { type: Boolean, default: false },
    memberList: { type: Array, default: () => [] },
    // 객체(Object), 배열(Array)의 경우 초기값은 함수(function)으로 정의해줘야한다.
    // () => [] 라는 의미 function(){return [];}와 같은 의미로 빈배열이라는 의미로 화살표함수로 표시한 것
    isShow: { type: Boolean, default: false },
  },
};
</script>

<style scoped>
.child-container {
  border: 1px solid #eee;
  background-color: #f1d8e5;
  padding: 10px;
}
</style>
