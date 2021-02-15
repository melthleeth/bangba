<template>
  <div class="flex flex-col justify-items-center mx-16 font-color-black-400">
    <span
      class="text-4xl text-center my-10 font-S-CoreDream-medium font-bold font-color-black-400"
      >커스텀 레시피</span
    >
    <section class="flex justify-center px-32 mb-6 font-S-CoreDream-light">
      <base-card size="box-290" class="flex flex-col justify-items-center">
          <span
            class="font-S-CoreDream-medium text-2xl font-bold text-center py-4"
            >금주의 랭킹</span
          >
          <section
            class="transition duration-200 ease-in-out transform hover:scale-105 hover:shadow-lg"
            v-for="(ranking, index) in filteredRanking"
            :key="ranking.user_name" 
          >
            <div class="flex items-center mt-4">
              <span class="text-2xl font-extrabold mx-4">{{ index + 1 }}</span>
              <img
                :src="ranking.img_path === '' ? 
                'https://www.lifewire.com/thmb/wTQhx22YA7ljA0-dTNKiHp2bReI=/1142x642/smart/filters:no_upscale()/iphonex_animoji_fox-59dd137c03f4020010a60b54.gif' 
                : ranking.img_path" 
                class="w-10 h-10 object-cover rounded-full ml-4 mr-2"
                alt="profile image"
              />
              <span class="text-base font-medium ml-2">{{
                ranking.user_name
              }}</span>
              <span class="text-base font-medium ml-2">{{
                ranking.like_weekly
              }}</span>
            </div>
          </section>
        </base-card>
      <base-card
        class="flex-auto inline-block flex flex-col justify-items-center"
      >
        <span
          class="font-S-CoreDream-medium text-2xl font-bold text-center py-4"
          >주간 베스트</span
        >
        <section class="font-S-CoreDream-light">
          <div v-if="isLoading" class="my-32">
        <base-spinner></base-spinner>
      </div>
      <div
        v-else-if="filteredArticleRanking.length > 0"
        class=" grid grid-cols-3 grid-flow-row gap-4 mx-auto"
      >
        <recipe-card
          v-for="articleranking in filteredArticleRanking"
          :key="articleranking.pk_article"
          :img_path="articleranking.img_path"
          :user_name="articleranking.user_name"
          :cocktailname="articleranking.title_kor"
          :tag="articleranking.tag"
          :like_cnt="articleranking.like_cnt"
          :bookmark_cnt="articleranking.bookmark_cnt"
        >
        </recipe-card>
      </div>
      <span
        v-else
        class="text-2xl text-center my-32 font-S-CoreDream-medium font-bold font-color-black-200"
        >등록된 레시피가 없습니다.</span
      >
        </section>
      </base-card>
    </section>
    <section class="flex justify-end mx-12">
      <base-button
        class="w-max  px-8 py-2"
        mode="important"
        link
        to="register/custom"
        >레시피 등록</base-button
      >
    </section>
    <section class="flex items-center mx-64 mb-12 font-S-CoreDream-light">
      <div class="inline-block relative w-max">
        <select
          class="block appearance-none w-full text-base bg-white hover:bg-gray-100 px-8 py-3 rounded-full shadow-lg leading-tight border-3 border-transparent focus:outline-none focus:shadow-outline"
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
          class="text-base text-left shadow-lg appearance-none rounded-full w-full px-8 py-3 leading-tight border-3 border-transparent hover:bg-gray-100 focus:outline-none focus:shadow-outline focus:border-gray-200"
          id="search"
          type="text"
          placeholder="검색"
        />
      </div>
      <div class="w-10 h-10 ml-4">
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
    <section class="flex flex-col">
      <div v-if="isLoading" class="my-32">
        <base-spinner></base-spinner>
      </div>
      <div
        v-else-if="filteredRecipes.length > 0"
        class=" grid grid-cols-4 grid-flow-row gap-4 mx-auto"
      >
        <recipe-card
          v-for="cocktail in filteredRecipes"
          :key="cocktail.pk_article"
          :pk_article="cocktail.pk_article"
          :img_path="cocktail.img_path"
          :user_name="cocktail.user_name"
          :cocktailname="cocktail.title_kor"
          :tag="cocktail.tag"
          :like_cnt="cocktail.like_cnt"
          :bookmark_cnt="cocktail.bookmark_cnt"
        >
        </recipe-card>
      </div>
      <span
        v-else
        class="text-2xl text-center my-32 font-S-CoreDream-medium font-bold font-color-black-200"
        >등록된 레시피가 없습니다.</span
      >
    </section>
  </div>
