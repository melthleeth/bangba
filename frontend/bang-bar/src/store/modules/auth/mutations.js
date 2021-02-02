export default {
    setUser(state, payload) {
      state.token = payload.token;
      state.userId = payload.userId;
      state.user_name = payload.user_name;
      state.didAutoLogout = false;
      console.log(state.user_name + " 123123131");
    },
    setAutoLogout(state) {
      state.didAutoLogout = true;
    }
  };