<template>
<<<<<<< Updated upstream
  <div class="flex flex-row place-content-center">
    <section class="flex-1">
      <article class="p-20 mt-24">
        <span class="block align-middle text-xl text-7xl font-bold mb-4"
          >Search Your</span
        >
        <span class="block align-middle text-xl text-7xl font-bold mb-16"
          >Cocktail Taste.</span
        >
=======
<<<<<<< Updated upstream
<div>
  <p>Search Your</p>
  <p>Cocktail Taste.</p>
</div>
=======
  <div class="flex flex-row place-content-center">
    <section class="flex-1">
      <article class="pl-20 mt-32">
        <div class="flex flex-col tracking-wide font-Abril-Fatface font-color-black-400 block align-middle text-7xl font-normal mb-16">
        <span class="mb-4">Search Your</span>
        <span>Cocktail Taste.</span>
        </div>
>>>>>>> Stashed changes
        <section class="flex items-center">
          <div class="inline-block relative w-max">
            <select
              class="block appearance-none w-full text-lg bg-white hover:bg-gray-100 px-10 py-4 rounded-full shadow-lg leading-tight border-4 border-transparent focus:outline-none focus:shadow-outline"
            >
              <option>통합</option>
              <option>오피셜</option>
              <option>커스텀</option>
            </select>
            <div
              class="pointer-events-none absolute inset-y-0 right-0 flex items-center px-2 text-gray-700"
            >
              <svg
                class="fill-current h-4 w-4"
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 20 20"
              >
                <path
                  d="M9.293 12.95l.707.707L15.657 8l-1.414-1.414L10 10.828 5.757 6.586 4.343 8z"
                />
              </svg>
            </div>
          </div>
          <div class="ml-4 flex-auto inline-block">
            <input
              class="text-lg text-left shadow-lg appearance-none rounded-full w-full px-10 py-4 leading-tight border-4 border-transparent hover:bg-gray-100 focus:outline-none focus:shadow-outline focus:border-gray-200"
              id="search"
              type="text"
              placeholder="검색"
            />
          </div>
<<<<<<< Updated upstream
            <div class="w-10 h-10 ml-4">
              <svg
                xmlns="http://www.w3.org/2000/svg"
                fill="none"
                viewBox="0 0 24 24"
                stroke="currentColor"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  stroke-width="2"
                  d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"
                />
              </svg>
            </div>
=======
          <div class="w-10 h-10 ml-4">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              fill="none"
              viewBox="0 0 24 24"
              stroke="currentColor"
            >
              <path
                stroke-linecap="round"
                stroke-linejoin="round"
                stroke-width="2"
                d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"
              />
            </svg>
          </div>
