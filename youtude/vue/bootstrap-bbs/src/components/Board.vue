<template>
  <div>
    <b-table striped hover :items="items" :per-page="perPage" :current-page="currentPage" :fields="fields" @row-clicked="rowClick"></b-table>
    <b-pagination v-model="currentPage"
                  :total-rows="rows"
                  :per-page="perPage"
                  align="center">

    </b-pagination>
    <b-button @click="writeContent">글쓰기</b-button>
  </div>
</template>

<script>
import { findContentList, findUser } from "../service";

export default {
    name: 'Board',
    async created() {
      const ret = await findContentList();
      let comments = ret.data
      for (let comment of comments) {
        const user_ret = await findUser({user_id: comment.user_id });
        comment = Object.assign(comment, { user_name: user_ret.data.name })
      }

      this.items = comments;
    },
    data() {
      return {
        currentPage: 1,
        perPage: 10,
        fields: [
          {
            key: 'content_id',
            label: '글번호'
          },
          {
            key: 'title',
            label: '내용'
          },
          {
            key: 'created_at',
            label: '작성일'
          },
          {
            key: 'user_name',
            label: '작성자'
          }],
        items: []
      }
    },
    methods: {
      rowClick(item, index, e) {
        this.$router.push({
          path: `/board/free/detail/${item.content_id}`
        })
      },
      writeContent() {
        this.$router.push({
          path: '/board/free/create'
        })
      },
    },
    computed: {
      rows() {
        return this.items.length;
      },
    }
  }
</script>
