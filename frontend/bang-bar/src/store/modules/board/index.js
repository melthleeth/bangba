import mutations from "./mutations.js";
import actions from "./actions.js";
import getters from "./getters.js";

export default {
  namespaced: true,
  state() {
    return {
        lastFetch: null,
      // dummy data
      boards: [],
<<<<<<< HEAD
      paginaged:[],

      //넘겨주기위한 데이터
      page_num: '',
      page_range: '',
      search_type: '',
      keyword: '',
      forum_cnt_per_page:'',
=======
>>>>>>> origin/backend
    };
  },
  mutations,
  actions,
  getters,
};
