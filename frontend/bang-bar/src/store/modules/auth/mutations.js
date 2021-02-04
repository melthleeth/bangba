export default {
    setUser(state, payload) {
      state.token = payload.token;
      state.userId = payload.userId;
      state.user_name = payload.user_name;
      state.user_email = payload.email;
      state.pk_user = payload.pk_user;
      state.didAutoLogout = false;
    },
    setAutoLogout(state) {
      state.didAutoLogout = true;
    }
  };