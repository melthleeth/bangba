<template>
  <div style="text-align: center;">
    
          <h1 style="font-size:50px; text-align: center;">글쓰기</h1>
        

        <div>
            <textarea class="whiteboard" placeholder="제목을 입력해주세요." v-model="title">

            </textarea>
        </div>
        
        <div>
            <textarea  class="whiteboard" style="min-height:500px" v-model="content" placeholder="내용을 입력해주세요.">
            
            </textarea>
        </div>


    <br>
    
    <span >
      <base-button @click="updateMode ? updateContent() : uploadContent()">저장</base-button>
      <base-button @click="cancle">취소</base-button>
    </span>
  </div>
</template>

<script>
import data from '@/data'
import BaseButton from '../../components/ui/BaseButton.vue'

export default {
  components: { BaseButton },
  name: 'BoardCreate',
  data() {
    return {
      category:'후기',
      title: '',
      context: '',
      user_id: 1,
      created_at: new Date(),
      updated_at: new Date(),
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
  },
  methods: {
    uploadContent() { // 저장

        // let contentItems = data.Content.sort((a, b) => { return b.content_id - a.content_id });
        // const content_id = contentItems[0].content_id + 1;  // 마지막 데이터의 id + 1
        // alert(this.created_at);
        console.log(this.created_at);

        let params={
          title: this.title,
          category: this.category,
          content: this.content,
          // created_at: this.created_at.replace("-","").replace("-",""), 
          // updated_at: this.updated_at.replace("-","").replace("-",""),

          created_at:20210202000000,
          updated_at:20210202000000,
          user_no:9,
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
            path:'/home'
          });
      })
      .catch(e=>{
          console.log('error:',e)
      })

        // this.$router.push({
        //   path: '/board/list'
        // })
    },
    updateContent() { // 수정
        this.updateObject.title = this.subject;
        this.updateObject.context = this.context;
        this.$router.push({
          path: '/board/list'
        })
    },
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