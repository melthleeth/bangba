<template>
  <div style="text-align: center;">
     
      <div class="whiteboard">
        <div class="font-extrabold text-lg content-detail-content-info-left-number" >[{{forum.category}}]</div>
        <div class="font-extrabold text-3xl content-detail-content-info-left-subject" >{{forum.title}}</div>
      </div>
      <div class="whiteboard">
        <img src="../../assets/icon/chunsik.png" class="float-left;" style="height:60px">
              <div class="content-detail-content-info-right-user">{{forum.user_name}}
                 <base-button>팔로우</base-button>
              </div>
                <div class="flex items-center mb-2">
                  <div class="content-detail-content-info-right-created">
                    {{forum.created_at}}
                    조회 : {{forum.hits}}
                  
                  </div>
                </div>

                <div>
                 <img src="../../assets/icon/like.png" class="" style="width:20px; "> {{forum.like_cnt}}
                 <img src="../../assets/icon/commentCount.png">  {{forum.like_cnt}}
                </div>
        </div>

      <div class="whiteboard" style="min-height:500px" >{{forum.content}}</div>
     
      <div class ="flex flex-col">
        <base-button>추천수 {{forum.like_cnt}}</base-button>
      </div>
      <div class="content-detail-button">
        
        <span v-if="forum.user_name===owner_check">
          <base-button @click="updateData">수정</base-button>
          <base-button @click="deleteData">삭제</base-button>
        </span>
        <base-button @click="golist">목록</base-button>
        
      </div>
      <div class="content-detail-comment">
        <CommentList :pk_forum="forum.pk_forum" ></CommentList>
      </div>
    
  </div>
</template>

<script>

import CommentList from "./CommentList";
const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
  name: "BoardDetail",

  
  data() {

    return {
    
      owner_check:localStorage.getItem('user_name'),
      forum:[],
      forumId:this.$route.params.contentId,
    };
  },

  created(){
    // console.log(this.forum.forumId);
    
    this.forum_Detail();
  },
  methods: {
    //삭제
    forum_Detail(){
        this.axios.get(`${SERVER_URL}/forum/${this.forumId}`, {
        headers: {
        'Access-Control-Allow-Origin': '*',
        'Content-Type': 'application/json; charset = utf-8',
        "Access-Control-Allow-Headers": "*",
        }
      })
      .then((result)=>{
        // this.items=result;
        // console.log(result)
        this.forum = result.data
        this.convert_time()
      })
      .catch(e=>{
        console.log('error:',e)
      })
    },


    deleteData() {
        const headers = {
          'Content-type': 'application/json; charset=UTF-8',
          'Accept': '*/*',
          'Access-Control-Allow-Origin': '*',
        "Access-Control-Allow-Headers": "*",
      }

        this.axios.delete(`${SERVER_URL}/forum/delete-forum/${this.forumId}`,
        // JSON.stringify(params),
        { headers }
      )
      .then((result)=>{
          console.log(result)
      this.$router.push({
        path: "/board/list"
      });
      })
      .catch(e=>{
          console.log('error:',e)
      })
    },

    //수정
    updateData() {
      this.$router.push({
        // path: `/board/modify/${this.forumId}`
        path: `/board/create/${this.forumId}`
      });
    },

    //목록으로가기
    golist(){
      this.$router.go(-1)
    },


    //시간 포멧 수정
    convert_time(){
          var Y=String(this.forum.created_at).substring(0,4)
          var M=String(this.forum.created_at).substring(4,6)
          var D=String(this.forum.created_at).substring(6,8)

          var H=String(this.forum.created_at).substring(8,10)
          var Min=String(this.forum.created_at).substring(10,12)
          var S=String(this.forum.created_at).substring(12,14)


          //현재 월
          let month = new Date().getMonth() + 1;  // 월
          let date = new Date().getDate();  // 날짜
          
          if(month<'10'){
            month='0'+month;
          }
          if(date<'10'){
            date='0'+date;
          }
          var answer=""
          answer=Y+"."+M+"."+D+"  "+H+":"+Min+":"+S;
          this.forum.created_at=answer;
      
    },
    
  },
  components: {
    CommentList,
    
  }
};
</script>
<style scoped>
.content-detail-content-info {
  border: 1px solid black;
  display: flex;
  justify-content: space-between;
}

.content-detail-content-info-left {
  width: 720px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  padding: 1rem;
}

.content-detail-content-info-right {
  width: 300px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 1rem;
}

.content-detail-content {
  border: 1px solid black;
  margin-top: 1rem;
  padding-top: 1rem;
  min-height: 720px;
}

.content-detail-button {
  border: 1px solid black;
  margin-top: 1rem;
  padding: 2rem;
}

.content-detail-comment {
  border: 1px solid black;
  margin-top: 1rem;
  padding: 2rem;
}

    .whiteboard{
        width:50%;
        background-color: #FFFFFF;
        text-decoration: none;
        padding: 0.75rem 1.5rem;
        font: inherit;
        border: 0.1px solid #FFFFFF;
        border-radius: 30px;
        margin-right: 0.5rem;
        display: inline-block;
        transition: .3s ease-out;
        margin-bottom: 15px;
    }
</style>