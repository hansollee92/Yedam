<template>
  <div>
    <img v-bind:src="imgSrc" v-bind:width="widthVal" />
  </div>
  <div class="container" v-bind:class="{ active: isActive, 'text-red': isRed }">
    Class Binding
  </div>
  <div v-bind:class="clsAry">Class Binding 배열</div>
  <div :style="backVal">Style Binding</div>
  <!-- v-bind 는 생략해서 : 으로 나타낼수도 있다 -->
</template>

<script>
export default {
  data() {
    return {
      imgSrc: "https://vuejs.org/images/logo.png",
      widthVal: "100px",
      isActive: false,
      isRed: true, // true일때만 active클래스가 적용되게끔 함
      activeCls: "active",
      redCls: "text-red",
      clsAry: ["active", "text-red"], //배열의 형태로 클래스를 함꼐 넣을수도 있음
      backVal: {
        "background-color": "#cceaf1ff",
        color: "#007fc9ff",
        padding: "10px 0",
      }, //스타일값들은 이런식으로 {key: value}값으로 가능
    };
  },
};
</script>

<!-- scoped 를 넣어주면 이 페이지에서만 적용되는 스타일로 지정됨 -->
<style scoped>
.active {
  background-color: #ffc3c3ff;
  font-weight: bold;
  color: #303030ff;
  padding: 5px 0;
}
.text-red {
  color: #a01919ff;
}
</style>
