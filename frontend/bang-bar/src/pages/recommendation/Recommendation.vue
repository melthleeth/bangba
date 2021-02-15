<template>
  <div class="font-color-black-400 font-S-CoreDream-light flex flex-col justify-items-center">
    <section class="mt-32 mb-24 flex flex-col tracking-widest leading-relaxed text-xl mx-auto">
      <span>당신의 칵테일을 완성하세요</span>
      <span>Build Your Cocktail Taste</span>
    </section>
    <section class="flex flex-col justify-items-center tracking-wider mx-auto mb-12">
      <span class="font-S-CoreDream-medium font-semibold text-xl mx-auto mb-8">레시피</span>
      <article class="flex mx-auto">
        <label class="flex flex-col justify-items-center">
          <input
            type="radio"
            name="radio"
            value="보드카"
            checked
            v-model="baseType"
            @change="checkBaseAlcohol(baseType)"
          />
          <div class="w-24 h-24 rounded-full"></div>
          <span class="mt-2 mx-auto">보드카</span>
        </label>
        <label class="flex flex-col justify-items-center">
          <input
            type="radio"
            name="radio"
            value="진"
            v-model="baseType"
            @change="checkBaseAlcohol(baseType)"
          />
          <div class="w-24 h-24 rounded-full"></div>
          <span class="mt-2 mx-auto">진</span>
        </label>
        <label class="flex flex-col justify-items-center">
          <input
            type="radio"
            name="radio"
            value="데킬라"
            v-model="baseType"
            @change="checkBaseAlcohol(baseType)"
          />
          <div class="w-24 h-24 rounded-full"></div>
          <span class="mt-2 mx-auto">데킬라</span>
        </label>
        <label class="flex flex-col justify-items-center">
          <input
            type="radio"
            name="radio"
            value="럼"
            v-model="baseType"
            @change="checkBaseAlcohol(baseType)"
          />
          <div class="w-24 h-24 rounded-full"></div>
          <span class="mt-2 mx-auto">럼</span>
        </label>
        <label class="flex flex-col justify-items-center">
          <input
            type="radio"
            name="radio"
            value="리큐르"
            v-model="baseType"
            @change="checkBaseAlcohol(baseType)"
          />
          <div class="w-24 h-24 rounded-full"></div>
          <span class="mt-2 mx-auto">리큐르</span>
        </label>
        <label class="flex flex-col justify-items-center">
          <input
            type="radio"
            name="radio"
            value="브랜디"
            v-model="baseType"
            @change="checkBaseAlcohol(baseType)"
          />
          <div class="w-24 h-24 rounded-full"></div>
          <span class="mt-2 mx-auto">브랜디</span>
        </label>
      </article>
      <base-card class="w-1/2 card-margin flex">
        <span class="mx-4 my-2">{{ baseAlcoholes[baseIdx].content }}</span>
      </base-card>
    </section>
  </div>
</template>
<script>
export default {
  data() {
    return {
      baseIdx: 3,
      baseType: '보드카',
    };
  },
  computed: {
    baseAlcoholes() {
      return this.$store.getters['recommendationes/baseType'];
    },
  },
  created() {
    this.loadBaseAlcoholes();
  },
  methods: {
    async loadBaseAlcoholes() {
      await this.$store.dispatch('recommendationes/loadBaseAlcohol');
    },
    checkBaseAlcohol(type) {
      if (type === '데킬라') {
        this.baseIdx = 0;
      } else if (type === '진') {
        this.baseIdx = 1;
      } else if (type === '럼') {
        this.baseIdx = 2;
      } else if (type === '보드카') {
        this.baseIdx = 3;
      } else if (type === '브랜디') {
        this.baseIdx = 4;
      } else if (type === '리큐르') {
        this.baseIdx = 5;
      }
    },
  },
};
</script>

<style scoped>
.card-margin {
  margin: 2rem auto;
}
/* HIDE RADIO */
[type='radio'] {
  position: absolute;
  opacity: 0;
  width: 0;
  height: 0;
}

/* default STYLES */
[type='radio'] + div {
  cursor: pointer;
  background: #c4c4c4;
}

/* CHECKED STYLES */
[type='radio']:checked + div {
  background: #56e6a5;
}
</style>
