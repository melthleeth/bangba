<template>
  <div style="font-color-black-400 font-S-CoreDream-light">
    <section class="w-1/2 my-20 mx-auto">
      <user-board></user-board>
    </section>
    <section class="mt-10">
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
