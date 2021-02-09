<template>
  <div>
    <div class="comment-list-item">
      <div class="comment-list-item-name">
        <div>{{ comments.user_name }}</div>
        <div>{{ comments.created_at }}</div>
      </div>
      <div class="comment-list-item-context">{{ comments.content }}</div>
      <div class="comment-list-item-button">
        <base-button mode="flat" class="text-sm px-3 py-1">수정</base-button>
        <base-button mode="flat" class="text-sm px-3 py-1">삭제</base-button>
        <base-button mode="flat" class="text-sm px-3 py-1" @click="subCommentToggle">덧글 달기</base-button>
      </div>
    </div>
    <template v-if="subCommentCreateToggle">
      <CommentCreate
        :isSubComment="true"
        :commentId="comments.pk_fcomment"
        :reloadSubComments="reloadSubComments"
        :subCommentToggle="subCommentToggle"
      />
    </template>
    <template v-if="subCommentList.length > 0">
      <div
        class="comment-list-item-subcomment-list"
        :key="subComment.subcomment_id"
        v-for="subComment in subCommentList"
      >
        <div class="comment-list-item-name">
          <div>{{ subComment.user_name }}</div>
          <div>{{ subComment.created_at }}</div>
        </div>
        <div class="comment-list-item-context">{{ subComment.context }}</div>
        <div class="comment-list-item-button">
          <button variant="info">수정</button>
          <button variant="info">삭제</button>
        </div>
      </div>
    </template>
  </div>
</template>

<script>
import data from "@/data";
import CommentCreate from "./CommentCreate";

export default {
  name: "CommentListItem",
  props: {
    comments: Object,
  },
  components: {
    CommentCreate,
  },
  data() {
    return {
      subCommentList: data.SubComment.filter(
        (comment) => comment.pk_fcomment === this.comments.pk_fcomment
      ).map((subCommentItem) => ({
        ...subCommentItem,
        user_name: data.User.filter(
          (comment) => comment.user_id === subCommentItem.user_id
        )[0].name,
      })),
      subCommentCreateToggle: false,
    };
  },
  methods: {
    subCommentToggle() {
      this.subCommentCreateToggle = !this.subCommentCreateToggle;
    },
    reloadSubComments() {
      this.subCommentList = data.SubComment.filter(
        (comment) => comment.pk_fcomment === this.comments.pk_fcomment
      ).map((subCommentItem) => ({
        ...subCommentItem,
        user_name: data.User.filter(
          (comment) => comment.user_id === subCommentItem.user_id
        )[0].name,
      }));
    },
  },
};
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
