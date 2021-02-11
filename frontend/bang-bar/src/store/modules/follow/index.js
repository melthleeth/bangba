import mutations from "./mutations.js";
import actions from "./actions.js";
import getters from "./getters.js";

export default {
    state() {
        return {
            isFollow : false,
            followCnt : 0,
            followingCnt : 0
        };
    },
    mutations,
    actions,
    getters,
}