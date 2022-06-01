<template>
  <div>
    <div :key="item.comment_id" v-for="item in comments">
      <comment-list-item :comment-obj="item" />
    </div>
    <comment-create :contentId="contentId" :reloadComments="reloadComment" />
  </div>
</template>

<script>
import data from "../data";
import commentListItem from "./CommentListItem";
import commentCreate from "./CommentCreate";

function getComments() {
  return data.Comment.filter(item => item.content_id === this.contentId);
}

export default {
  name: 'CommentList',
  components: {
    commentListItem,
    commentCreate
  },
  props: {
    contentId: Number,
  },
  data() {
    return {
      comments: getComments.call(this)
    }
  },
  methods: {
    reloadComment() {
      this.comments = getComments.call(this);
    },
  }
}
</script>
