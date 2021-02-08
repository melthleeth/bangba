import { createStore } from 'vuex';

import authModule from './modules/auth/index.js';
import recipeModule from './modules/recipes/index.js';
import boardModule from './modules/board/index.js';

// import acountModule from './modules/account/index.js';
import createPersistedState from "vuex-persistedstate";
import boardModule from './modules/board/index.js';

const store = createStore ({
    modules: {
        auth: authModule,
        recipes: recipeModule,
        boards: boardModule,
<<<<<<< HEAD
        // account: acountModule,
=======
>>>>>>> origin/backend
    },
    plugins: [createPersistedState()],
});

export default store;