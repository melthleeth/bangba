// let timer;

export default {
  async login(context, payload) {
    return context.dispatch('auth', {
      ...payload,
      mode: "login",
      isAuth: false,
    });
  },
  async signup(context, payload) {
    return context.dispatch("auth", {
      ...payload,
      mode: "signup",
    });
  },
  async auth(context, payload) {
    const mode = payload.mode;

    let url = "http://localhost:8081/user/login";
    // 'https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyAsR0CZ32xrFNB63aj3exZKVkoHnGqM8dA';
    if (mode === "signup") {
      url =
        "https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=AIzaSyAsR0CZ32xrFNB63aj3exZKVkoHnGqM8dA";
    }
   
    const response = await fetch(url, {
      headers: {
        "Content-Type": "application/json; charset=utf-8",
        'Accept': '*/*',
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Headers': '*',
      },
      method: "POST",
      body: JSON.stringify({
        email: payload.email,
        password: payload.password,
        returnSecureToken: true
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
      console.log(responseData);
    }

    const expiresIn = +responseData.expiresIn * 1000;
    // const expiresIn = 5000;
    const expirationDate = new Date().getTime() + expiresIn;

    console.log(responseData.user_name);

    localStorage.setItem('token', responseData.idToken);
    localStorage.setItem('userId', responseData.userId);
    localStorage.setItem('user_name', responseData.user_name);
    localStorage.setItem('pk_user', responseData.pk_user);
    localStorage.setItem('email', responseData.email);
    localStorage.setItem('tokenExpiration', expirationDate);

    // timer = setTimeout(function() {
    //   context.dispatch('autoLogout');
    // }, expiresIn);

    context.commit('setUser', {
      token: responseData.idToken,
      userId: responseData.localId,
      user_name: responseData.user_name,
      pk_user: responseData.pk_user,
      email: responseData.email,
    });
  },
  // tryLogin(context) {
  //   const token = localStorage.getItem("token");
  //   const userId = localStorage.getItem("userId");
  //   const tokenExpiration = localStorage.getItem("tokenExpiration");
  //   const expiresIn = +tokenExpiration - new Date().getTime();

  //   if (expiresIn < 0) {
  //     return;
  //   }

  //   timer = setTimeout(function() {
  //     context.dispatch("autoLogout");
  //   }, expiresIn);

  //   if (token && userId) {
  //     context.commit("setUser", {
  //       token: token,
  //       userId: userId,
  //     });
  //   }
  // },
  // logout(context) {
  //   localStorage.removeItem("token");
  //   localStorage.removeItem("userId");
  //   localStorage.removeItem("tokenExpiration");

  //   clearTimeout(timer);

  //   context.commit("setUser", {
  //     token: null,
  //     userId: null,
  //   });
  // },
  // autoLogout(context) {
  //   context.dispatch("logout");
  //   context.commit("setAutoLogout");
  // },
};
