<template>
  <div>
    <h1>{{userInfo.first_name}} {{userInfo.last_name}}님 안녕하세요!</h1>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: 'MyPage',
  computed: {
    ...mapState(['userInfo'])
  }
}
</script>