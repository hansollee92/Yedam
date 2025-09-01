<!-- App.vue -->

<template>
  <div class="container">
    <h3>초간단 게시판</h3>
    <p v-if="!user.id">로그인을 진행하세요.</p>
    <div v-else>
      <PostForm @add-post="addPost" />
    </div>
    <PostList v-bind:posts="posts" />

    <a @click="kakaoLogin">
      <img src="./assets/kakao_logo.png" alt="카카오 로그인 버튼" />
    </a>
  </div>
</template>

<script>
import PostForm from "./components/PostForm.vue";
import PostList from "./components/PostList.vue";

export default {
  // 객체를 이용해서 값을 지정하는 방식을 'OptionsAPI'방식(객체활용) 이라고 한다.
  // 이 뒤로 나온 방식이 CompositionAPI 방식으로 이 방식은 함수를 기반으로 한다.
  // 현재 우리는 OptionsAIP방식을 사용하는데 (좀더 쉬워서)

  // 그런데, provide를 작성할려면 함수를 참조하는 CompositionAPI방식으로 작성을 해야한다.
  // 이 방식을 사용하기 위해서는 import { ref } from "vue"; 를 해줘야하고
  // 아래와 같이 uid : ref(null), 라고 작성해서 초기값을 null로 설정한다. (그냥 ref("")라고 작성해도 괜춘)
  // ** 이 ref는 원시값의 주소값을 참조한다. -> 일반값을 참조방식으로 바꾸는 함수가 바로 ref()이다.

  // 그리고 아래에서 이 값의 value값을 보라고 이렇게 작성 -> this.uid.value = email;
  // provide에서도 uid: this.uid, 이렇게 작성이 되어야한다.

  name: "App",
  components: {
    PostForm,
    PostList,
  },
  data() {
    return {
      user: { id: "", name: "" }, // 처음에 빈 객체
      posts: [
        // {
        //   id: 1,
        //   title: "test",
        //   content: "test",
        //   date: new Date().toLocaleDateString(),
        // },
      ],
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
    kakaoLogin() {
      window.Kakao.Auth.login({
        scope: "profile_nickname, account_email",
        success: this.getKakaoAccount,
      });
    },
    getKakaoAccount() {
      window.Kakao.API.request({
        url: "/v2/user/me",
        success: (res) => {
          console.log(res);
          const kakao_account = res.kakao_account;
          const nickname = kakao_account.profile.nickname; //카카오 닉네임
          const email = kakao_account.email; //카카오 이메일
          console.log("nickname", nickname);
          console.log("email", email);

          //로그인 처리 구현
          alert("로그인 성공!");

          // this.user = { id: email, name: nickname }; // 새로운 값이여서 provide에 전달이 안됨
          // this.uid.value = email;

          this.user.id = email;
          this.user.name = nickname;
        },
        fail: (error) => {
          console.log(error);
        },
      });
    },
  },
  provide() {
    return {
      user: this.user, // 객체 자체를 내려줌
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
