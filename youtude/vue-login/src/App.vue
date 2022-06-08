<template>
  <div id="app">
    <nav>
      <router-link to="/">Home</router-link> |
      <router-link v-if="!isLogin" to="/login">로그인</router-link>
      <router-link v-if="isLogin" to="to" @click.native="$store.dispatch('logout')">로그아웃</router-link>
      <span v-if="isLogin"> | </span>
      <router-link v-if="isLogin" to="/myPage">마이페이지</router-link>
    </nav>
    <nav v-if="isLogin">
      웰컴
    </nav>
    <nav v-else>
      <span style="color: red" @click="$router.push('/login')">로그인을 해</span>
    </nav>
    <router-view/>
  </div>
</template>

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

</style>

<script>
import { mapState } from "vuex";
export default {
  computed: {
    ...mapState(['isLogin'])
  }
}
</script>