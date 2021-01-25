<template>
  <div class="container">
    <section>
      <p>당신의 칵테일을 찾아보세요</p>
    </section>
    <section>
      <base-button mode="outline"
        >내 취향대로 칵테일 추천받으러 가기</base-button
      >
    </section>
  </div>
</template>

<style scoped>
div {
  display: flex;
  flex-direction: column;
  margin: 70px auto;
  width: 1060px;
  height: 465px;
  justify-content: center;
  align-items: center;
  background: linear-gradient(
    100.06deg,
    #9943e2 -5.4%,
    #ff4266 30.23%,
    #ff5e46 50.89%,
    #ffbd31 71.1%,
    rgba(255, 189, 49, 0.45) 88.14%
  );
  border-radius: 45px;
}

section {
  align-items: center;
}

p {
  margin: 1rem auto 4rem auto;
  font-family: Noto Sans KR;
  font-style: normal;
  font-weight: bold;
  font-size: 30px;
  line-height: 93px;
  display: flex;
  align-items: center;

  color: white;
}
</style>
