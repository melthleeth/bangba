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
        <section class="flex justify-center px-32 mb-6 font-S-CoreDream-light">
          <!-- <base-card
        class="flex-auto inline-block flex flex-col justify-items-center"
      >
        <span
          class="font-S-CoreDream-medium text-2xl font-bold text-center py-4"
          >새로운 레시피</span
        >
        <section class="font-S-CoreDream-light">
          <div v-if="isLoading" class="my-32">
        <base-spinner></base-spinner>
      </div>
      <div
        v-else-if="filteredNewArticle.length > 0"
        class=" grid grid-cols-3 grid-flow-row gap-4 mx-auto"
      >
        <recipe-card
          v-for="newarticle in filteredNewArticle"
          :key="newarticle.pk_article"
          :img_path="newarticle.img_path"
          :user_name="newarticle.user_name"
          :cocktailname="newarticle.title_kor"
          :tag="newarticle.tag"
          :like_cnt="newarticle.like_cnt"
          :bookmark_cnt="newarticle.bookmark_cnt"
        >
        </recipe-card>
      </div>
      <span
        v-else
        class="text-2xl text-center my-32 font-S-CoreDream-medium font-bold font-color-black-200"
        >등록된 레시피가 없습니다.</span
      >
        </section>
      </base-card> -->
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
          v-for="newforum in filteredNewForum"
          :key="newforum.pk_forum"
        >
          <section class="flex flex-col px-4 py-2">
            <div class="flex items-center mb-2">
              <span class="text-base font-S-CoreDream-medium font-medium text-center"
                >[{{ newforum.category }}] {{ newforum.title }}</span
              >
              <article class="flex justify-self-end ml-auto items-center">
                <img
                  :src="
                    newforum.img_path === ''
                      ? 'https://www.lifewire.com/thmb/wTQhx22YA7ljA0-dTNKiHp2bReI=/1142x642/smart/filters:no_upscale()/iphonex_animoji_fox-59dd137c03f4020010a60b54.gif'
                      : newforum.img_path
                  "
                  class="w-10 h-10 object-cover rounded-full ml-4 mr-2"
                  alt="profile image"
                />
                <span class="text-sm font-semibold mr-2">{{ newforum.user_name }}</span>
                <span class="text-xs text-gray-400">
                  <!-- {{  newforum.created_at }} -->
                  {{ convert_time(newforum.created_at) }}
                </span>
              </article>
            </div>
            <span class="text-sm block leading-relaxed truncate">{{ newforum.content }}</span>
          </section>
        </base-card>
      </article>
    </section>
  </div>
</template>

<script>
// import RecipeCard from "../components/recipes/RecipeCard.vue";
export default {
  // components: {
  //   RecipeCard },
  data() {
    return {
      isLoading: false,
      error: null,
    };
  },
  computed: {
    filteredRanking() {
      const ranking = this.$store.getters['main/Ranking']; //모듈/getters
      console.log(ranking);
      return ranking;
    },
    hasRanking() {
      return !this.isLoading && this.$store.getters['main/Ranking'];
    },
    filteredNewArticle() {
      const newarticle = this.$store.getters['main/NewArticle']; //모듈/getters
      console.log(newarticle);
      return newarticle;
    },
    hasNewArticle() {
      return !this.isLoading && this.$store.getters['main/NewArticle'];
    },
    filteredNewForum() {
      const newforum = this.$store.getters['main/NewForum']; //모듈/getters
      console.log(newforum);
      return newforum;
    },
    hasNewForum() {
      return !this.isLoading && this.$store.getters['main/NewForum'];
    },
  },
  created() {
    this.LoadRanking();
    this.LoadNewArticle();
    this.LoadNewForum();
  },
  methods: {
    convert_time(time) {
      for (var i = 0; i < time.length; i++) {
        var Y = String(time).substring(0, 4);
        var M = String(time).substring(4, 6);
        var D = String(time).substring(6, 8);

        var H = String(time).substring(8, 10);
        var Min = String(time).substring(10, 12);
        var S = String(time).substring(12, 14);

        //현재 월
        let month = new Date().getMonth() + 1; // 월
        let date = new Date().getDate(); // 날짜

        if (month < '10') {
          month = '0' + month;
        }
        if (date < '10') {
          date = '0' + date;
        }
        var answer = '';
        if (String(month) === M && D === String(date)) {
          answer = H + ':' + Min + ':' + S;
        } else {
          answer = Y + '.' + M + '.' + D;
        }
        return answer;
      }
    },

    async LoadRanking(refresh = true) {
      this.isLoading = true;
      try {
        await this.$store.dispatch('main/LoadRanking', {
          forceRefresh: refresh,
        });
      } catch (error) {
        this.error = error.message || '랭킹을 불러오는데 문제가 발생했습니다.';
      }
      this.isLoading = false;
    },
    async LoadNewArticle(refresh = true) {
      this.isLoading = true;
      try {
        await this.$store.dispatch('main/LoadNewArticle', {
          forceRefresh: refresh,
        });
      } catch (error) {
        this.error = error.message || '최신 레시피를 불러오는데 문제가 발생했습니다.';
      }
      this.isLoading = false;
    },
    async LoadNewForum(refresh = true) {
      this.isLoading = true;
      try {
        await this.$store.dispatch('main/LoadNewForum', {
          forceRefresh: refresh,
        });
      } catch (error) {
        this.error = error.message || '최신 게시글을 불러오는데 문제가 발생했습니다.';
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
