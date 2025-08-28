<template>
  <h3>Hello, World</h3>
  <p>{{ msg }}</p>
  <p v-text="city"></p>
  <p v-html="htmltext"></p>
  <input v-model="msg" />
</template>

<!-- 지시자 (v-) 이렇게 붙은 것들
    {{ ... }} < 콧수염 문법  -->

<script>
export default {
  data() {
    return {
      msg: "안녕하세요",
      city: "서울",
      htmltext: "<b>서울</b>",
    };
  },
};
</script>

<style></style>
