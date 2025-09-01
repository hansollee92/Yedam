<!-- App.vue -->

<template>
  <div class="container">
    <h3>초간단 게시판</h3>
    <PostForm @add-post="addPost" />
    <PostList v-bind:posts="posts" />
  </div>
</template>

<script>
import PostForm from "./components/PostForm.vue";
import PostList from "./components/PostList.vue";

export default {
  name: "App",
  components: {
    PostForm,
    PostList,
  },
  data() {
    return {
      logId: "user01",
      posts: [
        // {
        //   id: 1,
        //   title: "test",
        //   content: "test",
        //   date: new Date().toLocaleDateString(),
        // },
      ],
      // [{id:1, title: 'test', content: 'test', date: new Date().toLocaleDateString()}] < 이런형태로 작성할 예정
    };
  },
  methods: {
    addPost(payload) {
      this.posts.push({
        id: this.posts.length + 1,
        title: payload.title,
        content: payload.content,
        date: new Date().toLocaleDateString(),
      });
    },
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
