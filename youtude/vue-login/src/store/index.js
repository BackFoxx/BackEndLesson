import Vue from 'vue'
import Vuex from 'vuex'
import Router from "@/router";
import axios from "axios";

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    userInfo: null,
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
    loginSuccess(state, payload) {
      state.isLogin = true;
      state.isLoginError = false;
      state.userInfo = payload;
    },
    // 로그인이 실패했을 때
    loginError(state) {
      state.isLogin = false;
      state.isLoginError = true;
    },
    logout(state) {
      state.isLogin = false;
      state.isLoginError = false;
      state.userInfo = null;
    },
  },
  //비즈니스 로직
  actions: {
    login({ dispatch }, loginObj) {
      // 로그인 -> 토큰 반환
      axios
          .post('https://reqres.in/api/login', loginObj)
          .then(res => {
            // 성공시 토큰이 들어온다.
            // 토큰을 헤더에 포함시켜서 유저 정보를 요청
            let token = res.data.token;
            // 토큰을 로컬스토리지에 저장
            localStorage.setItem('access-token', token);
            dispatch('getMemberInfo')
          })
          .catch(() => alert('이메일과 비밀번호를 확인하세요'))
    },
    // 로그인 시도
    // eslint-disable-next-line no-unused-vars
    getMemberInfo ({commit}) {
      // 로컬 스토리지에 있는 토큰을 불러온다.
      let token = localStorage.getItem('access-token');
      let config = {
        headers: {
          'access-token': token
        }
      }

      axios
          .get('https://reqres.in/api/users/2', config)
          .then(response => {
            let userInfo = {
              id: response.data.data.id,
              first_name: response.data.data.first_name,
              last_name: response.data.data.last_name,
              avartar: response.data.data.avatar,
              email: response.data.data.email,
            }
            commit('loginSuccess', userInfo)
          })
          .catch(() => {
            alert('이메일과 비밀번호를 확인하세요2')
          })
    },
    logout({commit}) {
      localStorage.removeItem('access-token');
      commit('logout');
      alert("로그아웃 완료되었습니다.")
      Router.push('/')
    },
  },
  modules: {
  }
})
