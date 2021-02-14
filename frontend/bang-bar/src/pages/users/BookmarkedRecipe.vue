<template>
  <div class="flex flex-col font-S-CoreDream-light font-color-black-400">
    <span
      class="tracking-wider font-semibold text-2xl border-gray-800 border-b-4 font-S-CoreDream-medium w-max px-1 mt-10"
      >북마크한 레시피</span
    >

    <section class="flex flex-col mt-4 mr-10">
      <div v-if="isLoading" class="my-32">
        <base-spinner></base-spinner>
      </div>
      <div
        v-else-if="filteredRecipes.length > 0"
        class=" grid grid-cols-3 grid-flow-row gap-4 mx-auto"
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
</style>
