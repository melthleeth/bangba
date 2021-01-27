<template>
  <div class="flex flex-row place-content-center">
    <section class="flex-1">
      <article class="p-20 mt-24">
        <span class="block align-middle text-xl text-7xl font-bold mb-4"
          >Search Your</span
        >
        <span class="block align-middle text-xl text-7xl font-bold mb-16"
          >Cocktail Taste.</span
        >
        <base-card>
          <span class="block align-middle text-xl font-bold">검색창</span>
        </base-card>
      </article>
    </section>
    <section class="flex-1">
      <article class="flex">
        <base-card size="box-290">
          <span class="text-3xl font-bold text-center py-8">오늘의 칵테일</span>
        </base-card>
        <base-card size="box-290">
          <span class="text-3xl font-bold">랭킹</span>
        </base-card>
      </article>
      <article>
        <base-card size="box-620">
        <section class="px-4 py-2">
          <div class="flex items-center mb-2">
          <span class="text-xl font-bold text-center"
            >[자유게시판] 소주로 모히또 만들기</span
          >
          <img src="../assets/img/mr.fox.jpg" class="board-post ml-4 mr-2" />
          <span class="font-semibold mr-2">미스터 여우씨</span>
          <span class="text-sm text-gray-400">1시간 전</span>
          </div>
          <span class="block"
            >죽기 전에 극락 가는 방법 알려드립니다.. 무슨 무슨 비율로 무슨무슨
            방법으로 하면 어떤맛이 어쩌구해서 대박입니다... 널리
            퍼트려주세요</span
          >
          </section>
        </base-card>
        <base-card size="box-620">
        <section class="px-4 py-2">
          <div class="flex items-center mb-2">
          <span class="text-xl font-bold text-center"
            >[자유게시판] 소주로 모히또 만들기</span
          >
          <img src="../assets/img/mr.fox.jpg" class="board-post ml-4 mr-2" />
          <span class="font-semibold mr-2">미스터 여우씨</span>
          <span class="text-sm text-gray-400">1시간 전</span>
          </div>
          <span class="block"
            >죽기 전에 극락 가는 방법 알려드립니다.. 무슨 무슨 비율로 무슨무슨
            방법으로 하면 어떤맛이 어쩌구해서 대박입니다... 널리
            퍼트려주세요</span
          >
          </section>
        </base-card>
        <base-card size="box-620">
        <section class="px-4 py-2">
          <div class="flex items-center mb-2">
          <span class="text-xl font-bold text-center"
            >[자유게시판] 소주로 모히또 만들기</span
          >
          <img src="../assets/img/mr.fox.jpg" class="board-post ml-4 mr-2" />
          <span class="font-semibold mr-2">미스터 여우씨</span>
          <span class="text-sm text-gray-400">1시간 전</span>
          </div>
          <span class="block"
            >죽기 전에 극락 가는 방법 알려드립니다.. 무슨 무슨 비율로 무슨무슨
            방법으로 하면 어떤맛이 어쩌구해서 대박입니다... 널리
            퍼트려주세요</span
          >
          </section>
        </base-card>
      </article>
    </section>
  </div>
</template>

<script>
import BaseCard from "../components/ui/BaseCard.vue";
export default {
  components: { BaseCard },
  data() {
    return {};
  },
};
</script>

<style scoped>
html,
body,
section {
  height: 100%;
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
</style>
