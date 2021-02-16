<template>
  <div style="font-color-black-400 font-S-CoreDream-light">
    <section class="w-1/2 my-20 mx-auto">
      <user-board></user-board>
    </section>
    <section class="w-2/3 mx-auto mt-10">
      <other-posts></other-posts>
    </section>
  </div>
</template>

<script>
import UserBoard from '../../components/users/UserBoard.vue';
import OtherPosts from '../users/OtherPosts.vue';

export default {
  components: {
    UserBoard,
    OtherPosts,
  },
};
</script>

<style scoped></style>
