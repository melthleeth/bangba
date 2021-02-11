import { createStore } from 'vuex';

import authModule from './modules/auth/index.js';
import recipeModule from './modules/recipes/index.js';
import boardModule from './modules/board/index.js';
import likeModule from './modules/like/index.js';

// import acountModule from './modules/account/index.js';
import createPersistedState from "vuex-persistedstate";

const store = createStore ({
    modules: {
        auth: authModule,
        recipes: recipeModule,
        boards: boardModule,
        likes : likeModule,
    },
    plugins: [createPersistedState()],
});

export default store;