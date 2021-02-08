<template>
  <div class="flex justify-center font-S-CoreDream-light mt-20 font-color-black-400">
    <section class="w-1/3 flex flex-col justify-items-center">
      <base-card class="flex flex-col justify-items-center">
        <img
          class="object-cover w-auto img-height rounded-3xl mx-6 mt-6"
          :src="imgsrc"
          alt="Sunset in the mountains"
        />
        <span
          class="text-2xl mt-6 mb-8 text-center font-S-CoreDream-medium font-bold"
          >{{ title_kor }}
        </span>
      </base-card>
      <article class="flex text-center">
        <base-card
          class="flex-1 flex flex-col justify-items-center items-center transition duration-200 ease-in-out transform hover:scale-105"
        >
          <img
            src="../../assets/icon/like@2x.png"
            class="mr-0 w-12 h-12 object-contain"
            alt="like icon"
          />
          <span class="mt-2 font-S-CoreDream-medium">{{ like_cnt }}</span>
        </base-card>
        <base-card
          class="flex-1 flex flex-col justify-items-center items-center transition duration-200 ease-in-out transform hover:scale-105"
        >
          <img
            src="../../assets/icon/bookmark@2x.png"
            class="mr-0 w-12 h-12 object-contain"
            alt="bookmark icon"
          />
          <span class="mt-2 font-S-CoreDream-medium">{{ bookmark_cnt }}</span>
        </base-card>
      </article>
    </section>
    <section class="flex w-1/2 flex-col justify-items-center ">
      <base-card class="flex flex-col">
        <span class="mx-4 my-2 leading-relaxed">{{ content }}</span>
      </base-card>
      <article>
        <span
          v-for="tag in tags"
          :key="tag"
          class="w-max inline-block bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold ml-2 mb-2"
          >#{{ tag }}</span
        >
      </article>
      <article class="flex">
        <base-card class="w-1/2 flex flex-col justify-items-center">
          <span
            class="text-xl font-S-CoreDream-medium font-bold text-center mt-4 mb-6"
            >재료</span
          >
          <ul class="mx-4">
            <li class="mb-2" v-for="alcohol in alcohols" :key="alcohol">
              🍸 {{ alcohol }}
            </li>
            <li
              class="mb-2"
              v-for="ingredient in ingredients"
              :key="ingredient"
            >
              🥄 {{ ingredient }}
            </li>
          </ul>
        </base-card>
        <base-card class="w-1/2 flex flex-col justify-items-center">
          <span
            class="text-xl font-S-CoreDream-medium font-bold text-center mt-4 mb-6"
            >레시피</span
          >
          <ol class="mx-4">
            <li class="mb-2" v-for="(recipe, index) in recipes" :key="recipe">
              {{ index + 1 }}. {{ recipe }}
            </li>
          </ol>
        </base-card>
      </article>
    </section>
  </div>
</template>

<script>
export default {
  props: ["pk_article"],
  data() {
    return {
      selectedRecipe: null,
    };
  },
  computed: {
    title_kor() {
      return this.selectedRecipe.title_kor;
    },
    imgsrc() {
      return this.selectedRecipe.img_path;
    },
    like_cnt() {
      return this.selectedRecipe.like_cnt;
    },
    bookmark_cnt() {
      return this.selectedRecipe.bookmark_cnt;
    },
    content() {
      return this.selectedRecipe.content;
    },
    tags() {
      return this.selectedRecipe.tag.split("<br>");
    },
    alcohols() {
      const alcoholItem = this.selectedRecipe.alcohol.split("<br>");
      const modified = [];
      for (const item of alcoholItem) {
        const alcoholInfo = item.split("/");
        const modifiedItem = `${alcoholInfo[0]} ${alcoholInfo[1]}${alcoholInfo[2]}`;
        modified.push(modifiedItem);
      }
      return modified;
    },
    ingredients() {
      const ingredientItem = this.selectedRecipe.ingredient.split("<br>");
      const modified = [];
      for (const item of ingredientItem) {
        const ingredientInfo = item.split("/");
        const modifiedItem = `${ingredientInfo[1]} ${ingredientInfo[2]}${ingredientInfo[3]}`;
        modified.push(modifiedItem);
      }
      return modified;
    },
    recipes() {
      return this.selectedRecipe.recipe.split("<br>");
    },
  },
  created() {
    this.selectedRecipe = this.$store.getters["recipes/recipes"].find(
      (recipe) => recipe.pk_article.toString() === this.pk_article
    );
  },
};
</script>

<style scoped>
.img-height {
  height: 30rem;
}
</style>
