import { createRouter, createWebHistory } from 'vue-router'
import MainContent from '@/views/MainContent.vue';
import BookList from '../views/book/BookList.vue';

const routes = [
  {
    path: '/',
    name: 'main',
    component: MainContent
    
  },
  {
    path: '/list',
    name: 'bookList',
    component: BookList
  },
  {
    path: '/info/:bno',
    name: 'bookInfo',
    component: () => import('../views/book/BookInfo.vue'),
  },
  {
    path: '/form',
    name: 'bookForm',
     component: () => import('../views/book/BookForm.vue'),
  },
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
