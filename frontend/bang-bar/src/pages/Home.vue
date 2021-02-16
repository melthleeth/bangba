<template>
  <div class="flex flex-row place-content-center">
    <section class="flex-1">
      <article class="pl-20 mt-32">
        <div
          class="flex flex-col tracking-wide font-Abril-Fatface font-color-black-400 block align-middle text-6xl font-normal mb-16"
        >
          <span class="mb-4">Search Your</span>
          <span>Cocktail Taste.</span>
        </div>
        <section class="flex items-center">
          <div class="inline-block relative w-max">
            <select
              class="block appearance-none w-full text-base bg-white hover:bg-gray-100 px-8 py-4 rounded-full shadow-lg leading-tight border-3 border-transparent focus:outline-none focus:shadow-outline"
            >
              <option>통합</option>
              <option>오피셜</option>
              <option>커스텀</option>
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
          <div class="ml-4 flex-auto inline-block">
            <input
              class="text-base text-left shadow-lg appearance-none rounded-full w-full px-6 py-4 leading-tight border-3 border-transparent hover:bg-gray-100 focus:outline-none focus:shadow-outline focus:border-gray-200"
              id="search"
              type="text"
              placeholder="검색"
            />
          </div>
          <div class="w-10 h-10 ml-4 mr-10">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              fill="none"
              viewBox="0 0 24 24"
              stroke="currentColor"
            >
              <path
                stroke-linecap="round"
                stroke-linejoin="round"
                stroke-width="2"
                d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"
              />
            </svg>
          </div>
        </section>
      </article>
    </section>
    <section class="flex-1">
      <article class="flex">
        <base-card size="box-290" class="flex flex-col justify-items-center">
          <span class="font-S-CoreDream-medium text-2xl font-bold text-center py-4"
            >오늘의 칵테일</span
          >
          <section
            class="flex flex-col justify-items-center transition duration-200 ease-in-out transform hover:scale-105"
          >
            <img
              class="object-cover w-56 m-auto"
              src="../assets/img/tequila-sunrise.png"
              alt="Sunset in the mountains"
            />
            <div class="font-S-CoreDream-medium text-xl mb-2 px-6 pt-4">
              테킬라 선라이즈
            </div>
          </section>

          <span class="text-gray-700 text-left px-4 mb-4 text-sm leading-relaxed">
            일출과 같이 무언가로부터 희망을 찾고 싶을 때, 활력을 얻고 싶을 때 한잔 만들어보는 것은
            어떨까?
          </span>
        </base-card>
        <base-card size="box-290" class="flex flex-col justify-items-center">
          <span class="font-S-CoreDream-medium text-2xl font-bold text-center py-4"
            >금주의 랭킹</span
          >
          <section
            class="transition duration-200 ease-in-out transform hover:scale-105 hover:shadow-lg"
            v-for="(ranking, index) in filteredRanking"
            :key="ranking.user_name"
            @click="saveUser(ranking.pk_user, ranking.user_name)"
          >
            <div class="flex items-center mt-4">
              <span class="text-2xl font-extrabold mx-4">{{ index + 1 }}</span>
              <img
                :src="
                  ranking.img_path === ''
                    ? 'https://www.lifewire.com/thmb/wTQhx22YA7ljA0-dTNKiHp2bReI=/1142x642/smart/filters:no_upscale()/iphonex_animoji_fox-59dd137c03f4020010a60b54.gif'
                    : ranking.img_path
                "
                class="w-10 h-10 object-cover rounded-full ml-4 mr-2"
                alt="profile image"
              />
              <span class="text-base font-medium ml-2">{{ ranking.user_name }}</span>
              <span class="text-base font-medium ml-2">{{ ranking.like_weekly }}</span>
            </div>
          </section>
        </base-card>
      </article>
      <article>
        <base-card
          size="box-620"
          class="transition duration-200 ease-in-out transform hover:scale-105"
          v-for="article in weeklyBest"
          :key="article.pk_board"
        >
          <section class="flex flex-col px-4 py-2">
            <div class="flex items-center mb-2">
              <span class="text-base font-S-CoreDream-medium font-medium text-center"
                >[{{ article.category }}] {{ article.title }}</span
              >
              <article class="flex justify-self-end ml-auto items-center">
                <img
                  :src="article.imgsrc"
                  class="board-post ml-4 mr-2 object-cover rounded-full"
                  alt="profile image"
                />
                <span class="text-sm font-semibold mr-2">{{ article.username }}</span>
                <span class="text-xs text-gray-400">{{ article.time }}</span>
              </article>
            </div>
            <span class="text-sm block leading-relaxed">{{ article.contents }}</span>
          </section>
        </base-card>
      </article>
    </section>
  </div>
