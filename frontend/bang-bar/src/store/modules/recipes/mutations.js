export default {
    registerRecipe(state, payload) {
        state.recipes.push(payload);
    },
    setFetchTimestamp(state) {
        state.lastFetch = new Date().getTime();
    }
};