</template>

<script>
import RecipeCard from "../../components/recipes/RecipeCard.vue";
export default {
  components: {
    RecipeCard,
  },
  data() {
    return {
      isLoading: false,
      error: null,
      // ranking: [
      //   {
      //     pk_user: 22,
      //     imgsrc: require("../../assets/img/mr.fox.jpg"),
      //     username: "미스터 여우씨",
      //   },
      //   {
      //     pk_user: 3,
      //     imgsrc: require("../../assets/img/profile2.png"),
      //     username: "의문의 루피",
      //   },
      //   {
      //     pk_user: 5,
      //     imgsrc: require("../../assets/img/profile3.jpg"),
      //     username: "베르나르 무민무민",
      //   },
      //   {
      //     pk_user: 46,
      //     imgsrc: require("../../assets/img/profile4.jpeg"),
      //     username: "이시국 칵테일",
      //   },
      //   {
      //     pk_user: 1,
      //     imgsrc: require("../../assets/img/profile5.jpg"),
      //     username: "개발 안맞아",
      //   },
      // ],
    };
  },
  computed: {
    filteredRecipes() {
      const recipes = this.$store.getters["recipes/recipes"];
      // console.log(recipes);
      return recipes.filter((recipeItem) => {
        if (recipeItem.category === false) return true;
      });
    },
    hasRecipes() {
      return !this.isLoading && this.$store.getters["recipes/hasRecipes"];
    },
     filteredRanking() {
      const ranking = this.$store.getters["recipes/Ranking"]; //모듈/getters
      console.log(ranking);
      return ranking;
    },
    hasRanking() {
      return !this.isLoading && this.$store.getters["recipes/Ranking"];
    },
    filteredArticleRanking() {
      const articleranking = this.$store.getters["recipes/ArticleRanking"]; //모듈/getters
      console.log(articleranking);
      return articleranking;
    },
    hasArticleRanking() {
      return !this.isLoading && this.$store.getters["recipes/ArticleRanking"];
    },
  },
  created() {
    this.loadRecipes();
    this.LoadRanking();
    this.LoadArticleRanking();
  },
  methods: {
    async loadRecipes(refresh = true) {
      this.isLoading = true;
      try {
        await this.$store.dispatch("recipes/loadRecipes", {
          forceRefresh: refresh,
        });
      } catch (error) {
        this.error =
          error.message || "레시피를 불러오는데 문제가 발생했습니다.";
      }
      this.isLoading = false;
    },
    async LoadRanking(refresh = true) {
      this.isLoading = true;
      try {
        await this.$store.dispatch("recipes/LoadRanking", {
          forceRefresh: refresh,
        });
      } catch (error) {
        this.error =
          error.message || "랭킹을 불러오는데 문제가 발생했습니다.";
      }
      this.isLoading = false;
    }, async LoadArticleRanking(refresh = true) {
      this.isLoading = true;
      try {
        await this.$store.dispatch("recipes/LoadArticleRanking", {
          forceRefresh: refresh,
        });
      } catch (error) {
        this.error =
          error.message || "레시피 랭킹을 불러오는데 문제가 발생했습니다.";
      }
      this.isLoading = false;
    },
    handleError() {
      this.error = null;
    },
  },
  
};
</script>

<style scoped>
p {
  margin: 0;
  font-style: normal;
  font-weight: bold;
}

.title {
  color: #23232f;
}

</style>
