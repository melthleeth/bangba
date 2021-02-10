<template>
  <div>
    <div :key="comment.pk_fcomment" v-for="comment in comments">
      <comment-list-item :comments="comment"></comment-list-item>
    </div>
    <comment-create :contentId="contentId" :reloadComment="reloadComment" />
    <base-button class="w-max px-4 py-1" mode="nude" @click="test()"
      >테스트용으로 만들어 놓은 것 같은 버튼
    </base-button>
  </div>
</template>

<script>
import data from "@/data";
import CommentListItem from "./CommentListItem";
import CommentCreate from "./CommentCreate";
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  name: "CommentList",
  components: {
    CommentListItem,
    CommentCreate,
  },
  props: ["contentId", "pk_forum"],
  data() {
    return {
      pk_num: this.pk_forum,
      // comments: data.Comment.filter((commentItem) => {
      //   return commentItem.content_id === this.contentId;
      // }),
      comments: [],
    };
  },
  created() {
    this.loadComments();
  },
  computed: {
    commentList() {
      for (const comment in this.comments) {
        console.log("comment");
        console.log(comment);
      }
      return true;
    },
  },
  methods: {
    test() {
      console.log(this.pk_forum);
    },
    loadComments() {
      const pk_forum = 74;
      let responseData = [];
      // this.axios.get(`${SERVER_URL}/forum/search-forum-list`, {
      this.axios
        .post(`${SERVER_URL}/forum/comment/keyword`, pk_forum, {
          headers: {
            "Content-Type": "application/json; charset=utf-8",
            Accept: "*/*",
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Allow-Headers": "*",
          },
        })
        .then((result) => {
          // this.items = result.dataF
          responseData = result.data;
          console.log(responseData);
        })
        .catch((e) => {
          console.log("error:", e);
        });

      for (const key in responseData) {
        console.log(key);
      }
    },

    reloadComment() {
      this.comments = data.Comment.filter((commentItem) => {
        return commentItem.content_id === this.contentId;
      });
    },
  },
};
</script>

<style scoped></style>
