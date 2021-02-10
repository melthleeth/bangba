<template>
  <div>
    
    <div :key="item.comment_id" v-for="item in comments" class="flex">
      <section class="card-flat flex flex-col flex-initial h-full w-full">
        <span class="font-S-CoreDream-medium mb-2">{{ item.user_name }} 
          <span class="flex items-center font-color-black-200 text-sm">{{item.created_at}}</span>
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
    
    <CommentCreate />
  </div>
  <base-button class="w-max px-4 py-1" mode="nude" @click="test()">테스트용으로 만들어 놓은 것 같은 버튼
  </base-button>
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

    getList_Comment(){

        //주소입력을 위함
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

        // string 배열로 3: "코테싫엉;;20210209134133;ㅎㅎ" 이렇게 들어옴  유저네임;이미지패스;작성시간;작성내용
        //우선 나눈다.
        var count=Object.keys(result.data).length;
        // console.log(count)
        for(var i=0;i<count;i++){
          var Stringinput=result.data[i];
          var Stringinput_Arr=Stringinput.split(';');
          // console.log((Stringinput_Arr));
          // console.log((Stringinput_Arr[0]));

          this.comments.push({
            user_name:Stringinput_Arr[0],
            img_path:Stringinput_Arr[1],
            created_at:Stringinput_Arr[2],
            content:Stringinput_Arr[3],
          })
          
          // this.comments[i].user_name.push(this.comments[i].user_name);
          // this.comments[i].user_name=Stringinput_Arr[0];
          // // console.log((this.comments[i].user_name));

          // this.comments[i].img_path=Stringinput_Arr[1];
          // // this.comments[i].created_at=Stringinput_Arr[2];
          // this.comments[i].created_at=this.convert_time(Stringinput_Arr[2]);
          // this.comments[i].content=Stringinput_Arr[3];
          
        }
        
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

<style>

/* .comment-list-item {
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
} */
</style>