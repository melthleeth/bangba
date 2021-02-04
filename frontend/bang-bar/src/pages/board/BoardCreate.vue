<template>
  <div style="text-align: center;">
          <h1 style="font-size:50px; text-align: center;">글쓰기</h1>
          <div>
          <select
            class="appearance-none w-auto m-3 text-lg bg-white hover:bg-gray-100 px-10 py-2 rounded-full leading-tight border-4 border-transparent focus:outline-none focus:shadow-outline"
            v-model="category"
          >
            <option>공지사항</option>
            <option>후기</option>
            <option>질문</option>
          </select>
          </div>
        <div>
            <textarea class="whiteboard" placeholder="제목을 입력해주세요." v-model="title">
            </textarea>
        </div>
        
        <div>
            <textarea  class="whiteboard" style="min-height:500px" v-model="content" placeholder="내용을 입력해주세요.">
            
            </textarea>
        </div>
    <br>
    <!-- <button @click="test()">클릭</button> -->

    <span >
      <base-button @click="uploadContent()">저장</base-button>
      <base-button @click="cancle">취소</base-button>
    </span>
  </div>
</template>

<script>
import data from '@/data'
import BaseButton from '../../components/ui/BaseButton.vue'

// var date=new Date();

export default {
  components: { BaseButton },
  name: 'BoardCreate',
  data() {
    return {
      category:'후기',
      title: '',
      context: '',
      user_id: 9,
      created_at:this.time_cal(),
      updated_at: "",
      updateObject: null,
      updateMode: this.$route.params.contentId > 0 ? true : false,
    }
  },
  created() {
      if(this.$route.params.contentId > 0) {
        const contentId = Number(this.$route.params.contentId)
        this.updateObject = data.Content.filter(contentItem => contentItem.content_id === contentId)[0]
        this.subject = this.updateObject.title;
        this.context = this.updateObject.context;
        
      } 
      console.log(this.user_id);
  },
  methods: {
    test(){
      console.log(this.user_id);
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

    uploadContent() { // 저장

        // let contentItems = data.Content.sort((a, b) => { return b.content_id - a.content_id });
        // const content_id = contentItems[0].content_id + 1;  // 마지막 데이터의 id + 1
        // alert(this.created_at);
        this.time_cal();

        let params={
          title: this.title,
          category: this.category,
          content: this.content,
          created_at:this.created_at,
          updated_at:this.created_at,
          user_no:this.user_id,
        }
        const headers = {
          'Content-type': 'application/json; charset=UTF-8',
          'Accept': '*/*',
          'Access-Control-Allow-Origin': '*',
      }

        this.axios.post('http://localhost:8081/forum/create-forum',
        JSON.stringify(params),
        { headers }
      )
      .then((result)=>{
          console.log(result)
          this.$router.push({
            path:'/board/list'
          });
      })
      .catch(e=>{
          console.log('error:',e)
      })

        // this.$router.push({
        //   path: '/board/list'
        // })
    },

    
    // updateContent() { // 수정
    //     this.updateObject.title = this.subject;
    //     this.updateObject.context = this.context;
    //     this.$router.push({
    //       path: '/board/list'
    //     })
    // },
    cancle() {
      this.$router.push({
        path: '/board/list'
      })
    }
  }
}
</script>

<style>
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