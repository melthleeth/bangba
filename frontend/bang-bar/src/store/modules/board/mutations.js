export default {
    registerBoard(state, payload) {
        console.log("mutations");
        console.log(payload);
        state.boards.push(payload);
    },  

    setBoards(state, payload) {
        state.boards = payload;
    },
    
    setFetchTimestamp(state) {
        state.lastFetch = new Date().getTime();
    }
};