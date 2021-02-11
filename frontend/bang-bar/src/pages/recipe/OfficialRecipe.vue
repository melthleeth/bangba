<template>
  <div class="flex flex-col justify-items-center mx-16 font-color-black-400">
    <span
      class="text-4xl text-center my-10 font-S-CoreDream-medium font-bold font-color-black-400"
      >오피셜 레시피</span
    >
    <section class="flex justify-end mx-12">
      <base-button
        class="w-max px-8 py-2"
        mode="important"
        link
        to="register/official"
        >레시피 등록</base-button
      >
    </section>
    <section id="search-bar" class="flex items-center mx-64 mb-12">
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
        v-else-if="hasRecipes"
        class="grid grid-cols-4 grid-flow-row gap-4 mx-auto"
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
    };
  },
  computed: {
    filteredRecipes() {
      const recipes = this.$store.getters["recipes/recipes"]; //모듈/getters
      console.log(recipes);
      return recipes.filter((recipeItem) => {
        if (recipeItem.category === true) return true;
      });
    },
    hasRecipes() {
      return !this.isLoading && this.$store.getters["recipes/hasRecipes"];
    },
  },
  created() {
    this.loadRecipes();
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
    handleError() {
      this.error = null;
    },
  },
};
</script>

<style scoped>
.title {
  font-size: 42px;
  line-height: 93px;
}

.card-corner {
  border-radius: 30px;
}
</style>