</template>

<script>
import BaseCard from '../components/ui/BaseCard.vue';
export default {
  components: { BaseCard },
  data() {
    return {
      isLoading: false,
      error: null,
      // ranking: [
      //   {
      //     pk_user: 22,
      //     imgsrc: require("../assets/img/mr.fox.jpg"),
      //     username: "미스터 여우씨",
      //   },
      //   {
      //     pk_user: 3,
      //     imgsrc: require("../assets/img/profile2.png"),
      //     username: "의문의 루피",
      //   },
      //   {
      //     pk_user: 5,
      //     imgsrc: require("../assets/img/profile3.jpg"),
      //     username: "베르나르 무민무민",
      //   },
      //   {
      //     pk_user: 46,
      //     imgsrc: require("../assets/img/profile4.jpeg"),
      //     username: "이시국 칵테일",
      //   },
      //   {
      //     pk_user: 1,
      //     imgsrc: require("../assets/img/profile5.jpg"),
      //     username: "개발 안맞아",
      //   },
      // ],
      weeklyBest: [
        {
          pk_board: 1,
          category: '자유게시판',
          title: '소맥 황금비율 딱 알려드림',
          imgsrc: require('../assets/img/profile2.png'),
          username: '의문의 루피',
          time: '14:41',
          contents: '소맥 황금비율 알려드립니다.',
        },
        {
          pk_board: 7,
          category: '커스텀 레시피',
          title: '소주 모히또',
          imgsrc: require('../assets/img/mr.fox.jpg'),
          username: '미스터 여우씨',
          time: '14:30',
          contents:
            '죽기 전에 극락 가는 방법 알려드립니다. 이 비율로 타시면 무조건 대박입니다... 널리 퍼트려주세요',
        },
        {
          pk_board: 12,
          category: '자유게시판',
          title: '요새 핫한 칵테일바 추천',
          imgsrc: require('../assets/img/profile4.jpeg'),
          username: '이시국 칵테일',
          time: '14:29',
          contents:
            '안녕하세요 이시국 칵테일입니다. 오늘은 이시국에 갈만한 칵테일 바 몇 개 추천드림니다. 우선 홍대쪽부터 알려드림.',
        },
      ],
    };
  },
  computed: {
    filteredRanking() {
      const ranking = this.$store.getters['ranking/Ranking']; //모듈/getters
      console.log(ranking);
      return ranking;
    },
    hasRanking() {
      return !this.isLoading && this.$store.getters['ranking/Ranking'];
    },
  },
  created() {
    this.LoadRanking();
  },
  methods: {
    async LoadRanking(refresh = true) {
      this.isLoading = true;
      try {
        await this.$store.dispatch('ranking/LoadRanking', {
          forceRefresh: refresh,
        });
      } catch (error) {
        this.error = error.message || '랭킹을 불러오는데 문제가 발생했습니다.';
      }
      this.isLoading = false;
    },
    handleError() {
      this.error = null;
    },
    saveUser(pkOther, nickname) {
      localStorage.setItem('pkOther', pkOther);
      this.$router.push({
        path: `/mypageother/${nickname}`,
      });
    },
  },
};
</script>

<style scoped>
html,
body,
section {
  height: 100%;
  /* font-family: 'NIXGONM-Vb'; */
  /* font-family: "S-CoreDream-4Regular"; */
  font-family: 'S-CoreDream-3Light';
}

.box-290 {
  width: 310px;
  /* height: 430px; */
  background-color: white;
  border-radius: 30px;
  text-align: center;
}

.box-620 {
  width: 660px;
}

.board-post {
  width: 25px;
  height: 25px;
}
</style>
