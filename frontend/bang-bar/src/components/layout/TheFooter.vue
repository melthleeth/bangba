<template>
  <footer>
    <div class="container">
      <section>
        <router-link to="/" class="logo"
          ><img src="../../assets/img/logo.png" />
          <p>방구석 바텐더</p>
        </router-link>
      </section>
      <section>
        <nav>
          <ul>
            <li><router-link to="/footer/guide">방바 가이드</router-link></li>
            <li><router-link to="/footer/people">방바 사람들</router-link></li>
            <li><router-link to="/footer/ask">문의</router-link></li>
          </ul>
        </nav>
      </section>
      <section>
        <p>2021 ⓒ 방구석 바텐더 All rights reserved</p>
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

section {
  align-items: center;
}

.logo {
    font-size: 15pt;
    border-radius: 50%;
    margin: 1rem;
    padding: 0.5rem;
}

.logo p {
    margin: 0;
}

.logo:hover {
    /* border-bottom: 3px solid #FF5E46; */
    background: #FF5E46;
}

nav {
  width: 100%;
}

footer {
  width: 100%;
  height: auto;
  display: flex;
  justify-content: center;
  align-items: center;
}

footer a {
  text-decoration: none;
  color: #23232f;
  display: inline-block;
  padding: 0.75rem 1.5rem;
  border: 1px solid transparent;
  transition: .3s ease-out;
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
  display: flex;
  justify-content: space-between;
  align-items: center;
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
  width: 140px;
}

</style>
