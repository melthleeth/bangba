import { createRouter, createWebHistory } from "vue-router";

import Home from "./pages/Home.vue";

// account
import SignUp from "./pages/account/SignUp.vue";
import FindPassword from "./pages/account/FindPassword.vue";

// users
import EditProfile from "./pages/users/EditProfile.vue";
import BookmarkedRecipe from "./pages/users/BookmarkedRecipe.vue";
import MyPosts from "./pages/users/MyPosts.vue";
import ActivityLog from "./pages/users/ActivityLog.vue";
import FollowingFollowers from "./pages/users/FollowingFollowers.vue";

// footer
import BangbaGuide from "./pages/footers/BangbaGuide.vue";
import BangbaPeople from "./pages/footers/BangbaPeople.vue";
import BangbaAsk from "./pages/footers/BangbaAsk.vue";

// board
import BoardList from "./pages/board/BoardList.vue";
import BoardCreate from "@/pages/board/BoardCreate";
import BoardDetail from "@/pages/board/BoardDetail";

// recipe
import SearchRecipe from "./pages/search/SearchRecipe.vue";
import OfficialRecipe from "./pages/recipe/OfficialRecipe.vue";
import CustomRecipe from "./pages/recipe/CustomRecipe.vue";
import RecipeRegistration from "./pages/recipe/RecipeRegistration.vue";
import RecipeDetail from "./pages/recipe/RecipeDetail.vue";

// recommendation
import RecommendationLanding from "./pages/recommendation/RecommendationLanding.vue";
import Recommendation from "./pages/recommendation/Recommendation.vue";
import RecommendationResult from "./pages/recommendation/RecommendationResult.vue";

const router = createRouter({
  history: createWebHistory(),
  routes: [
    // { path: , component: },
    { path: "/", redirect: "/home" },
    // login/join
    { path: "/home", component: Home },
    { path: "/signup", component: SignUp },
    { path: "/findpassword", component: FindPassword },
    // header
    { path: "/search", component: SearchRecipe },
    { path: "/recommendation", component: RecommendationLanding },
    { path: "/recommendation/form", component: Recommendation },
    { path: "/recommendation/result", component: RecommendationResult },

    { path: "/recipe/official", component: OfficialRecipe },
    { path: "/recipe/custom", component: CustomRecipe },
    { path: "/board", component: BoardList },
    // header-dropdown
    { path: "/header/editprofile", component: EditProfile },
    { path: "/header/bookmarkedrecipe", component: BookmarkedRecipe },
    { path: "/header/myposts", component: MyPosts },
    { path: "/header/activitylog", component: ActivityLog },
    { path: "/header/followingfollowers", component: FollowingFollowers },
    { path: "/board/list", component: BoardList },
    // footer
    { path: "/footer/guide", component: BangbaGuide },
    { path: "/footer/people", component: BangbaPeople },
    { path: "/footer/ask", component: BangbaAsk },
    //board
    {
      path: "/board/create/:contentId?",
      name: "BoardCreate",
      component: BoardCreate,
    },
    {
      path: "/board/detail/:contentId?",
      name: "BoardDetail",
      component: BoardDetail,
    },

    // recipe
    {
      path: "/recipe/register/:category",
      name: "RecipeRegistration",
      props: true,
      component: RecipeRegistration,
    },

    {
      path: "/recipe/detail/:pk_article",
      props: true,
      component: RecipeDetail,
    },
  ],
});

export default router;
