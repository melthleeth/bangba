<template>
<<<<<<< Updated upstream
  <footer>
    <div class="container">
        <router-link to="/">
      <section class="logo">
          <img src="../../assets/img/logo.png" />
          <span>방구석 바텐더</span>
      </section>
<<<<<<< Updated upstream
        </router-link>
=======
=======
  <footer class="my-10">
    <div class="flex flex-col justify-items-center">
>>>>>>> Stashed changes
>>>>>>> Stashed changes
      <section>
      <router-link to="/">
        <article class="logo flex flex-col justify-items-center w-max">
          <img src="../../assets/img/logo.png" alt="logo-image" />
          <span
            class="text-xl text-center font-color-black-400 font-Mapo-DPPA mt-2"
            >방구석 바텐더</span
          >
        </article>
      </router-link>
      </section>
      <section class="">
        <nav class="font-color-black-400 text-lg">
          <ul>
            <li><router-link to="/footer/guide">방바 가이드</router-link></li>
            <li><router-link to="/footer/people">방바 사람들</router-link></li>
            <li><router-link to="/footer/ask">문의</router-link></li>
          </ul>
        </nav>
      </section>
      <section class="my-6">
        <span class="font-S-CoreDream-light"
          >2021 ⓒ 방구석 바텐더 All rights reserved</span
        >
      </section>
    </div>
  </footer>
</template>

<script>
export default {};
</script>

<style scoped>
* {
  text-align: center;
}

nav {
  font-family: "S-CoreDream-5Medium";
}

section {
  align-items: center;
}

img {
  margin: auto;
}

.logo {
<<<<<<< Updated upstream
    font-size: 15pt;
    border-radius: 50%;
    margin: 1rem;
    padding: 0.5rem;
<<<<<<< Updated upstream
    display: flex;
    transition: .3s ease-out;
=======
=======
  font-size: 15pt;
  border-radius: 50%;
  margin: 1rem;
  padding: 0.5rem;
  transition: 0.3s ease-out;
>>>>>>> Stashed changes
>>>>>>> Stashed changes
}

.logo p {
  margin: 0;
}

.logo:hover {
  /* border-bottom: 3px solid #FF5E46; */
  background: #ff5e46;
}

nav {
  width: 100%;
}

footer {
  width: 100%;
  height: auto;
}

footer a {
  text-decoration: none;
  color: #23232f;
  display: inline-block;
  padding: 0.25rem 1.5rem;
  border: 1px solid transparent;
  transition: 0.3s ease-out;
}

a:active,
a:hover,
a.router-link-active {
}

li a {
  border-radius: 50px;
}

li a:hover,
li a:active,
li a.router-link-active {
  color: white;
  background-color: #23232f;
  border-radius: 25px;
}

footer nav {
  width: 90%;
  margin: auto;
}

footer ul {
  list-style: none;
  margin: 0;
  padding: 0;
  display: flex;
  justify-content: center;
  align-items: center;
}

li {
  margin: 0 0.5rem;
  /* width: 140px; */
}
</style>
