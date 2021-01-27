<template>
  <div>
    
          <h1>글쓰기</h1>
        

        <div>
            <span class="whiteboard" >
            </span>
        </div>
        
        <div>
            <textarea  class="whiteboard" >차 내 내린 까닭입니다. 덮어 노새, 패, 별을 있습니다. 다 별 어머니, 까닭입니다. 언덕 사랑과 이국 거외다. 부끄러운 이름과 속의 계집애들의 까닭입니다. 마리아 흙으로 계집애들의 언덕 있습니다. 내일 무성할 청춘이 가을 버리었습니다. 아름다운 계절이 내린 릴케 이름과, 동경과 노새, 계십니다. 써 하나에 내 계십니다.
속의 다 지나가는 하나 이름을 지나고 새워 나의 둘 거외다. 노새, 걱정도 둘 지나가는 멀리 아스라히 때 하나에 거외다. 쉬이 이국 그리고 가슴속에 사람들의 언덕 프랑시스 오는 까닭입니다. 불러 슬퍼하는 어머님, 멀리 강아지, 소녀들의 있습니다. 별 언덕 멀리 하나 무성할 것은 시인의 벌써 까닭입니다. 걱정도 속의 무덤 어머니, 하나에 쉬이 거외다. 속의 위에도 시인의 덮어 거외다. 별들을 패, 겨울이 어머니, 이 잔디가 까닭입니다. 우는 무엇인지 이제 이국 그리워 이 듯합니다. 내 무엇인지 언덕 별 피어나듯이 덮어 지나고 그러나 거외다. 피어나듯이 파란 오면 계십니다.
    이름과, 무덤 노루, 이름을 남은 봅니다. 비둘기, 하늘에는 경, 하나에 시와 하나 쉬이 많은 봅니다. 내 했던 하나 위에도 된 아름다운 있습니다. 잠, 이름을 잔디가 아무 봄이 있습니다. 우는 지나고 같이 이름과, 된 하나에 가을로 말 지나가는 거외다. 이 묻힌 써 언덕 있습니다. 어머니, 다하지 가을 별을 나는 파란 별 가득 있습니다. 한 자랑처럼 비둘기, 이름과 나의 나는 아름다운 듯합니다. 무성할 이름과, 다 자랑처럼 한 버리었습니다. 이름을 계절이 했던 청춘이 계십니다. 새워 무덤 이런 별 계십니다.
    ㅁㄴㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ
            
            </textarea>
        </div>


    <br>
    <b-button @click="updateMode ? updateContent() : uploadContent()">저장</b-button>&nbsp;
    <b-button @click="cancle">취소</b-button>
  </div>
</template>

<script>
import data from '@/data'

export default {
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
          path: '/'
        })
    },
    updateContent() { // 수정
        this.updateObject.title = this.subject;
        this.updateObject.context = this.context;
        this.$router.push({
          path: '/'
        })
    },
    cancle() {
      this.$router.push({
        path: '/'
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