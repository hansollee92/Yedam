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
<!-- 
  25-08-29(금)

  ** 데이터 바인딩 :
  <script>안에서 데이터를 처리하고 (Model)
  <template> 안에서 화면에 html형식으로 나타나고 있다. (View)

  Model(데이터), View(화면)이 뭔가 바뀌면 데이터가 바인딩 되어있어서 바로바로 변경이 적용이 된다.
  그걸 중간에서 처리하는 것이 Vue인 것이다. (viewModel)

  Attribute 또한 변경이 가능하고 -> DataBindingAttribute.vue 파일 참고
  input 태그 또한 가능 -> DataBindingInput.vue 파일참고
  어제 마지막으로 했던 반복된 요소(다중데이터) 또한 데이터바인딩을 v-for를 통해서 가능했다 -> DataBindingList.vue 

-->
