import Vue from 'vue'
import VueRouter from 'vue-router'
import HomePage from '../views/HomePage'
import Login from '../views/Login'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    meta: {
      showheader: false,
    },
    component: Login
  },
  {
    path: '/index',
    name: 'index',
    meta: {
      showheader: true,
    },
    component: HomePage
  },
  {
    path: '/login',
    name: 'login',
    meta: {
      showheader: false,
    },
    component: () => import('../views/Login.vue')
  },
  {
    path: '/info',
    name: 'information',
    meta: {
      showheader: true,
    },
    component: () => import( '../views/Information.vue')
  },
  {
    path: '/admin',
    name: 'adminpage',
    meta:{
      showheader: true,
    },
    component:() => import('../views/AdminHomePage.vue')
  },
  {
    path: '/userlist',
    name: 'userlistpage',
    meta:{
      showheader: true,
    },
    component:() => import('../views/AdminPage.vue')
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
