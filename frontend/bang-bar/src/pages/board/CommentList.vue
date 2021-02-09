<template>
  <div>
    <div :key="item.comment_id" v-for="item in comments">
      <CommentListItem :commentObj="item"></CommentListItem>
    </div>
    <CommentCreate :contentId="contentId" :reloadComment="reloadComment"/>
  </div>
  <base-button class="w-max px-4 py-1" mode="nude" @click="test()">테스트용으로 만들어 놓은 것 같은 버튼
  </base-button>
</template>

<script>
import data from "@/data";
import CommentListItem from "./CommentListItem";
import CommentCreate from "./CommentCreate";
const SERVER_URL = process.env.VUE_APP_SERVER_URL;


export default {
  name: "CommentList",
  props: {
    contentId: Number,
    pk_forum: Number,
  },
  data() {
    return {
      pk_num:this.pk_forum,
      comments: data.Comment.filter(commentItem => {
        return commentItem.content_id === this.contentId;
      })
    };
  },
  components: {
    CommentListItem,
    CommentCreate
  },
  methods: {
    test(){
      console.log(this.pk_forum)
    },

    getList_Comment(){
      
        let params = {
          
          pk_forum:74,
        };
        // this.axios.get(`${SERVER_URL}/forum/search-forum-list`, {
        this.axios.get(`${SERVER_URL}/forum/comment/keyword`, {
        headers: {
        "Content-Type": "application/json; charset=utf-8",
        'Accept': '*/*',
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Headers': '*',
        }, params
      })
      .then((result)=>{
        // this.items = result.data
        console.log(result.data);

      })
      .catch(e=>{
        console.log('error:',e)
      })
    },

    reloadComment() {
      this.comments = data.Comment.filter(commentItem => {
        return commentItem.content_id === this.contentId;
      });
    }
  },
  created() {
    this.getList_Comment()
  },
};
</script>

<style>
</style>