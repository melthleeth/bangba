<template>
  <div class="flex flex-col font-S-CoreDream-light font-color-black-400 w-max">
    <span
      class="tracking-wider font-semibold text-2xl border-gray-800 border-b-4 font-S-CoreDream-medium w-max px-1 mt-10"
      >내가 쓴 글</span
    >
    {{myRecipes}}
    <div class="flex grid grid-cols-3 grid-flow-row gap-4"></div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      myRecipes:[]
    }
  },
  created() {
    this.loadMyRecipes();
    this.myRecipes = this.$store.getters["users/myRecipe"];
  },
  watch:{
    set_myRecipes(newVal) {
      this.myRecipes = newVal;
    }
  },
  computed:{
    set_myRecipes() {
      return this.$store.getters["users/myRecipe"];
    }
  },
  methods: {
    async loadMyRecipes() {
      await this.$store.dispatch("users/LoadMyRecipe");
    }
  }
};
</script>

<style scoped></style>
