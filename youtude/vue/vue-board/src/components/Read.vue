<template>
  <div>
    <table>
      <tr>
        <td>글쓴이</td>
        <td>제목</td>
        <td>내용</td>
      </tr>
      <tr :key="index" v-for="(value, index) in data" @click="detail(index)">
        <td>{{value.writer}}</td>
        <td>{{value.title}}</td>
        <td>{{value.content}}</td>
      </tr>
    </table>
    <button @click="write">글쓰기</button>
  </div>
</template>

<script>
import data from "../data";

export default {
  name: 'Read',
  data() {
    return {
      data: data
    }
  },
  methods: {
    write() {
      this.$router.push({
        path: 'create'
      }) // 실행하면 해당 라우터의 주소로 이동 -> create.vue 로 이동
    },
    detail(index) {
      this.$router.push({
        name: 'Detail', // 파라미터를 넘겨줄 때메는 path 가 아니라 name 사용
        params: {
          contentId: index
        }
      })
    },
  }
}
</script>
