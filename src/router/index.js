import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import DataBindingView from "../views/ComputedOption.vue";

const routes = [
  // 필요한 라우팅 정보를 아래와 같이 작성하면 된다.
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/about",
    name: "about",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
  },
  {
    path: "/binding",
    name: "Binding",
    component: DataBindingView,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
