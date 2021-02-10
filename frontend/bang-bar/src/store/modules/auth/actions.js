const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
  async login(context, payload) {
    return context.dispatch('auth', {
      ...payload,
      mode: "login",
      isAuth: false,
    });
  },
  async auth(context, payload) {
    const response = await fetch(`${SERVER_URL}/user/login`, {
      headers: {
        "Content-Type": "application/json; charset=utf-8",
        'Accept': '*/*',
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Headers': '*',
      },
      method: "POST",
      body: JSON.stringify({
        email: payload.email,
        password: payload.password
      })
    });
    console.log(response);

    const responseData = await response.json();
    
    if (!response.ok) {
      const error = new Error(
        responseData.message || '로그인에 실패하였습니다.'
      );
      throw error;
    } else {
      console.log("success");
    }
    localStorage.setItem('user_name', responseData.user_name);
    localStorage.setItem('pk_user', responseData.pk_user);
    localStorage.setItem('email', responseData.email);

    context.commit('setUser', {
      user_name: responseData.user_name,
      pk_user: responseData.pk_user,
      email: responseData.email,
    });
  },
};
