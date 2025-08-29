import { createApp } from "vue"; //vue로부터 creatApp 함수 import
import App from "./App.vue";
import router from "./router"; //라우터(컴포넌트들을 연결)

createApp(App).use(router).mount("#app");
// creatApp으로 만들어진 것을 mount - #app에 연결
// #app은 pulic/index.html 내에 <div id="app"></div>으로 만들어져 있음
