<template>
  <div>
    <b-input placeholder="제목을 입력해주세요." v-model="subject" />
    <b-form-textarea
      v-model="context"
      placeholder="내용을 입력해주세요.."
      rows="3"
      max-rows="6"
    />
    <b-button @click="updateMode ? updateContent() : uploadContent()">저장</b-button>
    <b-button @click="cancle">취소</b-button>
  </div>
</template>

<script>
import { addContent, modifyContent, findContent } from "../service";

export default {
  name: 'Create',
  data() {
    return {
      subject: '',
      context: '',
      user_id: 1,
      updateMode: this.$route.params.contentId ? true : false
    }
  },
  async created() {
    if (this.$route.params.contentId) {
      const contentId = Number(this.$route.params.contentId);
      const ret = await findContent({
        content_id: contentId
      });
      const { data } = ret;
      this.subject = data.title;
      this.context = data.context;
    }
  },
  methods: {
    async uploadContent() {
      await addContent({
        user_id: this.user_id,
        title: this.subject,
        context: this.context,
      });

      this.$router.push({
        path: '/board/free'
      });
    },
    async updateContent() {
      await modifyContent({
        context_id: Number(this.$route.params.contentId),
        title: this.subject,
        context: this.context
      });
      this.$router.push({
        path: '/board/free'
      });
    },
    cancle() {
      this.$router.push({
        path: '/board/free/'
      })
    }
  }
}
</script>
