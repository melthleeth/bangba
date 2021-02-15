<template>
  <div
    class="font-color-black-400 font-S-CoreDream-light flex flex-col justify-items-center"
  >
    <section
      class="mt-32 mb-24 flex flex-col tracking-widest leading-relaxed text-xl mx-auto"
    >
      <span>당신의 칵테일을 완성하세요</span>
      <span>Build Your Cocktail Taste</span>
    </section>
    <section class="flex flex-col justify-items-center tracking-wider mx-auto mb-12">
      <span class="font-S-CoreDream-medium font-semibold text-xl mx-auto mb-8">레시피</span>
      <article class="flex mx-auto">
      <label class="flex flex-col justify-items-center">
        <input type="radio" name="radio" value="보드카" checked>
        <div class="w-24 h-24 rounded-full"></div>
        <span class="mt-2 mx-auto">보드카</span>
      </label>
      <label class="flex flex-col justify-items-center">
        <input type="radio" name="radio" value="진">
        <div class="w-24 h-24 rounded-full"></div>
        <span class="mt-2 mx-auto">진</span>
      </label>
      <label class="flex flex-col justify-items-center">
        <input type="radio" name="radio" value="테킬라">
        <div class="w-24 h-24 rounded-full"></div>
        <span class="mt-2 mx-auto">테킬라</span>
      </label>
      <label class="flex flex-col justify-items-center">
        <input type="radio" name="radio" value="럼">
        <div class="w-24 h-24 rounded-full"></div>
        <span class="mt-2 mx-auto">럼</span>
      </label>
      <label class="flex flex-col justify-items-center">
        <input type="radio" name="radio" value="위스키">
        <div class="w-24 h-24 rounded-full"></div>
        <span class="mt-2 mx-auto">위스키</span>
      </label>
      </article>
      <base-card class="w-1/2 card-margin flex">
        <span class="mx-4 my-2">진은 향나무 열매에서 우세한 맛을 내는 증류주이다. 진은 유럽 전역의 승려와 연금술사, 특히 남프랑스, 플랑드르, 네덜란드에서 포도와 곡물의 증류로부터 아쿠아비타를 공급하기 위해 만든 약주로 유래되었다.</span>
      </base-card>
    </section>
  </div>
</template>
<script>
export default {};
</script>

<style scoped>
.card-margin {
    margin: 2rem auto;
}
/* HIDE RADIO */
[type=radio] { 
  position: absolute;
  opacity: 0;
  width: 0;
  height: 0;
}

/* default STYLES */
[type=radio] + div {
  cursor: pointer;
  background: #C4C4C4;
}

/* CHECKED STYLES */
[type=radio]:checked + div {
  background: #56E6A5;
}
</style>
