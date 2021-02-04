export default {
    userId(state) {
      return state.userId;
    },
    token(state) {
      return state.token;
    },
    isAuthenticated(state) {
      return !!state.token;
    },
    didAutoLogout(state) {
      return state.didAutoLogout;
    },
    userName(state) {
      return state.user_name;
    }, 
    pkUser(state) {
      return state.pk_user;
    },
    userEmail(state) {
      return state.email;
    }
  };