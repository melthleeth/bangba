<template>
  <div style="flex flex-row">
    <div class="flex grid grid-cols-3 grid-flow-row gap-4">
      <section class="col-span-1">
        <side-menu></side-menu>
      </section>

      <section class="mx-10 mt-10 col-span-2">
        <span class="border-gray-800 border-b-2">북마크한 레시피</span>
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

<style scoped>
.box-290 {
  width: 310px;
  /* height: 430px; */
  background-color: white;
  border-radius: 30px;
  text-align: center;
}
</style>
