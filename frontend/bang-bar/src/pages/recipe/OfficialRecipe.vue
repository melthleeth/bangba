<template>
  <div class="flex flex-col justify-items-center">
    <span class="title text-center my-10">오피셜 레시피</span>
    <div class=" grid grid-cols-4 grid-flow-row gap-4">
      <recipe-card
        v-for="cocktail in cocktails"
        :key="cocktail.no"
        :cocktailname="cocktail.cocktailname"
        :tag="cocktail.tag"
        :username="cocktail.username"
        :like="cocktail.like"
        :bookmared="cocktail.bookmared"
      >
      </recipe-card>
    </div>
  </div>
</template>

<script>
import recipe from "../../data/recipe.js";
import RecipeCard from '../../components/recipes/RecipeCard.vue';
export default {
  components: {
    RecipeCard,
  },
  data() {
    return {
      cocktails: recipe.data,
    };
  },
};
</script>

<style scoped>
.title {
  font-family: Noto Sans KR;
  font-style: normal;
  font-weight: bold;
  font-size: 64px;
  line-height: 93px;

  color: #23232f;
}

.card-corner {
  border-radius: 30px;
}
</style>
