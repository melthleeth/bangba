<template>
  <div>
    <div :key="item.comment_id" v-for="item in comments">
        <div>
          <div class="comment-list-item">
            <div class="comment-list-item-name">
              <div>{{item.user_name}}</div>
              <div>{{item.created_at}}</div>
            </div>
            <div class="comment-list-item-context">{{item.context}}</div>
            <div class="comment-list-item-button">
            <button variant="info">수정</button>
            <button variant="info">삭제</button>
            <button variant="info" @click="subCommentToggle">덧글 달기</button>
          </div>
        </div>
    </div>
  </div>
    <CommentCreate :contentId="contentId" :reloadComment="reloadComment"/>
  </div>
  <base-button class="w-max px-4 py-1" mode="nude" @click="test()">테스트용으로 만들어 놓은 것 같은 버튼
  </base-button>
</template>

<script>
import data from "@/data";

import CommentCreate from "./CommentCreate";
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  name: "CommentList",
  props: ["pk_forum"]
    ,
  data() {
    return {
      comments:[],
      pk_num:''
    };
  },
  components: {
    CommentCreate
  },
  methods: {
    test(){
      var link=document.location.href;
      // console.log(this.$props.pk_forum)

      var answer=link.split('/');
      console.log(answer[5]);
    },

    getList_Comment(){
        var link=(document.location.href).split('/');

        var answer=link[5];
        



        this.axios.get(`${SERVER_URL}/forum/comment/`+answer, {
        headers: {
        "Content-Type": "application/json; charset=utf-8",
        'Accept': '*/*',
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Headers': '*',
        },
        
      })
      .then((result)=>{
        // this.items = result.data
        // console.log(result.data);
        console.log("!");

        this.comments=result.data;
        console.log(this.comments);
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
  mounted(){
      // console.log(this.pk_forum);
  },
  updated() {
      // console.log(this.pk_forum);
  },
  beforeUpdate(){
      // console.log(this.pk_forum);
  },
  
};
</script>

<style>

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