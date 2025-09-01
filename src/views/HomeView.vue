<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png" />
    <HelloWorld msg="Welcome to Your Vue.js App" />
    <HelloWorld msg="안녕하세요!" />
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from "@/components/HelloWorld.vue";

export default {
  name: "HomeView",
  components: {
    HelloWorld,
  },
};
</script>

<!-- 우리는 HelloWorld라는 것을 선언한적이 없는데 위에서 
 <HelloWorld msg="Welcome to Your Vue.js App"/> 으로 사용이 되고 있음 
 그러고 보면 아래 <script></script>안에 
 하나의 컴포넌트로 또 HelloWorld가 쓰여진 것을 확인할 수 있음 -->
