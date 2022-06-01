<template>
  <div>
    <b-input-group :prepend="name" class="mt-3">
      <b-form-textarea
        id="textarea"
        v-model="context"
        :placeholder="'코멘트를 달아주세요'"
        rows="3"
        max-rows="6">
      </b-form-textarea>
      <b-input-group-append>
        <b-button variant="info" @click="isSubComment ? (updateMode ? updateSubComment() : createSubComment()) : createComment()">작성하기</b-button>
      </b-input-group-append>
    </b-input-group>
  </div>
</template>

<script>
import data from "../data";

export default {
  name: 'CommentCreate',
  data() {
    return{
      name: 'Moomomo',
      context: '',
    };
  },
  props: {
    contentId: Number,
    commentId: Number,
    isSubComment: Boolean,
    reloadComments: Function,

    reloadSubComments: Function,
    subCommentToggle: Function,

    updateMode: Boolean,
    subCommentIdToUpdate: Number,
    subCommentUpdateToggle: Function
  },
  methods: {
    createComment() {
      const commentId = data.Comment[data.Comment.length - 1].comment_id + 1;
      data.Comment.push({
        comment_id: commentId,
        user_id: 1,
        content_id: this.contentId,
        context: this.context,
        created_at: '2019-03-29 14:11:11',
        updated_at: null
      });

      this.reloadComments();
      this.context = '';
    },
    createSubComment() {
      const subCommentId = data.SubComment[data.SubComment.length - 1].subcomment_id + 1;
      data.SubComment.push({
        subcomment_id: subCommentId,
        comment_id: this.commentId,
        user_id: 1,
        context: this.context,
        created_at: '2019-03-29 14:11:11',
        updated_at: null
      });

      this.reloadSubComments();
      this.subCommentToggle();
      this.context = '';
    },
    updateSubComment() {
      const subCommentIndex = data.SubComment.findIndex(item => item.subcomment_id === this.subCommentIdToUpdate);
      const subComment = data.SubComment[subCommentIndex];
      data.SubComment[subCommentIndex] = {
        subcomment_id: subComment.subcomment_id,
        comment_id: subComment.comment_id,
        user_id: subComment.user_id,
        context: this.context,
        created_at: subComment.created_at,
        updated_at: subComment.updated_at
      }

      this.reloadSubComments();
      this.subCommentToggle();
      this.context = '';
    },
  }
}
</script>
