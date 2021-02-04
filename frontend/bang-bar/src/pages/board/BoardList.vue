<template>
  <div class="flex flex-col justify-items-center px-16">
    <span
      class="text-center my-10 text-6xl font-S-CoreDream-medium font-bold font-color-black-400"
      >게시판</span
    >
    <section id="search-bar" class="flex flex-row mb-6 px-16 font-S-CoreDream-light">
      <article class="flex justify-center justify-self-start">
        <base-button mode="important" @click="writeContent" >글쓰기</base-button>
      </article>
      <article class="flex flex-1"></article>
      <article class="flex justify-center justify-self-end">

<!-- 제목검색으로 변경 -->

        <!-- <div class="inline-block relative w-max">
          <select
            class="block appearance-none w-full text-lg bg-white hover:bg-gray-100 px-10 py-2 rounded-full shadow-lg leading-tight border-4 border-transparent focus:outline-none focus:shadow-outline"
          >
            <option>전체</option>
            <option>공지사항</option>
            <option>후기</option>
            <option>질문</option>
          </select>
          <div
            class="pointer-events-none absolute inset-y-0 right-0 flex items-center px-2 text-gray-700"
          >
           <svg
              class="fill-current h-4 w-4"
              xmlns="http://www.w3.org/2000/svg"
              viewBox="0 0 20 20"
            >
              <path
                d="M9.293 12.95l.707.707L15.657 8l-1.414-1.414L10 10.828 5.757 6.586 4.343 8z"
              />
            </svg>
          </div>
        </div> -->
        <div class="mx-4 flex-auto inline-block">
          <input
            class="text-lg text-left shadow-lg appearance-none rounded-full w-full px-10 py-2 leading-tight border-4 border-transparent hover:bg-gray-100 focus:outline-none focus:shadow-outline focus:border-gray-200"
            id="search"
            type="text"
            placeholder="검색"
            v-model="keyword"
            @keydown.enter="search_board()"
          />
        </div>
        <base-button @click="search_board()">검색</base-button>
      </article>
    </section>
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
      writemode:null,
      keyword:"",
      currentPage: 1, // 현재 페이지
      perPage: 10, // 페이지당 보여줄 갯수
      pageSize:10,
      // bootstrap 'b-table' 필드 설정
            // bootstrap 'b-table' 필드 설정
      fields: [
        {
          key: "category",
          label: "카테고리"
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
        },
        {
          key: "hits",
          label : "조회수"

        }
      ],
      items: [],
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
      if(localStorage.getItem('pk_user')!=null){
      this.$router.push({
        path: `/board/create`
      });
    }else{
      alert("로그인을 해주세요.")
    }
    },
    getList() {

        let params = {
          page_num : 0
        };

        // this.axios.get(`${SERVER_URL}/forum/search-forum-list`, {
        this.axios.get('http://localhost:8081/forum/search-forum-list', {
        headers: {
        'Access-Control-Allow-Origin': '*',
        'Content-Type': 'application/json; charset = utf-8'
        }, params
      })
      .then((result)=>{
        // this.items=result;
        // console.log(result)
        this.items = result.data
      })
      .catch(e=>{
        console.log('error:',e)
      })
    },

    search_board(){
      this.axios.get('http://localhost:8081/forum/search-forum-list/'+this.keyword, {
        headers: {
        'Access-Control-Allow-Origin': '*',
        'Content-Type': 'application/json; charset = utf-8'
        }
      })
      .then((result)=>{
        // this.items=result;
        console.log(result)
        this.items = result.data
      })
      .catch(e=>{
        console.log('error:',e)
      })
    }
  },
  
  computed: {
    
    rows() {
      return this.items.length;
    }
  },
  created() {
    this.pageArray=this.items;
    this.writemode=localStorage.getItem("pk_user");
  },
  mounted() {
      this.getList()
      // console.log(this.items);
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