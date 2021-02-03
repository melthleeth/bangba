import { createStore } from 'vuex';

import authModule from './modules/auth/index.js';
import recipeModule from './modules/recipes/index.js';
import createPersistedState from "vuex-persistedstate";

const store = createStore ({
    modules: {
        auth: authModule,
        recipes: recipeModule,
    },
    plugins: [createPersistedState()],
});

export default store;