>>>>>>> Stashed changes
        </section>
      </article>
    </section>
    <section class="flex-1">
      <article class="flex">
        <base-card size="box-290" class="flex flex-col justify-items-center">
          <span class="text-3xl font-bold text-center py-4">오늘의 칵테일</span>
          <section
            class="flex flex-col justify-items-center transition duration-200 ease-in-out transform hover:scale-105"
          >
            <img
              class="object-cover w-56 m-auto"
              src="../assets/img/tequila-sunrise.png"
              alt="Sunset in the mountains"
            />
            <div class="font-bold text-xl mb-2 px-6 pt-4">테킬라 선라이즈</div>
          </section>

          <p class="text-gray-700 text-left px-4 mb-4 text-base">
            일출과 같이 무언가로부터 희망을 찾고 싶을 때, 활력을 얻고 싶을 때
            한잔 만들어보는 것은 어떨까?
          </p>
          <!-- <div class="px-6 pt-4 pb-2">
            <span
              class="inline-block bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2 mb-2"
              >#photography</span
            >
            <span
              class="inline-block bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2 mb-2"
              >#travel</span
            >
            <span
              class="inline-block bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2 mb-2"
              >#winter</span
            >
          </div> -->
        </base-card>
        <base-card size="box-290" class="flex flex-col justify-items-center">
          <span class="text-3xl font-bold text-center py-4">금주의 랭킹</span>
          <section
            class="transition duration-200 ease-in-out transform hover:scale-105 hover:shadow-lg"
          >
            <div class="flex items-center mt-4">
              <span class="text-2xl font-extrabold mx-4">1</span>
              <img
                src="../assets/img/mr.fox.jpg"
                class="w-12 h-12 object-cover rounded-full ml-4 mr-2"
              />
              <span class="font-medium ml-2 text-lg">미스터 여우씨</span>
            </div>
          </section>
          <section
            class="transition duration-200 ease-in-out transform hover:scale-105 hover:shadow-lg"
          >
            <div class="flex items-center mt-4">
              <span class="text-2xl font-extrabold mx-4">2</span>
              <img
                src="../assets/img/profile2.png"
                class="w-12 h-12 object-cover rounded-full ml-4 mr-2"
              />
              <span class="font-medium ml-2 text-lg">의문의 루피</span>
            </div>
          </section>
          <section
            class="transition duration-200 ease-in-out transform hover:scale-105 hover:shadow-lg"
          >
            <div class="flex items-center mt-4">
              <span class="text-2xl font-extrabold mx-4">3</span>
              <img
                src="../assets/img/profile3.jpg"
                class="w-12 h-12 object-cover rounded-full ml-4 mr-2"
              />
              <span class="font-medium ml-2 text-lg">베르나르 무민무민</span>
            </div>
          </section>
          <section
            class="transition duration-200 ease-in-out transform hover:scale-105 hover:shadow-lg"
          >
            <div class="flex items-center mt-4">
              <span class="text-2xl font-extrabold mx-4">4</span>
              <img
                src="../assets/img/profile4.jpeg"
                class="w-12 h-12 object-cover rounded-full ml-4 mr-2"
              />
              <span class="font-medium ml-2 text-lg">이시국 칵테일</span>
            </div>
          </section>
          <section
            class="transition duration-200 ease-in-out transform hover:scale-105 hover:shadow-lg"
          >
            <div class="flex items-center mt-4">
              <span class="text-2xl font-extrabold mx-4">5</span>
              <img
                src="../assets/img/profile5.jpg"
                class="w-12 h-12 object-cover rounded-full ml-4 mr-2"
              />
              <span class="font-medium ml-2 text-lg">개발 안맞아</span>
            </div>
          </section>
        </base-card>
      </article>
      <article>
        <base-card
          size="box-620"
          class="transition duration-200 ease-in-out transform hover:scale-105"
        >
          <section class="px-4 py-2">
            <div class="flex items-center mb-2">
              <span class="text-xl font-bold text-center"
                >[자유게시판] 소맥 황금비율 딱 알려드림</span
              >
              <img
                src="../assets/img/profile2.png"
                class="board-post ml-4 mr-2 object-cover rounded-full"
              />
              <span class="font-semibold mr-2">의문의 루피</span>
              <span class="text-sm text-gray-400">14:41</span>
            </div>
            <span class="block">소맥 황금비율 알려드립니다.</span>
          </section>
        </base-card>
        <base-card
          size="box-620"
          class="transition duration-200 ease-in-out transform hover:scale-105"
        >
          <section class="px-4 py-2">
            <div class="flex items-center mb-2">
              <span class="text-xl font-bold text-center"
                >[커스텀 레시피] 소주 모히또</span
              >
              <img
                src="../assets/img/mr.fox.jpg"
                class="board-post ml-4 mr-2 object-cover rounded-full"
              />
              <span class="font-semibold mr-2">미스터 여우씨</span>
              <span class="text-sm text-gray-400">14:30</span>
            </div>
            <span class="block"
              >죽기 전에 극락 가는 방법 알려드립니다. 이 비율로 타시면 무조건
              대박입니다... 널리 퍼트려주세요</span
            >
          </section>
        </base-card>
        <base-card
          size="box-620"
          class="transition duration-200 ease-in-out transform hover:scale-105"
        >
          <section class="px-4 py-2">
            <div class="flex items-center mb-2">
              <span class="text-xl font-bold text-center"
                >[자유게시판] 요새 핫한 칵테일바 추천</span
              >
              <img
                src="../assets/img/profile4.jpeg"
                class="board-post ml-4 mr-2 object-cover rounded-full"
              />
              <span class="font-semibold mr-2">이시국 칵테일</span>
              <span class="text-sm text-gray-400">14:29</span>
            </div>
            <span class="block"
              >안녕하세요 이시국 칵테일입니다. 오늘은 이시국에 갈만한 칵테일 바
              몇 개 추천드림니다. 우선 홍대쪽부터 알려드림.</span
            >
          </section>
        </base-card>
      </article>
    </section>
  </div>
<<<<<<< Updated upstream
=======
>>>>>>> Stashed changes
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======
<<<<<<< Updated upstream
p {
    margin: 0;
  font-family: Noto Sans KR;
  font-style: normal;
  font-weight: bold;
  font-size: 64px;
  line-height: 93px;
  display: flex;
  align-items: center;
=======
>>>>>>> Stashed changes
html,
body,
section {
  height: 100%;
<<<<<<< Updated upstream
=======
  /* font-family: 'NIXGONM-Vb'; */
  /* font-family: "S-CoreDream-4Regular"; */
  font-family: 'S-CoreDream-3Light';
>>>>>>> Stashed changes
}

.box-290 {
  width: 340px;
  /* height: 430px; */
  background-color: white;
  border-radius: 30px;
  text-align: center;
}

.box-620 {
  width: 720px;
}
<<<<<<< Updated upstream
=======
>>>>>>> Stashed changes
>>>>>>> Stashed changes

.board-post {
  width: 25px;
  height: 25px;
}
</style>
