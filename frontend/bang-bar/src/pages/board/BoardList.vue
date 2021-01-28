<template>
  <div class="container mx-auto">
    <paginated-list :list-array="items" />
  </div>
</template>

<script>
import data from "@/data";
import PaginatedList from './PaginatedList.vue';


export default {
  components: { 
    PaginatedList,
  },
  name: "BoardList",
  data() {
    // 정렬 : https://blog.naver.com/haskim0716n/221681695401
    let contentItems = data.Content.sort((a, b) => {
      return b.content_id - a.content_id;
    }); // 내림차순

    // User 와 Content 의 user_id 의 같은 번호를 찾아 Content 에 기존자료 + 'user_name' 으로 추가한다.
    let items = contentItems.map(contentItem => {
      return {
        ...contentItem,
        user_name: data.User.filter(userItem => {
          return contentItem.user_id === userItem.user_id;
        })[0].name
      };

    
    });
    
    return {
      // pageArray: [],
      currentPage: 1, // 현재 페이지
      perPage: 10, // 페이지당 보여줄 갯수
      pageSize:10,
      // bootstrap 'b-table' 필드 설정
            // bootstrap 'b-table' 필드 설정
      fields: [
        {
          key: "content_id",
          label: "번호"
        },
        {
          key: "title",
          label: "제목"
        },
        {
          key: "user_name",
          label: "글쓴이"
        },
        {
          key: "created_at",
          label: "작성일"
        }
      ],
      items: items,
      pageArray:items
    };
  },
  methods: {
    rowClick(item) {
      // alert(item.content_id)
      
      this.$router.push({
        path: `/board/detail/${item.content_id}`
      });
    },
    writeContent() {
      this.$router.push({
        path: `/board/create`
      });
    }
  },
  computed: {
    rows() {
      return this.items.length;
    }
  },
  created() {
    this.pageArray=this.items;

  },
};

/*
[예제] map --------------------
const objArr = [{ a: "a" }, { b: "b" }];

  0: {a: "a"}
  1: {b: "b"}

const altered = objArr.map(item => {
  return {
    ...item, // 기존자료 모두 추가
    c: "c" // 신규추가
  };
});

  0: {a: "a", c: "c"}
  1: {b: "b", c: "c"}

[예제] filter--------------------
const onlyA = altered.filter(item => {
  return item.a === "a"; // 'a' 인 값만 리턴
});

  0: {a: "a", c: "c"}
*/
</script>
<style scoped>
    .board{
        /* width:50%; */

        background-color: #FFFFFF;
        text-decoration: none;
        padding: 0.75rem 1.5rem;
        font: inherit;
        /* border: 0.1px solid #FFFFFF; */
        
        border-radius: 30px;
        margin-right: 0.5rem;
        /* display: inline-block; */
        transition: .3s ease-out;
        margin-bottom: 15px;
    }
</style>