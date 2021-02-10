<template>
  <div>
    <div :key="item.comment_id" v-for="item in comments" class="flex">
      <section class="card-flat flex flex-col flex-initial h-full w-full">
        <span class="font-S-CoreDream-medium mb-2">{{ item.user_name }}
          <span class="flex items-center font-color-black-200 text-sm">{{convert_time(item.created_at)}}</span>
          </span>
          <div class="comment-list-item">
            <div class="comment-list-item-name">

            </div>
            <div class="comment-list-item-context">{{item.content}}</div>
            <div class="w-max px-3 py-1 text-sm justify-self-end ml-auto">
            <button variant="info">수정</button>
              <!-- 줄 띄어쓰기 해야댐  -->
            <button variant="info">삭제</button>
          </div>
        </div>

    </section>
  </div>

    <CommentCreate :forum_id="forum_id" v-on:addComment="addComment"/>
  </div>
</template>

<script>

import CommentCreate from "./CommentCreate";
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  name: "CommentList",
  props: ["pk_forum"]
    ,
  data() {
    return {

      // 버그 수정하려면 얘 사이즈를 자동조절 해야댐!
      comments:[
      ],
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
    // loadComments() {
    //   const pk_forum = 74;
    //   let responseData = [];
    //   // this.axios.get(`${SERVER_URL}/forum/search-forum-list`, {
    //   this.axios
    //     .post(`${SERVER_URL}/forum/comment/keyword`, pk_forum, {
    //       headers: {
    //         "Content-Type": "application/json; charset=utf-8",
    //         Accept: "*/*",
    //         "Access-Control-Allow-Origin": "*",
    //         "Access-Control-Allow-Headers": "*",
    //       },
    //     })
    //     .then((result) => {
    //       // this.items = result.dataF
    //       responseData = result.data;
    //       console.log(responseData);
    //     })
    //     .catch((e) => {
    //       console.log("error:", e);
    //     });
    // },
    getList_Comment(){

        //주소입력을 위함
        var link=(document.location.href).split('/');
        var answer=link[5]; // = 74
        // console.log(answer)
        

        this.axios.get(`${SERVER_URL}/forum/comment/keyword/`+answer, {
        headers: {
        "Content-Type": "application/json; charset=utf-8",
        'Accept': '*/*',
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Headers': '*',
        },
        
        

      })
      .then((result)=>{
        this.comments = result.data
        console.log(result.data);

        //시간순 정렬
        this.comments.sort(function(a,b){
          return a.created_at-b.created_at
        });
      })
      .catch(e=>{
        console.log('error:',e)
      })
    },

    // reloadComment() {
    //   this.comments = data.Comment.filter(commentItem => {
    //     return commentItem.content_id === this.contentId;
    //   });
    // },


      //시간 포멧 변경
    convert_time(create_at) {
      var Y = String(create_at).substring(0, 4);
      var M = String(create_at).substring(4, 6);
      var D = String(create_at).substring(6, 8);

      var H = String(create_at).substring(8, 10);
      var Min = String(create_at).substring(10, 12);
      var S = String(create_at).substring(12, 14);

      //현재 월
      let month = new Date().getMonth() + 1; // 월
      let date = new Date().getDate(); // 날짜

      if (month < "10") {
        month = "0" + month;
      }
      if (date < "10") {
        date = "0" + date;
      }
      var answer = "";
      answer = Y + "." + M + "." + D + "  " + H + ":" + Min + ":" + S;
      return answer;
    },
  },

  created() {
      this.getList_Comment()
  },

};
</script>

<style scoped></style>