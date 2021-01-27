<template>
  <div >
    <table border="1">
      <thead role="rowgroup" class>
        <tr role="row" class="">
          <th>말머리</th>
          <th>제목</th>
          <th>작성자</th>
          <th>작성일</th>
          <th>조회수</th>
        </tr>

      </thead>
      <tbody>
        <tr v-for="item in items" :key="item.no">
          <td>{{ item.content_id }}</td>
          <td>{{ item.title}}</td>
          <td>{{ item.user_name}}</td>
          <td>{{ item.created_at }}</td>
          <td>{{ item.user_id }}</td>
        </tr>
      </tbody>

    </table>

    <paginated-list :list-array="items" />
    <base-button @click="writeContent">글쓰기</base-button>
  </div>
</template>

<script>
import data from "@/data";
import BaseButton from '@/components/ui/BaseButton.vue';
import PaginatedList from './PaginatedList.vue';


export default {
  components: { 
    BaseButton,
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
      pageArray: items,
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
      items: items
    };
  },
  methods: {
    // rowClick(item, index, e) {
    //   this.$router.push({
    //     path: `/board/detail/${item.content_id}`
    //   });
    // },
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
  }
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