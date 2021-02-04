<template>
  <div
    @click="viewRecipeDetail"
    class="font-S-CoreDream-light flex flex-col justify-center card-corner max-w-sm rounded overflow-hidden bg-white m-4 shadow-lg pb-2 transition duration-200 ease-in-out transform hover:scale-105"
  >
    <img
      class="w-full h-64 object-cover"
      :src="imgsrc"
      alt="Sunset in the mountains"
    />

    <span class="font-bold text-xl mt-4 mb-6 text-center">{{
      cocktailname
    }}</span>

    <section class="">
      <span
        v-for="tag in tags"
        :key="tag"
        class="w-max inline-block bg-red-200 rounded-full px-3 py-1 text-sm font-semibold ml-2 mb-2"
        >#{{ tag }}</span
      >
    </section>
    <section class="flex items-center mt-4">
      <img
        src="../../assets/img/mr.fox.jpg"
        class="w-10 h-10 rounded-full ml-4 mr-2"
      />
      <span class="ml-2 text-base font-semibold">{{ username }}</span>
      <section class="flex justify-center justify-self-end ml-auto mr-4">
        <article class="flex items-center">
          <img
            src="../../assets/icon/like.png"
            class="w-6 h-6 object-contain ml-4 mr-2"
          />
          <span class="font-xs font-medium">
            {{ like_cnt }}
          </span>
        </article>
        <article class="flex items-center">
          <img
            src="../../assets/icon/bookmarked.png"
            class="w-4 h-4 object-contain ml-4 mr-2"
          />
          <span class="font-xs font-medium">
            {{ bookmark_cnt }}
          </span>
        </article>
      </section>
    </section>
  </div>
</template>

<script>
export default {
  props: [
    "pk_article",
    "img_path",
    "cocktailname",
    "username",
    "tag",
    "like_cnt",
    "bookmark_cnt",
  ],
  data() {
    return {
      tags: [],
      imgsrc: require(this.img_path),
    };
  },
  created() {
    this.tags = this.tag.split("<br>");
  },
  methods: {
    viewRecipeDetail() {
      console.log(this.img_path);
      this.$router.push({
        path: `/recipe/detail/${this.pk_article}`,
      });
    },
  },
};
</script>
