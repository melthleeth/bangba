<template>
  <section class="container">
    <div class="col">
      <article>
        <p>Search Your</p>
        <p>Cocktail Taste.</p>
        <p>검색창</p>
      </article>
    </div>
    <div class="col">
      <article class="container">
        <base-card size="box-290">
          <p>오늘의 칵테일</p>
        </base-card>
        <base-card size="box-290">
          <p>랭킹</p>
        </base-card>
      </article>
      <article>
        <base-card size="box-620">
          <span>[자유게시판] 소주로 모히또 만들기</span>
          <img src="../assets/img/mr.fox.jpg" class="board-post"  />
          <span>미스터 여우씨</span>
          <span>1시간 전</span>
          <span>죽기 전에 극락 가는 방법 알려드립니다.. 무슨 무슨 비율로 무슨무슨 방법으로 하면 어떤맛이 어쩌구해서 대박입니다... 널리 퍼트려주세요</span>
        </base-card>
      </article>
    </div>
  </section>
</template>

<script>
export default {
  data() {
    return {

    };
  }
}
</script>

<style scoped>
html,
body,
section {
  height: 100%;
}

body {
  color: #fff;
  font-family: sans-serif;
  font-size: 1.25rem;
  line-height: 150%;
  text-align: center;
  text-shadow: 0 2px 2px #b6701e;
}

div {
  display: flex;
  flex-direction: column;
  justify-content: baseline;
}

/* Pattern styles */
.container {
  display: flex;
}

.col {
  background-color: #dddddd;
  flex: 1;
  padding: 1rem;
  margin: 1rem;
}

.box-290 {
  width: 290px;
  height: 430px;
  background-color: white;
  border-radius: 30px;
  text-align: center;
}

.box-620 {
  width: 620px;
}

.board-post {
  width: 20px;
  height: 20px;
}

p {
  margin: 0;
  font-family: Noto Sans KR;
  font-style: normal;
  font-weight: bold;
  font-size: 64px;
  line-height: 93px;
  align-items: center;

  color: #23232f;
}
</style>
