<template>
  <div>
    <div :key="item.comment_id" v-for="item in comments">
      <comment-list-item :comment-obj="item" />
    </div>
    <comment-create :contentId="contentId" :reloadComments="reloadComment" />
  </div>
</template>

<script>
import commentListItem from "./CommentListItem";
import commentCreate from "./CommentCreate";
import { findComment, findUser } from "../service";

async function loadComments() {
  const ret = await findComment({content_id: this.contentId});
  const comments = ret.data;
  for (let comment of comments) {
    const user_ret = await findUser({user_id: comment.user_id});
    comment = Object.assign(comment, {name: user_ret.data.name});
  }
  this.comments = comments;
}

export default {
  name: 'CommentList',
  components: {
    commentListItem,
    commentCreate
  },
  created() {
    loadComments.call(this);
  },
  props: {
    contentId: Number,
  },
  data() {
    return {
      comments: []
    }
  },
  methods: {
    reloadComment() {
      loadComments.call(this);
    },
  }
}
</script>
