<!-- components/PostForm.vue -->

<template>
  <h3>{{ msg }}</h3>
  <form @submit.prevent="handleSubmit" class="post-form">
    <!-- prevent -> 어떤 페이지로 이동하지 않게끔 (action을 통해서 어떤 페이지로 이동하는데)
     그 이벤트에 대해서 기본 기능을 차단하기 위해서 자바스크립트에서      
     document.querySelector('form', e => {
      e.preventDefault();})      
    이런식으로 차단하는 기능을 썼었다. 이것을 위에서도 똑같이 쓰는 것-->
    <div class="form-group">
      <label for="title">제목</label>
      <input type="text" id="title" v-model="title" required />
    </div>
    <div class="form-group">
      <label for="content">내용</label>
      <textarea id="content" v-model="content" rows="4" required></textarea>
    </div>
    <button type="submit">글 등록</button>
  </form>
</template>

<script>
export default {
  data() {
    return {
      msg: "게시글 작성",
      title: "",
      content: "",
    };
  },
  methods: {
    handleSubmit() {
      let post = {
        title: this.title,
        content: this.content,
      };
      this.$emit("add-post", post);
      // 입력필드 초기화
      this.title = "";
      this.content = "";
    },
  },
};
</script>

<style scoped>
h3 {
  margin-bottom: 20px;
}
.post-form {
  width: 70%;
  padding: 20px;
  border: 1px solid #eee;
  border-radius: 8px;
  background-color: #f9f9f9;
  margin: 0 auto 50px;
  width: 70%;
}
.form-group {
  display: flex;
  padding: 10px;
}
.form-group label {
  width: 20%;
}
.form-group input,
.form-group textarea {
  width: 100%;
  border: 1px solid #eee;
  padding: 10px;
  border-radius: 5px;
  outline: none;
  font-family: Avenir, Helvetica, Arial, sans-serif;
}
.form-group input:focus,
.form-group textarea:focus {
  border: 1px solid #aaa;
}
button {
  border: 1px solid #aaa;
  padding: 8px 40px;
  border-radius: 8px;
  transition: 0.3s;
  margin: 20px 0 10px;
}
button:hover {
  background-color: #999;
  color: #fff;
}
</style>
