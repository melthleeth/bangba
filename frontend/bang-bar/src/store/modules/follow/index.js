import mutations from "./mutations.js";
import actions from "./actions.js";
import getters from "./getters.js";

export default {
    state() {
        return {
            isFollow : false,
            followList : [],
            followingList : []
        };
    },
    mutations,
    actions,
    getters,
}