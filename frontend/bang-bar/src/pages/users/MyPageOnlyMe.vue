<template>
  <div style="flex flex-row">
    <div class="flex grid grid-cols-3 grid-flow-row gap-12">
      <section class="col-span-1">
        <side-menu></side-menu>
      </section>

      <section class="mx-10 mt-10 col-span-2">
        <router-view></router-view>
      </section>
    </div>
  </div>
</template>

<script>
import SideMenu from '../../components/ui/SideMenu.vue';

export default {
  components: {
    SideMenu,
  },
};
</script>

<style scoped></style>
