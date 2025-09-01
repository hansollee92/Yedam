<template>
  <div class="child-container">
    {{ msg }}

    <h3>{{ title }}</h3>

    <p>Likes: {{ likes }}</p>
    <p>isOk: {{ isOk ? "Yes" : "No" }}</p>

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
