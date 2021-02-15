<template>
  <div class="flex flex-col font-S-CoreDream-light font-color-black-400">
    <section class="tabs flex justify-around mr-10">
      <a
        v-on:click="activetab = 1"
        :class="[
          activetab === 1 ? 'active' : '',
          'tracking-wider font-semibold text-2xl font-S-CoreDream-medium w-max px-1 mt-10 mb-8',
        ]"
        >레시피</a
      >
      <a
        v-on:click="activetab = 2"
        :class="[
          activetab === 2 ? 'active' : '',
          'tracking-wider font-semibold text-2xl font-S-CoreDream-medium w-max px-1 mt-10 mb-8',
        ]"
        >게시판</a
      >
    </section>

    <section class="mr-10">
      <transition-group tag="ul" name="tab" mode="out-in">
        <div v-if="activetab === 1" class="tabcontent">
          <section class="flex flex-col">
            <div v-if="isLoading" class="my-32">
              <base-spinner></base-spinner>
            </div>
            <div
              v-else-if="recipes.length > 0"
              class=" grid grid-cols-3 grid-flow-row gap-4 mx-auto"
            >
              <recipe-card
                v-for="cocktail in recipes"
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
              >아직 작성한 레시피가 없습니다.</span
            >
          </section>
        </div>
        <div v-if="activetab === 2" class="tabcontent">
          <section class="flex flex-col">
            <div v-if="isLoading" class="my-32">
              <base-spinner></base-spinner>
            </div>
            <div v-else-if="recipes.length > 0" class=" grid grid-cols-3 grid-flow-row gap-4 mx-4">
              <board-card
                v-for="post in posts"
                :key="post.pk_forum"
                :pk_forum="post.pk_forum"
                :created_at="post.created_at"
                :category="post.category"
                :title="post.title"
                :content="post.content"
              >
              </board-card>
            </div>
            <span
              v-else
              class="text-2xl text-center my-32 font-S-CoreDream-medium font-bold font-color-black-200"
              >아직 작성한 게시글이 없습니다.</span
            >
          </section>
        </div>
      </transition-group>
    </section>
  </div>
</template>

<script>
import RecipeCard from '../../components/recipes/RecipeCard.vue';
import BoardCard from '../../components/boards/BoardCard.vue';
export default {
  components: {
    RecipeCard,
    BoardCard,
  },
  data() {
    return {
      isLoading: false,
      error: null,
      activetab: 1,
      // posts: [
      //   {
      //     pk_forum: 77,
      //     created_at: "2021.02.10",
      //     category: "후기",
      //     title: "헌법",
      //     content: "국가는 지역간의 균형있는 발전을 위하여 지역경제를 육성할 의무를 진다. 대한민국의 경제질서는 개인과 기업의 경제상의 자유와 창의를 존중함을 기본으로 한다. 법률이 헌법에 위반되는 여부가 재판의 전제가 된 경우에는 법원은 헌법재판소에 제청하여 그 심판에 의하여 재판한다. 위원은 정당에 가입하거나 정치에 관여할 수 없다.",
      //   },
      //   {
      //     pk_forum: 39,
      //     created_at: "2021.02.05",
      //     category: "후기",
      //     title: "여러분 행복하세요",
      //     content: "ㅎㅎ",
      //   },
      //   {
      //     pk_forum: 34,
      //     created_at: "2021.02.05",
      //     category: "후기",
      //     title: "되나?",
      //     content: "ㅂㅈㄷ",
      //   },
      //   {
      //     pk_forum: 31,
      //     created_at: "2021.02.05",
      //     category: "후기",
      //     title: "서버불안정",
      //     content: "ㅎㅎ",
      //   },
      //   {
      //     pk_forum: 29,
      //     created_at: "2021.02.05",
      //     category: "후기",
      //     title: "왜됨",
      //     content: "qwe",
      //   },
      // ],
    };
  },
  created() {
    this.loadMyRecipes();
    this.loadMyForums();
  },
  computed: {
    recipes() {
      return this.$store.getters['users/myRecipe'];
    },
    posts() {
      return this.$store.getters['users/myForum'];
    },
  },
  methods: {
    async loadMyRecipes() {
      await this.$store.dispatch('users/LoadMyRecipe');
    },
    async loadMyForums() {
      await this.$store.dispatch('users/LoadMyForum');
    },
  },
};
</script>

<style scoped>
.tabs {
  /* overflow: hidden;
  margin-left: 20px;
  margin-bottom: -2px; */
}

.tabs a {
  cursor: pointer;
  transition: 0.3s;
  color: #9a9a9a;
  border-bottom: 4px solid transparent;
  /* display: flex;
  width: 100%;
  padding: 12px 24px;
  border: 1px solid #ccc;
  border-right: none;
  background-color: #f1f1f1;
  border-radius: 10px 10px 0 0;
  font-weight: bold; */
}
.tabs a:last-child {
  /* border-right: 1px solid #ccc; */
}

/* Change background color of tabs on hover */

.tabs a:hover {
  /* background-color: #aaa;
  color: #fff; */
  color: #23232f;
  border-bottom: 4px solid #23232f;
}

/* Styling for active tab */
.tabs a.active {
  /* background-color: #fff; */
  color: #23232f;
  border-bottom: 4px solid #23232f;
  cursor: default;
}

/* Style the tab content */
.tabcontent {
  /* padding: 30px; */
  /* border: 1px solid #ccc;
  border-radius: 10px;
  box-shadow: 3px 3px 6px #e1e1e1; */
}

.tab-enter-from {
  opacity: 0;
  transform: translateX(20%);
}

.tab-leave-to {
  opacity: 0;
  transform: translateX(-20%);
}

.tab-enter-active {
  transition: all 1s ease-out;
}

.tab-leave-active {
  transition: all 1s ease-in;
  display: none;
}

.tab-enter-to,
.tab-leave-from {
  opacity: 1;
  transform: translateX(0);
}
</style>
