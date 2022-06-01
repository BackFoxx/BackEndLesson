<template>
  <div>
    <b-input placeholder="제목을 입력해주세요." v-model="subject" />
    <b-form-textarea
      v-model="context"
      placeholder="내용을 입력해주세요.."
      rows="3"
      max-rows="6"
    />
    <b-button @click="uploadContent">저장</b-button>
    <b-button @click="cancle">취소</b-button>
  </div>
</template>

<script>
import data from "../data";
export default {
  name: 'Create',
  data() {
    return {
      subject: '',
      context: '',
      user_id: 1,
      createdAt: '2019-04-17 11:32:42',
      updatedAt: null,
      updateObject: null,
      updateMode: this.$route.params.contentId ? true : false
    }
  },
  created() {
    if (this.$route.params.contentId) {
      const contentId = Number(this.$route.params.contentId);
      this.updateObject = data.Content.filter(item => item.content_id === contentId)[0];
      this.subject = this.updateObject.title;
      this.context = this.updateObject.context;
    }
  },
  methods: {
    uploadContent() {
      const lastContentId = data.Content.sort((a, b) => {
        return b.content_id - a.content_id;
      })[0].content_id;
      const newContentId = lastContentId + 1

      data.Content.push({
        content_id: newContentId,
        user_id: this.user_id,
        title: this.subject,
        context: this.context,
        created_at: this.createdAt,
        updated_at: this.updatedAt
      })

      this.$router.push({
        path: '/board/free'
      })
    },
    cancle() {
      this.$router.push({
        path: '/board/free/'
      })
    }
  }
}
</script>
