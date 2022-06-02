<template>
  <div>
    <div class="comment-list-item">
      <div class="comment-list-item-name">
        <div>{{commentObj.name}}</div>
        <div>{{commentObj.created_at}}</div>
      </div>
      <div class="comment-list-item-context">{{commentObj.context}}</div>
      <div class="comment-list-item-button">
        <b-button variant="info">수정</b-button>
        <b-button variant="info">삭제</b-button>
        <b-button variant="info" @click="subCommentToggle">덧글 달기</b-button>
      </div>
    </div>
    <template v-if="subCommentCreateToggle">
      <CommentCreate :comment-id="commentObj.comment_id"
                     :is-sub-comment="true"
                     :reload-sub-comments="reloadSubComments"
                     :subCommentToggle="subCommentToggle"/>
    </template>
    <template v-if="subCommentList.length > 0">
      <div class="comment-list-item-subcomment-list"
           :key="item.subcomment_id"
           v-for="item in subCommentList">
        <div class="comment-list-item-name">
          <div>{{item.user_name}}</div>
          <div>{{item.created_at}}</div>
        </div>
        <div class="comment-list-item-context">{{item.context}}</div>
        <div class="comment-list-item-button">
          <b-button variant="info">수정</b-button>
          <b-button variant="info" @click="deleteSubComment(item.subcomment_id)">삭제</b-button>
        </div>
      </div>
    </template>
  </div>
</template>

<script>
import data from "../data";
import CommentCreate from "./CommentCreate";
import {findSubComment, findUser} from "../service";

async function loadSubComments() {
  const ret = await findSubComment({comment_id: this.commentObj.comment_id})
  this.subCommentList = ret.data;
}

export default {
  name: 'CommentListItem',
  components: {
    CommentCreate
  },
  props: {
    commentObj: Object,
  },
  created() {
    loadSubComments.call(this);
  },
  data() {
    return {
      name: [],
      subCommentList: [],
      subCommentCreateToggle: false,
    }
  },
  methods: {
    subCommentToggle() {
      this.subCommentCreateToggle = !this.subCommentCreateToggle;
    },
    reloadSubComments() {
      loadSubComments.call(this);
    },
    deleteSubComment(subcomment_id) {
      const subcomment_index = data.SubComment.findIndex(item => item.subcomment_id === subcomment_id)
      data.SubComment.splice(subcomment_index, 1);
      this.reloadSubComments();
    },
  }

}
</script>

<style scoped>
.comment-list-item {
  display: flex;
  justify-content: space-between;
  padding-bottom: 1em;
}
.comment-list-item-name {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  border: 0.5px solid black;
  padding: 1em;
}
.comment-list-item-context {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 50em;
  border: 0.5px solid black;
}
.comment-list-item-button {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  border: 0.5px solid black;
  padding: 1em;
}
.btn {
  margin-bottom: 1em;
}
.comment-list-item-subcomment-list {
  display: flex;
  justify-content: space-between;
  padding-bottom: 1em;
  margin-left: 10em;
}
</style>
