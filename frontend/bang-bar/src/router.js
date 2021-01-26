import { createRouter, createWebHistory } from "vue-router";

import Home from "./pages/Home.vue";

import SignUp from "./pages/account/SignUp.vue";
import FindPassword from "./pages/account/FindPassword.vue";

import SearchRecipe from "./pages/search/SearchRecipe.vue";
import RecommendationLanding from "./pages/recommendation/RecommendationLanding.vue";
import OfficialRecipe from "./pages/recipe/OfficialRecipe.vue";
import CustomRecipe from "./pages/recipe/CustomRecipe.vue";
import BoardList from "./pages/board/BoardList.vue";

import BangbaGuide from "./pages/footers/BangbaGuide.vue";
import BangbaPeople from "./pages/footers/BangbaPeople.vue";
import BangbaAsk from "./pages/footers/BangbaAsk.vue";

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
    { path: "/recipe/official", component: OfficialRecipe },
    { path: "/recipe/custom", component: CustomRecipe },
    { path: "/board", component: BoardList },
    // footer
    { path: "/footer/guide", component: BangbaGuide },
    { path: "/footer/people", component: BangbaPeople },
    { path: "/footer/ask", component: BangbaAsk },
  ],
});

export default router;
