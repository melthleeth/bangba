import mutations from "./mutations.js";
import actions from "./actions.js";
import getters from "./getters.js";

export default {
    state() {
        return {
            isLike: false,
            isclick: "off", 
            user_no:"",
            article_no:"",
        }
    },
    mutations,
    actions,
    getters,
}