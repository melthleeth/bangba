<template>
  <div style="text-align: center;">
    
          <h1 style="font-size:50px; text-align: center;">글쓰기</h1>
        

        <div>
            <textarea class="whiteboard" placeholder="제목을 입력해주세요." v-model="subject">

            </textarea>
        </div>
        
        <div>
            <textarea  class="whiteboard" style="min-height:500px" v-model="context" placeholder="내용을 입력해주세요.">
            
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
      subject: '',
      context: '',
      user_id: 1,
      created_at: "2018-09-11",
      updated_at: null,
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

        let contentItems = data.Content.sort((a, b) => { return b.content_id - a.content_id });
        const content_id = contentItems[0].content_id + 1;  // 마지막 데이터의 id + 1

        data.Content.push({
          content_id: content_id,
          user_id: this.user_id,
          title: this.subject,
          context: this.context,
          created_at: this.created_at,
          updated_at: this.updated_at
        })

        this.$router.push({
          path: '/board/list'
        })
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