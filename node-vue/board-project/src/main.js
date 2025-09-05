// main.js

import { createApp } from "vue";
import App from "./App.vue";
import store from "./store";

createApp(App) //
  .use(store)
  .mount("#app");

window.Kakao.init("dd689b27e4b7fc12b2893cb036221eb8");
