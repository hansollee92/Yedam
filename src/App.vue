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
  provide() {
    return {
      uid: "user01",
      // PostItem.vue에서 이 로그인한 작성자 id가 필요한데 이걸 쓸려면
      // App.vue > PostList.vue > PostItem.vue 형태로 되어 있기 때문에
      // props로 해서 전달할려니 너무 복잡하다.
      // 그럴 경우 provide()를 이용해서 이렇게 작성하고
      // inject : ["uid"]를 PostItem.vue에서 작성해서 데이터를 전달할 수 있다.
    };
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
