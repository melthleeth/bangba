<template>
  <header>
    <nav>
      <div>
        <router-link to="/"
          ><img src="../../assets/img/logo.png" /> 방구석 바텐더
        </router-link>
      </div>
      <ul>
          <li><router-link to="">통합검색</router-link></li>
          <li><router-link to="">칵테일 추천</router-link></li>
          <li><router-link to="">오피셜 레시피</router-link></li>
          <li><router-link to="">커스텀 레시피</router-link></li>
          <li><router-link to="">게시판</router-link></li>
      </ul>
      <base-button mode="outline">회원가입</base-button>
      <base-button>로그인</base-button>
    </nav>
  </header>
</template>

<script>
export default {


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
  color: #23232F;
  display: inline-block;
  padding: 0.75rem 1.5rem;
  border: 1px solid transparent;
}

a:active,
a:hover,
a.router-link-active {
  /* border: 1px solid #ff5e46; */
}

h1 {
  margin: 0;
}

h1 a {
  color: white;
  margin: 0;
}

h1 a:hover,
h1 a:active,
h1 a.router-link-active {
  border-color: transparent;
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
</style>
