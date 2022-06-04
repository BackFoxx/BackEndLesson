import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    allUsers: [
      {id: 1, name: '사자', email: 'saza@gmail.com', password: 'test'},
      {id: 2, name: '호랑이', email: 'horange@gmail.com', password: 'test'}
    ],
    isLogin: false,
    isLoginError: false
  },
  getters: {
  },
  //상태값을 변경
  mutations: {
    // 로그인이 성공했을 때
    loginSuccess(state) {
      state.isLogin = true;
    },
    // 로그인이 실패했을 때
    loginError(state) {
      state.isLogin = false;
      state.isLoginError = true;
    },
  },
  //비즈니스 로직
  actions: {
    // 로그인 시도
    // eslint-disable-next-line no-unused-vars
    login({state, commit}, loginObj) {
      // 전체 유저에서 해당 이메일로 유저를 찾는다
      let selectedUser = null;
      state.allUsers.forEach(user => {
        if (user.email === loginObj.email) selectedUser = user;
      });

      selectedUser === null
          ? commit('loginError')
          : selectedUser.password === loginObj.password
              ? commit('loginSuccess')
              : commit('loginError')
    },
  },
  modules: {
  }
})
