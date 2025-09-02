<template>
  <h3>{{ msg }}</h3>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      msg: "ApiTest",
    };
  },
  mounted() {
    axios //
      .post("/api/productList2", { param: [] })
      .then((result) => console.log(result));
    // .post({ url: "api/productList2", data: {} })
    // .then((result) => console.log(result));

    // .post({ url: "api/productList2", data: {} }) 값을 들고 오지 못한 이유 :
    // axios.post(url, data, config) 가 정석 (data: body값)
    // axios.post({ url: "api/productList2", data: {} }) 처럼 객체 한 개를 넘기면, post()는 그걸 URL 문자열로 보지 못해 내부에서 문자열화
    // → "[object Object]"가 되어 POST /[object%20Object] 로 요청이 나갑니다 → 404.
    // 반면 axios.post("/api/productList2", { param: [] }) 는 정상 시그니처라 제대로 동작
    // .post({ url: "api/productList2", data: {} } 이 방식대로 작성하고 싶다면 -> axios({ method: "post", url: "/api/productList2", }) 이렇게 작성해야함
  },
};
</script>

<style scoped></style>
