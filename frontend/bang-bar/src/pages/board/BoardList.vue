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

         <div class="inline-block relative w-max">
          <select
            class="block appearance-none w-full text-lg bg-white hover:bg-gray-100 px-10 py-2 rounded-full shadow-lg leading-tight border-4 border-transparent focus:outline-none focus:shadow-outline"
          >
            <option>전체</option>
            <option>제목</option>
            <option>내용</option>
            <option>작성자</option>
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
        </div> 
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
    <!-- <paginated-list :list-array="items" :pageSize="pageSize" @pageNum="pageNum"/> -->
     <section>
        <div class="font-S-CoreDream-light flex flex-col justify-items-center">
          <section class="mt-4 mx-32">
            <table
              class="corner w-full flex flex-row flex-no-wrap sm:bg-white overflow-hidden sm:shadow-lg my-5 font-color-black-400"
            >
        <thead role="rowgroup" class="border-none py-4">
          <tr role="row" class="font-S-CoreDream-light font-bold text-lg">
            <th class="py-4 px-3">말머리</th>
            <th class="w-3/7">제목</th>
            <th class="w-1/7">작성자</th>
            <th class="w-1/7">작성일</th>
            <th class="w-1/7">조회수</th>
          </tr>
        </thead>
        <tbody class="text-center">
          <tr
            class="flex flex-col flex-no wrap sm:table-row mb-2 sm:mb-0 hover:bg-gray-100 hover:font-medium cursor-pointer text-base"
            @click="rowClick(item)"
            v-for="item in items"
            :key="item.no"
          >
            <td class="py-4 text-sm">{{ item.category }}</td>
            <td class="text-left font-semibold">{{ item.title }}</td>
            <td class="">{{ item.user_name }}</td>
            <td class="font-color-black-200 text-sm">{{ item.created_at }}</td>
            <td class="text-sm">{{ item.hits }}</td>
          </tr>
          </tbody>
      </table>
    </section>
    <section class="font-sm flex justify-center items-center mt-2 mb-6">
      <base-button
        mode="outline"
        :disabled="pageNum === 0"
        @click="prevPage"
      >
        이전
      </base-button>

      <!-- 버튼  -->
      
      
      <span class="mx-4 font-semibold">{{ pageNum + 1 }} / {{ (Math.ceil(pageSize/10)) }}</span>

      <base-button
        mode="outline"
        :disabled="pageNum >= (Math.ceil(pageSize/10))-1"
        @click="nextPage"
      >
        다음
      </base-button>
    </section>
  </div>
     </section>
  </div>
</template>


<script>
// import PaginatedList from './PaginatedList.vue';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  components: { 
    // PaginatedList,
  },
  
  name: "BoardList",
  data() {
    
    return {
      
      writemode:null,
      pk_forum:'',
      pageNum: 0,
      keyword:"",
      pageSize:'',
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
      pageArray:this.items
    };
  },

  methods: {
    writeContent() {
      if(localStorage.getItem('pk_user')!=null){
        this.$router.push({
          path: `/board/create`
        });
      }else{
        alert("로그인을 해주세요.")
      }
    },

    nextPage () {
      this.pageNum += 1;
      this.getList();
    },
    prevPage () {
      this.pageNum -= 1;
      this.getList();
    },

    fnView(){
      // alert("이동!");
      <router-link to="/board/view"></router-link>
    },
    rowClick(item) {

      this.$router.push({
        path: `/board/detail/${item.pk_forum}`
      });
    },


    getList() {

        let params = {
          // 이부분을 현재페이지로 고치면됨.
          page_num :this.pageNum+1,
          page_range:1,
          search_type:'',
          keyword:'',
        };

        // this.axios.get(`${SERVER_URL}/forum/search-forum-list`, {
        this.axios.get(`${SERVER_URL}/forum/search-forum-list`, {
        headers: {
        'Access-Control-Allow-Origin': '*',
        'Content-Type': 'application/json; charset = utf-8',
        "Access-Control-Allow-Headers": "*",
        }, params
      })
      .then((result)=>{
        // this.items=result;
        console.log("디스페이지넘"+this.pageNum)
        console.log(result)
        this.items = result.data
      })
      .catch(e=>{
        console.log('error:',e)
      })
    },

    get_length(){
      this.axios.get(`${SERVER_URL}/forum/forum_cnt`, {
        headers: {
          'Access-Control-Allow-Origin': '*',
          'Content-Type': 'application/json; charset = utf-8',
          "Access-Control-Allow-Headers": "*",
        }
      })
      .then((result)=>{
        // this.items=result;
        console.log(result)
        this.pageSize=result.data
      })
      .catch(e=>{
        console.log('error:',e)
      })
    },

    search_board(){
      this.axios.get(`${SERVER_URL}/forum/search-forum-list/`+this.keyword, {
        headers: {
        'Access-Control-Allow-Origin': '*',
        'Content-Type': 'application/json; charset = utf-8',
        "Access-Control-Allow-Headers": "*",
        }
      })
      .then((result)=>{
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
      this.get_length()
  },

};
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
    @media (min-width: 640px) {
  table {
    display: inline-table !important;
  }
  thead tr:not(:first-child) {
    display: none;
  }
}
/* td:not(:last-child) {
  border-bottom: 0;
}
th:not(:last-child) {
  border-bottom: 2px solid rgba(0, 0, 0, 0.1);
} */
th {
  border-bottom: 2px solid rgba(0, 0, 0, 0.1);
}
.corner {
  border-radius: 45px;
}
</style>