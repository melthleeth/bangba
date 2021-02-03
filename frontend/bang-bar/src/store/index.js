import { createStore } from 'vuex';

import authModule from './modules/auth/index.js';
import recipeModule from './modules/recipes/index.js';

const store = createStore ({
    modules: {
        auth: authModule,
        recipes: recipeModule,
    }
});

export default store;