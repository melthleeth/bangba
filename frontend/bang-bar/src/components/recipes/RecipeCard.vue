<template>
  <div
<<<<<<< Updated upstream
    class="flex flex-col justify-center card-corner max-w-sm rounded overflow-hidden bg-white m-4 shadow-lg pb-2 transition duration-200 ease-in-out transform hover:scale-105"
=======
    class="font-S-CoreDream-light flex flex-col justify-center card-corner max-w-sm rounded overflow-hidden bg-white m-4 shadow-lg pb-2 transition duration-200 ease-in-out transform hover:scale-105"
>>>>>>> Stashed changes
  >
    <img
      class="w-full h-64 object-cover"
      src="../../assets/img/tequila-sunrise.png"
      alt="Sunset in the mountains"
    />

    <span class="font-bold text-xl mt-4 mb-6 text-center">{{
      cocktailname
    }}</span>

    <span
      class="w-max inline-block bg-red-200 rounded-full px-3 py-1 text-sm font-semibold ml-2 mb-2"
      >#{{ tag }}</span
    >
    <section class="flex items-center mt-4">
      <img
        src="../../assets/img/mr.fox.jpg"
<<<<<<< Updated upstream
        class="w-12 h-12 rounded-full ml-4 mr-2"
=======
        class="w-10 h-10 rounded-full ml-4 mr-2"
>>>>>>> Stashed changes
      />
      <span class="ml-2 text-base font-semibold">{{ username }}</span>
      <section class="flex justify-center justify-self-end ml-auto mr-4">
        <article class="flex items-center">
          <img
            src="../../assets/icon/like.png"
<<<<<<< Updated upstream
            class="w-8 h-8 object-contain ml-4 mr-2"
          />
          <span class="font-sm font-medium">
=======
            class="w-6 h-6 object-contain ml-4 mr-2"
          />
          <span class="font-xs font-medium">
>>>>>>> Stashed changes
            {{ like }}
          </span>
        </article>
        <article class="flex items-center">
          <img
            src="../../assets/icon/bookmarked.png"
<<<<<<< Updated upstream
            class="w-6 h-6 object-contain ml-4 mr-2"
          />
          <span class="font-sm font-medium">
=======
            class="w-4 h-4 object-contain ml-4 mr-2"
          />
          <span class="font-xs font-medium">
>>>>>>> Stashed changes
            {{ bookmarked }}
          </span>
        </article>
      </section>
    </section>
  </div>
</template>

<script>
export default {
<<<<<<< Updated upstream
  props: ["id", "cocktailname", "tag", "username", "like", "bookmared"],
=======
  props: ["id", "cocktailname", "tag", "username", "like", "bookmarked"],
>>>>>>> Stashed changes
};
</script>
