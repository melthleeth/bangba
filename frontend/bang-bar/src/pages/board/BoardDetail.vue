<template>
  <div style="text-align: center;">
      <div >
        <div class="whiteboard">
          <div class="content-detail-content-info-left-number">{{contentId}}</div>
          <div class="content-detail-content-info-left-subject">{{title}}</div>
        </div>
        <div class="whiteboard">
          <div class="content-detail-content-info-right-user">글쓴이: {{user}}</div>
          <div class="content-detail-content-info-right-created">등록일: {{created}}</div>
        </div>
      </div>
      <div class="whiteboard" style="min-height:500px">{{context}}</div>
      <div class="content-detail-button">
        <base-button @click="updateData">수정</base-button>
        <base-button @click="deleteData">삭제</base-button>
        
        
      </div>
      <div class="content-detail-comment">
        <CommentList :contentId="contentId"></CommentList>
      </div>
    
  </div>
</template>

<script>
import data from "@/data";
import CommentList from "./CommentList";
import BaseButton from '../../components/ui/BaseButton.vue';

export default {
  name: "BoardDetail",
  data() {
    const contentId = Number(this.$route.params.contentId);
    const contentData = data.Content.filter(
      contentItem => contentItem.content_id === contentId
    )[0];
    return {
      contentId: contentId,
      title: contentData.title,
      context: contentData.context,
      user: data.User.filter(item => item.user_id === contentData.user_id)[0]
        .name,
      created: contentData.created_at
    };
  },
  methods: {
    deleteData() {
      const content_index = data.Content.findIndex(
        contentItem => contentItem.content_id === this.contentId
      );
      data.Content.splice(content_index, 1); // 데이터 삭제
      this.$router.push({
        path: "/board/list"
      });
    },
    updateData() {
      this.$router.push({
        path: `/board/create/${this.contentId}`
      });
    }
  },
  components: {
    CommentList,
    BaseButton
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