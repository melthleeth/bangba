export default {
    setIsClick(state, payload) {
        state.isclick = payload;
    },
    setClickInfo(staet, payload) {
        state.isclick = payload.isclick;
        state.user_no = payload.user_no;
        state.article_no = payload.article_no;
    }
}