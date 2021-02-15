<template>
  <div style="flex flex-row font-color-black-400 font-S-CoreDream-light">
    <section class="mt-20 mx-auto">
      <user-board></user-board>
    </section>
    <section class="mt-10 mx-10 p-10">
      <my-posts></my-posts>
    </section>
  </div>
</template>

<script>
import UserBoard from '../../components/users/UserBoard.vue';
import MyPosts from '../users/MyPosts.vue';

export default {
  components: {
    UserBoard,
    MyPosts,
  },
};
</script>

<style scoped></style>
