// router/index.js

import { createRouter, createWebHistory } from "vue-router";
// import HomeView from "../views/HomeView.vue";
import ProductList from "../views/ProductList.vue";
import SalesList from "../views/SalesList.vue";
import ProductDetail from "../views/ProductDetail.vue";

const routes = [
  {
    path: "/",
    name: "ProductList",
    component: ProductList,
  },
  {
    path: "/sales",
    name: "SalesList",
    component: SalesList,
  },
  {
    path: "/detail",
    name: "ProductDetail",
    component: ProductDetail,
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
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
