<!-- components/PostList.vue -->

<template>
  <h3>{{ msg }}</h3>
  <p v-if="posts.length == 0">게시글이 없습니다. 첫 게시글을 작성해보세요.</p>
  <div v-else>
    <PostItem v-for="post in posts" :key="post.id" :post="post" />
  </div>
</template>

<script>
import PostItem from "./PostItem.vue";
export default {
  data() {
    return {
      msg: "게시글 목록",
    };
  },
  props: {
    posts: { type: Array, default: () => [] },
  },
  components: {
    PostItem,
  },
};
</script>

<style scoped></style>
