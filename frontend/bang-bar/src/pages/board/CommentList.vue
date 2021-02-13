<template>
  <div>
    <div :key="item.comment_id" v-for="item in comments" class="flex" >
      <section class="card-flat flex flex-col flex-initial h-full w-full" v-if="item.pk_fcomment!==this.return_num || modify_flag">
        <span class="font-S-CoreDream-medium mb-2">{{ item.user_name }}
          <span class="flex items-center font-color-black-200 text-sm">{{convert_time(item.created_at)}}</span>
          </span>
          <div class="comment-list-item">
            <div class="comment-list-item-name">

            </div>
            <div class="comment-list-item-context">{{item.content}}</div>
            <div class="w-max px-3 py-1 text-sm justify-self-end ml-auto" v-if="item.user_name===this.loginName" >
  
            <button variant="info" @click="check_modifyComment(item.pk_fcomment,item.content)">수정</button>
            <button variant="info" @click="deleteComment(item.pk_fcomment)">삭제</button>
            
          </div>
        </div>
        
    </section>
      <div class="card-flat flex flex-col flex-initial h-full w-full" v-else>
        <section class="card-flat flex flex-col flex-initial h-full w-full">
          <span class="font-S-CoreDream-medium mb-2">{{ item.user_name }}</span>
          <textarea
            class="w-full mb-2"
            v-model="content"
            @keypress.enter="modifyComment()"
          >

          </textarea>
            <div class="w-max px-3 py-1 text-sm justify-self-end ml-auto"  >
  
            <button variant="info" @click="modifyComment(item.pk_fcomment,this.content)">수정</button>
            <button variant="info" @click="this.return_num=-1, modify_flag=true">취소</button>
            
          </div>
      </section>
    </div>
  </div>

    <comment-create :forum_id="forum_id" v-on:addComment="addComment"/>
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
      comments:[],
      pk_num:'',
      loginName:localStorage.getItem("user_name"),
      myComment:false,
      modify_flag:true,
      return_num:'',
      content:'',
      
    };
  },

  components: {
    CommentCreate
  },
  methods: {
    getList_Comment(){

        //주소입력을 위함
        var link=(document.location.href).split('/');
        var answer=link[5]; // = 74
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
        // console.log(result.data);

        //시간순 정렬
        this.comments.sort(function(a,b){
          return a.created_at-b.created_at
        });
      })
      .catch(e=>{
        console.log('error:',e)
      })
    },


    addComment(){
      // console.log('comments', comment);
      // var temp=comment.split(",");
      
      // var forum_n=(temp[0].split(":"))[1]
      // var c_at=(temp[3].split(":"))[1].substring(1,15)
      // var ct=(temp[2].split(":"))[1]
      // var ctleng=ct.length;

      // this.comments.push({
      //       forum_no:forum_n,
      //       user_name:localStorage.getItem("user_name"),
      //       img_path:'',
      //       created_at:c_at,
      //       content:ct.substring(1,ctleng-1),
      // })
      this.getList_Comment()
    },

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
    deleteComment(pk_fcomment){
      // alert(pk_fcomment)   
      // var params={
      //   pk_fcomment:pk_fcomment
      // }
      var pk=parseInt(pk_fcomment)

       const headers = {
        "Content-type": "application/json; charset=UTF-8",
        Accept: "*/*",
        "Access-Control-Allow-Origin": "*",
        "Access-Control-Allow-Headers": "*",
      };

      this.axios
        .delete(
          `${SERVER_URL}/forum/comment/${pk}`,
          // JSON.stringify(params),
          { headers },
          // pk
        )
        .then((result) => {
          console.log(result);
          this.getList_Comment()
        })
        .catch((e) => {
          console.log("error:", e);
        });
    },
    check_modifyComment(pk_fcomment,content){    
      this.modify_flag=false;  
      this.return_num=pk_fcomment;
      this.pk_num=pk_fcomment
      this.content=content;
      // this.content=this.
    },
    modifyComment(pk_fcomment,content) {
      // 수정
      let params = {
        pk_fcomment: pk_fcomment,
        content: content,
      };
      const headers = {
        "Content-type": "application/json; charset=UTF-8",
        Accept: "*/*",
        "Access-Control-Allow-Origin": "*",
        "Access-Control-Allow-Headers": "*",
      };

      this.axios
        .put(`${SERVER_URL}/forum/comment/update-comment`, JSON.stringify(params), {
          headers,
        })
        .then((result) => {
          console.log(result);
          this.return_num=this.pk_num
          this.modify_flag=true;
          this.getList_Comment()
        })
        .catch((e) => {
          console.log("error:", e);
        });
    },
  },


  created() {
      this.getList_Comment()
  },

};
</script>

<style scoped></style>