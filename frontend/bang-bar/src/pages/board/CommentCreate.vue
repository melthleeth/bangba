<template>
  <div class="flex">
    <section class="card-flat flex flex-col flex-initial h-full w-full">
      <span class="font-S-CoreDream-medium mb-2">{{ name }}</span>
      <textarea
        placeholder="코멘트를 달아주세요."
        class="w-full mb-2"
        v-model="content"
      ></textarea>
      <base-button
      class="w-max px-3 py-1 text-sm justify-self-end ml-auto"
        variant="info"
        mode="nude"
        @click="createComment()"
      >등록</base-button>
    </section>
  </div>
</template>

<script>
const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
  name: "CommentCreate",
  props: {
    contentId: Number,
    reloadComment: Function,
    reloadSubComments: Function,
    subCommentToggle: Function,
    commentId: Number,
  },
  data() {
    return {
      name: localStorage.getItem("user_name"),
      content: "",
      created_at:'',
      forum_no:'',
      user_no:'',
    };
  },

  methods: {
    //     createComment() {
    //   const comment_id = data.Comment[data.Comment.length - 1].comment_id + 1;
    //   data.Comment.push({
    //     comment_id: comment_id,
    //     user_id: 1,
    //     content_id: this.contentId,
    //     context: this.context,
    //     created_at: "2019-04-19",
    //     updated_at: null,
    //   });
    //   this.reloadComment();
    //   // this.subCommentToggle();
    //   this.context = "";
    // },
    createComment() {
        this.time_cal();

        let params={
          forum_no: 74,
          user_no: 9,
          content: this.content,
          created_at:this.created_at,
        }
        const headers = {
          'Content-type': 'application/json; charset=UTF-8',
          'Accept': '*/*',
          'Access-Control-Allow-Origin': '*',
        "Access-Control-Allow-Headers": "*",
      }

        this.axios.post(`${SERVER_URL}/forum/comment/create`,
        JSON.stringify(params),
        { headers }
      )
      .then((result)=>{
          console.log(result)

          this.$emit("addComment",result);
      })
      .catch(e=>{
          console.log('error:',e)
      })
    },

    time_cal(){
        let today = new Date();   

        let year = today.getFullYear(); // 년도
        let month = today.getMonth() + 1;  // 월
        let date = today.getDate();  // 날짜

        let hour=today.getHours();
        let min=today.getMinutes();
        let sec=today.getSeconds();

        if(date<'10'){
          date='0'+date;
        }

        if(month<'10'){
          month='0'+month;
        }

        if(hour<'10'){
          hour='0'+hour;
        }

        if(min<'10'){
          min='0'+min;
        }
        if(sec<'10'){
          sec='0'+sec;
        }

        this.created_at=year+""+month+""+date+""+hour+""+min+""+sec
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
