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
      <!-- 후기/질문 탭용 버튼 -->
      <article>
        <button class="mx-3">후기</button>
        <button>질문</button>
      </article>

      <article class="flex flex-1"></article>
      <article class="flex justify-center justify-self-end">
        <!-- 말머리 선택 드롭다운 -->
        <div class="inline-block relative w-max">
          <select v-model="search_type"
            class="block appearance-none w-full text-lg bg-white hover:bg-gray-100 px-10 py-2 rounded-full shadow-lg leading-tight border-4 border-transparent focus:outline-none focus:shadow-outline"
          >
            <option>제목</option>
            <option>내용</option>
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
        <!-- 검색창 제목과 내용으로-->
        <div class="mx-4 flex-auto inline-block">
          <input
            class="text-lg text-left shadow-lg appearance-none rounded-full w-full px-10 py-2 leading-tight border-4 border-transparent hover:bg-gray-100 focus:outline-none focus:shadow-outline focus:border-gray-200"
            id="search"
            type="text"
            placeholder="검색"
            v-model="keyword"
            @keydown.enter="getList()"
          />
        </div>
        <base-button @click="getList()">검색</base-button>
      </article>
    </section>

    <!-- 본문 내용 -->
    <section class="font-S-CoreDream-light flex flex-col justify-items-center">
      <!-- 게시판 테이블 -->
      <section class="mt-4 mx-32">
        <table
          class="corner w-full flex flex-row flex-no-wrap sm:bg-white overflow-hidden sm:shadow-lg my-5 font-color-black-400 table-fixed"
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
              <td class="text-left font-semibold truncate">{{ item.title }}</td>
              <td class="truncate">{{ item.user_name }}</td>
              <td class="font-color-black-200 text-sm">{{ item.created_at }}</td>
              <td class="text-sm">{{ item.hits }}</td>
            </tr>
          </tbody>
        </table>
      </section>
      <!-- 페이지네이션바 -->
      <section>
        <div class="flex flex-col items-center my-12">
            <div class="flex text-gray-700">
                <button class="h-8 w-8 mr-1 flex justify-center items-center  cursor-pointer">
                    <svg xmlns="http://www.w3.org/2000/svg" width="100%" height="100%" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-chevron-left w-4 h-4">
                        <polyline points="15 18 9 12 15 6"></polyline>
                    </svg>
                </button>
                <ul class="flex h-8 font-medium ">
                  <li
                    class="w-8 md:flex justify-center items-center hidden  cursor-pointer leading-5 transition duration-150 ease-in  border-t-2 border-transparent" 
                    v-for="(page, idx) in page_total_cnt" 
                    :key="idx"
                    @click="check(idx)"
                  >{{page}}</li>
                </ul>
                <button class="h-8 w-8 ml-1 flex justify-center items-center  cursor-pointer">
                    <svg xmlns="http://www.w3.org/2000/svg" width="100%" height="100%" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-chevron-right w-4 h-4">
                        <polyline points="9 18 15 12 9 6"></polyline>
                    </svg>
                </button>
            </div>
        </div>
      </section>
      <!-- 세진스표 페이지네이션 버튼 -->
      <!-- <section class="font-sm flex justify-center items-center mt-2 mb-6">
        <base-button
          mode="outline"
          :disabled="pageNum === 0"
          @click="prevPage"
        >
          이전
        </base-button>
        <span class="mx-4 font-semibold">{{ pageNum + 1 }} / {{ page_total_cnt }}</span>

        <base-button
          mode="outline"
          :disabled="pageNum >= page_total_cnt-1"
          @click="nextPage"
        >
          다음
        </base-button>
      </section> -->
    </section>
  </div>
</template>


<script>
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  components: { 
  },
  
  name: "BoardList",
  data() {
    
    return {
      writemode:null,
      pk_forum:'',
      pageNum: 0,
      keyword:"",
      search_type: "제목",
      page_total_cnt:'',
      items: [],
      pageArray:this.items,
      time_conver:'',
      forum_cnt_per_page: 10, //한 페이지당 보여질 게시글 수
      range_cnt: 5, //한 페이지에 보여지는 범위의 수
      
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

    check (idx) {
      this.pageNum = idx;
      console.log("pageNum", this.pageNum);
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
          search_type:this.search_type,
          keyword:this.keyword,
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
        // console.log("디스페이지넘"+this.pageNum)
        // console.log(result)

        this.items = result.data
        
        this.convert_time();
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
        // console.log(result)
        this.page_total_cnt= Math.ceil(result.data/this.forum_cnt_per_page)
      })
      .catch(e=>{
        console.log('error:',e)
      })
    },

    convert_time(){
      for(var i=0;i<this.items.length;i++){
          var Y=String(this.items[i].created_at).substring(0,4)
          var M=String(this.items[i].created_at).substring(4,6)
          var D=String(this.items[i].created_at).substring(6,8)

          var H=String(this.items[i].created_at).substring(8,10)
          var Min=String(this.items[i].created_at).substring(10,12)
          var S=String(this.items[i].created_at).substring(12,14)


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
          if(month===M && D===date){
            answer=H+":"+Min+":"+S;  
          }else{
            answer=Y+"."+M+"."+D;
          }
          this.items[i].created_at=answer;
      }
    },
    
    // get_end_page(){
    //   this.axios.get(`${SERVER_URL}/forum/search-forum-list/`+this.keyword, {
    //     headers: {
    //     'Access-Control-Allow-Origin': '*',
    //     'Content-Type': 'application/json; charset = utf-8',
    //     "Access-Control-Allow-Headers": "*",
    //     }
    //   })
    //   .then((result)=>{
    //     this.items = result.data
    //   })
    //   .catch(e=>{
    //     console.log('error:',e)
    //   })
    // },

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