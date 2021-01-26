<template>
  <header>
    <nav>
      <router-link to="/">
        <section class="logo">
          <img src="../../assets/img/logo.png" />
          <span>방구석 바텐더</span>
        </section>
      </router-link>
      <ul class="ul-menu">
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
            <base-button @click="login">로그인</base-button>
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
        <base-button @click="showDialog">로그인</base-button>
      </section>
      <section v-else>
        <base-dropdown>
          <!-- <img src="../../assets/img/mr.fox.jpg" class="img-profile" @click="showDropdown" /> -->
          <template v-slot="context">
            <img
              @click="context.toggleOpen"
              class="h-12 w-12 cursor-pointer rounded-full border-2 border-gray-400 object-cover"
              src="../../assets/img/mr.fox.jpg"
              alt="profile image"
            />
            <transition
              enter-active-class="transition-all duration-100 ease-out"
              leave-active-class="transition-all duration-100 ease-in"
              enter-class="opacity-0 scale-75"
              enter-to-class="opacity-100 scale-100"
              leave-class="opacity-100 scale-100"
              leave-to-class="opacity-0 scale-75"
            >
              <div
                v-if="context.open"
                class="origin-top-right absolute -right-8 mt-14 w-min bg-white text-center border overflow-hidden rounded-3xl shadow-xl"
              >
                <ul>
                  <li>
                    <a
                      class="rounded-t-lg block px-4 py-3 hover:bg-gray-100"
                    >
                      <div class="font-semibold">{{ username }}</div>
                      <div class="text-gray-700">{{ email }}</div>
                    </a>
                  </li>
                  <li class="hover:bg-gray-100">
                    <a class="font-normal block px-4 py-3" to="/profile"
                      >프로필 수정</a
                    >
                  </li>
                  <li class="hover:bg-gray-100">
                    <a class="font-normal block px-4 py-3" to="/profile"
                      >북마크한 레시피</a
                    >
                  </li>
                  <li class="hover:bg-gray-100">
                    <a class="font-normal block px-4 py-3" to="/profile"
                      >내가 쓴 글</a
                    >
                  </li>
                  <li class="hover:bg-gray-100">
                    <a class="font-normal block px-4 py-3" to="/profile"
                      >활동기록</a
                    >
                  </li>
                  <li class="hover:bg-gray-100">
                    <a class="font-normal block px-4 py-3" to="/profile"
                      >팔로잉/팔로워</a
                    >
                  </li>
                    <hr>
                  <li class="hover:bg-gray-100">
                    <a class="font-font-normal block px-4 py-3" to="/profile"
                      >로그아웃</a
                    >
                  </li>
                </ul>
              </div>
            </transition>
          </template>
        </base-dropdown>
      </section>
    </nav>
  </header>
</template>

<script>
import BaseButton from "../ui/BaseButton.vue";
import BaseDropdown from "../ui/BaseDropdown.vue";
export default {
  components: { BaseButton, BaseDropdown },
  data() {
    return {
      username: "미스터 여우씨",
      email: "mrfox@bangbar.com",
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
    },
    showDropdown() {},
  },
};
</script>

<style scoped>
.img-profile {
  width: 50px;
  height: 50px;
  border-radius: 15px;
}

header {
  width: 100%;
  height: 100%;
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

.ul-menu li {
  margin: 0;
}

.ul-menu li a {
  margin: 0;
  transition: 0.3s ease-out;
}

.ul-menu li a:hover,
.ul-menu li a:active,
.ul-menu li a.router-link-active {
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

header .ul-menu {
  list-style: none;
  margin: 0;
  padding: 0;
  display: flex;
  justify-content: center;
  align-items: center;
}

.ul-menu li {
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
