import Vue from 'vue'
import VueRouter from 'vue-router'
import LoginPage from "@/views/LoginPage";
import MyPage from "@/views/MyPage";
import store from "@/store";

Vue.use(VueRouter)

const rejectAuthUser = (to, from, next) => {
  if (store.state.isLogin) {
    // 이미 로그인 된 유저는 접속을 막아야 한다.
    alert('이미 로그인을 하셨습니다.')
    next('/')
  } else {
    next()
  }
}

const onlyAuth = (to, from, next) => {
  if (!store.state.isLogin) {
    // 아직 로그인이 안된 유저는 막아야 한다.
    alert('로그인이 필요합니다')
    next('/login')
  } else {
    next()
  }
}

const routes = [
  {
    path: '/login',
    name: 'login',
    beforeEnter: rejectAuthUser,
    component: LoginPage
  },
  {
    path: '/myPage',
    name: 'myPage',
    beforeEnter: onlyAuth,
    component: MyPage
  }
]

const router = new VueRouter({
  routes
})

export default router
