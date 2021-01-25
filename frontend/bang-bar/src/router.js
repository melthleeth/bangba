import { createRouter, createWebHistory } from 'vue-router';

import Home from './pages/Home.vue';
import BangbaGuide from "./pages/footers/BangbaGuide.vue";
import BangbaPeople from "./pages/footers/BangbaPeople.vue";
import BangbaAsk from "./pages/footers/BangbaAsk.vue";

const router = createRouter({
    history: createWebHistory(),
    routes: [
        { path: '/', redirect: '/home' },
        { path: '/home', component: Home },
        {path:'/footer/guide', component: BangbaGuide },
        {path:'/footer/people', component: BangbaPeople },
        {path:'/footer/ask', component: BangbaAsk },
    ]
});

export default router;