<!-- html영역은 <template></template>안에 만들면 된다 -->
<template>
  <!-- Router 설치시 아래와 같이 라우팅정보로 변경되어 있음 
   <router-link></router-link> 태그안에 적혀있음. 이 라우터정보는 router/index.js에 있음 -->
  <nav>
    <router-link to="/">Home</router-link> | <!-- Home을 볼려면 router/index.js로 가서 확인가능 -->
    <router-link to="/about">About</router-link> |
    <router-link to="/binding">Databinding</router-link>
  </nav>
  <router-view />
</template>

<!-- <script></script> 필요하면 이거 만들어서 작성 -->
<!-- 스타일영역 -->
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
