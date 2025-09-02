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

      // file(이미지, 문서 등)은 이진(binary) 데이터로 존재하는데
      // JS에서 이걸 그대로 JSON.stringify 해서 서버에 보내려 하면 깨지거나 전송이 불가능 (바이너리를 JSON 바디에 직접 넣을 수 없음)
      // 그래서 문자열화 과정이 필요 -> 이진 데이터를 안전하게 전송하기 위해 Base64 인코딩
      // FileReader.readAsDataURL(file)이 이 과정을 해주는데, 결과는 이런 문자열
      // data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAA...
      // 여기서 iVBORw0... 부분이 실제 파일 내용이 Base64로 변환된 텍스트

      // 즉, 프론트: File → Base64 문자열 → JSON 으로 전송
      // 서버: Base64 문자열 → Buffer.from(base64, "base64") → 파일로 저장 과 같은 과정을 하면 파일을 JSON body 안에서 안전하게 전달

      // 다시말해서 text형태로 변환해야한다. (stream -> Text)
      let fr = new FileReader();
      fr.onload = (ev) => {
        // file을 read할때 load 이벤트가 일어나는데,
        // 이벤트안에 이벤트핸들러를 넣으면 어떠한 작업이 일어나는지 확인이 가능하다
        let base64Txt = ev.target.result;
        // console.log(base64Txt.slice(base64Txt.indexOf(";base64") + 8));
        const data = base64Txt.slice(base64Txt.indexOf(";base64") + 8);
        axios
          .post("/upload/" + file_name, { param: data })
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
