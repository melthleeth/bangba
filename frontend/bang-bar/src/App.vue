<template>
  <the-header></the-header>
  <router-view></router-view>
  <the-footer></the-footer>
</template>

<script>
import TheHeader from "./components/layout/TheHeader.vue";
import TheFooter from "./components/layout/TheFooter.vue";

export default {
  components: {
    TheHeader,
    TheFooter,
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap");
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap');


* {
  box-sizing: border-box;
}

html {
  font-family: 'Noto Sans KR', sans-serif;
  color: #23232F;
  /* font-family: "Roboto", sans-serif; */
}

body {
  margin: 0;
  background-color: #FFF5EB;
}
</style>
