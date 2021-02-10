export default {
    setUser(state, payload) {
      state.user_name = payload.user_name;
      state.user_email = payload.email;
      state.pk_user = payload.pk_user;
    }
  };