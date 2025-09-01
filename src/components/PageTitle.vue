<!-- compoents/PageTitle.vue -->

<template>
  <div class="child-container">
    {{ msg }}

    <h3>{{ title }}</h3>

    <div v-if="isShow">
      <p>Likes: {{ likes }}</p>
      <p>isOk: {{ isOk ? "Yes" : "No" }}</p>
    </div>

    <h3>MemberList</h3>
    <ul>
      <li :key="i" v-for="(family, i) in memberList">
        {{ family.name }} - {{ family.age }} year old.
      </li>
    </ul>

    <!-- 좀더 다양한 형태의 데이터를 전달할 수도 있다 -->
    <input v-model="name" />
    <input type="text" v-model="age" />
    <!-- 하위요소에 실제 이벤트 함수 호출 -->
    <button @click="callParentEvent">call parent event</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      msg: "Child Component",
      name: "",
      age: 0,
    };
  },
  props: {
    title: { type: String, default: "Default Title" },
    likes: { type: Number, default: 0 },
    isOk: { type: Boolean, default: false },
    memberList: { type: Array, default: () => [] },
    isShow: { type: Boolean, default: false },
  },
  methods: {
    callParentEvent() {
      this.$emit("child-clicked", { name: this.name, age: this.age });
      // $emit() : 부모컴포넌트로 이벤트를 송출하겠다는 의미 -> 송출하면 부모가 알아서 이벤트를 실행
    },
  },
  mounted() {
    console.log(this);
    this.$parent.msg = "부모 컴포넌트";
  },
};
</script>

<style scoped>
.child-container {
  border: 1px solid #eee;
  background-color: #f1d8e5;
  padding: 10px;
}
</style>
