<template>
  <div>
    <span class="title text-center my-10 font-S-CoreDream-medium font-bold"
      >{{ title }}
    </span>
    <base-card>
      {{ content }}
    </base-card>
  </div>
</template>

<script>
export default {
  props: {
    pk_article: Number,
  },
  data() {
    return {
      selectedRecipe: null,
    };
  },
  computed: {
    title() {
      if (this.selectedRecipe.title_eng.length > 0)
        return (
          this.selectedRecipe.title_kor +
          " (" +
          this.selectedRecipe.title_eng +
          ")"
        );
      else return this.selectedRecipe.title_kor;
    },
    content() {
      return this.selectedRecipe.content;
    },
  },
  created() {
    this.selectedRecipe = this.$store.getters["recipes/recipes"].find(
      (recipe) => recipe.pk_article.toString() === this.pk_article
    );
    console.log(this.selectedRecipe);
    console.log(this.pk_article);
  },
};
</script>

<style scoped></style>
