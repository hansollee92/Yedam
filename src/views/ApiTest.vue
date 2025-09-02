<!-- views/ApiTest.vue -->

<template>
  <h3>{{ msg }}</h3>
  <form>
    <input type="file" @change="getFileInfo" />
  </form>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      msg: "ApiTest",
    };
  },
  methods: {
    getFileInfo(e) {
      // console.log(e.target.files[0]);
      const file_name = e.target.files[0].name;
      const file = e.target.files[0];
      console.log(file_name, file);

      // file은 2진값으로 바꿔주는 작업이 필요하다.
      // 다시말해서 text형태로 변환해야한다. (stream -> Text)
      let fr = new FileReader();
      fr.onload = (ev) => {
        // file을 read할때 load 이벤트가 일어나는데,
        // 이벤트안에 이벤트핸들러를 넣으면 어떠한 작업이 일어나는지 확인이 가능하다
        let base64Txt = ev.target.result;
        // console.log(base64Txt.slice(base64Txt.indexOf(";base64") + 8));
        const data = base64Txt.slice(base64Txt.indexOf(";base64") + 8);
        axios
          .post("/upload/" + file_name, { data })
          .then((result) => console.log(result));
      };
      fr.readAsDataURL(file);
    },
  },
  mounted() {
    axios //
      .post("/api/productList2", { param: [] })
      .then((result) => console.log(result.data));
    // .post({ url: "api/productList2", data: {} } 이 방식대로 작성하고 싶다면
    // -> axios({ method: "post", url: "/api/productList2", data: {param: []}}) 이렇게 작성해야함
  },
};
</script>

<style scoped></style>
