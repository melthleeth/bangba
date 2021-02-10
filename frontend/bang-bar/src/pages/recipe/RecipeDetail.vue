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
          @click="clickLikeBtn"
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
          @click="clickBmarkBtn"
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
      likeBtn : false,
      bmarkBtn : false,
      like_cnt : 0,
      bookmark_cnt : 0
    };
  },
  watch :{
    setLikeBtn: function(newVal) {
      this.likeBtn = newVal;
    },
    setBmarkBtn: function(newVal) {
      this.bmarkBtn = newVal;
    },
    set_like_cnt: function(newVal) {
      this.like_cnt = newVal;
    }, 
    set_bookmark_cnt: function(newVal) {
      this.bookmark_cnt = newVal;
    }
  },
  computed: {
    title_kor() {
      return this.selectedRecipe.title_kor;
    },
    imgsrc() {
      return this.selectedRecipe.img_path;
    },
    set_like_cnt() {
      return this.$store.getters["likes/likeCnt"];
    },
    set_bookmark_cnt() {
      return this.$store.getters["likes/bmarkCnt"];
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
        const modifiedItem = `${ingredientInfo[0]} ${ingredientInfo[1]}${ingredientInfo[2]}`;
        modified.push(modifiedItem);
      }
      return modified;
    },
    recipes() {
      return this.selectedRecipe.recipe.split("<br>");
    },
    setLikeBtn() {
      return this.$store.getters["likes/likeBtn"];
    }, 
    setBmarkBtn() {
      return this.$store.getters["likes/bmarkBtn"];
    }
  },
  created() {
    this.selectedRecipe = this.$store.getters["recipes/recipes"].find(
      (recipe) => recipe.pk_article.toString() === this.pk_article
    );
    this.test();
  },
  methods: {
    test(){
      this.isLike();
      this.isBmark();
      this.likeBtn = this.$store.getters["likes/likeBtn"];
      this.bmarkBtn = this.$store.getters["likes/bmarkBtn"];
      this.like_cnt = this.$store.getters["likes/likeCnt"];
      this.bookmark_cnt = this.$store.getters["likes/bmarkCnt"];
    },
    async isLike() {
      const btnInfo = {
        isLike : true, 
        article_no : this.pk_article,
        like_cnt : this.selectedRecipe.like_cnt
      };
      await this.$store.dispatch("likes/isClick", btnInfo);
    }, 
    async isBmark() {
      const btnInfo = {
        isLike : false,
        article_no : this.pk_article,
        bookmark_cnt : this.selectedRecipe.bookmark_cnt
      };
      await this.$store.dispatch("likes/isClick", btnInfo);
    }, 
    async clickLikeBtn() {
      if(localStorage.getItem("user_name") === null) {
        alert("로그인이 필요한 기능입니다.")
        return;
      }
      const btnInfo = {
        isLike : true,
        article_no : this.pk_article,
        isclick : this.likeBtn == false ? "off" : "on",
        like_cnt : this.like_cnt
      };
      await this.$store.dispatch("likes/clickBtn", btnInfo);
    }, 
    async clickBmarkBtn() {
      if(localStorage.getItem("user_name") === null) {
        alert("로그인이 필요한 기능입니다.")
        return;
      }
       const btnInfo = {
        isLike : false,
        article_no : this.pk_article,
        isclick : this.bmarkBtn == false ? "off" : "on",
        bookmark_cnt : this.bookmark_cnt
      };
      await this.$store.dispatch("likes/clickBtn", btnInfo);
    } 
  }
};
</script>

<style scoped>
.img-height {
  height: 30rem;
}
</style>
