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
import data from "../data";
  let items = data.Content.sort((a, b) => {
    return b.content_id - a.content_id;
  })
  export default {
    name: 'Board',
    data() {
      let items = data.Content.sort((a, b) => {
        return b.content_id - a.content_id;
      })

      items = items.map(contentItem => {
        return {...contentItem, user_name: data.User.filter(userItem => userItem.user_id === contentItem.user_id)[0].name}
      })

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
        items: items
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
