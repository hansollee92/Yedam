<!-- components/PostForm.vue -->

<template>
  <h3>{{ msg }}</h3>
  <slot name="header"></slot>
  <form @submit.prevent="handleSubmit" class="post-form">
    <div class="form-group">
      <label for="title">제목</label>
      <input type="text" id="title" v-model="title" required />
    </div>
    <div class="form-group">
      <label for="content">내용</label>
      <textarea id="content" v-model="content" rows="4" required></textarea>
    </div>
    <slot></slot>
    <button type="submit">글 등록</button>
  </form>
  <slot name="footer"></slot>
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
  computed: {
    boardNo() {
      return this.$store.getters.getBoardNo;
    },
  },
  methods: {
    handleSubmit() {
      let post = {
        id: this.boardNo,
        title: this.title,
        content: this.content,
        date: new Date().toLocaleDateString(),
      };
      //this.$emit("add-post", post); //$emit 사용
      this.$store.commit("addBoard", post); //store의 commit, mutations을 이용

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
