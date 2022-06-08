<template>
  <v-container style="max-width: 450px">
    <v-layout row wrap>
      <v-flex xs12>
        <div v-if="isLoginError"
            style="color: red"
        >
          아이디와 비밀번호를 확인해주세요.
        </div>

        <div v-if="isLogin"
            style="color: green"
        >
          로그인이 완료되었습니다.
        </div>

        <v-card>
          <v-text-field
              v-model="email"
              label="이메일을 입력하세요"
          ></v-text-field>
          <v-text-field
              v-model="password"
              type="password"
              label="패스워드를 입력하세요"
          ></v-text-field>
          <v-btn @click="login({
            email: email,
            password: password
          })">로그인</v-btn>
        </v-card>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
import { mapState, mapActions } from 'vuex'

export default {
  name: 'LoginPage',
  data() {
    return {
      email: null,
      password: null,
    }
  },
  computed: {
    ...mapState(['isLogin', 'isLoginError'])
  },
  methods: {
    ...mapActions(['login']),
  }
}
</script>