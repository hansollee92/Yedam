<!-- App.vue -->

<template>
  <div class="container">
    <h3>초간단 게시판</h3>
    <p v-if="!user.id">로그인을 진행하세요.</p>
    <div v-else>
      <PostForm @add-post="addPost">
        <!-- 현재까지 attribute값(데이터, 이벤트)으로 전달을 하고 있는데 
           html을 전달하고 싶다면 slot 태그를 사용해야한다 (p165) -->
        <template v-slot:header>
          <div>Header</div>
        </template>
        <template v-slot:footer>
          <div>&copy;since 1990</div>
        </template>
        <template #default>
          <p>이름이 없는 slot</p>
        </template>
      </PostForm>
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
  name: "App",
  components: {
    PostForm,
    PostList,
  },
  data() {
    return {
      user: { id: "", name: "" }, // 처음에 빈 객체
      // posts: [
      //   // {
      //   //   id: 1,
      //   //   title: "test",
      //   //   content: "test",
      //   //   date: new Date().toLocaleDateString(),
      //   // },
      // ],
    };
  },
  computed: {
    //계산된 속성
    // mounted()는 한번 실행되고 더이상 실행되지 않기 때문에
    // 계속적으로 감시(업데이트되면 데이터가 바뀌게끔)되는 computed를 사용하는것이 가장 적당
    posts() {
      return this.$store.getters.getBoardList;
    },
    // data()에 있는 posts: []은 주석처리
    // -> 여기에다가 이제 이것을 사용하게끔 하기 위해서
  },
  methods: {
    addPost(payload) {
      this.posts.push({
        //배열이기 때문에 push
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
  mounted() {
    console.log(this.$store.state.boardList);
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
