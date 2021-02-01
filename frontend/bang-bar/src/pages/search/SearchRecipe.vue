<template>
  <div class="flex flex-col justify-items-center px-16">
    <span class="title text-center my-10 font-S-CoreDream-medium font-bold font-color-black-400">통합 검색</span>
    <section class="spacing">
      <section id="search-bar" class="flex items-center px-64 mb-12">
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
    </section>
    </section>
  </div>
</template>

<style scoped>
span {
  font-size: 64px;
  line-height: 93px;
  color: #23232f;
}

.spacing {
  height: 40vh;
}
</style>
