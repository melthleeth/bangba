<template>
  <header>
    <nav>
      <router-link to="/">
        <section class="logo">
          <img src="../../assets/img/logo.png" />
          <span>방구석 바텐더</span>
        </section>
      </router-link>
      <ul>
        <li><router-link to="/search">통합검색</router-link></li>
        <li><router-link to="/recommendation">칵테일 추천</router-link></li>
        <li><router-link to="/recipe/official">오피셜 레시피</router-link></li>
        <li><router-link to="/recipe/custom">커스텀 레시피</router-link></li>
        <li><router-link to="/board">게시판</router-link></li>
      </ul>
      <section v-if="!isAuth">
        <base-button link mode="outline" to="/signup">회원가입</base-button>
        <base-modal @close="hideDialog" :open="dialogIsVisible">
          <section class="modal-header">
            <img src="../../assets/img/logo.png" />
            <span>로그인</span>
          </section>
          <input class="input-modal" type="text" placeholder="이메일" />
          <input class="input-modal" type="password" placeholder="비밀번호" />
          <section class="button-modal">
            <base-button>로그인</base-button>
            <base-button @click="hideDialog" mode="outline">취소</base-button>
          </section>
          <section class="sub-menu">
            <router-link @click="hideDialog" to="/findpassword"
              ><u>비밀번호 찾기</u></router-link
            >
            <router-link @click="hideDialog" to="/signup"
              ><u>회원가입</u></router-link
            >
          </section>
        </base-modal>
        <base-button @click="login">로그인</base-button>
      </section>
      <section v-else>
        <base-button @click="logout">로그아웃</base-button>
      </section>
    </nav>
  </header>
</template>

<script>
import BaseButton from "../ui/BaseButton.vue";
export default {
  components: { BaseButton },
  data() {
    return {
      dialogIsVisible: false,
      isAuth: false,
    };
  },
  methods: {
    showDialog() {
      this.dialogIsVisible = true;
    },
    hideDialog() {
      this.dialogIsVisible = false;
    },
    login() {
      this.isAuth = true;
    },
    logout() {
      this.isAuth = false;
    }
  },
};
</script>

<style scoped>
header {
  width: 100%;
  height: 5rem;
  /* background-color: #3d008d; */
  display: flex;
  justify-content: center;
  align-items: center;
}

header a {
  text-decoration: none;
  color: #23232f;
  display: inline-block;
  padding: 0.75rem 1.5rem;
  border: 1px solid transparent;
}

a:active,
a:hover,
a.router-link-active {
  /* border: 1px solid #ff5e46; */
}

li {
  margin: 0;
}

li a {
  margin: 0;
  transition: 0.3s ease-out;
}

li a:hover,
li a:active,
li a.router-link-active {
  /* border-color: transparent; */
  border-bottom: 5px solid #ff5e46;
}

header nav {
  width: 90%;
  margin: auto;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

header ul {
  list-style: none;
  margin: 0;
  padding: 0;
  display: flex;
  justify-content: center;
  align-items: center;
}

li {
  margin: 0 0.5rem;
  font-size: 15pt;
}

.modal-header {
  margin: 2rem auto;
  display: flex;
  align-items: center;
  font-weight: 700;
  font-size: 18pt;
}

.input-modal {
  font-size: 12pt;
  text-align: left;
  padding: 1rem 2rem;
  width: 257px;
  border-radius: 25px;
  border: 3px solid white;
  background-color: white;
  margin: 0.5rem 0;
  transition: 0.3s ease-out;
}

.input-modal:hover,
.input-modal:active,
.input-modal:focus {
  border: 3px solid #dddddd;
}

.button-modal {
  margin-top: 1rem;
}

u {
  color: #9a9a9a;
  transition: 0.3s ease-out;
}

u:hover,
u:active {
  color: #23232f;
}

.logo {
  display: flex;
  align-items: center;
}
</style>
