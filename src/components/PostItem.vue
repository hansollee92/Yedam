<!-- components/PostItem.vue -->
<template>
  <div class="post-item">
    <h3>{{ post.title }}</h3>
    <p>{{ post.content }}</p>
    <small>작성일 : {{ post.date }}</small>
    <small>작성자 : {{ user.id }}</small>
  </div>
</template>

<script>
export default {
  data() {
    return {
      msg: "",
    };
  },
  props: {
    post: { type: Object, default: () => {} },
  },
  inject: ["user"],
};
</script>

<style scoped>
.post-item {
  width: 70%;
  margin: 0 auto;
  border: 1px solid #eee;
  padding: 15px;
  margin-bottom: 15px;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}
.post-item h3 {
  margin: 0;
}
</style>
