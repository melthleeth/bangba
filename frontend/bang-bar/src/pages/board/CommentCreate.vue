<template>
  <div class="flex">
    <section class="card-flat flex flex-col flex-initial h-full w-full">
      <span class="font-S-CoreDream-medium mb-2">{{ name }}</span>
      <textarea
        placeholder="코멘트를 달아주세요."
        class="w-full mb-2"
      ></textarea>
      <base-button
      class="w-max px-3 py-1 text-sm justify-self-end ml-auto"
        variant="info"
        mode="nude"
        @click="isSubComment ? createSubComment() : createComment()"
      >등록</base-button>
    </section>
  </div>
</template>

<script>
import data from "@/data";

export default {
  name: "CommentCreate",
  props: {
    contentId: Number,
    reloadComment: Function,
    reloadSubComments: Function,
    subCommentToggle: Function,
    isSubComment: Boolean,
    commentId: Number,
  },
  data() {
    return {
      name: localStorage.getItem("user_name"),
      context: "",
    };
  },

  methods: {
    createComment() {
      const comment_id = data.Comment[data.Comment.length - 1].comment_id + 1;
      data.Comment.push({
        comment_id: comment_id,
        user_id: 1,
        content_id: this.contentId,
        context: this.context,
        created_at: "2019-04-19",
        updated_at: null,
      });
      this.reloadComment();
      // this.subCommentToggle();
      this.context = "";
    },
    createSubComment() {
      const subcomment_id =
        data.SubComment[data.SubComment.length - 1].subcomment_id + 1;
      data.SubComment.push({
        subcomment_id: subcomment_id,
        comment_id: this.commentId,
        user_id: 1,
        context: this.context,
        created_at: "2019-04-20",
        updated_at: null,
      });
      this.reloadSubComments();
      this.subCommentToggle();
      this.context = "";
    },
  },
};
</script>

<style scoped>
.card-flat {
  padding: 1rem 1.25rem;
  margin: 1rem 0;
}
.comment-create {
  display: flex;
  margin-bottom: 1em;
}
</style>
